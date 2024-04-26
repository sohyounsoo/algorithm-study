package so.programmers;

public class PM_공원산책 {

    public static void main(String[] args) {
        String[] park = {"SOO", "OOO", "OOO"};
        String[] routes = {"E 2", "S 2", "W 1"};

        for (int i : solution(park, routes)) {
            System.out.print(i);
        }
    }

    public static int[] solution(String[] park, String[] routes) {
        int[] answer = new int[2];

        int height = park.length;   //공원 높이
        int weight = park[0].length();    //공원 넓이
        int x = -1, y = -1;

        // 공원 순회
        for(int i=0; i<park.length; i++) {
            if(park[i].indexOf('S') !=  -1) {
                x = park[i].indexOf('S');
                y = i;
                break;
            }
        }

        // 강아지 명령 순회
        for(int i=0; i<routes.length; i++) {
            String[] temp = routes[i].split(" ");
            int currX = x;
            int currY = y;
            String vector = temp[0]; //방향
            int distance = Integer.parseInt(temp[1]); //거리
            boolean flag = true;

            if(vector.equals("E")) { //동
                for(int j=1;j<=distance;j++) {
                    currX++;
                    if(currX >= weight) {	//범위를 벗어났나
                        flag = false;
                        break;
                    }
                    // 장애물이 있나
                    else if(park[currY].charAt(currX) =='X') {
                        flag = false;
                        break;
                    }

                }
                if (flag) x = currX;
            }
            else if(vector.equals("W")) {    //서
                for(int j=1;j<=distance;j++) {
                    currX--;
                    if(currX < 0){
                        flag = false;
                        break;
                    }
                    else if(park[currY].charAt(currX) =='X') {
                        flag = false;
                        break;
                    }

                }
                if (flag) x = currX;
            }
            else if(vector.equals("S")) {    //남
                for(int j=1;j<=distance;j++) {
                    currY++;
                    if(currY >= height){
                        flag = false;
                        break;
                    }
                    else if(park[currY].charAt(currX) =='X') {
                        flag = false;
                        break;
                    }

                }
                if (flag) y = currY;
            }
            else if(vector.equals("N")) {    //북
                for(int j=1;j<=distance;j++) {
                    currY--;
                    if(currY < 0){
                        flag = false;
                        break;
                    }
                    else if(park[currY].charAt(currX) =='X') {
                        flag = false;
                        break;
                    }

                }
                if (flag) y = currY;
            }
        }

        answer[0] = y;
        answer[1] = x;

        return answer;
    }

}
