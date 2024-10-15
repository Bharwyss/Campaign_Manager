package campaignTools.advertisingCampaigns;
import java.time.LocalDateTime;
import java.util.List;

public class AdvertisingCampaignManager
        // Class that deals with multiple campaigns. You can add one, remove one, show them, and set them into order
{
    /** Attributes of an Advertising Campaign Manager */

    protected List<AdvertisingCampaign> advertisingCampaignList;

    /** Methods of an Advertising Campaign Manager */

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

    public void showAllCampaigns() // Display all current campaigns in the list
    {
        for (AdvertisingCampaign advertisingCampaigns : advertisingCampaignList)
        {
            System.out.println(advertisingCampaigns);
        }
    }

    public void setOrderCampaignFromMostOlderDate() // Set a chronological order in the list from oldest to newest
    {
        for (int i = 1; i < advertisingCampaignList.size(); i++)
        {
            // If the current index observed is older in date than the one before, put it to the first index
            AdvertisingCampaign currentCampaign = advertisingCampaignList.get(i);
            LocalDateTime date = currentCampaign.startingDate;
            int j = i - 1;
            while (j >= 0 && advertisingCampaignList.get(j).startingDate.isAfter(date))
            {
                advertisingCampaignList.set(j+1, advertisingCampaignList.get(j));
                j--;
            }
            // Insert the current campaign at the correct position
            advertisingCampaignList.set(j + 1, currentCampaign);
        }
    }

    public void setOrderCampaignFromMostRecentDate() // Set a chronological order in the list from newest to oldest
    {
        for (int i = 1; i < advertisingCampaignList.size(); i++)
        {
            // If the current index observed is older in date than the one before, put it to the first index
            AdvertisingCampaign currentCampaign = advertisingCampaignList.get(i);
            LocalDateTime date = currentCampaign.startingDate;
            int j = i - 1;
            while (j >= 0 && advertisingCampaignList.get(j).startingDate.isBefore(date))
            {
                advertisingCampaignList.set(j+1, advertisingCampaignList.get(j));
                j--;
            }
            // Insert the current campaign at the correct position
            advertisingCampaignList.set(j + 1, currentCampaign);
        }
    }

    public static void main(String[] args)
    {
        System.out.println("It's working");
    }
}