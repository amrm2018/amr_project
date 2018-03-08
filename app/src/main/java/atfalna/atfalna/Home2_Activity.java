package atfalna.atfalna;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import atfalna.atfalna.Create_Post_Java.Create_Post_Found_Activity;
import atfalna.atfalna.Create_Post_Java.Create_Post_Missing_Activity;
import atfalna.atfalna.Login_Register_Java.Login2_Activity;
import atfalna.atfalna.Show_All_Post_Found.Show_All_Found_Activity;

public class Home2_Activity extends AppCompatActivity {

    TextView textView_id ,textView_email ;

    RequestQueue requestQueue;

    GloablV gloablV ;
    String S_user_email , S_user_id;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home2);

        textView_id=findViewById(R.id.tv_show_id);
        textView_email=findViewById(R.id.tv_show_email_home);

        gloablV = (GloablV)getApplicationContext();
        S_user_email = gloablV.getEmail_user();
        textView_email.setText(gloablV.getEmail_user());

        get_userid();//خاص بانه يجيب ال id بتاع ال user اللى يدخل الapp

    }

    public void relative_go_create_post(View view) {
        startActivity(new Intent(getApplicationContext(),Create_Post_Found_Activity.class));
    }

    public void btn_Logout(View view) {
        getSharedPreferences("MyPref1",MODE_PRIVATE).edit().clear().commit();
        startActivity(new Intent(getApplicationContext(),Login2_Activity.class));

    }

    public void Go_activity_show_all_found(View view) {
        startActivity(new Intent(getApplicationContext(),Show_All_Found_Activity.class));
    }

    public void Go_activity_create_post_m(View view) {
        startActivity(new Intent(getApplicationContext(),Create_Post_Missing_Activity.class));
    }

    public void go_main_activity(View view) {
        startActivity(new Intent(getApplicationContext(),MainActivity.class));
    }


    public void get_userid() {

        String urlid="http://192.168.1.3/app_atfalna/show_userid.php?useremail=" + S_user_email;

        requestQueue= Volley.newRequestQueue(this);
        JsonObjectRequest jsonObjectRequest =new JsonObjectRequest(Request.Method.GET, urlid,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            JSONArray jsonArray = response.getJSONArray("user_id");
                            for (int i = 0; i < jsonArray.length(); i++) {
                                JSONObject res = jsonArray.getJSONObject(i);
                                String usid = res.getString("userid");
                                textView_id.setText(usid);
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.e("Volley" , "Error");
            }
        });requestQueue.add(jsonObjectRequest);


    }
}
