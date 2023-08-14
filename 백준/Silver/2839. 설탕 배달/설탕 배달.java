import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main{

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int minCnt=Integer.MAX_VALUE;
		int cnt=0;
		int idx=0;
		boolean isdo = false;
		
		int N = Integer.parseInt(br.readLine());
		
		while(true) {
			cnt=0;
			int check = N;
			if(5*idx>N)
				break;
			
			if(check-5*idx>=0) {
				check = check-5*idx;
				cnt+=idx;
			}
			if(check%3==0) {
				cnt+=check/3;
				isdo=true;
				if(cnt<minCnt)
					minCnt=cnt;		
			}			
			idx++;			
		
		}
		if(!isdo)
			minCnt=-1;
		System.out.println(minCnt);

	}

}
