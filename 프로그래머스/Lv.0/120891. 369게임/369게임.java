class Solution {
    public int solution(int order) {
        
        String s = order+"";
        int answer = 0;
        
        for(int i = 0; i < s.length(); i++){
            if((s.charAt(i) - '0') % 3 == 0 && (s.charAt(i) - '0') != 0)
                answer++;
        }
        
        
        return answer;
    }
}