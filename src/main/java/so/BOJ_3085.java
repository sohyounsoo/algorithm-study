package so;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class BOJ_3085 {

    static char[][] board;
    static int n;
    static int max = 1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine()); //난쟁이 숫자
        board = new char[n][n];

        for(int i=0; i<n; i++) {
            String s = br.readLine();
            for(int j=0; j<n; j++) {
                board[i][j] =  s.charAt(j);
            }
        }
        br.close();

        //행 비교
        for(int i=0; i<n; i++) {
            for(int j=0; j<n-1; j++) {
                sawp(i, j, i, j+1);
                search();
                sawp(i, j+1, i, j); // 다시 돌려놓음
            }
        }

        //열 비교
        for(int i=0; i<n; i++) {
            for(int j=0; j<n-1; j++) {
                sawp(j, i, j+1, i);
                search();
                sawp(j+1, i, j, i); // 다시 돌려놓음
            }
        }

        System.out.println(max);
    }

    private static void sawp(int x1, int y1, int x2, int y2) {
        char temp = board[x1][y1];
        board[x1][y1] = board[x2][y2];
        board[x2][y2] = temp;
    }

    private static void search() {

        for(int i=0; i<n; i++) {

            //행이랑 비교
            int count = 1;
            for(int j=0; j<n-1; j++) {
                if(board[i][j] ==board[i][j+1]) {
                    count++;
                    max = Math.max(count, max);
                }else {
                    count = 1;
                }
            }

            //열이랑 비교
            count = 1;
            for(int j=0; j<n-1; j++) {
                if(board[j][i] == board[j+1][i]) {
                    count++;
                    max = Math.max(count, max);
                }else {
                    count = 1;
                }
            }
        }
    }

}
