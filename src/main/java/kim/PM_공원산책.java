package kim;

public class PM_공원산책 {


    static int[] solution(String[] park, String[] routes) {
        int[] answer = new int[2];

        for (int i = 0; i < park.length; i++) {
            if (park[i].indexOf("S") != -1) {
                answer[0] = i;
                answer[1] = park[i].indexOf("S");
                break;
            }
        }

        loop:
        for (String route : routes) {
            int move = Integer.parseInt(route.split(" ")[1]);
            String direction = route.split(" ")[0];

            int x = answer[1];
            int y = answer[0];
            int newX = x, newY = y;

            switch (direction) {
                case "E":
                    newX = x + move;
                    if (newX >= park[0].length()) continue;
                    for (int j = x + 1; j <= newX; j++) {
                        if (park[y].charAt(j) == 'X') continue loop;
                    }
                    answer[1] = newX;
                    break;
                case "W":
                    newX = x - move;
                    if (newX < 0) continue;
                    for (int j = x - 1; j >= newX; j--) {
                        if (park[y].charAt(j) == 'X') continue loop;
                    }
                    answer[1] = newX;
                    break;
                case "N":
                    newY = y - move;
                    if (newY < 0) continue;
                    for (int i = y - 1; i >= newY; i--) {
                        if (park[i].charAt(x) == 'X') continue loop;
                    }
                    answer[0] = newY;
                    break;
                case "S":
                    newY = y + move;
                    if (newY >= park.length) continue;
                    for (int i = y + 1; i <= newY; i++) {
                        if (park[i].charAt(x) == 'X') continue loop;
                    }
                    answer[0] = newY;
                    break;
            }
        }

        return answer;
    }


    public static void main(String[] args) {
        String[] park = {"OSO","OOO","OXO","OOO"};
        String[] routes = {"E 2","S 3","W 1"};
        int[] solution = solution(park, routes);
        for(int a : solution){
            System.out.print(a + " ");
        }
    }
}
