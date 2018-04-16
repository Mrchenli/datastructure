package io.mrchenli.data.structure;

/**
 * 交换排序中的快速排序，目前应用最广泛的排序算法，是一个递归算法
 *
 * 快速排序包括2个过程：选定主元 和 确定主元位置
 * 时间复杂度 ：O(nlgn) O(n^2)
 * 最好情况是每次主元在中间，a(n)=n+2a(n/2)==>a(n)=O(nlogn)
 * 最坏情况 ：比如排序好的序列 n+n-1+n-2+...1=O(n^2)
 * 空间复杂度：O(logn) O(n)
 *
 * 稳定性: 不稳定
 *
 * 内部排
 *
 */
public class QuickSort {


    public static int[] quickSort(int[] target,int left,int right){
        int pivot = median3(target,left,right);

        return null;
    }


    public static int median3(int[] target,int left,int right){
        int median = (left+right)>>1;
        if(target[left]>target[median]) swap(target,left,median);
        if(target[left]>target[right]) swap(target,left,right);
        if(target[median]<target[right]) swap(target,left,right);
        swap(target,median,right-1);
        return target[right-1];
    }


    public static  void  swap(int[] target ,int left,int right){
        int tmp = target[left];
        target[left] = target[right];
        target[right] = tmp;
    }



    public static void main(String[] args) {

    }


}
