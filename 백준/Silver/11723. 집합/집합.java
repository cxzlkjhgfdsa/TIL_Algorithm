import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        Set<Integer> set = new HashSet<>(); // 연산처리할 자료구조 Set

        int n = sc.nextInt();  // 연산 수행 횟수

        for(int i = 0; i < n; i++){

            String order = sc.next();

            int x = 0;

            switch (order){
                case "add":     // 추가 연산 , set은 자료구조 특성상 중복제거 하기 때문에 무시와 같음
                    x = sc.nextInt();
                    set.add(x);  // set에 x 추가
                    break;
                case "remove":
                    x = sc.nextInt();
                    if(set.contains(x))  // 만약 x 가 존재한다면
                        set.remove(x);  // 제거
                    break;
                case "check":
                    x = sc.nextInt();
                    if(set.contains(x))  // 만약 x 가 있다면 1출력 아니면 0 출력
                        sb.append("1").append("\n");
                    else
                        sb.append("0").append("\n");
                    break;
                case "toggle":
                    x = sc.nextInt();
                    if(set.contains(x)){  // x 가 존재한다면 제거 아니면 추가
                        set.remove(x);
                    }else{
                        set.add(x);
                    }
                    break;
                case "all":
                    set.clear();  // set을 비운 후 1 ~ 20 추가
                    for(int k = 1; k <=20; k++)
                        set.add(k);
                    break;
                case "empty":  //set 비우기
                    set.clear();
                    break;

            }

        }
        System.out.println(sb);


    }
}
