package main

import (
	"fmt"
)

func main() {
	ar := []int{5, 3, 1, 90, 66, 43}
	sl := ar[:]

	g := Max(sl)
	s := Min(sl)

	fmt.Printf("Smaller:%d,Bigger:%d\n", s, g)
}

func Max(s []int) int {
	m := s[0]
	for _, v := range s {
		if v > m {
			m = v
		}
	}
	return m
}

func Min(s []int) int {
	m := s[0]
	for _, v := range s {
		if v < m {
			m = v
		}
	}
	return m
}
