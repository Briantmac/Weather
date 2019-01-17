package brian.com.weather.Activity;

import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import brian.com.weather.Presenter.MvpPresenter;
import brian.com.weather.R;
import brian.com.weather.View.MvpView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity  implements MvpView {


    @OnClick(R.id.bt_success)
    public void onclickSuccess(){
        Log.v("onclickSuccess","第一次");
        mvpPresenter.getData("normal");
    }
    @OnClick(R.id.bt_failure)
    public void onclickFailure(){
        mvpPresenter.getData("failure");
    }
    @OnClick(R.id.bt_error)
    public void onclickError(){
        mvpPresenter.getData("error");
    }




    @BindView(R.id.tv_message)
    TextView tv_message;
//    @BindView(R.id.bt_success)
//    Button bt_success;
//    @BindView(R.id.bt_failure)
//    Button bt_failure;
//    @BindView(R.id.bt_error)
//    Button bt_error;

    MvpPresenter mvpPresenter;
    ProgressDialog progressDialog;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("正在加载中...");
        progressDialog.setCancelable(false);
        mvpPresenter = new MvpPresenter(this);
        ButterKnife.bind(this);
//        onclick();
    }

//    public void onclick(){
//        bt_success.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                mvpPresenter.getData("normal");
//            }
//        });
//        bt_failure.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                mvpPresenter.getData("failure");
//            }
//        });
//        bt_error.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                mvpPresenter.getData("error");
//            }
//        });
//    }

    @Override
    public void showLoading() {
        if (!progressDialog.isShowing()) {
            progressDialog.show();
        }
    }

    @Override
    public void hideLoading() {
        if (progressDialog.isShowing()) {
            progressDialog.dismiss();
        }
    }

    @Override
    public void showMessage(String data) {
        tv_message.setText(data);
    }

    @Override
    public void showErrorMessage() {
        Toast.makeText(this, "网络请求数据出现异常", Toast.LENGTH_SHORT).show();
        tv_message.setText("网络请求数据出现异常");
    }
}
