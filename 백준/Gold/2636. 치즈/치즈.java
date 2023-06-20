import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

public class Main {	
	static int map[][];
	static int newMap[][];
	static int dx[] = {-1, 0, 1, 0};
	static int dy[] = {0, 1, 0, -1};
	static int H, W, ans=0;
	static boolean end=false;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));		
		String input[];
		
		input = br.readLine().split(" ");
		H = Integer.parseInt(input[0]);
		W = Integer.parseInt(input[1]);
		
		map = new int [H][W];
		newMap = new int [H][W];
		for(int i=0; i<H; i++) {
			input = br.readLine().split(" ");
			for(int j=0; j<W; j++) {				
				map[i][j] = Integer.parseInt(input[j]);
			}
		}
		
		int cnt=0;
		
		while(!end) {
			copy();
			bfs();
			change();
			check();			
			cnt++;			
			
		}
		if(ans==0)
			cnt=0;
		
		System.out.println(cnt);
		System.out.println(ans);
		
		
		
	}
	static void check() {
		int cnt=0;
		for(int i=0; i<H; i++) {
			for(int j=0; j<W; j++) {
				if(map[i][j]==0) {
					cnt++;
				}
			}
		}
		if(cnt==H*W)
			end=true;
	}
	
	static void change() {
		int cnt=0;
		for(int i=0; i<H; i++) {
			for(int j=0; j<W; j++) {
				if(map[i][j]==3) {
					map[i][j]=0;
					cnt++;
				}
			}
		}
//		System.out.println("c"+cnt);
//		System.out.println("a"+ans);
		ans=cnt;
	}
	
	static void bfs() {
		Queue<pos> que = new ArrayDeque<pos>();
		que.offer(new pos(0, 0));
		newMap[0][0]=2;		
		
		while(!que.isEmpty()) {
			pos p = que.poll();
			
			for(int i=0; i<4; i++) {
				int cx = p.x+dx[i];
				int cy = p.y+dy[i];
				
				if(cx<0 || cy < 0 || cx>=H || cy>=W || newMap[cx][cy]==2)
					continue;
				if(map[cx][cy]==1) {
					map[cx][cy]=3;
					newMap[cx][cy]=2;
				}else {
					que.offer(new pos(cx, cy));
					newMap[cx][cy]=2;
				}
			}
			
			
		}		
	}
	static void copy() {
		for(int i=0; i<H; i++) {
			for(int j=0; j<W; j++) {
				newMap[i][j] = map[i][j];
			}
		}
	}
	
	
	static class pos{
		int x, y;

		public pos(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}		
	}
}
