class Solution {
    public int solution(int n) {
        int answer = 0;
        
        
        for(int i=1; i <= n; i++){
            answer++;
            
            int cur = 0;
            
            while(cur != answer){
                cur = answer;
                if(answer%3 == 0)
                answer++;
            
                String s = answer+"";
            
                for(int j =0; j < s.length(); j++){
                    if(s.charAt(j)-'0' == 3){
                        answer++;
                        break;
                    }

                }  
                
            }
            
    
            
            //System.out.println(i + " : " + answer);
        }
  
        
        
        return answer;
    }
}