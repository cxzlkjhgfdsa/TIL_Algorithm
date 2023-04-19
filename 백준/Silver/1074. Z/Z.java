import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	
	static int cnt=0;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input[];

		input = br.readLine().split(" ");
		int N = Integer.parseInt(input[0]);
		int r = Integer.parseInt(input[1]);
		int c = Integer.parseInt(input[2]);

		int size = (int) Math.pow(2, N);
		
		zNum(size, r, c);
		System.out.println(cnt);
			

	}
	
	static void zNum(int size, int r, int c) {
		if(size==1) return;
		
		if(r<size/2 & c<size/2) {
			zNum(size/2, r, c);
		}
		else if(r<size/2 & c>=size/2) {
			cnt += (size * size /4);
			zNum(size/2, r, c-size/2);
		}
		else if(r>=size/2 & c<size/2) {
			cnt += (size * size/4) * 2;
			zNum(size/2, r-size/2, c);
		}else if(r >=size/2 & c >=size/2) {
			cnt+= (size * size/4) * 3;
			zNum(size/2, r-size/2, c-size/2);
		}
		
	}

	

}
