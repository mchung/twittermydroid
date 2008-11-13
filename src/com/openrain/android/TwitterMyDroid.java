package com.openrain.android;

import java.io.IOException;

import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.DefaultHttpClient;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

public class TwitterMyDroid extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
    	super.onCreate(savedInstanceState);
    	TextView tv = new TextView(this);

    	DefaultHttpClient httpclient = new DefaultHttpClient();
    	HttpGet httpget = new HttpGet("http://twitter.com/statuses/public_timeline.xml");
    	String responseBody = "<fail!>";
    	try {
    	    ResponseHandler<String> responseHandler = new BasicResponseHandler();
    	    responseBody = httpclient.execute(httpget, responseHandler);
    	} catch (ClientProtocolException e) {
    		// TODO Auto-generated catch block
    		e.printStackTrace();
    	} catch (IOException e) {
    		// TODO Auto-generated catch block
    		e.printStackTrace();
    	}
    	tv.setText(responseBody);
    	setContentView(tv);
    }
}

