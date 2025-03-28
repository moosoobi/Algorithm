package BOJ.JAVA.TwoPointer;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_2003_수들의합2 {
    public static void main(String[] args) throws IOException {
        int result=0;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int M = Integer.parseInt(input[1]);
        int[] arr= new int[N];
        input = br.readLine().split(" ");
        for(int i=0;i<N;i++) {
            arr[i] = Integer.parseInt(input[i]);
        }
        for (int i = 0; i < N; i++) {
            int sum=arr[i];
            int j=i;
            if(sum==M)result++;
            else{
                while(sum<M && j<N-1){
                    j++;
                    sum+=arr[j];
                    if(sum==M){result++;break;}
                    if(sum>M)break;
                }
            }
        }
        System.out.println(result);
    }
}
