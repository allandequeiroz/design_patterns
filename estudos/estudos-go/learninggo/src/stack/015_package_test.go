package stack

import (
	"testing"
)

func TestPush(t *testing.T) {

	s := new(Stack)
	s.Push(50)

	if s.Pop() != 50 {
		t.Log("Pop doesn't give 5")
		t.Fail()
	}

}
