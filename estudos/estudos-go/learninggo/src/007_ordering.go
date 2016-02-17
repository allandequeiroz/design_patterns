package main

import (
	"fmt"
)

func main() {
	r1, r2 := CheckOrder(5, 10)
	fmt.Printf("%d, %d\n", r1, r2)

	r1, r2 = CheckOrder(10, 5)
	fmt.Printf("%d, %d\n", r1, r2)
}

func CheckOrder(a int, b int) (r1 int, r2 int) {
	if a < b {
		t := a
		a = b
		b = t
	}
	return a, b
}
