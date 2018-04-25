package io.mrchenli.data.structure.tree;

import org.junit.Before;
import org.junit.Test;

public class BSTreeTest {

    BSTree bsTree;

    @Before
    public void testCreateBst(){
        bsTree = new BSTree<Integer>();
        bsTree.inOrder(bsTree.getRoot());
        bsTree.insert(10);
        bsTree.insert(11);
        bsTree.insert(8);
        bsTree.insert(3);
        bsTree.insert(20);
        bsTree.insert(23);
        bsTree.postOrder(bsTree.getRoot());
    }

    @Test
    public void testFind(){
        BSTree.TreeNode node = bsTree.find(10);
        System.out.println();
        System.out.println(node.value);
    }

    @Test
    public void testFindMax(){

    }

    @Test
    public void testFindMin(){

    }

    @Test
    public void testAdd(){

    }

    @Test
    public void testDelete(){

    }

    @Test
    public void testInOrder(){

    }

    @Test
    public void testInOrderIterator(){

    }

    @Test
    public void testPreOrder(){

    }

    @Test
    public void testPreOrderIterator(){

    }

    @Test
    public void testPostOrder(){

    }

    @Test
    public void testPostOrderIterator(){

    }

}
