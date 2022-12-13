import java.io.BufferedReader;
import java.io.InputStreamReader;

public class SWEA_Flatten {
    static int [] box = new int [100];

    public static void main(String[] args) throws  Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String input[];

        for(int tc=1; tc<=10; tc++){
            int T = Integer.parseInt(br.readLine());

            input = br.readLine().split(" ");
            for(int i=0; i<100; i++){
                box[i] = Integer.parseInt(input[i]);  // 박스의 높이를 입력받음
            }

            for(int i=0; i<T; i++){
                dump(); // 정해진 횟수만큼 상자 옮기기 실행
            }

            int min = 100;
            int max = 0;

            for(int i=0; i<100; i++){  // 최고높이와 최저높이를 알아낸다
                min = Math.min(box[i], min);
                max = Math.max(box[i], max);
            }

            sb.append("#").append(tc).append(" ").append(max-min).append("\n");


        }
        System.out.println(sb);

    }

    public static void dump(){ // 최대 높이의 상자에서 최저 높이의 상자로 옮기는 작업
        int min = 100;
        int max = 0;
        int minIdx=0;
        int maxIdx=0;

        for(int i=0; i<100; i++){  // 가장높은 상자와 낮은 상자의 배열상의 위치를 알기위한 알고리즘ㄴ
            if(box[i]>max){
                max = box[i];
                maxIdx = i;
            }
            if(box[i]<min){
                min = box[i];
                minIdx = i;
            }

        }

        box[maxIdx]--;
        box[minIdx]++;

    }
}
