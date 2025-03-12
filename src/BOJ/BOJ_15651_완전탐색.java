package BOJ;

import java.util.Scanner;

/*
자연수 N과 M이 주어졌을 때, 아래 조건을 만족하는 길이가 M인 수열을 모두 구하는 프로그램을 작성하시오.
- 1부터 N까지 자연수 중에서 M개를 고른 수열
- 같은 수를 여러 번 골라도 된다.
*/
public class BOJ_15651_완전탐색 {
    static int N, M;
    static StringBuilder result = new StringBuilder();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        N = scanner.nextInt(); // 1부터 N까지 선택 가능
        M = scanner.nextInt(); // 길이가 M인 수열 생성
        scanner.close();

        int[] sequence= new int[M];

        dfs(0,sequence);
        System.out.println(result);

    }

    static void dfs(int depth, int[] sequence) {
        // 종료 조건: M개의 숫자를 선택한 경우
        if(depth==M){
            for(int num: sequence){
                result.append(num).append(" ");
            }
            result.append("\n");
            return;
        }

        for(int i=1;i<=N;i++){
            sequence[depth]=i;
            dfs(depth+1, sequence);
        }

    }
}
