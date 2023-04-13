import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	
		static int map[][];
		static int N, M, ans, check;

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input [];
		
		input = br.readLine().split(" ");
		N = Integer.parseInt(input[0]);
		M = Integer.parseInt(input[1]);
		
		input = br.readLine().split(" ");
		int r = Integer.parseInt(input[0]);
		int c = Integer.parseInt(input[1]);
		int d = Integer.parseInt(input[2]);
		
		map = new int[N][M];
		
		for(int i=0; i<N; i++) {
			input = br.readLine().split(" ");
			for(int j=0; j<M; j++) {
				map[i][j] = Integer.parseInt(input[j]);
				
			}
		}
		ans=0;
		
		find(r, c, d);	
		System.out.println(ans);

	}
	
	static void find(int r, int c, int d) {
		if(map[r][c]==0) {
			map[r][c]=2;
			ans++;
		}	
	
		switch(d) {
		
		case 0:			 
			if(map[r][c-1]==0) {
				find(r, c-1, 3);			
			}else {
				if(map[r+1][c]==0) {
					find(r+1, c, 2);
					return;
				}
				if(map[r][c+1]==0) {
					find(r, c+1, 1);	
					return;
				}
				if(map[r-1][c]==0) {
					find(r-1, c, 0);	
					return;
					
				}
				if(map[r+1][c]!=1) {
					find(r+1, c, 0);
				}else {
					return;
				}
				
			}	
			break;
		case 1:
			if(map[r-1][c]==0) {
				find(r-1, c, 0);	
				
			}else {
				if(map[r][c-1]==0) {
					find(r, c-1, 3);
					return;
				}
				if(map[r+1][c]==0) {
					find(r+1, c, 2);
					return;
				}
				if(map[r][c+1]==0) {
					find(r, c+1, 1);
					return;
					
				}
				if(map[r][c-1]!=1) {
					find(r, c-1, 1);
					return;
				}else {
					return;
				}			
			}
			break;
		case 2:
			if(map[r][c+1]==0) {
				find(r, c+1, 1);				
			}else {
				if(map[r-1][c]==0) {
					find(r-1, c, 0);
					return;
				}
				if(map[r][c-1]==0) {
					find(r, c-1, 3);
					return;
				}
				if(map[r+1][c]==0) {
					find(r+1, c, 2);
					return;
					
				}
				if(map[r-1][c]!=1) {
					find(r-1, c, 2);
					return;
				}else {
					return;
				}						
			}
			break;
		case 3:
			if(map[r+1][c]==0) {
				find(r+1, c, 2);
			}else {
				if(map[r][c+1]==0) {
					find(r, c+1, 1);
					return;					
				}
				if(map[r-1][c]==0) {
					find(r-1, c, 0);
					return;					
				}	
				if(map[r][c-1]==0) {
					find(r, c-1, 3);
					return;
				}
				if(map[r][c+1]!=1) {
					find(r, c+1, 3);
					return;
				}else {
					return;
				}
				
			}
			break;
			
		}
		
		return;
	}
	
	
	

}
