package so;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_14500 {

    static int max = Integer.MIN_VALUE;
    static int[][] map;
    static boolean[][] visit;
    static int n;
    static int m;

    //상하좌우
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n][m];
        visit = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                visit[i][j] = true;
                solve(i, j, map[i][j], 1);
                visit[i][j] = false;
            }
        }

        System.out.println(max);

    }

    private static void solve(int row, int col, int sum , int count) {

        if(count == 4) {
            max = Math.max(max, sum);
            return;
        }

        //상하좌우 탐색
        for (int i = 0; i < 4; i++) {
            int cRow = row + dx[i];
            int cCol = col + dy[i];

            //범위
            if(cRow < 0 || cCol < 0 || cRow >= n || cCol >= m) continue;;

            if(!visit[cRow][cCol]) {
                // 보라색(ㅗ) 테트로미노 만들기 위해 2번째 칸에서 탐색 한번 더 진행
                if(count == 2) {
                    visit[cRow][cCol] = true;
                    solve(row, col, sum + map[cRow][cCol], count + 1);
                    visit[cRow][cCol] = false;
                }

                visit[cRow][cCol] = true;
                solve(cRow, cCol, sum + map[cRow][cCol], count + 1);
                visit[cRow][cCol] = false;
            }
        }
    }
}
