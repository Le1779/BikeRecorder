package le1779.bikerecorder.presenter;

import le1779.bikerecorder.presenter.contract.MapRecorderContract;

public class MapRecorderPresenter implements MapRecorderContract.Presenter {

    MapRecorderContract.View view;

    public MapRecorderPresenter(MapRecorderContract.View view){
        this.view = view;
    }
}
