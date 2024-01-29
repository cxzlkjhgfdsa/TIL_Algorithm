import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int H = sc.nextInt();  // 테이블의 행 크기
        int W = sc.nextInt();  // 테이블에 열 크기
        int N = sc.nextInt();  // 세로로 띄워야 하는 수
        int M = sc.nextInt();  // 가로로 띄우야 하는 수

        int x = H%(N+1) == 0 ? H/(N+1) : H/(N+1) + 1;  // 세로로 앉을 수 있는 수는 -> 세로길이 /(떨어져 앉아야하는 거리 + 1 ) , 만약 딱 나누어떨어지지 않는다면 + 1;
        int y = W%(M+1) == 0 ? W/(M+1) : W/(M+1) + 1;  //  가로도 마찬가지

        int ans = x * y; // 총 앉을 수 있는 좌석 수는 , 가로 * 세로 

        System.out.println(ans);
    }
}
