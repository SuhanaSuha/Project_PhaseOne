
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Scanner;
import java.io.FileReader;


public class UserDetails
{
static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

 public void addUser() throws IOException
 {
 // Create or Modify a file for Database
 PrintWriter pw = new PrintWriter(new BufferedWriter(new
 FileWriter("userDetail.txt",true)));
 String name, address, dob;
 int age;
 long telephoneNo;
 String s;
 boolean addMore = false;
 // Read Data
 do
 {
  System.out.print("\nEnter name: ");
  name = br.readLine();

  System.out.print("Address: ");
  address = br.readLine();

   System.out.print("Date of Birth (dd/mm/yy) : ");
  dob = br.readLine();

  System.out.print("Age: ");
  age = Integer.parseInt(br.readLine());

  System.out.print("Telephone No.: ");
  telephoneNo = Long.parseLong(br.readLine());
  // Print to File
  pw.println(name);
  pw.println(address);
  pw.println(dob);
  pw.println(age);
  pw.println(telephoneNo);
  
  System.out.print("\nNew User added successfully !\n\nDo you want to add more records ? (y/n) : ");
  s = br.readLine();
  if(s.equalsIgnoreCase("y"))
  {
   addMore = true;
   System.out.println();
  }
  else
   addMore = false;
 }
 while(addMore);
 pw.close();
 showMenu();
 }
 public void readRecords() throws IOException
 {
 try
 {
  // Open the file
  BufferedReader file = new BufferedReader(new
  FileReader("userDetail.txt"));
  String name;
  int i=1;
  // Read records from the file
  while((name = file.readLine()) != null)
  {
   System.out.println("S.No. : " +(i++));
   System.out.println("-------------");
   System.out.println("\nName: " +name);
   System.out.println("Address: "+file.readLine());
   System.out.println("Date of Birth : "+file.readLine());
   System.out.println("Age: "+Integer.parseInt(file.readLine()));
   System.out.println("Tel. No.: "+Long.parseLong(file.readLine()));
   System.out.println();
  }
  file.close();
  showMenu();
 }
 catch(FileNotFoundException e)
 {
  System.out.println("\nERROR : File not Found !!!");
 }
 }
 public void Delete() throws IOException {
	File name = new File("userDetail.txt");
	if(name.delete()) {
		System.out.println(name.getName()+ "is deleted");
	}
	else {
		System.out.println("Operation Failed");
		
	}
}
 
 public void clear() throws IOException
 {
PrintWriter writer = new PrintWriter("userDetail.txt");
writer.print("");
// other operations
writer.close();
 System.out.println("\nAll Records cleared successfully !");
 for(int i=0;i<999999999;i++); // Wait for some time
 showMenu();
 }
 public void showMenu() throws IOException
 {
 System.out.print("1 : Add Records\n2 : Display Records\n3 : Clear All Records\n4 : Exit\n5 : Delete\n6 : Search\n\nYour Choice : ");
 int choice = Integer.parseInt(br.readLine());
 switch(choice)
 {
  case 1:
   addUser();
   break;
  case 2:
   readRecords();
   break;
  case 3:
   clear();
   break;
  case 4:
   System.exit(1);
   break;
  case 5:
	  Delete();
  case 6:
	  search();
  default:
   System.out.println("\nInvalid Choice !");
   break;
 }
 }
 public void search() throws IOException
 {
 try
 {
  
  BufferedReader file = new BufferedReader(new
  FileReader("userDetail.txt"));
  String name;
  int i=1;
  String find;
  System.out.println("\nEnter name to search");
	find = br.readLine();
  // Read records from the file
	Scanner s = new Scanner(new File("userDetail.txt"));
	while (s.hasNextLine()) 
	{
	String line = s.nextLine();
   // process the line
	if(line.equals(find))
	{
	   System.out.println("-------------");
	   System.out.println("\nName: " +line);
	   System.out.println("Address: "+s.nextLine());
	   System.out.println("Date of Birth : "+s.nextLine());
	   System.out.println("Age: "+Integer.parseInt(s.nextLine()));
	   System.out.println("Tel. No.: "+Long.parseLong(s.nextLine()));
	   System.out.println();
	}
  } 


  file.close();
  showMenu();
 }
 catch(FileNotFoundException e)
 {	
  System.out.println("\nERROR : File not Found !!!");
 }
 }
public static void main(String args[]) throws IOException
 {
    String Username;
    String Password;

    Password = "123";
    Username = "suhi";
    System.out.println("***********************************************************************");
    System.out.println("***********************************************************************");
    System.out.println("*******************WELCOME TO LOCKED ME.COM****************************");
    System.out.println("***********************************************************************");
    System.out.println("***********************************************************************");
    
    Scanner input1 = new Scanner(System.in);
    System.out.println("\n\nEnter Username : ");
    String username = input1.next();

    Scanner input2 = new Scanner(System.in);
    System.out.println("\n\nEnter Password : ");
    String password = input2.next();

    if (username.equals(Username) && password.equals(Password)) {
		System.out.println("Access Granted! Welcome!");
	UserDetails call = new UserDetails();
	call.showMenu();
    
    }

    else if (username.equals(Username)) {
        System.out.println("Invalid Password!");
    } else if (password.equals(Password)) {
        System.out.println("Invalid Username!");
    } else {
        System.out.println("Invalid Username & Password!");
    }

 }
}
