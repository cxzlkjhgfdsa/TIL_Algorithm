class Solution {
    public int solution(int m, int n, int[][] puddles) {
        int answer = 0;
        
        int dp[][] = new int[n][m];
        int map[][] = new int[n][m];
        
        for(int [] arr : puddles){
            map[arr[1]-1][arr[0]-1] = 1;
        }

        
        dp[0][0] = 1;
        
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(map[i][j] != 0)
                    continue;
                
                if(i == 0 && j == 0)
                    continue;
                
                if( i == 0){
                    dp[i][j] += dp[i][j-1]%1000000007; 
                }else if( j == 0){
                    dp[i][j] += dp[i-1][j]%1000000007;
                }else{
                    dp[i][j] += (dp[i-1][j] + dp[i][j-1])%1000000007;
                }
                
                
            }
        }
        
        // for(int i=0; i<n; i++){
        //     for(int j=0; j<m; j++){
        //         System.out.print(dp[i][j]);
        //     }
        //     System.out.println();
        // }
        answer = dp[n-1][m-1];

        return answer;
    }
}