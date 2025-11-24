import java.util.*;

public class WordCircle {

    public static boolean makeCircle(String[] words, List<String> path, boolean[] used) {
        if (path.size() == words.length) {
            return path.get(path.size() - 1).charAt(path.get(path.size() - 1).length() - 1) == path.get(0).charAt(0);  
        }

        for (int i = 0; i < words.length; i++) {
            if (!used[i]) {
                if (path.isEmpty() || path.get(path.size() - 1).charAt(path.get(path.size() - 1).length() - 1) == words[i].charAt(0)) {
                    used[i] = true;
                    path.add(words[i]);

                    if (makeCircle(words, path, used)) 
                           return true;

                    used[i] = false;
                    path.remove(path.size() - 1);
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        String[] words = {"chair", "height", "racket", "touch", "tunic"};
        boolean[] used = new boolean[words.length];
        List<String> path = new ArrayList<>();

        if (makeCircle(words, path, used)) {
            for (int i = 0; i < path.size(); i++) {
                System.out.print(path.get(i) + " --> ");
            }
            System.out.println(path.get(0)); 

        } 
        else {
            System.out.println("Circle cannot be formed");
        }
    }
}
