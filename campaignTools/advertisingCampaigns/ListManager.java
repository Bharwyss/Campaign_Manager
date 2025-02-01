package campaignTools.advertisingCampaigns;

import java.util.*;
import java.util.function.Function;

public abstract class ListManager<E> // Abstract class that holds the "manager" logic (add, remove, set, show, etc)
    // T is a generic, it can be from different subclasses type
{

    /** Attribute of ListManager **/
    protected List<E> elementsList = new ArrayList<>();
    
    /** Methods of an Advertising Campaign Manager */

    public void showAllElements() // Display all current campaigns in the list by name and date
    {
        for (E element : elementsList)
        {
            System.out.println(element);
        }
    }

    public void addNew(E element) // Add an element to the list
    {
        elementsList.add(element);
    }

    public void remove(E Element)
    {
        elementsList.remove(Element);
    }

    public void removeByIndex(int index) // Remove an element from the list by its name
    {
        elementsList.remove(index);
    }

    public abstract void removeByName(String elementName); // Remove an element from the list by its name


    public <U extends Comparable<U>> void sortByAttribute(Function<E, U> attributeExtractor, boolean ascending) // 2 parameters, one is the function that gets the attribute from an object, the second the boolean for orders
    {
        // Creating the comparator based on the attributeExtractor
        Comparator<E> comparatorByAttribute = Comparator.comparing(attributeExtractor);
        // If the boolean is false, the comparator will be in descending order
        if(!ascending)
        {
            comparatorByAttribute = comparatorByAttribute.reversed();
            System.out.println("Descending order");
        }
        // sorting the list with the new created comparator
        elementsList.sort(comparatorByAttribute);
        System.out.println("Ordering complete");
    }
}

