package main

import (
	"fmt"
)

func main() {
	f := plusX(2)
	fmt.Println(f(2))
}

func plusX(x int) func(int) int {
	return func(y int) int { return x + y }
}
