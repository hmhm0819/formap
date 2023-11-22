package com.example.formap;

import android.annotation.SuppressLint;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.location.Address;
import android.location.Geocoder;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SearchView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import java.io.IOException;
import java.util.List;

public class Map extends Fragment implements OnMapReadyCallback {

    GoogleMap map;
    MapView mapView;
    SearchView searchView;

    @SuppressLint("MissingInflatedId")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup)inflater.inflate(R.layout.map, container, false);

        searchView = rootView.findViewById(R.id.sv_location);
        MapView mapView=(MapView) rootView.findViewById(R.id.google_Map);
        mapView.onCreate(savedInstanceState);
        mapView.onResume();

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                String location = searchView.getQuery().toString();
                List<Address> addressList = null;

                if(location != null || !location.equals("")){
                    Geocoder geocoder = new Geocoder(getActivity());
                    try {
                        addressList = geocoder.getFromLocationName(location,1);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    Address address = addressList.get(0);
                    LatLng latLng = new LatLng(address.getLatitude(),address.getLongitude());
                    map.animateCamera(CameraUpdateFactory.newLatLngZoom(latLng,16));
                }
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                return false;
            }
        });
        mapView.getMapAsync(this);
        return rootView;

    }

    @Override
    public void onMapReady(@NonNull GoogleMap googleMap) {
        map = googleMap;
        LatLng anyang = new LatLng(37.3942527,126.9568209);
        MarkerOptions markerOptions = new MarkerOptions();
        markerOptions.title("안양");
        markerOptions.snippet("도시");
        markerOptions.position(anyang);
        googleMap.addMarker(markerOptions);
        map.moveCamera(CameraUpdateFactory.newLatLngZoom(anyang,16));

        googleMap.setOnMapClickListener(new GoogleMap.OnMapClickListener() {
            @Override
            public void onMapClick(@NonNull LatLng latLng) {
                addCustomMarker(latLng);
            }
        });
    }
    private void addCustomMarker(LatLng latLng) {
        // 마커에 사용할 커스텀 이미지 가져오기
        Bitmap customMarkerBitmap = getCustomMarkerBitmap();

        // 마커 추가
        MarkerOptions markerOptions = new MarkerOptions()
                .position(latLng)
                .title("발자취")
                .icon(BitmapDescriptorFactory.fromBitmap(customMarkerBitmap));

        Marker marker = map.addMarker(markerOptions);
        marker.showInfoWindow();
    }

    // 마커에 사용할 커스텀 이미지 가져오기
    private Bitmap getCustomMarkerBitmap() {
        // 여기에서는 예시로 Drawable 리소스에서 이미지를 가져옵니다.
        Drawable drawable = getResources().getDrawable(R.drawable.custom_marker_icon);

        // Drawable을 Bitmap으로 변환
        Bitmap customMarkerBitmap = ((BitmapDrawable) drawable).getBitmap();

        // 원하는 크기로 조절 (옵션)
        int width = 100; // 원하는 너비
        int height = 100; // 원하는 높이
        customMarkerBitmap = Bitmap.createScaledBitmap(customMarkerBitmap, width, height, false);

        return customMarkerBitmap;
    }

    private void addMarker(LatLng latLng) {
        Marker marker = map.addMarker(new MarkerOptions().position(latLng).title("발자취"));
        ((Marker) marker).showInfoWindow();


    }
}