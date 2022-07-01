package main

/**
 * Definition for singly-linked list.
 * type ListNode struct {
 *     Val int
 *     Next *ListNode
 * }
 */
func Merge(pHead1 *ListNode, pHead2 *ListNode) *ListNode {
	if pHead1 == nil { //递归终止条件
		return pHead2
	}
	if pHead2 == nil { //递归终止条件
		return pHead1
	}
	if pHead1.Val > pHead2.Val { //交换两节点
		pHead1, pHead2 = pHead2, pHead1
	}
	pHead1.Next = Merge(pHead1.Next, pHead2) //递归
	return pHead1
}
