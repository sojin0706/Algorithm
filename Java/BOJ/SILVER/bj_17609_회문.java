package SILVER;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class bj_17609_ȸ�� {
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
//			} //�Է� 
				int count=0; 
				int start=0; //���ʿ��� ���� ->
				int end=str.length()-1; //���������� ����. <-
				//��������
				
				//start�� end���� Ŀ���ų� �������� out
				while(start<=end) {
					if(str.charAt(start)==str.charAt(end)) {
						//start�� end�� ������ 
						start++;
						end--;
						
					}else {
						count=1; //Ʋ�����ϱ� ������ �÷��� 
						// ���� �޶����� �ϴ� ������ �̵���Ű�� 
						int left=start+1;
						int right=end;
					
						while(left<=right) {
							if(str.charAt(left)==str.charAt(right)) {
								left++;
								right--;
								
							}else {
								count++; //�� �޶����� ���� out
								break;
							}
						}
						if(count==1) {
							break;
						}else if(count==2) {
							//�״��� ������ �̵���Ű�� 
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


