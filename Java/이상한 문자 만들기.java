import java.util.*;

class Solution {
    public String solution(String s) {
        String answer = "";
        StringBuilder sb = new StringBuilder();
        boolean isNextUpper = true;

        for (char c: s.toCharArray()) {
            if (Character.isSpaceChar(c)) {
                sb.append(c);
                isNextUpper = true;
            } else if (Character.isAlphabetic(c)) {
                if (isNextUpper) {
                    sb.append(Character.toUpperCase(c));
                    isNextUpper = false;
                } else {
                    sb.append(Character.toLowerCase(c));
                    isNextUpper = true;
                }
            }
        }
        answer = sb.toString();
        return answer;
    }
}