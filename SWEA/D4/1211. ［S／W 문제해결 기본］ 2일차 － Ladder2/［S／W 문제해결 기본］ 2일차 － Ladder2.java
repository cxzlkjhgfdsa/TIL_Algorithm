import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input;

        for(int t = 0; t < 10; t++){
            int tc = Integer.parseInt(br.readLine());

            int[][] ladder = new int[100][100];

            int min = 10000;
            int ans = -1;

            for(int i = 0; i < 100; i++){
                input = br.readLine().split(" ");
                for(int j = 0; j < 100; j++){
                    ladder[i][j] = Integer.parseInt(input[j]);
                }
            }

            for(int i = 0; i < 100; i++){
                if(ladder[0][i] == 1){
                    int cur = distance(ladder, 0 , i);
                    if(cur <= min){
                        ans = i;
                        min = cur;
                    }
                }
            }

            System.out.println("#"+tc+" "+ans);
        }

    }

    private static int distance(int[][] ladder , int x, int y){

        int cx = x;
        int cy = y;
        int dis = 1;  // 1 아래 , 2 왼쪽 , 3 오른쪽
        int cnt = 0;

        while(x < 99){

            if(dis == 1){
                x++;
                cnt++;

                if(y > 0){
                    if(ladder[x][y-1] == 1){
                        dis = 2;
                    }
                }

                if(y < 99) {
                    if (ladder[x][y + 1] == 1) {
                        dis = 3;
                    }
                }
            }else if(dis == 2){
                y--;
                cnt++;
                if(ladder[x+1][y] == 1)
                    dis = 1;

            }else{
                y++;
                cnt++;
                if(ladder[x+1][y] == 1)
                    dis =1;
            }
        }
        return cnt;
    }
}

