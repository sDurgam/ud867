package com.udacity.gradle.builditbigger;

import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import junit.framework.TestCase;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.concurrent.ExecutionException;

/**
 * Created by root on 9/20/16.
 */
@RunWith(AndroidJUnit4.class)
public class EndpointAsyncTaskTest extends TestCase {

    @Rule
    public ActivityTestRule<MainActivity> mActivityRule =
            new ActivityTestRule<>(MainActivity.class, true, true);


    @Test
    public void buttonShouldUpdateText() throws ExecutionException, InterruptedException {

        String result = null;
        EndpointAsyncTask jokeTask = new EndpointAsyncTask();
        result = jokeTask.execute(mActivityRule.getActivity()).get();
        Assert.assertNotNull(result);
        Assert.assertTrue(result.length() > 0);
    }

    @Override
    protected void tearDown() throws Exception {
        super.tearDown();
    }
}
