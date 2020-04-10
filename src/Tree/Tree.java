package Tree;

public class Tree<T> implements TTree<T>{

    @Override
    public boolean isEmpty(TreeNode<T> p) {
        return p == null;
    }

    @Override
    public int size(TreeNode<T> p) {
        return p != null ? size(p.left) + size(p.right) + 1 : 0;
    }

    @Override
    public int height(TreeNode<T> p) {
        return p != null ? Math.max(height(p.left), height(p.right)) + 1 : 0;
    }

    @Override
    public TreeNode<T> search(T x) {
        return null;
    }

    @Override
    public void preOrder(TreeNode<T> p) {
        if (p != null){
            System.out.print(p.data);
            preOrder(p.left);
            preOrder(p.right);
        }
    }

    @Override
    public void inOrder(TreeNode<T> p) {
        if (p != null){
            inOrder(p.left);
            System.out.print(p.data);
            inOrder(p.right);
        }
    }

    @Override
    public void postOrder(TreeNode<T> p) {
        if (p != null) {
            postOrder(p.left);
            postOrder(p.right);
            System.out.print(p.data);
        }
    }

    @Override
    public void levelOrder(TreeNode<T> p) {

    }
}
