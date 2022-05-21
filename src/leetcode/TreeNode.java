package Tree;

public class TreeNode{
    int val;
    TreeNode right;
    TreeNode left;
    public TreeNode(){

    }
    public TreeNode(int val){
        this.val=val;

    }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
};