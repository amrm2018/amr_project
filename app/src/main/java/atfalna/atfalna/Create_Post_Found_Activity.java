package atfalna.atfalna;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class Create_Post_Found_Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_post_found);

    }

    public void back_finish(View view) {
        finish();
    }
}
