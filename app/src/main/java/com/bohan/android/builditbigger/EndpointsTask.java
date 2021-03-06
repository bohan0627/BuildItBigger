package com.bohan.android.builditbigger;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import com.bohan.android.jokesandroidlibrary.JokeDisplayActivity;
import com.google.api.client.extensions.android.http.AndroidHttp;
import com.google.api.client.extensions.android.json.AndroidJsonFactory;
import com.google.api.client.googleapis.services.AbstractGoogleClientRequest;
import com.google.api.client.googleapis.services.GoogleClientRequestInitializer;
import com.udacity.gradle.builditbigger.backend.myApi.MyApi;
import java.io.IOException;

/**
 * Created by Bo Han.
 */
public class EndpointsTask extends AsyncTask<Context, Void, String> {
    public static MyApi myApiService = null;
    private Context context;
    String text;

    @Override
    protected String doInBackground(Context...params) {
        if(myApiService == null) {
            MyApi.Builder builder = new MyApi.Builder(AndroidHttp.newCompatibleTransport(),
                    new AndroidJsonFactory(), null)
                    .setRootUrl("http://10.0.2.2:8080/_ah/api/")
                    .setGoogleClientRequestInitializer(new GoogleClientRequestInitializer() {
                        @Override
                        public void initialize(AbstractGoogleClientRequest<?> abstractGoogleClientRequest) throws IOException {
                            abstractGoogleClientRequest.setDisableGZipContent(true);
                        }
                    });
            myApiService = builder.build();
        }
        context = params[0];
        try {
            return myApiService.getRandomJokeService().execute().getData();
        } catch (IOException e) {
            return e.getMessage();
        }
    }

    @Override
    protected void onPostExecute(String result) {
        final Intent intent = new Intent(context, JokeDisplayActivity.class);
        //boolean b = result == null;
        //System.out.println("result is: " + b );
        intent.putExtra("result",result);
        context.startActivity(intent);
    }
}


