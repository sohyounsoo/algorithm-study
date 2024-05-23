package kim;

public class PM_이웃한칸 {

    static int solution(String[][] board, int h , int w){

        int answer = 0;
        int height_length = board.length;
        int width_length = board[0].length;

        int[] dh = {-1, 1, 0, 0};
        int[] dw = {0, 0, 1, -1};

        for (int i = 0; i < 4; i++) {
            int nh = h + dh[i];
            int nw = w + dw[i];

            if (nh >= 0 && nh < height_length && nw >= 0 && nw < width_length && board[nh][nw].equals(board[h][w])) {
                answer++;
            }
        }

        return answer;
    }


    public static void main(String[] args) {
        String[][] board = {
                {"blue", "red", "orange", "red"},
                {"red", "red", "blue", "orange"},
                {"blue", "orange", "red", "red"},
                {"orange", "orange", "red", "blue"}
        };

        int h = 1;
        int w = 1;

        System.out.println(solution(board, h , w));

    }
}
