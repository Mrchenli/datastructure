package io.mrchenli.data.structure;

/**
 * T=O(n)-O(n2)
 *
 * 稳定的
 *
 * 逆序对 插入排序和冒泡排序一次都是移动一个逆序对
 *
 */
public class InsertSort implements Sort {

    @Override
    public int[] sort(int[] target) {
        int length = target.length;
        for (int p=1;p<length;p++){//当前摸到那张牌
            //摸一张牌
            int tmp = target[p];
            int i;
            for (i=p;i>0&&target[i-1]>tmp;i--){//排序
                target[i]= target[i-1];//挪位置
            }
            target[i]=tmp;//落牌
        }
        return target;
    }



}
