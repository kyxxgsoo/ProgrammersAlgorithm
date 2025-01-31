import java.util.*;

class Solution {
    class Node {
        int x;
        int y;
        int distance;

        Node(int x, int y, int distance) {
            this.x = x;
            this.y = y;
            this.distance = distance;
        }
    }
    private static final int[] dx = {0, 0, -1, 1};
    private static final int[] dy = {-1, 1, 0, 0};
    private static ArrayList<Node> people;


    public int[] solution(String[][] places) {
        int[] answer = new int[places.length];
        for (int i = 0; i < places.length; i++) {
            init(places, i);
            // System.out.println();
            // for (int j = 0; j < people.size(); j++) {
            //     System.out.println(people.get(j).x + " " + people.get(j).y);
            // }
            int ret = 1;
            for (int j = 0; j < people.size(); j++) {
                // System.out.println("========" + trevalsal(places[i], people.get(j)));
                if (trevalsal(places[i], people.get(j)) == false) {
                    ret = 0;
                    break;
                }
            }
            answer[i] = ret;
            // System.out.println();
        }
        return answer;
    }

    private void init(String[][] places, int testCase) {
        people = new ArrayList<>();
        for (int i = 0; i < places[testCase].length; i++) {
            // System.out.println(places[testCase][i]);
            // String은 length 또는 size()가 아니라 length()로 길이를 구할 수 있음.
            for (int j = 0; j < places[testCase][i].length(); j++) {
                // charAt(j) -> String에서 문자열 중 문자를 하나씩 접근하는 방법
                char cur = places[testCase][i].charAt(j);
                if (cur == 'P') {
                    people.add(new Node(j, i, 0));
                }
            }
        }
    }

    private boolean trevalsal(String[] place, Node node) {
        Deque<Node> q = new LinkedList<>();
        boolean[][] visited = new boolean[5][5];

        q.add(node);
        visited[node.y][node.x] = true;

        while (!q.isEmpty()) {
            Node curNode = q.remove();
            int curX = curNode.x;
            int curY = curNode.y;
            int curDistance = curNode.distance;

            // System.out.println("cur : " + curX + " " + curY + " " + curDistance);


            if (curDistance > 1) {
                break;
            }

            for (int i = 0; i < 4; i++) {
                int nextX = curX + dx[i];
                int nextY = curY + dy[i];


                if (isValid(visited, nextX, nextY)) {
                    if (place[nextY].charAt(nextX) == 'P') {
                        // System.out.println("여기!! " + nextX + nextY + (curDistance + 1));
                        return false;
                    }
                    if (place[nextY].charAt(nextX) == 'O') {
                        visited[nextY][nextX] = true;

                        // System.out.println("next : " + nextX + " " + nextY + " " + (curDistance + 1));
                        q.add(new Node(nextX, nextY, curDistance + 1));
                    }
                }
            }
        }
        return true;
    }

    private boolean isValid(boolean[][] visited, int x, int y) {
        if (0 <= x && x < 5 && 0 <= y && y < 5 && !visited[y][x]) {
            return true;
        }
        return false;
    }
}