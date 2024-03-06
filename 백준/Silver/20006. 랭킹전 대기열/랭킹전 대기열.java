import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        ArrayList<Room> game = new ArrayList<>();

        int p = sc.nextInt();
        int m = sc.nextInt();

        int level = sc.nextInt();
        String id = sc.next();


        // 첫번쨰 방을 생성함과 동시에 플레이어 입장
        ArrayList<Player> players = new ArrayList<>();
        players.add(new Player(level, id));
        game.add(new Room(level - 10, level+10, players));

        for(int i = 0; i < p-1; i++){
            level = sc.nextInt();
            id = sc.next();

            boolean submit = false;
            for(Room r : game){  // 방들을 순회하면서 들어갈 수 있는 게임이 있으면 들어감
                if(r.list.size() < m && (level >= r.minLevel && level <= r.maxLevel)){
                    r.list.add(new Player(level, id));
                    submit = true;
                    break;
                }
            }

            if(submit)  // 이미 방에 들어갔다면 패스
                continue;

            // 아니라면 방을 새로 생성
            ArrayList<Player> temp = new ArrayList<>();
            temp.add(new Player(level, id));

            game.add(new Room(level-10, level+10, temp));

        }

        for(int i = 0; i < game.size(); i++){  // 방을 순회하며 정원이 찻는지 안찼는지 확인해가며 방 정보 출력
            if(game.get(i).list.size() == m){
                sb.append("Started!").append("\n");
            }else{
                sb.append("Waiting!").append("\n");
            }

            Collections.sort(game.get(i).list);
            for(int j = 0; j < game.get(i).list.size(); j++){
                Player p1 = game.get(i).list.get(j);

                sb.append(p1.level).append(" ").append(p1.id).append("\n");
            }
        }
        System.out.println(sb);

    }

    static class Room{
        int minLevel, maxLevel;
        ArrayList<Player> list;
        public Room(int minLevel, int maxLevel, ArrayList<Player> list){
            this.minLevel = minLevel;
            this.maxLevel = maxLevel;
            this.list = list;
        }
    }

    static class Player implements Comparable<Player>{
        int level;
        String id;

        public Player(int level, String id){
            this.level = level;
            this.id = id;
        }

        @Override
        public int compareTo(Player o){
            return this.id.compareTo(o.id);
        }
    }

}
