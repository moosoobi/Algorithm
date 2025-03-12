package BOJ;

import java.util.Scanner;
/*
    두 정수를 입력받아 합을 출력하는 프로그램입니다.
*/
public class BOJ_1000_더하기 {


    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        int A = in.nextInt();
        int B = in.nextInt();

        System.out.println(A+B);

        in.close();
    }

}
