package TOP_450.GRAPHS;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class CourseScheduleI {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>(numCourses);
        int[] indegrees = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            indegrees[i] = 0;
            graph.add(new ArrayList<>());
        }

        for (int[] prerequisite : prerequisites) {
            graph.get(prerequisite[1]).add(prerequisite[0]);
            indegrees[prerequisite[0]]++;
        }
        Queue<Integer> queue = new LinkedList<>();
        // Push all the nodes with indegree zero in the queue.
        for (int i = 0; i < indegrees.length; i++) {
            if (indegrees[i] == 0) {
                queue.offer(i);
            }
        }
        int visitedNodes = 0;
        while (!queue.isEmpty()) {
            Integer current = queue.poll();
            visitedNodes++;
            for (Integer i : graph.get(current)) {
                // Delete the edge "node -> neighbor".
                indegrees[i]--;
                if (indegrees[i] == 0) {
                    queue.offer(i);
                }
            }
        }
        return visitedNodes == numCourses;
    }

    public static void main(String[] args) {
        CourseScheduleI courseScheduleI = new CourseScheduleI();
        int numCourses = 4;
        int[][] prerequisites = {{1, 0}, {2, 0}, {3, 1}, {3, 2}};
        System.out.println(courseScheduleI.canFinish(numCourses, prerequisites));
    }
}
