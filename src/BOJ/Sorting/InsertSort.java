package BOJ.Sorting;

public class InsertSort {
    public static void main(String[] args) {
        int[]a = {2,8,3,5,4,2};
        InsertSort (a);
        for (int j : a) {
            System.out.print(j + " ");
        }
    }
    public static void InsertSort (int[]a){
        for(int i=0;i<a.length;i++){
            int index=i;
            for(int j=0;j<i;j++){
                if(a[i]<a[j]){swap(a,index,j);}
            }
        }
    }
    public static void swap(int[]a,int i,int j){
        int temp=a[i];
        a[i]=a[j];
        a[j]=temp;
    }
}
