import java.util.*;

class Solution {
    public String solution(String polynomial) {
        String answer = "";
        
        String[] add = polynomial.split(" ");
        
        int x = 0;
        int nomal = 0;
        
        //System.out.println(Arrays.toString(add));
        
        for(String s : add){
            //System.out.print(s+",");
            if(s.equals("+"))
                continue;
            
            if(s.charAt(s.length()-1) == 'x'){
                if(s.length() == 1)
                    x+=1;
                else
                    x += Integer.parseInt(s.substring(0, s.length()-1));
            }else{
                nomal += Integer.parseInt(s);
            }
        }
        
        if(x > 0){
            if(nomal > 0){
                if(x == 1)
                    answer = "x"+" + "+nomal;
                else
                    answer = x+"x"+" + "+nomal;
            }else{
                if(x == 1)
                    answer = "x";
                else
                    answer = x+"x";
            }
        }else{
            if(nomal > 0)
                answer = nomal+"";
        }
        
        return answer;
    }
}