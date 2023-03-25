package com.amg.farthestnodefinder;

import java.util.*;
/*

Dijkstra
Time Complexity : O(E + E log(E))
SpaceComplexity: O(V+E)

*/

public class Dijkstra {
    // edge record with vertex and weight
    record Edge(int vertex, int weight) {
    }

    public int[] find(int[][] weights, int n, int q) {
        // create undirected graph edges list
        List<Edge>[] graph = new List[n];
        for (int i = 0; i < n; i++) graph[i] = new ArrayList<>();
        for (var t : weights) {
            graph[t[0]].add(new Edge(t[1], t[2]));
            graph[t[1]].add(new Edge(t[0], t[2]));
        }

        int[] distance = new int[n];
        Queue<Integer> queue = new PriorityQueue<>((u, v) -> Math.abs(distance[u] - distance[v]));
        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[q] = 0;
        queue.offer(q);

        while (!queue.isEmpty()) {
            var node = queue.poll();
            for (var neighbour : graph[node]) {

                int new_distance = distance[node] + neighbour.weight;
                if (new_distance >= distance[neighbour.vertex]) continue;
                distance[neighbour.vertex] = new_distance;
                queue.offer(neighbour.vertex);
            }
        }

        return distance;
    }
}