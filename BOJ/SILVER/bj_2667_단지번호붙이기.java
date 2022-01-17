package SILVER;
package ?��?��??�?;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class bj_2667_?���?번호붙이�? {
	static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer tokens;
	static StringBuilder output=new StringBuilder();
	static int[][]map;
	static int[][]deltas= {{-1,0},{1,0},{0,-1},{0,1}};
	static boolean[][] visited;
	//0,0�??�� ?��?��?��?���? 1?�� ?��?���? bfs?��?��=>totalCount++, count�? 1?�� 개수 ?��주고 1�? ?��?��주기 그리�? �? 개수�? 배열?�� ?��?��주기
	//그리�? ?��?�� 1?? 0?���? 바꿔주고 ?�� ?��?�� 1?��?��?���? ?�� ?���? �? 개수 배열?�� ?���?	
	//마�?막엔 배열 ?��?��?���? totalcount?? 출력
	static int totalCnt=0;
	static int count;
	static List<Integer> counts=new ArrayList<Integer>(); //몇개�? ???��?���? 불분명해?�� 리스?���? 받음 
	static int N;

	public static void main(String[] args) throws NumberFormatException, IOException {
		N=Integer.parseInt(br.readLine());
		visited=new boolean[N][N];
		map=new int[N][N];
		for(int i=0;i<N;i++) {
			String str=br.readLine();
			for(int j=0;j<N;j++) {
				map[i][j]=str.charAt(j)-'0';
			}
		}
		
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				if(map[i][j]==1&&visited[i][j]==false) {
					bfs(i,j);
				}
			}
		}
		Collections.sort(counts);
		output.append(totalCnt).append("\n");
		for(int i=0;i<counts.size();i++) {
			if(i==counts.size()-1) {
				output.append(counts.get(i));
				break;
			}
			output.append(counts.get(i)).append("\n");
		}
		System.out.println(output);
	}
	private static void bfs(int r,int c) {
		totalCnt++;
		Queue<Point>queue=new LinkedList<>();
		queue.offer(new Point(r,c));
	
		count=1;
		while(!queue.isEmpty()) {
			Point head=queue.poll();
			visited[head.r][head.c]=true;
			for(int d=0;d<deltas.length;d++) {
				int nr=head.r+deltas[d][0];
				int nc=head.c+deltas[d][1];
				
				if(isIn(nr,nc)&&map[nr][nc]==1&&visited[nr][nc]==false) {
					visited[nr][nc]=true;
					count++;
					queue.offer(new Point(nr,nc));
				}
			}
		}
		
		counts.add(count);
	}
	private static boolean isIn(int r,int c) {
		return r>=0&&r<N&&c>=0&&c<N;
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
