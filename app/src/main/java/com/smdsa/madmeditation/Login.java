package com.smdsa.madmeditation;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
import com.smdsa.madmeditation.retro.ApiInterface;
import com.smdsa.madmeditation.retro.login;
import java.util.HashMap;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Login extends AppCompatActivity {

    private EditText ETlogin, ETpassword;
    private String login, password;
    private HashMap<String,String> hashMap;
    private ApiInterface apiInterface;
    private Retrofit retrofit;
    private Call<login> call;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ETlogin = findViewById(R.id.login);
        ETpassword = findViewById(R.id.password);
        login = ETlogin.getText().toString();
        password = ETpassword.getText().toString();
        hashMap = new HashMap<String,String>();
        retrofit = new Retrofit.Builder()
                .baseUrl("http://mskko2021.mad.hakta.pro/api/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    public void onClick(View view){
        login = ETlogin.getText().toString();
        password = ETpassword.getText().toString();
        hashMap.put("email",login);
        hashMap.put("password",password);
        apiInterface = retrofit.create(ApiInterface.class);
        call = apiInterface.getAuth(hashMap);
        call.enqueue(new Callback<com.smdsa.madmeditation.retro.login>() {
            @Override
            public void onResponse(Call<com.smdsa.madmeditation.retro.login> call, Response<com.smdsa.madmeditation.retro.login> response) {
                if(response.code() == 200){
                    Toast.makeText(Login.this, "YEAH", Toast.LENGTH_SHORT).show();
                }
                else{
                    Toast.makeText(Login.this, "Неверный логин или пароль", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<com.smdsa.madmeditation.retro.login> call, Throwable t) {
                Toast.makeText(Login.this, "NOO", Toast.LENGTH_SHORT).show();
            }
        });
    }
}