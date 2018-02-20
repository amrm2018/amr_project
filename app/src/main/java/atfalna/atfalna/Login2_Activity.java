package atfalna.atfalna;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class Login2_Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login2);
    }

    public void btn_go_Register2(View view) {
        startActivity(new Intent(getApplicationContext(),Registration2_Activity.class));
    }
    public void btn_go_Home2(View view) {
        startActivity(new Intent(getApplicationContext(),Home2_Activity.class));
    }
}
