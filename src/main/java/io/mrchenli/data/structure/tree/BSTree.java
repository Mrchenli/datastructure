package io.mrchenli.data.structure.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

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
        }else{
            if(key.compareTo(bst.value)<0){
                bst.left = insert(key,bst.left);
            }else if(key.compareTo(bst.value)>0){
                bst.right = insert(key,bst.right);
            }
        }
        return bst;
    }

    public void insert(E key){
       insert(key,root);
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
                tmp = bst;
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

    /**
     * 尾递归查找
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

    public TreeNode findMinIter(TreeNode bst){
        if(bst!=null){
            while (bst.left!=null){
                bst = bst.left;
            }
        }
        return bst;
    }

    public TreeNode findMax(TreeNode bst){
        if(bst ==null){
            return null;
        }else if(bst.right == null){
            return bst;
        }else
            return findMax(bst.right);
    }

    public TreeNode findMaxIter(TreeNode bst){
        if(bst!=null){
            while (bst.right!=null){
                bst = bst.right;
            }
        }
        return bst;
    }

    /**
     * 每个节点遍历的时候都会碰到三次 第二次碰到的时候打印出来就是中序了
     * @param bst
     */
    public void inOrder(TreeNode bst){
        if(bst!=null){
            inOrder(bst.left);
            System.out.println(bst.value);
            inOrder(bst.right);
        }
    }

    /**
     * 非递归的算法来实现中序遍历
     * @param bst
     */
    public void inOrderIter(TreeNode bst){
        TreeNode t  = bst;
        Stack<TreeNode> s = new Stack();
        while (t!=null||!s.empty()){
            while (t!=null){//left 走到最底部了
                s.push(t);
                t = t.left;
            }
            if(!s.empty()){//stack 不为空 弹出来
                t = s.pop();
                System.out.print(t.value);
                t = t.right;
            }
        }
    }


    public void preOrder(TreeNode bst){
        if(bst!=null){
            System.out.println(bst.value);
            preOrderIter(bst.left);
            preOrderIter(bst.right);
        }
    }


    public void preOrderIter(TreeNode bst){
        TreeNode t = bst;
        Stack<TreeNode> s = new Stack<>();
        while (t!=null||!s.empty()){
            while (t!=null){
                System.out.println(t.value);
                s.push(t);
                t = t.left;
            }
            if(!s.empty()){
                t = s.pop();
                t = t.right;
            }
        }
    }

    public void postOrder(TreeNode bst){
        if(bst!=null){
            postOrderIter(bst.left);
            postOrderIter(bst.right);
            System.out.print(bst.value+" ");
        }
    }

    public void postOrderIter(TreeNode bst){
        TreeNode t = bst;
        Stack<TreeNode> s = new Stack();
        while (t!=null||!s.empty()){

            while (t!=null){
                s.push(t);
                t = t.left;
            }
            if(!s.empty()){
                t = s.pop();
                t = t.right;
                if(t!=null) System.out.print(t.value+" ");
            }
        }
        System.out.println();
    }









    class TreeNode<E extends Comparable>{
        E value;
        TreeNode left;
        TreeNode right;

        public TreeNode(E value) {
            this.value = value;
        }
    }

}
