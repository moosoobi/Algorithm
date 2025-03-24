package BOJ.JAVA.DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_14501_퇴사 {
    public static int totalDay;
    public static int[] t;
    public static int[] p;
    public static int max = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 총 일 수 입력 받기
        totalDay = Integer.parseInt(br.readLine());

        // 배열 초기화
        t = new int[totalDay];
        p = new int[totalDay];

        // 상담 일정 입력 받기
        for (int i = 0; i < totalDay; i++) {
            String[] input = br.readLine().split(" ");
            t[i] = Integer.parseInt(input[0]);
            p[i] = Integer.parseInt(input[1]);
        }

        // DFS 탐색 시작
        dfs(0, 0);

        // 최대 수익 출력
        System.out.println(max);
    }

    // ✅ DFS 탐색 (현재 날짜, 현재 수익)
    public static void dfs(int day, int profit) {
        // ✅ 퇴사일을 넘긴 경우, 최대 수익 갱신 후 종료
        if (day >= totalDay) {
            max = Math.max(max,profit);
            return;
        }

        // ✅ 현재 날짜에서 상담을 진행하는 경우 (퇴사일을 초과하지 않는 경우)
        if (day + t[day] <= totalDay) {
            dfs(day + t[day], profit + p[day]); // 상담을 진행하고, t[day]일 후부터 탐색
        }

        // ✅ 현재 날짜에서 상담을 진행하지 않는 경우 (다음 날로 이동)
        dfs(day + 1, profit);
    }
}