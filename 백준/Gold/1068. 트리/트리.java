import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        Set<Integer>[] tree = new HashSet[n];
        for(int i = 0; i <n; i++){
            tree[i] = new HashSet<>();
        }

        int rootNode = 0;

        for(int i = 0; i < n; i++){
            int idx = sc.nextInt();

            if(idx == -1){
                rootNode = i;
                continue;
            }
            tree[idx].add(i);
        }

        int removeIdx = sc.nextInt();

        for(int i = 0; i < n; i++){
            if(tree[i].contains(removeIdx)){
                tree[i].remove(removeIdx);
            }
        }


        Queue<Integer> que = new ArrayDeque<>();
        que.add(rootNode);

        int ans = 0;

        while(!que.isEmpty()){

            int cur = que.poll();

            if(cur == removeIdx)
                continue;

            if(tree[cur].size() == 0){
                ans++;
                continue;
            }

            for(Integer next : tree[cur]){
                que.add(next);
            }
        }

        System.out.println(ans);
    }
}
