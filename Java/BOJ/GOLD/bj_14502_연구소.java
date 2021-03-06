package GOLD;
package ?Ό???κΈ?;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;
//1.0?Έκ³³μ 3κ°μ λ²? ?Έ?°κΈ?  => nC3 ? μ²΄μ λΉ? κ³΅κ°?? 3κ°μ λΉ? κ³΅κ°? ? ??΄λ³΄μ => λ²? κ±΄μ€ (λͺ¨λ  κ³΅κ°? ???€?λ©΄μ)
// λ°μ΄?¬?€λ₯? μ€μ¬?Όλ‘? ?Όμ§μ??κ±? μ°Ύμλ³΄λ(?¬λ°©ν??Όλ‘? κ°? ? ?? κ³΅κ°?΄ ??Όλ©? go)
// =>BFS(μ΅λ¨κ±°λ¦¬)/DFS => ?΄ λ¬Έμ ? ?Όλ§λ λΉ λ₯Έ??λ‘? ?Όμ§??? μ€μ?μ§? ??Ό?κΉ? bfs/dfs ?΄?€κ±? ?°? ?κ΄??΄ ??€.
//?¨??? 0λ²μ κ°μλ₯? ?Έ?΄? μ΅λ?κ°? μΆλ ₯?κΈ? 


// μ¦?, μ‘°ν©?Όλ‘? 3κ°λ?? λ½μ??€?? λ²½μ ?Έ?΄ ? λ°μ΄?¬?€λ₯? ?¬λ°©ν?? ?μΌ? κ°? ? ?? 0? κ°μ? μ΅λ?κ°μ κ΅¬ν΄λ³΄κΈ° 

public class bj_14502_?°κ΅¬μ {
	static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer tokens;
	static StringBuilder output=new StringBuilder();
	static int[][]map;
	static int R,C;
	static List<Point> virus; //λ°μ΄?¬?€λ₯? ???₯
	static List<Point> normal; //0? ???₯ 
	static int MAX=Integer.MIN_VALUE;
	static int[][]deltas= {{-1,0},{1,0},{0,1},{0,-1}};
	public static void main(String[] args) throws IOException {
		tokens=new StringTokenizer(br.readLine());
		 R=Integer.parseInt(tokens.nextToken()); //?
		 C=Integer.parseInt(tokens.nextToken()); //?΄
		 map=new int[R][C];
		 virus=new ArrayList<>();
		 normal=new ArrayList<>();
		for(int i=0;i<R;i++) {
			tokens=new StringTokenizer(br.readLine());
			for(int j=0;j<C;j++) {
				map[i][j]=Integer.parseInt(tokens.nextToken());
				if(map[i][j]==2) {
					virus.add(new Point(i,j)); //?κ³? ?΄? ???₯
				}else if(map[i][j]==0) {
					normal.add(new Point(i,j)); //λ§μ½ 0?΄λ©? ? ?? ???₯
				}
			} 
		}
		//?΄?  normal? ???₯?κ²μ€?  3κ°μ ?μΉλ?? μ‘°ν©?Όλ‘? κ³¨λΌλ³΄κΈ°
		makeWallCombination(3,new Point[3],0);
		
		System.out.println(MAX);
		
	}
	
	private static void makeWallCombination(int toChoose,Point[]choosed,int start) {
		if(toChoose==0) {
			//λ²? ?€μΉ? ?μΉ? ? ?  ? --> λ²? ?Έ?°κ³?, ?? ??­ ??Έ?΄λ³΄μ 
			check(choosed);
			return;
		}
		for(int i=start;i<normal.size();i++) {
			choosed[choosed.length-toChoose]=normal.get(i);
			makeWallCombination(toChoose-1,choosed,i+1);
		}
	}
	
	
	public static void check(Point[]visited) {
		//1.?΄κ²λ€λ‘? λ²? ?Έ?°κΈ?
		
		for(Point p:visited) {
			map[p.r][p.c]=1; //λ²? ?Έ?μ£ΌκΈ°
		}
		
		//2.λ°μ΄?¬?€ ?Ό?Έλ¦¬κ³  μΉ΄μ΄?Έ?κΈ?
		
		int polluted=bfs();
		
		MAX=Math.max(MAX, normal.size()-polluted-3);
		
		for(Point p:visited) {
			map[p.r][p.c]=0; //λ²? μ΄κΈ°?
		}	
		
	
	}
	
	public static int bfs() {
		//κΈ°λ³Έ? ?Όλ‘? bfs? queue?¬?©
		Queue<Point> q=new LinkedList<>();
		boolean[][]visited=new boolean[R][C]; //λ°©λ¬Έ?¬λΆ? ??Έ
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
		int r,c; //?κ³? ?΄? ???₯? ??κ²ν?€. 
		
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
