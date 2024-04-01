import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input;

        List<String>[] gears = new List[4];

        for(int i = 0; i < 4; i++){
            gears[i] = new ArrayList<>(Arrays.asList(br.readLine().split("")));
        }

        int k = Integer.parseInt(br.readLine());

        for(int tc = 0; tc < k; tc++){
            input = br.readLine().split(" ");

            int idx = Integer.parseInt(input[0]) - 1;
            int dir = Integer.parseInt(input[1]);

            simulation(idx, dir, gears);
        }

        int sum = 0;
        int mx = 1;

        for(int i = 0; i < 4; i++){
            sum += (Integer.parseInt(gears[i].get(0)) * mx);
            mx *= 2;
        }

        System.out.println(sum);
    }

    public static void simulation(int idx, int dir , List<String>[] gears){

        int temp = dir;

        int[] turn = new int[4];
        turn[idx] = dir;

        for(int i = idx; i < 3; i++){
            if(gears[i].get(2).equals(gears[i+1].get(6)))
                break;
            turn[i+1] = temp * -1;
            temp *= -1;
        }

        temp = dir;

        for(int i = idx; i > 0; i--){
            if(gears[i].get(6).equals(gears[i-1].get(2)))
                break;
            turn[i-1] = temp * -1;
            temp *= -1;
        }

        for(int i = 0; i < 4; i++){
            if(turn[i] == 0)
                continue;

            if(turn[i] == -1){
                gears[i].add(gears[i].remove(0));
            }else{
                gears[i].add(0, gears[i].remove(7));
            }
        }

    }
}
