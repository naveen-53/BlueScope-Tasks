import java.util.*;

public class WordCircle {

    public static boolean canFormCircle(List<String> words) {
        if (words == null || words.isEmpty()) {
            return false;
        }

        int alphabet = 26;

        
        int[] inDegree = new int[alphabet];
        int[] outDegree = new int[alphabet];
        List<List<Integer>> graph = new ArrayList<>();
        List<List<Integer>> reverseGraph = new ArrayList<>();

        for (int i = 0; i < alphabet; i++) {
            graph.add(new ArrayList<>());
            reverseGraph.add(new ArrayList<>());
        }

        for (String word : words) {
            if (word == null || word.isEmpty()) {
                return false;
            }
            char startChar = word.charAt(0);
            char endChar = word.charAt(word.length() - 1);

            int u = startChar - 'a';
            int v = endChar - 'a';

            outDegree[u]++;
            inDegree[v]++;

            graph.get(u).add(v);
            reverseGraph.get(v).add(u);
        }
        for (int i = 0; i < alphabet; i++) {
            if (inDegree[i] != outDegree[i]) {
                return false;
            }
        }
        int start = -1;
        for (int i = 0; i < alphabet; i++) {
            if (outDegree[i] > 0 || inDegree[i] > 0) {
                start = i;
                break;
            }
        }

        if (start == -1) {
            return false;
        }
        boolean[] visited = new boolean[alphabet];

        dfs(graph, start, visited);

        for (int i = 0; i < alphabet; i++) {
            if ((inDegree[i] > 0 || outDegree[i] > 0) && !visited[i]) {
                return false;
            }
        }
        Arrays.fill(visited, false);
        dfs(reverseGraph, start, visited);

        
        for (int i = 0; i < alphabet; i++) {
            if ((inDegree[i] > 0 || outDegree[i] > 0) && !visited[i]) {
                return false;
            }
        }
        return true;
    }

    private static void dfs(List<List<Integer>> graph, int node, boolean[] visited) {
        visited[node] = true;
        for (int nei : graph.get(node)) {
            if (!visited[nei]) {
                dfs(graph, nei, visited);
            }
        }
    }
    public static void main(String[] args) {
        List<String> words = Arrays.asList("chair", "height", "racket", "touch", "tunic");
        System.out.println(canFormCircle(words));
        List<String> words2 = Arrays.asList("ab", "bc", "cd");
        System.out.println(canFormCircle(words2)); 
    }
}
