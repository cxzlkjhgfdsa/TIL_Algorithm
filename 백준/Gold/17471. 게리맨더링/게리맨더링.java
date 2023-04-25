import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.TreeSet;

public class Main {	

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input [];
		int cost[];		
		int N = Integer.parseInt(br.readLine());
		Queue<Integer> que1 = new ArrayDeque<Integer>();
		Queue<Integer> que2 = new ArrayDeque<Integer>();
		TreeSet<Integer> tree1 = new TreeSet<>();
		TreeSet<Integer> tree2 = new TreeSet<>();
		int ans=2000;
		
		cost = new int[N];		
		int map[][] = new int[N][N];
		
		input = br.readLine().split(" ");
		
		for(int i=0; i<N; i++) {
			cost[i] = Integer.parseInt(input[i]);
		}
		
		for(int i=0; i<N; i++) {
			input = br.readLine().split(" ");
			int k = Integer.parseInt(input[0]);
			for(int j=1; j<=k; j++) {
				map[i][Integer.parseInt(input[j])-1]=1;		
			}					
			
		}
		
		
		
		int sum1=0, sum2=0, cnt1=0, cnt2=0;					
		boolean visited1[] = new boolean[10];
		boolean visited2[] = new boolean[10];
		
		
		for(int i=0; i< 1<<N; i++) {
			sum1=0; sum2=0; cnt1=0; cnt2=0;
			tree1.clear();
			tree2.clear();
			que1.clear();
			que2.clear();
			visited1 = new boolean[10];
			visited2 = new boolean[10];
			
			
			for(int j=0; j<N; j++) {
				if((i & 1<< j)==0) {
					tree1.add(j);
//					System.out.print(j+" ");
				}else {
					tree2.add(j);					
				}
			}
//			System.out.println();
			
			if(tree1.size()==0 || tree2.size()==0)
				continue;
								
			que1.offer(tree1.last());
			visited1[tree1.last()] = true;
			que2.offer(tree2.last());
			visited2[tree2.last()] = true;
			
//			System.out.println(tree1.last()+" "+tree2.last());
//			System.out.println(tree1.size()+" "+tree2.size());
//			System.out.print("que1 : ");
			while(!que1.isEmpty()) {
				int n = que1.poll();				
				cnt1++;
				sum1+=cost[n];
				
//				System.out.print(n+" ");
				
				for(int j=0; j<N; j++) {
					if(map[n][j]==1 && tree1.contains(j) && !visited1[j]) {
						que1.offer(j);		
						visited1[j] = true;
					}			
					
				}			
				
			}
//			System.out.println();
//			System.out.print("que2 : ");
			
			while(!que2.isEmpty()) {
				int n = que2.poll();				
				cnt2++;
				sum2+=cost[n];
				
//				System.out.print(n+" ");
				
				for(int j=0; j<N; j++) {
					if(map[n][j]==1 && tree2.contains(j)&& !visited2[j]) {
						que2.offer(j);
						visited2[j]=true;
					}				
				}			
				
			}
//			System.out.println();
			
			
			
			if(cnt1!=tree1.size() || cnt2!=tree2.size())
				continue;
			
//			System.out.println(sum1+" "+sum2);
			
			
			ans = Math.min(ans, Math.abs(sum1-sum2));
			
			
			
			
		}
		
		if(ans==2000)
			ans=-1;
		
		System.out.println(ans);
		
	}

}
