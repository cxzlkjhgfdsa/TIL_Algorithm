class Solution {
    public int solution(int n, int[] stations, int w) {
        int answer = 0;
        int size = w*2 + 1;
        
        answer += cal (1, stations[0] - w - 1, size);
        
        for(int i = 1; i < stations.length; i++){
            answer += cal(stations[i-1] + w + 1 , stations[i] - w - 1, size);
        }
        
        answer += cal(stations[stations.length - 1] + w + 1 , n , size);
        
        
        return answer;
    }
    
    private int cal(int start, int end, int size){
        int sum = end - start + 1;
        
        if(sum <= 0){
            return 0;
        }
        
        if(sum % size == 0){
            return sum / size;
        }else{
            return sum / size + 1;
        }
    }
}