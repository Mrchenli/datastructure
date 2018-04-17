package io.mrchenli.data.structure;

import java.util.Arrays;

public class BubbleSort implements Sort {

    @Override
    public int[] sort(int[] target) {

        for (int i=0;i<target.length-1;i++){
            boolean sorted =true;
            for (int j=0;j<target.length-1-i;j++){
                if(target[j]>target[j+1]){
                    swap(target,j,j+1);
                    sorted = false;
                }
            }
            if (sorted) break;
        }
        return target;
    }

    public void swap(int[] target,int i,int j){
        int tmp = target[i];
        target[i]= target[j];
        target[j]= tmp;
    }

    public static void main(String[] args) {
        int[] data = new int[]{12,1,9,22,24,7,34,36,91};
        Sort sort = new BubbleSort();
        sort.sort(data);
        System.out.println(Arrays.toString(data));
    }

}
