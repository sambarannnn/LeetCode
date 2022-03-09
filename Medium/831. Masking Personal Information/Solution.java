class Solution {
	public String maskPII(String S) {
		return (S.indexOf("@") != -1) ? maskEmail(S) : maskPhone(S.toCharArray());
	}

	public String maskEmail(String s){
		StringBuilder sb = new StringBuilder();
		int index = s.indexOf("@");
		sb.append(s.charAt(0)).append("*****").append(s.charAt(index-1)).append(s.substring(index));
		return sb.toString().toLowerCase();
	}

	public String maskPhone(char[] chs){
		int cnt = 0;
		StringBuilder sb = new StringBuilder();

		for(int i=chs.length-1;i>=0;i--){
			char ch = chs[i];
			if(Character.isDigit(ch)){
				if(cnt == 4 || cnt == 7 || cnt == 10) 
				   sb.append("-");
				if (cnt < 4)
					sb.append(ch);
				else
					sb.append("*");
				cnt++; 
			} 
		}

		if(cnt>10){
			sb.append('+');
		}

		return sb.reverse().toString();
	}
}
