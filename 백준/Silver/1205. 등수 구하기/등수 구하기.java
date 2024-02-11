import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input;

        input = br.readLine().split(" ");

        int N = Integer.parseInt(input[0]); // 현재 리스트에 있는 정수의 개수
        int score = Integer.parseInt(input[1]); // 새로운 점수
        int P = Integer.parseInt(input[2]); // 리스트에 올라갈 수 있는 점수의 개수

        int[] ranking = new int[N]; //  등수 저장할 변수

        if(N  > 0){
            input = br.readLine().split(" ");

            for(int i = 0; i < N; i++){
                ranking[i] = Integer.parseInt(input[i]);
            }
        }

        int answer = 1;

        for(int i = 0; i < N; i++){
            if(score >= ranking[i])
                break;
            else
                answer++;
        }

        if(N == P && ranking[N-1] >= score)
            answer = -1;




        System.out.println(answer);
    }
}
