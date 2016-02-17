package main

import (
	"fmt"
	"io"
	"os"
	"strings"
)

func main() {

	var args = os.Args

	file, err := os.Open(args[1])
	if err != nil {
		panic(err)
	}
	defer file.Close()

	buf := make([]byte, 1024)
	lineCounter := 1
	charCounter := 0
	wordCounter := 0

	for {
		n, err := file.Read(buf)
		if err != nil && err != io.EOF {
			panic(err)
		}
		if n == 0 {
			break
		}

		charCounter += len(buf)
		wordCounter += len(strings.Split(strings.TrimSpace(string(buf)), " "))

		for _, v := range buf {
			if v == '\n' {
				lineCounter++
			}
		}

	}

	fmt.Printf("Total Chars : %d\n", charCounter)
	fmt.Printf("Total Words : %d\n", wordCounter)
	fmt.Printf("Total Lines : %d\n", lineCounter)

}
