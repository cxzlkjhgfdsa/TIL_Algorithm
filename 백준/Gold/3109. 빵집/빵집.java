
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	
		static String map [][];
		static boolean visited [][];
		static int R, C, cnt;
		static int [] dx = {-1, 0, 1};
		static int [] dy = {1,1,1};

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input [];
		
		input = br.readLine().split(" ");
		R = Integer.parseInt(input[0]);
		C = Integer.parseInt(input[1]);
		cnt =0;
		
		map = new String [R][C];
		visited = new boolean [R][C];
		
		for(int i=0; i<R; i++) {
			input = br.readLine().split("");
			for(int j=0; j<C; j++) {
				map[i][j] = input[j];
			}
		}
		for(int i=0; i<R; i++) {
			findPipe(i, 0);
		}
		System.out.println(cnt);
		
	}
	
	static boolean findPipe(int x, int y) {		
		
		if(y == C-1) {
			cnt++;
			return true;
		}
		
					
		
		for(int i=0; i<3; i++) {
			int cx = x + dx[i];
			int cy = y + dy[i];
				
			if(cx<0 || cy<0 ||  cx>=R || cy>=C) 
				continue;
			if(visited[cx][cy] | map[cx][cy].equals("x"))
				continue;
				
			visited[cx][cy]=true;
			
			if(findPipe(cx, cy))
				return true;
				
			
		}
		
		return false;
		
		
	}
	
	

}
