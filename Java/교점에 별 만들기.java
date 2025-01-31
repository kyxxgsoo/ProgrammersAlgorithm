import java.util.*;



class Solution {
    private static class Point {
        public final long x;
        public final long y;

        private Point(long x, long y) {
            this.x = x;
            this.y = y;
        }

        public String toString() {
           return "<Point>\n" + "x: " + x + "\ny: " + y + "\n";
        }
    }

    // 교점 계산 로직 구현
    public Point calculateCrossPoint(int[] line1, int[] line2) {
        long a = (long) line1[0];
        long b = (long) line1[1];
        long e = (long) line1[2];
        long c = (long) line2[0];
        long d = (long) line2[1];
        long f = (long) line2[2];

        long denominator = (a * d - b * c);

        // 평행일 때(= 분모가 0일 때) 교점 생성 X -> 예외처리
        if (denominator == 0) {
            return null;
        }

        double x = (double) (b * f - e * d) / (a * d - b * c);
        double y = (double) (e * c - a * f) / (a * d - b * c);
        if (x % 1 != 0 || y % 1 != 0) {
            return null;
        }

        return new Point((long)x, (long)y);
    }

    public String[] solution(int[][] line) {
        String[] answer = {};
        List<int[]> selectedLine = new ArrayList<>();
        List<Point> points = new ArrayList<>();

        for (int i = 0; i < line.length; i++) {
            for (int j = i + 1; j < line.length; j++) {
                // 직선 두 개 선택
                int[] line1 = line[i];
                int[] line2 = line[j];

                // 평행하지 않을 때만 교점 생성
                Point point = calculateCrossPoint(line1, line2);
                if (point != null) {
                    points.add(point);
                }
            }
        }

        // for (int i = 0; i < points.size(); i++) {
        //     System.out.println(points.get(i).toString());
        // }

        // stream() 사용 방법 공부하기
        long minX = points.stream()
            .min(Comparator.comparingLong(p -> p.x))
            .get().x;

        long maxX = points.stream()
            .max(Comparator.comparingLong(p -> p.x))
            .get().x;

        long minY = points.stream()
            .min(Comparator.comparingLong(p -> p.y))
            .get().y;

        long maxY = points.stream()
            .max(Comparator.comparingLong(p -> p.y))
            .get().y;

        // System.out.println(minX);
        // System.out.println(maxX);
        // System.out.println(minY);
        // System.out.println(maxY);

        int width = (int) (maxX - minX + 1);
        int height = (int) (maxY - minY + 1);

        char[][] result = new char[height][width];

        // 모든 배열을 '.'로 초기화
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                result[i][j] = '.';
            }
        }

        for (int i = 0; i < points.size(); i++) {
            int x = (int) (points.get(i).x - minX);
            int y = (int) (maxY - points.get(i).y);
            // System.out.println("---");
            // System.out.println(x);
            // System.out.println(minX);
            // System.out.println("---");
            // System.out.println(y);
            // System.out.println(minY);
            result[y][x] = '*';
        }

        answer = new String[result.length];

        for (int i = 0; i < result.length; i++) {
            answer[i] = new String(result[i]);
        }

        return answer;
    }
}