package com.example.retrofit_user;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    Recycler_Adapter adapter;
    List<ViewProduct> resposeList = new ArrayList<ViewProduct>();
    ArrayList<Model_Class> modellist = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new Recycler_Adapter(MainActivity.this,modellist);
        recyclerView.setAdapter(adapter);

        Instance_Class.CallAPI().showProducts().enqueue(new Callback<List<ViewProduct>>() {
            @Override
            public void onResponse(Call<List<ViewProduct>> call, Response<List<ViewProduct>> response) {
                Log.d("AAA", "onResponse: "+response.body().get(0).getName().toString());
                resposeList = response.body();

                for (int i = 0; i < resposeList.size(); i++)
                {
                    String name = response.body().get(i).getName();
                    String street = response.body().get(i).getAddress().getStreet();
                    String lat = response.body().get(i).getAddress().getGeo().getLat();
                    String lng = response.body().get(i).getAddress().getGeo().getLng();
                    Model_Class model = new Model_Class(name,street,lat,lng);
                    modellist.add(model);
                    adapter.notifyDataSetChanged();
                }
            }

            @Override
            public void onFailure(Call<List<ViewProduct>> call, Throwable t) {
                Log.e("AAA", "onResponse: Error="+t.getLocalizedMessage());
            }
        });
    }
}