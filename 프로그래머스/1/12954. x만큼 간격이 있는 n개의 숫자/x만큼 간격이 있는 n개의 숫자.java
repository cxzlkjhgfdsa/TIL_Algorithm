class Solution {
    public long[] solution(int x, int n) {
        long[] answer = new long[n];
        
        long idx = x;
        long k = x;        
        
        for(int i = 0; i < n; i++){
            answer[i] = idx;
            idx += k;
        }
        
        
        
        return answer;
    }
}