import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

public class BJ_바이러스 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input [];

        int N = Integer.parseInt(br.readLine());
        int L = Integer.parseInt(br.readLine());

        int [][] computer = new int [N+1][N+1];
        for(int i=0; i<L; i++){
            input = br.readLine().split(" ");
            int x = Integer.parseInt(input[0]);
            int y = Integer.parseInt(input[1]);
            computer[x][y] = 1;
            computer[y][x] = 1;
        }
        int ans = 0;
        boolean [] visited = new boolean[N+1];

        Queue<Integer> que = new ArrayDeque<>();
        que.offer(1);
        visited[1] = true;

        while(!que.isEmpty()){
            int n = que.poll();

            for(int i=1; i<=N; i++){
                if(visited[i] || computer[n][i]==0)
                    continue;
                que.offer(i);
                visited[i] = true;
                ans++;

            }

        }

        System.out.println(ans);

    }
}
