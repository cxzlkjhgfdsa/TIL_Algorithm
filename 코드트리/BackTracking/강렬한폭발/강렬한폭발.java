import java.io.*;
import java.util.*;

public class Main {

    static int[] dx1 = {-2, -1, 1, 2};
    static int[] dy1 = {0, 0, 0, 0};
    static int[] dx2 = {-1, 0, 1, 0};
    static int[] dy2 = {0, 1, 0, -1};
    static int[] dx3 = {-1, 1, 1, -1};
    static int[] dy3 = {1, 1, -1, -1};
    
    static int N;
    static int size, max;
    static ArrayList<Pos> list;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input;

        N = Integer.parseInt(br.readLine());

        int map[][] = new int[N][N];
        list = new ArrayList<>();
        max = 0;

        for(int i = 0; i < N; i++){
            input = br.readLine().split(" ");
            for(int j = 0; j < N; j++){
                map[i][j] = Integer.parseInt(input[j]);
                if(map[i][j] == 1){
                    list.add(new Pos(i, j));
                }
            }
        }

        size = list.size();

        boomed(0, map);

        System.out.println(max);


        
        
    }

    private static void boomed(int cnt, int[][] map){
        if(cnt == size){
            int sum = 0;
            for(int i = 0; i < N; i++){
                for(int j = 0; j < N; j++){
                    //System.out.print(map[i][j]+" ");
                    if(map[i][j] == 1){
                        sum++;
                    }
                }
                //System.out.println();
            }
            //System.out.println();
            max = Math.max(max, sum);

            return;
        }

        Pos p = list.get(cnt);

        int[][] copyMap = copy(map);

        {
            for(int i = 0; i<4; i++){
                int cx = p.x+dx1[i];
                int cy = p.y+dy1[i];

                if(cx < 0 || cx >= N || cy < 0 || cy >= N)
                    continue;
                copyMap[cx][cy] = 1;
            }

            boomed(cnt + 1, copyMap);
        }

        copyMap = copy(map);

        {
            for(int i = 0; i<4; i++){
                int cx = p.x+dx2[i];
                int cy = p.y+dy2[i];

                if(cx < 0 || cx >= N || cy < 0 || cy >= N)
                    continue;
                copyMap[cx][cy] = 1;
            }

            boomed(cnt + 1, copyMap);
        }

        copyMap = copy(map);


        {
            for(int i = 0; i<4; i++){
                int cx = p.x+dx3[i];
                int cy = p.y+dy3[i];

                if(cx < 0 || cx >= N || cy < 0 || cy >= N)
                    continue;
                copyMap[cx][cy] = 1;
            }

            boomed(cnt + 1, copyMap);
        }


    }

    private static int[][] copy(int[][] map){
        int[][] copyMap = new int[N][N];

        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                copyMap[i][j] = map[i][j];
            }
        }

        return copyMap;
    }
}

class Pos{
    int x, y;
    public Pos(int x, int y){
        this.x = x; 
        this.y = y;
    }
}