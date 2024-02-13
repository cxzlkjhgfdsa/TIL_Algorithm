import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt(); // 굴다리의 길이
        int M = sc.nextInt(); // 가로등의 개수

        int[] lamp = new int[M+2];

        for(int i = 1; i <= M; i++){
            lamp[i] = sc.nextInt();
        }
        lamp[M+1] = N;

        int height = 0;  // 가로등의 높이


        for(int i = 1; i <= M; i++){ // 밝혀야하는 최대 거리를 구함

            if(i == M && i == 1){
                int a = lamp[i] - lamp[i-1];
                int b = lamp[i+1] - lamp[i];
                int max = Math.max(a, b);
                height = Math.max(height, max);

            }else if(i == M){  // 마지막 가로등이라면
                int a = (lamp[i] - lamp[i-1])%2 == 0 ? (lamp[i]-lamp[i-1])/2 : (lamp[i]-lamp[i-1])/2 + 1;
                int b = lamp[i+1] - lamp[i];
                int max = Math.max(a, b);
                height = Math.max(height, max);

            }else if(i == 1){ // 첫 번째 가로등이라면
                int a = lamp[i] - lamp[i-1];
                int b = (lamp[i+1] - lamp[i])%2 == 0 ? (lamp[i+1]-lamp[i])/2 : (lamp[i+1]-lamp[i])/2 + 1;
                int max = Math.max(a, b);
                height = Math.max(height, max);

            }else{ // 나머지
                int a = (lamp[i] - lamp[i-1])%2 == 0 ? (lamp[i]-lamp[i-1])/2 : (lamp[i]-lamp[i-1])/2 + 1;
                int b = (lamp[i+1] - lamp[i])%2 == 0 ? (lamp[i+1]-lamp[i])/2 : (lamp[i+1]-lamp[i])/2 + 1;
                int max = Math.max(a, b);
                height = Math.max(height, max);
            }

        }
        System.out.println(height);
    }
}
