package BOJ.Sorting;

import java.lang.reflect.Array;

public class BubbleSort {
    public static void main(String[] args) {
        int[]a = {2,8,3,5,4,2};
        BubbleSort (a);
        for (int j : a) {
            System.out.print(j + " ");
        }
    }
    public static void BubbleSort (int[]a){
        for(int j=0;j<a.length-1;j++) {
            for (int i = 0; i < a.length - 1; i++) {
                if (a[i] > a[i + 1]) swap(a, i, i + 1);
            }
        }

    }
    public static void swap(int[]a,int i,int j){
        int temp=a[i];
        a[i]=a[j];
        a[j]=temp;
    }
}

