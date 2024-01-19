class Solution {
    public int[] solution(int num, int total) {
        int[] answer = new int[num];
        
        for(int n = -1000; n<=1000; n++){
            
            int sum = 0;
            for(int i = n, j = 0; i < n+num; i++, j++){
                answer[j] = i;
                sum += i;
            }
            
            if(sum == total)
                break;
            
        }
        
        
        
        return answer;
    }
}