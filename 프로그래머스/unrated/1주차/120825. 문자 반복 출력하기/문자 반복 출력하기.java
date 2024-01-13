class Solution {
    public String solution(String my_string, int n) {
        String answer = "";
        
        String[] str = my_string.split("");
        
        for(String s : str){
            for(int i = 0; i < n; i++){
                answer+=s;
            }
        }
        
        return answer;
    }
}