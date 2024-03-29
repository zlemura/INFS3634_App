package com.example.android.googlemapsapp.MapsResources;

import com.example.android.googlemapsapp.MapsResources.Distance;
import com.example.android.googlemapsapp.MapsResources.Duration;

public class Elements
{
    private Duration duration;

    private Distance distance;

    private String status;

    public Duration getDuration ()
    {
        return duration;
    }

    public void setDuration (Duration duration)
    {
        this.duration = duration;
    }

    public Distance getDistance ()
    {
        return distance;
    }

    public void setDistance (Distance distance)
    {
        this.distance = distance;
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
        return "ClassPojo [duration = "+duration+", distance = "+distance+", status = "+status+"]";
    }
}