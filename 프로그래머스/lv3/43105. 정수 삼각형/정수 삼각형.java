class Solution {
    public int solution(int[][] triangle) {
        int answer = 0;
        int len = triangle.length - 1;
        int[][] dp = new int[len+1][len+1];

        for(int i = 0; i<len+1; i++){
            dp[len][i] = triangle[len][i];
        }

        for(int i=len; i> 0; i--){
            int col  = triangle[i].length;
            for(int j=0; j<col; j++){

                if( j < col-1){
                    if(dp[i-1][j] < dp[i][j] + triangle[i-1][j]){
                        dp[i-1][j] = dp[i][j] + triangle[i-1][j];
                    }
                }
                if(j -1 >= 0){
                    if(dp[i-1][j-1] < dp[i][j] + triangle[i-1][j-1]){
                        dp[i-1][j-1] = dp[i][j] + triangle[i-1][j-1];
                    }
                }
            }
        }

        answer = dp[0][0];

        return answer;
    }
}