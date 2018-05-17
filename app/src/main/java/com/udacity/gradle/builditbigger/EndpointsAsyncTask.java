package com.udacity.gradle.builditbigger;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import com.google.api.client.extensions.android.http.AndroidHttp;
import com.google.api.client.extensions.android.json.AndroidJsonFactory;
import com.google.api.client.googleapis.services.AbstractGoogleClientRequest;
import com.google.api.client.googleapis.services.GoogleClientRequestInitializer;
import com.udacity.gradle.builditbigger.backend.myApi.MyApi;
import java.io.IOException;
import io.github.mpao.show_joke_lib.JokeActivity;

public class EndpointsAsyncTask extends AsyncTask<Context, Void, String> {

    private static MyApi endpoint = null;
    private Context context;

    @Override
    protected String doInBackground(Context... params) {

        if(endpoint == null) {  // Only do this once
            MyApi.Builder builder = new MyApi.Builder(AndroidHttp.newCompatibleTransport(),
                    new AndroidJsonFactory(), null)
                    .setRootUrl("http://10.0.2.2:8080/lol/api/")
                    .setGoogleClientRequestInitializer(new GoogleClientRequestInitializer() {
                        @Override
                        public void initialize(AbstractGoogleClientRequest<?> abstractGoogleClientRequest) {
                            abstractGoogleClientRequest.setDisableGZipContent(true);
                        }
                    });
            endpoint = builder.build();
        }

        context = params[0];

        try {
            return endpoint.getJoke().execute().getJoke();
        } catch (IOException e) {
            return e.getMessage();
        }

    }

    @Override
    protected void onPostExecute(String result) {

        Intent intent = new Intent(context, JokeActivity.class);
        intent.putExtra("joke", result);
        context.startActivity(intent);

    }

}
