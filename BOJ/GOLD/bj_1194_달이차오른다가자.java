package GOLD;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class bj_1194_?��?��차오른다�??�� {
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
		minsik start=null; //민식?�� 처음 ?���? 초기?�� 
		for(int r=0;r<R;r++) {
			String str=br.readLine();
			for(int c=0;c<C;c++) {
				map[r][c]=str.charAt(c);
				if(map[r][c]=='0') {
					start=new minsik(r,c,0); //0만나�? start?�� ?��?��주기
				}
			}
		} //?��?��?���?
		
		//bfs�? ?��?��
		int result = bfs(start); //start�??���??�� 
		System.out.println(result);
	}
	
	private static int bfs(minsik start) {
		//민식?�� ?��?���? ?��
		Queue<minsik> queue=new LinkedList<>();
		//방문배열 만들�?
		boolean[][][]visited=new boolean[R][C][1<<6];
		
		queue.offer(start); //초기?��치�?? ?��?��?��.
		visited[start.r][start.c][start.k]=true;
		int size=0,depth=0;
		while(!queue.isEmpty()) {
			size=queue.size();
			//?��?��즈만?�� ?��?��.(?��?��방향?�� 갈수?��?��?���?) 
			while(size-->0) {
				minsik head=queue.poll();
				if(map[head.r][head.c]=='1') {
					return depth;
				}
				for(int d=0;d<deltas.length;d++) {
					int nr=head.r+deltas[d][0];
					int nc=head.c+deltas[d][1];
					
					if(isIn(nr,nc)&&!visited[nr][nc][head.k]) {
						//�? ?�� ?��?�� 경우 ?��각하�?
						//벽만?���? 못감 
						if(map[nr][nc]=='#') {
							continue;
						}
						//??�? 만났?��?�� ?��?��?���? 못감
						if(map[nr][nc]>='A'&&map[nr][nc]<='F'&&!head.isKey(map[nr][nc])) {
							continue;
						}
						
						//?��머�??�� ?�� �? ?�� ?��?��. 
						minsik go=new minsik(nr,nc,head.k);
						visited[nr][nc][head.k]=true; //만약?�� a~f?���? ?��?��?��?�� ?���? ?��?�� ?��?��?��?�� 그곳?�� 방문?��기때문에 ?��?�� true
						
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
	//민식?��?�� ?��?�� ???��
	static class minsik{
		
		int r,c,k;

		public minsik(int r, int c, int k) {
			super();
			this.r = r;
			this.c = c;
			this.k = k;
		}
		
		public boolean isKey(char key) {
			//?���? �?�?�? ?��?���? true
			 return (k&(1<<(key-'A')))>0;
		}
		public void update(char key) {
			//주운 ?�� ?��?��?��?��?���? 
			k=k|(1<<(key-'a'));
		}
		
	}

}
