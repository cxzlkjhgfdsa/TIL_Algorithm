import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String[] input;

        input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int M = Integer.parseInt(input[1]);

        int[] trees = new int[N];
        input = br.readLine().split(" ");
        int min = 0;
        int max = 0;  // 나무들의 높이중 가장 높은 값

        for (int i = 0; i < N; i++) {
            trees[i] = Integer.parseInt(input[i]);
            max = Math.max(max, trees[i]); // 최대높이값 갱신
        }

        while (min < max) {

            int mid = (min + max) / 2;
            long sum = 0;

            for (int h : trees) {
                if (h - mid > 0) { // 나무가 잘릴때만 계산
                    sum += (h - mid);
                }
            }

            if (sum < M) {  // 목표수치보다 작다면 자르는 높이를 낮춰야 하므로 max 값 갱신
                max = mid;
            } else {  // 그게 아니라면 최적해를 구하기 위해서 min 값 갱신
                min = mid + 1;
            }

        }

        System.out.println(min - 1);

    }
}
