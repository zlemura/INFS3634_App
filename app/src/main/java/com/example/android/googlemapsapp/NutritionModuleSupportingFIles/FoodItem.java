package com.example.android.googlemapsapp.NutritionModuleSupportingFIles;

import com.google.android.gms.common.internal.service.Common;

public class FoodItem
{
    private Branded[] branded;

    private Common[] common;

    private Self[] self;

    public Branded[] getBranded ()
    {
        return branded;
    }

    public void setBranded (Branded[] branded)
    {
        this.branded = branded;
    }

    public Common[] getCommon ()
    {
        return common;
    }

    public void setCommon (Common[] common)
    {
        this.common = common;
    }

    public Self[] getSelf ()
    {
        return self;
    }

    public void setSelf (Self[] self)
    {
        this.self = self;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [branded = "+branded+", common = "+common+", self = "+self+"]";
    }
}
