package BOJ.JAVA.Sorting;

public class SelectSort {
    public static void main(String[] args) {
        int[]a = {2,8,3,5,4,2};
        SelectSort (a);
        for (int j : a) {
            System.out.print(j + " ");
        }
    }
    public static void SelectSort (int[]a){
        int min;
        int index;
        for(int i=0;i<a.length-1;i++) {
            min=a[i];
            index=i;
            for(int j=i+1;j<a.length;j++) {
                if(min>a[j]){
                    min=a[j];
                    index=j;
                }
            }
            swap(a,index,i);
        }

    }
    public static void swap(int[]a,int i,int j){
        int temp=a[i];
        a[i]=a[j];
        a[j]=temp;
    }
}

