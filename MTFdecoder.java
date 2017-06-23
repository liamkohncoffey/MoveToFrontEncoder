/*LIAM COFFEY 1206617 Move to front decoder*/
//imports relivant libraries
import java.io.File;
import java.util.Scanner;
import java.io.BufferedWriter;
import java.io.FileWriter;

class MTFdecoder{
    //declears variables
    private node head;
    private node temp;
    private node curr;
    private int count;
    private String output;
    //initilises variables
    private MTFdecoder(){
    count = 0;
    }
    //the main method takes in the file that has been incoded by MTFencoder.java then reads the values in, if it is a non zero string add print it and add the value to the front of the list, if it a zero adds it to the list
    public static void main(String [] args){
	MTFdecoder List = new MTFdecoder();
	
	try{
	 File file = new File("encode.txt");
	 Scanner sc = new Scanner(file);
	    String S;
	    int i;
	    while(sc.hasNextLine()){
		i = sc.nextInt();
		S = sc.next();
		List.add(S);
		if(List.output == null){
		    List.output = S + " ";
		}else{
		    List.output +=S + " ";
		}
		
	    }
	    //this deletes the file after use
	    	if(file.delete()){
    			System.out.println(file.getName() + " is deleted!");
    		}else{
    			System.out.println("Delete operation is failed.");
    		} 
	}
	catch(Exception e){};
    System.out.println(List.output);
    }
    // this adds the value to the list (SAME AS MTFencoder.java)
    public void add(String X){
	node temp = new node(X);
	if(head == null){
	    head = temp;
	    count++;
	}
	else{
	    if(findCurrent(X)!=true){
	    node curr = head;
	    while(curr.next != null){
		curr = curr.next;
	    }
	    curr.next = temp;
	    count++;}
	    else{
		moveToFront(X);
		count++;
	    }
	}	
    }
    //this finds the previous item from the string value you give it(SAME AS MTFencoder.java)
    public node findPrevious(String Key){
	node curr = head;
	while(curr != null){
	    if(curr.next.data.equals(Key)){
		return curr;
	    }else{
		curr = curr.next;
	    }
	}
	    return null;
	
    }
    //This method finds the current node of the string value you give it (SAME AS MTFencoder.java)
    public boolean findCurrent(String Key){
	node curr = head;
	while(curr != null){
	    if(curr.data.equals(Key)){
		return true;
	    }else{
		curr = curr.next;
	    }
	}
	    return false;	
    }
    //this finds the number of the String in the list(SAME AS MTFencoder.java)
    public int index(String Key){
	node curr = head;
	int i = 1;
	while(curr != null){
	    if(curr.data.equals(Key)){
		return i;
	    }else{
		i++;
		curr = curr.next;
	    }
	}
	    return i;	
    }
    // this finds the next node of the string value you pass it (SAME AS MTFencoder.java)
    public node findNext(String Key){
	node curr = head;
	while(curr != null){
	    if(curr.data.equals(Key)){
		return curr.next;
	    }else{
		curr = curr.next;
	    }
	}
      return null;	
    }
    //this checks to see if it is the head of the list(SAME AS MTFencoder.java)
    public boolean isHead(String Key){
	if(head.data.equals(Key)){
	    return true;
	}
	else{
	    return false;
	}
    }
    //this move the item to the front of the list(SAME AS MTFencoder.java)
    public void moveToFront(String X){
	node curr = head;
	node Temp;
	while(curr != null){
	    if(isHead(X) == true){

		break;
	    }
	    if(curr.data.equals(X) && curr.next == null && isHead(X) == false){

		Temp = curr;
		findPrevious(X).next = null;
		Temp.next = head;
		head = Temp;

		break;
	    }
	    if(curr.data.equals(X) && curr.next != null && isHead(X) == false){
		Temp = curr;
		findPrevious(X).next = findNext(X);
		Temp.next = head;
		head = Temp;
		break;
	   }
	else{
	    curr = curr.next;
	}
	}
    }
}
