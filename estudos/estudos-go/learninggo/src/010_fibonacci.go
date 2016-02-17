package main

import (
	"fmt"
)

func main() {

	Fibonacci(100)

}

func Fibonacci(n int) {
	i := 1
	j := 1

	fmt.Printf("%d ", j)

	for i < n && j <= n {

		s := i + j

		fmt.Printf("%d ", j)

		i = j
		j = s
	}
}
