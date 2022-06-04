package SILVER;
package ?òº?ûêÍ≥µÎ?;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj_9205_Îß•Ï£ºÎßàÏãúÎ©∞Í±∏?ñ¥Í∞?Í∏? {
	static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer tokens;
	static StringBuilder output=new StringBuilder();
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		int T=Integer.parseInt(br.readLine()); //?Öå?ä§?ä∏ Ïº??ù¥?ä§
		for(int t=1;t<=T;t++) {
			int N=Integer.parseInt(br.readLine()); //?é∏?ùò?†ê?ùò Í∞úÏàò
			int[][]dis=new int[N+2][N+2]; //Í±∞Î¶¨ ?ã¥Í∏?
			Point[] points=new Point[N+2]; //x,yÏ¢åÌëú ?ã¥Í∏?
			boolean[][]check=new boolean[N+2][N+2]; //true/false ?ã¥Í∏? 
			
			for(int i=0;i<N+2;i++) {
				tokens=new StringTokenizer(br.readLine());
				int x=Integer.parseInt(tokens.nextToken());
				int y=Integer.parseInt(tokens.nextToken());
				points[i]=new Point(x,y); //Ï¢åÌëú ???û• 
			}
			
			for(int i=0;i<N+2;i++) {
				for(int j=0;j<N+2;j++) {
					//0Î∂??Ñ∞ 1,2,3,... Í∞?Î©¥ÏÑú Í∑? Í±∞Î¶¨Í∞? 1000 ?ù¥?ïòÎ©? ?ñâÎ≥µÌïòÍ≤? Í∞àÏàò?ûà?úº?ãàÍπ? trueÏ£ºÍ∏∞ 
					//?ù¥?ü∞?ãù?úºÎ°? 0->1,2,3,4,... 1->0,1,2,3,4... 2->0,1,2,3,4... ?ï¥Ï£ºÍ∏∞ 
					dis[i][j]=Math.abs(points[i].x-points[j].x)+Math.abs(points[i].y-points[j].y);
					if(dis[i][j]<=1000) {
						check[i][j]=true; 
					}
				}
			}
			for(int k=0;k<N+2;k++) { //Í≤ΩÏú†Ïß?
				for(int i=0;i<N+2;i++) { //Ï∂úÎ∞úÏß?
					if(i==k) continue;
					for(int j=0;j<N+2;j++) {//?èÑÏ∞©Ï?
						if(i==j||j==k) continue;
						//Í≤ΩÏú†Ïß?Î•? Í±∞Ï≥êÍ∞??äîÍ≤? ?ã§ trueÎ©?
						if(check[i][k]==true&&check[k][j]==true) {
							//i->j?èÑ true?ù∏Í≤? 
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
