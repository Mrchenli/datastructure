package io.mrchenli.data.structure.tree;

import org.junit.Before;
import org.junit.Test;

public class BSTreeTest {

    BSTree bsTree;

    @Before
    public void createBst(){
        bsTree = new BSTree<Integer>();
        bsTree.insert(10);
        bsTree.insert(11);
        bsTree.insert(8);
        bsTree.insert(3);
        bsTree.insert(20);
        bsTree.insert(23);
        bsTree.insert(9);
    }

    @Test
    public void testFind(){
        BSTree.TreeNode node = bsTree.find(10);
        System.out.println(node.value);
        System.out.println(bsTree.findIter(20).value);
    }

    @Test
    public void testFindMax(){
        System.out.println(bsTree.findMax().value);
        System.out.println(bsTree.findMaxIter().value);
    }

    @Test
    public void testFindMin(){
        System.out.println(bsTree.findMin().value);
        System.out.println(bsTree.findMinIter().value);
    }

    /**
     * allRight in order is ok
     */
    @Test
    public void testInOrder(){
        bsTree.inOrder(true);
        System.out.println("*************");
        bsTree.inOrder(false);
    }

    /**
     * 先序遍历
     */
    @Test
    public void testPreOrder(){
        bsTree.preOrder(true);
        bsTree.preOrder(false);
    }

    /**
     * 后续遍历
     */
    @Test
    public void testPostOrder(){
        bsTree.postOrder(false);
        bsTree.postOrder(true);
    }

    /**
     * 层序遍历
     */
    @Test
    public void testLevelOrder(){

    }
    /**
     * 删除
     */
    @Test
    public void testDelete(){

    }

}
