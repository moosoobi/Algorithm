package BOJ.JAVA.SlidingWindow;

import java.io.*;


public class BOJ_2559 {
    public static void main(String args[]) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] parts= br.readLine().split(" ");
        int n=Integer.parseInt(parts[0]);
        int k=Integer.parseInt(parts[1]);
        parts = br.readLine().split(" ");
        int[] temp= new int[n];
        int sum=0;
        int max=0;
        for(int i=0;i<n;i++){
            temp[i]=Integer.parseInt(parts[i]);
        }
        for(int i=0;i<k;i++){
            sum+=temp[i];
            max=sum;
        }

        for(int i=k;i<n;i++){
            sum=sum-temp[i-k]+temp[i];
            if(max<sum){

                    max=sum;
            }
        }

        System.out.print(max);
    }
}
