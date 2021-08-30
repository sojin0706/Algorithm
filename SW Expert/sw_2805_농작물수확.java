import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class sw_2805_농작물수확 {
	static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output=new StringBuilder();
	static int[][]map;
	static int sum;
	public static void main(String[] args) throws NumberFormatException, IOException {
	
		int T=Integer.parseInt(br.readLine());	
		for(int t=1;t<=T;t++) {
			output.append("#").append(t).append(" ");
			int N=Integer.parseInt(br.readLine());
			map=new int[N][N];
			sum=0;			
				for(int r=0;r<N;r++) {
					String str=br.readLine();
					for(int c=0;c<N;c++) {
						map[r][c]=str.charAt(c)-'0';
					}
				}
				
				for(int r=0;r<N;r++) {
					for(int c=0;c<N;c++) {
						if(Math.abs(r-N/2)+Math.abs(c-N/2)<=N/2) {
							sum+=map[r][c];
						}
					}
				}
				output.append(sum).append("\n");
			}
			System.out.println(output);
		}
		
	}


