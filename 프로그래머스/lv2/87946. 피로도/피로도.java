class Solution {
    int size;
    boolean[] visited;
    int[] nums;
    int max = 0;
    
    public int solution(int k, int[][] dungeons) {
        int answer = -1;
        size = dungeons.length;
        
        visited = new boolean[size];
        nums = new int[size];
        perm(0, dungeons, k);
        answer = max;
        
        return answer;
    }
    
    void perm(int cnt, int[][] dungeons, int k){
        if(cnt == size){
            checkMax(nums, dungeons, k);
            return;
        }
        for(int i=0; i<size; i++){
            if(visited[i])
                continue;
            nums[cnt] = i;
            visited[i] = true;
            perm(cnt + 1, dungeons, k);
            visited[i] = false;
        }
        
    }
    
    void checkMax(int[] arr, int[][] dungeons, int k){
        int count = 0;
        for(int n : arr){
            if(k < dungeons[n][0])
                break;
            count++;
            k = k - dungeons[n][1];
        }
        max = Math.max(count, max);
        
    }
}