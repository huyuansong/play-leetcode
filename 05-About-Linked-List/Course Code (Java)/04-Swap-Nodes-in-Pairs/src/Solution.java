// 24. Swap Nodes in Pairs
// https://leetcode.com/problems/swap-nodes-in-pairs/description/
// 时间复杂度: O(n)
// 空间复杂度: O(1)
//  单链表的操作一定要引入虚拟头节点
public class Solution {

    public ListNode swapPairs(ListNode head) {  // 返回值：删除元素之后的链表的头结点

        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;

        ListNode pre = dummyHead;
        while(pre.next != null && pre.next.next != null ){   //p.next为头节点 p.next.next为头节点的下一个节点 ，保证至少有两个实际的元素才可以交换
            ListNode node1 = pre.next;
            ListNode node2 = node1.next;
            ListNode next = node2.next;     //整个while循环，两个元素指针的交换，画图是非常容易理解的
            node2.next = node1;
            node1.next = next;
            pre.next = node2;
            pre = node1;   // 整体四个指针 pre node1 node2 next 四个指针向后移，这里移动 pre ,那三指针上面移
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
