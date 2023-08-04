import java.util.*;
import java.io.*;


public class Main{

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input;
        int ans = 0;

        input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);

        ArrayList<Integer>[] map = new ArrayList[n+1];
        ArrayList<Integer>[] mapR = new ArrayList[n+1];

        for(int i = 0; i <= n; i++){
            map[i] = new ArrayList<>();
            mapR[i] = new ArrayList<>();
        }

        for(int i = 0; i < m; i++){
            input = br.readLine().split(" ");
            int a = Integer.parseInt(input[0]);
            int b = Integer.parseInt(input[1]);

            map[a].add(b);
            mapR[b].add(a);
        }

        input = br.readLine().split(" ");
        int S = Integer.parseInt(input[0]);
        int T = Integer.parseInt(input[1]);

        boolean[] S2Node = new boolean[n+1];
        boolean[] T2Node = new boolean[n+1];
        boolean[] Node2S = new boolean[n+1];
        boolean[] Node2T = new boolean[n+1];

        S2Node[T] = true;
        T2Node[S] = true;

        bfs(S, S2Node, map);
        bfs(T, T2Node, map);
        bfs(S, Node2S, mapR);
        bfs(T, Node2T, mapR);

        for(int i = 1; i <= n ; i ++){
            if(S2Node[i] && T2Node[i] && Node2S[i] && Node2T[i]){
                //System.out.println(i);
                ans++;
            }
        }

        ans -= 2;
        System.out.println(ans);

    }

    public static void bfs(int start, boolean[]visited, ArrayList<Integer>[] map){

        Queue<Integer> que = new ArrayDeque<>();
        visited[start] = true;
        que.add(start);

        while(!que.isEmpty()){
            int cur = que.poll();

            for(int next : map[cur]){
                if(visited[next]){
                    continue;
                }

                visited[next] = true;
                que.add(next);
            }
        }
    }

}
