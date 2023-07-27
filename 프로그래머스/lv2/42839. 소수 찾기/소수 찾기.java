import java.util.*;

class Solution {
    String[] arr;
    int size;
    Set<Integer> ans;
    String[] check;
    boolean[] visited;
    
    public int solution(String numbers) {
        
        ans = new HashSet<>();
        
        arr = numbers.split("");
        size = arr.length;
        check = new String[size];
        visited = new boolean[size];
        perm(0);
        int answer = ans.size();
        
        return answer;
    }
    
    public void perm(int cnt){
        if(cnt > size){
            return;
        }
        
        if(cnt>0){
            String s = "";
            for(int i=0; i<cnt; i++){
                s+= check[i];
            }
            int deci = Integer.parseInt(s);
            boolean isDecimal = true;
            Double d = Math.sqrt(deci);
            for(int k=2; k<=d; k++){
                if(deci%k==0){
                    isDecimal = false;
                }
            }
            //System.out.println(deci+" : "+isDecimal);
            if(isDecimal && deci != 0 && deci != 1){
                ans.add(deci);
            }
        }
        
        
        
        for(int i=0; i<size; i++){
            if(visited[i]){
                continue;
            }
            visited[i] = true;
            check[cnt] = arr[i];
            perm(cnt+1);
            visited[i] = false;
        }
    }
}