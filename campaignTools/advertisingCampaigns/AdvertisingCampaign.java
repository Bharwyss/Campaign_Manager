package campaignTools.advertisingCampaigns;

import campaignTools.advertisements.Advertisement;
import campaignTools.datas.PublicAudience;
import java.time.LocalDateTime;
import java.util.List;

public class AdvertisingCampaign // Class that define what an Advertising Campaign is.
{

    /** Attributes of an Advertising Campaign */
    protected String name;
    protected LocalDateTime startingDate;
    protected LocalDateTime endingDate;
    protected double budget;
    protected String platformTarget;
    protected PublicAudience publicTarget;
    protected List<Advertisement> advertisementList;

    /** Methods of an Advertising Campaign */

    public void addAdvertisement(Advertisement ad) // Add an advertisement to the list
    {
        advertisementList.add(ad);
    }

    public void removeAdvertisementByName(Advertisement ad) // Remove an advertisement from the list by its name
    {
        advertisementList.remove(ad);
    }

    public void removeAdvertisementByIndex(int index) // Remove an advertisement from the list by its index
    {
        advertisementList.remove(index);
    }

    public void showAdvertisement()
    {
        for (Advertisement advertisements : advertisementList)
        {
            System.out.println(advertisements);
        }
    }

    public double calculateROI() // Calculate return of investment
    {
        return 10;
    }
}
