package atfalna.atfalna;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class Login_Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

    }

    public void btn_login(View view) {
        startActivity(new Intent(getApplicationContext(),Home_Activity.class));
    }

    public void btn_go_Register(View view) {
        startActivity(new Intent(getApplicationContext(),Registraion_Activity.class));
    }
}
