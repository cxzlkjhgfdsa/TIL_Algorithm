import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class BJ_탑 {
    static class Building{ // 빌딩 정보를 저장하는 클래스
        int idx, high;  // idx = 탑의 위치, high = 탑의 높이
        public Building(int idx, int high) {
            this.idx = idx;
            this.high = high;
        }
    }

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String [] input;
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());  // 탐의 개수
        input = br.readLine().split(" ");

        Stack<Building> top = new Stack<>();  // 레이저가 송신되는 탑을 알아내기 위한 스택

        for(int i=0; i<N; i++){
            int h = Integer.parseInt(input[i]);
            while(true){
                if(top.isEmpty()){  // top 이 비었으면 레이저를 송신할 탑이 없다는 것
                    sb.append(0).append(" ");  // 0 추가
                    top.push(new Building(i, h)); // 현재 빌딩을 top 에 추가
                    break;
                }
                if(h<=top.peek().high){   // top에 가장 위에있는 빌딩의 높이가 현재 빌딩높이보다 높거나 같으면 그 탑이 수신
                    sb.append(top.peek().idx+1).append(" ");  // 그탑의 위치를 저장
                    top.push(new Building(i, h)); // 현재 빌딩을 top에 저장
                    break;
                }
                top.pop();
            }
        }
        System.out.println(sb);

    }
}
