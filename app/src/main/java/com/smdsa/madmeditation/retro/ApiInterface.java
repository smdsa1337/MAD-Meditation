package com.smdsa.madmeditation.retro;

import java.util.HashMap;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface ApiInterface {
    @POST("user/login")
    Call<login> getAuth(@Body HashMap<String, String> hashMap);
}
