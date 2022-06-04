package GOLD;
package ?˜¼???ê¸?;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;
//1.0?¸ê³³ì— 3ê°œì˜ ë²? ?„¸?š°ê¸?  => nC3 ? „ì²´ì˜ ë¹? ê³µê°„?—?„œ 3ê°œì˜ ë¹? ê³µê°„?„ ?„ ?ƒ?•´ë³´ì => ë²? ê±´ì„¤ (ëª¨ë“  ê³µê°„?„ ?Œ?•„?‹¤?‹ˆë©´ì„œ)
// ë°”ì´?Ÿ¬?Š¤ë¥? ì¤‘ì‹¬?œ¼ë¡? ?¼ì§ˆìˆ˜?ˆ?Š”ê±? ì°¾ì•„ë³´ë‹ˆ(?‚¬ë°©íƒ?ƒ‰?œ¼ë¡? ê°? ?ˆ˜ ?ˆ?Š” ê³µê°„?´ ?ˆ?œ¼ë©? go)
// =>BFS(ìµœë‹¨ê±°ë¦¬)/DFS => ?´ ë¬¸ì œ?Š” ?–¼ë§ˆë‚˜ ë¹ ë¥¸?†?„ë¡? ?¼ì§??ƒ?Š” ì¤‘ìš”?•˜ì§? ?•Š?œ¼?‹ˆê¹? bfs/dfs ?–´?–¤ê±? ?“°?˜ ?ƒê´??´ ?—†?‹¤.
//?‚¨?•„?ˆ?Š” 0ë²ˆì˜ ê°œìˆ˜ë¥? ?„¸?–´?„œ ìµœë?ê°? ì¶œë ¥?•˜ê¸? 


// ì¦?, ì¡°í•©?œ¼ë¡? 3ê°œë?? ë½‘ì??‹¤?Œ?— ë²½ì„ ?„¸?š´ ?›„ ë°”ì´?Ÿ¬?Š¤ë¥? ?‚¬ë°©íƒ?ƒ‰?„ ?‹œì¼? ê°? ?ˆ˜ ?ˆ?Š” 0?˜ ê°œìˆ˜?˜ ìµœë?ê°’ì„ êµ¬í•´ë³´ê¸° 

public class bj_14502_?—°êµ¬ì†Œ {
	static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer tokens;
	static StringBuilder output=new StringBuilder();
	static int[][]map;
	static int R,C;
	static List<Point> virus; //ë°”ì´?Ÿ¬?Š¤ë¥? ???¥
	static List<Point> normal; //0?„ ???¥ 
	static int MAX=Integer.MIN_VALUE;
	static int[][]deltas= {{-1,0},{1,0},{0,1},{0,-1}};
	public static void main(String[] args) throws IOException {
		tokens=new StringTokenizer(br.readLine());
		 R=Integer.parseInt(tokens.nextToken()); //?–‰
		 C=Integer.parseInt(tokens.nextToken()); //?—´
		 map=new int[R][C];
		 virus=new ArrayList<>();
		 normal=new ArrayList<>();
		for(int i=0;i<R;i++) {
			tokens=new StringTokenizer(br.readLine());
			for(int j=0;j<C;j++) {
				map[i][j]=Integer.parseInt(tokens.nextToken());
				if(map[i][j]==2) {
					virus.add(new Point(i,j)); //?–‰ê³? ?—´?„ ???¥
				}else if(map[i][j]==0) {
					normal.add(new Point(i,j)); //ë§Œì•½ 0?´ë©? ? •?ƒ?— ???¥
				}
			} 
		}
		//?´? œ normal?— ???¥?œê²ƒì¤‘?—  3ê°œì˜ ?œ„ì¹˜ë?? ì¡°í•©?œ¼ë¡? ê³¨ë¼ë³´ê¸°
		makeWallCombination(3,new Point[3],0);
		
		System.out.println(MAX);
		
	}
	
	private static void makeWallCombination(int toChoose,Point[]choosed,int start) {
		if(toChoose==0) {
			//ë²? ?„¤ì¹? ?œ„ì¹? ?„ ? • ? --> ë²? ?„¸?š°ê³?, ?•ˆ? „?˜?—­ ?™•?¸?•´ë³´ì 
			check(choosed);
			return;
		}
		for(int i=start;i<normal.size();i++) {
			choosed[choosed.length-toChoose]=normal.get(i);
			makeWallCombination(toChoose-1,choosed,i+1);
		}
	}
	
	
	public static void check(Point[]visited) {
		//1.?´ê²ƒë“¤ë¡? ë²? ?„¸?š°ê¸?
		
		for(Point p:visited) {
			map[p.r][p.c]=1; //ë²? ?„¸?›Œì£¼ê¸°
		}
		
		//2.ë°”ì´?Ÿ¬?Š¤ ?¼?Š¸ë¦¬ê³  ì¹´ìš´?Š¸?•˜ê¸?
		
		int polluted=bfs();
		
		MAX=Math.max(MAX, normal.size()-polluted-3);
		
		for(Point p:visited) {
			map[p.r][p.c]=0; //ë²? ì´ˆê¸°?™”
		}	
		
	
	}
	
	public static int bfs() {
		//ê¸°ë³¸? ?œ¼ë¡? bfs?Š” queue?‚¬?š©
		Queue<Point> q=new LinkedList<>();
		boolean[][]visited=new boolean[R][C]; //ë°©ë¬¸?—¬ë¶? ?™•?¸
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
		int r,c; //?–‰ê³? ?—´?„ ???¥?• ?ˆ˜?ˆê²Œí•œ?‹¤. 
		
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
