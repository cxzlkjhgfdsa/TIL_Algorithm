import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while(true){
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();   // 삼각형의 세 변을 입력받음

            if(a  == 0 && b == 0 && c == 0)
                break;

            if(a+b <= c || a+c <= b || b+c <= a){  /// 삼각형의 조건을 만족하지 못하는 경우
                System.out.println("Invalid");
                continue;
            }

            if(a == b && b == c){  // 세 변이 모두 같은경우
                System.out.println("Equilateral");
            }else if((a == b && b != c) || (a == c && c != b) || (b == c && a != b)){ // 두변의 길이만 같은 경우
                System.out.println("Isosceles");
            }else if( a != b && b != c && a != c){ // 세변이 모두 다른 경우
                System.out.println("Scalene");
            }
        }


    }
}
