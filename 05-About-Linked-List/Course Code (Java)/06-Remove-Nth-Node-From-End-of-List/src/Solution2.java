// 19. Remove Nth Node From End of List
// https://leetcode.com/problems/remove-nth-node-from-end-of-list/description/
/* 给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。
示例：
给定一个链表: 1->2->3->4->5, 和 n = 2.
当删除了倒数第二个节点后，链表变为 1->2->3->5. */
// 使用双指针, 对链表只遍历了一遍
// 时间复杂度: O(n)
// 空间复杂度: O(1)
public class Solution2 {

    public ListNode removeNthFromEnd(ListNode head, int n) {

        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;

        ListNode p = dummyHead;  //双指针
        ListNode q = dummyHead;
        for( int i = 0 ; i < n + 1 ; i ++ ){  //要删除倒数第 n 个元素，q 节点先走 n+1 步
            assert q != null;
            q = q.next;
        }
                            // 画图 可以最好的理解这些边界之间的关系
        while(q != null){   // 等到 q 节点为空，说明 q 已经到达链表的最后一个元素的后面，而q比p先走了n+1步，此刻p正在倒数第n个元素的前面
            p = p.next;
            q = q.next;
        }

        p.next = p.next.next; //直接跳过 p.next 元素，也就是倒数第n个元素

        return dummyHead.next; //返回链表的头节点
    }

    public static void main(String[] args) {

        int arr[] = {1, 2, 3, 4, 5};
        ListNode head = new ListNode(arr);
        System.out.println(head);

        head = (new Solution2()).removeNthFromEnd(head, 2);
        System.out.println(head);
    }
}
