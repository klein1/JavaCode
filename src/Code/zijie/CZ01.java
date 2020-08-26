package Code.zijie;

import java.util.Arrays;
import java.util.Scanner;

public class CZ01 {

    private static int count;

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] preorder = new int[n];
        int[] inorder = new int[n];
        for (int i = 0; i < n; i++) {
            preorder[i] = in.nextInt();
        }
        for (int i = 0; i < n; i++) {
            inorder[i] = in.nextInt();
        }
        TreeNode root = buildTree(preorder, inorder);
        DLR(root);
        System.out.println(count);
    }

    public static void DLR(TreeNode root) {
        if (root != null) {
            if (root.left == null && root.right == null) {
                count++;
            }
            DLR(root.left);
            DLR(root.right);
        }
    }

    public static TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length <= 0) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[0]);
        if (preorder.length == 1) {
            return root;
        }
        int temp = 0;
        for (int i = 0; i < inorder.length; i++) {
            if (inorder[i] == preorder[0]) {
                temp = i;
                break;
            }
        }
        int[] preorderLeft = Arrays.copyOfRange(preorder, 1, temp + 1);
        int[] preorderRight = preorder.length - 1 >= temp + 1 ? Arrays.copyOfRange(preorder, temp + 1, preorder.length) : new int[0];

        int[] inorderLeft = Arrays.copyOfRange(inorder, 0, temp);
        int[] inorderRight = inorder.length - 1 >= temp + 1 ? Arrays.copyOfRange(inorder, temp + 1, inorder.length) : new int[0];

        root.left = buildTree(preorderLeft, inorderLeft);
        root.right = buildTree(preorderRight, inorderRight);

        return root;
    }
}