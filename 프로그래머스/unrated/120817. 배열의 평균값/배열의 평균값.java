class Solution {
    public double solution(int[] numbers) {
        double answer = 0;
        
        for(int n : numbers){
            answer += n;
        }
        
        answer /= numbers.length; // 배열의 길이 == 원소의 개수
        
        return answer;
    }
}