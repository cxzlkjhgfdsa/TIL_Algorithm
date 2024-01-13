class Solution {
    public int[] solution(int[] numbers, String direction) {
        int[] answer = new int[numbers.length];
        
        if(direction.equals("right")){
            for(int i = 1; i <numbers.length; i++){  // 오른쪽으로 한칸씩 밀기위해 answer 의 i 번째에 numbers의 i-1번째를 삽입
                answer[i] = numbers[i-1];
            }
            answer[0] = numbers[numbers.length-1];
        }else{
            for(int i = 0; i < numbers.length - 1; i++){ // 왼쪽으로 한칸씩 밀기위해 answer 의 i 번째에 numbers의 i+1번째를 삽입
                answer[i] = numbers[i+1];
            }
            answer[numbers.length - 1] = numbers[0];
            
        }
        
        return answer;
    }
}