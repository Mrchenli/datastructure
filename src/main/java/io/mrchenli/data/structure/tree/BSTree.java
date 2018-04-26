package io.mrchenli.data.structure.tree;

import java.util.Queue;
import java.util.Stack;
import java.util.concurrent.LinkedBlockingQueue;

public class BSTree<E extends Comparable> {

    private TreeNode<E> root;

    public TreeNode getRoot() {
        return root;
    }

    public BSTree() {
        this.root = null;
    }

    /**
     * 插入
     * 1.root 为空 root为插入值
     * 2.root不为空 root节点开始 如果当前节点大于插入值找左节点 若果当前节点小于插入值找右节点
     */
    public TreeNode insert(E key,TreeNode bst){
        if(bst==null){
            bst = new TreeNode(key);
            if(root==null){
                root = bst;
            }
        }else{
            if(key.compareTo(bst.value)<0){
                bst.left = insert(key,bst.left);
            }else if(key.compareTo(bst.value)>0){
                bst.right = insert(key,bst.right);
            }
        }
        return bst;
    }

    /**
     * insert is ok
     * @param key
     */
    public void insert(E key){
       insert(key,root);
    }


    /**
     * 尾递归查找 is ok
     * @param key
     * @param bst
     * @return
     */
    public TreeNode find(E key ,TreeNode bst){
        if(bst==null){
            return null;//查找失败
        }
        if(key.compareTo(bst.value)>0){
            return find(key,bst.right);
        }else if(key.compareTo(bst.value)<0){
            return find(key,bst.left);
        }else {
            return bst;
        }
    }

    public TreeNode find(E key){
        return find(key,root);
    }


    public TreeNode findIter(E key){
        return findIter(key,root);
    }


    public TreeNode findIter(E key ,TreeNode bst){
        while (bst!=null){
            if(key.compareTo(bst.value)>0){
                bst = bst.right;//去右子树里面去找
            }else if(key.compareTo(bst.value)<0){
                bst = bst.left;//左子树里面去找
            }else {
                return bst;//查找成功
            }
        }
        return null;//查找失败
    }


    public TreeNode findMin(TreeNode bst){
        if(bst==null){
            return null;
        }else if(bst.left==null){
            return bst;
        }else{
            return findMin(bst.left);
        }
    }

    public TreeNode findMin(){
        return findMin(root);
    }

    public TreeNode findMinIter(TreeNode bst){
        if(bst!=null){
            while (bst.left!=null){
                bst = bst.left;
            }
        }
        return bst;
    }

    public TreeNode findMinIter(){
        return findMinIter(root);
    }




    public TreeNode findMax(TreeNode bst){
        if(bst ==null){
            return null;
        }else if(bst.right == null){
            return bst;
        }else
            return findMax(bst.right);
    }

    public TreeNode findMax(){
        return findMax(root);
    }

    public TreeNode findMaxIter(TreeNode bst){
        if(bst!=null){
            while (bst.right!=null){
                bst = bst.right;
            }
        }
        return bst;
    }

    public TreeNode findMaxIter(){
        return findMaxIter(root);
    }



    /**
     * 每个节点遍历的时候都会碰到三次 第二次碰到的时候打印出来就是中序了
     * @param bst
     */
    private void inOrder(TreeNode bst){
        if(bst!=null){
            inOrder(bst.left);
            System.out.print(bst.value+" ");
            inOrder(bst.right);
        }
    }

    /**
     * 非递归的算法来实现中序遍历
     * @param bst
     */
    private void inOrderIter(TreeNode bst){
        TreeNode t  = bst;
        Stack<TreeNode> s = new Stack();
        while (t!=null||!s.empty()){
            while (t!=null){//left 走到最底部了
                s.push(t);
                t = t.left;
            }
            if(!s.empty()){//stack 不为空 弹出来
                t = s.pop();
                System.out.print(t.value+" ");
                t = t.right;
            }
        }
    }
    public void inOrder(boolean isIter){
        if(isIter){
            inOrderIter(root);
        }else{
            inOrder(root);
        }
        System.out.println();
    }


    private void preOrder(TreeNode bst){
        if(bst!=null){
            System.out.print(bst.value+" ");
            preOrderIter(bst.left);
            preOrderIter(bst.right);
        }
    }

    private void preOrderIter(TreeNode bst){
        TreeNode t = bst;
        Stack<TreeNode> s = new Stack<>();
        while (t!=null||!s.empty()){
            while (t!=null){
                System.out.print(t.value+" ");
                s.push(t);
                t = t.left;
            }
            if(!s.empty()){
                t = s.pop();
                t = t.right;
            }
        }
    }

    /**
     * 先序遍历
     * @param isIter
     */
    public void preOrder(boolean isIter){
        if(isIter){
            preOrderIter(root);
        }else{
            preOrder(root);
        }
        System.out.println();
    }


    private void postOrder(TreeNode bst){
        if(bst!=null){
            postOrder(bst.left);
            postOrder(bst.right);
            System.out.print(bst.value+" ");
        }
    }

    private void postOrderIter(TreeNode bst){
        TreeNode t = bst;
        Stack<TreeNode> s = new Stack();
        while (t!=null||!s.empty()){
            while (t!=null&&!t.flag){
                s.push(t);
                t = t.left;
            }
            if(!s.empty()){
                t = s.pop();
                if(!t.flag){
                    t.flag=true;
                    s.push(t);
                    t = t.right;
                }else {
                    System.out.print(t.value+" ");
                    t = null;
                }
            }
        }
    }

    /**
     * 后续遍历
     * @param isIter
     */
    public void postOrder(boolean isIter){
        if(isIter){
            postOrderIter(root);
        }else {
            postOrder(root);
        }
        System.out.println();
    }



    /**
     * 删除节点
     * step1.findNode
     * step2. delete
         1.如果是叶子节点直接就删除掉了
         2.如果只有一个子节点 引用指向子节点
         3.如果有2个子节点 左子树里面找一个最大 或者右字树里面找一个最小的
     * @param key
     * @return
     */
    public TreeNode delete(E key,TreeNode<E> bst){
        TreeNode<E> tmp;
        if(bst==null){
            System.out.println("要删除的元素未找到");
        }else if(key.compareTo(bst.value)>0){
            bst.right = delete(key,bst.right);
        }else if(key.compareTo(bst.value)<0){
            bst.left = delete(key,bst.left);
        }else{//找到了
            if(bst.left!=null&&bst.right!=null){//有2个子节点
                tmp = findMin(bst.right);//右子树里面找最小值
                bst.value = tmp.value;//用最小的值替换调当前值
                bst.right = delete(bst.value,bst.right);//删除右子树里最小节点
            }else{
                if(bst.left!=null){
                    bst = bst.left;
                }else if(bst.right!=null){
                    bst = bst.right;
                }else {
                    bst = null;
                }
            }
        }
        return bst;
    }

    public void delete(E key){
        delete(key,root);
    }
    private int height(TreeNode t){
        if(t!=null){
            int lh = height(t.left);
            int rh = height(t.right);
            int max=lh>rh?lh:rh;
            return max +1;
        }else {
            return 0;
        }
    }

    public int height(){
       return height(root)-1;
    }
    /**
     * 层序遍历 二叉树遍历其实是把一个二维结构 转换成一维结构
     *
     * 可以用队列来实现
     */
    public void levelOrder(){
        if(root==null) return;
        Queue<TreeNode> q = new LinkedBlockingQueue();
        q.add(root);
        while (!q.isEmpty()){
            TreeNode t = q.poll();
            System.out.print(t.value+" ");
            if(t.left!=null){
                q.add(t.left);
            }
            if(t.right!=null){
                q.add(t.right);
            }
        }
        System.out.println();
    }



    class TreeNode<E extends Comparable>{
        E value;
        TreeNode left;
        TreeNode right;
        boolean flag;//标识这个节点是否被访问过 在遍历的后序遍历中会有用


        public TreeNode(E value) {
            this.value = value;
        }
    }

}
