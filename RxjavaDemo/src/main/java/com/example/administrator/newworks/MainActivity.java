package com.example.administrator.newworks;

import android.os.AsyncTask;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.administrator.Adapter.RecyclerAdapter;
import com.jakewharton.rxbinding.view.RxView;
import com.jakewharton.rxbinding.widget.AdapterViewItemClickEvent;
import com.jakewharton.rxbinding.widget.RxAdapterView;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.Call;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import rx.Observable;
import rx.Subscriber;
import rx.Subscription;
import rx.functions.Action1;
import rx.functions.Func1;
import rx.observables.GroupedObservable;
import rx.schedulers.Schedulers;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        RecyclerView rv = (RecyclerView) findViewById(R.id.rv);
        assert rv != null;
        rv.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));
        rv.setHasFixedSize(true);
        rv.setItemAnimator(new DefaultItemAnimator());
        RecyclerAdapter recyclerAdapter = new RecyclerAdapter(this);
        rv.setAdapter(recyclerAdapter);

//        getData().subscribeOn(Schedulers.io()).subscribe(new Subscriber<String>() {
//            @Override
//            public void onCompleted() {
//
//            }
//
//            @Override
//            public void onError(Throwable e) {
//
//            }
//
//            @Override
//            public void onNext(String s) {
//
//            }
//        });
//       Test();
    }
    private  Observable<String> getData(){
        return  Observable.create(new Observable.OnSubscribe<String>() {
            @Override
            public void call(Subscriber<? super String> subscriber) {
                OkHttpClient okHttpClient=new OkHttpClient();
                Request request=new Request.Builder().url("https://www.baidu.com/").build();
                try {
                    Response execute = okHttpClient.newCall(request).execute();
                    if (execute.isSuccessful()){
                        String string = execute.body().string();
                        int i=0;
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        });
    }
    private  void Test(){
        Observable.just(1,2,3,4).groupBy(new Func1<Integer, String>() {
            @Override
            public String call(Integer integer) {
                return integer%2==0?"偶数":"奇数";
            }
        }).subscribe(new Action1<GroupedObservable<String, Integer>>() {
            @Override
            public void call(GroupedObservable<String, Integer> stringIntegerGroupedObservable) {
                Log.e("TAG",stringIntegerGroupedObservable.getKey());
                stringIntegerGroupedObservable.subscribe(new Action1<Integer>() {
                    @Override
                    public void call(Integer integer) {
                        Log.e("TAG",integer+"");

                    }
                });

            }
        });

    }

}
