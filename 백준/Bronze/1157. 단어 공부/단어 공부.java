import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String word = sc.next().toUpperCase();  // 대소문자를 구분하지 않기 때문에 전부 대문자로 만듬
        int[] count = new int[27]; // 알파벳의 등장 횟수를 체크하기 위한 배열

        for(int i = 0; i < word.length(); i++){
            count[word.charAt(i)-'A']++;  // 아스키 코드를 이용해 횟수를 측정
        }

        boolean both = false;  // 최빈값이 여러개인지 체크하기 위한 변수
        int max = 0; // 최댓값을 체크하기 위한 변수
        int maxIdx = 0; // 최댓값의 인덱스를 체크하기 위한 변수

        for(int i = 0; i < count.length; i++){
            if(max <= count[i]){
                if(max == count[i]){  // 만약 최빈값이 이전 최빈값과 같다면 여러개이므로 true
                    both = true;
                }else{
                    both = false;  // 아니라면 false;
                }

                max = count[i];
                maxIdx = i;  // 최댓값을 갱신해줌
            }
        }

        if(both){
            System.out.println("?");
        }else{
            System.out.println((char)(maxIdx+65));
        }


    }
}
