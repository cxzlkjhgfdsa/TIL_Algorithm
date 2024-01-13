class Solution {
    public int solution(int n) {
        int answer = 0;
        
        for(int i = 1; i <= n; i++){
            
            int cnt = 0;
            
            for(int j = 1; j <= i; j++){ // 1 ~ i 까지 약수가 있는지 탐색
                if(i % j == 0) // 약수라면 카운트 ++
                    cnt++;
            }
            if(cnt >= 3)  // 약수의 개수가 3개 이상이라면 합성수 
                answer++;
            
        }
        
        return answer;
    }
}