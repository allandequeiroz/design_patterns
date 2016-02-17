package main

import (
	"fmt"
)

var arr [5]string
var cursor = 4

func main() {
	Push("e")
	Print()

	Push("d")
	Print()

	Pop()
	Print()

	Pop()
	Print()

	Pop()
	Print()

}

func Push(push string) {
	arr[cursor] = push
	if cursor > 0 {
		cursor--
	}
}

func Pop() string {
	pop := arr[cursor]
	arr[cursor] = ""
	if cursor < 4 {
		cursor++
	}
	return pop
}

func Print() {
	fmt.Printf("%v\n", arr)
}
