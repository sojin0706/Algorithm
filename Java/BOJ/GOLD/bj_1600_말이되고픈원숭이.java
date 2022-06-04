package GOLD;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class bj_1600_말이?��고픈?��?��?�� {
	//bfs문제
	//중요?�� ?��?��?�� =>말로 방문?��거랑 ?��?��?���? 방문?��것�? ?��른문?��.(?���? 체크?��줘야?��?��)
	static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer tokens;
	static StringBuilder output=new StringBuilder();
	static int K,R,C;
	static int[][]map;
	//?��?��?��?��?��?�� ?��방탐?��
	static int[][]deltasM= {{-1,0},{1,0},{0,-1},{0,1}};
	//말일?��?�� ?��방탐?��
	static int[][]deltasH= {{-1,-2},{1,-2},{-2,-1},{2,-1},{-2,1},{2,1},{-1,2},{1,2}};
	public static void main(String[] args) throws NumberFormatException, IOException {
		K=Integer.parseInt(br.readLine()); //�? ?��?�� ?��?�� 
		tokens=new StringTokenizer(br.readLine());
		C=Integer.parseInt(tokens.nextToken());
		R=Integer.parseInt(tokens.nextToken());
		map=new int[R][C];
		for(int r=0;r<R;r++) {
			tokens=new StringTokenizer(br.readLine());
			for(int c=0;c<C;c++) {
				map[r][c]=Integer.parseInt(tokens.nextToken());
			}
		}//?��?��?���?
		System.out.println(bfs());
	}
	private static int bfs() {
		Queue<Monkey>q=new LinkedList<>();
		boolean[][][]visited=new boolean[R][C][K+1]; //0,1,2,..,K까�? ?��???��?��?��?��.
		q.offer(new Monkey(0,0,0)); //처음 ?��?�� ?��?��?�� ?��치�?? ?��?���??��.
		visited[0][0][0]=true;
		
		int depth=0,size=0; 
		while(!q.isEmpty()) {
			size=q.size();
			while(size-->0) {
				Monkey head=q.poll();
				if(head.r==R-1&&head.c==C-1) {
					return depth;
				}
				//?��?��?���? ?��?��?��거나 말로 ?��?��?�� ?�� ?��?��.
				//말로 ?��?��?��?���? k�? 0보다 커야?��(?��?��?��?���? ?��?��?��?��)
				//말일?��
				if(head.k<K) {
					visit(visited,deltasH,false,head,q);
				}
				
				//?��?��?��?��?��
				visit(visited,deltasM,true,head,q);
				
			}
			depth++;
		}
		
		
		return -1; //방문x?��?��?�� 기본�?
	}
	private static void visit(boolean[][][]visited,int[][]deltas,boolean isMonkey,Monkey head,Queue<Monkey>q) {
		
		for(int d=0;d<deltas.length;d++) {
			int nr=head.r+deltas[d][0];
			int nc=head.c+deltas[d][1];
			//?��?�� visited�??���? ?��?���? ?��?��?�� (?��?��?��?�� ?��?��?��?�� ?��?��?�� 3번째[]값이 ?��?���?�? ?��문이?��)
			if(isIn(nr,nc)&&map[nr][nc]==0) {
				int result=isMonkey?head.k:head.k+1; //?��?��?���? 그�?�?, 말이�? +1?��주기
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
	//몽키?�� 좌표�? 찍어�?
	private static class Monkey{
		int r,c,k; //말로 몇번 갔는�??�� 체크?��줘야?��

		public Monkey(int r, int c, int k) {
			super();
			this.r = r;
			this.c = c;
			this.k = k;
		}
		
	}

}
