import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

public class Main {
	static class Pos{
		int x, y, price;

		public Pos(int x, int y, int price) {	
			this.x = x;
			this.y = y;
			this.price=price;
		}
		
	}
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		String input[];
		int dx [] = {-1, 0, 1, 0};
		int dy [] = {0, 1, 0, -1};
		int cnt=0;
		
		while(true) {
			cnt++;
			int N = Integer.parseInt(br.readLine());
			
			if(N==0)
				break;
			
			int map [][] = new int [N][N];
			
			for(int i=0; i<N; i++) {
				input = br.readLine().split(" ");
				for(int j=0; j<N; j++) {
					map[i][j] = Integer.parseInt(input[j]);
				}
			}
		
			int minEdge[][] = new int [N][N];
			for(int i=0; i<N; i++) {
				Arrays.fill(minEdge[i], Integer.MAX_VALUE);
			}			
			
			Pos start = new Pos(0, 0, map[0][0]);		
			Queue <Pos> que = new ArrayDeque<>();
			que.offer(start);		
			
			minEdge[0][0] = map[0][0];
			
			while(!que.isEmpty()) {
				Pos p = que.poll();
				
				
				
				for(int i=0; i<4; i++) {
					int cx = p.x + dx[i];
					int cy = p.y + dy[i];
					
					if(cx>=0 && cy>=0 && cx< N && cy<N) {
						if( minEdge[cx][cy] > minEdge[p.x][p.y]+ map[cx][cy]) {
							minEdge[cx][cy] = minEdge[p.x][p.y]+ map[cx][cy];
							que.offer(new Pos(cx, cy, minEdge[cx][cy]));
						}
						
						
					}
					
				}				
				
			}			
			
			sb.append("Problem "+cnt+": "+minEdge[N-1][N-1]+"\n");
			
		}
		System.out.println(sb);

	}

}
