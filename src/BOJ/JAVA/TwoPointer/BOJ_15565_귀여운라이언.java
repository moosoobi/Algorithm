package BOJ.JAVA.TwoPointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_15565_귀여운라이언 {
    public static void main(String[] args) throws IOException {
        int result=0;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int M = Integer.parseInt(input[1]);
        int[] dolls= new int[N];
        input = br.readLine().split(" ");
        for(int i=0;i<N;i++) {
            dolls[i] = Short.parseShort(input[i]);
        }
        int left=0;
        int right=0;
        int lioncount=dolls[0] == 1 ? 1:0;
        int minLength = Integer.MAX_VALUE;

        while(left<=right&&right<N){
            if(lioncount<minLength){
                right++;
            }
        }
        System.out.println(result);
    }
}
