public class WordCircle {

    public static boolean form_circle(String[] words) {
        int[] start = new int[26];
        int[] end = new int[26];

        for (String w : words) {
            int s = w.charAt(0) - 'a';
            int e = w.charAt(w.length() - 1) - 'a';

            start[s]++;
            end[e]++;
        }

        for (int i = 0; i < 26; i++) {
            if (start[i] != end[i]) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        String[] words = {"chair", "height", "racket", "touch", "tunic"};

        if (form_circle(words)) {
            System.out.println("yes they can form a circle.");
        } else {
            System.out.println("no ,the circle cannot be formed.");
        }
    }
}




