package le1779.bikerecorder.ui.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;
import java.util.List;

import le1779.bikerecorder.ui.fragment.MapRecorderFragment;

public class ViewPagerAdapter extends FragmentPagerAdapter {

    private List<Fragment> fragmentList = new ArrayList<>();

    public ViewPagerAdapter(FragmentManager fm) {
        super(fm);

        this.fragmentList.add(new MapRecorderFragment());
        this.fragmentList.add(new MapRecorderFragment());
        this.fragmentList.add(new MapRecorderFragment());
    }

    @Override
    public int getCount() {
        return 3;
    }

    @Override
    public Fragment getItem(int position) {
        return fragmentList.get(position);
    }
}
