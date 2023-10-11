import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input;

        input = br.readLine().split(" ");

        int n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);
        int k = Integer.parseInt(input[2]) - 1;

        int[][] map = new int[n][n];

        for(int i = 0; i < n; i++){
            input = br.readLine().split(" ");
            for(int j = 0; j < n; j++){
                map[i][j] = Integer.parseInt(input[j]);
            }
        }

        for(int i = 0; i < n; i++){
            boolean stop = false;

            for(int j = k; j < k+m; j++){
                if(map[i][j] == 1)
                    stop = true;
            }

            if(stop){
                if(i - 1 >= 0){
                    for(int j = k; j < k+m; j++){
                        map[i-1][j] = 1;
                    }
                    break;
                }else{
                    break;
                }
            }

            if(i == n-1){
                for(int j = k; j < k+m; j++){
                        map[i][j] = 1;
                }
            }
        }

        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                System.out.print(map[i][j]+" ");
            }
            System.out.println();
        }


    }
}