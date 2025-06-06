import java.io.*;

public class Main {
    public static int n;
    public static char[][] board;

    public static int count() {
        int maxLen = 1;  // 최소 길이는 1

        // 가로 방향 확인 (각 행에서)
        for (int i = 0; i < n; i++) {
            int cnt = 1;  // 각 행마다 새로 시작
            for (int j = 0; j < n - 1; j++) {
                if (board[i][j] == board[i][j + 1]) {
                    cnt++;
                } else {
                    maxLen = Math.max(maxLen, cnt);
                    cnt = 1;  // 연속이 끊기면 카운트 초기화
                }
            }
            maxLen = Math.max(maxLen, cnt);  // 마지막 연속 구간의 최대값 갱신
        }

        // 세로 방향 확인 (각 열에서)
        for (int i = 0; i < n; i++) {
            int cnt = 1;  // 각 열마다 새로 시작
            for (int j = 0; j < n - 1; j++) {
                if (board[j][i] == board[j + 1][i]) {
                    cnt++;
                } else {
                    maxLen = Math.max(maxLen, cnt);
                    cnt = 1;  // 연속이 끊기면 카운트 초기화
                }
            }
            maxLen = Math.max(maxLen, cnt);  // 마지막 연속 구간의 최대값 갱신
        }

        return maxLen;
    }

    public static void swap(int a, int b, int c){
        if(a==0){
            char temp=board[b][c];
            board[b][c]=board[b+1][c];
            board[b+1][c]=temp;
        }else{
            char temp=board[b][c];
            board[b][c]=board[b][c+1];
            board[b][c+1]=temp;
        }
    }

    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        board = new char[n][n];
        int max=0;
        int countResult=0;
        for(int i=0;i<n;i++){
            String input= br.readLine();
            for(int j=0;j<n;j++) {
                board[i][j] = input.charAt(j);
            }
        }

        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                countResult=count();
                if(max<countResult)max=countResult;
                if(i+1<n){
                    swap(0,i,j);
                    countResult=count();
                    if(max<countResult)max=countResult;
                    swap(0,i,j);
                }
                if(j+1<n){
                    swap(1,i,j);
                    countResult=count();
                    if(max<countResult)max=countResult;
                    swap(1,i,j);
                }
            }
        }
        System.out.print(max);
    }
}
