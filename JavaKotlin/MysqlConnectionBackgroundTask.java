package com.rr_dokkar.phpmysql;

import android.app.AlertDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;

public class BackgroundTask extends AsyncTask<String,Void,String> {
    Context c;
   public BackgroundTask(Context c){
       this.c=c;
   }
   
    @Override
    protected String doInBackground(String... voids) {
       String result="";

       String user=voids[0];
       String passwd=voids[1];

       String phpConection="http://192.168.1.8/android_connection_db.php";

        try {
            URL url=new URL(phpConection);
            HttpURLConnection httpURLConnection=(HttpURLConnection) url.openConnection();
            httpURLConnection.setRequestMethod("POST");
            httpURLConnection.setDoInput(true);
            httpURLConnection.setDoOutput(true);
            OutputStream outputStream=httpURLConnection.getOutputStream();
            BufferedWriter writer=new BufferedWriter(new OutputStreamWriter(outputStream,"UTF-8"));

            String postData= URLEncoder.encode("username","UTF-8")+"="+URLEncoder.encode(user,"UTF-8")+"&"
                    + URLEncoder.encode("passwd","UTF-8")+"="+URLEncoder.encode(passwd,"UTF-8");

            writer.write(postData);
            writer.flush();

            writer.close();
            outputStream.close();

            //reading the server answer

            InputStream inputStream=httpURLConnection.getInputStream();
            BufferedReader reader=new BufferedReader(new InputStreamReader(inputStream,"iso-8859-1"));

            String line="";

            while ((line=reader.readLine()) != null){
                result += line +"\n";

            }

            reader.close();
            inputStream.close();
            httpURLConnection.disconnect();


        } catch (MalformedURLException e) {
            result=e.toString();
        } catch (IOException f) {
            result=f.toString();

        }

        Log.e("ress",result);
        return result;
    }


    @Override
    protected void onPostExecute(String s) {
        Log.e("ress","preparation : "+s);
    }
}
