
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static int[][] map;
    public static int[][] result;
    public static boolean[][] visited;
    public static int n;
    public static int m;
    public static int[] dx={1,0,-1,0};
    public static int[] dy={0,-1,0,1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] parts=br.readLine().split(" ");
        n = Integer.parseInt(parts[0]);
        m = Integer.parseInt(parts[1]);
        map = new int[n][m];
        result = new int[n][m];
        visited = new boolean[n][m];
        for(int i=0;i<n;i++){
            String[] input = br.readLine().split("");
            for(int j=0;j<m;j++){
                visited[i][j]=false;
                map[i][j]=Integer.parseInt(input[j]);
                result[i][j]=Integer.MAX_VALUE;
            }
        }
        result[0][0]=1;
        dfs(0,0);
        System.out.println(result[n-1][m-1]);

    }
    public static void dfs(int x, int y){
        visited[x][y]=true;
        for(int i=0;i<4;i++) {
            int nx=x+dx[i];
            int ny=y+dy[i];
            if (nx < n && ny < m && nx >= 0 && ny >= 0) {
                if (map[nx][ny] == 1 && result[nx][ny]>result[x][y]+1) {
                    visited[nx][ny] = true;
                    result[nx][ny]=result[x][y]+1;
                    dfs(nx,ny);
                }
            }
        }
    }
}
