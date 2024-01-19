class Solution {
    public int solution(String A, String B) {
        int answer = -1;
        
        if(A.equals(B)){
            answer = 0;
        }else{
            for(int i = 1; i < A.length(); i++){
                String start = A.substring(A.length()-1, A.length());
                String end = A.substring(0, A.length()-1);
                
                A = start+end;
                
                if(A .equals(B)){
                    answer = i;
                    break;
                }
            
            }
        }
        
        return answer;
    }
}