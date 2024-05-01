package so;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1748 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int answer = 0;
        int plus = 1;
        int num = 10;
        int N = Integer.parseInt(br.readLine());

        for(int i=1; i<=N; i++) {
            if(i%num == 0) {
                plus ++;
                num *= 10;
            }
            answer += plus;
        }

        System.out.println(answer);
        br.close();

    }
}