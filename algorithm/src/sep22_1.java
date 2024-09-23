// https://www.acmicpc.net/problem/1926 이문제를 bfs로 풀어보기
import java.util.*;
public class sep22_1 {
    static int n,m;
    static int[][] grid;
    static boolean[][] visited;
    static int[] dy = {0,0,-1,1};
    static int[] dx = {1, -1, 0, 0};

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();

        grid = new int[n][m];
        visited = new boolean[n][m];

        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                grid[i][j] = sc.nextInt();
            }
        }

        int pictureCnt = 0;
        int maxArea = 0;

        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(grid[i][j] == 1 && !visited[i][j]){
                    int area = bfs(i, j);
                    pictureCnt++;
                    maxArea = Math.max(maxArea, area);
                }
            }
        }

        System.out.println(pictureCnt);
        System.out.println(maxArea);

        sc.close();
    }

    public static int bfs(int x, int y){
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{x,y});
        visited[x][y] = true;

        int area = 1;

        while(!queue.isEmpty()){
            int[] now = queue.poll();
            int nowX = now[0];
            int nowY = now[1];
            for(int i = 0; i < 4; i++){
                int newX = nowX + dx[i];
                int newY = nowY + dy[i];
                if(newX >= 0 && newX < n && newY >= 0 && newY < m){
                    if(grid[newX][newY] == 1 && !visited[newX][newY]){
                        visited[newX][newY] = true;
                        area++;
                        queue.add(new int[]{newX, newY});
                    }
                }
            }
        }

        return area;
    }


}
