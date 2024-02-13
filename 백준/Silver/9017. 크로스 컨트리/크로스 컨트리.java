import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String[] input;

        int T = Integer.parseInt(br.readLine());

        for(int tc = 0; tc < T; tc++){

            int n = Integer.parseInt(br.readLine());
            Map<Integer, Integer> map = new HashMap<>();

            int[] cross = new int[n];

            input = br.readLine().split(" ");

            for(int i = 0; i < n; i++){
                cross[i] = Integer.parseInt(input[i]);
                if(map.get(cross[i]) == null){
                    map.put(cross[i] , 1);
                }else{
                    map.put(cross[i], map.get(cross[i]) + 1);
                }
            }


            List<Player>[] teamScore = new List[map.size()+1];  // 팀별로 선수들의 정보를 저장하기위한 List 2차원 배열

            for(int i = 1; i <=map.size(); i++){
                teamScore[i] = new ArrayList<>();
            }
            int[] score = new int[map.size()+1];

            int idx = 1;

            for(int i = 0; i < n; i++){

                if(map.get(cross[i]) < 6)
                    continue;

                //System.out.println(idx+" "+i+" ");
                if(teamScore[cross[i]].size() < 4)
                    score[cross[i]] += idx;
                teamScore[cross[i]].add(new Player(cross[i], idx));
                idx++;


            }

            //System.out.println(Arrays.toString(score));

            int win = 1000000;
            int winTeam = 0;

            for(int i = 1; i < score.length; i++){

                if(score[i] == 0) // 점수 0 -> 자격이 없는 팀
                    continue;

                if(score[i] < win){
                    win = score[i];
                    winTeam = i;
                }

                if(score[i] == win){
                    if(teamScore[i].get(4).rank < teamScore[winTeam].get(4).rank){
                        winTeam = i;
                    }

                }
            }
            sb.append(winTeam).append("\n");

        }
        System.out.println(sb);
    }

    static class Player{
        int team, rank;

        public Player(int team, int rank){
            this.team = team;
            this.rank = rank;
        }

    }
}
