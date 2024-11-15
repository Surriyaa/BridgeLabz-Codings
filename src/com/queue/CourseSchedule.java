package com.queue;

import java.util.*;

public class CourseSchedule {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] inDegree = new int[numCourses];
        Map<Integer, List<Integer>> graph = new HashMap<>();

        for (int[] prerequisite : prerequisites) {
            inDegree[prerequisite[0]]++;
            graph.computeIfAbsent(prerequisite[1], k -> new ArrayList<>()).add(prerequisite[0]);
        }

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (inDegree[i] == 0) {
                queue.offer(i);
            }
        }

        int completedCourses = 0;
        while (!queue.isEmpty()) {
            int course = queue.poll();
            completedCourses++;
            if (graph.containsKey(course)) {
                for (int nextCourse : graph.get(course)) {
                    inDegree[nextCourse]--;
                    if (inDegree[nextCourse] == 0) {
                        queue.offer(nextCourse);
                    }
                }
            }
        }

        return completedCourses == numCourses;
    }
    public static void main(String[] args) {
    	System.out.println("Testing Course Schedule:");
        int[][] prerequisites = {{1, 0}, {2, 1}, {3, 2}};
        CourseSchedule courseSchedule = new CourseSchedule();
        System.out.println("Can finish all courses: " + courseSchedule.canFinish(4, prerequisites));  // Should print true
        System.out.println();
	}
}
