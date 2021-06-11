package addressbook;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

import model.Person;

public class AddressBook 
{
	private static Scanner scanner = new Scanner(System.in);
	List<Person> personList = new ArrayList<>();
	HashMap<String, ArrayList<Person>> areaAddressBook = new HashMap<>();
	String keyAreaBook;
	
	/**
	 * Accepting AreaName from user as reference for ArrayList. 
	 */
	public void enterAreaBook()
	{
		System.out.println("Enter City Name for AddressBook:");
		keyAreaBook = scanner.next();
		chooseOption();
	}
	
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
	      System.out.println("Enter options 1.Add. 2.Edit. 3.Delete. 4.Display Contact. 5.Exit. 6.Display City-Wise-AddressBook ");
	      
		  
	      int userInput = scanner.nextInt();
	      switch (userInput)
	      	{
	        case 1:
	        		// Add details.
	        		addNewContact();
	        		break;
	        case 2:
		          	//Edit contact.
	        		editExistingContact();
		          	break;
	        case 3:
		          	//Delete contact.
	        		deleteExistingContact();
		          	break;
	        case 4:
		        	//Display Details.
	        		System.out.println(personList);
		        	break;
	        case 5:
			       	//Exit from program.
			        isExit = true;
			        break;
	        case 6:
		       	//Display address book by area.
		        System.out.println("City-Wise AddressBook: "+areaAddressBook);
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
        
        //storing arrayList along with the area name in hashMap.
        areaAddressBook.put(keyAreaBook,(ArrayList<Person>) personList);
        
	}
	
	/**
	 * UC-2
	 * Making changes in existing details,as per user input.
	 * Restoring the newly edited details.
	 */
	public void editExistingContact()
	{
		System.out.println("Enter old first name:");
		String oldFirstName = scanner.next();
		System.out.println("Enter new first name:");
		String newFirstName = scanner.next();
		
		for( int i = personList.size() - 1; i >= 0; --i)
		{	
			Person f = personList.get(i);
		    if(f.getFirstName().equals(oldFirstName))
		    {
		    	personList.get(i).setFirstName(newFirstName);
		    }
		}
	}
	
	/**
	 * UC-3
	 * As per the input deleting exiting record.
	 */
	public void deleteExistingContact()
	{
		System.out.println("Enter Phone Number to delete record.");
		String phoneNumber = scanner.next();
		System.out.println("Trying to locate <" + phoneNumber + ">");
		
        for (int i = personList.size() - 1; i >= 0; --i)
        {
            Person f = personList.get(i);
	        if (f.getPhoneNo().equals(phoneNumber)) 
	        {
	        	System.out.println("Found the number at index. " + i);
	            personList.remove(i);
	            System.out.println("... Successfully deleted the record.");
	        }
        }
	}
	
	/**
	 * @param args
	 * Calling methods.
	 */
	public static void main(String[] args) 
	{
		AddressBook addressBookObj = new AddressBook(); 
		addressBookObj.enterAreaBook();

	}
}
