class Solution {
    private int answer;
    private boolean[] isVisited;

    private void init(int[][] dungeons) {
        answer = 0;
        isVisited = new boolean[dungeons.length];
    }

    private void dfs(int k, int[][] dungeons, int count) {
        if (answer < count) {
            answer = count;
        }

        for (int i = 0; i < dungeons.length; i++) {
            if (!isVisited[i]) {
                // 최소 피로도보다 현재 피로도가 작지 않다면 -> 던전 탐색
                if (k >= dungeons[i][0]) {
                    isVisited[i] = true;
                    // 현재 피로도에서 소모 필요도만큼 빼고 탐색
                    dfs(k - dungeons[i][1], dungeons, count + 1);
                    isVisited[i] = false;
                }
            }
        }
    }

    public int solution(int k, int[][] dungeons) {

        init(dungeons);

        dfs(k, dungeons, 0);

        return answer;
    }
}