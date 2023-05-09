import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	static int K;
	static boolean[] isSel;
	static int[] num;
	static int totalCnt = 0;
	static int allCase[][];

	static void perm(int cnt) {
		if (cnt == K) {
			for (int i = 0; i < K; i++) {
				allCase[totalCnt][i] = num[i];
			}
			totalCnt++;
			return;
		}

		for (int i = 0; i < K; i++) {
			if (isSel[i])
				continue;
			num[cnt] = i;
			isSel[i] = true;
			perm(cnt + 1);
			isSel[i] = false;
		}
	}

	static int fact(int n) {
		int p = 1;
		for (int i = 1; i <= n; i++) {
			p = p * i;
		}
		return p;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int min = Integer.MAX_VALUE;
		final int[] dx = { 1, 0, -1, 0 };// 하,우,상,좌
		final int[] dy = { 0, 1, 0, -1 };// ""

		String input[];
		int r, c, s, sum;

		input = br.readLine().split(" ");
		int N = Integer.parseInt(input[0]);
		int M = Integer.parseInt(input[1]);
		K = Integer.parseInt(input[2]);

		int arr[][] = new int[N][M];
		int tempArr[][] = new int[N][M];
		int all[][] = new int[K][3];
		allCase = new int[fact(K)][K];
		num = new int[K];
		isSel = new boolean[K];

		for (int i = 0; i < N; i++) {
			input = br.readLine().split(" ");
			for (int j = 0; j < M; j++) {
				arr[i][j] = Integer.parseInt(input[j]);
				tempArr[i][j] = arr[i][j];

			}
		}
		for (int i = 0; i < K; i++) {
			input = br.readLine().split(" ");
			for (int j = 0; j < 3; j++)
				all[i][j] = Integer.parseInt(input[j]);
		}
		perm(0);				
		
		for (int l = 0; l < totalCnt; l++) {
			for(int w=0; w<N; w++) {
				for(int v=0; v<M; v++) {
					arr[w][v]=tempArr[w][v];
				}
			}
			
			for (int q = 0; q < K; q++) {
				r = all[allCase[l][q]][0];
				c = all[allCase[l][q]][1];
				s = all[allCase[l][q]][2];				

				for (int i = 0; i < s; i++) {
					int x = r - s - 1 + i;
					int y = c - s - 1 + i;
					int temp = arr[x][y];
					int cnt = 0;
					while (cnt < 4) {
						int nx = x + dx[cnt];
						int ny = y + dy[cnt];
						if (nx < r - s - 1 + i || nx > r + s - 1 - i || ny < c - s - 1 + i || ny > c + s - 1 - i) {
							cnt++;
						} else {
							arr[x][y] = arr[nx][ny];
							x = nx;
							y = ny;
						}

					}
					arr[x][y + 1] = temp;
				}

			}
			for (int i = 0; i < N; i++) {
				sum = 0;
				for (int j = 0; j < M; j++) {
					sum += arr[i][j];

				}
				if (sum < min) {
					min = sum;
				}

			}


		}
		
		System.out.println(min);

	}

}
