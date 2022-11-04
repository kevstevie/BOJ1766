
import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        List<List<Integer>> nodes = new ArrayList<>();
        int[] counts = new int[n + 1];
        for (int i = 0 ; i <= n; i++) {
            nodes.add(new ArrayList<>());
        }
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int n1 = Integer.parseInt(st.nextToken());
            int n2 = Integer.parseInt(st.nextToken());
            nodes.get(n1).add(n2);
            counts[n2]++;
        }

        StringBuilder sb = new StringBuilder();
        PriorityQueue<Integer> q = new PriorityQueue<>();

        for (int i = 1; i <= n; i++) {
            if (counts[i] == 0) {
                q.offer(i);
            }
        }while (!q.isEmpty()) {
            int now = q.poll();
            sb.append(now).append(" ");
            for (int j : nodes.get(now)) {
                counts[j]--;
                if (counts[j] == 0) {
                    q.offer(j);
                }
            }
        }
        System.out.println(sb);
    }
}