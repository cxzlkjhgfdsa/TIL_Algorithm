class Solution {
    public int[] solution(int[] array) {
        int[] answer = new int[2];
        
        int idx = 0;
        int max = 0;
        
        for(int i = 0; i < array.length; i++){
            if(array[i] > max){
                idx = i;
                max = array[i];
            }
        }
        
        answer[0] = max;
        answer[1] = idx;
        
        return answer;
    }
}