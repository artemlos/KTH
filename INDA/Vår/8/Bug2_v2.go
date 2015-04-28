package main

import "fmt"

// This program should go to 11, but sometimes it only prints 1 to 10.
func main() {
	ch := make(chan int)
	//	c := make(chan bool)
	go Print(ch)
	for i := 1; i <= 11; i++ {
		ch <- i
		//c <- true // a send occurs before a receive.
		<-ch
	}

	close(ch)

}

// Print prints all numbers sent on the channel.
// The function returns when the channel is closed.
func Print(ch chan int) {
	for n := range ch { // reads from channel until it's closed
		fmt.Println(n)
		ch <- 1
		//<-c // receive occurs after send.
	}

}
