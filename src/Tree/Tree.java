package Tree;

import java.util.LinkedList;
import java.util.Stack;

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

    public void preOrderRe(TreeNode<T> p) {//非递归实现
        Stack<TreeNode<T>> stack = new Stack<>();
        while (p != null || !stack.isEmpty()) {
            while (p != null) {
                nodeData(p);
                stack.push(p);
                p = p.left;
            }
            if (!stack.isEmpty()) {
                p = stack.pop();
                p = p.right;
            }
        }
    }

    public void inOrderRe(TreeNode<T> p) {//非递归实现
        Stack<TreeNode<T>> stack = new Stack<>();
        while (p != null || !stack.isEmpty()) {
            while (p != null) {
                stack.push(p);
                p = p.left;
            }
            if (!stack.isEmpty()) {
                p = stack.pop();
                nodeData(p);
                p = p.right;
            }
        }
    }

    public void postOrderRe(TreeNode<T> p){//后序遍历非递归实现
        int left = 1;//在辅助栈里表示左节点
        int right = 2;//在辅助栈里表示右节点
        Stack<TreeNode<T>> stack = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();//辅助栈，用来判断子节点返回父节点时处于左节点还是右节点

        while(p != null || !stack.empty())
        {
            while(p != null) {//将节点压入栈1，并在栈2将节点标记为左节点
                stack.push(p);
                stack2.push(left);
                p = p.left;
            }

            while(!stack.empty() && stack2.peek() == right) {//如果是从右子节点返回父节点，则任务完成，将两个栈的栈顶弹出
                stack2.pop();
                nodeData(stack.pop());
            }

            if(!stack.empty() && stack2.peek() == left) {//如果是从左子节点返回父节点，则将标记改为右子节点
                stack2.pop();
                stack2.push(right);
                p = stack.peek().right;
            }
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

    public void levelOrderLinked(TreeNode<T> p) {//层次遍历
        if(p == null)
            return;
        LinkedList<TreeNode> list = new LinkedList<>();
        list.add(p);
        TreeNode currentNode;
        while(!list.isEmpty()) {
            currentNode = list.poll();
            nodeData(currentNode);
            if(currentNode.left != null)
                list.add(currentNode.left);
            if(currentNode.right != null)
                list.add(currentNode.right);
        }
    }
}
