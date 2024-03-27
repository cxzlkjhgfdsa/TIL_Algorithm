import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input;
        final int max_value = 100000000;

        input = br.readLine().split(" ");

        int N = Integer.parseInt(input[0]);
        int D = Integer.parseInt(input[1]);

        ArrayList<Node>[] map = new ArrayList[D+1];
        for(int i = 0; i < D; i++){
            map[i] = new ArrayList<>();
            map[i].add(new Node(i+1, 1));
        }
        map[D] = new ArrayList<>();

        for(int i = 0; i < N; i++){
            input = br.readLine().split(" ");
            int start = Integer.parseInt(input[0]);
            int end = Integer.parseInt(input[1]);
            int distance = Integer.parseInt(input[2]);

            if(end > D)
                continue;

            map[start].add(new Node(end, distance));
        }

        int[] djk = new int[D+1];
        boolean[] visited = new boolean[D+1];
        Arrays.fill(djk, max_value);
        djk[0] = 0;

        PriorityQueue<Node> que = new PriorityQueue<>();
        que.add(new Node(0, 0));

        while(!que.isEmpty()){

            Node cur = que.poll();

            if(visited[cur.idx]) continue;
            visited[cur.idx] = true;

            for(Node next : map[cur.idx]){

                if(djk[next.idx] > djk[cur.idx] + next.dis){
                    djk[next.idx] = djk[cur.idx] + next.dis;
                    que.add(new Node(next.idx, djk[next.idx]));
                }
            }
        }

        System.out.println(djk[D]);

    }

    private static class Node implements Comparable<Node>{
        int idx, dis;
        public Node(int idx, int dis){
            this.idx = idx;
            this.dis = dis;
        }

        @Override
        public int compareTo(Node o) {
            return this.dis - o.dis;
        }
    }
}
