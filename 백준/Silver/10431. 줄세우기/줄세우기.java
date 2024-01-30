import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String[] input;

        int P = Integer.parseInt(br.readLine());

        for(int i = 1; i <= P; i++){
            sb.append(i).append(" ");

            input = br.readLine().split(" "); // 학생들의 순서를 입력받음

            ArrayList<Integer> list = new ArrayList<>(); // 줄세우기를 위한 ArrayList
            int ans = 0;  //  뒤로 물러난 걸음수를 저장하는 변수

            list.add(Integer.parseInt(input[1])); // 첫번쨰 사람은 미리 넣어둠

            for(int j = 2; j <= 20; j++){ // 두 번째 순서부터 20번째 순서까지

                int cur = Integer.parseInt(input[j]);  // 현재 사람의 키
                boolean in = false;  // 중간에 삽입 했는지 안했는지 알기위한 변수

                for(int k = 0; k < list.size(); k++){
                    if(list.get(k) > cur){  // 만약 키 큰 애가 1명 이상있다면 가장 앞에있는 애 앞에 서기때문에 앞에서부터 체크
                        ans += (list.size()- k);
                        list.add(k, cur);  // 가장 앞에있는에 바로 앞에 삽입한다
                        in = true;
                        break;
                    }
                }

                if(!in)
                    list.add(cur);

            }

            sb.append(ans).append("\n");

        }
        System.out.println(sb);
    }
}
