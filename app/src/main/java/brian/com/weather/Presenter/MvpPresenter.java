package brian.com.weather.Presenter;

import brian.com.weather.CallBack.CallBack;
import brian.com.weather.Model.Model;
import brian.com.weather.View.MvpView;

/**
 * Created by Brian on 2019/1/3.
 */
public class MvpPresenter {

    MvpView mvpView;

    public MvpPresenter(MvpView mvpView){
        this.mvpView = mvpView;
    }

    public void getData(String param){
        mvpView.showLoading();

        Model.getData(param, new CallBack() {
            @Override
            public void onSuccess(String param) {
                mvpView.showMessage(param);
            }

            @Override
            public void onFailure(String param) {
                mvpView.showMessage(param);
            }

            @Override
            public void onError() {
                mvpView.showErrorMessage();
            }

            @Override
            public void onComplete() {
                mvpView.hideLoading();
            }
        });

    }


}
