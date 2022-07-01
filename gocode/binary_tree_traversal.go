package main

type TreeNode struct {
	Val   int
	Left  *TreeNode
	Right *TreeNode
}

func threeOrders(root *TreeNode) [][]int {
	result := make([][]int, 3)
	result[0] = preorderTraversal(root)
	result[1] = midorderTraversal(root)
	result[2] = postorderTraversal(root)
	return result
}

func preorderTraversal(root *TreeNode) (vals []int) {
	var preorder func(*TreeNode)
	preorder = func(node *TreeNode) {
		if node == nil {
			return
		}
		vals = append(vals, node.Val)
		preorder(node.Left)
		preorder(node.Right)
	}
	preorder(root)
	return
}
func midorderTraversal(root *TreeNode) (vals []int) {
	var midorder func(*TreeNode)
	midorder = func(node *TreeNode) {
		if node == nil {
			return
		}
		midorder(node.Left)
		vals = append(vals, node.Val)
		midorder(node.Right)
	}
	midorder(root)
	return
}

func postorderTraversal(root *TreeNode) (vals []int) {
	var postOrder func(*TreeNode)
	postOrder = func(node *TreeNode) {
		if node == nil {
			return
		}
		postOrder(node.Left)
		postOrder(node.Right)
		vals = append(vals, node.Val)
	}
	postOrder(root)
	return
}

func preorderTraversalUseStack(root *TreeNode) (vals []int) {
	stack := []*TreeNode{}
	node := root
	for node != nil || len(stack) > 0 {
		for node != nil {
			vals = append(vals, node.Val)
			stack = append(stack, node)
			node = node.Left
		}
		node = stack[len(stack)-1].Right
		stack = stack[:len(stack)-1]
	}
	return
}
