import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static ArrayList<String> list = new ArrayList<>();

    public static void main(String[] args)
    {
        Scanner console = new Scanner(System.in);
        final String menu = "A - Add  D - Delete  P - Print Q - Quit";
        boolean done = false;
        String cmd = "";
        //testing
        do
        {
            {
                // display the list
                displayList();
                // display the menu options
                // get a menu choice
                cmd = SafeInput.getRegExString(console, menu, "[AaDdPpQq]");
                cmd = cmd.toUpperCase();

                // execute the choice
                switch (cmd)
                {
                    case "A":
                        Add();
                        // Prompt the user for a list item
                        // Make sure it is not an empty string
                        // add it to the list
                        break;
                    case "D":
                        Delete();
                        // Prompt the user for the number of the item to delete
                        // Translate the number to an index by subtracting 1
                        // remove the item from the list
                        break;
                    case "P":
                        break;
                    case "Q":
                        System.exit(0);
                        break;
                }
                System.out.println("Command is " + cmd);
            }
        }
        while (!done);
    }

    private static void Quit ()
    {
        Scanner in = new Scanner(System.in);
        String msg = SafeInput.getNonZeroLenString(in, "Do you want to quit?");
        boolean quit = SafeInput.getYNConfirm(in, msg);
        if (quit)
        {
            System.exit(1);
        }
    }

    private static void Add()
    {
        Scanner in = new Scanner(System.in);
        String item = SafeInput.getNonZeroLenString(in, "Enter the item to add: ");
        list.add(item);
    }

    private static void Delete ()
    {
        Scanner in = new Scanner(System.in);
        String msg = SafeInput.getNonZeroLenString(in, "Enter the item you want to remove: ");
        if (list.isEmpty())
        {
            System.out.println("The list is EMPTY");
            return ;
        }
        int index = SafeInput.getRangedInt(in, "Enter the item you want to REMOVE: ",1,list.size());
        list.remove(index-1);
    }

    private static void displayList()
    {
        System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
        if (list.size() != 0)
        {
            for (int i = 0; i < list.size(); i++)
            {
                System.out.printf("%3d%35s", i+1, list.get(i));
            }
        }
        else
            System.out.println("+++++                             List is empty                                +++++");
        System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
    }
}