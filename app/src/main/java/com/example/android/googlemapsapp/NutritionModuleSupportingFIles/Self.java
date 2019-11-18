package com.example.android.googlemapsapp.NutritionModuleSupportingFIles;

public class Self
{
    private String food_name;

    private String serving_unit;

    private Object nix_brand_id;

    private String serving_qty;

    private String nf_calories;

    private Object brand_name;

    private String uuid;

    private Object nix_item_id;

    public String getFood_name ()
    {
        return food_name;
    }

    public void setFood_name (String food_name)
    {
        this.food_name = food_name;
    }

    public String getServing_unit ()
    {
        return serving_unit;
    }

    public void setServing_unit (String serving_unit)
    {
        this.serving_unit = serving_unit;
    }

    public Object getNix_brand_id ()
{
    return nix_brand_id;
}

    public void setNix_brand_id (Object nix_brand_id)
    {
        this.nix_brand_id = nix_brand_id;
    }

    public String getServing_qty ()
    {
        return serving_qty;
    }

    public void setServing_qty (String serving_qty)
    {
        this.serving_qty = serving_qty;
    }

    public String getNf_calories ()
    {
        return nf_calories;
    }

    public void setNf_calories (String nf_calories)
    {
        this.nf_calories = nf_calories;
    }

    public Object getBrand_name ()
{
    return brand_name;
}

    public void setBrand_name (Object brand_name)
    {
        this.brand_name = brand_name;
    }

    public String getUuid ()
    {
        return uuid;
    }

    public void setUuid (String uuid)
    {
        this.uuid = uuid;
    }

    public Object getNix_item_id ()
{
    return nix_item_id;
}

    public void setNix_item_id (Object nix_item_id)
    {
        this.nix_item_id = nix_item_id;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [food_name = "+food_name+", serving_unit = "+serving_unit+", nix_brand_id = "+nix_brand_id+", serving_qty = "+serving_qty+", nf_calories = "+nf_calories+", brand_name = "+brand_name+", uuid = "+uuid+", nix_item_id = "+nix_item_id+"]";
    }
}
