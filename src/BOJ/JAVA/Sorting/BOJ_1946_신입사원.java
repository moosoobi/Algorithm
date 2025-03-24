package BOJ.JAVA.Sorting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_1946_신입사원 {

    public static int[][] arr;
    public static int N;
    public static int count;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder(); // 출력 최적화

        int T = Integer.parseInt(br.readLine()); // 테스트 케이스 개수
        for (int i = 0; i < T; i++) {
            N = Integer.parseInt(br.readLine()); // 지원자 수
            arr = new int[N][2];

            for (int j = 0; j < N; j++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                arr[j][0] = Integer.parseInt(st.nextToken()); // 서류 등수
                arr[j][1] = Integer.parseInt(st.nextToken()); // 면접 등수
            }

            NewEmployee();
            sb.append(count).append("\n"); // 결과 저장 (출력 최적화)
        }

        System.out.print(sb); // 한 번에 출력
    }

    public static void NewEmployee() {
        count = 1;

        // 기존 버블 정렬 제거 -> Arrays.sort() 사용 (O(N log N))
        Arrays.sort(arr, (a, b) -> Integer.compare(a[0], b[0]));

        int min = arr[0][1]; // 첫 번째 지원자의 면접 등수

        for (int j = 1; j < N; j++) {
            if (arr[j][1] < min) { // 면접 등수가 더 낮은 경우
                min = arr[j][1];
                count++;
            }
        }
    }
}
