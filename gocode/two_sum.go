package main

func twoSum(numbers []int, target int) []int {
	hashTable := map[int]int{}
	for i, x := range numbers {
		if p, ok := hashTable[target-x]; ok {
			if p < i {
				return []int{p + 1, i + 1}
			} else {
				return []int{i + 1, p + 1}
			}
		}
		hashTable[x] = i
	}
	return nil
}
