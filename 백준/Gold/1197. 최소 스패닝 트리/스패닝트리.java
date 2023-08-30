import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {

    static int[] parents;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input;

        input = br.readLine().split(" ");
        int V = Integer.parseInt(input[0]);
        int E = Integer.parseInt(input[1]);
        int ans = 0;

        parents = new int[V+1];
        for(int i = 0; i <=V; i++){
            parents[i] = i;
        }
        Edge[] edges = new Edge[E];

        for(int i=0; i<E; i++){
            input = br.readLine().split(" ");
            int x = Integer.parseInt(input[0]);
            int y = Integer.parseInt(input[1]);
            int cost = Integer.parseInt(input[2]);

            edges[i] = new Edge(x, y, cost);
        }

        Arrays.sort(edges, (e1, e2) -> Integer.compare(e1.cost ,e2.cost));


        for(int i=0; i<E; i++){
            if(find(edges[i].x) != find(edges[i].y)){
                union(edges[i].x, edges[i].y);
                ans += edges[i].cost;
            }
        }

        System.out.println(ans);

    }

    private static void union(int x, int y){
        int a = find(x);
        int b = find(y);

        if(a > b){
            parents[a] = b;
        }else{
            parents[b] = a;
        }
    }

    private static int find(int n){
        if(parents[n] == n){
           return n;
        }

        return find(parents[n]);
    }
}

class Edge{
    int x, y, cost;
    public Edge(int x, int y, int cost){
        this.x = x;
        this.y = y;
        this.cost = cost;
    }
}

