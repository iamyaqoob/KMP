class KMP{
	
	public static void KMP(String pat, String text){
		int m = pat.length();
		int n = text.length();
		char PATTERN[] = pat.toCharArray();
		char TEXT[] = text.toCharArray();
		
		int LPS[] = getLPS(PATTERN,m);    //LPS: longest prefix suffix 
		
		int i=0;
		int j=0;
		
		while(i<n){
			if(PATTERN[j] == TEXT[i]){
				i++;
				j++;
			}
			if(j == m){
				System.out.println("Yeah, Match at "+(i-j+1));
				j = LPS[j-1];
			}
			else if(PATTERN[j] != TEXT[i]   && i<n){
				if(j!=0){
					j = LPS[j-1];
				}
				else{
					i++;
				}
			}
		}
		
	}
	public static int[] getLPS(char[] PATTERN, int patLength){
		int j=0;
		int LPS[] = new int[patLength];   //LPS: longest prefix suffix 
		LPS[0] = 0;
		
		for(int i=1;i<patLength; ){
			if(PATTERN[i]==PATTERN[j]){
				LPS[i] = j+1;
				j++;
				i++;
			}
			else if(PATTERN[i] != PATTERN[j] && j==0){
				LPS[i] = 0;
				i++;
			}
			else{
				j = LPS[j-1];
			}
		}
		return LPS;
	}
	public static void main(String lol[]){
		String t = "hello123boy12xboy123123";
		String p = "123";
		
		KMP(p,t);
	}
}