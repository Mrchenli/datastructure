package io.mrchenli.data.structure;

import java.util.Arrays;

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
public class QuickSort implements Sort{

    private final int CUT_OFF = 4;

    public int[] quickSort(int[] target,int left,int right){
        if(right-left+1>CUT_OFF){
            int pivot = median3(target,left,right);
            int i = left;
            int j = right -1;
            for (;;){
                while (target[++i]<pivot){}//左边移动
                while (target[--j]>pivot){}//右边移动
                if (i<j){//没有结束就交换
                    swap(target,i,j);
                }else{//结束了 就跳出循环
                    break;
                }
            }
            swap(target,i,right-1);//把主元调到正确的位置
            quickSort(target,left,i-1);
            quickSort(target,i+1,right);
        }else{
            insertSort(target,left,right);
        }
        return target;
    }

    public int median3(int[] target,int left,int right){
        int median = (left+right)>>1;
        if(target[left]>target[median]) swap(target,left,median);
        if(target[left]>target[right]) swap(target,left,right);
        if(target[median]>target[right]) swap(target,median,right);
        swap(target,median,right-1);
        return target[right-1];
    }

    public void  swap(int[] target ,int left,int right){
        int tmp = target[left];
        target[left] = target[right];
        target[right] = tmp;
    }

    public void sort2(int[] target ,int left,int right){
        if(target[left]>target[right]) swap(target,left,right);
    }

    public void  insertSort(int[] target,int left,int right){
        for (int p =left+1;p<=right;p++){
            //起一张牌
            int tmp = target[p];
            int i ;
            for (i=p;i>left&&target[i-1]>tmp;i--){
                target[i]= target[i-1];//挪位置
            }
            target[i]= tmp;//落牌
        }
    }


    @Override
    public int[] sort(int[] target) {
        return quickSort(target,0,target.length-1);
    }

    public static void main(String[] args) {
        int[] data = new int[]{12,1,9,22,24,7,34,36,91};
        Sort sort = new QuickSort();
        sort.sort(data);
        System.out.println(Arrays.toString(data));
    }

}
