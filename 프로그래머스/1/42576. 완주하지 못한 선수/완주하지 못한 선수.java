import java.util.*;
import java.io.*;

class Solution {
    public String solution(String[] participant, String[] completion) {            
        String answer = "";
        Map<String,Integer> map = new HashMap<>();
        for(int i=0;i<participant.length;i++){
            if(map.containsKey(participant[i])){
                int a=map.remove(participant[i]);
                map.put(participant[i],a+1);
            }else{map.put(participant[i],1);}
        }
        for(int i=0;i<completion.length;i++){
            int b= map.remove(completion[i])-1;
            if(b>0){map.put(completion[i],b);}
        }
        for(String next:map.keySet()){
            answer+=next;
        }
        return answer;
    }
}