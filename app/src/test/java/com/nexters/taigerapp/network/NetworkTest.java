package com.nexters.taigerapp.network;

import com.nexters.taigerapp.network.response.model.AuthResult;
import com.nexters.taigerapp.network.service.NetworkService;
import com.nexters.taigerapp.network.service.UserService;

import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Response;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsNull.notNullValue;
import static org.hamcrest.core.IsNull.nullValue;

public class NetworkTest {

    private NetworkService networkService;

    @Before
    public void setUp(){
        networkService = new NetworkService.Factory().create();
    }

    @Test
    public void test_getIp() throws IOException {
        Call<Map<String, String>> call = networkService.getIp();

        Response<Map<String, String>> response = call.execute();
        assertThat(response.body().get("ip"), notNullValue());
    }
}
