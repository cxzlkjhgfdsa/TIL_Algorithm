import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int zero [] = new int[41];
		int one [] = new int [41];
		
		zero[0]=1; zero[1]=0;
		one[0]=0; one[1]=1;
		
		for(int i=2; i<41; i++) {
			one[i]=one[i-1]+one[i-2];
			zero[i]=zero[i-1]+zero[i-2];
		}
		
		int T = Integer.parseInt(br.readLine());
		for(int tc=0; tc<T; tc++) {
			int n = Integer.parseInt(br.readLine());
			sb.append(zero[n]+" "+one[n]+"\n");
			
			
		}
		System.out.println(sb);

	}

}
