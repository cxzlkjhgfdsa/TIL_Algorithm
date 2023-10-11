import java.util.*;
import java.io.*;

public class Main {

    int[] dx = {-1, 0, 1, 0};
    int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input;

        int N = Integer.parseInt(br.readLine());

        int[][] map = new int[N][N];

        for(int i = 0; i < N; i++){
            input = br.readLine().split(" ");
            for(int j = 0; j < N; j++){
                map[i][j] = Integer.parseInt(input[j]);
            }
        }

        input = br.readLine().split(" ");
        int x = Integer.parseInt(input[0]) - 1;
        int y = Integer.parseInt(input[1]) - 1;

        int size = map[x][y];

        //위쪽 터뜨려
        for(int i=x; i>x - size; i--){
            if(i < 0){
                break;
            }
            map[i][y] = 0;
        }

        // 오른쪽 터뜨려
        for(int i=y; i<y+size; i++){
            if(i >= N){
                break;
            }
            map[x][i] = 0;
        }

        for(int i = x; i < x + size; i++){
            if(i >= N){
                break;
            }
            map[i][y] = 0;
        }

        for(int i = y; i > y - size; i--){
            if(i < 0){
                break;
            }
            map[x][i] = 0;
        }

        Queue<Integer> que = new ArrayDeque<>();

        for(int i=0; i<N; i++){
            for(int j = N - 1; j >= 0; j--){
                if(map[j][i] != 0){
                    que.add(map[j][i]);
                    map[j][i] = 0;
                }
            }

            for(int j = N - 1; j >= 0; j--){
                if(que.isEmpty()){
                    break;
                }
                map[j][i] = que.poll();
            }
        }

        
        
        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                System.out.print(map[i][j]+" ");
            }
            System.out.println();
        }

        
    }
}