package com.px.rxandroiddmeo;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ImageView;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;



public class MainActivity extends AppCompatActivity {

    String TAG = MainActivity.class.getSimpleName();
    private ImageView img;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        //观察者
        final Observer<String> observer = new Observer<String>()
        {

            @Override
            public void onSubscribe(@NonNull Disposable d)
            {
            }

            @Override
            public void onNext(@NonNull String s)
            {

                Log.e(TAG,"item = "+s);
            }

            @Override
            public void onError(@NonNull Throwable e)
            {
                Log.e("TTT","e = "+e.toString());
            }

            @Override
            public void onComplete()
            {
                Log.e(TAG,"........ = finish");
            }
        };

//        Observable observable = Observable.create(new ObservableOnSubscribe()
//        {
//            @Override
//            public void subscribe(@NonNull ObservableEmitter e) throws Exception
//            {
//                observer.onNext("Hello");
//                observer.onNext("Hi");
//                observer.onNext("Aloha");
//                observer.onComplete();
//            }
//        });
        String [] names = {"张龙","赵虎","王朝","马汉","牛津","剑桥"};
//        Observable.just("张龙","赵虎","王朝","马汉").subscribe(observer);
//        Observable.fromArray(names).subscribe(observer);
//        Observable.fromArray(names).subscribe(new Consumer<String>()
//        {
//            @Override
//            public void accept(@NonNull String s) throws Exception
//            {
//                Log.e("TTT","item = "+s);
//            }
//        });
        img = (ImageView) findViewById(R.id.imageView);
        Observable.just(R.mipmap.ic_launcher).map(new Function<Integer, Bitmap>()
        {
            @Override
            public Bitmap apply(@NonNull Integer s) throws Exception
            {
                return BitmapFactory.decodeResource(getResources(),s);
            }
        })

                .subscribe(new Consumer<Bitmap>()
        {
            @Override
            public void accept(@NonNull Bitmap bitmap) throws Exception
            {
                img.setImageBitmap(bitmap);
            }
        });


        //最普通的的
       /* Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://www.weather.com.cn/data/sk/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        IWeather userBiz = retrofit.create(IWeather.class);

        Call<WeatherInfo> call = userBiz.getWeather();
        call.enqueue(new Callback<WeatherInfo>()
        {

            @Override
            public void onResponse(Call<WeatherInfo> call, Response<WeatherInfo> response)
            {
                Log.e(TAG, "data:" + response.body().toString() + "");
            }

            @Override
            public void onFailure(Call<WeatherInfo> call, Throwable t)
            {

            }
        });*/


        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://www.weather.com.cn/data/sk/")
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();

        RxWeather rxWeather = retrofit.create(RxWeather.class);
        Observable<WeatherInfo> weather = rxWeather.getWeather();

        weather
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<WeatherInfo>()
                {
                    @Override
                    public void accept(@NonNull WeatherInfo weatherInfo) throws Exception
                    {
                        Log.e(TAG,"weather = "+weatherInfo.toString());
                    }
                });
    }
}
