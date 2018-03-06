package atfalna.atfalna;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import atfalna.atfalna.Create_Post_Java.Create_Post_Found_Activity;
import atfalna.atfalna.Create_Post_Java.Create_Post_Missing_Activity;
import atfalna.atfalna.Login_Register_Java.Login2_Activity;
import atfalna.atfalna.Show_All_Post_Found.Show_All_Found_Activity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void btn_Logout1(View view) {
        getSharedPreferences("MyPref1",MODE_PRIVATE).edit().clear().commit();
        startActivity(new Intent(getApplicationContext(),Login2_Activity.class));

    }

    public void go_activity_show_all_f(View view) {
        startActivity(new Intent(getApplicationContext(),Show_All_Found_Activity.class));
    }

    public void go_activity_show_all_m(View view) {
       // startActivity(new Intent(getApplicationContext(),Show_All_Found_Activity.class));
    }

    public void go_activity_create_post_f(View view) {
        startActivity(new Intent(getApplicationContext(),Create_Post_Found_Activity.class));
    }

    public void go_activity_create_post_m(View view) {
        startActivity(new Intent(getApplicationContext(),Create_Post_Missing_Activity.class));
    }
}
