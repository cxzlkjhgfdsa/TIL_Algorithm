class Solution {
    public int solution(int n, int[] money) {
        long[] dp = new long[n+1];
        
        dp[0] = 1;
        
        for(int m : money){
            
            for(int i = m; i <= n; i++){
                dp[i] += dp[i-m];
            }
            
        }
        
        return (int) dp[n] % 1000000007;
       
    }
}