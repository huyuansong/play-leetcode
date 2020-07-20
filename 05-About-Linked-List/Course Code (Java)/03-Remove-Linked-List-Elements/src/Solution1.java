// 203. Remove Linked List Elements
// https://leetcode.com/problems/remove-linked-list-elements/description/
// 不使用虚拟头结点
// 时间复杂度: O(n)
// 空间复杂度: O(1)
public class Solution1 {

    public ListNode removeElements(ListNode head, int val) {

        // 需要对头结点进行特殊处理，头节点存在并且要移除的元素就是头节点
        while(head != null && head.val == val){         //关于头节点的单独处理，如果整个链表都是相同的元素，且每次都删除头节点，相当于删除整个链表
            ListNode node = head;                       //因此需要while循环在先，if头节点判空在while的后面执行  这里是一很大的坑
            head = head.next;
        }

        if(head == null)
            return head;

        ListNode cur = head;
        while(cur.next != null){   
            if(cur.next.val == val){
                ListNode delNode = cur.next;
                cur.next = delNode.next; //直接跳过delNode节点
            }
            else
                cur = cur.next;
        }

        return head;
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
