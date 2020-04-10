package Tree;

public interface TTree<T> {

    boolean isEmpty(TreeNode<T> p);

    int size(TreeNode<T> p);

    int height(TreeNode<T> p);

    TreeNode<T> search(T x);

    void preOrder(TreeNode<T> p);

    void inOrder(TreeNode<T> p);

    void postOrder(TreeNode<T> p);

    void levelOrder(TreeNode<T> p);
}
