class Solution {
    public boolean checkRange(int x, int y, int n) {
        if (x < 0 || x >= n || y < 0 || y >= n) {
            return false;
        }
        return true;
    }

    public int[] solution(int n) {
        int[] answer = {};
        // 1. 아래로 이동 / 2. 오른쪽으로 이동 / 3. 왼쪽 대각선으로 이동
        int[] dx = {0, 1, -1};
        int[] dy = {1, 0, -1};
        int x = 0;
        int y = 0;
        int it = 0;
        long num = 1;

        long[][] arr = new long[n][n];

        arr[y][x] = num;
        while (true) {

            // 삼각형 돌기 반복
            while (true) {
                int nextX = x + dx[it];
                int nextY = y + dy[it];
                // java에서는 왼쪽 조건부터 평가하고 왼쪽조건이 false인 경우 오른쪽 조건을 평가하지 않는다.
                if (checkRange(nextX, nextY, n) && arr[nextY][nextX] == 0) {
                    num++;
                    arr[nextY][nextX] = num;
                    x = nextX;
                    y = nextY;
                } else {
                    break;
                }
            }

            it = (it + 1) % 3;
            int nextX = x + dx[it];
            int nextY = y + dy[it];

            if (checkRange(nextX, nextY, n) && arr[nextY][nextX] == 0) {
                num++;
                arr[nextY][nextX] = num;
                x = nextX;
                y = nextY;
            } else {
                break;
            }
        }

        // 정답 저장
        answer = new int[(int)num];
        int index = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                if (arr[i][j] != 0) {
                    answer[index++] = (int)arr[i][j];
                }
            }
        }

        return answer;
    }
}