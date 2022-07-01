package main

func GetLeastNumbers(input []int, k int) []int {
	// write code here
	if k >= len(input) {
		return input
	}
	return quickSort(input, k, 0, len(input)-1)
}

func quickSort(arr []int, k, l, r int) []int {
	i, j := l, r
	for i < j {
		for i < j && arr[j] >= arr[l] {
			j--
		}
		for i < j && arr[i] <= arr[l] {
			i++
		}
		arr[i], arr[j] = arr[j], arr[i]
	}
	arr[i], arr[l] = arr[l], arr[i]
	if i > k {
		return quickSort(arr, k, l, i-1)
	}
	if i < k {
		return quickSort(arr, k, i+1, r)
	}
	return arr[:k]
}
