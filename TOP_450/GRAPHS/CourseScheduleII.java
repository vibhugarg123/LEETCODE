package TOP_450.GRAPHS;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class CourseScheduleII {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<List<Integer>> graph = new ArrayList<>(numCourses);
        int[] indegrees = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            indegrees[i] = 0;
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < prerequisites.length; i++) {
            graph.get(prerequisites[i][1]).add(prerequisites[i][0]);
            indegrees[prerequisites[i][0]]++;
        }
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < indegrees.length; i++) {
            if (indegrees[i] == 0) {
                queue.offer(i);
            }
        }
        int nVisited = 0;
        int[] result = new int[numCourses];
        while (!queue.isEmpty()) {
            Integer current = queue.poll();
            result[nVisited] = current;
            nVisited++;

            for (Integer i : graph.get(current)) {
                indegrees[i]--;
                if (indegrees[i] == 0) {
                    queue.offer(i);
                }
            }
        }
        return nVisited == numCourses ? result : new int[]{};
    }

    public static void main(String[] args) {
        CourseScheduleII courseScheduleII = new CourseScheduleII();
        int numCourses = 4;
        int[][] prerequisites = {{1, 0}, {2, 0}, {3, 1}, {3, 2}};
        int[] order = courseScheduleII.findOrder(numCourses, prerequisites);
        for (int i = 0; i < order.length; i++) {
            System.out.print(order[i] + " ");
        }
    }
}
