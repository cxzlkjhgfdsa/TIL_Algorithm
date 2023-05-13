import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input[];
		boolean toggle=false;
		
		input = br.readLine().split(" ");
		
		int N = Integer.parseInt(input[0]);
		int d = Integer.parseInt(input[1]);
		int k = Integer.parseInt(input[2]);
		int c = Integer.parseInt(input[3]);
		
		int max=0;
		int size=0;
		
		int sushi[] = new int[N];		
		int eat[] = new int[d+1];
		
		for(int i=0; i<N; i++) {
			sushi[i] = Integer.parseInt(br.readLine());
			if(sushi[i]==c) {
				toggle=true;
			}
		}
		
		
		
		for(int i=0; i<k; i++) {
			if(eat[sushi[i]]==0)
				size++;
			eat[sushi[i]]++;			
		}
		
		max = size;		
		
		for(int i=0; i<N-1; i++) {
			if(size>= max) {
				if(eat[c]==0) {
					max = size+1;
				}else {
					max=size;
				}
				
				
			}
			
			eat[sushi[i]]--;
			
			if(eat[sushi[i]]==0)
				size--;
			if(eat[sushi[(i+k)%N]]==0) {
				size++;
			}
			eat[sushi[(i+k)%N]]++;
			
		}
		System.out.println(max);		
		
	}

}
