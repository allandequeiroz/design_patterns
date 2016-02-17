package main

import (
	"fmt"
)

func gt(l, r interface{}) bool {
	switch l.(type) {
	case int:
		if _, ok := r.(int); ok {
			return l.(int) > r.(int)
		}
	case float64:
		if _, ok := r.(float64); ok {
			return l.(float64) > r.(float64)
		}
	}
	return false
}

func Gt(ar []interface{}) {
	m := ar[0]
	for _, v := range ar {
		if gt(v, m) {
			m = v
		}
	}

	fmt.Printf("Biggest:%v\n", m)
}

func main() {
	arInt := []interface{}{5, 3, 1, 90, 66, 43}
	arFloat := []interface{}{5.0, 3.0, 1.0, 90.0, 66.0, 43.0}
	Gt(arInt)
	Gt(arFloat)
}
