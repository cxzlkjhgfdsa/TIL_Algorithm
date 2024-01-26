class Solution {
    public int[] solution(long n) {
        
        String[] s = (n+"").split("");
        
        int[] answer = new int[s.length];
        
        int idx = 0;
        
        for(int i = s.length-1; i >= 0; i--){
            answer[idx] = Integer.parseInt(s[i]);
            idx++;
        }
        return answer;
    }
}