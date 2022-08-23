package com.gentech.recyclerviewretrofit;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    TextView applicantNameTvId;
    RecyclerView recyclerViewId;
    RecyclerViewAdp recyclerViewAdp;
    ArrayList<ResponseArray> responseArrayArrayList=new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

       applicantNameTvId=findViewById(R.id.applicantNameTvId);
        recyclerViewId=findViewById(R.id.recyclerViewId);

        Call<List<ResponseArray>> call = RetrofitClient.getInstance().getApi().getData();

        call.enqueue(new Callback<List<ResponseArray>>() {
            @Override
            public void onResponse(Call<List<ResponseArray>> call, Response<List<ResponseArray>> response) {
                List<ResponseArray> data =  response.body();

                if (response.isSuccessful()){
                    applicantNameTvId.setText(data.get(0).ApplicantName);

                    recyclerViewAdp=new RecyclerViewAdp(MainActivity.this,responseArrayArrayList);
                    recyclerViewId.setAdapter(recyclerViewAdp);

                }
                //set this List<ResponseArray> data to your RecycleView
            }

            @Override
            public void onFailure(Call<List<ResponseArray>> call, Throwable t) {
                System.out.println(t.getMessage());

            }
        });
    }
}