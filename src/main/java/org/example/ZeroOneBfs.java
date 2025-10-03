package org.example;

import java.util.*;

public class ZeroOneBfs {

    // 그래프의 간선을 표현하는 클래스
    static class Edge {
        int to;   // 연결된 노드
        int cost; // 간선의 가중치 (0 또는 1)

        public Edge(int to, int cost) {
            this.to = to;
            this.cost = cost;
        }
    }

    /**
     * 0-1 BFS 알고리즘을 사용하여 시작 노드로부터 모든 노드까지의 최단 거리를 계산합니다.
     *
     * @param numNodes 그래프의 전체 노드 수 (0부터 numNodes-1까지)
     * @param adj      인접 리스트 (각 노드에서 나가는 간선들을 저장)
     * @param startNode 탐색을 시작할 노드
     * @return 각 노드까지의 최단 거리를 담은 배열 (도달할 수 없으면 Integer.MAX_VALUE)
     */
    public int[] calculateShortestPaths(int numNodes, List<Edge>[] adj, int startNode) {
        // 모든 노드까지의 최단 거리를 저장할 배열
        // 처음에는 무한대(도달할 수 없음)로 초기화
        int[] dist = new int[numNodes];
        Arrays.fill(dist, Integer.MAX_VALUE);

        // 덱(Deque)을 사용하여 BFS 탐색
        // 0-cost 간선으로 연결된 노드는 덱의 앞에, 1-cost 간선으로 연결된 노드는 덱의 뒤에 삽입
        Deque<Integer> dq = new ArrayDeque<>();

        // 시작 노드의 거리는 0
        dist[startNode] = 0;
        dq.addFirst(startNode); // 시작 노드는 덱의 맨 앞에 추가

        while (!dq.isEmpty()) {
            int u = dq.pollFirst(); // 덱의 앞에서 현재 노드를 꺼냄

            // (선택 사항 최적화) 이미 더 짧은 경로를 찾았거나 처리 완료된 노드이면 스킵
            // 이 최적화는 특정 상황에서 도움이 되지만, dist[u]가 정확하다면 항상 필요한 것은 아닙니다.
            // if (dist[u] < current_dist_from_deque_node) {
            //     continue;
            // }

            // 현재 노드 u에서 갈 수 있는 모든 인접 노드 v를 탐색
            for (Edge edge : adj[u]) {
                int v = edge.to;
                int weight = edge.cost;

                // u를 거쳐 v로 가는 경로가 현재 v의 최단 거리보다 짧으면 업데이트
                if (dist[v] > dist[u] + weight) {
                    dist[v] = dist[u] + weight; // 거리 업데이트

                    // 간선 가중치에 따라 덱에 삽입
                    if (weight == 0) {
                        dq.addFirst(v); // 가중치 0이면 덱의 앞에 삽입 (우선적으로 탐색)
                    } else { // weight == 1
                        dq.addLast(v);  // 가중치 1이면 덱의 뒤에 삽입 (다음 레벨로 밀림)
                    }
                }
            }
        }
        return dist; // 계산된 최단 거리 배열 반환
    }

    public static void main(String[] args) {
        // 예시 그래프 생성
        int numNodes = 6; // 0부터 5까지 총 6개의 노드
        ArrayList<Edge>[] adj = new ArrayList[numNodes];
        for (int i = 0; i < numNodes; i++) {
            adj[i] = new ArrayList<>();
        }

        // 간선 추가: (시작 노드, 끝 노드, 가중치)
        // 0-cost 간선은 마치 같은 레벨에서 이동하는 것처럼 빠르게 처리됨
        // 1-cost 간선은 다음 레벨로 이동하는 것처럼 처리됨

        // (u, v, cost)
        adj[0].add(new Edge(1, 1));
        adj[0].add(new Edge(2, 0)); // 0에서 2로 가는 비용은 0

        adj[1].add(new Edge(3, 0)); // 1에서 3로 가는 비용은 0
        adj[1].add(new Edge(4, 1));

        adj[2].add(new Edge(1, 0)); // 2에서 1로 가는 비용은 0 (다시 1로 돌아옴)
        adj[2].add(new Edge(5, 1));

        adj[3].add(new Edge(5, 0)); // 3에서 5로 가는 비용은 0 (5가 빠르게 도달될 수 있음)

        adj[4].add(new Edge(5, 1)); // 4에서 5로 가는 비용은 1


        // 0-1 BFS 객체 생성
        ZeroOneBfs zeroOneBFS = new ZeroOneBfs();
        int startNode = 0;

        System.out.println("0-1 BFS를 이용한 최단 경로 계산 (시작 노드: " + startNode + ")");
        int[] shortestDistances = zeroOneBFS.calculateShortestPaths(numNodes, adj, startNode);

        // 결과 출력
        for (int i = 0; i < numNodes; i++) {
            if (shortestDistances[i] == Integer.MAX_VALUE) {
                System.out.println("노드 " + i + ": 도달 불가능");
            } else {
                System.out.println("노드 " + i + ": " + shortestDistances[i]);
            }
        }
    }
}
