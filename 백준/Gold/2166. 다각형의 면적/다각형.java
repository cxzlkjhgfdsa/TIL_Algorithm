import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input;

        int N = Integer.parseInt(br.readLine());
        double[][] polygon = new double[N+1][2];
        for(int i=0; i<N; i++){
            input = br.readLine().split(" ");
            double x = Double.parseDouble(input[0]);   // 다각형을 이루는 정점의 x 좌표
            double y = Double.parseDouble(input[1]);   // 다각형을 이루는 정점의 y 좌표

            polygon[i][0] = x;
            polygon[i][1] = y;
        }

        polygon[N][0] = polygon[0][0];
        polygon[N][1] = polygon[0][1];  // 다각형을 이루는 마지막점 = 처음 점 이기 떄문에 추가해줌

        double area = 0;
        for(int i=0; i<N; i++){
            area += (polygon[i][0] + polygon[i+1][0]) * (polygon[i][1] - polygon[i+1][1]);
        }

        double ans = Math.abs(area) / 2;

        System.out.printf("%.1f", ans);

    }
}
