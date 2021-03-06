package GOLD??€?Έμ€?λΉ?;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class bj_14442_λ²½λ??κ³ μ΄??κΈ?2 {
	static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer tokens;
	static int N,M,K;
	static int[][] map;
	static boolean[][][]visited;
	static Queue<Point> queue=new LinkedList<>();
	static int[][]deltas= {{-1,0},{1,0},{0,-1},{0,1}};
	public static void main(String[] args) throws IOException {
		tokens=new StringTokenizer(br.readLine());
		N=Integer.parseInt(tokens.nextToken()); //?
		M=Integer.parseInt(tokens.nextToken()); //?΄
		K=Integer.parseInt(tokens.nextToken()); //κ°??₯? μ΅λ? 
		map=new int[N][M];
		visited=new boolean[N][M][K+1];
		for(int i=0;i<N;i++) {
			String str=br.readLine();
			for(int j=0;j<M;j++) {
				map[i][j]=str.charAt(j)-'0';
			}
		}//?? ₯?λ£?
		System.out.println(bfs(0,0));
	}

	private static int bfs(int r,int c) {
		
		queue.offer(new Point(r,c,1,0)); //?΄?κ±°λ¦¬?? λΆ????? ?μ§? 0?΄?€.
		visited[r][c][0]=true; //?μ§? ?λ²λ ?΄?x 
		while(!queue.isEmpty()) {
			Point head=queue.poll();
			if(head.r==N-1&&head.c==M-1) {
				return head.dist;
			}
			for(int d=0;d<deltas.length;d++) {
				int nr=head.r+deltas[d][0];
				int nc=head.c+deltas[d][1];
				
				if(isIn(nr,nc)) {
					//λ§μ½ λ²½μ΄ ??λ©??
					if(map[nr][nc]==0&&visited[nr][nc][head.d_count]==false) {
						visited[nr][nc][head.d_count]=true;
						queue.offer(new Point(nr,nc,head.dist+1,head.d_count));
					} //λ²½μ΄λ©??
					else {
						if(head.d_count<K&&visited[nr][nc][head.d_count+1]==false) {
							visited[nr][nc][head.d_count+1]=true;
							queue.offer(new Point(nr,nc,head.dist+1,head.d_count+1));
						}
		    		}
				}
			}	
		}
		return -1;
	}
	private static boolean isIn(int r,int c) {
		return r>=0&&c>=0&&r<N&&c<M;
	}
	
	private static class Point{
		int r,c,dist,d_count; //?,?΄,?΄?κ±°λ¦¬,λΆ????

		public Point(int r, int c, int dist, int d_count) {
			super();
			this.r = r;
			this.c = c;
			this.dist = dist;
			this.d_count = d_count;
		}
	}

}
