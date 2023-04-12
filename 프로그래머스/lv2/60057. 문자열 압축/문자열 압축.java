class Solution {
    public int solution(String s) {
        int answer = 0;
        int size = s.length()/2;
        int size2 = s.length();
        int min = s.length();
        
        for(int i=1; i<=size; i++){
            String str = "";
            int cnt = 1;
            String check = s.substring(0, i);
            
            for(int j=i; j<=size2; j+=i){
                 String substr = "";
                if(j+i>size2){
                    substr = s.substring(j, size2);
                }else{
                    substr = s.substring(j, j+i);
                }
                //System.out.print(substr+" ");
                    
                if(substr.equals(check)){
                    cnt++;
                }else{
                    if(cnt==1){
                        str +=check;
                    }else{
                        str += cnt+check;
                    }
                    cnt = 1;
                    check = substr;
                }
            }
            if(cnt==1){
                str +=check;
            }else{
                str += cnt+check;
            }
            
            //System.out.println(str);
            min = Math.min(min, str.length());
        }
        
        answer = min;
        
        return answer;
    }
}