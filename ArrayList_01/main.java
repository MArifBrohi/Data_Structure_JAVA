import java.util.Collections;
import java.util.ArrayList;
class ArrayList_01{
    public static void main(String[] args)
    {
        ArrayList<Integer> list = new ArrayList<Integer>();
        // add elements
        list.add(1);
        list.add(5);
        list.add(7);
        System.out.println("ArrayList:");
        System.out.println(list);
        // get element from its index
        System.out.println("Getting value at index 2");
        int ele = list.get(2);
        System.out.println(ele);
        System.out.println("Remove element at 2 index: ");

        list.remove(2);
        System.out.println(list);

        // SET ELEMENT
        System.out.println("Set element at 1 index: ");
        list.set(1 , 6);
        System.out.println(list);

        // add elememt in between
        System.out.println("adding element at zero index:");
        list.add(0,2);
        System.out.println(list);

        //Sorting all elements
        System.out.println("Sorting all elements: ");

        Collections.sort(list);
        System.out.println(list);

        System.out.println("Printing all elements using for loop: ");

        for(int i =0; i<list.size(); i++)
        {
            System.out.print(list.get(i)+" ");
        }

     

    }
}
