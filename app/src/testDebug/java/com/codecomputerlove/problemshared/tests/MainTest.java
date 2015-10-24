package com.codecomputerlove.problemshared.module.main.interactor;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.MockitoAnnotations;


/**
 * Created by ryanjohnstone on 19/06/15.
 */
public class MainTest {

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testSuccessfulLogin() {

        MainInteractor mainInteractor = new MainInteractorImpl();
        Assert.assertEquals(true, true);
    }

}