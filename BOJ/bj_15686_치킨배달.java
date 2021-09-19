package 혼자풀기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class bj_15686_치킨배달 {
	static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer tokens;
	static StringBuilder output=new StringBuilder();
	static int N,M;
	static int[][]map;
	static List<Point> chicken;
	static List<Point> home;
	static int totalDistance=Integer.MAX_VALUE;
	static int[][]deltas= {{-1,0},{1,0},{0,-1},{0,1}};
	public static void main(String[] args) throws IOException {
		tokens=new StringTokenizer(br.readLine());
		N=Integer.parseInt(tokens.nextToken());
		M=Integer.parseInt(tokens.nextToken());
		map=new int[N][N];
		chicken=new ArrayList<>();
		home=new ArrayList<>();
		for(int i=0;i<N;i++) {
			tokens=new StringTokenizer(br.readLine());
			for(int j=0;j<N;j++) {
				map[i][j]=Integer.parseInt(tokens.nextToken());
			}
		}
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				if(map[i][j]==1) {
					home.add(new Point(i,j));
				}else if(map[i][j]==2) {
					chicken.add(new Point(i,j));
				}
			}
		}
		
		combination(M,new Point[M],0);
		System.out.println(totalDistance);
		
	}
	
	static void combination(int cnt,Point[]choose,int start) {
		if(cnt==0) {
			//0이면 다 뽑은거니까 check
			check(choose);
			return;
		}
		for(int i=start;i<chicken.size();i++) {
			choose[choose.length-cnt]=chicken.get(i);
			combination(cnt-1,choose,i+1);
		}
	}
	static void check(Point[]choose) {
		int distance=0;
		//집 정보 => 하나하나 최소면 전체에서 최소니까 치킨집을 돌려보면서 최소인거 찾기
		for(Point homes:home) {
			int MIN=Integer.MAX_VALUE;
			for(Point chicken:choose) {
				int dist=homes.getDist(chicken);
				MIN=Math.min(dist, MIN);
			}
			distance+=MIN;
		}
		totalDistance=Math.min(totalDistance, distance);
	}
	static boolean isIn(int r,int c) {
		return r>=0&&r<N&&c>=0&&c<N;
	}

	static class Point{
		int r,c;

		public Point(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}
		public int getDist(Point other) {
			return Math.abs(this.r-other.r)+Math.abs(this.c-other.c);
		}
		
	}

}
