import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

public class Main {
	
	static int graph [][];
	static int N,M, start;
	static boolean visited[];
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String input[];
		
		
		
		input = br.readLine().split(" ");
		
		N = Integer.parseInt(input[0]);
		M = Integer.parseInt(input[1]);
		start = Integer.parseInt(input[2]);
		graph = new int [N+1][N+1];
		visited = new boolean[N+1];
		
		
		for(int i=0; i<M; i++) {
			input = br.readLine().split(" ");
			int from = Integer.parseInt(input[0]);
			int to = Integer.parseInt(input[1]);
			graph[from][to] = graph[to][from] =1;
			
		}	
		
		dfs(start);
		sb.append("\n");
		bfs();
		
		System.out.println(sb);
	}
	static void dfs(int cur) {
		visited[cur] = true;
		sb.append(cur+" ");
		
		for(int i=1; i<=N; i++) {
			if(!visited[i] && graph[cur][i]!=0) {
				dfs(i);	
				
			}
		}
		
	}
	static void bfs() {
		Queue<Integer> queue = new ArrayDeque<>();
		visited = new boolean[N+1];
		
		visited[start] = true;
		queue.offer(start);
		
		while(!queue.isEmpty()) {
			
			int cur = queue.poll();			
			sb.append(cur+" ");
			
			for(int i=1; i<=N; i++) {
				if(!visited[i] && graph[cur][i]!=0) {
					visited[i] = true;
					queue.offer(i);
				}
			}
			
		}
		
		
	}

}
