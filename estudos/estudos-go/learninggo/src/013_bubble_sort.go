package main

import (
	"fmt"
)

func main() {

	arr := []int{10, 5, 1, 80, 44, 0, 22, 88, 46, 1}

	for i := 1; i < len(arr); i++ {

		if arr[i-1] > arr[i] {
			t := arr[i-1]
			arr[i-1] = arr[i]
			arr[i] = t
			i = 0

			fmt.Printf("%v\n", arr)
		}
	}

	fmt.Printf("%v\n", arr)

}
