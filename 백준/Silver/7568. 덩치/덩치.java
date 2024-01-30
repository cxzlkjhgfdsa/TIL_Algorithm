import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input;
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine()); // 사람 수

        int[][] size = new int[N][2]; // 덩치들을 저장할 2차원 배열

        for(int i = 0; i < N; i++){  // 덩치들을 저장
            input = br.readLine().split(" ");
            size[i][0] = Integer.parseInt(input[0]);
            size[i][1] = Integer.parseInt(input[1]);
        }

        for(int i = 0; i < N; i++){  // 사람 한명씩 나기보다 덩치큰 사람이 얼마나 있는지 체크
            int count = 0; // 덩치큰사람이 얼마나 있는지 체크

            int curX = size[i][0];  // 현재사람 키
            int curY = size[i][1]; // 현재사람 몸무게

            for(int j = 0; j < N; j++){
                if(i == j) //  같은사람이면 패스
                    continue;
                if(size[j][0] > curX && size[j][1] > curY){  // 키 몸무게 둘다 크다면 덩치가 큰사람 이기 때문에 count + 1
                    count++;
                }
            }

            sb.append(count+1).append(" ");

        }

        System.out.println(sb);

    }
}
