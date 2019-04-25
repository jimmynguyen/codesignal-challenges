package main

import (
	"fmt"
	"strings"
)

func improperFractionToMixed(a []int) []int {
	return []int{a[0] / a[1], a[0] % a[1], a[1]}
}

func arrayToString(a []int) string {
	return strings.Join(strings.Fields(fmt.Sprint(a)), ", ")
}

func assert(assertion bool, message string) {
	if !assertion {
		panic(message)
	}
}

//https://yourbasic.org/golang/compare-slices/
func arraysEqual(a []int, b []int) bool {
	if len(a) != len(b) {
		return false
	}
	for i, v := range a {
		if v != b[i] {
			return false
		}
	}
	return true
}
func main() {
	input0 := [][]int{[]int{7, 2}, []int{10, 3}}
	expectedOutput := [][]int{[]int{3, 1, 2}, []int{3, 1, 3}}
	assert(len(input0) == len(expectedOutput), fmt.Sprintf("# input0 = %d, # expectedOutput = %d", len(input0), len(expectedOutput)))
	for i := 0; i < len(expectedOutput); i++ {
		actualOutput := improperFractionToMixed(input0[i])
		assert(arraysEqual(actualOutput, expectedOutput[i]), fmt.Sprintf("improperFractionToMixed(%s) returned %s, but expected %s", arrayToString(input0[i]), arrayToString(actualOutput), arrayToString(expectedOutput[i])))
	}
	fmt.Println(fmt.Sprintf("PASSES %d out of %d tests", len(expectedOutput), len(expectedOutput)))
}
