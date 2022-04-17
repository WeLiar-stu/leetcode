import java.util.Arrays;
import java.util.HashMap;
import java.util.Stack;


//  Definition for singly-linked list.
class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    void showList() {
        ListNode listNode1 = this;
        while (listNode1 != null) {
            System.out.print(listNode1.val + " ");
            listNode1 = listNode1.next;
        }
    }
}

//Definition for a binary tree node.
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

public class Main {
    public static void main(String[] args) {
        Main h = new Main();

        int[] nums1 = new int[]{1, 2, 3, 0, 0, 0};
        int[] nums2 = new int[]{2, 5, 6};

        int target = 9;
        int x = 121;
        String str = "Hello World";
        String str1 = "1111";
        String str2 = "1111";
        h.merge(nums1, 3, nums2, 3);
        System.out.println(Arrays.toString(nums1));
    }
    //111
    public int minDepth(TreeNode root) {
        if(root==null){
            return 0;
        }else if(root.left==null) {
            return 1+minDepth(root.right);
        }else if(root.right==null) {
            return 1 + minDepth(root.left);
        }else{
            return Math.min(minDepth(root.left),minDepth(root.right))+1;
        }
    }

    //    104
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        } else {
            return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
        }
    }
//    110

    public boolean isBalanced(TreeNode root) {
        if(isBalancedF(root)<0 ){
            return false;
        }else{
            return true;
        }
    }
    public static int isBalancedF(TreeNode root){
        if(root!=null){
            int left=isBalancedF(root.left);
            int right=isBalancedF((root.right));
            if(left==-1 || right==-1||Math.abs(left-right)>1){
                return -1;
            }else{
                return Math.max(left,right)+1;
            }
        }else{
            return 0;
        }
    }
    //    108
    public TreeNode sortedArrayToBST(int[] nums) {

        if(nums.length>0){
            return sortedArrayToBSTF(nums,0,nums.length-1);
        }else{
            return null;
        }
    }
    public TreeNode sortedArrayToBSTF(int[] nums, int start,int end){
        if(start<=end){
            int mid=start+(end-start)/2;
            TreeNode t=new TreeNode(nums[mid]);
            t.left=sortedArrayToBSTF(nums,start,mid-1);
            t.right=sortedArrayToBSTF(nums,mid+1,end);
            return t;
        }else{
            return null;
        }


    }

//    101

    public boolean isSymmetric(TreeNode root) {

        if (root != null) {
            return isSymmetricF(root.left, root.right);
        }
        return true;
    }

    public static boolean isSymmetricF(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return true;
        } else if (left != null && right != null) {
            if (left.val == right.val) {
                return isSymmetricF(left.left, right.right) && isSymmetricF(left.right, right.left);
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

    // 100
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p != null && q != null && p.val == q.val) {
            return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
        } else if (p == null && q == null) {
            return true;
        } else
            return false;
    }

    //    88
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int end1 = m - 1;
        int end2 = n - 1;
        for (int i = m + n - 1; i >= 0; i--) {
            if (end1 >= 0 && end2 >= 0) {
                if (nums1[end1] > nums2[end2]) {
                    nums1[i] = nums1[end1--];
                } else {
                    nums1[i] = nums2[end2--];
                }
            } else if (end1 < 0) {
                nums1[i] = nums2[end2--];
            } else {
                nums1[i] = nums1[end1--];
            }
        }
    }

    //    83
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null)
            return null;
        ListNode h = head;
        while (h.next != null) {
            ListNode p = h.next;
            if (h.val == p.val) {
                h.next = p.next;
            } else {
                h = p;
            }
        }
        return head;
    }

    //    70
    public int climbStairs(int n) {
        if (n == 1) {
            return 1;
        }
        if (n == 2)
            return 2;
        int a = 1, b = 2, temp = 0;
        for (int i = 2; i < n; i++) {
            temp = a + b;
            a = b;
            b = temp;
        }
        return temp;
    }

    //69
    public int mySqrt(int x) {
        if (x == 1)
            return 1;
        int min = 0;
        int max = x;
        while (max - min > 1) {
            int mid = (max + min) / 2;
            if (x / mid < mid)
                max = mid;
            else
                min = mid;
        }
        return min;
    }

    //    67
    public String addBinary(String a, String b) {
        int t = 0;
        StringBuilder result = new StringBuilder();
        for (int i = 0; t != 0 || i < a.length() || i < b.length(); i++) {
            if (i < a.length()) {
                t = a.charAt(a.length() - 1 - i) - '0' + t;
            }
            if (i < b.length()) {
                t = b.charAt(b.length() - 1 - i) - '0' + t;
            }
            if (t < 2) {
                result.append((char) (t + '0'));
                t = 0;
            } else {
                result.append((char) (t % 2 + '0'));
                t = 1;
            }
        }
        return result.reverse().toString();
    }

    //66
    public int[] plusOne(int[] digits) {
        int temp = 1;
        for (int i = digits.length - 1; i >= 0; i--) {
            temp = digits[i] + temp;
            if (temp < 10) {

                digits[i] = temp;
                return digits;
            } else {

                digits[i] = 0;
                temp = 1;
            }
            if (i == 0 && temp == 1) {
                int[] nums = new int[digits.length + 1];
                nums[0] = 1;
                return nums;
            }
        }
        return null;
    }

    //58
    public int lengthOfLastWord(String s) {

        int end = -1;
        for (int i = s.length() - 1; i >= 0; i--) {
            if (end == -1 && s.charAt(i) != ' ') {
                end = i;
            }
            if (end != -1 && s.charAt(i) == ' ') {
                return end - i;
            }
        }
        return s.length() - 1;
    }


//    53


    public int maxSubArray(int[] nums) {

        int temp = 0;
        int max = nums[0];
        for (int i = 0; i < nums.length; i++) {
            temp = Math.max(temp + nums[i], nums[i]);
            max = Math.max(max, temp);

        }

        return max;


    }

    //    35
    public int searchInsert(int[] nums, int target) {
        if (target > nums[nums.length - 1]) {
            return nums.length;
        }
        if (target < nums[0]) {
            return 0;
        }
        int start = 0;
        int end = nums.length - 1;
        int mid = (end - start) / 2 + start;
        while (start <= end) {
            if (nums[mid] < target) {
                start = mid + 1;
                mid = (end - start) / 2 + start;
            } else if (nums[mid] > target) {
                end = mid - 1;
                mid = (end - start) / 2 + start;
            } else
                break;
        }
        return mid;
    }

//    28

    public int strStr(String haystack, String needle) {
        if ("".equals(needle))
            return 0;
        if (haystack.length() < needle.length())
            return -1;
        int length = needle.length();
        for (int i = 0; i + length <= haystack.length(); i++) {
            if (haystack.substring(i, i + length).equals(needle)) {
                return i;

            }
        }
        return -1;

    }

    private static ListNode creatList(int[] nums) {
        ListNode head = new ListNode();
        ListNode p = head;
        for (int i = 0; i < nums.length; i++) {
            ListNode q = new ListNode(nums[i]);
            p.next = q;
            p = q;
        }
        return head.next;

    }


    //    21
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode head = new ListNode();
        ListNode p = head;
        while (list1 != null && list2 != null) {
            if (list1.val > list2.val) {
                p.next = list2;
                p = list2;
                list2 = list2.next;

            } else {
                p.next = list1;
                p = list1;
                list1 = list1.next;

            }
        }
        if (list1 == null) {
            p.next = list2;

        } else {
            p.next = list1;
        }
        return head.next;
    }


    //    20
    public boolean isValid(String s) {

        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(' || c == '[' || c == '{')
                stack.push(c);
            else {
                if (stack.isEmpty())
                    return false;
                if (c == ')') {
                    if (!(stack.pop() == '(')) {
                        return false;
                    }
                } else if (c == ']') {
                    if (!(stack.pop() == '[')) {
                        return false;
                    }
                } else if (c == '}') {
                    if (!(stack.pop() == '{')) {
                        return false;
                    }
                } else {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }

    //    14
    public String longestCommonPrefix(String[] strs) {
        String s = strs[0];
        for (int i = 1; i < strs.length; i++) {
            while (!strs[i].startsWith(s)) {
                if (s.length() == 0) {
                    return "";
                }
                s = s.substring(0, s.length() - 1);
            }
        }
        return s;
    }

    //    13
    public int romanToInt(String s) {
        int sum = 0;
        for (int i = 0; i < s.length(); i++) {
            switch (s.charAt(i)) {
                case 'I':
                    sum++;
                    if (i + 1 < s.length() && (s.charAt(i + 1) == 'V' || s.charAt(i + 1) == 'X'))
                        sum -= 2;
                    break;
                case 'V':
                    sum += 5;
                    break;
                case 'X':
                    sum += 10;
                    if (i + 1 < s.length() && (s.charAt(i + 1) == 'L' || s.charAt(i + 1) == 'C'))
                        sum -= 20;
                    break;
                case 'L':
                    sum += 50;
                    break;
                case 'C':
                    sum += 100;
                    if (i + 1 < s.length() && (s.charAt(i + 1) == 'D' || s.charAt(i + 1) == 'M'))
                        sum -= 200;
                    break;
                case 'D':
                    sum += 500;
                    break;
                case 'M':
                    sum += 1000;
                    break;


            }

        }
        return sum;
    }


    //    9
    public boolean isPalindrome(int x) {

        if (x < 0)
            return false;
        int y = x;
        int sum = 0;
        while (x > 0) {
            sum = sum * 10 + x % 10;
            x /= 10;
        }
        return sum == y;
    }

    //    1
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (hashMap.containsKey(target - nums[i])) {
                return new int[]{i, hashMap.get(target - nums[i])};
            } else {
                hashMap.put(nums[i], i);
            }
        }

        return null;
    }
}
