package main

import(
	"fmt"
)

func main(){

	i := 0

	it:

	fmt.Println("Index -> ", i);
	i+=1
	
	if i < 10 {
		goto it
	}	

}