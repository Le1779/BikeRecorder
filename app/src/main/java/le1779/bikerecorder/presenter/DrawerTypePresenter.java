package le1779.bikerecorder.presenter;

import le1779.bikerecorder.presenter.contract.DrawerTypeContract;

public class DrawerTypePresenter implements DrawerTypeContract.Presenter {

    DrawerTypeContract.View view;

    public DrawerTypePresenter(DrawerTypeContract.View view){
        this.view = view;
    }
}
