package campaignTools.advertisements;

import campaignTools.datas.Statistics;

public abstract class Advertisement // Define the blueprint of an advertisement. It has 3 children that inherit its characteristics
{
    /** Attributes of an Advertisement */

    String name;
    String type;
    double baseCost;
    Statistics statistics;

    /** Method of an Advertisement */

    public void getStatistics()
    {

    }

    public void display()
    {

    }
}
