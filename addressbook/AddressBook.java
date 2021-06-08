package addressbook;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import model.Person;

public class AddressBook 
{
	private static Scanner scanner = new Scanner(System.in);
	List<Person> personList = new ArrayList<>();
	
	/**
	 * UC-1.
	 *Asking user to choose either of the choice.
	 *Calling the function as per user input. 
	 */
	public void chooseOption()
	{
		boolean isExit = false;
	    
	    while (!isExit) 
	    {
	      System.out.println("Enter options 1.Add. 2.Edit. 3.Delete. 4.Display Contact. 5.Exit.");
	      int userInput = scanner.nextInt();
	      switch (userInput)
	      	{
	        case 1:
	        		// Add details.
	        		addNewContact();
	        		break;
	        default:
	          System.out.println("Please enter valid input");
			}
		}
	}
	
	/**
	 * UC-1
	 * Adding person details.
	 * storing it inside ArrayList.
	 */
	public void addNewContact()
	{	
		Person person =new Person();
        
        System.out.println("Enter First name:");
        person.setFirstName(scanner.next());
        
        System.out.println("Enter Last Name:");
        person.setLastName(scanner.next());
        
        System.out.println("Enter Address:");
        person.setAddress(scanner.next());
        
        System.out.println("Enter City:");
        person.setCity(scanner.next());
        
        System.out.println("Enter State:");
        person.setState(scanner.next());
        
        System.out.println("Enter Zip:");
        person.setZip(scanner.next());
        
        System.out.println("Enter Email:");
        person.setEmail(scanner.next());
        
        System.out.println("Enter Phone:");
        person.setPhoneNo(scanner.next());
        
        personList.add(person);
	}
	
	
	
	/**
	 * @param args
	 * Calling methods.
	 */
	public static void main(String[] args) 
	{
		AddressBook addressBookObj = new AddressBook(); 
		addressBookObj.chooseOption();

	}
}
