import java.util.*;

class Solution {
    public int solution(int[] priorities, int location) {
        int answer = 0;
        int[] po = new int[10];
        Queue<Process> que = new ArrayDeque<>();
        int maxPo = 0;
        
        for(int i=0; i<priorities.length; i++){
            int p = priorities[i];
            po[p]++;
            maxPo = Math.max(maxPo, p);
            que.add(new Process(i, p));
        }
        
        while(!que.isEmpty()){
            Process p = que.poll();
            if(p.priority < maxPo){
                que.add(p);
                continue;
            }
            answer++;
            po[p.priority]--;
            if(po[p.priority] == 0){
                for(int i=9; i>=0; i--){
                    if(po[i]>0){
                        maxPo = i;
                        break;
                    }
                }
            }
            //System.out.println(p.idx + " : " + p.priority);
            if(p.idx == location){
                break;
            }
        }
        
        return answer;
    }
}

class Process{
    int idx;
    int priority;
    
    public Process(int idx, int priority){
        this.idx = idx;
        this.priority = priority;
        
    }
}