class Solution {
    
    public int solution(String[] babbling) {
        int answer = 0;
        String[] word = {"aya", "ye", "woo", "ma"};
        
        for(String s : babbling){
            
            String k = s;
            
            for(int j = 0; j < 4; j++){
                k = k.replace(word[j], "1");
            }
            
            k = k.replaceAll("1", "");

            System.out.println(k);
            if(k.equals(""))
                answer++;
        }
        
        
        return answer;
    }
    

}