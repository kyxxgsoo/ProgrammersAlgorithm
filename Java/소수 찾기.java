import java.util.*;

class Solution {

    boolean[] isPrime;
    HashSet<Integer> hs;
    StringBuilder sb;
    boolean[] isVisited;
    int maxNumber = 0;

    private void init(String numbers) {
        isPrime = new boolean[maxNumber + 1];
        Arrays.fill(isPrime, true);
        isPrime[0] = false;
        isPrime[1] = false;
        hs = new HashSet<>();
        sb = new StringBuilder();
        isVisited = new boolean[numbers.length()];
    }

    // numbers로 만들 수 있는 최댓값 반환 메서드
    private void getMaxNumber(String numbers) {
        char[] cArr = numbers.toCharArray();
        Arrays.sort(cArr);
        String tempStr = new String(cArr);
        StringBuilder sb = new StringBuilder(tempStr);
        sb.reverse();

        maxNumber = Integer.parseInt(sb.toString());
    }

    // 에라토스테네스의 체
    private void getPrimeNumber() {
        int sqrtNum = (int) (Math.sqrt(maxNumber));
        for (int i = 2; i <= sqrtNum; i++) {
            // 만약 소수이면, i의 배수를 maxNumber까지 반복하며 소수가 아님을 판별한다.
            // (이 때, i * i 이전의 소수들은 i보다 작은 소수가 i의 배수를 모두 지웠기 때문에 i * i부터 시작해야 함.) -> 에라토스테네스의 체
            if (isPrime[i]) {
                for (int j = i * i; j <= maxNumber; j += i) {
                    isPrime[j] = false;
                }
            }
        }
    }

    private void dfs(String numbers) {
        if (sb.length() > 0) {
            int number = Integer.parseInt(sb.toString());
            if (!hs.contains(number)) {
                if (isPrime[number]) {
                    System.out.println(number);
                    hs.add(number);
                }
            }
        }

        for (int i = 0; i < numbers.length(); i++) {
            char numberChar = numbers.charAt(i);
            // numbers에서 number이 방문되지 않았다면 dfs
            if (!isVisited[i]) {
                sb.append(numberChar);
                isVisited[i] = true;
                dfs(numbers);
                sb.deleteCharAt(sb.length() - 1);
                isVisited[i] = false;
            }
        }

    }

    public int solution(String numbers) {
        int answer = 0;
        getMaxNumber(numbers);
        init(numbers);
        getPrimeNumber();
        dfs(numbers);


        return hs.size();
    }
}