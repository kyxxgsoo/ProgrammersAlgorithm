class Solution {
    public String solution(String s, int n) {
        String answer = "";
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            sb.append(caesarCipher(s.charAt(i), n));
        }
        answer = sb.toString();
        return answer;
    }

    private char caesarCipher(char origin, int n) {
        char encrypted = ' ';
        if ('a' <= origin && origin <= 'z') {
            encrypted = (char) ('a' + (origin - 'a' + n) % 26);
        } else if ('A' <= origin && origin <= 'Z') {
            encrypted = (char) ('A' + (origin - 'A' + n) % 26);
        }
        return encrypted;
    }
}