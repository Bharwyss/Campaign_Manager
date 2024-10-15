package campaignTools.datas;

public class PublicAudience // Defines what is the public audience.
{
    /** Attributes */

    private String localisation;
    private int age;

    /** Methods */

    public String getLocalisation()
    {
        return localisation;
    }

    public void setLocalisation(String localisation)
    {
        this.localisation = localisation;
    }

    public void setAge(int age)
    {
        this.age = age;
    }

    public int getAge() {
        return age;
    }
}
