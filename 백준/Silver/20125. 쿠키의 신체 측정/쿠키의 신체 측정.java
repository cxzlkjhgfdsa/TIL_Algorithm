import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine()); // 쿠키판 한 변의 길이

        String[][] map = new String[N][N];  // 쿠키 판의 정보를 저장할 2차원배열

        for(int i = 0; i < N; i++){
            map[i] = br.readLine().split(""); // 쿠키 판의 정보를 받는다
        }

        Cookie heart  = null; // 쿠키의 심장 좌표 저장

        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                if(map[i][j].equals("*")){  // 왼쪽 맨 위부터 오른쪽 아래까지 탐색했을 때 가장 먼저 나온 * == 머리 그거보다 한칸 아래가 심장
                    heart = new Cookie((i+1),j );
                    break;
                }
            }
            if(heart != null)
                break;
        }

        int leftArm = 0; // 왼쪽 팔길이
        int rightArm = 0; // 오른쪽 팔길이
        int waist = 0; // 허리길이
        int leftLeg = 0; // 왼쪽 다리 길이
        int rightLeg = 0; //  오른쪽 다리길이

        int waistX = 0;// 허리의 x 좌표


        for(int i = heart.y - 1; i >= 0; i--){  // 심장부터 왼쪽 팔길이가 몇인지 탐색
            leftArm++;
            if( i - 1 < 0 || map[heart.x][i-1].equals("_"))  // 범위를 벗어나거나 쿠키가 아니면 탈출
                break;
        }

        for(int i = heart.y + 1; i < N; i++){
            rightArm++;
            if( i + 1 >= N || map[heart.x][i+1].equals("_")) // 범위를 벗어나거나 쿠키가 아니면 탈출
                break;
        }

        for(int i = heart.x + 1; i < N; i++){  // 허리도 마찬가지로 체크
            waist++;
            if(i + 1 >= N || map[i+1][heart.y].equals("_")){
                waistX = i;
                break;
            }
        }

        boolean find = false;

        for(int i = N-1; i >= 0; i--){
            for(int j = 0; j < N; j++) {
                if (map[i][j].equals("*") && j < heart.y) {  // 왼쪽 아래 구석부터 위로 올라가면석 탐색했을 떄 가장 첫번 째로 나온 * 가 심장보다 왼쪽일 시 왼쪽 다리의 끝단
                    leftLeg = i - waistX;  // 왼쪽다리의 끝단의 x 좌표 ( 세로 좌표 ) - 허리의 끝단 == 다리길이
                    find =true;
                    break;
                }
            }
            if(find)
                break;
        }

        find = false;

        for(int i = N-1; i >= 0; i--){
            for(int j = N-1 ; j >= 0; j--){
                if(map[i][j].equals("*") && j > heart.y){  // 왼쪽다리와 마찬가지로 오른쪽 다리 길이도 구할 수 있다
                    rightLeg  = i - waistX;
                    find = true;
                    break;
                }
            }
            if(find)
                break;
        }

        System.out.println((heart.x+1) +" "+(heart.y+1));  // 출력
        System.out.println(leftArm+" " +rightArm+" "+waist+" "+leftLeg+" "+rightLeg);


    }
}

class Cookie{  //쿠키의 좌표값을 받기 위한 클래스
    int x, y;

    public Cookie(int x, int y){
        this.x = x;
        this.y =y;
    }

    public boolean isEqual(Cookie c){  // 같은 좌표인지 확인하기 위한 메서드
        if(this.x == c.x && this.y == c.y)
            return true;
        return false;
    }

}
