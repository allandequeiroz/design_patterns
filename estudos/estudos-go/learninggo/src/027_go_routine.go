package main

import (
	"fmt"
)

func main() {
	ch := make(chan int)
	quit := make(chan bool)

	go print(ch, quit)

	for i := 0; i < 10; i++ {
		ch <- i
	}

	quit <- true //don't matter
}

func print(ch chan int, quit chan bool) {
	for {
		select {
		case j := <-ch:
			fmt.Printf("%d\n", j)
		case <-quit:
			break
		}
	}
}
