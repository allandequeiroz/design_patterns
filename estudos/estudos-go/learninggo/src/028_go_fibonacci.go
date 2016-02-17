package main

import (
	"fmt"
)

func main() {

	ci := make(chan int)
	cb := make(chan bool)

	go Fibonacci(100, ci, cb)

	for {
		select {
		case i := <-ci:
			fmt.Printf("%d ", i)
		case <-cb:
			break
		}
	}

}

func Fibonacci(n int, ci chan int, cb chan bool) {
	cb <- true
	i := 1
	j := 1
	ci <- j

	for i < n && j <= n {

		s := i + j

		ci <- j

		i = j
		j = s
	}

	cb <- false
}
