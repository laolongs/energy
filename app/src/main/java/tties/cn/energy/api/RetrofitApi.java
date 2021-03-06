package tties.cn.energy.api;


import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import tties.cn.energy.application.Content;
import tties.cn.energy.common.Constants;

/**
 *
 *
 * 将Retrofit封装起来，返回Api
 */

public class RetrofitApi {

    static class RetrofitInstance {
        private static OkHttpClient okHttpClient = new OkHttpClient().newBuilder().addInterceptor(new ReadCookiesInterceptor()).addInterceptor(new SaveCookiesInterceptor()).build();
        private static Api api = new Retrofit.Builder()
                .baseUrl(Constants.BASE_RUL)
                .client(okHttpClient)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(Api.class);
    }

    //得到Server对象
    public static Api getServer() {
        return RetrofitInstance.api;
    }

}
