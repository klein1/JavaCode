package Tree;

public interface ITree<T> {

    boolean isEmpty(TreeNode<T> p);

    int size(TreeNode<T> p);

    int depth(TreeNode<T> p);

    void clear(TreeNode<T> p);

    void nodeData(TreeNode<T> p);

    TreeNode<T> search(TreeNode<T> p, T x);

    void preOrder(TreeNode<T> p);

    void inOrder(TreeNode<T> p);

    void postOrder(TreeNode<T> p);

    void levelOrder(TreeNode<T> p);
}
