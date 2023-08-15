class Solution {
    String[] answer;
    int len;
    public String[] solution(String[][] tickets) {
        len = tickets.length;
        answer = new String[len+1];
        for(int i=0; i<len; i++){
            if(tickets[i][0].equals("ICN")){
                boolean[] visited = new boolean[len];
                String[] place = new String[len+1];
                visited[i] = true;
                dfs(0, visited, place, tickets, tickets[i][0], tickets[i][1]);
            }
        }
        return answer;
    }

    public void dfs(int cnt, boolean[] visited, String[] place, String[][] tickets, String start, String end){
        place[cnt] = start;
        if(cnt == len-1){
            place[cnt+1] = end;
            boolean can = true;
            for(String s : place){
                if(s == null){
                    can = false;
                }
            }
            if(!can)
                return;

            if(answer[0] == null){
                for(int i=0; i<len+1; i++){
                    answer[i] = place[i];
                }
            }else{
                for(int i=1; i<len+1; i++){
                    if(place[i].equals(answer[i])){
                        continue;
                    }
                    for(int j=0; j<3; j++){
                        int a = answer[i].charAt(j) - 'A';
                        int b = place[i].charAt(j) - 'A';
                        if( a > b){
                            for(int k=0; k<len+1; k++){
                                answer[k] = place[k];
                            }
                            return;
                        }else if(a < b){
                            return;
                        }
                    }
                }
            }
            return;
        }
        for(int i=0; i<len; i++){
            if(visited[i]){
                continue;
            }
            if(tickets[i][0].equals(end)) {
                boolean can = false;
                visited[i] = true;
                dfs(cnt + 1, visited, place, tickets, tickets[i][0], tickets[i][1]);
                visited[i] = false;
            }
        }

    }
}