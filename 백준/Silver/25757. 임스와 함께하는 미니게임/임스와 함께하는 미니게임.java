import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt(); // 신청자 수
        String game = sc.next(); // 게임 종료

        int player = 0; // 플에이어 수

        if(game.equals("Y"))  // 게임 종류에 따라 플레이어수를 나눔
            player = 2;
        else if(game.equals("F"))
            player = 3;
        else
            player = 4;

        Set<String> set = new HashSet<>();  // 중복을 제거한 총 플레이어의 수를 알기위해 Set을 활용

        for(int i = 0; i < N; i++){ // 총 플레이어의 수를 체크
            set.add(sc.next());
        }

        System.out.println(set.size()/(player-1));  // 총 플레이어의 수 -> set 의 사이즈 , 한번 게임한 친구와 하지않기 떄문에 정답은 총 사람수 / 임스를 제외하고 게임에 필요한 플레이어의 수
    }
}
