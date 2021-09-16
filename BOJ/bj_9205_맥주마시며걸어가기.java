package 혼자공부;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj_9205_맥주마시며걸어가기 {
	static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer tokens;
	static StringBuilder output=new StringBuilder();
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		int T=Integer.parseInt(br.readLine()); //테스트 케이스
		for(int t=1;t<=T;t++) {
			int N=Integer.parseInt(br.readLine()); //편의점의 개수
			int[][]dis=new int[N+2][N+2]; //거리 담기
			Point[] points=new Point[N+2]; //x,y좌표 담기
			boolean[][]check=new boolean[N+2][N+2]; //true/false 담기 
			
			for(int i=0;i<N+2;i++) {
				tokens=new StringTokenizer(br.readLine());
				int x=Integer.parseInt(tokens.nextToken());
				int y=Integer.parseInt(tokens.nextToken());
				points[i]=new Point(x,y); //좌표 저장 
			}
			
			for(int i=0;i<N+2;i++) {
				for(int j=0;j<N+2;j++) {
					//0부터 1,2,3,... 가면서 그 거리가 1000 이하면 행복하게 갈수있으니까 true주기 
					//이런식으로 0->1,2,3,4,... 1->0,1,2,3,4... 2->0,1,2,3,4... 해주기 
					dis[i][j]=Math.abs(points[i].x-points[j].x)+Math.abs(points[i].y-points[j].y);
					if(dis[i][j]<=1000) {
						check[i][j]=true; 
					}
				}
			}
			for(int k=0;k<N+2;k++) { //경유지
				for(int i=0;i<N+2;i++) { //출발지
					if(i==k) continue;
					for(int j=0;j<N+2;j++) {//도착지
						if(i==j||j==k) continue;
						//경유지를 거쳐가는게 다 true면
						if(check[i][k]==true&&check[k][j]==true) {
							//i->j도 true인것 
							check[i][j]=true;
						}
					}
				}
			}
			
			if(check[0][N+1]==true) output.append("happy").append("\n");
			else output.append("sad").append("\n");
			
		}
		System.out.println(output);

	}
	
	public static class Point{
		int x,y;

		public Point(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
		
	}

}
