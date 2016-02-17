package main

import (
	"fmt"
)

func main() {

	str := "abaaacdefg"
	slc := str[:]

	for i, v := range slc {
		switch {
		case i == 0:
			fmt.Printf("'%s' ", string(v))
		case i != 0 && slc[i] != slc[i-1]:
			fmt.Printf("'%s' ", string(v))
		}
	}

	fmt.Println("")
}
