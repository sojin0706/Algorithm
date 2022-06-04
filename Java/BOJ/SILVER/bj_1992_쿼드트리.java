package SILVER;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj_1992_쿼드?���? {
	static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output=new StringBuilder();
	static int N;
	static char[][] map;
	static StringTokenizer tokens;
	public static void main(String[] args) throws NumberFormatException, IOException {
		N=Integer.parseInt(br.readLine());
		
		map=new char[N][];
		for(int r=0;r<N;r++) {
			map[r]=br.readLine().toCharArray();
		}
		dnc(0,0,N);
		System.out.println(output);
	}
	private static void dnc(int r,int c,int l) {
		//모든 ?��?��?�� 같니?
		boolean same=isSame(r,c,l); //?��?��?��?�� 같�?�? ?��?�� 
		// 기�?조건 --> ?��출하�? 만들?�� 주는�?
		//?��?��?�� 모두 같다�? ?��~~
		if(same==true) {
			output.append(map[r][c]);
			return;
		}
		//?��?�� -->괄호�? 묶어�??��.. -->?��?��?�� 4분할?��?�� 쪼개?�� ?��?��간다. 
		output.append("(");
		int half=l/2;
		dnc(r,c,half);
		dnc(r,c+half,half);
		dnc(r+half,c,half);
		dnc(r+half,c+half,half);
		output.append(")");
	}
	private static boolean isSame(int r,int c,int l) {
		for(int r2=r;r2<r+l;r2++) {
			for(int c2=c;c2<c+l;c2++) {
				if(map[r][c]!=map[r2][c2]) {
					return false;
				}
			}
		}
		return true;
	}

}
