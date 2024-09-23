import java.util.*;

public class sep22_2 {

    private static boolean[] visited; // 방문 여부를 체크하는 배열
    private static ArrayList<Integer>[] graph; // 그래프를 저장할 인접 리스트

    // DFS 메서드
    public static void dfs(int v) {
        visited[v] = true; // 현재 정점 방문 표시
        System.out.print(v + " "); // 방문한 정점 출력

        // 현재 정점에서 갈 수 있는 정점들을 탐색
        for (int next : graph[v]) {
            if (!visited[next]) {
                dfs(next); // 방문하지 않은 정점이면 재귀 호출
            }
        }
    }

    // BFS 메서드
    public static void bfs(int v) {
        Queue<Integer> queue = new LinkedList<>();
        visited[v] = true; // 시작 정점 방문 표시
        queue.add(v); // 시작 정점을 큐에 넣음

        while (!queue.isEmpty()) {
            int current = queue.poll(); // 큐에서 꺼냄
            System.out.print(current + " "); // 방문한 정점 출력

            // 현재 정점에서 갈 수 있는 정점들을 탐색
            for (int next : graph[current]) {
                if (!visited[next]) {
                    visited[next] = true; // 방문 표시
                    queue.add(next); // 큐에 추가
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 입력 받기
        int n = sc.nextInt(); // 정점의 개수
        int m = sc.nextInt(); // 간선의 개수
        int v = sc.nextInt(); // 탐색을 시작할 정점 번호

        // 그래프 초기화
        graph = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        // 간선 정보 입력받기
        for (int i = 0; i < m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            graph[a].add(b);
            graph[b].add(a); // 양방향이므로 두 정점 모두에 추가
        }

        // 번호가 작은 것부터 탐색하기 위해 각 리스트를 정렬
        for (int i = 1; i <= n; i++) {
            Collections.sort(graph[i]);
        }

        // DFS 실행
        visited = new boolean[n + 1];
        dfs(v);
        System.out.println();

        // BFS 실행
        visited = new boolean[n + 1];
        bfs(v);
        System.out.println();

        sc.close();
    }
}