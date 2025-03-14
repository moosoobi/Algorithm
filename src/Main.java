public class Main {
    public static void main(String[] args) {

        int[]a=new int[10];

        a[0]=1;
        point(a);
        System.out.println(a[0]);

    }
    public static void point(int[] a){
        a[0]=0;
        point2(a);

    }
    public static void point2(int[] a){
        a[0]=-1;
    }
}