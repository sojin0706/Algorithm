package GOLD;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class bj_1600_λ§μ΄?κ³ ν??­?΄ {
	//bfsλ¬Έμ 
	//μ€μ? ?¬?Έ?Έ =>λ§λ‘ λ°©λ¬Έ?κ±°λ ??­?΄λ‘? λ°©λ¬Έ?κ²μ? ?€λ₯Έλ¬Έ? .(?°λ‘? μ²΄ν¬?΄μ€μΌ??€)
	static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer tokens;
	static StringBuilder output=new StringBuilder();
	static int K,R,C;
	static int[][]map;
	//??­?΄?Ό?? ?¬λ°©ν?
	static int[][]deltasM= {{-1,0},{1,0},{0,-1},{0,1}};
	//λ§μΌ?? ?λ°©ν?
	static int[][]deltasH= {{-1,-2},{1,-2},{-2,-1},{2,-1},{-2,1},{2,1},{-1,2},{1,2}};
	public static void main(String[] args) throws NumberFormatException, IOException {
		K=Integer.parseInt(br.readLine()); //λ§? ?΄? ?? 
		tokens=new StringTokenizer(br.readLine());
		C=Integer.parseInt(tokens.nextToken());
		R=Integer.parseInt(tokens.nextToken());
		map=new int[R][C];
		for(int r=0;r<R;r++) {
			tokens=new StringTokenizer(br.readLine());
			for(int c=0;c<C;c++) {
				map[r][c]=Integer.parseInt(tokens.nextToken());
			}
		}//?? ₯?λ£?
		System.out.println(bfs());
	}
	private static int bfs() {
		Queue<Monkey>q=new LinkedList<>();
		boolean[][][]visited=new boolean[R][C][K+1]; //0,1,2,..,KκΉμ? ????Ό???€.
		q.offer(new Monkey(0,0,0)); //μ²μ ?? ??­?΄ ?μΉλ?? ?΄?μ€??€.
		visited[0][0][0]=true;
		
		int depth=0,size=0; 
		while(!q.isEmpty()) {
			size=q.size();
			while(size-->0) {
				Monkey head=q.poll();
				if(head.r==R-1&&head.c==C-1) {
					return depth;
				}
				//??­?΄λ‘? ???κ±°λ λ§λ‘ ???  ? ??€.
				//λ§λ‘ ???? €λ©? kκ°? 0λ³΄λ€ μ»€μΌ?¨(?¨???κ²? ??΄?Ό?¨)
				//λ§μΌ?
				if(head.k<K) {
					visit(visited,deltasH,false,head,q);
				}
				
				//??­?΄?Ό?
				visit(visited,deltasM,true,head,q);
				
			}
			depth++;
		}
		
		
		return -1; //λ°©λ¬Έx?Ό?? κΈ°λ³Έκ°?
	}
	private static void visit(boolean[][][]visited,int[][]deltas,boolean isMonkey,Monkey head,Queue<Monkey>q) {
		
		for(int d=0;d<deltas.length;d++) {
			int nr=head.r+deltas[d][0];
			int nc=head.c+deltas[d][1];
			//?΄? visitedκ²??¬λ₯? ??κ²? ???€ (??­?΄? ???? ?°?Ό? 3λ²μ§Έ[]κ°μ΄ ?¬?Όμ§?κΈ? ?λ¬Έμ΄?€)
			if(isIn(nr,nc)&&map[nr][nc]==0) {
				int result=isMonkey?head.k:head.k+1; //??­?΄λ©? κ·Έλ?λ‘?, λ§μ΄λ©? +1?΄μ£ΌκΈ°
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
	//λͺ½ν€? μ’νλ₯? μ°μ΄μ€?
	private static class Monkey{
		int r,c,k; //λ§λ‘ λͺλ² κ°λμ§?? μ²΄ν¬?΄μ€μΌ?¨

		public Monkey(int r, int c, int k) {
			super();
			this.r = r;
			this.c = c;
			this.k = k;
		}
		
	}

}
