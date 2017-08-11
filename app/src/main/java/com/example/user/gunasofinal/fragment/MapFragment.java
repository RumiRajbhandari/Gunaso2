package com.example.user.gunasofinal.fragment;


import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.user.gunasofinal.R;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.MapsInitializer;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Polygon;
import com.google.android.gms.maps.model.Polyline;
import com.google.android.gms.maps.model.PolylineOptions;

/**
 * A simple {@link Fragment} subclass.
 */
public class MapFragment extends Fragment implements OnMapReadyCallback,GoogleMap.OnPolylineClickListener,
        GoogleMap.OnPolygonClickListener {
    GoogleMap mgoogleMap;
    MapView mMapView;
    View mView;
    private static final LatLng balkumari=new LatLng(27.672695, 85.341360);
    private static final LatLng satdobato=new LatLng(27.656541, 85.322048);
    private static final LatLng ekantakuna=new LatLng(27.669056, 85.306103);
    private static final LatLng kalanki=new LatLng(27.694121, 85.281551);

    public MapFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        mView= inflater.inflate(R.layout.fragment_map, container, false);
        return mView;


    }


    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mMapView=(MapView)mView.findViewById(R.id.map);
        if (mMapView !=null){
            mMapView.onCreate(null);
            mMapView.onResume();
            mMapView.getMapAsync(this);

        }
    }

    @Override
    public void onPolygonClick(Polygon polygon) {


    }

    @Override
    public void onPolylineClick(Polyline polyline) {

    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        MapsInitializer.initialize(getContext());
//        mgoogleMap=googleMap;
        PolylineOptions polylineOptions=new PolylineOptions().add(balkumari).add(satdobato).add(ekantakuna).add(kalanki).width(5).color(Color.BLUE).geodesic(true);
//        Polyline polyline1 = googleMap.addPolyline(new PolylineOptions()
//                .clickable(true)
//                .add(
//                        new LatLng(-35.016, 143.321),
//                        new LatLng(-34.747, 145.592),
//                        new LatLng(-34.364, 147.891),
//                        new LatLng(-33.501, 150.217),
//                        new LatLng(-32.306, 149.248),
//                        new LatLng(-32.491, 147.309)));

        // Position the map's camera near Alice Springs in the center of Australia,
        // and set the zoom factor so most of Australia shows on the screen.
        googleMap.addPolyline(polylineOptions);
        googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(balkumari,13));

        // Set listeners for click events.
        googleMap.setOnPolylineClickListener(this);
        googleMap.setOnPolygonClickListener(this);

    }
}
