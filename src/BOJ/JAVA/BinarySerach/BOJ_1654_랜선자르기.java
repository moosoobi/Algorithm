package BOJ.JAVA.BinarySerach;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_1654_랜선자르기 {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int K = Integer.parseInt(input[0]);
        int N = Integer.parseInt(input[1]);

        int[] lan = new int[K];
        int max = 0;

        for(int i = 0; i < K; i++) {
            lan[i] = Integer.parseInt(br.readLine());
            if(max < lan[i]) max = lan[i];
        }

        long left = 1;
        long right = max;
        long result = 0;

        while(left <= right) {
            long mid = (left + right) / 2;
            long count = 0;

            for(int i = 0; i < K; i++) {
                count += lan[i] / mid;
            }

            if(count >= N) {
                result = mid;     // 가능한 답
                left = mid + 1;   // 더 큰 값도 될 수 있으니 오른쪽 탐색
            } else {
                right = mid - 1;  // 너무 많이 잘라서 개수가 부족 → 왼쪽으로
            }
        }

        System.out.println(result);
    }
}
