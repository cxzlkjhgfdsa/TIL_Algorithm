import java.util.*;

class Solution {
    public int solution(int[][] routes) {
        int answer = 0;
        ArrayList<Camera> list = new ArrayList<>();
        
        for(int [] arr : routes){
            list.add(new Camera(arr[0], arr[1]));
        }
        
        Collections.sort(list);
        
        int cur = -30001;
        
        for(int i = 0; i < list.size(); i++){
            Camera c = list.get(i);
            
            if(cur < c.min){
                cur = c.max;
                answer++;
            }else{
                cur = Math.min(c.max , cur);   
            }
        }
        
        return answer;
    }
}

class Camera implements Comparable<Camera>{
    int min, max;
    public Camera(int min, int max){
        this.min = min;
        this.max = max;
    }
    
    @Override
    public int compareTo(Camera c){
        if(this.min == c.min)
            return this.max - c.max;
        return this.min - c.min;
    }
}