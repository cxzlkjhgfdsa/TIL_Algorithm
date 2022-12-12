import org.w3c.dom.Node;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

public class BJ_최단경로 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String [] input;

        input = br.readLine().split(" ");
        int V = Integer.parseInt(input[0]);
        int E = Integer.parseInt(input[1]);

        int start = Integer.parseInt(br.readLine());

        ArrayList<Node>[] graph = new ArrayList[V+1];

        for(int i=1; i<=V; i++){
            graph[i] = new ArrayList<>();
        }

        for(int i=0; i<E; i++){
            input = br.readLine().split(" ");
            int u = Integer.parseInt(input[0]);
            int v = Integer.parseInt(input[1]);
            int w = Integer.parseInt(input[2]);

            graph[u].add(new Node(v, w));
        }

        int [] D = new int[V+1];
        boolean [] visited = new boolean[V+1];

        int MAX = 10*(V-1) +1;

        Arrays.fill(D, MAX);
        D[start] = 0;
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(start, 0));

        while (!pq.isEmpty()){
            int current = pq.poll().index;

            if(visited[current])
                continue;

            visited[current] = true;

            for(Node next : graph[current]){
                if(D[next.index]> D[current] + next.distance){
                    D[next.index] = D[current] + next.distance;
                    pq.offer(new Node(next.index, D[next.index]));
                }
            }
        }

        for(int i=1; i<=V; i++){
            if(D[i] == MAX){
                System.out.println("INF");
            }else{
                System.out.println(D[i]);
            }

        }


    }

    static class Node implements Comparable<Node>{
        int index, distance;

        public Node(int index, int distance) {
            this.index = index;
            this.distance = distance;
        }

        @Override
        public int compareTo(Node o) {
            return this.distance-o.distance;
        }
    }
}
