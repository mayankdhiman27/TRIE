package trie;
import java.util.*;
/**
 *
 * @author dmayank
 */
public class TRIE {
        
    //Node class which stores character
    static class TrieNode{
        char ch;
        HashMap<Character,TrieNode> children=new HashMap<>();
        boolean isLeaf;
        
        //Constructor to maintain node created with empty args such as root.
        public TrieNode(){
        }
        
        public TrieNode(char c){
            ch=c;
        }
    }
    
    //TRIE class to implement its functions
    static class Trie{
        
        //Root Node
        static TrieNode root;
        
        //Constructor..which initailizes with root node as empty node
        public Trie(){
            root=new TrieNode();            // To define this we need a constructor with empty args.
        }
        
        //Insert function..used to insert word char by char
        public void insert(String s){
            //Create a hashmap named children and point this as root's child.This is used to know about the child
            HashMap<Character, TrieNode> children=root.children;
            
            for(int i=0;i<s.length();i++){
                char ch=s.charAt(i);
                
                //Temp node to assign char as a new node in TRIE..will be assigned address later when we need to insert new node
                TrieNode t;
                
                //Chech if char is already in TRIE
                if(children.containsKey(ch)){
                    t=children.get(ch);
                }
                //If not present in TRIE, then we node to insert a new node as t which is declared earlier as TrieNode t
                else{
                    t=new TrieNode(ch);
                    children.put(ch, t);
                }
                
                //now children will pount to its child node
                children=t.children;
                
                //if we reach end of string, then we mark it as a leaf
                if(i==s.length()-1){
                    t.isLeaf=true;
                }
            }
        }
        
        //Search Function
        public boolean search(String s){
            TrieNode t=searchword(s);
            
            if(t!=null && t.isLeaf){
                return true;
            }
            else{
                return false;
            }
        }
        
        //Search Word function
        public TrieNode searchword(String s){
            
            //make a child as map which acts as root's children
            HashMap<Character,TrieNode> children=root.children;
            
            //make a t node,but do not initialize till we get the required word
            TrieNode t=null;
            
            //loop to search char by char in TRIE
            for(int i=0;i<s.length();i++){
                char ch=s.charAt(i);
                if(children.containsKey(ch)){
                    t=children.get(ch);
                    children =t.children;
                }
                else{
                    return null;
                }
            }
            return t;
        }
    }
    
    public static void main(String[] args) {
        
        Trie t=new Trie();
        
        String s[]={"dhiman","mayank","is","worst","coder","and","he","loves","to","code","Apple","Apples"};
        
        for(int i=0;i<s.length;i++){
            t.insert(s[i]);
        }
        
        if(t.search("Apples")){
            System.out.println("Present in TRIE");
        }
        else{
            System.out.println("Not present in TRIE");
        }
        
    }
    
}

