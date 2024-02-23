import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input;
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        input = br.readLine().split(" ");

        int[] cards = new int[N];

        for (int i = 0; i < N; i++) {
            cards[i] = Integer.parseInt(input[i]);
        }

        Arrays.sort(cards);  // 이분탐색하기 위해 정렬

        int M = Integer.parseInt(br.readLine());
        input = br.readLine().split(" ");

        for (int i = 0; i < M; i++) {

            int k = Integer.parseInt(input[i]);
            sb.append(findHigh(k, cards) - findLow(k, cards)).append(" ");

        }

        System.out.println(sb);

    }

    private static int findLow(int n, int[] cards) { // 같은 숫자들의 낮은 인덱스를 찾기위한 함수
        int lo = 0;
        int hi = cards.length;

        while (lo < hi) {

            int mid = (lo + hi) / 2;

            if (n <= cards[mid]) { // n이 작거나 같을시 hi를 계속 줄여서 n의 최소 인덱스 값을 찾음
                hi = mid;
            } else {
                lo = mid + 1;
            }

        }

        return lo;

    }

    private static int findHigh(int n, int[] cards) { // 같은 숫자들의 높은 인덱스를 찾기위한 함수
        int lo = 0;
        int hi = cards.length;

        while (lo < hi) {

            int mid = (lo + hi) / 2;

            if (n < cards[mid]) {
                hi = mid;
            } else {  // n 이 크거나 같을 때는 lo를 높여 최대 인덱스 값을 찾음
                lo = mid + 1;
            }

        }

        return lo;

    }
}
