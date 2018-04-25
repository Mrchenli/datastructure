package io.mrchenli.data.structure;

import java.util.Arrays;

/**
 * 时间复杂度nlogn 确定的值
 *
 * 是不稳定的
 */
public class HeapSort implements Sort {

    /**
     * 排序
     * @param target
     * @return
     */
    @Override
    public int[] sort(int[] target) {
       //1.build heap
        buildMaxHeap(target);
        //2.delete max
        for (int i=target.length-1;i>0;i--){
            swap(target,0,i);
            percDown(target,0,i-1);
        }
        return target;
    }

    /**
     * 建堆
     * @param target
     */
    public void buildMaxHeap(int[] target){
        int lastP = (target.length-1-1)>>1;
        for (int i =lastP;i>=0;i--){//从最后一个节点的父节点开始循环跳转 堆
            percDown(target,i,target.length-1);//当前节点和数组
        }
    }

    /**
     * 调整成最大堆
     * @param target
     * @param
     * @param
     */
    public void percDown(int[] target,int root,int length){
       //取出根节点
        int p,c;//根节点和值比较大的那个孩子节点
        int rootValue = target[root];
        for (p = root;p*2+1<=length;p=c){//进来就说明至少有左孩子
            c = p*2+1;
            if(c!=length&&target[c]<target[c+1]){//如果有右孩子 且右孩子大
                c++;//切到右孩子
            }//否则就是左孩子
            if(rootValue>=target[c]){//
                break;//如果根节点大 就结束
            }else {
                target[p]=target[c];//父节点和子节点交换
            }
        }
        target[p] = rootValue;
    }

    public void swap(int[] target,int i,int j){
        int tmp = target[i];
        target[i]= target[j];
        target[j] = tmp;
    }

    public static void main(String[] args) {
        int[] data = new int[]{3,2,1,5,6,4};
        Sort sort = new HeapSort();
        sort.sort(data);
        System.out.println(Arrays.toString(data));
    }

}
