package TOP_450.PRIORITY_QUEUE;

import java.awt.geom.Point2D;
import java.util.Comparator;
import java.util.PriorityQueue;

/*
       Problem-973: K Closed Points to Origin-https://leetcode.com/problems/k-closest-points-to-origin/description/
       Given an array of points where points[i] = [xi, yi] represents a point on the X-Y plane and an integer k, return the
       k closest points to the origin (0, 0).

       The distance between two points on the X-Y plane is the Euclidean distance (i.e., √(x1 - x2)2 + (y1 - y2)2).

        Input: points = [[1,3],[-2,2]], k = 1
        Output: [[-2,2]]
        Explanation:
        The distance between (1, 3) and the origin is sqrt(10).
        The distance between (-2, 2) and the origin is sqrt(8).
        Since sqrt(8) < sqrt(10), (-2, 2) is closer to the origin.
        We only want the closest k = 1 points from the origin, so the answer is just [[-2,2]].

        Input: points = [[3,3],[5,-1],[-2,4]], k = 2
        Output: [[3,3],[-2,4]]
        Explanation: The answer [[-2,4],[3,3]] would also be accepted.
 */
public class KClosestPointsOrigin973 {
    public int[][] kClosest(int[][] points, int k) {
        // Make priority keep to keep k maximum distance from origin
        PriorityQueue<int[]> pq = new PriorityQueue<>(k, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                double dist1 = Point2D.distance(o1[0], o1[1], 0, 0);
                double dist2 = Point2D.distance(o2[0], o2[1], 0, 0);

                return Double.compare(dist2, dist1);
            }
        });

        int i = 0;
        for (i = 0; i < k; i++) {
            pq.offer(points[i]);
        }

        for (; i < points.length; i++) {
            int[] maxDistanceElement = pq.peek();
            assert maxDistanceElement != null;

            if (Point2D.distance(points[i][0], points[i][1], 0, 0) <
                    Point2D.distance(maxDistanceElement[0], maxDistanceElement[1], 0, 0)) {
                pq.poll();
                pq.offer(points[i]);
            }
        }

        return pq.toArray(new int[][]{});
    }

    public static void main(String[] args) {
        int[][] points = {
                {3, 3},
                {5, -1},
                {-2, 4},
        };
        int k = 2;
        int[][] kClosedPoints = new KClosestPointsOrigin973().kClosest(points, k);
        for (int[] kClosedPoint : kClosedPoints) {
            System.out.print(kClosedPoint[0] + " " + kClosedPoint[1] + "\n");
        }
    }
}