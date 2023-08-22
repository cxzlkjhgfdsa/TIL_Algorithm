    import java.io.BufferedReader;
    import java.io.IOException;
    import java.io.InputStreamReader;
    import java.util.ArrayDeque;
    import java.util.Comparator;
    import java.util.PriorityQueue;
    import java.util.Queue;
    
    public class Main {
        static class pos{
            int x, y;
    
            public pos(int x, int y) {
                this.x = x;
                this.y = y;
            }
        }
        static int [][] map;
        static int n, m;
        static boolean [][] visited;
    
        static PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        static int [] dx = {-1, 0, 1, 0};
        static  int [] dy = {0, 1, 0 ,-1};
    
        public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            String input[];
    
            input = br.readLine().split(" ");
            n = Integer.parseInt(input[0]);
            m = Integer.parseInt(input[1]);
    
            map = new int[n][m];
            visited = new boolean[n][m];
    
            for(int i=0; i<n; i++){
                input = br.readLine().split(" ");
                for(int j=0; j<m; j++){
                    map[i][j] = Integer.parseInt(input[j]);
                }
            }
    
            for(int i=0; i<n; i++){
                for(int j=0; j<m; j++){
                    if(visited[i][j] || map[i][j] == 0){
                        continue;
                    }
                    bfs(i, j);
    
                }
            }
            if(pq.size()==0){
                System.out.println(0);
                System.out.println(0);
            }else{
                System.out.println(pq.size());
                System.out.println(pq.poll());
            }
    
    
    
        }
    
        private static void bfs(int i, int j) {
            Queue<pos> que = new ArrayDeque<>();
            int cnt = 1;
            visited[i][j] = true;
            que.offer(new pos(i, j));
    
            while (!que.isEmpty()){
    
                pos p = que.poll();
    
                for(int k=0; k<4; k++){
                    int cx = p.x + dx[k];
                    int cy = p.y + dy[k];
                    if(cx<0 || cy<0 || cx>=n || cy>=m){
                        continue;
                    }
                    if(!visited[cx][cy] && map[cx][cy]==1){
                        que.offer(new pos(cx, cy));
                        cnt ++;
                        visited[cx][cy] = true;
                    }
                }
    
            }
            pq.offer(cnt);
    
        }
    
    
    }
