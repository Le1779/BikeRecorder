package le1779.bikerecorder.ui.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import le1779.bikerecorder.R;
import le1779.bikerecorder.presenter.MapRecorderPresenter;
import le1779.bikerecorder.presenter.contract.MapRecorderContract;

public class MapRecorderFragment extends Fragment implements OnMapReadyCallback, MapRecorderContract.View{

    private View viewCourse;
    private GoogleMap mMap;
    private MapRecorderPresenter prestenter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        viewCourse = inflater.inflate(R.layout.fragment_map_recorder,container, false);

        prestenter = new MapRecorderPresenter(this);
        SupportMapFragment mapFragment = (SupportMapFragment) getChildFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        return viewCourse;
    }

    @Override
    public void onResume(){
        super.onResume();
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        // Add a marker in Sydney and move the camera
        LatLng sydney = new LatLng(-34, 151);
        mMap.addMarker(new MarkerOptions().position(sydney).title("Marker in Sydney"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));
    }


}

