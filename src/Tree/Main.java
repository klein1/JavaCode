package Tree;

import org.junit.Assert;
import org.junit.Test;

public class Main {

    @Test
    public void testNull(){
        Assert.assertTrue(BalancedTree.isBalanced(null));
    }

    @Test
    public void testBalanced(){
        TreeNode<Integer> node1 = new TreeNode<Integer>(1);
        TreeNode<Integer> node2 = new TreeNode<Integer>(2);
        TreeNode<Integer> node3 = new TreeNode<Integer>(3);
        TreeNode<Integer> node4 = new TreeNode<Integer>(4);
        TreeNode<Integer> node5 = new TreeNode<Integer>(5);
        TreeNode<Integer> node6 = new TreeNode<Integer>(6);
        TreeNode<Integer> node7 = new TreeNode<Integer>(7);
        TreeNode<Integer> node8 = new TreeNode<Integer>(8);
        TreeNode<Integer> node9 = new TreeNode<Integer>(9);

        node1.left = node2;
        node1.right = node3;

        node2.left = node4;
        node2.right = node5;

        node3.left = node6;
        node3.right = node7;

        node4.left = node8;

        node7.right = node9;

        Assert.assertTrue(BalancedTree.isBalanced(node1));
        Assert.assertTrue(BalancedTree.isBalanced2(node1) != -1);
    }

    @Test
    public void testUnBalanced(){
        TreeNode<Integer> node1 = new TreeNode<Integer>(1);
        TreeNode<Integer> node2 = new TreeNode<Integer>(2);
        TreeNode<Integer> node3 = new TreeNode<Integer>(3);
        TreeNode<Integer> node4 = new TreeNode<Integer>(4);
        TreeNode<Integer> node5 = new TreeNode<Integer>(5);
        TreeNode<Integer> node6 = new TreeNode<Integer>(6);
        TreeNode<Integer> node7 = new TreeNode<Integer>(7);
        TreeNode<Integer> node8 = new TreeNode<Integer>(8);
        TreeNode<Integer> node9 = new TreeNode<Integer>(9);
        TreeNode<Integer> node10 = new TreeNode<Integer>(10);

        node1.left = node2;
        node1.right = node3;

        node2.left = node4;
        node2.right = node5;

        node3.left = node6;
        node3.right = node7;

        node4.left = node8;

        node7.right = node9;

        node9.left = node10;

        Assert.assertFalse(BalancedTree.isBalanced(node1));
        Assert.assertFalse(BalancedTree.isBalanced2(node1) != -1);
    }

    public static void main(String[] args) {
        TreeNode<Integer> node1 = new TreeNode<Integer>(1);
        TreeNode<Integer> node2 = new TreeNode<Integer>(2);
        TreeNode<Integer> node3 = new TreeNode<Integer>(3);
        TreeNode<Integer> node4 = new TreeNode<Integer>(4);

        node1.left = node2;
        node1.right = node3;

        node2.left = node4;

        Tree tree = new Tree();
//        tree.preOrderRe(node1);
//        tree.postOrderRe(node1);
        tree.inOrderRe(node1);
        System.out.println();
//        tree.preOrder(node1);
        tree.inOrder(node1);
//        tree.postOrder(node1);

//        tree.levelOrder(node1);


    }
}
