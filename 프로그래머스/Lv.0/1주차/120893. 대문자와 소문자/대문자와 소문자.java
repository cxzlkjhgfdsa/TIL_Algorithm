class Solution {
    public String solution(String my_string) {
        String answer = "";
    
        for(int i = 0; i < my_string.length(); i++){
            
            int num = (int)my_string.charAt(i);
            
            if(num >= 97){
                answer += (char)(num - 32);
            }else{
                answer += (char)(num + 32);
            }
            
        }
        
        return answer;
    }
}