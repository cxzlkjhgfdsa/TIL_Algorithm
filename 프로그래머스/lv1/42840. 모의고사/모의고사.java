import java.util.*;

class Solution {
    int[] one = {1,2,3,4,5};
    int[] two = {2,1,2,3,2,4,2,5};
    int[] three = {3,3,1,1,2,2,4,4,5,5};
    
    public int[] solution(int[] answers) {
        int[] score = new int[3];
        for(int i = 0; i< answers.length; i++){
            if(one[i%5] == answers[i]){
                score[0]++;
            }
            if(two[i%8] == answers[i]){
                score[1]++;
            }
            if(three[i%10] == answers[i]){
                score[2]++;
            }
        }
        
        int max = 0;
        for(int n : score){
            max = Math.max(n, max);
        }
        Queue<Integer> que = new ArrayDeque();
        for(int i=0; i<3; i++){
            if(score[i] == max){
                que.offer(i+1);
            }
        }
        int[] answer = new int[que.size()];
        int idx = 0;
        while(!que.isEmpty()){
            answer[idx] = que.poll();
            idx++;
        }
        return answer;
    }
}