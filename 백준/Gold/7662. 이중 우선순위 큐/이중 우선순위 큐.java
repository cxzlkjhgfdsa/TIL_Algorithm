import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String [] input;
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        int T = Integer.parseInt(br.readLine());

        for(int tc=0; tc<T; tc++){
            int K = Integer.parseInt(br.readLine());
            TreeMap<Integer, Integer> dq = new TreeMap<>();
            for(int i=0; i<K; i++){
                input = br.readLine().split(" ");
                int no = Integer.parseInt(input[1]);

                switch (input[0]){
                    case "D":
                        if(dq.size()==0)
                            continue;
                        if(no == 1){
                            int key = dq.lastKey();
                            int cnt = dq.get(key);
                            if(cnt==1){
                                dq.remove(key);
                            }else{
                                dq.put(key, cnt-1);
                            }
                        }else{
                            int key = dq.firstKey();
                            int cnt = dq.get(key);
                            if(cnt==1){
                                dq.remove(key);
                            }else{
                                dq.put(key, cnt-1);
                            }
                        }
                        break;
                    case "I" :
                        if(dq.get(no)!=null){
                            dq.put(no, dq.get(no)+1);
                        }else{
                            dq.put(no, 1);
                        }
                        break;
                }

            }

            if(dq.size()==0){
                sb.append("EMPTY").append("\n");
            }else{
                sb.append(dq.lastKey()).append(" ").append(dq.firstKey()).append("\n");
            }
        }

        System.out.println(sb);


    }

}
