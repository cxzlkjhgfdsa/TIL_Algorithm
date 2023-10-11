import java.io.*;

public class Main {

    static int[][] map;
    static int n, m;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input;

        input = br.readLine().split(" ");
        n = Integer.parseInt(input[0]);
        m = Integer.parseInt(input[1]);
        int q = Integer.parseInt(input[2]);

        map = new int[n][m];

        for(int i = 0; i < n; i++){
            input = br.readLine().split(" ");
            for(int j = 0; j < m; j++){
                map[i][j] = Integer.parseInt(input[j]);
            }
        }

        // 바람 반복
        for(int tc = 0; tc < q; tc++){

            input = br.readLine().split(" ");

            int idx = Integer.parseInt(input[0])-1;  // 어느 행인지
            String way = input[1];  // 방향이 뭔지

            // 1. 입력 들어온 행 밀기 ( 왼 / 오 )

            push(idx, way);

            // 2. 밀기 이후 열에 같은 숫자가 있는지 확인

            boolean up = checkUp(idx);
            boolean down = checkDown(idx);
            int upIdx = idx;
            int downIdx = idx;

            // 3. 같은열에 있으면 다음과 같은 반복문을 진행

            while(up || down){
                if(way.equals("L")){
                    way = "R";
                }else{
                    way = "L";
                }

                if(up){
                    upIdx--;
                    if(upIdx >= 0){
                        push(upIdx, way);
                    }
                    up = checkUp(upIdx);

                }

                if(down){
                    downIdx++;
                    if(downIdx < n){
                        push(downIdx, way);
                    }
                    down = checkDown(downIdx);
                }

                if(upIdx <= 0){
                    up = false;
                }
                if(downIdx >= n){
                    down = false;
                }
                
            }

        }

        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                System.out.print(map[i][j]+" ");
            }
            System.out.println();
        }
        
        
    }
    private static boolean checkDown(int idx){
        if(idx + 1 < n){
            for(int i=0; i<m; i++){
                if(map[idx+1][i] == map[idx][i]){
                    return true;
                }
            }
        }else{
            return false;
        }
        return false;
    }

    private static boolean checkUp(int idx){
        if(idx - 1 >= 0){
            for(int i=0; i<m; i++){
                if(map[idx-1][i] == map[idx][i]){
                    return true;
                }
            }

        }else{
            return false;
        }
        return false;
    }

    private static void push(int idx , String way){
        if(way.equals("L")){
                int temp = map[idx][m-1];
                for(int i=m-1; i>=1; i--){
                    map[idx][i] = map[idx][i-1];
                }
                map[idx][0] = temp;

            }else{
                int temp = map[idx][0];
                for(int i=0; i<m-1; i++){
                    map[idx][i] = map[idx][i+1];
                }
                map[idx][m-1] = temp;

            }
    }
}