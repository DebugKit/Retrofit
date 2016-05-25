package com.slht.retrofit;


import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by LI on 2016/5/24.
 */
public interface MoveService {

    @GET("top250")
    Observable<MoveEntity> getTopMove(@Query("start") int start, @Query("count") int count);
}
