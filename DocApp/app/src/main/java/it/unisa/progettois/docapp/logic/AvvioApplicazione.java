package it.unisa.progettois.docapp.logic;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import it.unisa.progettois.docapp.R;
import it.unisa.progettois.docapp.models.Documento;
import it.unisa.progettois.docapp.utils.ApplicationContext;
import it.unisa.progettois.docapp.utils.StaticUrls;


public class AvvioApplicazione extends AppCompatActivity {
    Button registration, login;

    public AvvioApplicazione() {
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        System.out.println("AvvioApplicazione.onCreate");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_apertura);
        StaticUrls.init("http://", "192.168.1.3", "8080");


        ApplicationContext.getInstance().init(getApplicationContext());
        //use via ApplicationContext.get()
        assert (getApplicationContext() == ApplicationContext.get());


        login = (Button) findViewById(R.id.bottonePerLogin);
        registration = (Button) findViewById(R.id.bottonePerRegistrazione);


        //check preferences
        SharedPreferences sharedPreferences = getApplicationContext().getSharedPreferences("com.docapp", Context.MODE_PRIVATE);

        if (!sharedPreferences.getString("accessToken", "null").equals("null")) {
            Map<String, String> headers = new HashMap<>();
// Add the authorization header to the headers Map
            headers.put("Authorization", "Bearer " + sharedPreferences.getString("accessToken", "null"));
            JSONObject json_signin = new JSONObject();

            RequestQueue requestQueue = Volley.newRequestQueue(this);
            System.out.println(StaticUrls.getUrl("url_login_token"));
            try {
                JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(
                        Request.Method.POST,
                        StaticUrls.getUrl("url_login_token"),
                        json_signin,
                        new Response.Listener<JSONObject>() {
                            @Override
                            public void onResponse(JSONObject response) {
                                Intent intent = new Intent(getApplicationContext(), HomepageActivity.class);
                                startActivity(intent);

                            }
                        },
                        new Response.ErrorListener() {
                            @Override
                            public void onErrorResponse(VolleyError error) {
                                Toast.makeText(getApplicationContext(), "Sessione scaduta, ricollegarsi", Toast.LENGTH_SHORT).show();
                                Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
                                startActivity(intent);
                                System.out.println(error.getMessage());
                            }
                        }) {
                    @Override
                    public Map<String, String> getHeaders() throws AuthFailureError {
                        Map<String, String> headers = new HashMap<>();
                        headers.put("Authorization", "Bearer " + sharedPreferences.getString("accessToken", "null"));
                        return headers;
                    }
                };

                requestQueue.add(jsonObjectRequest);

            } catch (Exception exception) {
                Toast.makeText(getApplicationContext(), "Errore nell'input", Toast.LENGTH_SHORT).show();
            }

        }

//        String url = "api/endpoints";
//        RequestQueue requestQueue = Volley.newRequestQueue(this);

//        JsonObject endpoints = new JsonObject();
//
//        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
//            @Override
//            public void onResponse(JSONObject response) {
//                //get all endpoints
//
//
//            }
//        }, new Response.ErrorListener() {
//            @Override
//            public void onErrorResponse(VolleyError error) {
//                Toast.makeText(getApplicationContext(), "Errore di connessione", Toast.LENGTH_SHORT).show();
//            }
//        });

        registration.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), RegistrazioneActivity.class);
                startActivity(intent);
            }
        });

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
                startActivity(intent);
            }
        });
    }
}