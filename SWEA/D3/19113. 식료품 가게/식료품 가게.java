import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String[] input;

        int T = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= T; tc++) {
            sb.append("#").append(tc).append(" ");

            Map<Integer, Integer> map = new HashMap<>();

            int n = Integer.parseInt(br.readLine());

            int[] food = new int[2 * n];

            input = br.readLine().split(" ");

            for (int i = 0; i < n * 2; i++) {
                food[i] = Integer.parseInt(input[i]);
                if (map.get(food[i]) == null) {
                    map.put(food[i], 1);
                } else {
                    map.put(food[i], map.get(food[i]) + 1);
                }
            }

            for (int next : food) {
                int sum = next + (next / 3);

                if (map.get(sum) != null && map.get(sum) >= 1 && map.get(next) >= 1) {
                    sb.append(next).append(" ");
                    map.put(sum, map.get(sum) - 1);
                    map.put(next, map.get(next) - 1);
                }
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}