package so.programmers;

public class PM_둘만의_암호 {

    public static void main(String[] args) {
        String s = "aukks";
        String skip = "wbqd";
        int index = 5;

        System.out.println(soulition(s, skip, index));
    }

    public static String soulition(String s, String skip, int index) {
        String answer = "", alphabet = "abcdefghijklmnopqrstuvwxyz";
        int idx;

        for (int i = 0; i < skip.length(); i++) {
            alphabet = alphabet.replace(Character.toString(skip.charAt(i)), "");
        }

        for (int i = 0; i < s.length(); i++) {
            idx = alphabet.indexOf(Character.toString(s.charAt(i))) + index;
            answer += Character.toString(alphabet.charAt(idx%alphabet.length()));
        }




        return answer;

    }
}
