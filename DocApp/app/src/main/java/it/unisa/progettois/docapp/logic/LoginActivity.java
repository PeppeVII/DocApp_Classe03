package it.unisa.progettois.docapp.logic;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;


import org.json.JSONException;
import org.json.JSONObject;

import it.unisa.progettois.docapp.R;
import it.unisa.progettois.docapp.utils.StaticUrls;


public class LoginActivity extends AppCompatActivity {
    Button buttonAccedi;
    EditText usernameLogin, passwordLogin;

    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_login);

        sharedPreferences = getApplicationContext().getSharedPreferences("com.docapp", Context.MODE_PRIVATE);
        editor = sharedPreferences.edit();

        buttonAccedi = findViewById(R.id.buttonAccedi);
        usernameLogin = findViewById(R.id.username);
        passwordLogin = findViewById(R.id.passwordLogin);
    }

    public void effettuaLogin(View view) {
        String username = usernameLogin.getText().toString();
        String password = passwordLogin.getText().toString();


        JSONObject json_signin = new JSONObject();
        try {
            json_signin.put("username", username);
            json_signin.put("password", password);
        } catch (JSONException ex) {
            System.out.println(ex.getMessage());
            Toast.makeText(getApplicationContext(), "Errore inaspettato", Toast.LENGTH_LONG).show();
        }
        RequestQueue requestQueue = Volley.newRequestQueue(this);

        try {
            JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.POST, StaticUrls.getUrl("url_login"), json_signin, new Response.Listener<JSONObject>() {
                @Override
                public void onResponse(JSONObject response) {
                    editor.putString("accessToken", response.optString("accessToken"));
                    editor.apply();
                    Toast.makeText(getApplicationContext(), "Ti sei loggato correttamente", Toast.LENGTH_LONG).show();
                    Intent intent = new Intent(getApplicationContext(), HomepageActivity.class);
                    startActivity(intent);

                }
            }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                    Toast.makeText(getApplicationContext(), "Email o password errate", Toast.LENGTH_LONG).show();

                    System.out.println(error.getMessage());
                }
            });
            requestQueue.add(jsonObjectRequest);

        } catch (Exception exception) {
            Toast.makeText(getApplicationContext(), "Errore nell'input", Toast.LENGTH_SHORT).show();
        }
    }
}
