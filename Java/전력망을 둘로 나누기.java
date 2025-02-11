import java.util.*;

class Solution {

    private int answer;
    private boolean[] isVisited;
    private ArrayList<Deque<Integer>> tree;
    private ArrayList<Integer> rets;

    private void init(int n) {
        answer = Integer.MAX_VALUE;
        isVisited = new boolean[n + 1];
        Arrays.fill(isVisited, false);
        tree = new ArrayList<Deque<Integer>>();

        rets = new ArrayList<>();

        for (int i = 0; i <= n; i++) {
            Deque<Integer> tempList = new LinkedList<>();
            tree.add(tempList);
        }
    }

    private void wiresDfs(int n) {

        // 각 노드의 자식들 선택
        for (int i = 1; i < tree.size(); i++) {
            Deque<Integer> children = tree.get(i);
            int childrenSize = children.size();
            // 각 자식들에 대해서 remove & add 반복
            for (int j = 0; j < childrenSize; j++) {
                // 연결 끊기
                int removeNum = children.remove();
                Arrays.fill(isVisited, false);
                rets = new ArrayList<>();

                // 모든 노드에 대해서 돌 필요 없이 어차피 자르면 두 트리로 나눠지고 n이 있으니 한 트리의 값만 계산해서 n에서 빼면 됨.
                int count1 = countDfs(i);
                int count2 = n - count1;

                answer = Math.min(answer, Math.abs(count1 - count2));

                // 다시 연결
                children.add(removeNum);
            }
        }
    }

    private int countDfs(int curNode) {
        isVisited[curNode] = true;
        int count = 1;

        for (int nextNode: tree.get(curNode)) {
            if (!isVisited[nextNode]) {
                isVisited[nextNode] = true;
                count += countDfs(nextNode);
            }
        }
        return count;
    }

    public int solution(int n, int[][] wires) {
        init(n);
        for (int i = 0; i < wires.length; i++) {
            int[] wire = wires[i];
            tree.get(wire[0]).add(wire[1]);
            tree.get(wire[1]).add(wire[0]);
        }
        wiresDfs(n);
        return answer;
    }
}