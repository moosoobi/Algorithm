package BOJ.DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class BOJ_1987_알파벳 {

    public static char[][] arr; // ✅ String[][] -> char[][] 변경
    public static int[] dx = {-1, 1, 0, 0};
    public static int[] dy = {0, 0, -1, 1};
    public static Set<Character> set = new HashSet<>(); // ✅ Set<String> -> Set<Character> 변경
    public static int max = 0; // 최대값 저장 변수

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int R = Integer.parseInt(input[0]);
        int C = Integer.parseInt(input[1]);

        arr = new char[R][C];

        // ✅ 입력을 char[][] 배열에 저장
        for (int i = 0; i < R; i++) {
            String line = br.readLine();
            for (int j = 0; j < C; j++) {
                arr[i][j] = line.charAt(j);
            }
        }

        // ✅ DFS 탐색 시작
        set.add(arr[0][0]); // 첫 번째 문자 추가
        dfs(0, 0, 1); // count를 매개변수로 전달

        // ✅ 최대값 출력
        System.out.println(max);
    }

    public static void dfs(int row, int col, int count) {
        max = Math.max(max, count); // ✅ 매번 DFS 실행 시 최대값 갱신

        // 4방향 탐색
        for (int i = 0; i < 4; i++) {
            int newRow = row + dx[i];
            int newCol = col + dy[i];

            if (isValid(newRow, newCol)) {
                set.add(arr[newRow][newCol]); // 방문한 문자 추가
                dfs(newRow, newCol, count + 1); // 다음 DFS 호출
                set.remove(arr[newRow][newCol]); // ✅ 백트래킹 (방문했던 문자 제거)
            }
        }
    }

    public static boolean isValid(int row, int col) {
        return row >= 0 && row < arr.length &&
                col >= 0 && col < arr[0].length &&
                !set.contains(arr[row][col]); // 방문하지 않은 알파벳인지 확인
    }
}
