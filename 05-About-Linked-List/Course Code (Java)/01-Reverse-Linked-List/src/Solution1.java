// 206. Reverse Linked List
// https://leetcode.com/problems/reverse-linked-list/description/
//反转单链表
// 时间复杂度: O(n)
// 空间复杂度: O(1)
public class Solution1 {

    // Definition for singly-linked list.
    public class ListNode {
        int val;                    //节点的值
        ListNode next;              //节点的指针
        ListNode(int x) { val = x; }  //构造函数
    }

    public ListNode reverseList(ListNode head) {

        ListNode pre = null;
        ListNode cur = head;
        while(cur != null){
            ListNode next = cur.next;  //多引入一个指针，便于表示指针的移动关系
            cur.next = pre;    //调整指向，将正向指针转为反向指针
            pre = cur;          //pre指针向后移动
            cur = next;         //cur指针向后移动
        }

        return pre;
    }
}
