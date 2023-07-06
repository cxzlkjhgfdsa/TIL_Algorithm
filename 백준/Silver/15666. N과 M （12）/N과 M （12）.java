import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedHashSet;

public class Main {

    static int N, M;
    static int[] combArr;
    static int[] inputNum;
    static LinkedHashSet<String> set = new LinkedHashSet<>();


    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input;

        input = br.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);

        combArr = new int[M];
        inputNum = new int[N];

        input = br.readLine().split(" ");
        for(int i=0; i<N; i++){
            inputNum[i] = Integer.parseInt(input[i]);
        }

        Arrays.sort(inputNum);
        findComb(0, 0);
        for(String s : set){
            System.out.println(s);
        }

    }

    static void findComb(int start, int cnt){
        if(cnt == M){
            String s = "";;
            for(int n : combArr){
                s+=n+" ";
            }
            set.add(s);
            return;
        }

        for(int i=start; i<N; i++){
            combArr[cnt] = inputNum[i];
            findComb(i, cnt+1);
        }
    }
}
