package le1779.bikerecorder.model;

import android.Manifest;
import android.app.Activity;
import android.content.pm.PackageManager;
import android.support.v4.app.ActivityCompat;

public class PermissionUtils {

    private static PermissionUtils permissionUtils;
    private Activity activity;

    public PermissionUtils(){

    }

    public static PermissionUtils instance() {
        if (permissionUtils == null) {
            synchronized (PermissionUtils.class) {
                if (permissionUtils == null) {
                    permissionUtils = new PermissionUtils();
                }
            }
        }
        return permissionUtils;
    }

    public PermissionUtils with(Activity activity) {
        this.activity = activity;
        return this;
    }

    public Boolean check() {
        if (ActivityCompat.checkSelfPermission(activity, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(activity, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            return false;
        }
        return true;
    }


    public interface OnPermissionCallback {
        void onRequestAllow(String permissionName);

        void onRequestRefuse(String permissionName);

        void onRequestNoAsk(String permissionName);
    }
}
