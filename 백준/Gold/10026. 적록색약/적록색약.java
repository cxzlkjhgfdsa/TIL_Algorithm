import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.concurrent.SynchronousQueue;

public class Main {
		static String map[][], map2[][];
		static boolean visited [][], visited2[][];
		static int N;
		static int [] dx = {-1, 0, 1, 0};
		static int [] dy = {0, 1, 0, -1};
		static int ans1, ans2;
		
		static void dfs(int x, int y) {
			visited[x][y] = true;
			
			for(int i=0; i<4; i++) {
				int cx = x + dx[i];
				int cy = y + dy[i];
				
				if(cx>=0 && cx < N && cy >=0 && cy < N) {
					if(!visited[cx][cy] && map[cx][cy].equals(map[x][y]))
						dfs(cx, cy);			
					
				}			
				
			}			
		}
		
		static void dfs2(int x, int y) {
			visited2[x][y] = true;			
			
			for(int i=0; i<4; i++) {
				int cx = x + dx[i];
				int cy = y + dy[i];
				
				if(cx>=0 && cx < N && cy >=0 && cy < N) {
					if(map2[x][y].equals("R") || map2[x][y].equals("G")) {
						if(!visited2[cx][cy]&& (map2[cx][cy].equals("R") || map2[cx][cy].equals("G")))	
							dfs2(cx, cy);
						
					}else {
						if(!visited2[cx][cy] && map[cx][cy].equals(map[x][y]))
							dfs2(cx, cy);		
					}
									
					
				}			
				
			}			
			
		}
	
	

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input[];
		
		N = Integer.parseInt(br.readLine());
		
		map = new String [N][N];
		map2= new String [N][N];
		visited = new boolean[N][N];
		visited2 = new boolean[N][N];	
		
		ans1=0; ans2=0;
		
		for(int i=0; i<N; i++) {
			input = br.readLine().split("");
			for(int j=0; j<N; j++) {
				map[i][j] = input[j];
				map2[i][j]= map[i][j];
			}
		}
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				if(!visited[i][j]) {
					dfs(i, j);
					ans1++;
				}
				if(!visited2[i][j]) {
					dfs2(i, j);					
					ans2++;
				}
			}
		}
		System.out.println(ans1+" "+ans2);

	}

}
