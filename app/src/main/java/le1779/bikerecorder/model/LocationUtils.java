package le1779.bikerecorder.model;

import android.app.Activity;
import android.content.Context;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.util.Log;

public class LocationUtils implements LocationListener {

    public static final int LOCATION_UPDATE_MIN_DISTANCE = 10;
    public static final int LOCATION_UPDATE_MIN_TIME = 5000;
    private static LocationManager mLocationManager;
    private static OnLocationCallback onLocationCallback;
    public void setOnLocationCallback(OnLocationCallback listener){
        onLocationCallback = listener;
    }
    private Activity activity;

    public LocationUtils(Activity activity) {
        this.activity = activity;
        mLocationManager = (LocationManager) activity.getSystemService(Context.LOCATION_SERVICE);
    }

    public void getLocation(){
        boolean isGPSEnabled = mLocationManager.isProviderEnabled(LocationManager.GPS_PROVIDER);
        boolean isNetworkEnabled = mLocationManager.isProviderEnabled(LocationManager.NETWORK_PROVIDER);

        Location location = null;
        if (!(isGPSEnabled || isNetworkEnabled))
            onLocationCallback.onLocationError();
        else {
            if (PermissionUtils.instance().with(activity).check()) {
                if (isNetworkEnabled) {
                    mLocationManager.requestLocationUpdates(LocationManager.NETWORK_PROVIDER,
                            LOCATION_UPDATE_MIN_TIME, LOCATION_UPDATE_MIN_DISTANCE, this);
                    location = mLocationManager.getLastKnownLocation(LocationManager.NETWORK_PROVIDER);
                }

                if (isGPSEnabled) {
                    mLocationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER,
                            LOCATION_UPDATE_MIN_TIME, LOCATION_UPDATE_MIN_DISTANCE, this);
                    location = mLocationManager.getLastKnownLocation(LocationManager.GPS_PROVIDER);
                }
            }
        }
        if (location != null)
            if(onLocationCallback!=null) {
                onLocationCallback.onLocation(location);
            }
    }

    @Override
    public void onLocationChanged(Location location) {
        if (location != null) {
            Log.d("gps", String.format("%f, %f", location.getLatitude(), location.getLongitude()));
            //drawMarker(location);
            //mLocationManager.removeUpdates(mLocationListener);
            onLocationCallback.onLocation(location);
        } else {
            Log.d("gps", "Location is null");
        }
    }

    @Override
    public void onStatusChanged(String s, int i, Bundle bundle) {

    }

    @Override
    public void onProviderEnabled(String s) {

    }

    @Override
    public void onProviderDisabled(String s) {

    }

    public interface OnLocationCallback {
        void onLocation(Location location);

        void onLocationError();
    }
}
