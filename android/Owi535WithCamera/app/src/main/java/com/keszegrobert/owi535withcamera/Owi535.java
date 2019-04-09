package com.keszegrobert.owi535withcamera;


import android.net.Uri;
import android.os.AsyncTask;
import android.util.Log;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;

class Owi535 {
    private String TAG="OWI535";

    public void rotateBaseClockwise() {
        new RobotTask("base", 1).execute();
        Log.d(this.TAG,"base+");
    }

    public void rotateBaseAntiClockwise() {
        new RobotTask("base", -1).execute();
        Log.d(this.TAG,"base-");
    }

    public void rotateShoulderClockwise() {
        new RobotTask("shoulder", 1).execute();
        Log.d(this.TAG,"shoulder+");
    }

    public void rotateShoulderAntiClockwise() {
        new RobotTask("shoulder", -1).execute();
        Log.d(this.TAG,"shoulder-");
    }

    public void rotateElbowClockwise() {
        new RobotTask("elbow", 1).execute();
        Log.d(this.TAG,"elbow+");
    }

    public void rotateElbowAntiClockwise() {
        new RobotTask("elbow", -1).execute();
        Log.d(this.TAG,"elbow-");
    }

    public void rotateWristClockwise() {
        new RobotTask("wrist", 1).execute();
        Log.d(this.TAG,"wrist+");
    }

    public void rotateWristAntiClockwise() {
        new RobotTask("wrist", -1).execute();
        Log.d(this.TAG,"wrist-");
    }

    public void openGrip() {
        new RobotTask("grip", 1).execute();
        Log.d(this.TAG,"grip+");
    }

    public void closeGrip() {
        new RobotTask("grip", -1).execute();
        Log.d(this.TAG,"grip-");
    }

    public void switchLedOn(){
        new RobotTask("led", 1).execute();
        Log.d(TAG, "LED On");
    }
    public void switchLedOff(){
        new RobotTask("led", 0).execute();
        Log.d(TAG, "LED Off");
    }


    private class RobotTask extends AsyncTask<Void,Void, Void> {
        private static final String SERVER_ADDRESS = "http://192.168.0.33:5351/task";
        String operation;
        int direction;

        public RobotTask(String operation, int direction){
            this.operation = operation;
            this.direction = direction;
        }

        @Override
        protected Void doInBackground(Void... voids) {
            HttpURLConnection connection = null;
            Uri.Builder builder = new Uri.Builder()
                    .appendQueryParameter("part", this.operation)
                    .appendQueryParameter("dir", String.format("%d", this.direction));

            String query = builder.build().getEncodedQuery();
            try {
                URL url = new URL(SERVER_ADDRESS);
                HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
                urlConnection.setRequestMethod("POST");
                urlConnection.connect();
                byte[] outputBytes = query.getBytes("UTF-8");
                OutputStream os = urlConnection.getOutputStream();
                os.write(outputBytes);
                os.close();

                /* Get Response and execute WebService request*/
                int statusCode = urlConnection.getResponseCode();

                /* 200 represents HTTP OK */
                if (statusCode == HttpsURLConnection.HTTP_OK) {

                    InputStream inputStream = new BufferedInputStream(urlConnection.getInputStream());
                    //ResponseData= convertStreamToString(inputStream);
                    Log.d(TAG, String.format("HTTP response: %d", statusCode));

                } else {
                    Log.d(TAG, String.format("HTTP STATUS: %d", statusCode));
                    //ResponseData = null;
                }

            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPostExecute(Void bitmap) {
            super.onPostExecute(bitmap);
            if (bitmap != null){
                //imDownloaded.setImageBitmap(bitmap);
            }

        }
    }
}
