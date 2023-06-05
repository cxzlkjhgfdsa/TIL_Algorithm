import java.io.BufferedReader;
import java.io.InputStreamReader;


public class Main {
		static Node [] adjList;
		static boolean visited[];
		static int N;
		static boolean isCan=false;
		
		static class Node{
			int to;
			Node next;
			public Node(int to, Node next) {
				super();
				this.to = to;
				this.next = next;
			}
			
			
		}
		
		static void dfs(int cur, int cnt) {					
			
			visited[cur] = true;			
			if(cnt==4) {
				isCan=true;
				return;
			}
			
			for(Node temp = adjList[cur]; temp!=null; temp = temp.next) {
				if(!visited[temp.to]) {					
					dfs(temp.to, cnt+1);					
				}
				if(isCan)
					return;			
				
			}
			visited[cur] = false;
			
			
		}

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input[];		
		
		input = br.readLine().split(" ");		
		
		N = Integer.parseInt(input[0]);
		int M = Integer.parseInt(input[1]);
		
		adjList = new Node[N];
		
		for(int i=0; i<M; i++) {
			input = br.readLine().split(" ");
			int from = Integer.parseInt(input[0]);
			int to = Integer.parseInt(input[1]);
						
			adjList[from] = new Node(to, adjList[from]);
			adjList[to] = new Node(from, adjList[to]);
		}
		
		for(int i=0; i<N; i++) {
			visited = new boolean [N];
			dfs(i, 0);				
			if(isCan) {				
				break;
			}
		}		
		
		if(isCan) {
			System.out.println(1);
		}else {
			System.out.println(0);
		}
	}

}
