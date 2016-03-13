package com.nexters.taigerapp.network;

import com.nexters.taigerapp.network.service.TestService;

import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Response;

public class TestServiceTest {
    private TestService testService;

    @Before
    public void setUp(){
        testService = new TestService.Factory().create();
    }

    @Test
    public void test_getVendorItemId() throws IOException {
        for(int i=1; i<10; i++) {
            Call<Map<String, String>> call = testService.getVendorItemId("" + i);
            Response<Map<String, String>> response = call.execute();
            if(response.body().get("productId") != null){
                System.out.println(response.body().get("productId"));
            }
        }
    }
}
