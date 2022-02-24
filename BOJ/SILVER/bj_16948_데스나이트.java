package SILVER;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class bj_16948_데스나이트 {
	static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer tokens;
	static int N;
	static int[][]deltas= {{-2,-1},{-2,1},{0,-2},{0,2},{2,-1},{2,1}};
	static int r1,c1,r2,c2;
	static Queue<Point>queue;
	public static void main(String[] args) throws Exception{
		N=Integer.parseInt(br.readLine());
		
		tokens=new StringTokenizer(br.readLine());
		r1=Integer.parseInt(tokens.nextToken());
		c1=Integer.parseInt(tokens.nextToken());
		r2=Integer.parseInt(tokens.nextToken());
		c2=Integer.parseInt(tokens.nextToken());
		
		queue=new LinkedList<>();
		queue.offer(new Point(r1,c1));
		
		Bfs();
	}
	private static void Bfs() {
		boolean[][]visited=new boolean[201][201];
		int depth=0;
		while(!queue.isEmpty()) {
			int size=queue.size();
			
			while(size-->0) {
				Point p=queue.poll();
				visited[p.r][p.c]=true;
				if(p.r==r2&&p.c==c2) {
					System.out.println(depth);
					System.exit(0);
				}
				for(int d=0;d<deltas.length;d++) {
					int nr=p.r+deltas[d][0];
					int nc=p.c+deltas[d][1];
					if(isIn(nr,nc)&&!visited[nr][nc]) {
						visited[nr][nc]=true;
						queue.offer(new Point(nr,nc));
					}
				}
			}
			depth++;
		}
		System.out.println(-1);
	}
	private static boolean isIn(int r,int c) {
		return r>=0&&c>=0&&r<=200&c<=200;
	}
	private static class Point{
		int r,c;
		public Point(int r,int c) {
			this.r=r;
			this.c=c;
		}
	}

}
