class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        for(int i=1; i<=yellow; i++){
            if(yellow%i == 0){
                int a = i;
                int b = yellow/a;
                
                if(a < b){
                    continue;
                }
                
                if((a*2) + (b*2) + 4 == brown){
                    answer[0] = a+2;
                    answer[1] = b+2;
                    break;
                }
            }
        }
        return answer;
    }
}