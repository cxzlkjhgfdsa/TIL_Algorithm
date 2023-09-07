import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input[];

        input = br.readLine().split(" ");

        int N = Integer.parseInt(input[0]);
        int M = Integer.parseInt(input[1]);

        ArrayList<Edge>[] graph = new ArrayList[N+1];
        for(int i=1; i<=N; i++){
            graph[i] = new ArrayList<>();
        }

        for(int i=0; i<M; i++){
            input = br.readLine().split(" ");
            int a = Integer.parseInt(input[0]);
            int b = Integer.parseInt(input[1]);
            int cost = Integer.parseInt(input[2]);

            graph[a].add(new Edge(b, cost));
            graph[b].add(new Edge(a, cost));
        }

        PriorityQueue<Edge> pq = new PriorityQueue<>();

        int totalCost = 0;
        int maxCost = 0;

        boolean[] visited = new boolean[N+1];

        pq.add(new Edge(1, 0));

        while(!pq.isEmpty()){
            Edge e = pq.poll();
            if(visited[e.p])
                continue;
            totalCost += e.cost;
            maxCost = Math.max(maxCost, e.cost);
            visited[e.p] = true;

            for(Edge next : graph[e.p]){
                if(visited[next.p])
                    continue;
                pq.add(next);
            }
        }

        System.out.println(totalCost - maxCost);

    }

    private static class Edge implements Comparable<Edge>{
        int p, cost;
        public Edge(int p, int cost){
            this.p = p;
            this.cost = cost;
        }

        @Override
        public int compareTo(Edge o) {
            return this.cost - o.cost;
        }
    }
}
