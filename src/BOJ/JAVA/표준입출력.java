package BOJ.JAVA;

import java.io.*;

public class 표준입출력 {
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        String[] parts= br.readLine().split(" "); 한줄 숫자 입력 방법
//        int[] arr =new int[parts.length];
//        for(int i=0;i<arr.length;i++) {
//            arr[i]=Integer.parseInt(parts[i]);
//        }


//         String str= br.readLine(); 한줄 전체 입력 방법
//         String[] arr = br.readLine().split(" "); 공백 기준 문자열 배열

        String[] parts= br.readLine().split(" ");
        int m = Integer.parseInt(parts[0]);
        int n = Integer.parseInt(parts[1]);

        int[][] map = new int[m][n];

        for(int i=0;i<m;i++){
            String[] parts1 = br.readLine().split(" ");
            for(int j=0;j<n;j++){
                map[i][j]=Integer.parseInt(parts1[j]);
            }
        }

        System.out.println("입력된 배열:");
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println(); // 줄 바꿈
        }

    }
}
