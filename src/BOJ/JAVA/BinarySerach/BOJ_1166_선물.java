package BOJ.JAVA.BinarySerach;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1166_선물 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st= new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());
        int W = Integer.parseInt(st.nextToken());
        int H = Integer.parseInt(st.nextToken());

        double left=0;
        double mid;
        double max=Math.max(Math.max(W, L),H);
        double right=max;

        for(int i=0;i<=100;i++) {
            mid=(left+right)/2;
            long count =(long)(L/mid)*(long)(W/mid)*(long)(H/mid);
            if(count<N){right=mid;}
            else{left=mid;}

        }
        System.out.printf("%.10f\n", left);
    }
}