package campaignTools.AdvertisingCampaigns;

import campaignTools.Advertisements.Advertisement;
import campaignTools.datas.PublicTarget;

import java.time.LocalDateTime;
import java.util.List;

public class AdvertisingCampaign
{

    /** Attributes of an Advertising Campaign */
    String name;
    LocalDateTime startingDate;
    LocalDateTime endingDate;
    double budget;
    String platformTarget;
    PublicTarget publicTarget;
    List<Advertisement> advertisementList;

    /** Methods of an Advertising Campaign */

    public void addAdvertisement(Advertisement add) // Add an advertisement to the list
    {

    }

    public void removeAdvertisement(Advertisement add) // Remove an advertisement from the list
    {

    }

    public double calculateROI() // Calculate return of investment
    {
        return 10;
    }
}
