import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class sw_7236_저수지물높이구하기 {
	static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer tokens;
	static StringBuilder output=new StringBuilder();
	static char[][]map;
	static int N;
	static int max,sum;
	static int[][]deltas= {{-1,-1},{-1,0},{-1,1},{0,-1},{0,1},{1,-1},{1,0},{1,1}};
	public static void main(String[] args) throws NumberFormatException, IOException {
		int T=Integer.parseInt(br.readLine());
		for(int t=1;t<=T;t++) {
			output.append("#").append(t).append(" ");
			N=Integer.parseInt(br.readLine());
			map=new char[N][N];
			for(int i=0;i<N;i++) {
				tokens=new StringTokenizer(br.readLine());
				for(int j=0;j<N;j++) {
					map[i][j]=tokens.nextToken().charAt(0);
				}
			}		
			max=0;
			for(int i=0;i<N;i++) {
				for(int j=0;j<N;j++) {
					if(map[i][j]=='W') {
						check(i,j);
						max=Math.max(max, sum);
					}
				}
			}		
			output.append(max).append("\n");
		}
		System.out.println(output);
	}
	static void check(int r,int c) {
		sum=0;
		for(int i=0;i<deltas.length;i++) {
			int nr=r+deltas[i][0];
			int nc=c+deltas[i][1];
			if(nr<0||nr>=N||nc<0||nc>=N) continue;
			if(map[nr][nc]=='W') {
				sum+=1;
			}
		}
		if(sum==0) {
			sum=1;
		}		
	}
}
