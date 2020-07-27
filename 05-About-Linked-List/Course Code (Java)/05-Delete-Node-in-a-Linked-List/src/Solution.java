// 237. Delete Node in a Linked List
// https://leetcode.com/problems/delete-node-in-a-linked-list/description/
/* 请编写一个函数，使其可以删除某个链表中给定的（非末尾）节点，你将只被给定要求被删除的节点。

现有一个链表 -- head = [4,5,1,9]，它可以表示为:

示例 1:

输入: head = [4,5,1,9], node = 5
输出: [4,1,9]
解释: 给定你链表中值为 5 的第二个节点，那么在调用了你的函数之后，该链表应变为 4 -> 1 -> 9.
示例 2:

输入: head = [4,5,1,9], node = 1
输出: [4,5,9]
解释: 给定你链表中值为 1 的第三个节点，那么在调用了你的函数之后，该链表应变为 4 -> 5 -> 9.
*/
// 时间复杂度: O(1)
// 空间复杂度: O(1)
public class Solution {

    public void deleteNode(ListNode node) {

        // 注意: 这个方法对尾节点不适用。题目中要求了给定的node不是尾节点
        // 我们检查node.next, 如果为null则抛出异常, 确保了node不是尾节点
        if(node == null || node.next == null)
            throw new IllegalArgumentException("node should be valid and can not be the tail node.");

        //因为没有前驱指针，也没有办法反向找到前一个元素，所以采用这样的奇技淫巧
        node.val = node.next.val;  //将node节点取下一个节点的值
        node.next = node.next.next;//node节点直接指向下下个节点
    }

    public static void main(String[] args) {

        int[] arr = {1, 2, 3, 4};

        ListNode head = new ListNode(arr);
        System.out.println(head);

        ListNode node2 = head.findNode(2);
        (new Solution()).deleteNode(node2);
        System.out.println(head);
    }
}
