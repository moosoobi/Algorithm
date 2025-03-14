package BOJ.DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2630_색종이만들기 {
    public static int white=0;
    public static int blue=0;
    public static Integer[][] color;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Integer N = Integer.parseInt(br.readLine());
        color = new Integer[N][N];
        for (int i=0; i<N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++){
                color[i][j]=Integer.parseInt(st.nextToken());
            }
        }

        Partition(0,0,N);
        System.out.println(white);
        System.out.println(blue);
    }

    public static void Partition(int cols,int rows, int N){
        if(colorCheck(cols, rows, N)==true){
            if(color[cols][rows]==0){white++;}
            else{blue++;}

        }else{
            Partition(cols,rows,N/2);
            Partition(cols+N/2,rows,N/2);
            Partition(cols,rows+N/2,N/2);
            Partition(cols+N/2,rows+N/2,N/2);
        }
    }

    public static boolean colorCheck(int cols, int rows, int N){
        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                if(color[cols+i][rows+j]!=color[cols][rows]){return false;}
            }
        }
        return true;
    }
}


