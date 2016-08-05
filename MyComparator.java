public class MyComparator implements java.util.Comparator<String> {

	public int compare(String strA, String strB) {
	    return strA.length() - strB.length();
	  }
}