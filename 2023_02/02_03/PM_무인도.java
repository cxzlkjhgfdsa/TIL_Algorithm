import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

public class PM_무인도 {
    public static void main(String[] args) {
        String maps[] = {"X591X","X1X5X","X231X", "1XXX1"};
        Solution s = new Solution();
        s.solution(maps);
    }
}

class Solution {

    int [][]map;
    boolean [][] visited;

    int n, m;

    int [] dx = {-1, 0, 1, 0};
    int [] dy = {0, 1, 0, -1};

    PriorityQueue<Integer> pq = new PriorityQueue<>();
    public int[] solution(String[] maps) {
        String input[];
        n = maps.length;
        m = maps[0].length();

        map = new int[n][m];
        visited = new boolean[n][m];

        for(int i=0; i< n; i++){
            input = maps[i].split("");
            for(int j=0; j<m; j++){
                if(input[j].equals("X")){
                    map[i][j] = 0;
                }else{
                    map[i][j] = Integer.parseInt(input[j]);
                }
            }
        }


        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(map[i][j]>0 && !visited[i][j]){
                    bfs(i, j);
                }
            }
        }
        int size = pq.size();
        int [] answer;
        if(size>0){
            answer = new int[size];

            for(int i=0; i<size; i++){
                answer[i] = pq.poll();
            }
        }else{
            answer = new int[1];
            answer[0] = -1;
        }
        return answer;
    }

    private void bfs(int i, int j) {
        Queue<pos> que = new ArrayDeque<>();
        que.offer(new pos(i, j));
        visited[i][j] = true;
        int cnt = map[i][j];

        while (!que.isEmpty()){
            pos p = que.poll();

            for(int k=0; k<4; k++){
                int cx = p.x + dx[k];
                int cy = p.y + dy[k];
                if(cx<0 || cy<0 || cx>=n || cy>=m || visited[cx][cy] || map[cx][cy]<=0){
                    continue;
                }
                visited[cx][cy] =true;
                cnt+=map[cx][cy];
                que.offer(new pos(cx, cy));
            }

        }
        pq.offer(cnt);
    }

}

class pos{
    int x, y;

    public pos(int x, int y) {
        this.x = x;
        this.y = y;
    }
}