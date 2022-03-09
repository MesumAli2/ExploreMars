package com.mesum.ExploreMars;

import com.squareup.moshi.Moshi;
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory;

import java.util.List;

import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.moshi.MoshiConverterFactory;
import retrofit2.http.GET;

public class ServiceGenerator {

    private static final String BASE_URL = "https://android-kotlin-fun-mars-server.appspot.com";

    private static Moshi moshi = new Moshi.Builder()
            .add(new KotlinJsonAdapterFactory())
            .build();

    private static Retrofit.Builder builder =
            new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(MoshiConverterFactory.create(moshi));

    private static Retrofit retrofit = builder.build();

    public interface TaskService {
        @GET("realestate")
        Call<List<MarsModel>> getPhotos();
    }

    private static OkHttpClient.Builder httpClient =
            new OkHttpClient.Builder();

    public static <S> S createService(
            Class<S> serviceClass) {
        return retrofit.create(serviceClass);
    }
}
