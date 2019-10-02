import java.util.Scanner;

/*
 * Purpose: Data Structure and Algorithms Lab 4 Problem 2
 * Status: Complete and thoroughly tested
 * Last update: 09/23/19
 * Submitted:  10/1/19
 * @author: Nick Setaro
 * @version: 2019.10.01
 */

public class Driver {

    static String input = "";	//variables to handle user input
    static int num = 0;
    static String item = "";
    static int index = 0;
    static Scanner sc = new Scanner(System.in);	//Scanner to handle user input
    static ListCDLSBased MyList = new ListCDLSBased();	//create list

    public static void main (String args []) {

        System.out.print("Select from the following menu: "
                         + "\r\n 1. Insert item to list."	//print input selection menu
                         + "\r\n 2. Remove item from list."
                         + "\r\n 3. Get item from list."
                         + "\r\n 4. Clear list."
                         + "\r\n 5. Display size and content of list."
                         + "\r\n 7. Delete largest item in list."
                         + "\r\n 7. Reverse the list."
                         + "\r\n 8. Exit Program."
                         + "\r\n Make your menu selection now: ");
        //take user input
        num = Integer.parseInt(sc.nextLine());
        System.out.println(Integer.toString(num));
        while(true) {	//loop for reading input

            switch (num) {	//switch to handle cases
            case 0: 
            	System.out.println("Exiting program...Good Bye");	//print exiting message and exit
                System.exit(0);
                break;
            case 1:
                insert(MyList);
                break;

            case 2:
                remove(MyList);
                break;

            case 3:
                retrieve(MyList);
                break;

            case 4:
                clear(MyList);
                break;

            case 5:
                print(MyList);
                break;

            case 6:
                reverse(MyList);
                break;
                
            default:
                System.out.println("Invalid Input");
            }
            //ask for user input
            System.out.println();
            System.out.print("Make your menu selection now: ");
            num = Integer.parseInt(sc.nextLine());
            System.out.println(Integer.toString(num));
            System.out.println();
        }
    }
    //method to handle insert option
    private static void insert(ListCDLSBased list) {

        //get item to be inserted
        System.out.println("You are now inserting an item into the list.");
        System.out.print("  Enter item:");
        item = sc.nextLine();
        System.out.println(item);
        System.out.print("  Enter position to insert item in: ");
        index = Integer.parseInt(sc.nextLine());
        System.out.println(Integer.toString(index));

        //try to add the item and check for and handle list index out of bounds exception
        try {
            list.add(index, item);
        } catch (ListIndexOutOfBoundsException e) {
            System.out.println("Position specified is out of range!");
        } finally {
        	System.out.println("Item " + item + " inserted in position " + Integer.toString(index) + " in the list.");
        }

    }

    //method to handle remove option
    private static void remove(ListCDLSBased list) {
        //check if the list is empty
        if(list.isEmpty()) {
            System.out.println("List is empty.");
        } else {
            //get index to be removed from user
            System.out.print("  Enter position to remove item from list: ");
            index = Integer.parseInt(sc.nextLine());
            Object s = null;
            System.out.println(Integer.toString(index));

            //try to remove the item from that index and check for and handle list index out of bounds exception
            try {
                s = list.get(index);
                list.remove(index);
            } catch (ListIndexOutOfBoundsException e) {
                System.out.println("Position specified is out of range!");
            }
            System.out.println("Item " + (String)s + " removed from position " + Integer.toString(index) + " in the list.");
        }

    }

    //method to handle retrieve option
    private static void retrieve(ListCDLSBased list) {

        //get user input for index to get item from
        Object s = "";
        System.out.print("  Enter position to retrieve item from: ");
        index = Integer.parseInt(sc.nextLine());
        System.out.println(index);

        //try to get the item from the index and check for and handle list index out of bounds exception
        try {
            s = list.get(index);
        } catch (ListIndexOutOfBoundsException e) {
            System.out.println("Position specified is out of range!");
        }
        System.out.println("Item " + s + " removed from position " + Integer.toString(index) + " in the list.");
    }

    //method to handle clear option
    private static void clear(ListCDLSBased list) {
        list.removeAll();
    }

    //method to handle print option
    private static void print(ListCDLSBased list) {

        //check if list is empty
        if (list.isEmpty()) {
            System.out.println("List is empty");
        } else {
            System.out.println("List of size " + list.size() + " has the following items: " + list.toString());
        }

    }

    //method to handle reverse list option
    private static void reverse(ListCDLSBased list) {
        //check if the list is empty
        if (list.isEmpty()) {
            System.out.println("List empty...nothing to reverse!");
        } else {
            //create a copy of the list
            ListCDLSBased temp = new ListCDLSBased();
            for (int i = list.size(); i > 0; i--) {
                temp.add(0, list.get(i-1));
            }
            //clear the list
            list.removeAll();
            //fill the list in reverse order
            for (int i = 0; i < temp.size(); i++) {
                list.add(0, temp.get(i));
            }
            System.out.println("List has been reversed");
            System.out.println("Here is the content: " + list.toString());
        }
    }
}