
class TrieNode {

    private TrieNode[] links;

    private final int total = 26;

    private boolean isEnd;

    public TrieNode() {
        links = new TrieNode[total];
    }

    public boolean containsKey(char ch) {
        return links[ch -'A'] != null;
    }
    public TrieNode get(char ch) {
        return links[ch -'A'];
    }
    public void put(char ch, TrieNode node) {
        links[ch -'A'] = node;
    }
    public void setEnd() {
        isEnd = true;
    }
    public boolean isEnd() {
        return isEnd;
    }
}