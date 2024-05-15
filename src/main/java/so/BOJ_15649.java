package so;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_15649 {

    // 고장난 버튼 정보를 저장하는 배열
    static boolean[] broken;

    // 목표 숫자와 현재 채널
    static int target;
    static int count;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        target = Integer.parseInt(br.readLine()); // 목표 숫자 입력
        int n = Integer.parseInt(br.readLine()); // 고장난 버튼의 개수 입력

        broken = new boolean[10]; // 0부터 9까지의 버튼을 저장할 배열

        // 고장난 버튼 정보 입력
        if (n > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                int cur = Integer.parseInt(st.nextToken());
                broken[cur] = true;
            }
        }

        // 목표 숫자가 이미 100이면 0을 출력하고 종료
        if (target == 100) {
            System.out.println("0");
            return;
        }

        // 초기값 설정 (현재 채널에서 100까지의 거리)
        count = Math.abs(target - 100);

        // DFS를 통해 최소 클릭 횟수 찾기
        dfs(0, 0);

        // 최소 클릭 횟수 출력
        System.out.println(count);

        br.close();
    }

    // DFS 메서드: 현재 채널에서 가능한 다음 채널을 찾는다.
    private static void dfs(int click, int curChannel) {
        for (int i = 0; i < 10; i++) {
            // 고장난 버튼은 무시하고 다음 버튼을 찾는다.
            if (!broken[i]) {
                int newChannel = click * 10 + i; // 새로운 채널
                int distance = Math.abs(target - newChannel) + String.valueOf(newChannel).length(); // 목표까지의 거리 + 버튼 클릭 횟수

                // 최소 클릭 횟수 갱신
                count = Math.min(count, distance);

                // 현재까지 버튼을 누른 횟수가 6미만이면 계속해서 탐색
                if (click < 6) {
                    dfs(click + 1, newChannel);
                }
            }
        }
    }
}