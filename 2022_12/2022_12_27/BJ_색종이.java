import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BJ_색종이 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String [] input;

        boolean [][] paper = new boolean[101][101];  //도화지를 나타내는 배열
        int ans = 0;                                 // 색칠된 넓이

        int T = Integer.parseInt(br.readLine());    //색종이 개수

        for(int t=0; t<T; t++){
            input = br.readLine().split(" ");

            int x = Integer.parseInt(input[0]);   // 색종이가 y축과 떨어져있는 거리
            int y = Integer.parseInt(input[1]);   // 색종이가 x축과 떨어져있는 거리

            for(int i=x; i<x+10; i++){    // 색종이의 사이즈가 10 * 10 이기 때문에 10 * 10 만큼 색칠
                for(int j=y; j<y+10; j++){
                    if(i>=100 || j>=100){  // 범위 밖이면 패스
                        continue;
                    }
                    if(!paper[i][j]){   // 아직 색칠 안된 곳이면 색칠 후 검은색 범위 ++
                        paper[i][j]=true;
                        ans++;
                    }
                }
            }

        }
        System.out.println(ans);  // 정답 출력
    }
}
