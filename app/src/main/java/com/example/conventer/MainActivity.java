package com.example.conventer;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import com.example.conventer.Api.NetworkUtils;
import com.example.conventer.Api.NetworkUtlsInteface;
import com.example.conventer.RecycleAdapter.MyAdapter;
import com.example.conventer.pojo.DailyCurrency;
import com.example.conventer.pojo.DailyCurrencyFile;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class MainActivity extends AppCompatActivity {


    private RecyclerView recyclerView;
    private MyAdapter adapter;
    private ArrayList<DailyCurrency> listOfCurrency;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initRecycleView();
    }

    public void initRecycleView() {
        recyclerView = findViewById(R.id.rv_currency);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        //Set adapter
        adapter = new MyAdapter();
        recyclerView.setAdapter(adapter);
        Download();
    }

    private void Download() {
        //Init request to server

        NetworkUtlsInteface apiService = NetworkUtils.getClient().create(NetworkUtlsInteface.class);
        Call<DailyCurrencyFile> call = apiService.getCurrencies();

        call.enqueue(new Callback<DailyCurrencyFile>() {
            @Override
            public void onResponse(Call<DailyCurrencyFile> call, Response<DailyCurrencyFile> response) {
                DailyCurrencyFile dailyCurrencyFile = response.body();

                ActivityConnect(dailyCurrencyFile);
                // filling RecycleView from internet

            }

            @Override
            public void onFailure(Call<DailyCurrencyFile> call, Throwable t) {
            }
        });

        Toast.makeText(this, "PLease, wait.Downloading file", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions,
                                           @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
    }

    private void ActivityConnect(DailyCurrencyFile dailyCurrencyFile) {

        listOfCurrency = new ArrayList<>(dailyCurrencyFile.getValute().values());
        adapter.setItems(listOfCurrency);

        //Currency was filled data
    }
}

