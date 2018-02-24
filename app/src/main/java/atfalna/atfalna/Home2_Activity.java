package atfalna.atfalna;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import atfalna.atfalna.Login_Register_Java.Login2_Activity;

public class Home2_Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home2);





    }

    public void relative_go_create_post(View view) {
        startActivity(new Intent(getApplicationContext(),Create_Post_Found_Activity.class));
    }

    public void btn_Logout(View view) {
        getSharedPreferences("MyPref1",MODE_PRIVATE).edit().clear().commit();
        startActivity(new Intent(getApplicationContext(),Login2_Activity.class));

    }
}
