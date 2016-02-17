package main

import (
	"bufio"
	"fmt"
	"net"
)

func main() {

	l, err := net.Listen("tcp", "127.0.0.1:8080")
	if err != nil {
		panic(err)
	}

	for {
		if c, err := l.Accept(); err == nil {
			go Echo(c)
		}
	}
}

func Echo(c net.Conn) {
	defer c.Close()
	line, err := bufio.NewReader(c).ReadString('\n')
	if err != nil {
		fmt.Printf("Failure do read: %s\n", err.Error())
		return
	}

	_, err = c.Write([]byte(line))
	if err != nil {
		fmt.Printf("Failure do write: %s\n", err.Error())
		return
	}
}
