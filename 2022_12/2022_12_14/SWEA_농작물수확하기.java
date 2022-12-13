import java.io.BufferedReader;
import java.io.InputStreamReader;

public class SWEA_농작물수확하기 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String [] input;

        int T = Integer.parseInt(br.readLine()); // 테스트 케이스 수
        for(int tc=1; tc<=T; tc++){
            
            int N = Integer.parseInt(br.readLine()); //농장의 크기
            int [][] farm = new int [N][N]; //농장의 정보를 저장하는 배열

            for(int i=0; i<N; i++){
                input = br.readLine().split("");
                for(int j=0; j<N; j++){
                    farm[i][j] = Integer.parseInt(input[j]);
                }
            }

            int mid = N/2;  // 농장의 가운데
            int ans = 0;   // 정답을 저장할 변수

            for(int i=0; i<N; i++){
                for(int j=0; j<N; j++){
                    if(i<=mid){  // 마름모의 상단 부분
                        if(j>=mid-i && j<=mid+i){ // 가로세로가 중간 지점에서 i만큼 더하고 뺸값 사이값이면 더함
                            ans+=farm[i][j];
                        }
                    }else{  // 마름모의 하단부분
                        if(j>=mid-(N-1-i) && j<=mid+(N-1-i)){ // 가로세로가 중간지점에서 (N-1-i) 만큼 더하고 뺸값 사이값이면 더함
                            ans+=farm[i][j];
                        }
                    }
                }
            }

            sb.append("#").append(tc).append(" ").append(ans).append("\n"); // 스트랑빌더에 넣음


        }
        System.out.println(sb);
    }
}
