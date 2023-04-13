import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static class Robot{
        int x, y, dir;

        public Robot(int x, int y, int dir){
            this.x = x;
            this.y = y;
            this.dir = dir;
        }
    }

    static int N, M;
    static int[][] map;

    static int[] xBack = {1,0, -1, 0 };
    static int[] yBack = {0,-1, 0, 1};

    static int[] xFront = {-1, 0, 1, 0};
    static int[] yFront = {0, 1, 0, -1};

    static Robot robot;
    static int answer;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input;

        input = br.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);

        input = br.readLine().split(" ");
        map = new int[N][M];

        robot = new Robot(Integer.parseInt(input[0]), Integer.parseInt(input[1]), Integer.parseInt(input[2]));

        for(int i=0; i<N; i++){
            input = br.readLine().split(" ");
            for(int j=0; j<M; j++){
                map[i][j] = Integer.parseInt(input[j]);
            }
        }

        answer = 0;
        cleanOne();

        System.out.println(answer);
    }

    public static void cleanOne(){
        int x = robot.x;
        int y = robot.y;
        int dir = robot.dir;

        if(map[x][y] == 0){  // 만약 현재칸이 청소되지 않은 경우 현재 칸 청소
            answer++;
            map[x][y] = 2;
        }

        if(!(map[x-1][y]==-0 || map[x+1][y] == 0 || map[x][y+1] == 0 || map[x][y-1] == 0)){  // 4개합 == 4 => 주면 4칸중 청소되지 않은 빈칸이 없는것
            if(map[x+xBack[dir]][y+yBack[dir]]==1){
                return;
            }else{
                robot.x = x+xBack[dir];
                robot.y = y+yBack[dir];
                cleanOne();
                return;
            }
        }

        if(dir == 0){
            robot.dir = 3;
        }else{
            robot.dir = dir-1;
        }

        dir = robot.dir;
        if(map[x+xFront[dir]][y+yFront[dir]] == 0){
            robot.x = x+xFront[dir];
            robot.y = y+yFront[dir];
        }
        cleanOne();
        return;
    }


}
