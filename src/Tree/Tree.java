package Tree;

public class Tree<T> implements ITree<T> {

    @Override
    public boolean isEmpty(TreeNode<T> p) {
        return p == null;
    }

    @Override
    public int size(TreeNode<T> p) {
        return p != null ? size(p.left) + size(p.right) + 1 : 0;
    }

    @Override
    public int depth(TreeNode<T> p) {
        return p != null ? Math.max(depth(p.left), depth(p.right)) + 1 : 0;
    }

    @Override
    public void clear(TreeNode<T> p) {
        if(p != null){
            clear(p.left);
            clear(p.right);
            p = null;
        }
    }

    @Override
    public void nodeData(TreeNode<T> p) {
        System.out.printf("%s ", p.data);
    }

    @Override
    public TreeNode<T> search(TreeNode<T> p, T x) {
        TreeNode<T> r;
        if (p == null) {
            return null;
        }
        else{
            if(p.data.equals(x))
                return p;
            else{
                if((r = search(p.left, x)) != null)
                    return r;
                else if((r=search(p.right, x)) != null)
                    return r;
                else
                    return null;
            }
        }
    }

    @Override
    public void preOrder(TreeNode<T> p) {
        if (p != null){
            nodeData(p);
            preOrder(p.left);
            preOrder(p.right);
        }
    }

    @Override
    public void inOrder(TreeNode<T> p) {
        if (p != null){
            inOrder(p.left);
            nodeData(p);
            inOrder(p.right);
        }
    }

    @Override
    public void postOrder(TreeNode<T> p) {
        if (p != null) {
            postOrder(p.left);
            postOrder(p.right);
            nodeData(p);
        }
    }

    @Override
    public void levelOrder(TreeNode<T> p) {
        final int MAXLEN = 20;
        TreeNode<T>[] q = new TreeNode[MAXLEN];
        int head = 0, tail = 0;

        if(p != null){
            tail = (tail + 1) % MAXLEN;
            q[tail] = p;
        }
        while(head != tail){
            head = (head + 1) % MAXLEN;
            TreeNode<T> temp = q[head];
            nodeData(temp);
            if(temp.left != null){
                tail = (tail + 1) % MAXLEN;
                q[tail] = temp.left;
            }
            if(temp.right != null){
                tail = (tail + 1) % MAXLEN;
                q[tail] = temp.right;
            }
        }
    }
}
