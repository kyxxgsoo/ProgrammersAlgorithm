import java.util.*;

class Solution {

    private int answer;
    private boolean[] isPrime;
    private HashSet<Integer> numbersComb;
    private boolean[] isVisited;
    private StringBuilder tempSb;

    private void init(int maxNum, String numbers) {
        answer = 0;
        isPrime = new boolean[maxNum + 1];
        Arrays.fill(isPrime, true);
        isPrime[0] = false;
        isPrime[1] = false;
        numbersComb = new HashSet<>();
        isVisited = new boolean[numbers.length()];
        tempSb = new StringBuilder();

    }

    private void getCombination(StringBuilder sb, String numbers) {
        if (sb.length() > 0) {
            // 현재까지 조합한 숫자
            int num = Integer.parseInt(sb.toString());

            // 모든 숫자 조합을 numbersComb에 저장
            if (!numbersComb.contains(num)) {
                numbersComb.add(num);
            }
        }

        for (int i = 0; i < numbers.length(); i++) {
            // 이미 방문한 numbers이면 방문 X
            if (!isVisited[i]) {
                // 글자 하나 추가
                sb.append(numbers.charAt(i));
                isVisited[i] = true;
                getCombination(sb, numbers);
                // 글자 하나 삭제
                isVisited[i] = false;
                sb.deleteCharAt(sb.length() - 1);
            }
        }


    }

    private void getPrime(int n) {
        // 에라토스테네스의 체(제곱근까지 반복하며 i의 배수를 모두 primeNum에서 제외)
        int sqrtNum = (int) Math.sqrt(n);
        for (int i = 2; i <= sqrtNum; i++) {
            if (isPrime[i]) {
                for (int j = i * i; j <= n; j += i) {
                    isPrime[j] = false;
                }
            }
        }
    }

    public int solution(String numbers) {
        int answer = 0;

        // StringBuilder 내림차순 정렬 -> 무조건 StringBuilder를 사용할 것
        char[] charArr = numbers.toCharArray();
        Arrays.sort(charArr);
        StringBuilder sb = new StringBuilder();
        for (char c: charArr) {
            sb.append(c);
        }
        sb.reverse();
        int maxNum = Integer.parseInt(sb.toString());
        // ---

        init(maxNum, numbers);
        getPrime(maxNum);
        getCombination(tempSb, numbers);

        for (int i: numbersComb) {
            if (isPrime[i]) {
                answer++;
            }
        }

        return answer;
    }
}