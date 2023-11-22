package com.example.formap;

import android.annotation.SuppressLint;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
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

public class Map extends Fragment implements GoogleMap.OnMyLocationButtonClickListener, GoogleMap.OnMyLocationClickListener, OnMapReadyCallback {

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

        Button btnZoomIn = rootView.findViewById(R.id.btnZoomIn);
        Button btnZoomOut = rootView.findViewById(R.id.btnZoomOut);

        btnZoomIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                map.animateCamera(CameraUpdateFactory.zoomIn());
            }
        });

        btnZoomOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                map.animateCamera(CameraUpdateFactory.zoomOut());
            }
        });

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
    private Bitmap resizeBitmap(int resource, int width, int height) {
        BitmapDrawable bitmapDrawable = (BitmapDrawable) getResources().getDrawable(resource);
        Bitmap bitmap = bitmapDrawable.getBitmap();
        return Bitmap.createScaledBitmap(bitmap, width, height, false);
    }

    @Override
    public void onMapReady(@NonNull GoogleMap googleMap) {
        map = googleMap;
        LatLng anyang = new LatLng(37.3942527, 126.9568209);
        int desiredWidth = 100; // 원하는 너비
        int desiredHeight = 150; // 원하는 높이
        Bitmap resizedBitmap = resizeBitmap(R.drawable.pink_marker, desiredWidth, desiredHeight);

        MarkerOptions anyangMarkerOptions = new MarkerOptions()
                .position(anyang)
                .title("안양")
                .snippet("도시")
                .icon(BitmapDescriptorFactory.fromBitmap(resizedBitmap));

        googleMap.addMarker(anyangMarkerOptions);
        map.moveCamera(CameraUpdateFactory.newLatLngZoom(anyangMarkerOptions.getPosition(), 16));

        // 병목안 시민공원 마커 추가
        LatLng b = new LatLng(37.38459, 126.9090);
        MarkerOptions bMarkerOptions = new MarkerOptions()
                .position(b)
                .title("병목안 시민공원")
                .snippet("시티 공원, 24시간 영업, 반려견 출입 가능")
                .icon(BitmapDescriptorFactory.fromBitmap(resizedBitmap)); // pink_marker 이미지 사용

        map.addMarker(bMarkerOptions);

        // 평촌 중앙공원 마커 추가
        b = new LatLng(37.39020, 126.9594);
        bMarkerOptions = new MarkerOptions()
                .position(b)
                .title("평촌 중앙공원")
                .snippet("공원, 24시간 영업, 반려견 출입 가능")
                .icon(BitmapDescriptorFactory.fromBitmap(resizedBitmap));
        map.addMarker(bMarkerOptions);

        //안양 종합운동장 마커 추가
        b = new LatLng(37.40634, 126.9463);
        bMarkerOptions = new MarkerOptions()
                .position(b)
                .title("안양 종합운동장")
                .snippet("경기장, 오후 10시 영업종료, 산책 가능")
                .icon(BitmapDescriptorFactory.fromBitmap(resizedBitmap)); // pink_marker 이미지 사용
        map.addMarker(bMarkerOptions);

        b = new LatLng( 37.39789, 126.9708);
        bMarkerOptions = new MarkerOptions()
                .position(b)
                .title("M365")
                .snippet("카페, 매장 내 식사 및 포장 가능, 오후 10시 영업종료")
                .icon(BitmapDescriptorFactory.fromBitmap(resizedBitmap)); // pink_marker 이미지 사용
        map.addMarker(bMarkerOptions);
        //
        b = new LatLng( 37.39863, 126.9238);
        bMarkerOptions = new MarkerOptions()
                .position(b)
                .title("계진상 안양점")
                .snippet("닭요리 전문점, 매장 내 식사 가능, 오후 10시 영업종료")
                .icon(BitmapDescriptorFactory.fromBitmap(resizedBitmap)); // pink_marker 이미지 사용
        map.addMarker(bMarkerOptions);
        //
        b = new LatLng( 37.39050, 126.95508);
        bMarkerOptions = new MarkerOptions()
                .position(b)
                .title("고고랜드 롤러스케이드 안양 범계역점")
                .snippet("롤러스케이트장, 오후 9시 영업종료")
                .icon(BitmapDescriptorFactory.fromBitmap(resizedBitmap)); // pink_marker 이미지 사용
        map.addMarker(bMarkerOptions);

        b = new LatLng( 37.41432, 126.9520);
        bMarkerOptions = new MarkerOptions()
                .position(b)
                .title("남도에서 본점")
                .snippet("게장 전문점, 매장 내 식사 및 포장 가능, 오후 10시 영업종료")
                .icon(BitmapDescriptorFactory.fromBitmap(resizedBitmap)); // pink_marker 이미지 사용
        map.addMarker(bMarkerOptions);

        b = new LatLng(  37.39383, 126.9595);
        bMarkerOptions = new MarkerOptions()
                .position(b)
                .title("건강밥상심마니 평촌점")
                .snippet("한식당, 매장 내 식사 가능, 오후 9시 영업종료")
                .icon(BitmapDescriptorFactory.fromBitmap(resizedBitmap)); // pink_marker 이미지 사용
        map.addMarker(bMarkerOptions);

        b = new LatLng(  37.39992, 126.9215);
        bMarkerOptions = new MarkerOptions()
                .position(b)
                .title("누누가 소문난 밀크티")
                .snippet("카페, 매장 내 식사 및 포장 가능, 오후 11시 영업종료")
                .icon(BitmapDescriptorFactory.fromBitmap(resizedBitmap)); // pink_marker 이미지 사용
        map.addMarker(bMarkerOptions);


        b = new LatLng(   37.39177, 126.9532);
        bMarkerOptions = new MarkerOptions()
                .position(b)
                .title("드림디포 범계점")
                .snippet("문구점, 오후 8시 영업종료")
                .icon(BitmapDescriptorFactory.fromBitmap(resizedBitmap)); // pink_marker 이미지 사용
        map.addMarker(bMarkerOptions);


        b = new LatLng(  37.39158, 126.9535);
        bMarkerOptions = new MarkerOptions()
                .position(b)
                .title("D'ani")
                .snippet("카페, 매장 내 식사 및 포장 가능, 오후 10시 영업종료")
                .icon(BitmapDescriptorFactory.fromBitmap(resizedBitmap)); // pink_marker 이미지 사용
        map.addMarker(bMarkerOptions);


        b = new LatLng(  37.39825, 126.9226);
        bMarkerOptions = new MarkerOptions()
                .position(b)
                .title("로렌스308 ")
                .snippet("음식점, 매장 내 식사 및 포장 가능, 오후 10시 영업종료")
                .icon(BitmapDescriptorFactory.fromBitmap(resizedBitmap)); // pink_marker 이미지 사용
        map.addMarker(bMarkerOptions);


        b = new LatLng(  37.39003, 126.9503);
        bMarkerOptions = new MarkerOptions()
                .position(b)
                .title("롯데백화점 평촌점")
                .snippet("백화점, 오후 8시 영업종료")
                .icon(BitmapDescriptorFactory.fromBitmap(resizedBitmap)); // pink_marker 이미지 사용
        map.addMarker(bMarkerOptions);


        b = new LatLng(   37.39139, 126.9548);
        bMarkerOptions = new MarkerOptions()
                .position(b)
                .title("마초쉐프 범계점")
                .snippet("패밀리 레스토랑, 매장 내 식사 및 포장 가능, 오후 10시 영업종료")
                .icon(BitmapDescriptorFactory.fromBitmap(resizedBitmap)); // pink_marker 이미지 사용
        map.addMarker(bMarkerOptions);


        b = new LatLng(  37.39995, 126.9178);
        bMarkerOptions = new MarkerOptions()
                .position(b)
                .title("메리어케이크")
                .snippet("케이크전문점, 포장 가능, 오후 9시 영업종료")
                .icon(BitmapDescriptorFactory.fromBitmap(resizedBitmap)); // pink_marker 이미지 사용
        map.addMarker(bMarkerOptions);

        b = new LatLng( 37.39640, 126.9757);
        bMarkerOptions = new MarkerOptions()
                .position(b)
                .title("벨라로사 평촌본점")
                .snippet("음식점, 매장 내 식사 및 포장 가능, 오후 10시 영업종료")
                .icon(BitmapDescriptorFactory.fromBitmap(resizedBitmap)); // pink_marker 이미지 사용
        map.addMarker(bMarkerOptions);

        b = new LatLng(  37.39973, 126.9734);
        bMarkerOptions = new MarkerOptions()
                .position(b)
                .title("삑삑도요")
                .snippet("이탈리아 음식점, 매장 내 식사 가능, 오전 1시 영업종료")
                .icon(BitmapDescriptorFactory.fromBitmap(resizedBitmap)); // pink_marker 이미지 사용
        map.addMarker(bMarkerOptions);

        b = new LatLng(  37.39995, 126.9178);
        bMarkerOptions = new MarkerOptions()
                .position(b)
                .title("사이숲")
                .snippet("케이크전문점, 포장 가능, 오후 9시 영업종료")
                .icon(BitmapDescriptorFactory.fromBitmap(resizedBitmap)); // pink_marker 이미지 사용
        map.addMarker(bMarkerOptions);

        b = new LatLng(   37.41936, 126.9217);
        bMarkerOptions = new MarkerOptions()
                .position(b)
                .title("메리어케이크")
                .snippet("카페, 매장 내 식사 및 포장 가능, 오후 9시 영업종료")
                .icon(BitmapDescriptorFactory.fromBitmap(resizedBitmap)); // pink_marker 이미지 사용
        map.addMarker(bMarkerOptions);

        b = new LatLng( 37.39822, 126.9170);
        bMarkerOptions = new MarkerOptions()
                .position(b)
                .title("삼덕공원")
                .snippet("공원, 반려견 출입 가능, 24시간 영업")
                .icon(BitmapDescriptorFactory.fromBitmap(resizedBitmap)); // pink_marker 이미지 사용
        map.addMarker(bMarkerOptions);

        b = new LatLng(  37.39071, 126.9540);
        bMarkerOptions = new MarkerOptions()
                .position(b)
                .title("삼돌박이수라육간")
                .snippet("음식점, 매장 내 식사 가능, 오후 9:30분 영업종료")
                .icon(BitmapDescriptorFactory.fromBitmap(resizedBitmap)); // pink_marker 이미지 사용
        map.addMarker(bMarkerOptions);

        b = new LatLng(  37.43481, 126.9229);
        bMarkerOptions = new MarkerOptions()
                .position(b)
                .title("삼막사계곡")
                .snippet("하이킹코스, 반려견 출입 가능, 오후 6시 영업종료")
                .icon(BitmapDescriptorFactory.fromBitmap(resizedBitmap)); // pink_marker 이미지 사용
        map.addMarker(bMarkerOptions);

        b = new LatLng(  37.42229, 126.9031);
        bMarkerOptions = new MarkerOptions()
                .position(b)
                .title("석수체육공원")
                .snippet("공원, 24시간 영업")
                .icon(BitmapDescriptorFactory.fromBitmap(resizedBitmap)); // pink_marker 이미지 사용
        map.addMarker(bMarkerOptions);

        b = new LatLng( 37.39617, 126.9655);
        bMarkerOptions = new MarkerOptions()
                .position(b)
                .title("세븐스타코인노래연습장 평촌대한점")
                .snippet("노래방, 오전 1시 영업종료")
                .icon(BitmapDescriptorFactory.fromBitmap(resizedBitmap)); // pink_marker 이미지 사용
        map.addMarker(bMarkerOptions);

        b = new LatLng(  37.39258, 126.9541);
        bMarkerOptions = new MarkerOptions()
                .position(b)
                .title("슈가판타지")
                .snippet("사무용품 판매점, 오후 8시 영업종료")
                .icon(BitmapDescriptorFactory.fromBitmap(resizedBitmap)); // pink_marker 이미지 사용
        map.addMarker(bMarkerOptions);

        b = new LatLng(  37.36349, 126.9641);
        bMarkerOptions = new MarkerOptions()
                .position(b)
                .title("신멘")
                .snippet("일본라면 전문식당, 매장 내 식사 가능, 오후 8:30분 영업종료")
                .icon(BitmapDescriptorFactory.fromBitmap(resizedBitmap)); // pink_marker 이미지 사용
        map.addMarker(bMarkerOptions);

        b = new LatLng( 37.40184, 126.9757);
        bMarkerOptions = new MarkerOptions()
                .position(b)
                .title("신스")
                .snippet("술집, 매장 내 식사 가능, 오전 2시 영업종료")
                .icon(BitmapDescriptorFactory.fromBitmap(resizedBitmap)); // pink_marker 이미지 사용
        map.addMarker(bMarkerOptions);

        b = new LatLng( 37.40671, 126.9702);
        bMarkerOptions = new MarkerOptions()
                .position(b)
                .title("심스커피")
                .snippet("카페, 매장 내 식사 및 포장 가능, 오후 11시 영업종료 ")
                .icon(BitmapDescriptorFactory.fromBitmap(resizedBitmap)); // pink_marker 이미지 사용
        map.addMarker(bMarkerOptions);

        b = new LatLng( 37.38221, 126.9594);
        bMarkerOptions = new MarkerOptions()
                .position(b)
                .title("아쿠아워시 평촌학원가점")
                .snippet("빨래방, 24시간 영업")
                .icon(BitmapDescriptorFactory.fromBitmap(resizedBitmap)); // pink_marker 이미지 사용
        map.addMarker(bMarkerOptions);

        b = new LatLng(  37.39065, 126.9540);
        bMarkerOptions = new MarkerOptions()
                .position(b)
                .title("악쓰는 하마 코인노래연습장 범계점")
                .snippet("노래방, 오전 2시 영업종료")
                .icon(BitmapDescriptorFactory.fromBitmap(resizedBitmap)); // pink_marker 이미지 사용
        map.addMarker(bMarkerOptions);

        b = new LatLng(  37.38087, 126.9635);
        bMarkerOptions = new MarkerOptions()
                .position(b)
                .title("평촌자유공원축구장")
                .snippet("축구 경기장, 오전 12시 영업종료")
                .icon(BitmapDescriptorFactory.fromBitmap(resizedBitmap)); // pink_marker 이미지 사용
        map.addMarker(bMarkerOptions);

        b = new LatLng( 37.38025, 126.9469);
        bMarkerOptions = new MarkerOptions()
                .position(b)
                .title("호계체육관")
                .snippet("체육관, 오후 10시 영업종료")
                .icon(BitmapDescriptorFactory.fromBitmap(resizedBitmap)); // pink_marker 이미지 사용
        map.addMarker(bMarkerOptions);

        b = new LatLng( 37.39678, 126.9210);
        bMarkerOptions = new MarkerOptions()
                .position(b)
                .title("안양 명물 순대곱창골목")
                .snippet("음식점, 매장 내 식사 및 포장 가능, 오후 9시 영업종료")
                .icon(BitmapDescriptorFactory.fromBitmap(resizedBitmap)); // pink_marker 이미지 사용
        map.addMarker(bMarkerOptions);

        b = new LatLng( 37.39068, 126.95289);
        bMarkerOptions = new MarkerOptions()
                .position(b)
                .title("엔젤스코인노래연습장 범계점")
                .snippet("노래방, 오전 1시 영업종료")
                .icon(BitmapDescriptorFactory.fromBitmap(resizedBitmap)); // pink_marker 이미지 사용
        map.addMarker(bMarkerOptions);

        b = new LatLng(37.40297, 126.9176);
        bMarkerOptions = new MarkerOptions()
                .position(b)
                .title("온유김밥")
                .snippet("한식당, 매장 내 식사 및 포장 가능, 오후 7시 영업종료")
                .icon(BitmapDescriptorFactory.fromBitmap(resizedBitmap)); // pink_marker 이미지 사용
        map.addMarker(bMarkerOptions);

        b = new LatLng( 37.40886, 126.9721);
        bMarkerOptions = new MarkerOptions()
                .position(b)
                .title("우디드커피")
                .snippet("카페, 매장 내 식사 및 포장 가능, 오후 9시 영업종료")
                .icon(BitmapDescriptorFactory.fromBitmap(resizedBitmap)); // pink_marker 이미지 사용
        map.addMarker(bMarkerOptions);

        b = new LatLng( 37.39232, 126.9565);
        bMarkerOptions = new MarkerOptions()
                .position(b)
                .title("워시 프렌즈 셀프빨래방 안양평촌점")
                .snippet("빨래방, 24시간 영업")
                .icon(BitmapDescriptorFactory.fromBitmap(resizedBitmap)); // pink_marker 이미지 사용
        map.addMarker(bMarkerOptions);

        b = new LatLng(  37.39106, 126.9528);
        bMarkerOptions = new MarkerOptions()
                .position(b)
                .title("준식당")
                .snippet("삼겹살 전문점, 매장 내 식사 및 포장 가능, 오전 2시 영업종료")
                .icon(BitmapDescriptorFactory.fromBitmap(resizedBitmap)); // pink_marker 이미지 사용
        map.addMarker(bMarkerOptions);

        b = new LatLng(  37.39856, 126.9237);
        bMarkerOptions = new MarkerOptions()
                .position(b)
                .title("청춘포차")
                .snippet("술집, 매장 내 식사 가능, 오전 2시 영업종료")
                .icon(BitmapDescriptorFactory.fromBitmap(resizedBitmap)); // pink_marker 이미지 사용
        map.addMarker(bMarkerOptions);


        b = new LatLng(  37.39111, 126.9553);
        bMarkerOptions = new MarkerOptions()
                .position(b)
                .title("촌놈집 범계점 ")
                .snippet("고기 전문점, 매장 내 식사 가능, 오후 10:30분 영업종료")
                .icon(BitmapDescriptorFactory.fromBitmap(resizedBitmap)); // pink_marker 이미지 사용
        map.addMarker(bMarkerOptions);


        b = new LatLng(  37.39004, 126.9535);
        bMarkerOptions = new MarkerOptions()
                .position(b)
                .title("최군로바다야끼 범계점 ")
                .snippet("술집, 매장 내 식사 가능")
                .icon(BitmapDescriptorFactory.fromBitmap(resizedBitmap)); // pink_marker 이미지 사용
        map.addMarker(bMarkerOptions);

        b = new LatLng(  37.40130, 126.9738);
        bMarkerOptions = new MarkerOptions()
                .position(b)
                .title("크린토피아 인덕원역점")
                .snippet("세탁소, 오후 8시 영업종료")
                .icon(BitmapDescriptorFactory.fromBitmap(resizedBitmap)); // pink_marker 이미지 사용
        map.addMarker(bMarkerOptions);


        b = new LatLng(  37.40711, 126.9692);
        bMarkerOptions = new MarkerOptions()
                .position(b)
                .title("크릴리")
                .snippet("이탈리아 음식점, 매장 내 식사 가능, 오후 9시 영업종료")
                .icon(BitmapDescriptorFactory.fromBitmap(resizedBitmap)); // pink_marker 이미지 사용
        map.addMarker(bMarkerOptions);


        b = new LatLng( 37.39686, 126.9224);
        bMarkerOptions = new MarkerOptions()
                .position(b)
                .title("킹락볼링장 ")
                .snippet("볼링 시설, 오전 4시 영업종료")
                .icon(BitmapDescriptorFactory.fromBitmap(resizedBitmap)); // pink_marker 이미지 사용
        map.addMarker(bMarkerOptions);


        b = new LatLng(  37.39067, 126.9550);
        bMarkerOptions = new MarkerOptions()
                .position(b)
                .title("투파인드피터 범계점")
                .snippet("이탈리아 음식점, 매장 내 식사 및 포장 가능, 오후 11시 영업종료")
                .icon(BitmapDescriptorFactory.fromBitmap(resizedBitmap)); // pink_marker 이미지 사용
        map.addMarker(bMarkerOptions);


        b = new LatLng(  37.37943, 126.9596);
        bMarkerOptions = new MarkerOptions()
                .position(b)
                .title("파파롤")
                .snippet("제과점, 포장 가능, 오후 6시 영업종료")
                .icon(BitmapDescriptorFactory.fromBitmap(resizedBitmap)); // pink_marker 이미지 사용
        map.addMarker(bMarkerOptions);

        b = new LatLng(  37.38463, 126.9588);
        bMarkerOptions = new MarkerOptions()
                .position(b)
                .title("펜트리문구 평촌점")
                .snippet("문구점, 임시휴업")
                .icon(BitmapDescriptorFactory.fromBitmap(resizedBitmap)); // pink_marker 이미지 사용
        map.addMarker(bMarkerOptions);

        b = new LatLng(   37.39060, 126.9526);
        bMarkerOptions = new MarkerOptions()
                .position(b)
                .title("프로당구클럽")
                .snippet("당구장, 오전 2시 영업종료")
                .icon(BitmapDescriptorFactory.fromBitmap(resizedBitmap)); // pink_marker 이미지 사용
        map.addMarker(bMarkerOptions);

        b = new LatLng(  37.39031, 126.9504);
        bMarkerOptions = new MarkerOptions()
                .position(b)
                .title("교보핫트랙스 평촌점")
                .snippet("서점, 오후 8시 영업종료")
                .icon(BitmapDescriptorFactory.fromBitmap(resizedBitmap)); // pink_marker 이미지 사용
        map.addMarker(bMarkerOptions);

        b = new LatLng(  37.39993, 126.9189);
        bMarkerOptions = new MarkerOptions()
                .position(b)
                .title("해피리본")
                .snippet("이색제품 판매점, 오후 8시 영업종료")
                .icon(BitmapDescriptorFactory.fromBitmap(resizedBitmap)); // pink_marker 이미지 사용
        map.addMarker(bMarkerOptions);

        b = new LatLng(   37.39101, 126.9526);
        bMarkerOptions = new MarkerOptions()
                .position(b)
                .title("홍미집 범계직영점")
                .snippet("음식점, 매장 내 식사 및 포장 가능, 오후 11시 영업종료")
                .icon(BitmapDescriptorFactory.fromBitmap(resizedBitmap)); // pink_marker 이미지 사용
        map.addMarker(bMarkerOptions);



        map.moveCamera(CameraUpdateFactory.newLatLng(anyang));
        map.moveCamera(CameraUpdateFactory.newLatLngZoom(anyang,14));

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
        int width1 = 100; // 원하는 너비
        int height1 = 100; // 원하는 높이
        customMarkerBitmap = Bitmap.createScaledBitmap(customMarkerBitmap, width1, height1, false);

        return customMarkerBitmap;
    }
    private void addMarker(LatLng latLng) {

    }

    @Override
    public boolean onMyLocationButtonClick() {
        return false;
    }

    @Override
    public void onMyLocationClick(@NonNull Location location) {

    }
}