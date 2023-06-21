import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input[];
		
		int N = Integer.parseInt(br.readLine());
		
		int tri [][] = new int [N][N];
		
		tri [0][0] = Integer.parseInt(br.readLine());
		
		for(int i=1; i<N; i++) {
			input = br.readLine().split(" ");
			for(int j=0; j<i+1; j++) {
				if(j==0) {
					tri[i][j] = tri[i-1][j] + Integer.parseInt(input[j]);
				}else if(j==i) {
					tri[i][j] = tri[i-1][j-1] + Integer.parseInt(input[j]);
				}else {
					tri[i][j] = Math.max(tri[i-1][j], tri[i-1][j-1]) + Integer.parseInt(input[j]);
				}
			}			
		}
		int max = 0;
		for(int i=0; i<N; i++) {
			max = Math.max(max, tri[N-1][i]);
		}
		System.out.println(max);

	}

}
