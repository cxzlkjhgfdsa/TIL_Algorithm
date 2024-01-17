class Solution {
    public int solution(int i, int j, int k) {
        int answer = 0;
        
        for(int num = i; num <= j; num++){
            String check = num+"";
            
            for(int s = 0; s < check.length(); s++){
                if(check.charAt(s)-'0' == k)
                    answer++;
            }
        }
        
        return answer;
    }
}