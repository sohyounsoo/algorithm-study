package so;

import java.io.*;

public class BOJ_9095 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            int n = Integer.parseInt(br.readLine());
            int[] dp = new int[11]; //11로 고정
            dp[1] = 1;
            dp[2] = 2;
            dp[3] = 4;

            for (int j = 4; j <= n; j++) {
                dp[j] = dp[j-1] + dp[j-2] + dp[j-3];
            }

            bw.write(dp[n] + "\n");
        }

        bw.flush();
    }
}
