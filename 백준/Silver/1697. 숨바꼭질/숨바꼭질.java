import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);  // 입력받을 도구

        int N = sc.nextInt();   // 수빈이의 위치를 입력받음
        int K = sc.nextInt();   // 동생의 위치를 입력받음
        int answer = 0;   // 정답을 출력할 변수

        Queue<Dis> que = new ArrayDeque<>(); // bfs 탐색을 위한 Queue , 가장 빠른 시간을 탐색하는 것이기 때문에 BFS 가 적합하다
        boolean[] visited = new boolean[100001]; // 한번 방문한 곳을 재방문하는 일을 막기위한 boolean 배열

        que.add(new Dis(N, 0)); // 수빈이의 위치를 que에 넣고 팀색 시작
        visited[N] = true; // 현재 수빈이의 위치를 방문 표시

        while(!que.isEmpty()){

            Dis d = que.poll();
            if(d.cur == K){ // 현재 위치가 동생이 있는 위치라면 탐색 종료
                answer = d.depth;  // bfs 방식으로 탐색하기 때문에 가장 먼저 걸린 것이 최단 거리로 갈 수 있는 방법이다
                break;
            }

            if(d.cur-1 >= 0 && !visited[d.cur - 1]){ // 배열의 범위를 벗어나지 않고 , 현재위치 - 1 이 방문하지 않은 곳이라면
                que.add(new Dis(d.cur-1 , d.depth + 1)); // 현재위치 -1 의 위치를 queue에 삽입 ( depth 를 1 늘려서 )
                visited[d.cur-1] = true; // 방문표시
            }

            if(d.cur+1 <= 100000 && !visited[d.cur + 1]){ // 배열의 범위를 벗어나지 않고 , 현재위치 + 1 이 방문하지 않은 곳이라면
                que.add(new Dis(d.cur+1 , d.depth + 1)); // 현재위치 +1 의 위치를 queue에 삽입 ( depth 를 1 늘려서 )
                visited[d.cur+1] = true; // 방문표시
            }

            if(d.cur*2 <= 100000 && !visited[d.cur*2]){  // 배열의 범위를 벗어나지 않고 , 현재위치 * 2 가 방문하지 않은 곳이라면
                que.add(new Dis(d.cur*2 , d.depth+1));  // 현재위치 * 2 의 위치를 queue에 삽입 ( depth 를 1 늘려서 )
                visited[d.cur*2] = true; // 방문표시
            }

        }

        System.out.println(answer);

    }
}

class Dis {  // 현재의 위치와 깊이 ( 행동한 횟수 ) 를 갖고있는 Dis 클래스
    int cur, depth;

    public Dis(int cur, int depth){
        this.cur = cur;
        this.depth = depth;
    }
}
