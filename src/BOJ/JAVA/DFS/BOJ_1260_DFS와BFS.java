package BOJ.JAVA.DFS;

import java.io.*;
import java.util.*;

public class BOJ_1260_DFS와BFS {
    static boolean[] visited;
    static ArrayList<Integer>[] graph;
    public static void main(String args[])throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] parts = br.readLine().split(" ");
        int n = Integer.parseInt(parts[0]);
        int m = Integer.parseInt(parts[1]);
        int v = Integer.parseInt(parts[2]);

        graph= new ArrayList[n+1];
        visited= new boolean[n+1];
        for(int i=1;i<=n;i++){
            graph[i]=new ArrayList<>();
            visited[i]=false;
        }

        for(int i=0;i<m;i++){
            parts=br.readLine().split(" ");
            int a=Integer.parseInt(parts[0]);
            int b=Integer.parseInt(parts[1]);
            graph[a].add(b);
            graph[b].add(a);
        }

        for(int i=1;i<=n;i++){
            Collections.sort(graph[i]);
        }

        dfs(v);
        System.out.println();
        for(int i=1;i<=n;i++){
            visited[i]=false;
        }
        bfs(v);
    }
    public static void dfs(int v){
        System.out.print(v+" ");
        visited[v]=true;
        for(int next:graph[v]){
            if(visited[next]==false)dfs(next);
        }
    }
    public static void bfs(int v){
        visited[v]=true;
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(v);
        while(!queue.isEmpty()){
            int current=queue.poll();
            System.out.print(current+" ");
            for(int next:graph[current]){
                if(!visited[next]){
                    queue.offer(next);
                    visited[next]=true;
                }
            }
        }

    }

}
