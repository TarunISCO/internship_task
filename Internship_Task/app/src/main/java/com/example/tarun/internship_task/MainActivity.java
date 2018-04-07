package com.example.tarun.internship_task;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.ImageView;

import java.util.List;

import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private static final String LOG_TAG = MainActivity.class.getSimpleName();
    private CountryAdapter mAdapter;
    private RecyclerView recyclerView;
    private ImageView imageView;
    private String fullScreenInd;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ApiInterface apiInterface = ApiClient.getClient().create(ApiInterface.class);
        recyclerView = (RecyclerView) findViewById(R.id.countries_list_view);

        retrofit2.Call<UrlResponse> call = apiInterface.getCountries();
        call.enqueue(new Callback<UrlResponse>() {
            @Override
            public void onResponse(retrofit2.Call<UrlResponse> call, Response<UrlResponse> response) {
                List<Country> countries = response.body().getCountries();
                Log.d(LOG_TAG, "Total countries fetched: " + countries.size());
                mAdapter = new CountryAdapter(countries, getApplicationContext());
                RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
                recyclerView.setLayoutManager(layoutManager);
                recyclerView.setItemAnimator(new DefaultItemAnimator());
                recyclerView.setAdapter(mAdapter);

            }

            @Override
            public void onFailure(retrofit2.Call<UrlResponse> call, Throwable t) {
                Log.e(LOG_TAG, t.toString());
            }
        });


    }
}
