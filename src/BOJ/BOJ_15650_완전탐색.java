package BOJ;

import java.util.Scanner;

/*
자연수 N과 M이 주어졌을 때, 아래 조건을 만족하는 길이가 M인 수열을 모두 구하는 프로그램을 작성하시오.
- 1부터 N까지 자연수 중에서 M개를 고른 수열
- 같은 수열은 허용하지 않는다.
- 수열안에서 같은 숫자가 들어갈 수 없다.
*/
public class BOJ_15650_완전탐색 {
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
        //수열안 중복된 숫자는 제거
        for(int i=1;i<=N;i++){
            boolean isUsed=false;

            for(int j=0;j<depth;j++){
                if(i==sequence[j])isUsed=true;
            }
            if(!isUsed){
                sequence[depth]=i;
                dfs(depth+1, sequence);
            }

        }

    }
}
