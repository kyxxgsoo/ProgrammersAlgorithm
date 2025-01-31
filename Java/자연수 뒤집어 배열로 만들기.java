class Solution {
    public int[] solution(long n) {
        int[] answer = {};
        String str = Long.toString(n);
        StringBuilder sb = new StringBuilder(str).reverse();
        String reversedStr = sb.toString();

        answer = new int[reversedStr.length()];
        for (int i = 0; i < reversedStr.length(); i++) {
            answer[i] = reversedStr.charAt(i) - '0';
        }
        return answer;
    }
}