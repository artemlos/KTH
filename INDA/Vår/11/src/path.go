// Based on code by Stefan Nilsson 2014-04-20
// The Graph package is made by Stefan Nilsson 2014-04-20
// Implementation of Path.go by Artem Los (artemlos.net) 2015.04.27

package main

import (
	"bufio"
	"fmt"
	"graph"
	"log"
	"os"
	"strconv"
	"strings"
)

const prog = "path"

func init() {
	log.SetFlags(0) // no extra info in log messages
}

func main() {
	if len(os.Args) < 2 {
		log.Fatalf("usage: %s FROM TO (FILE)\n", prog)
	}
	from := stringToInt(os.Args[1], -1)
	to := stringToInt(os.Args[2], -1)

	//optional, if the graph is stored in a different file.
	//by default, it should be stored in Distances.txt

	var filename string
	if len(os.Args) == 4 {
		filename = os.Args[3]
	} else {
		filename = "Distances.txt"
	}

	file, err := os.Open(filename)
	if err != nil {
		log.Fatalln(err)
	}
	defer file.Close()

	g, err := parser(file)

	getPathInfo(g, from, to)

	if err != nil {
		log.Fatalln(err)
	}
}

// Returns graph info
// The arguments dont make sense because I did not want to
// put another while/function to reverse the path (we are working backwards)
// Instead, you - the developer, should image "to" being "from" and vice versa.
func getPathInfo(g *graph.Matrix, to, from int) {

	state := make([]bool, g.NumVertices())
	rowpointer := make([]int, g.NumVertices())
	found := false

	if to < g.NumVertices() && from <= g.NumVertices() {

	
	// use row to store where each node came from.
	// then, we can while through and find the path.
	fmt.Println("Path from ", to, " to ", from)

	graph.BFS(g, from, state, func(w int) {

		if w == to {
			found = true
		}
	}, &rowpointer)
	} else {
		fmt.Println()
	}

	if found {
		
		//finished
		current := to
		count := 0
		for current != from {
			fmt.Print(current, "-")
			current = rowpointer[current]
			count++
		}
		fmt.Print(from)
		fmt.Println()
		fmt.Println("The path consists of ", count, " node(s)")
	}

}

func cost(g *graph.Matrix, from int, to int) int {
	i := (g.Label(from, to)).(int)
	return i
}

// Parsing the input to construct a directed.Graph
func parser(file *os.File) (*graph.Matrix, error) {
	scanner := bufio.NewScanner(file)
	g := new(graph.Matrix)
	count := 0
	exec := false // keeps track if the size of the array has been specified before we start adding items.
	for scanner.Scan() {
		line := scanner.Text()
		count++
		if !strings.HasPrefix(line, "//") {
			//fmt.Println(line);
			exp := strings.Split(line, " ") // split

			if exec == false {
				if exp[0] != "" {
					size := stringToInt(exp[0], count)
					g = graph.NewMatrix(size)
					exec = true
				}

			} else if len(exp) >= 3 && exec {
				from := stringToInt(exp[0], count)
				to := stringToInt(exp[1], count)
				weight := stringToInt(exp[2], count)
				//fmt.Println(from, ",", to, ",", weight)
				g.AddBiLabel(from, to, weight)
				//g.AddEdge(exp[0],exp[1])
			}
			/*else  {
				log.Print("Invalid line formatting on line ", count, ". The information on this line was ignored.")

			}*/
			//fmt.Println(exp[0])
			//
		}

	}

	return g, scanner.Err()

}

// Converts a string into an int. If an error is thrown, the application will terminate.
func stringToInt(input string, where int) int {
	num, err := strconv.Atoi(input)

	if err != nil {
		log.Fatalln("Unable to cast string to int. Occured on line ", where, " Error message:", err)
		os.Exit(2)
	}
	return num
}

// notes:
/*
 * 1. install using go get. remember to set GOPATH using export GOPATH=...
 * 2. package is like a namespace. need to use directed.Graph.
 * 4. Do not return a pointer. instead, use it as param.
 * 5. Keep in mind that go install has to be performed each time a package changes.
 */
