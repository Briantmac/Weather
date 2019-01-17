package brian.com.weather.CallBack;

/**
 * Created by Brian on 2019/1/3.
 */
public interface CallBack {

    void onSuccess(String param);

    void onFailure(String param);

    void onError();

    void onComplete();
}
