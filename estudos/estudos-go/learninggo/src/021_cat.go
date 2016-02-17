package main

import (
	"fmt"
	"io"
	"os"
)

func main() {

	var args = os.Args
	var nArg = len(args) == 3 && args[2] == "-n"

	file, err := os.Open(args[1])
	if err != nil {
		panic(err)
	}
	defer file.Close()

	buf := make([]byte, 1024)
	nLines := 1

	for {
		n, err := file.Read(buf)
		if err != nil && err != io.EOF {
			panic(err)
		}
		if n == 0 {
			break
		}
		if nArg {
			fmt.Printf("%d\t", nLines)
		}

		for _, v := range buf {
			fmt.Printf("%s", string(v))
			if v == '\n' && nArg {
				nLines++
				fmt.Printf("%d\t", nLines)
			}
		}
	}
}
