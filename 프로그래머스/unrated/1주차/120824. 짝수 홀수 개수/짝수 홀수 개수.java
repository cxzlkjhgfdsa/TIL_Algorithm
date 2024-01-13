class Solution {
    public int[] solution(int[] num_list) {
        int[] answer = new int[2];
        
        int a = 0;
        int b = 0;
        
        for(int next : num_list){
            if(next%2 == 0){  // 짝수라면
                a++;
            }else{            // 아니면 홀수
                b++;
            }
        }
        
        answer[0] = a;
        answer[1] = b;
        
        return answer;
    }
}