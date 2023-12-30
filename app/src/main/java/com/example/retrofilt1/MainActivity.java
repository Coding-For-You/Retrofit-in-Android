package com.example.retrofilt1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.example.retrofilt1.api.APIClient;
import com.example.retrofilt1.model.UserModel;
import com.example.retrofilt1.model.UserModelItem;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.textview);
        Call<List<UserModelItem>> call = APIClient.getInstance().getApi().getUserData();
        call.enqueue(new Callback<List<UserModelItem>>() {
            @Override
            public void onResponse(Call<List<UserModelItem>> call, Response<List<UserModelItem>> response) {

                if (response.isSuccessful()){
                    Toast.makeText(MainActivity.this, "Successfully get data", Toast.LENGTH_SHORT).show();
                    List<UserModelItem> userModel = response.body();
                    for (int i=0 ; i<userModel.size() ; i++){
                        textView.append(""+userModel.get(i).getId()+"\n");
                    }

                }

            }

            @Override
            public void onFailure(Call<List<UserModelItem>> call, Throwable t) {

            }
        });




    }
}