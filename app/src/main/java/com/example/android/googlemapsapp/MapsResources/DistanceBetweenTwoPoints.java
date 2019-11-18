package com.example.android.googlemapsapp.MapsResources;

import com.example.android.googlemapsapp.MapsResources.Rows;

public class DistanceBetweenTwoPoints
{
    private String[] destination_addresses;

    private Rows[] rows;

    private String[] origin_addresses;

    private String status;

    public String[] getDestination_addresses ()
    {
        return destination_addresses;
    }

    public void setDestination_addresses (String[] destination_addresses)
    {
        this.destination_addresses = destination_addresses;
    }

    public Rows[] getRows ()
    {
        return rows;
    }

    public void setRows (Rows[] rows)
    {
        this.rows = rows;
    }

    public String[] getOrigin_addresses ()
    {
        return origin_addresses;
    }

    public void setOrigin_addresses (String[] origin_addresses)
    {
        this.origin_addresses = origin_addresses;
    }

    public String getStatus ()
    {
        return status;
    }

    public void setStatus (String status)
    {
        this.status = status;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [destination_addresses = "+destination_addresses+", rows = "+rows+", origin_addresses = "+origin_addresses+", status = "+status+"]";
    }
}
