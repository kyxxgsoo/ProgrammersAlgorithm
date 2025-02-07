import java.util.*;

class Solution {
    public boolean[] clothes;

    public void init(int n) {
        clothes = new boolean[n + 2];
        for (int i = 0; i < clothes.length; i++) {
            clothes[i] = true;
        }
    }

    public int solution(int n, int[] lost, int[] reserve) {
        init(n);
        int answer = 0;

        Arrays.sort(lost);
        Arrays.sort(reserve);

        // 도난당했으면 reserve 없애기.
        for (int i = 0; i < lost.length; i++) {
            boolean haveReserve = false;
            for (int j = 0; j < reserve.length; j++) {
                // 도난당했는데 reserve가 있으면 reserve만 없애기
                if (lost[i] == reserve[j]) {
                    reserve[j] = -1;
                    haveReserve = true;
                }
            }
            // reserve가 없으면 옷 뺏기
            if (!haveReserve) {
                clothes[lost[i]] = false;
            }
        }

        for (int i = 0; i < reserve.length; i++) {
            if (reserve[i] != -1) {
                // 앞 학생 체크
                if (!clothes[reserve[i] - 1]) {
                    clothes[reserve[i] - 1] = true;
                } else if (!clothes[reserve[i] + 1]) {
                    clothes[reserve[i] + 1] = true;
                }
            }
        }

        for (int i = 0; i < clothes.length; i++) {
            if (clothes[i]) {
                answer++;
            }
        }


        return answer - 2;
    }
}