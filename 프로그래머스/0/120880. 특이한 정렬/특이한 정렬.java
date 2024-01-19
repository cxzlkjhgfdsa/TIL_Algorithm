import java.util.*;

class Solution {
    public int[] solution(int[] numlist, int n) {
        int[] answer = new int[numlist.length];
        
        PriorityQueue<Num> pq = new PriorityQueue<>();
        
        
        for(int next : numlist){
            pq.add(new Num(next, Math.abs(next-n)));
        }
        
        for(int i = 0; i < numlist.length; i++){
            answer[i] = pq.poll().n;
        }                
        
        
        return answer;
    }
}

class Num implements Comparable<Num>{
    int n, dis;
    public Num(int n, int dis){
        this.n = n;
        this.dis = dis;
    }
    
    @Override
    public int compareTo(Num o){
        if(this.dis == o.dis)
            return o.n-this.n;
        return this.dis - o.dis; 
    }
}