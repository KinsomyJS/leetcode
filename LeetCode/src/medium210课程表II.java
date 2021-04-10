import java.util.*;

public class medium210课程表II {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<List<Integer>> edges = new ArrayList<>();
        int[] res = new int[numCourses];
        int[] indegree = new int[numCourses];

        for (int i = 0; i < numCourses; i++) {
            edges.add(new ArrayList<>());
        }

        for (int[] pre : prerequisites) {
            edges.get(pre[1]).add(pre[0]);
            ++indegree[pre[0]];
        }

        Queue<Integer> queue = new LinkedList<>();
        for (int j = 0; j < numCourses; j++) {
            if (indegree[j] == 0) {
                queue.offer(j);
            }
        }

        int visited = 0;
        while (!queue.isEmpty()) {
            int lesson = queue.poll();
            res[visited] = lesson;
            ++visited;
            for (int n : edges.get(lesson)) {
                --indegree[n];
                if (indegree[n] == 0) {
                    queue.offer(n);
                }
            }
        }
        if (visited == numCourses) {
            return res;
        } else {
            return new int[0];
        }
    }
}
