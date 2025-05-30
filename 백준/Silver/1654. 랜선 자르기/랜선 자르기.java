
import java.io.*;
import java.util.Arrays;

public class Main{

    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] parts = br.readLine().split(" ");
        int k=Integer.parseInt(parts[0]);
        int n=Integer.parseInt(parts[1]);
        int[] lan=new int[k];
        long max=0;
        long result=0;
        for(int i=0;i<k;i++){
            lan[i]=Integer.parseInt(br.readLine());
            if(max<lan[i]){max=lan[i];}
        }
        long left=1;
        long right=max;


        while(left<=right){
            long count=0;
            long mid = (left+right)/2;
            for(int i=0;i<k;i++){
                count+=lan[i]/mid;
            }
            if(count>=n){
                result=mid;
                left=mid+1;
            }else{
                right=mid-1;
            }
        }
        System.out.println(result);

    }
}