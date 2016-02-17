package main

import (
	"fmt"
)

func main() {
	arr := []int{5, 10}
	f := Exp

	Map(f, arr)

}

func Map(f func(int) int64, arr []int) {

	for _, v := range arr {

		r := f(v)
		fmt.Printf("%d\n", r)
	}
}

func Exp(exp int) int64 {

	var e int64 = int64(exp)

	for i := 0; i < exp; i++ {

		//fmt.Printf("%d * %d = ", e, exp)

		e *= int64(exp)

		//fmt.Printf("%d\n", e)
	}
	return e
}
