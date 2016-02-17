package main

import (
	"container/list"
	"fmt"
)

func main() {

	l := new(list.List)
	l.PushBack(1)
	l.PushBack(2)
	l.PushBack(4)

	for e := l.Front(); e != nil; e = e.Next() {
		fmt.Printf(" %d ", e.Value)
	}

	fmt.Println()
}
