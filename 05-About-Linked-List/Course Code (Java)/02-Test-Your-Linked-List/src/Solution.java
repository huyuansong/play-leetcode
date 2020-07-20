// 206. Reverse Linked List
// https://leetcode.com/problems/reverse-linked-list/description/
// 时间复杂度: O(n)
// 空间复杂度: O(1)
public class Solution {

    public ListNode reverseList(ListNode head) {

        ListNode pre = null;
        ListNode cur = head;
        while(cur != null){
            ListNode next = cur.next;
            cur.next = pre;   //这一步是反转的操作  其他步骤都是维护三个指针的相对位置（循环不变量）
            pre = cur;
            cur = next;
        }

        return pre;  //循环已经退出，说明cur已经为null，next没有被重新修改值，那么头节点就是pre了
    }

    public static void main(String[] args) {

        int[] nums = {1, 2, 3, 4, 5};
        ListNode head = new ListNode(nums);
        System.out.println(head);

        ListNode head2 = (new Solution()).reverseList(head);
        System.out.println(head2);
    }
}
