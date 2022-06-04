package GOLD;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class bj_1194_?‹¬?´ì°¨ì˜¤ë¥¸ë‹¤ê°?? {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;
	static int R,C;
	static char[][]map;
	static int[][]deltas= {{-1,0},{1,0},{0,-1},{0,1}};
	public static void main(String[] args) throws IOException {
		tokens=new StringTokenizer(br.readLine());
		
		R=Integer.parseInt(tokens.nextToken());
		C=Integer.parseInt(tokens.nextToken());
		map=new char[R][C];
		minsik start=null; //ë¯¼ì‹?´ ì²˜ìŒ ?œ„ì¹? ì´ˆê¸°?™” 
		for(int r=0;r<R;r++) {
			String str=br.readLine();
			for(int c=0;c<C;c++) {
				map[r][c]=str.charAt(c);
				if(map[r][c]=='0') {
					start=new minsik(r,c,0); //0ë§Œë‚˜ë©? start?— ?„£?–´ì£¼ê¸°
				}
			}
		} //?…? ¥?™„ë£?
		
		//bfsë¡? ?ƒ?ƒ‰
		int result = bfs(start); //startì§?? ë¶??„° 
		System.out.println(result);
	}
	
	private static int bfs(minsik start) {
		//ë¯¼ì‹?´ ?„£?–´ì¤? ?
		Queue<minsik> queue=new LinkedList<>();
		//ë°©ë¬¸ë°°ì—´ ë§Œë“¤ê¸?
		boolean[][][]visited=new boolean[R][C][1<<6];
		
		queue.offer(start); //ì´ˆê¸°?œ„ì¹˜ë?? ?„£?Š”?‹¤.
		visited[start.r][start.c][start.k]=true;
		int size=0,depth=0;
		while(!queue.isEmpty()) {
			size=queue.size();
			//?‚¬?´ì¦ˆë§Œ?¼ ?ˆ?‹¤.(?—¬?Ÿ¬ë°©í–¥?„ ê°ˆìˆ˜?ˆ?œ¼?‹ˆê¹?) 
			while(size-->0) {
				minsik head=queue.poll();
				if(map[head.r][head.c]=='1') {
					return depth;
				}
				for(int d=0;d<deltas.length;d++) {
					int nr=head.r+deltas[d][0];
					int nc=head.c+deltas[d][1];
					
					if(isIn(nr,nc)&&!visited[nr][nc][head.k]) {
						//ê°? ?ˆ˜ ?—†?Š” ê²½ìš° ?ƒê°í•˜ê¸?
						//ë²½ë§Œ?‚˜ë©? ëª»ê° 
						if(map[nr][nc]=='#') {
							continue;
						}
						//??ë¬? ë§Œë‚¬?Š”?° ?‚¤?—†?œ¼ë©? ëª»ê°
						if(map[nr][nc]>='A'&&map[nr][nc]<='F'&&!head.isKey(map[nr][nc])) {
							continue;
						}
						
						//?‚˜ë¨¸ì??Š” ?‹¤ ê°? ?ˆ˜ ?ˆ?‹¤. 
						minsik go=new minsik(nr,nc,head.k);
						visited[nr][nc][head.k]=true; //ë§Œì•½?— a~f?¼ê³? ?•˜?”?¼?„ ?‚¤ê°? ?—†?Š” ?ƒ?ƒœ?—?„œ ê·¸ê³³?„ ë°©ë¬¸?–ˆê¸°ë•Œë¬¸ì— ?¼?‹¨ true
						
						if(map[nr][nc]>='a'&&map[nr][nc]<='f') {
							go.update(map[nr][nc]);
						}
						queue.offer(go);
						
					}
					
				}
				
				
			}
			depth++;
		}
		
		
		return -1;
	}
	static boolean isIn(int r,int c) {
		return r>=0&&c>=0&&r<R&&c<C;
	}
	//ë¯¼ì‹?´?˜ ?ƒ?ƒœ ???¥
	static class minsik{
		
		int r,c,k;

		public minsik(int r, int c, int k) {
			super();
			this.r = r;
			this.c = c;
			this.k = k;
		}
		
		public boolean isKey(char key) {
			//?‚¤ë¥? ê°?ì§?ê³? ?ˆ?œ¼ë©? true
			 return (k&(1<<(key-'A')))>0;
		}
		public void update(char key) {
			//ì£¼ìš´ ?‚¤ ?—…?°?´?Š¸?•˜ê¸? 
			k=k|(1<<(key-'a'));
		}
		
	}

}
