package BOJ.JAVA.DFS;

import java.io.*;
import java.util.*;

public class BOJ_2606_바이러스{
    public static int count=0;
    public static boolean[] visit;
    public static ArrayList<Integer>[] a;

    public static void dfs(int v){
        visit[v]=true;
        for(int next:a[v]){
            if(visit[next]==false){
                visit[next]=true;
                count+=1;
                dfs(next);
            }
        }
    }

    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int k = Integer.parseInt(br.readLine());
        visit=new boolean[n+1];
        a=new ArrayList[n+1];
        for(int i=0;i<=n;i++){
            a[i]=new ArrayList<>();
            visit[i]=false;
        }
        for(int i=0;i<k;i++){
            String[] parts=br.readLine().split(" ");
            int u=Integer.parseInt(parts[0]);
            int v=Integer.parseInt(parts[1]);
            a[u].add(v);
            a[v].add(u);
        }
        dfs(1);
        System.out.println(count);
    }
}
