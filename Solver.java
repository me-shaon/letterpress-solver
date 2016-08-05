import java.io.*;
import java.util.*;

public class Solver {

	public static void main(String[] args) throws IOException {
		Trie trie = new Trie();
		
		try {
			BufferedReader filein = new BufferedReader(new FileReader("dictionary.txt"));
		
			String word = filein.readLine();
			do{
				//skipping the words separated by '-' or ' '
				if(word.indexOf(' ') < 0 && word.indexOf('-') < 0)
					trie.insert(word);
				word = filein.readLine();
			}while(word != null);
		
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}		


		Scanner in = new Scanner(System.in);
		String word=null;
		while((word = in.nextLine()) != null)
		{
			trie.search(word.toUpperCase());
			trie.showSorted();
		}
	}

}
