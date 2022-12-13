import java.util.Scanner;

public class SWEA_달팽이숫자 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int [] dx = {0, 1, 0, -1};
        int [] dy = {1, 0, -1, 0};

        int T = sc.nextInt();

        for(int tc=1; tc<=T; tc++){
            int N = sc.nextInt();

            int [][] snail = new int[N][N];
            int idx=2;
            int dir = 0;
            snail[0][0] = 1;
            int x = 0;
            int y = 0;

            while(idx<=N*N){
                dir = dir%4;


                if(dir==0){
                    if(y+dy[dir]>=N || snail[x][y+dy[dir]]!=0){
                        dir++;
                        continue;
                    }
                }else if(dir==1){
                    if(x+dx[dir]>=N || snail[x+dx[dir]][y]!=0){
                        dir++;
                        continue;
                    }
                }else if(dir==2){
                    if(y+dy[dir]<0 || snail[x][y+dy[dir]]!=0){
                        dir++;
                        continue;
                    }

                }else{
                    if(x+dx[dir]<0 || snail[x+dx[dir]][y]!=0){
                        dir++;
                        continue;
                    }

                }
                x = x+dx[dir];
                y = y+dy[dir];
                snail[x][y]=idx;
                idx++;

            }
            System.out.println("#"+tc);
            for(int i=0; i<N; i++){
                for(int j=0; j<N; j++){
                    System.out.print(snail[i][j]+" ");
                }
                System.out.println();
            }

        }
    }
}
