package BOJ.JAVA.Sorting;

import java.io.*;
import java.util.*;

public class BOJ_1764_듣보잡 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        Set<String> unheard = new HashSet<>(); // 듣도 못한 사람 저장
        List<String> result = new ArrayList<>(); // 교집합 저장

        for (int i = 0; i < N; i++) {
            unheard.add(br.readLine()); // 듣도 못한 사람을 HashSet에 저장
        }

        for (int i = 0; i < M; i++) {
            String name = br.readLine();
            if (unheard.contains(name)) { // HashSet에서 찾기 (O(1))
                result.add(name);
            }
        }

        Collections.sort(result); // 사전순 정렬 (O(K log K), K = 교집합 크기)

        sb.append(result.size()).append("\n");
        for (String name : result) {
            sb.append(name).append("\n");
        }

        System.out.print(sb); // 한 번에 출력
    }
}
