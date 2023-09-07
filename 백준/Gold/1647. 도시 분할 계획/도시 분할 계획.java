import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    static int[] parents;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input[];

        input = br.readLine().split(" ");

        int N = Integer.parseInt(input[0]);
        int M = Integer.parseInt(input[1]);

        int maxCost = 0;

        Edge[] edges = new Edge[M];
        parents = new int[N+1];
        for(int i=1; i<=N; i++){
            parents[i] = i;
        }

        for(int i=0; i<M; i++){
            input = br.readLine().split(" ");
            int a = Integer.parseInt(input[0]);
            int b = Integer.parseInt(input[1]);
            int cost = Integer.parseInt(input[2]);

            edges[i] = new Edge(a, b, cost);
        }

        Arrays.sort(edges, (e1, e2) -> (e1.cost - e2.cost));

        int totalCost = 0;

        for(int i=0; i<M; i++){
            Edge e = edges[i];

            if(find(e.a) != find(e.b)){
                union(e.a, e.b);
                totalCost += e.cost;

                maxCost = Math.max(e.cost, maxCost);
            }
        }

        System.out.println(totalCost - maxCost);

    }

    private static void union(int a, int b){
        a = find(a);
        b = find(b);

        if(a >= b){
            parents[b] = a;
        }else{
            parents[a] = b;
        }
    }

    private static int find(int x){
        if(x == parents[x])
            return x;

        return find(parents[x]);
    }


    private static class Edge{
        int a, b, cost;
        public Edge(int a, int b, int cost){
            this.a = a;
            this.b = b;
            this.cost = cost;
        }
    }
}
