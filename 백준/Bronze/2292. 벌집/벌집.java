import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int idx = 1;  // 벌집 층의 가장 높은 번호수를 저장하기 위한 변수  ( ex : 1층 -> 1 , 2층 -> 7 , 3층 -> 19 , 4층 -> 37 ) 계차 수열인것을 확인할 수 있음
        int add = 6;  // 계차수열의 차를 더해주기 위한 변수
        int cnt = 1;  //

        while(true){
            if(idx >= n){  // 벌집의 가장 마지막 번째 방 번호가 n 보다 커질때를 체크함
                break;
            }

            idx += add;
            add +=6;
            cnt++;

        }

        System.out.println(cnt);
    }
}
