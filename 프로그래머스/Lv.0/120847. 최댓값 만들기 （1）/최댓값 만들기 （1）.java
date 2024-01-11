import java.util.*;

class Solution {
    public int solution(int[] numbers) {
        int answer = 0;
        
        Arrays.sort(numbers);
        
        answer = numbers[numbers.length-1]*numbers[numbers.length-2]; // 오름차순 정렬후 가장 마지막 원소 2개를 곱함
        
        return answer;
    }
}