package SILVER;
package ?òº?ûê??Í∏?;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class bj_2178_ÎØ∏Î°ú?Éê?Éâ {
	static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer tokens;
	static StringBuilder output=new StringBuilder();
	static int[][]map;
	static int R,C;
	static int[][] deltas= {{-1,0},{1,0},{0,1},{0,-1}};
	public static void main(String[] args) throws IOException {
		tokens=new StringTokenizer(br.readLine());
		R=Integer.parseInt(tokens.nextToken()); //?ñâ
		C=Integer.parseInt(tokens.nextToken()); //?ó¥
		map=new int[R][C];

		for(int i=0;i<R;i++) {
			String str=br.readLine();
			for(int j=0;j<C;j++) {
				map[i][j]=str.charAt(j)-'0';
			}
		}
		
		bfs();
		System.out.println(map[R-1][C-1]);

	}
	
	public static void bfs() {
		Queue<Point> queue=new LinkedList<>();
		boolean[][]visited=new boolean[R][C];
		queue.offer(new Point(0,0));
		visited[0][0]=true;
	
		while(!queue.isEmpty()) {
			Point head=queue.poll();
		
			for(int d=0;d<deltas.length;d++) {
				int nr=head.r+deltas[d][0];
				int nc=head.c+deltas[d][1];
				
				if(isIn(nr,nc)&&visited[nr][nc]==false&&map[nr][nc]!=0) {
					queue.offer(new Point(nr,nc));
					visited[nr][nc]=true;
					map[nr][nc]=map[head.r][head.c]+1;
				}
			}
		}
		
		
	}
	static boolean isIn(int r,int c) {
		return r>=0&&r<R&&c>=0&&c<C;
	}
	
	public static class Point{
		int r,c;

		public Point(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}
		
	}

}
