import java.util.*;
import java.io.*;

public class Main {

    static int[] dice;
    static int n, m, k;
    static int max;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input;

        input = br.readLine().split(" ");

        n = Integer.parseInt(input[0]);
        m = Integer.parseInt(input[1]);
        k = Integer.parseInt(input[2]);
        max = 0;

        dice = new int[n];
        int[] player = new int[k];

        input = br.readLine().split(" ");
        for(int i = 0; i < n; i++){
            dice[i] = Integer.parseInt(input[i]);
        }

        game(0, player);

        System.out.println(max);
    }

    private static void game(int cnt, int[] player){

        if(cnt == n){
            int count = 0;
            for(int i : player){
                if(i >= m-1)
                    count++;
            }
            max = Math.max(count, max);
            return;
        }
        
        for(int i = 0; i < k; i++){
            player[i] += dice[cnt];
            game(cnt + 1, player);
            player[i] -= dice[cnt];
        }
    }
}