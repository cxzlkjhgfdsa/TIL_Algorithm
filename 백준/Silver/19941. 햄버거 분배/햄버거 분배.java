import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int K = sc.nextInt();

        String[] map = sc.next().split("");
        boolean[] eat = new boolean[N];

        int ans = 0;
        boolean check= false;

        for(int i = 0; i < N; i++){

            if(map[i].equals("P")){
                for(int j = K; j >= 1; j--){

                    if(i - j >= 0){
                        if(map[i-j].equals("H") && !eat[i-j]){
                            ans++;
                            eat[i-j] = true;
                            check = true;
                            break;
                        }
                    }
                }

                if(check){
                    check = false;
                    continue;
                }

                for(int j = 1; j <=K; j++){
                    if(i + j < N){
                        if(map[i+j].equals("H") && !eat[i+j]){
                            ans++;
                            eat[i+j] = true;
                            break;
                        }
                    }
                }
            }

            //System.out.println(i + " " + ans);

        }

        System.out.println(ans);

    }
}
