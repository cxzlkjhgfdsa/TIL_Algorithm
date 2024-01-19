import java.util.*;

class Solution {
    public int solution(int[] array) {
        int answer = 0;
        
        Map<Integer , Integer> map = new TreeMap<>();
        
        for(int k : array){
            if(map.get(k) != null){
                map.put(k, map.get(k)+1);
            }else{
                map.put(k, 1);
            }
        }
        
        PriorityQueue<Num> pq = new PriorityQueue<>();
        
        for(int key : map.keySet()){
            pq.add(new Num(key, map.get(key)));
        }
        
        Num n = pq.poll();
        
        answer = n.n;
        
        if(pq.size()>0){
            if(n.idx == pq.peek().idx)
                answer = -1;
        }
        
        
        
        return answer;
    }
}

class Num implements Comparable<Num>{
    int n, idx;
    
    public Num(int n , int idx){
        this.n = n;
        this.idx = idx;
    }
    @Override
    public int compareTo(Num o){
        return o.idx - this.idx;
    }
}