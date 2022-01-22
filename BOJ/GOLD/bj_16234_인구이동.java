package GOLD;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj_16234_인구이동 {
	static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer tokens;
	static int N,L,R;
	static int[][]map;
	static boolean[][]visited;
	static int[][]deltas= {{-1,0},{1,0},{0,-1},{0,1}};
	static int moveCnt=0; //이동한 횟수
	static int countryCnt; //나라개수 (나눠줘야하니까)
	static Country[] country;
	static int cnt=0;
	public static void main(String[] args) throws IOException {
		tokens=new StringTokenizer(br.readLine());
		N=Integer.parseInt(tokens.nextToken());
		L=Integer.parseInt(tokens.nextToken());
		R=Integer.parseInt(tokens.nextToken());
		map=new int[N][N];
		
		for(int r=0;r<N;r++) {
			tokens=new StringTokenizer(br.readLine());
			for(int c=0;c<N;c++) {
				map[r][c]=Integer.parseInt(tokens.nextToken());
			}
		}// 입력완료
		boolean check=true;
		//이 while문을 계속 돈다.
		while(true) {
			//check가 false면 이동할수없으니까 나가라
			if(check==false) {
				break;
			}
			
			check=false;
			
			visited=new boolean[N][N];
			country=new Country[N*N]; //나라의 총 개수는 N*N이다.이동할 수 있는 나라를 저장한다.
			
			for(int r=0;r<N;r++) {
				for(int c=0;c<N;c++) {
					if(visited[r][c]==false) {	
						countryCnt=0;
						dfs(r,c); //dfs돌고
						
						//나라가 2개이상이면?
						if(countryCnt>=2) {
							int sum=0;
							for(int i=0;i<countryCnt;i++) {
								sum+=map[country[i].r][country[i].c];
							}
							int total=sum/countryCnt;
							for(int i=0;i<countryCnt;i++) {
								map[country[i].r][country[i].c]=total;
							}
							check=true;
						}
					}
					
				}
			} //dfs다 돌았다.
			if(check==true) {
				moveCnt++;
			}
		
		}
		 System.out.println(moveCnt);
		
	}
	private static void dfs(int r,int c) {
		
		country[countryCnt++]=new Country(r,c); //나라 넣어줌 
		visited[r][c]=true; //방문체크 
		for(int d=0;d<deltas.length;d++) {
			int nr=r+deltas[d][0];
			int nc=c+deltas[d][1];
			//안에있고, 방문하지 않았으면? 
			if(isIn(nr,nc)&&!visited[nr][nc]) {
				int temp=Math.abs(map[r][c]-map[nr][nc]);
				//그 범위안에 있다면?
				if(scope(temp)) {
					dfs(nr,nc);
				}
			}
			
		}
		
	}
	
	//이 범위 안에 있어야한다.
	private static boolean scope(int a) {
		return a>=L&&a<=R;
	}
	
	private static boolean isIn(int r,int c) {
		return r>=0&&c>=0&&r<N&&c<N;
	}
	
	private static class Country{
		int r,c;
		public Country(int r,int c) {
			this.r=r;
			this.c=c;
		}
	}

}
