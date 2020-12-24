# Linked List


+ [Reverse Linked List](#reverse-linked-list)
+ [Middle of the Linked List][#middle-of-the-linked-list]
+ [Palindrome Linked List][#palindrome-linked-list]

## Reverse Linked List

https://leetcode.com/problems/reverse-linked-list

```
class Solution {
        public ListNode reverseList(ListNode head) {
            ListNode prev = null;
            ListNode curr = head;
            while (curr != null) {
                ListNode temp = curr.next;
                curr.next = prev;
                prev = curr;
                curr = temp;
            }
            return prev;
        }
    }
```

## Middle of the Linked List

https://leetcode.com/problems/middle-of-the-linked-list/
```
class Solution {
        public ListNode middleNode(ListNode head) {
            ListNode fast = head;
            ListNode slow = head;

            if (head.next == null)
                return head;
            else if (head.next.next == null)
                return head.next;

            while (fast != null && fast.next != null) {
                fast = fast.next.next;
                slow = slow.next;
            }

            return slow;
        }

    }
```

## Palindrome Linked List

https://leetcode.com/problems/palindrome-linked-list/
```
class Solution {
        public boolean isPalindrome (ListNode head) {
            if (head == null)
                return true;
            if (head.next == null)
                return true;
            else if (head.next.next == null) {
                return head.next.val == head.val;
            }

            ListNode fast = head;
            ListNode slow = head;

            while (fast != null && fast.next != null) {
                fast = fast.next.next;
                slow = slow.next;
            }

            if (fast != null)
                slow = slow.next;

            ListNode reversedSecondHalf = reverseList(slow);

            while (reversedSecondHalf != null) {
                if (reversedSecondHalf.val != head.val)
                    return false;
                reversedSecondHalf = reversedSecondHalf.next;
                head = head.next;
            }



            return true;
        }

        ListNode reverseList(ListNode head) {
            ListNode prev = null;
            ListNode curr = head;
            while (curr != null) {
                ListNode temp = curr.next;
                curr.next = prev;
                prev = curr;
                curr = temp;
            }
            return prev;
        }

    }
```
