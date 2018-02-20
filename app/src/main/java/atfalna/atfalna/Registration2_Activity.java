package atfalna.atfalna;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class Registration2_Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration2);
    }

    public void btn_go_login2(View view) {
        startActivity(new Intent(getApplicationContext(),Login2_Activity.class));
    }
}
