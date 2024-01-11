class Solution {
    public String solution(int age) {
        
        String sum = age+"";
        String answer = "";
        
        for(int i = 0; i < sum.length(); i++){
            int k = sum.charAt(i) - '0';
            
            answer += (char)(97+k);
        }    
    
        return answer;
    }
}