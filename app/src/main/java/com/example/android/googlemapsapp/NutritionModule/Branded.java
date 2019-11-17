package com.example.android.googlemapsapp.NutritionModule;

public class Branded
{
    private String food_name;

    private Object image;

    private String serving_unit;

    private String nix_brand_id;

    private String brand_name_item_name;

    private String serving_qty;

    private String nf_calories;

    private String brand_name;

    private String brand_type;

    private String nix_item_id;

    public String getFood_name ()
    {
        return food_name;
    }

    public void setFood_name (String food_name)
    {
        this.food_name = food_name;
    }

    public Object getImage ()
{
    return image;
}

    public void setImage (Object image)
    {
        this.image = image;
    }

    public String getServing_unit ()
    {
        return serving_unit;
    }

    public void setServing_unit (String serving_unit)
    {
        this.serving_unit = serving_unit;
    }

    public String getNix_brand_id ()
    {
        return nix_brand_id;
    }

    public void setNix_brand_id (String nix_brand_id)
    {
        this.nix_brand_id = nix_brand_id;
    }

    public String getBrand_name_item_name ()
    {
        return brand_name_item_name;
    }

    public void setBrand_name_item_name (String brand_name_item_name)
    {
        this.brand_name_item_name = brand_name_item_name;
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

    public String getBrand_name ()
    {
        return brand_name;
    }

    public void setBrand_name (String brand_name)
    {
        this.brand_name = brand_name;
    }

    public String getBrand_type ()
    {
        return brand_type;
    }

    public void setBrand_type (String brand_type)
    {
        this.brand_type = brand_type;
    }

    public String getNix_item_id ()
    {
        return nix_item_id;
    }

    public void setNix_item_id (String nix_item_id)
    {
        this.nix_item_id = nix_item_id;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [food_name = "+food_name+", image = "+image+", serving_unit = "+serving_unit+", nix_brand_id = "+nix_brand_id+", brand_name_item_name = "+brand_name_item_name+", serving_qty = "+serving_qty+", nf_calories = "+nf_calories+", brand_name = "+brand_name+", brand_type = "+brand_type+", nix_item_id = "+nix_item_id+"]";
    }
}