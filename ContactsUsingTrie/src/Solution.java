import java.io.*;
import java.math.*;
import java.text.*;
import java.util.*;
import java.util.regex.*;

public class Solution {

	private static final Scanner scanner = new Scanner(System.in);
	
	public static void main(String[] args) {
		int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        Node node = new Node();
        for (int nItr = 0; nItr < n; nItr++) {
            String[] opContact = scanner.nextLine().split(" ");

            String op = opContact[0];

            String contact = opContact[1];
            
            if (op.equals("add")){
            	node.add(contact);
            }
            else{
            	int count = node.findCount(contact, 0);
            	System.out.println(count);
            }            	
        }
        scanner.close();		
	}

	public static class Node{
		private static int NUMBER_OF_CHARACTERS = 26;
		Node[] children = new Node[NUMBER_OF_CHARACTERS];
		int size = 0;
		
		private int getCharIndex(char c){
			return c - 'a';
		}
		
		private Node getNode(char c){
			return children[getCharIndex(c)];
		}
		
		private void setNode(char c, Node node){
			children[getCharIndex(c)] = node;
		}
		
		private void add(String s){
			add(s, 0);
		}
		
		private void add(String s, int index){
			size++;
			if (index == s.length()) return;
			char current = s.charAt(index);
			Node child = getNode(current);
			if (child == null){
				child = new Node();
				setNode(current, child);
			}
			child.add(s, index+1);
		}
		
		private int findCount(String s, int index){
			if (index == s.length()) {
				return size;
			}
			Node child = getNode(s.charAt(index));
			if (child == null){
				return 0;
			}		
			return child.findCount(s, index + 1);
		}
	}
}
