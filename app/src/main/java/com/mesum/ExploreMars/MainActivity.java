package com.mesum.ExploreMars;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.facebook.drawee.backends.pipeline.Fresco;

import java.util.List;

import ExploreMars.R;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity  {

    private RecyclerView recyclerView;
    private  MarsAdapter adapter;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.marsRecycler);
        adapter = new MarsAdapter(MarsAdapter.DIFF_CALLBACK, getApplicationContext());

        Fresco.initialize(this);

        ServiceGenerator.TaskService taskService = ServiceGenerator.createService(ServiceGenerator.TaskService.class);
        Call<List<MarsModel>> call = taskService.getPhotos();
        call.enqueue(new Callback<List<MarsModel>>() {
            @Override
            public void onResponse(Call<List<MarsModel>> call, Response<List<MarsModel>> response) {
                if(response.isSuccessful()){
                    adapter.submitList(response.body());
                    recyclerView.setAdapter(adapter);
                    recyclerView.setLayoutManager(new GridLayoutManager(MainActivity.this, 2));
                }
            }

            @Override
            public void onFailure(Call<List<MarsModel>> call, Throwable t) {

            }
        });



    }



}
