class Solution {
    public int solution(String my_string) {
        int answer = 0;
        
        String s = "";
        
        for(int i = 0; i < my_string.length(); i++){
            if(my_string.charAt(i) - 'A' < 0){
                s += (my_string.charAt(i)-'0')+"";                
            }else{
                if(s.length()>0)
                    answer += Integer.parseInt(s);
                s = "";
            }
        }
        
        if(s.length()>0)
            answer += Integer.parseInt(s);
        
        return answer;
    }
}