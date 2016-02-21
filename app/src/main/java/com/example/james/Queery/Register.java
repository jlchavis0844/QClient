package com.example.james.Queery;

import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.common.api.GoogleApiClient;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

public class Register extends AppCompatActivity implements View.OnClickListener {

    //for use in register fields
    Button bRegister;//register buttom
    EditText etUsername, etFname, etLname, etEmail, etPassword, etAge;//register info
    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        //fields being imported from registration activity.
        etUsername = (EditText) findViewById(R.id.etUsername);
        etFname = (EditText) findViewById(R.id.etFname);
        etLname = (EditText) findViewById(R.id.etLname);
        etPassword = (EditText) findViewById(R.id.etPassword);
        etEmail = (EditText) findViewById(R.id.etEmail);
        etAge = (EditText) findViewById(R.id.etAge);
        bRegister = (Button) findViewById(R.id.bRegister);
        bRegister.setOnClickListener(this);//start listener
        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.bRegister:
                new sendRegister().execute();
                break;
        }
    }

    class sendRegister extends AsyncTask<Void,Void,Void> {

        Boolean complete = false;
        //Socket sock = null;
        //InetAddress host;
        PrintWriter out;
        BufferedReader in;

        protected Void doInBackground(Void... args) {
            try {
                //host = InetAddress.getLocalHost();
                Socket sock = new Socket("10.0.2.2", 4910);
                out = new PrintWriter(sock.getOutputStream(), true);
                in = new BufferedReader(new InputStreamReader(sock.getInputStream()));

                String command = "addUser, " + getETtext(etUsername) + ", " + getETtext(etPassword) +
                        ", " + getETtext(etFname) + ", " + getETtext(etLname) + ", " +
                        getETtext(etEmail) + ", " + getETtext(etAge);
                out.println(command);
                Log.i("Register Command", command);
                String temp;
                while (in.ready()) {
                    temp = in.readLine();
                    Log.d("Register Command", temp);
                    System.out.println(temp);
                }
                sock.close();
            } catch (UnknownHostException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            } finally {
                /*try {
                    sock.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }*/
            }
            //return null;
            return null;
        }
    }

    /**
     * Checks if EditText is empty and replaces empty with ""
     * returns text if not empty
     *
     * @param et - The EditText to get the text from
     * @return String of "" if empty, or the text if not
     */
    private String getETtext(EditText et) {
        String temp = et.getText().toString().trim();
        if (temp.equals("") || temp == null) {
            return "";
        } else return temp;
    }
}
