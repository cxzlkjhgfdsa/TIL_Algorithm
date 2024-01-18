class Solution {
    public int solution(int[] numbers, int k) {
        int answer = 0;
        
        int num = (k-1)*2;
        
        if(num >= numbers.length)
            num = num % numbers.length;
        
        answer = numbers[num];
        
        return answer;
    }
}