import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input[];
		int map[][];
		int chicken[][];
		int house[][];
		int cnt = 0;
		int min[];
		int hcnt = 0;
		int sum = 0;
		int totalSum = 0;
		int minTotal = Integer.MAX_VALUE;

		input = br.readLine().split(" ");
		int N = Integer.parseInt(input[0]);
		int M = Integer.parseInt(input[1]);

		map = new int[N][N];

		for (int i = 0; i < N; i++) {
			input = br.readLine().split(" ");
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(input[j]);
				if (map[i][j] == 2) {
					cnt++;
				}
				if (map[i][j] == 1) {
					hcnt++;
				}
			}
		}
		min = new int[hcnt];
		for (int i = 0; i < hcnt; i++) {
			min[i] = 2 * N;
		}
		house = new int[hcnt][2];
		chicken = new int[cnt][2];
		cnt = 0;
		hcnt = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (map[i][j] == 2) {
					chicken[cnt][0] = i;
					chicken[cnt][1] = j;
					cnt++;
				}
				if (map[i][j] == 1) {
					house[hcnt][0] = i;
					house[hcnt][1] = j;
					hcnt++;
				}
			}
		}
		if (M > 1) {
			for (int i = 0; i < 1 << cnt; i++) {
				int check = 0;
				for (int j = 0; j < cnt; j++) {
					if ((i & 1 << j) != 0) {
						check++;
					}
				}
				if (check == M) {
					for (int x = 0; x < hcnt; x++) {
						min[x] = 2 * N;
					}
					for (int j = 0; j < cnt; j++) {
						if ((i & 1 << j) != 0) {
							for (int k = 0; k < hcnt; k++) {
								sum = Math.abs(house[k][0] - chicken[j][0]) + Math.abs(house[k][1] - chicken[j][1]);
								if(min[k]>sum) {
									min[k]=sum;
								}								

							}							
						}
						totalSum = 0;
						for (int y = 0; y < min.length; y++) {
							totalSum += min[y];
						}
						if (totalSum < minTotal)
							minTotal = totalSum;
					}

				}
			}
		}else {
			for(int i=0; i<chicken.length; i++) {
				totalSum=0;
				for(int j=0; j<house.length; j++) {
					totalSum += Math.abs(house[j][0]-chicken[i][0])+Math.abs(house[j][1]-chicken[i][1]);
				}
				if(totalSum<minTotal) {
					minTotal=totalSum;
				}
			}
		}

		System.out.println(minTotal);
	}

}
