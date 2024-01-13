class Solution {
    public int solution(int[] array, int n) {
        int answer = 0;
        
        for(int next : array){
            if(next == n)
                answer++;
        }
        
        return answer;
    }
}