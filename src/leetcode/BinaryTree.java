package Tree;


import java.util.*;

public class BinaryTree {


    public static void main(String[] args) {

        int[] nums = {1, 2, 3, 4, 5, 6, 7, 0, 0, 8, 0, 0, 9, 0, 0, 0, 0, 0, 0};
        int[] nums1 = {1, 2, 3, 4, 5, 6, 7, 0, 0, 8, 0, 0, 9, 0, 0, 0, 0, 0, 0};
        TreeNode root = creatBinaryTree(nums, 0);
        TreeNode root2 = creatBinaryTree(nums1, 0);

        leverTraveralBinaryTree(root);
    }

    //    创建二叉树（带返回值）
    private static TreeNode creatBinaryTree(int[] nums, int start) {
        if (start >= nums.length || nums[start] == 0) {
            return null;
        } else {
            TreeNode root = new TreeNode(nums[start]);
            root.left = creatBinaryTree(nums, start * 2 + 1);
            root.right = creatBinaryTree(nums, start * 2 + 2);
            return root;
        }
    }

    //    遍历二叉树
//    递归方法
//    前序遍历
    private static void preorderTraversalByRecursion(TreeNode root) {
        if (root != null) {
            System.out.print(root.val + " ");
            preorderTraversalByRecursion(root.left);
            preorderTraversalByRecursion(root.right);
        }
    }

    //    中序遍历
    private static void inorderTraversalByRecursion(TreeNode root) {
        if (root != null) {
            inorderTraversalByRecursion(root.left);
            System.out.print(root.val + " ");
            inorderTraversalByRecursion(root.right);
        }
    }

    //    后序遍历
    private static void postorderTraversalByRecursion(TreeNode root) {
        if (root != null) {

            postorderTraversalByRecursion(root.left);
            postorderTraversalByRecursion(root.right);
            System.out.print(root.val + " ");
        }
    }

    //    非递归遍历
//    前序遍历
    private static void preorderTraversalWithoutRecursion(TreeNode root) {
        List<Integer> list=new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        if (root == null) {
            return;
        } else {
            stack.push(root);
        }
        while (!stack.isEmpty()) {
            TreeNode p = stack.pop();
            System.out.print(p.val + " ");
            if (p.right != null) {
                stack.push(p.right);
            }
            if (p.left != null) {
                stack.push(p.left);
            }
        }
    }

    //    中序遍历
    private static void inorderTraversalWithoutRecursion(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            TreeNode p = stack.pop();
            System.out.print(p.val + " ");
            if (p.right != null) {
                root = p.right;
            }
        }
    }

    //    后序遍历
//    可以简单理解为将二叉树进行对称翻转之后，再进行前序遍历，之后，将遍历结果反转即可。
    private static void postorderTraversalWithoutRecursion(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        ArrayList<Integer> list = new ArrayList<>();
        if (root == null) {
            return;
        } else {
            stack.push(root);
        }
        while (!stack.isEmpty()) {
            TreeNode p = stack.pop();
            list.add(p.val);
            if (p.left != null) {
                stack.push(p.left);
            }
            if (p.right != null) {
                stack.push(p.right);
            }

        }
        for (int i = list.size() - 1; i >= 0; i--) {
            System.out.print(list.get(i) + " ");
        }
    }

    //    层次遍历
    private static void leverTraveralBinaryTree(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        if (root != null)
            queue.add(root);
        while (!queue.isEmpty()){
            TreeNode p=queue.poll();
            System.out.print(p.val+" ");
            if(p.left!=null){
                queue.add(p.left);
            }
            if(p.right!=null){
                queue.add(p.right);
            }
        }


    }

    //    是否为同一二叉树
    private static boolean isSameBinaryTree(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null) {
            return true;
        } else if (root1 == null || root2 == null) {
            return false;
        } else if (root1.val == root2.val) {
            return isSameBinaryTree(root1.left, root2.left) && isSameBinaryTree(root1.right, root2.right);
        } else
            return false;
    }

    //    是否为对称二叉树
    public boolean isSymmetric(TreeNode root) {

        if (root != null) {
            return isSymmetricCmp(root.left, root.right);
        }
        return true;
    }

    public static boolean isSymmetricCmp(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return true;
        } else if (left != null && right != null) {
            if (left.val == right.val) {
                return isSymmetricCmp(left.left, right.right) && isSymmetricCmp(left.right, right.left);
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

    //    二叉树高度
    private static int getdeepth(TreeNode root) {
        if (root == null) {
            return 0;
        } else {
            int left = getdeepth(root.left);
            int right = getdeepth(root.right);
            return left > right ? left + 1 : right + 1;
        }
    }
}
