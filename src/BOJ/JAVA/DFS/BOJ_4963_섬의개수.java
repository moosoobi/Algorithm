package BOJ.JAVA.DFS;

import java.io.*;
import java.util.*;
class BOJ_4963_섬의개수 {
    public static int[][] map;
    public static boolean[][] visited;
    public static int count;
    public static int n;
    public static int m;
    public static int[] dx={1,1,1,0,-1,-1,-1,0};
    public static int[] dy={1,0,-1,-1,-1,0,1,1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while(true){
            String[] parts=br.readLine().split(" ");
            n = Integer.parseInt(parts[0]);//행의 개수
            m = Integer.parseInt(parts[1]);//열의 개수
            if(n==0 && m==0){break;}
            map = new int[m][n];
            visited = new boolean[m][n];
            count=0;
            for(int i=0;i<m;i++){
                String[] input = br.readLine().split(" ");
                for(int j=0;j<n;j++){
                    visited[i][j]=false;
                    map[i][j]=Integer.parseInt(input[j]);
                }
            }

            for(int i=0;i<m;i++){
                for(int j=0;j<n;j++){
                    if(map[i][j]==1 && visited[i][j]==false){
                        dfs(i,j);
                        count+=1;
                    }
                }
            }
            System.out.println(count);
        }
    }
    public static int dfs(int x, int y){
        int size=1;
        visited[x][y]=true;
        for(int i=0;i<8;i++){
            if((x+dx[i])<m&&(y+dy[i])<n&&(x+dx[i])>=0&&(y+dy[i])>=0){
                if(map[x+dx[i]][y+dy[i]]==1 && visited[x+dx[i]][y+dy[i]]==false){
                    visited[x+dx[i]][y+dy[i]]=true;
                    size+=dfs((x+dx[i]),(y+dy[i]));
                }
            }

        }
        return size;
    }
}