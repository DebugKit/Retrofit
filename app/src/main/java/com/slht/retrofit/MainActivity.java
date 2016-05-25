package com.slht.retrofit;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Observer;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class MainActivity extends AppCompatActivity {

    private static final String BASE_URL = "http://apis.baidu.com";
    private static final String API_KEY = "64dd495965f1096862fa19509155a85c";


    private EditText editText;
    private Button button;
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = (EditText) findViewById(R.id.edittext);
        button = (Button) findViewById(R.id.button);
        textView = (TextView) findViewById(R.id.textview);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                query();
            }
        });
    }

    private void query() {
        Subscriber subscriber = new Subscriber<MoveEntity>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {
                System.out.println("----------------------"+e.getMessage());
            }

            @Override
            public void onNext(MoveEntity moveEntity) {
                for (MoveEntity.Subjects s : moveEntity.getSubjects()) {
                    Log.d("MainActivity", s.getTitle());
                }
            }
        };

        HttpMethods.getInstance().getTopMove(subscriber, 0, 10);
    }


//    private void query() {
//        //创建Retrofit对象
//        Retrofit retrofit = new Retrofit.Builder()
//                .baseUrl(BASE_URL)//地址
//                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
//                .addConverterFactory(GsonConverterFactory.create())//解析方法
//                .build();
//
//        //创建访问API的请求
//        PhoneService service = retrofit.create(PhoneService.class);
//        Call<PhoneResult> call = service.getResult(API_KEY, editText.getText().toString().trim());
//
//        service.getPhoneResult(API_KEY,editText.getText().toString().trim())
//                .subscribeOn(Schedulers.newThread())
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribe(new Observer<PhoneResult>() {
//                    @Override
//                    public void onCompleted() {
//
//                    }
//
//                    @Override
//                    public void onError(Throwable e) {
//
//                    }
//
//                    @Override
//                    public void onNext(PhoneResult phoneResult) {
//                        if (phoneResult!=null && phoneResult.getErrNum()==0){
//                            PhoneResult.RetDataPhoneResult entity = phoneResult.getRetData();
//                            textView.setText(entity.getProvince() + " " + entity.getSupplier());
//                        }
//                    }
//                });
//
//
//
//        //发送请求
////        call.enqueue(new Callback<PhoneResult>() {
////            @Override
////            public void onResponse(Call<PhoneResult> call, Response<PhoneResult> response) {
////                if (response.isSuccessful()) {
////                    PhoneResult result = response.body();
////                    if (result != null) {
////                        PhoneResult.RetDataPhoneResult entiry = result.getRetData();
////                        textView.setText(entiry.getProvince() + " " + entiry.getSupplier());
////                    }
////                }
////            }
////
////            @Override
////            public void onFailure(Call<PhoneResult> call, Throwable t) {
////                Log.d("MainActivity", t.getMessage());
////            }
////        });
//    }


}
