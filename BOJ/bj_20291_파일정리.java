

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class bj_20291_�������� {
	static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output=new StringBuilder();
	static int N;
	static Map<String,Integer> map=new HashMap<>();
	static String word1="";
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		N=Integer.parseInt(br.readLine());
		for(int i=0;i<N;i++) {
			String word=br.readLine();
			for(int j=0;j<word.length();j++) {
				if(word.charAt(j)=='.') {
					word1=word.substring(j+1,word.length()); //�ڿ� ���ϸ� ���� ����
					if(map.get(word1)==null) {
						map.put(word1, 1);
					}else {
						map.put(word1, map.get(word1)+1);
					}
				}
			}//�Է¿Ϸ�
	}
		ArrayList<String>list=new ArrayList<>();
		//key�� ���� ���ͼ� �����Ѵ�. 
		for (String key : map.keySet()) {
			list.add(key);
		}   
		Collections.sort(list); //�� ������� ������ 
		for(int t=0;t<list.size();t++) {
			System.out.println(list.get(t)+" "+map.get(list.get(t)));
		}
		
		
		
	}

}
