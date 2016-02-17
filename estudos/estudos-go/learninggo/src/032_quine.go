package main

import (
	"fmt"
	"io"
	"os"
)

func main() {

	var args = os.Args

	file, err := os.Open(args[0])

	if err != nil {
		panic(err)
	}
	defer file.Close()

	buf := make([]byte, 1024)

	for {
		n, err := file.Read(buf)
		if err != nil && err != io.EOF {
			panic(err)
		}
		if n == 0 {
			break
		}
		for _, v := range buf {
			fmt.Printf("%v", v)
		}

	}

}
