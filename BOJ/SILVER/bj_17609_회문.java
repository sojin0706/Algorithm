package SILVER;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class bj_17609_회문 {
	static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output=new StringBuilder();
	public static void main(String[] args) throws IOException {
		int N=Integer.parseInt(br.readLine());
//		char[]map;
		
		for(int i=0;i<N;i++) {
			
			String str=br.readLine();
//			map=new char[str.length()]; 
//			for(int j=0;j<str.length();j++) {
//				map[j]=str.charAt(j);
//			} //입력 
				int count=0; 
				int start=0; //왼쪽에서 가고 ->
				int end=str.length()-1; //오른쪽으로 간다. <-
				//투포인터
				
				//start가 end보다 커지거나 같아지면 out
				while(start<=end) {
					if(str.charAt(start)==str.charAt(end)) {
						//start랑 end가 같으면 
						start++;
						end--;
						
					}else {
						count=1; //틀렸으니까 개수를 늘려줌 
						// 만약 달라지면 일단 왼쪽을 이동시키기 
						int left=start+1;
						int right=end;
					
						while(left<=right) {
							if(str.charAt(left)==str.charAt(right)) {
								left++;
								right--;
								
							}else {
								count++; //또 달라지면 이제 out
								break;
							}
						}
						if(count==1) {
							break;
						}else if(count==2) {
							//그다음 오른쪽 이동시키기 
							left=start;
							right=end-1;
							count=1;
							while(left<=right) {
								if(str.charAt(left)==str.charAt(right)) {
									left++;
									right--;
								}else {
									count++;
									break;
								}
							}
							
						}
						break;
					}
				}
				
			output.append(count).append("\n");
			
		}
		System.out.println(output);
	
		
	}
}


