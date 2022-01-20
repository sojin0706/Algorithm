package GOLD;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class bj_17129_¹«½¼µüµû±¸¸® {
	static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer tokens;
	static int[][]map;
	static int N,M;
	static int[][]deltas= {{-1,0},{1,0},{0,-1},{0,1}};
	public static void main(String[] args) throws IOException {
		tokens=new StringTokenizer(br.readLine());
		N=Integer.parseInt(tokens.nextToken());
		M=Integer.parseInt(tokens.nextToken());
		int r1=0,c1=0;
		map=new int[N][M];
		for(int r=0;r<N;r++) {
			String str=br.readLine();
			for(int c=0;c<M;c++) {
				map[r][c]=str.charAt(c)-'0';
				if(map[r][c]==2) {
					r1=r;
					c1=c;
				}
			}
		}
		bfs(r1,c1,0);

	}
	private static void bfs(int r,int c,int cnt) {
		Queue<Point>queue=new LinkedList<>();
		queue.offer(new Point(r,c));
		boolean[][] visited=new boolean[N][M];
		visited[r][c]=true;
		int size=0,depth=0;
		while(!queue.isEmpty()) {
			size=queue.size();
			while(size-->0) {
				Point head=queue.poll();
				
				if(map[head.r][head.c]==3||map[head.r][head.c]==4||map[head.r][head.c]==5) {
					System.out.println("TAK");
					System.out.println(depth);
					System.exit(0);
				}
			for(int d=0;d<deltas.length;d++) {
				int nr=head.r+deltas[d][0];
				int nc=head.c+deltas[d][1];
				if(isIn(nr,nc)&&map[nr][nc]!=1&&!visited[nr][nc]) {
					visited[nr][nc]=true;
					queue.offer(new Point(nr,nc));
				}
			}
		}
			depth++;
			}
			
		
		System.out.println("NIE");
	}
	private static boolean isIn(int r,int c) {
		return r>=0&&c>=0&&r<N&&c<M;
	}
	private static class Point{
		int r,c;

		public Point(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}
		
	}

}
