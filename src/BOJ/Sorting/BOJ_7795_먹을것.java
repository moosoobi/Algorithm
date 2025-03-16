package BOJ.Sorting;

import java.io.*;
import java.util.*;

public class BOJ_7795_먹을것 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken()); // A의 크기
            int M = Integer.parseInt(st.nextToken()); // B의 크기

            int[] A = new int[N];
            int[] B = new int[M];

            // A 입력 받기
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                A[i] = Integer.parseInt(st.nextToken());
            }

            // B 입력 받기
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < M; i++) {
                B[i] = Integer.parseInt(st.nextToken());
            }

            // **B 배열 정렬 (이분 탐색을 위해)**
            Arrays.sort(B);

            int count = 0;
            for (int i = 0; i < N; i++) {
                count += lowerBound(B, A[i]);
            }

            sb.append(count).append("\n");
        }

        System.out.print(sb); // 한 번에 출력
    }

    // **이분 탐색을 사용한 lowerBound 구현**
    public static int lowerBound(int[] arr, int key) {
        int left = 0, right = arr.length;

        while (left < right) {
            int mid = (left + right) / 2;
            if (arr[mid] < key) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        return left; // key보다 작은 원소 개수 반환
    }
}
