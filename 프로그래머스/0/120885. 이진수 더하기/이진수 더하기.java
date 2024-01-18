class Solution {
    public String solution(String bin1, String bin2) {
        String answer = "";
        
        int a = 0;
        int b = 0;
        
        int idx = 0;
        
        for(int i = bin1.length()-1; i>=0; i--){
            a += (int)(Math.pow(2, idx)*(bin1.charAt(i)-'0'));
            idx++;
        }
        
        idx= 0;
        
        for(int i = bin2.length()-1; i>=0; i--){
            b += (int)(Math.pow(2, idx)*(bin2.charAt(i)-'0'));
            idx++;
        }
         
        
        int sum = a+b;
        
        answer = Integer.toBinaryString(sum);
        
        return answer;
    }
}