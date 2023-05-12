import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Queue;

public class Main{
	
	static int map [][];
	static boolean visited[][];
	static int dx [] = {-1, 0, 1, 0};
	static int dy [] = {0, 1, 0, -1};
	static int N, fish=0, cnt=0, total=0;
	static Shark start;
	static Queue<Shark> shark = new ArrayDeque<>();
	
	static boolean canEat=false;
	
	static class Shark implements Comparable<Shark>{
		int x, y, size, time;

		public Shark(int x, int y, int size, int time) {
			super();
			this.x = x;
			this.y = y;
			this.size = size;
			this.time = time;
		}

		@Override
		public int compareTo(Shark o) {
			
			if(this.time == o.time) {
				if(this.x==o.x) {
					return this.y-o.y;
				}else {
					return this.x-o.x;
				}
				
				
			}
			return this.time-o.time;
		}		
		
	}	
	
	static void bfs() {	
	
		if(fish>0) {
			while(true) {				
				visited = new boolean[N][N];	
				
				canEat=false;
				visited[start.x][start.y] = true;
				
				shark.offer(start);			
				ArrayList<Shark> SE = new ArrayList<>();
				
				while(!shark.isEmpty()) {	
					Shark here = shark.poll();
					if(map[here.x][here.y]>0 && map[here.x][here.y]<start.size) {
						SE.add( new Shark(here.x, here.y, here.size, here.time));
						canEat=true;
						
					}				
					for(int i=0; i<4; i++) {
						int cx = here.x + dx[i];
						int cy = here.y + dy[i];
						
						if(cx>=0 && cy>=0 && cx<N && cy<N) {
							if(map[cx][cy]<=here.size && !visited[cx][cy]) {
								visited[cx][cy]=true;
								shark.offer(new Shark(cx, cy, here.size, here.time+1));	
							}
						}						
					}					
				}
				shark.clear();		
				Collections.sort(SE);
				
				if(canEat) {	
					start = SE.get(0);
					map[start.x][start.y] = 0;
					total+=start.time;
					start.time=0;
					cnt++;
					if(cnt==start.size) {
						start.size++;
						cnt=0;					
						
					}	
//					for(int i=0; i<N; i++) {
//						for(int j=0; j<N; j++) {
//							System.out.print(map[i][j]+"");
//						}
//						System.out.println();
//					}
//					System.out.println();
					
				}else
					break;			
				
			}		
		}	
	}
	

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input [];
		
		N = Integer.parseInt(br.readLine());
		
		map = new int [N][N];
		
		for(int i=0; i<N; i++) {
			input = br.readLine().split(" ");
			for(int j=0; j<N; j++) {
				map[i][j] = Integer.parseInt(input[j]);		
				if(map[i][j]==9) {
					start = new Shark(i, j, 2, 0);
					map[i][j]=0;
				}
				if(map[i][j]>0 && map[i][j]<9) {
					fish++;
				}
			}
		}			
		bfs();
		System.out.println(total);
		

	}

}
