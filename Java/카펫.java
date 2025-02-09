// 완탐 + 재귀로 풀어보기

import java.util.*;

class Solution {

    class Node {
        int w;
        int h;

        Node(int w, int h) {
            this.w = w;
            this.h = h;
        }
    }

    // 완탐 + 재귀로 해결
    private int[] recursive(ArrayList<Node> factors, int index, int b, int y, int w, int h) {
        // 기저사례 1. factors만큼 돌아야하는데, 더 많이 돈 경우
        if (index >= factors.size()) {
            return new int[]{};
        }
        // 기저사례 2. 조건을 만족해서 빠져나간 경우
        if (/*w * h  == b + y && w >= h && */(w - 2) * (h - 2) == y) {
            return new int[]{w, h};
        }

        // 무조건 기저사례 1 또는 2를 반환하게 된다.
        return recursive(factors, index + 1, b, y, factors.get(index + 1).w, factors.get(index + 1).h);

    }

    // 약수 구하기
    private ArrayList<Node> getFactors(int num) {
        ArrayList<Node> factors = new ArrayList<>();
        for (int i = 1; i <= num / i; i++) {
            if (num % i == 0) {
                factors.add(new Node(num / i, i));
            }
        }

        return factors;
    }

    // 메인
    public int[] solution(int brown, int yellow) {
        int[] answer = {};

        ArrayList<Node> factors = getFactors(brown + yellow);
        answer = recursive(factors, 0, brown, yellow, factors.get(0).w, factors.get(0).h);

        return answer;
    }
}