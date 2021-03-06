package GOLD;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class bj_1194_?¬?΄μ°¨μ€λ₯Έλ€κ°?? {
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
		minsik start=null; //λ―Όμ?΄ μ²μ ?μΉ? μ΄κΈ°? 
		for(int r=0;r<R;r++) {
			String str=br.readLine();
			for(int c=0;c<C;c++) {
				map[r][c]=str.charAt(c);
				if(map[r][c]=='0') {
					start=new minsik(r,c,0); //0λ§λλ©? start? ?£?΄μ£ΌκΈ°
				}
			}
		} //?? ₯?λ£?
		
		//bfsλ‘? ??
		int result = bfs(start); //startμ§?? λΆ??° 
		System.out.println(result);
	}
	
	private static int bfs(minsik start) {
		//λ―Όμ?΄ ?£?΄μ€? ?
		Queue<minsik> queue=new LinkedList<>();
		//λ°©λ¬Έλ°°μ΄ λ§λ€κΈ?
		boolean[][][]visited=new boolean[R][C][1<<6];
		
		queue.offer(start); //μ΄κΈ°?μΉλ?? ?£??€.
		visited[start.r][start.c][start.k]=true;
		int size=0,depth=0;
		while(!queue.isEmpty()) {
			size=queue.size();
			//?¬?΄μ¦λ§?Ό ??€.(?¬?¬λ°©ν₯? κ°μ??Ό?κΉ?) 
			while(size-->0) {
				minsik head=queue.poll();
				if(map[head.r][head.c]=='1') {
					return depth;
				}
				for(int d=0;d<deltas.length;d++) {
					int nr=head.r+deltas[d][0];
					int nc=head.c+deltas[d][1];
					
					if(isIn(nr,nc)&&!visited[nr][nc][head.k]) {
						//κ°? ? ?? κ²½μ° ?κ°νκΈ?
						//λ²½λ§?λ©? λͺ»κ° 
						if(map[nr][nc]=='#') {
							continue;
						}
						//??λ¬? λ§λ¬??° ?€??Όλ©? λͺ»κ°
						if(map[nr][nc]>='A'&&map[nr][nc]<='F'&&!head.isKey(map[nr][nc])) {
							continue;
						}
						
						//?λ¨Έμ?? ?€ κ°? ? ??€. 
						minsik go=new minsik(nr,nc,head.k);
						visited[nr][nc][head.k]=true; //λ§μ½? a~f?Όκ³? ???Ό? ?€κ°? ?? ???? κ·Έκ³³? λ°©λ¬Έ?κΈ°λλ¬Έμ ?Ό?¨ true
						
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
	//λ―Όμ?΄? ?? ???₯
	static class minsik{
		
		int r,c,k;

		public minsik(int r, int c, int k) {
			super();
			this.r = r;
			this.c = c;
			this.k = k;
		}
		
		public boolean isKey(char key) {
			//?€λ₯? κ°?μ§?κ³? ??Όλ©? true
			 return (k&(1<<(key-'A')))>0;
		}
		public void update(char key) {
			//μ£Όμ΄ ?€ ??°?΄?Έ?κΈ? 
			k=k|(1<<(key-'a'));
		}
		
	}

}
