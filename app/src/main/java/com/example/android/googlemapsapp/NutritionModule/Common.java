package com.example.android.googlemapsapp.NutritionModule;

public class Common
{
    private String food_name;

    private String image;

    private String tag_name;

    private String tag_id;

    public String getFood_name ()
    {
        return food_name;
    }

    public void setFood_name (String food_name)
    {
        this.food_name = food_name;
    }

    public String getImage ()
    {
        return image;
    }

    public void setImage (String image)
    {
        this.image = image;
    }

    public String getTag_name ()
    {
        return tag_name;
    }

    public void setTag_name (String tag_name)
    {
        this.tag_name = tag_name;
    }

    public String getTag_id ()
    {
        return tag_id;
    }

    public void setTag_id (String tag_id)
    {
        this.tag_id = tag_id;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [food_name = "+food_name+", image = "+image+", tag_name = "+tag_name+", tag_id = "+tag_id+"]";
    }
}