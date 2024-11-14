package campaignTools.advertisingCampaigns;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public abstract class ListManager<T> // Abstract class that holds the "manager" logic (add, remove, set, show, etc)
    // T is a generic, it can be from different subclasses type
{

    /** Attribute of ListManager **/
    protected List<T> elementsList = new ArrayList<>();

    /** Methods of an Advertising Campaign Manager */

    public void showAllElements() // Display all current campaigns in the list by name and date
    {
        Iterator<T> it = elementsList.iterator();
        while(it.hasNext())
            System.out.println(it.next());
    }

    public void addNew(T element) // Add an element to the list
    {
        elementsList.add(element);
    }

    public void remove(T Element)
    {
        elementsList.remove(Element);
    }

    public void removeByIndex(int index) // Remove an element from the list by its name
    {
        elementsList.remove(index);
    }

    public abstract void removeByName(String elementName); // Remove an element from the list by its name

}
