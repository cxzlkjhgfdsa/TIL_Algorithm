class Solution {
    int answer;
    int targetNum;
    int size;
    public int solution(int[] numbers, int target) {
        answer = 0;
        targetNum = target;
        size = numbers.length;
        dfs(1, numbers[0], numbers);
        dfs(1, numbers[0]*-1, numbers);
        return answer;
    }
    public void dfs(int cnt, int sum, int[] arr){
        
        if (cnt == size){
            if(sum == targetNum)
                answer++;
            return;
        }
        
        dfs(cnt + 1, sum + arr[cnt] , arr);
        dfs(cnt + 1, sum - arr[cnt] , arr);
    }
}