import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {

    static Set<String> gather; // 모음을 체크하기위한 Set

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        init(); // 초기화

        while(true){  // end 가 나올떄까지 반복
            String pw = sc.next();

            if(pw.equals("end"))
                break;

            String[] str = pw.split("");  // 배열로 한문자씩 쪼개서 체크

            if(firstCheck(str)){  // 조건을 만족하는지 체크
                sb.append("<").append(pw).append(">").append(" ").append("is").append(" ").append("acceptable.");
            }else{
                sb.append("<").append(pw).append(">").append(" ").append("is").append(" ").append("not").append(" ").append("acceptable.");
            }
            sb.append("\n");

        }

        System.out.println(sb);
    }

    private static boolean firstCheck(String[] str){
        boolean check = false;

        for(String next : str){  // 만약 모음이 하나라도 포함되어있다면 true
            if(gather.contains(next))
                check = true;
        }

        if(check){  // 모음이 포함되어있다면 다음 체크로 넘어감
            return secondCheck(str);
        }
        return check;
    }

    private static boolean secondCheck(String[] str){
        int x = 0;  // 모음이 연속적으로 나오는지 체크하기 위한 변수
        int y = 0; // 자음이 연속으로 나오는지 체크하기 위한 변수

        if(str.length <= 2) // 문자가 2자 이하면 체크할 핋요 X
            return thirdCheck(str);

        if(gather.contains(str[0]))  // 첫 문자가 모음이라면 x++ , 아니면  y++
            x++;
        else
            y++;

        boolean check = true;  // 체크하기 위한 변수

        for(int i = 1; i <str.length; i++){

            if(gather.contains(str[i])){  // 모음일 때
                if(x > 0){  // 이미 모음이 연속으로 나오고 있었다면
                    x++;
                }else{ // 아니라면
                    x = 1;  // 모음 개수 1
                    y = 0;  // 자음 연속개수 0으로 초기화
                }
            }else{
                if(y > 0){ // 이미 자음이 연속적으로 나오고 있었다면
                    y++;
                }else{
                    y = 1; // 자음의 연속 개수 1 로 최고하
                    x = 0; // 모음은 0으로
                }
            }

            if(x >= 3 || y >= 3)
                check = false;
        }

        if(check){
            return thirdCheck(str);
        }
        return check;
    }

    private static boolean thirdCheck(String[] str){
        boolean check = true;

        for(int i = 1; i <  str.length; i++){
            if( !str[i].equals("e") && !str[i].equals("o") && str[i].equals(str[i-1]))  // e도 o 도 아니면서 연속한 2개의 문자가 있다면 false
                check = false;
        }

        return check;
    }

    private static void init(){
        gather = new HashSet<>();
        gather.add("a");
        gather.add("e");
        gather.add("i");
        gather.add("o");
        gather.add("u");

    }


}
