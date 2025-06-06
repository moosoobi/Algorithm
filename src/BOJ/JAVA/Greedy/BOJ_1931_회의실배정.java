package BOJ.JAVA.Greedy;

import java.io.*;
import java.util.*;


public class BOJ_1931_회의실배정 {
    public static void main(String[] args)throws IOException{
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(br.readLine());
        List<int[]> meetings = new ArrayList<>();
        for(int i=0;i<n;i++){
            String[] parts=br.readLine().split(" ");
            int a=Integer.parseInt(parts[0]);
            int b=Integer.parseInt(parts[1]);
            meetings.add(new int[]{a,b});
        }
        Collections.sort(meetings, new Comparator<int[]>(){
            @Override
            public int compare(int[]a, int[]b){
                if(a[1]==b[1]){
                    return Integer.compare(a[0],b[0]);
                }
                return Integer.compare(a[1],b[1]);
            }
        });
    }
}
