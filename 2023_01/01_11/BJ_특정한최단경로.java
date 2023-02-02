import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Array;
import java.util.*;

public class BJ_특정한최단경로 {
    static class Node implements Comparable<Node>{
        int index, distance;

        public Node(int index, int distance) {
            this.index = index;
            this.distance = distance;
        }

        @Override
        public int compareTo(Node o) {
            return this.distance - o.distance;
        }
    }

    static int max, N;
    static ArrayList<Node> [] Graph;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String [] input;

        input = br.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        int E = Integer.parseInt(input[1]);
        max = 1000*(N-1) + 1;

        Graph = new ArrayList[N+1];

        for(int i=1; i<=N; i++){
            Graph[i] = new ArrayList<>();
        }

        for(int i=0; i<E; i++){
            input = br.readLine().split(" ");
            int a = Integer.parseInt(input[0]);  // 출발 정점
            int b = Integer.parseInt(input[1]);  // 도착 정점
            int c = Integer.parseInt(input[2]);  // 가중치
            Graph[a].add(new Node(b, c));
            Graph[b].add(new Node(a, c));
        }

        input = br.readLine().split(" ");
        int v1 = Integer.parseInt(input[0]);
        int v2 = Integer.parseInt(input[1]);

        int ans1 = 0;
        ans1 += dijkstra(1, v1);
        ans1 += dijkstra(v1, v2);
        ans1 += dijkstra(v2, N);

        int ans2 = 0;
        ans2 += dijkstra(1, v2);
        ans2 += dijkstra(v2, v1);
        ans2 += dijkstra(v1, N);

        int ans = (ans1>=max) && (ans2>=max) ? -1 : Math.min(ans1, ans2);
        System.out.println(ans);
    }

    static int dijkstra(int start, int end){

        PriorityQueue<Node> pq = new PriorityQueue<>();
        int [] D = new int[N+1];
        boolean [] visited = new boolean[N+1];
        Arrays.fill(D, max);
        D[start] = 0;
        pq.offer(new Node(start, 0));

        while (!pq.isEmpty()){
            int cur = pq.poll().index;
            if(visited[cur]){
                continue;
            }

            visited[cur] = true;

            for(Node next : Graph[cur]){
                if(D[next.index] > D[cur] + next.distance){
                    D[next.index] = D[cur] + next.distance;
                    pq.offer(new Node(next.index, D[next.index]));
                }
            }
        }


        return D[end];
    }


}
