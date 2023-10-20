import java.util.*;

class Solution {
    
        int answer = 0;
        int size;
        ArrayList<Ban> list = new ArrayList<>();
    
    public int solution(String[] user_id, String[] banned_id) {
        size = banned_id.length;
        
        boolean[] visited = new boolean[user_id.length];
        
        dfs(0, visited, user_id, banned_id);
        
        return answer;
    }
    
    private void dfs(int cnt, boolean[] visited, String[] user_id, String[] banned_id){
        if(cnt == size){
            
            boolean yes = true;
            for(Ban b : list){
                int count = 0;
                for(int k = 0; k < visited.length; k++){
                    if(visited[k]){
                        if(b.banned.contains(k))
                            count++;
                    }
                        
                }
                if(count == b.banned.size())
                    yes = false;
                
            }
            
            if(yes){
                answer++;
                TreeSet<Integer> set = new TreeSet<>();
                
                for(int k = 0; k < visited.length; k++){
                    if(visited[k])
                        set.add(k);
                }
                
                list.add(new Ban(set));
            }
            
            return;
        }
        
        for(int i = 0; i < visited.length; i++){
            
            if(banned_id[cnt].length() == user_id[i].length()){
                boolean can = true;
                
                for(int j = 0; j < banned_id[cnt].length(); j++){
                    if(banned_id[cnt].charAt(j) == '*')
                        continue;
                    if(banned_id[cnt].charAt(j) != user_id[i].charAt(j))
                        can = false;
                    
                }
                
                if(can && !visited[i] ){
                    visited[i] = true;
                    dfs(cnt+1, visited, user_id, banned_id);
                    visited[i] = false;
                }
                
            }
            
        }
        
    }
}

class Ban{
    TreeSet<Integer> banned;
    public Ban(TreeSet<Integer> tree){
        this.banned = tree;
    }
}