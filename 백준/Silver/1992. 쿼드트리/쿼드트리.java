import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
		static int map[][];
		static int sum;
		static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));			
		String input [];
		
		int N = Integer.parseInt(br.readLine());
		
		map = new int [N][N];
		
		for(int i=0; i<N; i++) {
			input = br.readLine().split("");
			for(int j=0; j<N; j++) {
				map[i][j] = Integer.parseInt(input[j]);
			}
		}
		
		find(N, 0, 0);
		
		System.out.println(sb);

	}
	
	static void find (int N, int x, int y) {		
		sum=0;
		for(int i=x; i<x+N; i++) {
			for(int j=y; j<y+N; j++) {
				sum += map[i][j];
			}
		}
		if(sum==N*N) {
			sb.append(1);
		}
		else if(sum==0) {
			sb.append(0);
		}
		else {
			sb.append("(");
			find(N/2, x, y);
			find(N/2, x, y+N/2);
			find(N/2, x+N/2, y);
			find(N/2, x+N/2, y+N/2);	
			sb.append(")");
		}	
		if(N==1) {
			return;
		}		
		
	}

}
