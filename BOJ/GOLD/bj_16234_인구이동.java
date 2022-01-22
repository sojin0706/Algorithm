package GOLD;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj_16234_�α��̵� {
	static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer tokens;
	static int N,L,R;
	static int[][]map;
	static boolean[][]visited;
	static int[][]deltas= {{-1,0},{1,0},{0,-1},{0,1}};
	static int moveCnt=0; //�̵��� Ƚ��
	static int countryCnt; //���󰳼� (��������ϴϱ�)
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
		}// �Է¿Ϸ�
		boolean check=true;
		//�� while���� ��� ����.
		while(true) {
			//check�� false�� �̵��Ҽ������ϱ� ������
			if(check==false) {
				break;
			}
			
			check=false;
			
			visited=new boolean[N][N];
			country=new Country[N*N]; //������ �� ������ N*N�̴�.�̵��� �� �ִ� ���� �����Ѵ�.
			
			for(int r=0;r<N;r++) {
				for(int c=0;c<N;c++) {
					if(visited[r][c]==false) {	
						countryCnt=0;
						dfs(r,c); //dfs����
						
						//���� 2���̻��̸�?
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
			} //dfs�� ���Ҵ�.
			if(check==true) {
				moveCnt++;
			}
		
		}
		 System.out.println(moveCnt);
		
	}
	private static void dfs(int r,int c) {
		
		country[countryCnt++]=new Country(r,c); //���� �־��� 
		visited[r][c]=true; //�湮üũ 
		for(int d=0;d<deltas.length;d++) {
			int nr=r+deltas[d][0];
			int nc=c+deltas[d][1];
			//�ȿ��ְ�, �湮���� �ʾ�����? 
			if(isIn(nr,nc)&&!visited[nr][nc]) {
				int temp=Math.abs(map[r][c]-map[nr][nc]);
				//�� �����ȿ� �ִٸ�?
				if(scope(temp)) {
					dfs(nr,nc);
				}
			}
			
		}
		
	}
	
	//�� ���� �ȿ� �־���Ѵ�.
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
