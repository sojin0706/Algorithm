import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class bj_1600_말이되고픈원숭이 {
	//bfs문제
	//중요한 포인트 =>말로 방문한거랑 원숭이로 방문한것은 다른문제.(따로 체크해줘야한다)
	static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer tokens;
	static StringBuilder output=new StringBuilder();
	static int K,R,C;
	static int[][]map;
	//원숭이일때의 사방탐색
	static int[][]deltasM= {{-1,0},{1,0},{0,-1},{0,1}};
	//말일때의 팔방탐색
	static int[][]deltasH= {{-1,-2},{1,-2},{-2,-1},{2,-1},{-2,1},{2,1},{-1,2},{1,2}};
	public static void main(String[] args) throws NumberFormatException, IOException {
		K=Integer.parseInt(br.readLine()); //말 이동 횟수 
		tokens=new StringTokenizer(br.readLine());
		C=Integer.parseInt(tokens.nextToken());
		R=Integer.parseInt(tokens.nextToken());
		map=new int[R][C];
		for(int r=0;r<R;r++) {
			tokens=new StringTokenizer(br.readLine());
			for(int c=0;c<C;c++) {
				map[r][c]=Integer.parseInt(tokens.nextToken());
			}
		}//입력완료
		System.out.println(bfs());
	}
	private static int bfs() {
		Queue<Monkey>q=new LinkedList<>();
		boolean[][][]visited=new boolean[R][C][K+1]; //0,1,2,..,K까지 나타낼수있다.
		q.offer(new Monkey(0,0,0)); //처음 시작 원숭이 위치를 담아준다.
		visited[0][0][0]=true;
		
		int depth=0,size=0; 
		while(!q.isEmpty()) {
			size=q.size();
			while(size-->0) {
				Monkey head=q.poll();
				if(head.r==R-1&&head.c==C-1) {
					return depth;
				}
				//원숭이로 탐색하거나 말로 탐색할 수 있다.
				//말로 탐색하려면 k가 0보다 커야함(남아있는게 있어야함)
				//말일때
				if(head.k<K) {
					visit(visited,deltasH,false,head,q);
				}
				
				//원숭이일때
				visit(visited,deltasM,true,head,q);
				
			}
			depth++;
		}
		
		
		return -1; //방문x일때의 기본값
	}
	private static void visit(boolean[][][]visited,int[][]deltas,boolean isMonkey,Monkey head,Queue<Monkey>q) {
		
		for(int d=0;d<deltas.length;d++) {
			int nr=head.r+deltas[d][0];
			int nc=head.c+deltas[d][1];
			//이때 visited검사를 하는게 아니다 (원숭이냐 아니냐에 따라서 3번째[]값이 달라지기 때문이다)
			if(isIn(nr,nc)&&map[nr][nc]==0) {
				int result=isMonkey?head.k:head.k+1; //원숭이면 그대로, 말이면 +1해주기
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
	//몽키의 좌표를 찍어줌
	private static class Monkey{
		int r,c,k; //말로 몇번 갔는지도 체크해줘야함

		public Monkey(int r, int c, int k) {
			super();
			this.r = r;
			this.c = c;
			this.k = k;
		}
		
	}

}
