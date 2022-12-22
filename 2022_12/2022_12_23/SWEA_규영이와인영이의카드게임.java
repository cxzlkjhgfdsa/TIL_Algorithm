import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class SWEA_규영이와인영이의카드게임 {
    static int [] gyu; //규영이의 카드
    static int [] in;  // 인영이카드
    static boolean [] selected = new boolean[9]; // 순열에서 선택된 것을 확인하기 위한배열

    static int [] num = new int[9];  // 순열을 만들기 위한 배열
    static int gyuWin=0; // 규영이가 이긴 횟수
    static int inWin=0;  // 인영이가 이긴 횟수

    static int GyuPoint = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String [] input;

        int T = Integer.parseInt(br.readLine());  // 테스트케이스 수

        for(int tc=1; tc<=T; tc++){
            gyu = new int[9];  
            in = new int[9];
            input = br.readLine().split(" ");
            for(int i=0; i<9; i++){
                gyu[i] = Integer.parseInt(input[i]);  // 규영이가 낼 카드 입력받음
            }

            int idx = 0;
            boolean check = true;
            for(int i=1; i<=18; i++){  // 인영이가 받은 카드를 구하기위한 반복문
                check = true;
                for(int j=0; j<9; j++){
                    if(i==gyu[j]){
                        check=false;
                    }
                }
                if(check){
                    in[idx]=i;
                    idx++;
                }
            }
            gyuWin = 0;  // 이긴 횟수들 0 으로 초기화
            inWin = 0;

            perm(0);  // 순열 돌림
            sb.append("#").append(tc).append(" ").append(gyuWin).append(" ").append(inWin).append("\n"); // 입력
        }
        System.out.println(sb);
    }

    static void perm(int cnt){  // 순열 함수
        if(cnt==9){
            cal(num); // 순열을 완성했으면 계산
            return;
        }

        for(int i=0; i<9; i++){
            if(selected[i])
                continue;
            num[cnt] = in[i];
            selected[i] = true;
            perm(cnt+1);
            selected[i] = false;
        }
    }

    private static void cal(int[] num) {  // 카드게임 승자를 알기위한 함수
        int gyuTotal = 0;  // 규영이의 총 포인트
        int inTotal = 0;  // 인영이의 총 포인트
        for(int i=0; i<9; i++){
            if(num[i]>gyu[i]){  // 인영이가 이김
                inTotal+=num[i]+gyu[i];
            }else{   // 규영이가 이김
                gyuTotal+=num[i]+gyu[i];
            }
        }
        if(gyuTotal>inTotal){  // 전체점수로 게임의 총 승자를 판단
            gyuWin++;
        }else{
            inWin++;
        }
    }


}
