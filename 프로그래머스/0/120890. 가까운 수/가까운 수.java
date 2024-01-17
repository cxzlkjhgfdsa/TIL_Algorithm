class Solution {
    public int solution(int[] array, int n) {
        int answer = 0;
        int close = 200;
        
        for(int i : array){
            if(close > Math.abs(i - n)){
                close = Math.abs(i-n);
                answer = i;
            }else if(close == Math.abs(i - n)){
                answer = Math.min(answer, i);
            }
                
        }
        
        return answer;
    }
}