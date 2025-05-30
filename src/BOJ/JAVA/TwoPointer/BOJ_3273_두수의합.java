package BOJ.JAVA.TwoPointer;

import java.io.*;
import java.util.*;

public class BOJ_3273_두수의합 {
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(br.readLine());
        int[] a=new int[n];
        String[] parts=br.readLine().split(" ");
        for(int i=0;i<n;i++){
            a[i]=Integer.parseInt(parts[i]);
        }
        int x=Integer.parseInt(br.readLine());
        int left=0;
        int right=a.length-1;
        int result=0;
        Arrays.sort(a);
        while(left<right){
            int sum=a[left]+a[right];
            if(sum==x){result+=1;left+=1;}
            else if(sum<x){left+=1;}
            else{right-=1;}
        }
        System.out.println(result);
    }
}
