package brian.com.weather.Model;

import android.os.Handler;

import brian.com.weather.CallBack.CallBack;

/**
 * Created by Brian on 2019/1/3.
 */
public class Model {

    public static void getData(final String param, final CallBack callBack){
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                switch (param){
                    case "normal":
                        callBack.onSuccess("网络请求成功");
                        break;
                    case "failure":
                        callBack.onFailure("请求失败，参数有误");
                        break;
                    case "error":
                        callBack.onError();
                }
                callBack.onComplete();
            }
        },2000);
    }
}
