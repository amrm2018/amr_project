package atfalna.atfalna;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class Home2_Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home2);





    }

    public void relative_go_create_post(View view) {
        startActivity(new Intent(getApplicationContext(),Create_Post_Found_Activity.class));
    }
}
