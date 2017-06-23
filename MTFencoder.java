/*LIAM COFFEY 1206617 MY VERSION OF MOVE TO FRONT ENCODER*/
//importing relivant classes
import java.io.File;
import java.util.Scanner;
import java.io.BufferedWriter;
import java.io.FileWriter;

class MTFencoder{
    //declearing variables
    private node head;
    private node temp;
    private node curr;
    private int count;
    private int[] output;
    //initializing variables
    private MTFencoder(){
    output = new int[1000];
    count = 0;
    }
    //in the main method I run a loop to add every token scanned from the
    //scanner and add it to my list
    public static void main(String [] args){
	MTFencoder List = new MTFencoder();
	try{
	    Scanner sc = new Scanner(new File(args[0]));
	    String S;
	    while(sc.hasNext()){
		S = sc.next();
		List.add(S);
	    }
	}catch(Exception e){};
	
    }
    //this method Writes all of the data that has been added to the OUTPUT array and outputs it to a file if the file is not there it creates it
    public void Write(String X){
	File newFile = new File("encode.txt");
	    if(newFile.exists()){}
	    else{
		try{
		newFile.createNewFile();
		}
		catch(Exception e){}
	    }
		try{
		    FileWriter fileW = new FileWriter(newFile, true);
		    BufferedWriter buffW = new BufferedWriter(fileW);
		    buffW.write(X);
		    buffW.write(System.getProperty("line.separator"));
		    buffW.close();
		}
		catch(Exception e){}

	}
    //This method adds each token to the list first checking to see if there is a head element, then it checks to see if it is allready in the list the adds it to the next avaliable spot on the list
    public void add(String X){
	node temp = new node(X);
	if(head == null){
	    head = temp;
	    System.out.println("0 "+head.data);
	    Write("0 "+head.data);
	    count++;
	}
	else{
	    if(findCurrent(X)!=true){
	    node curr = head;
	    while(curr.next != null){
		curr = curr.next;
	    }
	    curr.next = temp;
	    System.out.println("0 "+temp.data);
	    Write("0 "+temp.data);
	    count++;}
	    else{
		moveToFront(X);
		count++;
	    }
	}	
    }
    //this method finds the previous node of the string value you pass it then returns it.
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
    //this method finds the current node value of the string value you pass it then returns it
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
    //This returns which position the item is in the list returned as a int
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
    //this method finds the next node after the string value you pass it
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
    //This method checks to see if the String you have passed it is the head
    public boolean isHead(String Key){
	if(head.data.equals(Key)){
	    return true;
	}
	else{
	    return false;
	}
    }
    //this method moves the item to the front of the list.
    public void moveToFront(String X){
	node curr = head;
	node Temp;
	while(curr != null){
	    if(isHead(X) == true){
		System.out.println(index(X)+" "+X);
		Write(index(X)+" "+X);
		break;
	    }
	    if(curr.data.equals(X) && curr.next == null && isHead(X) == false){
		System.out.println(index(X)+" "+X);
		Write(index(X)+" "+X);
		Temp = curr;
		findPrevious(X).next = null;
		Temp.next = head;
		head = Temp;

		break;
	    }
	    if(curr.data.equals(X) && curr.next != null && isHead(X) == false){
		System.out.println(index(X)+" "+X);
		Write(index(X)+" "+X);
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
