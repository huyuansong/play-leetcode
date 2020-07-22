// 206. Reverse Linked List
// https://leetcode.com/problems/reverse-linked-list/description/
//
// 递归的方式反转链表
// 时间复杂度: O(n)
// 空间复杂度: O(n) - 注意，递归是占用空间的，占用空间的大小和递归深度成正比：）
public class Solution2 {

    // Definition for singly-linked list.
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public ListNode reverseList(ListNode head) { // 返回值 ：反转后链表的头结点

        // 递归终止条件
        if(head == null|| head.next == null)
            return head;

        ListNode rhead = reverseList(head.next);

        // head->next此刻指向head后面的链表的尾节点
        // head->next->next = head把head节点放在了尾部
        head.next.next = head;   //这两行代码：两个节点做位置的交换，每次只交换两个节点的位置
        head.next = null;

        return rhead;
    }
}
