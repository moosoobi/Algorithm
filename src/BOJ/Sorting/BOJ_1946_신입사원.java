package BOJ.Sorting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_1946_신입사원 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T= Integer.parseInt(br.readLine());
        int N;
        int[][] arr;
        for (int i=0; i<T; i++){
            N= Integer.parseInt(br.readLine());
            arr=new int[N][2];
            for (int j=0; j<N; j++){
                br.readLine().split(" ");
            }
        }
    }
}
