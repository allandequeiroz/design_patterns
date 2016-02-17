package main

import (
	"fmt"
)

func main() {

	arr := []float64{9.0, 8.5, 10.0, 5.5}
	slice := arr[:]
	average := 0.0

	for cursor := 0; cursor < len(slice); cursor++ {
		average += slice[cursor]
	}

	fmt.Println(average)
}
