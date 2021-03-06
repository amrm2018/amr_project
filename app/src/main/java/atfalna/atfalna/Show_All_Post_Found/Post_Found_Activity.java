package atfalna.atfalna.Show_All_Post_Found;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.squareup.picasso.Picasso;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import atfalna.atfalna.Comment_Java.Send_Data_Comment_F;

import atfalna.atfalna.Comment_Java.listitme_comm_f;
import atfalna.atfalna.GloablV;

import atfalna.atfalna.R;

public class Post_Found_Activity extends AppCompatActivity {

    TextView tv_code_p, tv_user_name_f, tv_date_p_f,tv_time_p_f, tv_city, tv_day, tv_month, tv_year, tv_gender, tv_phone,tv_place, tv_info ;

    ImageView img_p_f  , img_send_comment_p_f_1 ,img_send_comment_p_f_2;

    RelativeLayout rel_comm_p_f ;
    EditText ed_comm_p_f;

    String S_user_id_f ;// صاحب البوست

    // دول بتاعه ال user اللى عمل login
   String S_user_name_login , S_user_id_login;

   GloablV gloablV ;


   // من هنا الجزء الخاص بالتعليقات
   RequestQueue requestQueue;

    ArrayList<listitme_comm_f> listcomment_f = new ArrayList<listitme_comm_f>();
    ListView listV_comm_p_f;

    String S_code_p_f ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post_found);

        tv_code_p = findViewById(R.id.code_p);
        tv_user_name_f = findViewById(R.id.tv_user_name_f);
        tv_date_p_f = findViewById(R.id.tv_date_f);
        tv_time_p_f = findViewById(R.id.tv_time_p_f);
        tv_city = findViewById(R.id.tv_city_f);
        tv_day = findViewById(R.id.tv_day_f);
        tv_month = findViewById(R.id.tv_month_f);
        tv_year = findViewById(R.id.tv_year_f);
        tv_gender = findViewById(R.id.tv_gender_f);
        tv_phone = findViewById(R.id.tv_phone_f);
        tv_place = findViewById(R.id.tv_place_f);
        tv_info = findViewById(R.id.tv_info_f);

        img_p_f = findViewById(R.id.img_p_f);

        Intent data_p_f = getIntent();

        tv_code_p.setText(data_p_f.getExtras().getString("text_code_p_f").trim());
        S_code_p_f =data_p_f.getExtras().getString("text_code_p_f");

        tv_date_p_f.setText(data_p_f.getExtras().getString("text_date_p_f").trim());
        tv_time_p_f.setText(data_p_f.getExtras().getString("text_time_p_f").trim());

        tv_city.setText(data_p_f.getExtras().getString("text_city_f").trim());
        tv_day.setText(data_p_f.getExtras().getString("text_day_f").trim());
        tv_month.setText(data_p_f.getExtras().getString("text_month_f").trim());
        tv_year.setText(data_p_f.getExtras().getString("text_year_f").trim());

        tv_gender.setText(data_p_f.getExtras().getString("text_gender_f").trim());
        tv_phone.setText(data_p_f.getExtras().getString("text_phone_f").trim());
        tv_place.setText(data_p_f.getExtras().getString("text_place_case_f"));
        tv_info.setText(data_p_f.getExtras().getString("text_info_case_f").trim());

        String simg = data_p_f.getExtras().getString("text_img_f");

        S_user_id_f = data_p_f.getExtras().getString("text_us_id_f");
        // S_user_name= data_p_f.getExtras().getString("text_user_name_f");
        tv_user_name_f.setText(data_p_f.getExtras().getString("text_user_name_f").trim());


        Picasso.with(getApplicationContext())
                .load("http://192.168.1.3/atfalna_app/img_found/" + simg)
                .into(img_p_f);

        gloablV = (GloablV) getApplicationContext();
        S_user_name_login = gloablV.getUser_name();
        S_user_id_login = gloablV.getUser_id();

        //send  Comment_p_f
        rel_comm_p_f = findViewById(R.id.rel_comment_p_f);

        img_send_comment_p_f_1 = findViewById(R.id.img_send_comm_p_f_1);
        img_send_comment_p_f_2 = findViewById(R.id.img_send_comm_p_f_2);
        ed_comm_p_f = findViewById(R.id.ed_comment_p_f);

        ed_comm_p_f.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                img_send_comment_p_f_2.setVisibility(View.INVISIBLE);
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                img_send_comment_p_f_2.setVisibility(View.VISIBLE);
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        //List
        listV_comm_p_f = findViewById(R.id.listview_show_all_comment_p_f);

        get_comment_p_f();


    }
    public void get_comment_p_f(){
        //show comment f
        final TextView tv_total_comm_f =findViewById(R.id.tv_total_comm_f);
        String url_comm_f = "http://192.168.1.3/atfalna_app/show_all_comment_found.php?code_p_f=" + S_code_p_f;
        requestQueue = Volley.newRequestQueue(this);

        listcomment_f.clear();

        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, url_comm_f,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            JSONArray jsonArray = response.getJSONArray("allcomment_p_f");

                            for (int i = 0; i < jsonArray.length(); i++) {
                                JSONObject res = jsonArray.getJSONObject(i);
                                tv_total_comm_f.setText(String.valueOf(jsonArray.length()));
                                String code_comm = res.getString("code_comm");
                                String date_comm = res.getString("date_comm");
                                String time_comm = res.getString("time_comm");
                                String comment_f = res.getString("comment");
                                String us_id_comm = res.getString("us_id");
                                String user_name_comm = res.getString("user_name");

                                listcomment_f.add(new listitme_comm_f(code_comm,
                                        date_comm, time_comm,
                                        comment_f,
                                        us_id_comm, user_name_comm));
                            }

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                        listData_comm_f();
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.e("Volley", "Error");
            }
        });
        requestQueue.add(jsonObjectRequest);
        // end comment
    }

    //Send_Data_Comment_to_Serveries
    public void btn_comment_p_f(final View view) {

        String comment_p_f = ed_comm_p_f.getText().toString().trim();
        String code_p_f = tv_code_p.getText().toString().trim();

        if (comment_p_f.equals("")) {
            Toast.makeText(getApplicationContext(), "لا يمكن أضافة تعليق فارغ", Toast.LENGTH_SHORT).show();
        } else {

            Response.Listener<String> responseLisener = new Response.Listener<String>() {
                @Override
                public void onResponse(String response) {
                    try {
                        JSONObject jsonResponse = new JSONObject(response);
                        boolean success = jsonResponse.getBoolean("success");
                        if (success) {
                            Toast.makeText(getApplicationContext(), "تم أضافة التعليق ", Toast.LENGTH_SHORT).show();
                            ed_comm_p_f.setText("");
                            img_send_comment_p_f_2.setVisibility(View.INVISIBLE);
                            btn_exit_comment_p_f(view);
                            get_comment_p_f();

                        } else {
                            Toast.makeText(getApplicationContext(), "يوجد خطأ ( تاكد من البيانات )", Toast.LENGTH_SHORT).show();
                        }
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
            };
            Send_Data_Comment_F send_data_comment_f = new Send_Data_Comment_F(
                    comment_p_f, S_user_id_login, code_p_f, responseLisener);
            RequestQueue queue_comment_p_f = Volley.newRequestQueue(getApplicationContext());
            queue_comment_p_f.add(send_data_comment_f);
        }
    }

    public void listData_comm_f(){
        ListAdapter_comm ad_comm = new ListAdapter_comm(listcomment_f);
        listV_comm_p_f.setAdapter(ad_comm);
    }

    class ListAdapter_comm extends BaseAdapter {

        ArrayList<listitme_comm_f> list_comm = new ArrayList<listitme_comm_f>();

        ListAdapter_comm(ArrayList<listitme_comm_f> listitme) {
            this.list_comm=listitme;
        }

        @Override
        public int getCount() {
            return list_comm.size();
        }
        @Override
        public Object getItem(int i) {
            return list_comm.get(i).comment_f;
        }
        @Override
        public long getItemId(int i) {
            return i;
        }
        @Override
        public View getView(final int i, View view, ViewGroup viewGroup) {

            LayoutInflater layoutInflater=getLayoutInflater();
            View v_comm =layoutInflater.inflate(R.layout.row_itme_comment,null);

            TextView comment_f =v_comm.findViewById(R.id.tv_comment_f_row);
            TextView date_comm_f =v_comm.findViewById(R.id.tv_date_comm_f_row);
            TextView time_comm_f =v_comm.findViewById(R.id.tv_time_comm_f_row);
            TextView user_name_comm_f =v_comm.findViewById(R.id.tv_user_name_comm_f_row);

            String code_comm , us_id_comm ;
            code_comm=list_comm.get(i).code_comm;
            us_id_comm=list_comm.get(i).us_id;
            comment_f.setText(list_comm.get(i).comment_f);
            date_comm_f.setText(list_comm.get(i).date_comm);
            time_comm_f.setText(list_comm.get(i).time_comm);
            user_name_comm_f.setText(list_comm.get(i).user_name);

            return v_comm;
        }
    }

    public  void btn_exit_comment_p_f (View view){
        rel_comm_p_f.setVisibility(View.INVISIBLE);
        listV_comm_p_f.setVisibility(View.VISIBLE);
        get_comment_p_f();
    }

    public  void btn_show_rel_comment_p_f (View view){
        rel_comm_p_f.setVisibility(View.VISIBLE);
        listV_comm_p_f.setVisibility(View.INVISIBLE);
    }


}