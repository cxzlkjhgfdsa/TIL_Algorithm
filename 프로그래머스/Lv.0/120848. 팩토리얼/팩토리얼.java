class Solution {
    public int solution(int n) {
        int answer = 0;
        
        int fact = 1;
        
        for(int i = 1; i <= 10; i++){
            
            fact = fact * i;
            
            if(fact <= n){
                answer = i;
            }
                    
        }
        
        return answer;
    }
}