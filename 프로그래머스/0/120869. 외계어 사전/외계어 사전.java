class Solution {
    public int solution(String[] spell, String[] dic) {
        int answer = 2;
        
        int[] sp = new int[27];
        
        for(String s : spell){
            sp[s.charAt(0)-'a']++;
        }
        
        for(String word : dic){
            int[] dc = new int[27];
            for(int j = 0; j < word.length(); j++){
                dc[word.charAt(j)-'a']++;
            }
            boolean b = true;
            for(int i = 0; i < 27; i++){
                if(sp[i] != dc[i])
                    b = false;
            }
            if(b){
                answer = 1;
                break;
            }
                
        }
        
        
        return answer;
    }
}