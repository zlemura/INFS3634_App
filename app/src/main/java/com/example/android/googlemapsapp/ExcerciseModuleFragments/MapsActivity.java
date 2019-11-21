package com.example.android.googlemapsapp.ExcerciseModuleFragments;

import androidx.fragment.app.FragmentActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.android.googlemapsapp.MapsResources.DistanceBetweenTwoPoints;
import com.example.android.googlemapsapp.R;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.Circle;
import com.google.android.gms.maps.model.CircleOptions;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.gson.Gson;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    public GoogleMap mMap;
    boolean userPinDropped = false;
    private LatLng userPin = new LatLng(0, 0);
    private String urlForDistanceRequest;
    private LatLng unsw = new LatLng(-33.917324, 151.229669);
    private int pinStepDistance = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);

        pinStepDistance=0;

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        Button nextBtn = findViewById(R.id.mapsQuizNextBtn);

        //Button to submit results of user selection (pin)
        nextBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {

                System.out.println("userPinDropped = " + userPinDropped);
                System.out.println("Pin distance = " + pinStepDistance);

                //If a pin has been dropped and within 10000 steps of UNSW pin, go to passed activity
                //Else if pin dropped and not within 10000 steps of UNSW pin, go to failed activity
                //Else if pin has not been dropped, show a toast informing the user they must drop a pin before cotninuing
                if( userPinDropped == true){
                    if(pinStepDistance >=10000){
                        System.out.println("IN PASSED IF");
                        Intent intent = new Intent(getApplicationContext(), ExcerciseModuleQuizPassedActivity.class);
                        intent.putExtra("stepsDistance",pinStepDistance);
                        startActivity(intent);
                    }else if(pinStepDistance <10000){
                        System.out.println("IN FAILED IF");
                        Intent intent = new Intent(getApplicationContext(), ExcerciseModuleQuizFailedActivity.class);
                        intent.putExtra("stepsDistance",pinStepDistance);
                        startActivity(intent);
                    }
                }else{
                    Toast.makeText(getApplicationContext(),"Please place a pin before continuing",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    //Initialises the google map for a user to interact with
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        // Add a marker in Sydney and move the camera
        mMap.addMarker(new MarkerOptions().position(unsw).title("UNSW"));
        mMap.getUiSettings().setScrollGesturesEnabled(false);
        mMap.getUiSettings().setZoomControlsEnabled(true);
        mMap.moveCamera(CameraUpdateFactory.zoomTo(13.0f));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(unsw));

        googleMap.setMapType(GoogleMap.MAP_TYPE_HYBRID);

        //Listener for when user taps map, to place pin on that position and calcualte how many steps the pin
        //is from the UNSW pin, for the prupose of determine if user has passed quiz


        mMap.setOnMapClickListener(new GoogleMap.OnMapClickListener() {

            @Override
            public void onMapClick(LatLng point) {

                //Boolean to determine if a pin has already been dropped, to tell the user they can only
                //drop one pin

                if (userPinDropped == false) {
                    MarkerOptions marker = new MarkerOptions()
                            .position(new LatLng(point.latitude, point.longitude))
                            .title("The location you chose");
                    userPin = point;
                    mMap.addMarker(marker);
                    System.out.println("The pin is at: " + point.latitude + "---" + point.longitude);
                    userPinDropped = true;

                    //API call for detemrining distance from UNSW pin to users pin, using latitidue and longitudes
                    urlForDistanceRequest = "https://maps.googleapis.com/maps/api/distancematrix/json?units=metric&" +
                            "origins=" + unsw.latitude + "," + unsw.longitude +
                            "&destinations=" + userPin.latitude + "," + userPin.longitude +
                            "&key=AIzaSyDAILac6SkoE9XjrMKpEUugF1eVWJ7hkGI";

                    System.out.println("USER REQUESTER URL IS: " + urlForDistanceRequest);

                    //Code to request distance between two points

                    RequestQueue requestQueue = Volley.newRequestQueue(MapsActivity.this);

                    StringRequest stringRequest = new StringRequest(Request.Method.GET, urlForDistanceRequest,
                            new Response.Listener<String>() {
                                @Override
                                public void onResponse(String response) {
                                    // Display the first 500 characters of the response string.
                                    String apiText = response.toString();
                                    Gson gson = new Gson();
                                    DistanceBetweenTwoPoints distanceObject = gson.fromJson(apiText, DistanceBetweenTwoPoints.class);
                                    int distance = Integer.valueOf(distanceObject.getRows()[0].getElements()[0].getDistance().getValue());
                                    pinStepDistance = distance;
                                    System.out.println("THE DISTANCEY IS: " + distance);


                                    if(distance < 10000){
                                        Circle circle = mMap.addCircle(new CircleOptions()
                                                .center(unsw)
                                                .radius(10000)
                                                .strokeColor(Color.RED));
                                        mMap.moveCamera(CameraUpdateFactory.zoomTo(11.0f));
                                    }else{
                                        Circle circle = mMap.addCircle(new CircleOptions()
                                                .center(unsw)
                                                .radius(10000)
                                                .strokeColor(Color.GREEN));
                                        mMap.moveCamera(CameraUpdateFactory.zoomTo(11.0f));
                                    }

                                }
                            }, new Response.ErrorListener() {
                        @Override
                        public void onErrorResponse(VolleyError error) {
                            Log.d("NO BUENO", error.toString());
                            Log.d("PARSE FINISHED", "WITH ERROR");
                            //com.android.volley.NoConnectionError: java.net.UnknownHostException: Unable to resolve host "api.nytimes.com": No address associated with hostname
                        }
                    });

                    requestQueue.add(stringRequest);

                } else {
                    Toast.makeText(getApplicationContext(), "You can only drop one pin", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
}
