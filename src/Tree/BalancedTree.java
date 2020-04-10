package Tree;

public class BalancedTree {

    private static int treeDepth(TreeNode root) {
        return root != null ? Math.max(treeDepth(root.left), treeDepth(root.right)) + 1 :0;
    }

    public static boolean isBalanced(TreeNode root) {
        return root == null || Math.abs(treeDepth(root.left) - treeDepth(root.right)) <= 1 && isBalanced(root.left) && isBalanced(root.right);
    }

    public static int isBalanced2(TreeNode root){
        if(root == null)
            return 0;
        int left = isBalanced2(root.left);
        int right = isBalanced2(root.right);
        if(left == -1 || right == -1)
            return -1;

        return Math.abs(left - right) > 1 ? -1 : Math.max(left, right) + 1;
    }

}
