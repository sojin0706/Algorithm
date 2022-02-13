package SILVER;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class bj_14716_Çö¼ö¸· {
	static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer tokens;
	static int R,C;
	static int[][]map;
	static boolean[][]visited;
	static int[][]deltas= {{-1,0},{1,0},{0,-1},{0,1},{-1,-1},{-1,1},{1,-1},{1,1}};
	public static void main(String[] args) throws Exception{
		tokens=new StringTokenizer(br.readLine());
		R=Integer.parseInt(tokens.nextToken());
		C=Integer.parseInt(tokens.nextToken());
		map=new int[R][C];
		
		
		for(int r=0;r<R;r++) {
			tokens=new StringTokenizer(br.readLine());
			for(int c=0;c<C;c++) {
				map[r][c]=Integer.parseInt(tokens.nextToken());
			}
		}
		int cnt=0;
		visited=new boolean[R][C];
		for(int r=0;r<R;r++) {
			for(int c=0;c<C;c++) {
				if(map[r][c]==1&&!visited[r][c]) {
					bfs(r,c);
					cnt++;
				}
			}
		}
		
		System.out.println(cnt);
	}
	private static void bfs(int r,int c) {
		Queue<Point>queue=new LinkedList<>();
		queue.offer(new Point(r,c));
	
		visited[r][c]=true;
		while(!queue.isEmpty()) {
			Point p=queue.poll();
			for(int d=0;d<deltas.length;d++) {
				int nr=p.r+deltas[d][0];
				int nc=p.c+deltas[d][1];
				if(isIn(nr,nc)&&!visited[nr][nc]&&map[nr][nc]==1) {
					queue.offer(new Point(nr,nc));
					visited[nr][nc]=true;
				}
			}
		}
	}
	private static boolean isIn(int r,int c) {
		return r>=0&&c>=0&&r<R&&c<C;
	}
	
	private static class Point{
		int r,c;
		public Point(int r,int c) {
			this.r=r;
			this.c=c;
		}
	}

}
