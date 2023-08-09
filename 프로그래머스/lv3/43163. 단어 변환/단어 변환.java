class Solution {
        int answer = 0;
    
    public int solution(String begin, String target, String[] words) {
        boolean[] visited = new boolean[words.length];
        
        for(int i=0; i<words.length; i++){
            if(words[i].equals(begin)){
                visited[i] = true;
                break;
            }
        }
        dfs(begin, target, 0, words, visited);
        
        
        return answer;
    }
    
    public void dfs(String current, String target, int cnt, String[] words, boolean[] visited){
        if(current.equals(target)){
            if(answer == 0){
                answer = cnt;
            }else{
                answer = Math.min(answer, cnt);    
            }
        }
        
        for(int i = 0; i< words.length; i++){
            if(visited[i])
                continue;
            int c = 0;
            for(int j=0; j<words[i].length(); j++){
                if(current.charAt(j) != words[i].charAt(j)){
                    c++;
                }
            }
            if(c == 1){
                visited[i] = true;
                dfs(words[i], target, cnt+1, words, visited);
                visited[i] = false;
            }
        }
    }
}