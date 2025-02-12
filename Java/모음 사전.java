import java.util.*;

class Solution {
    private int answer;
    private int count;
    private StringBuilder sb;
    private char[] alphabets;
    private boolean isFound;

    private void init() {
        answer = 0;
        count = 0;
        isFound = false;
        sb = new StringBuilder();
        alphabets = new char[]{'A', 'E', 'I', 'O', 'U'};
    }

    private void dfs(String word) {
        if (isFound) {
            return;
        }
        if (5 < sb.length()) {
            return;
        }

        if (0 < sb.length()) {
            count++;

            if (sb.toString().equals(word)) {
                answer = count;
                isFound = true;
                return;
            }
        }

        for (int i = 0; i < alphabets.length; i++) {
            sb.append(alphabets[i]);
            dfs(word);
            sb.deleteCharAt(sb.length() - 1);
        }
        return;
    }

    public int solution(String word) {
        init();

        dfs(word);

        return answer;
    }
}  