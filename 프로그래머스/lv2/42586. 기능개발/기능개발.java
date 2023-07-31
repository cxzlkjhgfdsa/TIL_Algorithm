import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        ArrayList<Integer> list = new ArrayList<>();
        int idx = 0;
        int size = progresses.length;
        while(idx < size){
            
            for(int i = idx; i<size; i++){
                progresses[i] += speeds[i];
            }            
            
            int cnt = success(progresses, idx);
            //System.out.println(cnt);
            if(cnt > 0){
                list.add(cnt);
                idx += cnt;
            }
            
        }
        
        int[] answer = new int[list.size()];
        for(int i = 0 ; i < list.size(); i++){
            answer[i] = list.get(i);
        }
        return answer;
    }
    
    public int success(int[] progresses, int idx){
        int cnt = 0;
        for(int i = idx; i< progresses.length; i++){
            if(progresses[i] >= 100){
                cnt++;
            }else{
                break;
            }
        }
        
        return cnt;
    }
}