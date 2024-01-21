class Solution {
    public int solution(int[][] sizes) {
        int answer = 0;
        int col = 0;
        int low = 0;
        boolean flag = false;
        
        for(int i=1; i<=1000; i++){
            for(int j=1; j<=1000; j++){
                for(int k=0; k<sizes.length; k++){
                    flag = false;
                    int a = sizes[k][0];
                    int b = sizes[k][1];
                    
                    if(a <= i && b <=j)
                        flag = true;
                    else if( a <= j && b <= i)
                        flag = true;
                    
                    if(!flag)
                        break;                    
                }
                if(flag){
                    col = i;
                    low = j;
                    break;
                }
            }
            if(flag)
                break;
        }
        
        answer = col * low;
        
        return answer;
    }
}