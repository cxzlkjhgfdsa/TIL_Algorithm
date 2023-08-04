import java.util.*;
import java.io.*;


public class Main
{
    public static void main(String args[]) throws Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input;
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        PriorityQueue<Point> gameA = new PriorityQueue<>();
        PriorityQueue<Point> gameB = new PriorityQueue<>();
        PriorityQueue<Point> gameC = new PriorityQueue<>();
        PriorityQueue<Point> Total = new PriorityQueue<>();

        int[][] ans = new int[4][N];

        int[][] score = new int[N][3];
        
        input = br.readLine().split(" ");
        for(int j = 0; j < N; j++){
            int s = Integer.parseInt(input[j]);
            gameA.add(new Point(j, s));
            score[j][0] = s;
        }

        input = br.readLine().split(" ");
        for(int j = 0; j < N; j++){
            int s = Integer.parseInt(input[j]);
            gameB.add(new Point(j, s));
            score[j][1] = s;
        }

        input = br.readLine().split(" ");
        for(int j = 0; j < N; j++){
            int s = Integer.parseInt(input[j]);
            gameC.add(new Point(j, s));
            score[j][2] = s;
        }

        for(int i=0; i<N; i++){
            int sum = score[i][0] + score[i][1] + score[i][2];
            Total.add(new Point(i, sum));
        }
       

        calculate(gameA, ans, 0);
        calculate(gameB, ans, 1);
        calculate(gameC, ans, 2);
        calculate(Total, ans, 3);

        for(int i=0; i<4; i++){
            for(int j=0; j<N; j++){
                sb.append(ans[i][j]).append(" ");
            }
            sb.append("\n");
        }

        System.out.println(sb);


    }

    static void calculate(PriorityQueue<Point> pq , int[][] ans, int name){

        int rank = 0;
        int beforPoint = -1;
        int idx = 0;

        while(!pq.isEmpty()){
            Point p = pq.poll();

            //System.out.print(p.idx + " : " + p.point + " ");

            if(beforPoint != p.point){
                rank = idx+1;
                beforPoint = p.point;
                ans[name][p.idx] = rank;
            }else{
                ans[name][p.idx] = rank;
            }

            idx++;
        }
        //System.out.println();
    }
}

class Point implements Comparable<Point>{
    int idx;
    int point;
    public Point(int idx, int point){
        this.idx = idx;
        this.point = point;
    }

    @Override
    public int compareTo(Point p){
        return p.point - this.point;
    }
}