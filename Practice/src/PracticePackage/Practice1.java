package PracticePackage;

public class Practice1 {
	public static void main (String [] args) {
		String a = "Vikas";
		String b = "V k  s";
		System.out.println("The String is {}" +  a);
		//String [] ar = null;
		b.replaceAll("\\s+", "");
		char[] strArray = a.toCharArray();
		for(int i = strArray.length-1 ; i>=0; i--) {
			System.out.println(strArray[i]);
			
		}
		System.out.println(b.replaceAll(" ", ""));
	}

}
