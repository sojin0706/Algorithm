package SILVER;

package ?òº?ûê??Í∏?;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class bj_1012_?ú†Í∏∞ÎÜçÎ∞∞Ï∂î {
	static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer tokens;
	static StringBuilder output=new StringBuilder();
	static int R,C,N;
	static int[][]map;
	static boolean[][]visited;
	static int count;
	static int[][]deltas= {{-1,0},{1,0},{0,-1},{0,1}};
	public static void main(String[] args) throws NumberFormatException, IOException {
		int T=Integer.parseInt(br.readLine());
		for(int t=1;t<=T;t++) {
			count=0;
			tokens=new StringTokenizer(br.readLine());
			C=Integer.parseInt(tokens.nextToken()); //Í∞?Î°úÍ∏∏?ù¥
			R=Integer.parseInt(tokens.nextToken()); //?Ñ∏Î°úÍ∏∏?ù¥
			N=Integer.parseInt(tokens.nextToken()); //Î∞∞Ï∂î Í∞úÏàò 
			map=new int[R][C];
			visited=new boolean[R][C];
			for(int i=0;i<N;i++) {
				tokens=new StringTokenizer(br.readLine());
				int x=Integer.parseInt(tokens.nextToken());
				int y=Integer.parseInt(tokens.nextToken());
				map[y][x]=1;
			}
			for(int y=0;y<R;y++) {
				for(int x=0;x<C;x++) {
					if(map[y][x]==1&&visited[y][x]==false) {
						bfs(y,x);
					}
				}
			}
			output.append(count).append("\n");
		}
		System.out.println(output);

	}
	static void bfs(int y,int x) {
		count++;
		Queue<Point>queue=new LinkedList<>();
		queue.offer(new Point(y,x));
		while(!queue.isEmpty()) {
			Point head=queue.poll();
			visited[head.y][head.x]=true;
			
			for(int d=0;d<deltas.length;d++) {
				int ny=head.y+deltas[d][0];
				int nx=head.x+deltas[d][1];
				
				if(isIn(ny,nx)&&map[ny][nx]==1&&visited[ny][nx]==false) {
					queue.offer(new Point(ny,nx));
					visited[ny][nx]=true;
				}
				
			}
			
		}
		
		
	}
	static boolean isIn(int y,int x) {
		return y>=0&&y<R&&x>=0&&x<C;
	}
	
	static class Point{
		int y,x;

		public Point(int y, int x) {
			super();
			this.y = y;
			this.x = x;
		}
		
		
	}

}
