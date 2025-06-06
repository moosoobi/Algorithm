package BOJ.JAVA.DFS;

import java.io.*;

public class BOJ_3085_사탕게임 {
    public static int n;
    public static char[][] board;

    public static int count(){
        int maxLen=1;
        int cnt=1;
        //각 열 검사
        for(int i=0;i<n;i++){
            cnt=1;
            for(int j=0;j<n-1;j++){
                if(board[i][j]==board[i][j+1]){
                    cnt+=1;
                }else {
                    if (maxLen < cnt) {
                        maxLen = cnt;
                        cnt = 1;
                    }
                }
            }
        }
        if(maxLen<cnt){
            maxLen=cnt;
            cnt=1;
        }
        for(int j=0;j<n;j++){
            cnt=1;
            for(int i=0;i<n-1;i++){
                if(board[i][j]==board[i+1][j]){
                    cnt+=1;
                }else{
                    if(maxLen<cnt){
                        maxLen=cnt;
                        cnt=1;
                    }
                }
            }
        }
        if(maxLen<cnt){
            maxLen=cnt;
            cnt=1;
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
