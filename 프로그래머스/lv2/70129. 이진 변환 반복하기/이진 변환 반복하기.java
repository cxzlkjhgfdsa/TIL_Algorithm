class Solution {
    public int[] solution(String s) {
        int cnt = 0;
        int zero = 0;
        
        
        while(!s.equals("1")){
            int size = s.length();
            int zeroCnt = 0;
            for(int i=0; i<size; i++){
                if(s.charAt(i) == '0'){
                    zeroCnt++;
                }
            }
            
            zero += zeroCnt;
            int size2 = size - zeroCnt;
            s = Integer.toBinaryString(size2);           
            
            cnt++;
        }
        int[] answer = {cnt, zero};
        
        return answer;
    }
}