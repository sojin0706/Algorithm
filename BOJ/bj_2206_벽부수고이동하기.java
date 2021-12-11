package 코딩테스트준비;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class bj_2206_벽부수고이동하기 {
	static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer tokens;
	static int N,M;
	static int[][] map,visited;
	static Queue<Point> queue=new LinkedList<>();
	static int[][]deltas= {{-1,0},{1,0},{0,-1},{0,1}};
	public static void main(String[] args) throws IOException {
		tokens=new StringTokenizer(br.readLine());
		N=Integer.parseInt(tokens.nextToken()); //행
		M=Integer.parseInt(tokens.nextToken()); //열
		map=new int[N][M];
		visited=new int[N][M];
		for(int i=0;i<N;i++) {
			String str=br.readLine();
			for(int j=0;j<M;j++) {
				map[i][j]=str.charAt(j)-'0';
				 visited[i][j] = Integer.MAX_VALUE;
			}
		}//입력완료
		
		System.out.println(bfs(0,0));
	}

	private static int bfs(int r,int c) {
		queue.offer(new Point(r,c,1,0)); //이동거리와 부순횟수는 아직 0이다.
		visited[r][c]=0;
		while(!queue.isEmpty()) {
			Point head=queue.poll();
			if(head.r==N-1&&head.c==M-1) {
				return head.dist;
			}
			for(int d=0;d<deltas.length;d++) {
				int nr=head.r+deltas[d][0];
				int nc=head.c+deltas[d][1];
				
				if(isIn(nr,nc)) {
					if(visited[nr][nc]>head.d_count) {
						if(map[nr][nc]==0) {
							visited[nr][nc]=head.d_count;
							queue.offer(new Point(nr,nc,head.dist+1,head.d_count));	
						}else {
							//벽인데 한번도 안뚫음? 
							if(head.d_count==0){
								 visited[nr][nc] = head.d_count+1;
								queue.offer(new Point(nr,nc,head.dist+1,head.d_count+1));
							}
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
		int r,c,dist,d_count; //행,열,이동거리,부순횟수

		public Point(int r, int c, int dist, int d_count) {
			super();
			this.r = r;
			this.c = c;
			this.dist = dist;
			this.d_count = d_count;
		}
	}

}
