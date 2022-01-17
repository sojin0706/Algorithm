package GOLD;
package ?��?��??�?;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;
//1.0?��곳에 3개의 �? ?��?���?  => nC3 ?��체의 �? 공간?��?�� 3개의 �? 공간?�� ?��?��?��보자 => �? 건설 (모든 공간?�� ?��?��?��?��면서)
// 바이?��?���? 중심?���? ?��질수?��?���? 찾아보니(?��방탐?��?���? �? ?�� ?��?�� 공간?�� ?��?���? go)
// =>BFS(최단거리)/DFS => ?�� 문제?�� ?��마나 빠른?��?���? ?���??��?�� 중요?���? ?��?��?���? bfs/dfs ?��?���? ?��?�� ?���??�� ?��?��.
//?��?��?��?�� 0번의 개수�? ?��?��?�� 최�?�? 출력?���? 


// �?, 조합?���? 3개�?? 뽑�??��?��?�� 벽을 ?��?�� ?�� 바이?��?���? ?��방탐?��?�� ?���? �? ?�� ?��?�� 0?�� 개수?�� 최�?값을 구해보기 

public class bj_14502_?��구소 {
	static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer tokens;
	static StringBuilder output=new StringBuilder();
	static int[][]map;
	static int R,C;
	static List<Point> virus; //바이?��?���? ???��
	static List<Point> normal; //0?�� ???�� 
	static int MAX=Integer.MIN_VALUE;
	static int[][]deltas= {{-1,0},{1,0},{0,1},{0,-1}};
	public static void main(String[] args) throws IOException {
		tokens=new StringTokenizer(br.readLine());
		 R=Integer.parseInt(tokens.nextToken()); //?��
		 C=Integer.parseInt(tokens.nextToken()); //?��
		 map=new int[R][C];
		 virus=new ArrayList<>();
		 normal=new ArrayList<>();
		for(int i=0;i<R;i++) {
			tokens=new StringTokenizer(br.readLine());
			for(int j=0;j<C;j++) {
				map[i][j]=Integer.parseInt(tokens.nextToken());
				if(map[i][j]==2) {
					virus.add(new Point(i,j)); //?���? ?��?�� ???��
				}else if(map[i][j]==0) {
					normal.add(new Point(i,j)); //만약 0?���? ?��?��?�� ???��
				}
			} 
		}
		//?��?�� normal?�� ???��?��것중?��  3개의 ?��치�?? 조합?���? 골라보기
		makeWallCombination(3,new Point[3],0);
		
		System.out.println(MAX);
		
	}
	
	private static void makeWallCombination(int toChoose,Point[]choosed,int start) {
		if(toChoose==0) {
			//�? ?���? ?���? ?��?�� ?�� --> �? ?��?���?, ?��?��?��?�� ?��?��?��보자 
			check(choosed);
			return;
		}
		for(int i=start;i<normal.size();i++) {
			choosed[choosed.length-toChoose]=normal.get(i);
			makeWallCombination(toChoose-1,choosed,i+1);
		}
	}
	
	
	public static void check(Point[]visited) {
		//1.?��것들�? �? ?��?���?
		
		for(Point p:visited) {
			map[p.r][p.c]=1; //�? ?��?��주기
		}
		
		//2.바이?��?�� ?��?��리고 카운?��?���?
		
		int polluted=bfs();
		
		MAX=Math.max(MAX, normal.size()-polluted-3);
		
		for(Point p:visited) {
			map[p.r][p.c]=0; //�? 초기?��
		}	
		
	
	}
	
	public static int bfs() {
		//기본?��?���? bfs?�� queue?��?��
		Queue<Point> q=new LinkedList<>();
		boolean[][]visited=new boolean[R][C]; //방문?���? ?��?��
		int Polluted=0;
		for(Point head:virus) {
			q.offer(head);
			visited[head.r][head.c]=true;
		}
		
		while(!q.isEmpty()) {
			Point head=q.poll();
			for(int d=0;d<deltas.length;d++) {
				int nr=head.r+deltas[d][0];
				int nc=head.c+deltas[d][1];
				
				if(isIn(nr,nc)&&map[nr][nc]==0&&visited[nr][nc]==false) {
					visited[nr][nc]=true;
					q.offer(new Point(nr,nc));
					Polluted++;
				}
			}
		}
		
		return Polluted;
		
	}
	public static boolean isIn(int r,int c) {
		return r>=0&&r<R&&c>=0&&c<C;
	}
	
	
	static class Point{
		int r,c; //?���? ?��?�� ???��?��?��?��게한?��. 
		
		public Point(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}

		@Override
		public String toString() {
			return "Point [r=" + r + ", c=" + c + "]";
		}
		
	}

}
