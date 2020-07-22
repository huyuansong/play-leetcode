// 203. Remove Linked List Elements
// https://leetcode.com/problems/remove-linked-list-elements/description/
// 使用虚拟头结点
// 时间复杂度: O(n)
// 空间复杂度: O(1)
public class Solution2 {

    public ListNode removeElements(ListNode head, int val) {

        // 创建虚拟头结点  为了避免单链表中在删除元素时需要对头节点单独的处理，引入虚拟节点（哑节点），一段代码逻辑可以同时适用于头节点的删除操作
        ListNode dummyHead = new ListNode(0);  //虚拟节点中存什么元素不重要，没有用
        dummyHead.next = head;

        ListNode cur = dummyHead;
        while(cur.next != null){   //适用于一般节点的删除，也适用于头节点的删除操作
            if(cur.next.val == val ){
                ListNode delNode = cur.next;
                cur.next = delNode.next;
            }
            else
                cur = cur.next;
        }

        return dummyHead.next;  //返回链表的头节点
    }

    public static void main(String[] args) {

        int[] arr = {1, 2, 6, 3, 4, 5, 6};
        int val = 6;

        ListNode head = new ListNode(arr);
        System.out.println(head);

        (new Solution1()).removeElements(head, val);
        System.out.println(head);
    }
}
