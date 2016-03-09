package com.nexters.taigerapp.network.service;

import android.test.suitebuilder.annotation.SmallTest;

import com.nexters.taigerapp.network.response.model.AuthResult;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsNull.nullValue;

public class UserServiceTest {

    private UserService userService;

    @Before
    public void setUp(){
        userService = new UserService.Factory().create();
    }

    @Test
    public void test_ok(){
        AuthResult authResult = userService.login("test");

        assertThat(authResult, nullValue());
    }
}
