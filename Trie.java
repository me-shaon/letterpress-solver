import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.Arrays;

class Trie {
    private TrieNode root;
    private ArrayList<String> list;
    private boolean flag[];

    public Trie() {
        root = new TrieNode();
        list = new ArrayList<String>();
        flag = new boolean[100];
    }

    // Inserts a word into the trie.
    public void insert(String word) {
        TrieNode node = root;
        for (int i = 0; i < word.length(); i++) {
            char currentChar = word.charAt(i);
            if (!node.containsKey(currentChar)) {
                node.put(currentChar, new TrieNode());
            }
            node = node.get(currentChar);
        }
        node.setEnd();
    }
    
    private void searchMatch(TrieNode node, String word, String matchedWord) {
    	
    	if(node.isEnd())
		{
    		list.add(matchedWord);
		}

    	String matchThisFar = "";

    	for(int i = 0; i<word.length(); i++)
    	{
    		char currChar = word.charAt(i);
    		
    		if(node.containsKey(currChar) && !flag[i])
    		{
    			TrieNode newNode = node.get(currChar);
    			matchThisFar = matchedWord + currChar;

    			flag[i] = true;
    			searchMatch(newNode, word, matchThisFar);
    			flag[i] = false;
    		}
    	}
    }

    
    public boolean search(String word) {
        Arrays.fill(flag, false);

        String matchedWord = "";
        searchMatch(root, word, matchedWord);

        return true;
    }
    
    public void showSorted() throws IOException {

    	Collections.sort(list, new MyComparator());
    	Collections.reverse(list);
    	Set<String> newlist = new LinkedHashSet<>(list);

    	BufferedWriter fileout = null;
    	fileout = new BufferedWriter(new FileWriter("output.txt"));
    	
    	for (Iterator<String> it = newlist.iterator(); it.hasNext(); ) {
            String f = it.next();
            System.out.println(f);
            
            fileout.write(f);
            fileout.newLine();
        }
    	
		fileout.close();
    }
}