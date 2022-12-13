import java.io.BufferedReader;
import java.io.InputStreamReader;

public class SWEA_Ladder1 {
    static int x, y;
    static int dir=1; // 1 == 위방향, 2 == 오른쪽 , 3 == 왼쪽
    static int [][] Ladder;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb= new StringBuilder();
        String [] input;

        for(int tc=1; tc<=10; tc++){
            int T = Integer.parseInt(br.readLine());
            Ladder = new int [100][100]; // 사다리 정보를 저장할 배열
            
            for(int i=0; i<100; i++){
                input = br.readLine().split(" ");
                for(int j=0; j<100; j++){
                    Ladder[i][j] = Integer.parseInt(input[j]);
                    if(Ladder[i][j]==2){ // 도착 정보를 저장
                        x = i; y= j;
                    }
                }
            }

            dir = 1;
            while(x>0){
                if(dir==1){  // 위방향
                    moveUp();
                }else if(dir==2){ // 오른쪽
                    moveR();
                }else if(dir==3){ // 왼쪽
                    moveL();
                }
            }
            sb.append("#").append(T).append(" ").append(y).append("\n");
        }
        System.out.println(sb);


    }

    static void moveUp(){  // 위방향 수행 메소드
        if(y-1>=0 && Ladder[x][y-1]==1){  // 왼쪽에 길이 있다면 변경
            dir=3;
            y--;
        }else if(y+1<100 && Ladder[x][y+1]==1){  // 오른쪽에 길이 있다면 변경
            dir=2;
            y++;
        }else{
            x--;
        }
    }

    static void moveL(){  // 왼쪽으로 이동
        if(Ladder[x-1][y]==1){  // 위로가는 길이 있다면 변경
            dir =1;
            x--;
        }else{
            y--;
        }

    }
    static void moveR(){ // 오른쪽으로 이동
        if(Ladder[x-1][y]==1){ // 위로가는 길이 있다면 변경
            dir=1;
            x--;
        }else{
            y++;
        }
    }

}
