import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class bj_1194_달이차오른다가자 {
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
		minsik start=null; //민식이 처음 위치 초기화 
		for(int r=0;r<R;r++) {
			String str=br.readLine();
			for(int c=0;c<C;c++) {
				map[r][c]=str.charAt(c);
				if(map[r][c]=='0') {
					start=new minsik(r,c,0); //0만나면 start에 넣어주기
				}
			}
		} //입력완료
		
		//bfs로 탐색
		int result = bfs(start); //start지점부터 
		System.out.println(result);
	}
	
	private static int bfs(minsik start) {
		//민식이 넣어줄 큐
		Queue<minsik> queue=new LinkedList<>();
		//방문배열 만들기
		boolean[][][]visited=new boolean[R][C][1<<6];
		
		queue.offer(start); //초기위치를 넣는다.
		visited[start.r][start.c][start.k]=true;
		int size=0,depth=0;
		while(!queue.isEmpty()) {
			size=queue.size();
			//사이즈만큼 돈다.(여러방향을 갈수있으니까) 
			while(size-->0) {
				minsik head=queue.poll();
				if(map[head.r][head.c]=='1') {
					return depth;
				}
				for(int d=0;d<deltas.length;d++) {
					int nr=head.r+deltas[d][0];
					int nc=head.c+deltas[d][1];
					
					if(isIn(nr,nc)&&!visited[nr][nc][head.k]) {
						//갈 수 없는 경우 생각하기
						//벽만나면 못감 
						if(map[nr][nc]=='#') {
							continue;
						}
						//대문 만났는데 키없으면 못감
						if(map[nr][nc]>='A'&&map[nr][nc]<='F'&&!head.isKey(map[nr][nc])) {
							continue;
						}
						
						//나머지는 다 갈 수 있다. 
						minsik go=new minsik(nr,nc,head.k);
						visited[nr][nc][head.k]=true; //만약에 a~f라고 하더라도 키가 없는 상태에서 그곳을 방문했기때문에 일단 true
						
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
	//민식이의 상태 저장
	static class minsik{
		
		int r,c,k;

		public minsik(int r, int c, int k) {
			super();
			this.r = r;
			this.c = c;
			this.k = k;
		}
		
		public boolean isKey(char key) {
			//키를 가지고 있으면 true
			 return (k&(1<<(key-'A')))>0;
		}
		public void update(char key) {
			//주운 키 업데이트하기 
			k=k|(1<<(key-'a'));
		}
		
	}

}
