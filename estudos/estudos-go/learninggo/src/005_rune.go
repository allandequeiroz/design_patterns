package main

import(
	"fmt"
	"unicode/utf8"
)

func main(){

	s := "asSASA ddd dsjkdsjs dk"
	l := utf8.RuneCountInString(s)

	fmt.Printf("Characters = %d\n" , l)

	r := []rune(s)
	b := 0

	for i , _ := range r {

		b += utf8.RuneLen( r[i] )

	}

	fmt.Printf("Bytes = %d\n" , b)

}