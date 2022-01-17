package GOLD;


import java.io.*;
import java.util.*;

public class bj_17836_공주님을구해라 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer tokens;
	static int R, C, T;
	static int[][] map;
	static boolean it = false;
	static int[][] deltas = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };
	static int r = 0, c = 0;
	static int out = 0;
	static int min = Integer.MAX_VALUE;
	static boolean[][][] visited;

	public static void main(String[] args) throws IOException {
		tokens = new StringTokenizer(br.readLine());
		R = Integer.parseInt(tokens.nextToken());
		C = Integer.parseInt(tokens.nextToken());
		T = Integer.parseInt(tokens.nextToken());
		visited = new boolean[R][C][2];
		map = new int[R][C];

		for (int r = 0; r < R; r++) {
			tokens = new StringTokenizer(br.readLine());
			for (int c = 0; c < C; c++) {
				map[r][c] = Integer.parseInt(tokens.nextToken());
			}
		} // 입력완료

		bfs(); // bfs
//		System.out.println(check);
		if (out != 1) {
			System.out.println(min);
		} else {
			System.out.println("Fail");
		}

	}

	private static void bfs() {
		Queue<Point> queue = new LinkedList<>();
		queue.offer(new Point(0, 0, 0, 0)); // 시작값 0,0,0,0
		visited[0][0][0] = true;
		while (!queue.isEmpty()) {
			Point p = queue.poll();
			// 끝까지 도달했다?
			if (p.t > T) {
				out = 1;
				return;
			}

			if (p.r == R - 1 && p.c == C - 1) {

				min = Math.min(min, p.t);
				return;
			}

			for (int d = 0; d < deltas.length; d++) {
				int nr = p.r + deltas[d][0];
				int nc = p.c + deltas[d][1];
				// 검을 주운 상태면?
				if (p.get == 1) {
					if (isIn(nr, nc) && visited[nr][nc][1] == false) {
						// 바로 갈 수 있다.
						queue.offer(new Point(nr, nc, p.t + 1, 1));
						visited[nr][nc][1] = true;
					}
				} // 검을 줍지 못한 상태면?
				else {
					if (isIn(nr, nc) && visited[nr][nc][0] == false && map[nr][nc] != 1) {
						if (map[nr][nc] == 2) {
							visited[nr][nc][1] = true;
							queue.offer(new Point(nr, nc, p.t + 1, 1));
						} else {
							visited[nr][nc][0] = true;
							queue.offer(new Point(nr, nc, p.t + 1, 0));
						}
					}
				}
			}

		}
		out = 1;

	}

	private static boolean isIn(int r, int c) {
		return r >= 0 && c >= 0 && r < R && c < C;
	}

	private static class Point {
		int r, c, t, get;

		public Point(int r, int c, int t, int get) {
			this.r = r;
			this.c = c;
			this.t = t;
			this.get = get;
		}
	}

}
