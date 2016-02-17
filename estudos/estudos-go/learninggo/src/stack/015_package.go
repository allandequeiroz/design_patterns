/*
% mkdir $GOPATH/src/even ← Create top-level directory
% cp even.go $GOPATH/src/even ← Copy the package file
% go build ← Build it
% go install ← Install it to ../pkg
*/
package stack

type Stack struct {
	i    int
	data [10]int
}

func (s *Stack) Push(k int) {
	if s.i+1 > 9 {
		return
	}
	s.data[s.i] = k
	s.i++
}

func (s *Stack) Pop() int {
	s.i--
	if s.i < 0 {
		return 0
	}
	r := s.data[s.i]
	s.data[s.i] = 0
	return r
}
