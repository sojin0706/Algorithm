package GOLD;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class bj_1600_ë§ì´?˜ê³ í”ˆ?›?ˆ­?´ {
	//bfsë¬¸ì œ
	//ì¤‘ìš”?•œ ?¬?¸?Š¸ =>ë§ë¡œ ë°©ë¬¸?•œê±°ë‘ ?›?ˆ­?´ë¡? ë°©ë¬¸?•œê²ƒì? ?‹¤ë¥¸ë¬¸? œ.(?”°ë¡? ì²´í¬?•´ì¤˜ì•¼?•œ?‹¤)
	static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer tokens;
	static StringBuilder output=new StringBuilder();
	static int K,R,C;
	static int[][]map;
	//?›?ˆ­?´?¼?•Œ?˜ ?‚¬ë°©íƒ?ƒ‰
	static int[][]deltasM= {{-1,0},{1,0},{0,-1},{0,1}};
	//ë§ì¼?•Œ?˜ ?Œ”ë°©íƒ?ƒ‰
	static int[][]deltasH= {{-1,-2},{1,-2},{-2,-1},{2,-1},{-2,1},{2,1},{-1,2},{1,2}};
	public static void main(String[] args) throws NumberFormatException, IOException {
		K=Integer.parseInt(br.readLine()); //ë§? ?´?™ ?šŸ?ˆ˜ 
		tokens=new StringTokenizer(br.readLine());
		C=Integer.parseInt(tokens.nextToken());
		R=Integer.parseInt(tokens.nextToken());
		map=new int[R][C];
		for(int r=0;r<R;r++) {
			tokens=new StringTokenizer(br.readLine());
			for(int c=0;c<C;c++) {
				map[r][c]=Integer.parseInt(tokens.nextToken());
			}
		}//?…? ¥?™„ë£?
		System.out.println(bfs());
	}
	private static int bfs() {
		Queue<Monkey>q=new LinkedList<>();
		boolean[][][]visited=new boolean[R][C][K+1]; //0,1,2,..,Kê¹Œì? ?‚˜???‚¼?ˆ˜?ˆ?‹¤.
		q.offer(new Monkey(0,0,0)); //ì²˜ìŒ ?‹œ?‘ ?›?ˆ­?´ ?œ„ì¹˜ë?? ?‹´?•„ì¤??‹¤.
		visited[0][0][0]=true;
		
		int depth=0,size=0; 
		while(!q.isEmpty()) {
			size=q.size();
			while(size-->0) {
				Monkey head=q.poll();
				if(head.r==R-1&&head.c==C-1) {
					return depth;
				}
				//?›?ˆ­?´ë¡? ?ƒ?ƒ‰?•˜ê±°ë‚˜ ë§ë¡œ ?ƒ?ƒ‰?•  ?ˆ˜ ?ˆ?‹¤.
				//ë§ë¡œ ?ƒ?ƒ‰?•˜? ¤ë©? kê°? 0ë³´ë‹¤ ì»¤ì•¼?•¨(?‚¨?•„?ˆ?Š”ê²? ?ˆ?–´?•¼?•¨)
				//ë§ì¼?•Œ
				if(head.k<K) {
					visit(visited,deltasH,false,head,q);
				}
				
				//?›?ˆ­?´?¼?•Œ
				visit(visited,deltasM,true,head,q);
				
			}
			depth++;
		}
		
		
		return -1; //ë°©ë¬¸x?¼?•Œ?˜ ê¸°ë³¸ê°?
	}
	private static void visit(boolean[][][]visited,int[][]deltas,boolean isMonkey,Monkey head,Queue<Monkey>q) {
		
		for(int d=0;d<deltas.length;d++) {
			int nr=head.r+deltas[d][0];
			int nc=head.c+deltas[d][1];
			//?´?•Œ visitedê²??‚¬ë¥? ?•˜?Š”ê²? ?•„?‹ˆ?‹¤ (?›?ˆ­?´?ƒ ?•„?‹ˆ?ƒ?— ?”°?¼?„œ 3ë²ˆì§¸[]ê°’ì´ ?‹¬?¼ì§?ê¸? ?•Œë¬¸ì´?‹¤)
			if(isIn(nr,nc)&&map[nr][nc]==0) {
				int result=isMonkey?head.k:head.k+1; //?›?ˆ­?´ë©? ê·¸ë?ë¡?, ë§ì´ë©? +1?•´ì£¼ê¸°
				if(!visited[nr][nc][result]) {
					q.offer(new Monkey(nr,nc,result));
					visited[nr][nc][result]=true;
				}
				
			}
		}
		
	}
	private static boolean isIn(int r,int c) {
		return r>=0&&c>=0&&r<R&&c<C;
	}
	//ëª½í‚¤?˜ ì¢Œí‘œë¥? ì°ì–´ì¤?
	private static class Monkey{
		int r,c,k; //ë§ë¡œ ëª‡ë²ˆ ê°”ëŠ”ì§??„ ì²´í¬?•´ì¤˜ì•¼?•¨

		public Monkey(int r, int c, int k) {
			super();
			this.r = r;
			this.c = c;
			this.k = k;
		}
		
	}

}
