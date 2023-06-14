import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	static int[][] farm;
	static boolean check[][];
	static int dx[] = { 0, 0, -1, 1 };
	static int dy[] = { -1, 1, 0, 0 };
	static int x, y, cx, cy, M, N;

	static void find(int x, int y) {
		check[y][x] = true;

		for (int i = 0; i < 4; i++) {
			cx = x + dx[i];
			cy = y + dy[i];

			if (cx >= 0 && cx < M && cy >= 0 && cy < N) {
				if (!check[cy][cx] && farm[cy][cx] == 1) {
					find(cx, cy);
				}
			}
		}

	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		String[] input;
		int cnt;

		int T = Integer.parseInt(br.readLine());
		for (int tc = 0; tc < T; tc++) {
			cnt = 0;

			input = br.readLine().split(" ");
			M = Integer.parseInt(input[0]);
			N = Integer.parseInt(input[1]);
			int K = Integer.parseInt(input[2]);

			farm = new int[N][M];
			check = new boolean[N][M];
			for (int i = 0; i < K; i++) {
				input = br.readLine().split(" ");
				farm[Integer.parseInt(input[1])][Integer.parseInt(input[0])] = 1;
			}
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if (farm[i][j] == 1 && !check[i][j]) {
						find(j, i);
						cnt++;

					}

				}
			}

			System.out.println(cnt);

		}

	}

}
