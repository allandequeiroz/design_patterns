package main

import (
	"fmt"
)

func main() {
	Variadic(5, 78, 2, 22, 1)
}

func Variadic(varargs ...int) {

	for _, v := range varargs {
		fmt.Println(v)
	}
}
