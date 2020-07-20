// 24. Swap Nodes in Pairs
// https://leetcode.com/problems/swap-nodes-in-pairs/description/
// 时间复杂度: O(n)
// 空间复杂度: O(1)
//  单链表的操作一定要引入虚拟头节点
public class Solution {

    public ListNode swapPairs(ListNode head) {

        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;

        ListNode p = dummyHead;
        while(p.next != null && p.next.next != null ){   //p.next为头节点 p.next.next为头节点的下一个节点 ，保证至少有两个实际的元素
            ListNode node1 = p.next;
            ListNode node2 = node1.next;
            ListNode next = node2.next;     //整个while循环，两个元素指针的交换，画图是非常容易理解的
            node2.next = node1;
            node1.next = next;
            p.next = node2;
            p = node1;
        }

        return dummyHead.next;  //返回单链表的头节点
    }

    public static void main(String[] args) {

        int[] arr = {1, 2, 3, 4};

        ListNode head = new ListNode(arr);
        System.out.println(head);

        head = (new Solution()).swapPairs(head);
        System.out.println(head);
    }
}
