package main

import "fmt"

// fibonacci is a function that returns
// a function that returns an int.
func fibonacci() func() int {
	//counter := 0
	var x, y = 0, 1
	return func() int {
	
	/*
	too complicated.
		if counter == 0 {
			counter++
			return 0
		} else if counter == 1 {
			counter++
			return 1
		} else {
			ret := x + y
			x = y
			y = ret
			return ret
		}
*/
	temp := x
	x, y = y, x+y
	return temp
	}
}

func main() {
	f := fibonacci()
	for i := 0; i < 10; i++ {
		fmt.Println(f())
	}
}
