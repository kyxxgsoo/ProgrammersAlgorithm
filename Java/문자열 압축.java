import java.util.*;

class Solution {
    private List<String> generationToken(String s, int tokenLength) {
        List<String> tokens = new ArrayList<>();
        // -> 이 부분에서 실수. "앞에서부터" 조건을 만족하기 위해서는 tokenLength씩 반복해서 잘라내야 함
        for (int startIndex = 0; startIndex < s.length(); startIndex += tokenLength) {
            int endIndex = startIndex + tokenLength;
            if (endIndex > s.length()) {
                endIndex = s.length();
            }
            String token = s.substring(startIndex, endIndex);
            tokens.add(token);
        }

        // for (String t: tokens) {
        //     System.out.println(t);
        // }
        return tokens;
    }

    private int compress(String s, int tokenLength) {
        String lastStr = "";
        int count = 0;
        StringBuilder sb = new StringBuilder();

        for (String token: generationToken(s, tokenLength)) {
            if (lastStr.equals(token)) {
                count++;
            } else {
                if (count > 1) {
                    sb.append(count);
                }
                sb.append(lastStr);
                lastStr = token;
                count = 1;
            }
        }

        if (count > 1) {
            sb.append(count);
        }
        sb.append(lastStr);

        // System.out.println(sb.toString());

        return sb.length();
    }

    public int solution(String s) {
        int min = Integer.MAX_VALUE;
        for (int length = 1; length <= s.length(); length++) {
            int compressedLength = compress(s, length);
            if (compressedLength < min) {
                min = compressedLength;
            }
        }
        return min;
    }
}