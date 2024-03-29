class Solution {
    public int[] solution(int[] prices) {
        
        int len = prices.length;
        
        int[] answer = new int[len];
        
        for(int i=0; i<len; i++){
            int cur = prices[i];
            int cnt = 0;
            for(int j=i+1; j<len; j++){
                if(cur > prices[j]){
                    cnt++;
                    break;
                }
                cnt++;
            }
            answer[i] = cnt;
        }
        
        
        return answer;
    }
}