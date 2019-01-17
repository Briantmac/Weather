package brian.com.weather.View;

/**
 * Created by Brian on 2019/1/3.
 */
public interface MvpView {

    /**
     * 显示加载
     */
    void showLoading();

    /**
     * 隐藏加载进度框
     */
    void hideLoading();

    /**
     * 显示网络请求结果
     */
    void showMessage(String data);

    void showErrorMessage();

}
