package main

import (
	"allan/stack"
	"bufio"
	"fmt"
	"os"
	"strconv"
)

func main() {

	var stack = new(stack.Stack)
	var reader *bufio.Reader = bufio.NewReader(os.Stdin)

	for {
		line, err := reader.ReadString('\n')

		fmt.Printf("Err %s", err)

		var token string

		if err != nil {
			return
		}

		for _, c := range line {

			switch {
			case c >= '0' && c <= '9':
				token = token + string(c)
			case c == ' ':
				r, _ := strconv.Atoi(token)
				stack.Push(r)
				token = ""
			case c == '+':
				fmt.Printf("%d\n", stack.Pop()+stack.Pop())
			case c == '-':
				fmt.Printf("%d\n", stack.Pop()-stack.Pop())
			case c == '*':
				fmt.Printf("%d\n", stack.Pop()*stack.Pop())
			case c == '/':
				fmt.Printf("%d\n", stack.Pop()/stack.Pop())
			case c == '%':
				fmt.Printf("%d\n", stack.Pop()%stack.Pop())
			case c == 'q':
				os.Exit(0)
			default:
				fmt.Errorf("Invalid argument %v\n", c)
			}
		}
	}
}
