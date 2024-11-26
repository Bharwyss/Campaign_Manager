package campaignTools.advertisingCampaigns;
import java.util.Comparator;
import java.util.Iterator;


public class AdvertisingCampaignManager extends ListManager<AdvertisingCampaign>
        // Class that deals with advertising campaigns

        /** Methods of an Advertising Campaign Manager */
{
    @Override
    public void showAllElements() // Display all current campaigns in the list by name and date
    {
        for (int i = 0; i < elementsList.size(); i++)
        {
            System.out.println(elementsList.get(i).getName());
            System.out.println(elementsList.get(i).getStartingDate());
        }
    }

    @Override
    public void removeByName(String elementName) // Remove an element from the list by its name
    {
        Iterator<AdvertisingCampaign> iterator = elementsList.iterator();
        while (iterator.hasNext()) {
            AdvertisingCampaign element = iterator.next();
            if (element.getName().equals(elementName)) {
                iterator.remove(); // This safely removes the element from the list
                System.out.println("Removed: " + element.getName());
                return; // Exit after the first match
            }
        }
        System.out.println("No element found with name: " + elementName);
    }

    // Method to set order by startingDate
    /** Attributes of an Advertising Campaign Manager */

    /** Methods of an Advertising Campaign Manager */
    /**

    public void addCampaign(AdvertisingCampaign addCampaign) // Add a defined campaign to the list
    {
        advertisingCampaignList.add(addCampaign);
    }

    public void removeCampaignByName(AdvertisingCampaign removeCampaign) // Remove a defined campaign from the list by its name
    {
        advertisingCampaignList.remove(removeCampaign);
    }

    public void removeCampaignByIndex(int index) // Remove a defined campaign from the list by its name
    {
        advertisingCampaignList.remove(index);
    }

    public void showAllCampaigns() // Display all current campaigns in the list by name and date
    {
        for (AdvertisingCampaign advertisingCampaigns : advertisingCampaignList)
        {
            System.out.println(advertisingCampaigns.name + " " + advertisingCampaigns.startingDate);
        }
    }

    public void setOrderCampaignFromMostOldestDate() // Set a chronological order in the list from oldest to newest
    {
        System.out.println("Test, changing list order from oldest to most recent");
        for (int i = 1; i < advertisingCampaignList.size(); i++)
        {
            // Create a new variable that refer to the current index of the list
            AdvertisingCampaign currentCampaign = advertisingCampaignList.get(i);
            // Create a new variable that refers to the attribute startingDate of the current campaign
            LocalDateTime currentCampaignDate = currentCampaign.startingDate;
            // Create variable j that represents the precedent index of the list
            int j = i - 1;
            // While j is greater or equal to zero and the date of the previous campaign is more recent than currentCampaignDate
            while (j >= 0 && advertisingCampaignList.get(j).startingDate.isAfter(currentCampaignDate))
            {
                // Set the previous campaign on index j + 1
                advertisingCampaignList.set(j+1, advertisingCampaignList.get(j));
                j--;
            }
            // Insert the current campaign at the correct position
            advertisingCampaignList.set(j+1, currentCampaign);
        }
    }

     public void setOrderCampaignFromMostRecentDate() // Set a chronological order in the list from newest to oldest
    {
        System.out.println("Test, changing list order from most recent to oldest");
        for (int i = 1; i < advertisingCampaignList.size(); i++)
        {
            AdvertisingCampaign currentCampaign = advertisingCampaignList.get(i);
            LocalDateTime date = currentCampaign.startingDate;
            int j = i - 1;
            // While j is greater or equal to zero and the date of the previous campaign is older than currentCampaignDate
            while (j >= 0 && advertisingCampaignList.get(j).startingDate.isBefore(date))
            {
                advertisingCampaignList.set(j+1, advertisingCampaignList.get(j));
                j--;
            }
            // Insert the current campaign at the correct position
            advertisingCampaignList.set(j + 1, currentCampaign);
        }
    } */
}