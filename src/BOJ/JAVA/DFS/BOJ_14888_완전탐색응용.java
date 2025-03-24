package BOJ.JAVA.DFS;

import java.util.Scanner;

/*
입력
    첫쨰 줄: N 숫자의 개수
    둘째 줄: 숫자들
    셋째 줄: 덧셈, 뺼셈, 나눗셈, 곱셈의 개수
출력
    숫자와 연산의 조합으로 나올 수 있는 최대, 최소
*/

public class BOJ_14888_완전탐색응용 {

    public static int MAX = Integer.MIN_VALUE;	// 최댓값
    public static int MIN = Integer.MAX_VALUE;	// 최솟값
    public static int[] operator = new int[4];	// 연산자 개수
    public static int[] number;					// 숫자
    public static int N;						// 숫자 개수

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        N = in.nextInt();
        number = new int[N];

        // 숫자 입력
        for (int i = 0; i < N; i++) {
            number[i] = in.nextInt();
        }

        // 연산자 입력
        for (int i = 0; i < 4; i++) {
            operator[i] = in.nextInt();
        }

        dfs(number[0], 1);

        System.out.println(MAX);
        System.out.println(MIN);

    }

    public static void dfs(int num, int idx) {
        if (idx == N) {
            MAX = Math.max(MAX, num);
            MIN = Math.min(MIN, num);
            return;
        }

        for (int i = 0; i < 4; i++) {
            // 연산자 개수가 1개 이상인 경우
            if (operator[i] > 0) {

                // 해당 연산자를 1 감소시킨다.
                operator[i]--;

                switch (i) {

                    case 0:	dfs(num + number[idx], idx + 1);	break;
                    case 1:	dfs(num - number[idx], idx + 1);	break;
                    case 2:	dfs(num * number[idx], idx + 1);	break;
                    case 3:	dfs(num / number[idx], idx + 1);	break;

                }
                // 재귀호출이 종료되면 다시 해당 연산자 개수를 복구한다.
                operator[i]++;
            }
        }
    }

}
