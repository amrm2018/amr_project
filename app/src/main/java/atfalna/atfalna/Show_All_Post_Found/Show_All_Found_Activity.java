package atfalna.atfalna.Show_All_Post_Found;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;

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

import atfalna.atfalna.GloablV;
import atfalna.atfalna.R;

public class Show_All_Found_Activity extends AppCompatActivity {

    RequestQueue requestQueue;
    String url="http://192.168.1.3/atfalna_app/show_all_post_found.php";
    ArrayList<listitme_f> listMovis = new ArrayList<listitme_f>();
    ListView listView ;
    TextView text_total , text_email_user ;

    GloablV gloablV;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_all_found);

        listView =findViewById(R.id.listview_show_all_found);
        text_total = findViewById(R.id.tv_total_post);
        text_email_user=findViewById(R.id.tv_show_email_user2);

        assert text_email_user !=null;
        gloablV =(GloablV)getApplicationContext();
        text_email_user.setText("مرحبا : "+gloablV.getUser_name());

        requestQueue= Volley.newRequestQueue(this);
        JsonObjectRequest jsonObjectRequest=new JsonObjectRequest(Request.Method.GET, url,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            JSONArray jsonArray = response.getJSONArray("allpost_found");
                            text_total.setText("الحالات التى تم رؤيتها: " + jsonArray.length());
                            for (int i = 0 ; i < jsonArray.length(); i++) {
                                JSONObject res = jsonArray.getJSONObject(i);


                                String code_p_f = res.getString("code_p_f");
                                String date_p_f= res.getString("date_p_f");
                                String time_p_f = res.getString("time_p_f");

                                String city_f = res.getString("city_f");

                                String day_f = res.getString("day_f");
                                String month_f = res.getString("month_f");
                                String year_f = res.getString("year_f");

                                String gender_f = res.getString("gender_f");
                                String phone_f = res.getString("phone_f");

                                String place_case_f = res.getString("place_case_f");
                                String info_case_f = res.getString("info_case_f");
                                String img_f = res.getString("img_f");

                                String us_id_f = res.getString("us_id");
                                String user_name_f = res.getString("user_name_f");

                                listMovis.add(new listitme_f(code_p_f,date_p_f,time_p_f,
                                        city_f,
                                        day_f,month_f,year_f,
                                        gender_f,phone_f,
                                        place_case_f,info_case_f,
                                        img_f,
                                        us_id_f , user_name_f));
                            }

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                        listData();
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.e("Volley","Error");
            }
        });requestQueue.add(jsonObjectRequest);

    }
    public void listData(){
       ListAdapter ad = new ListAdapter(listMovis);
       listView.setAdapter(ad);
    }

    class ListAdapter extends BaseAdapter{

        ArrayList<listitme_f> listA = new ArrayList<listitme_f>();

      ListAdapter(ArrayList<listitme_f> listitme) {
            this.listA=listitme;
        }


        @Override
        public int getCount() {
            return listA.size();
        }

        @Override
        public Object getItem(int i) {
            return listA.get(i).code_p_f;
        }

        @Override
        public long getItemId(int i) {
            return i;
        }

        @Override
        public View getView(final int i, View view, ViewGroup viewGroup) {

            LayoutInflater layoutInflater=getLayoutInflater();
            View v1 =layoutInflater.inflate(R.layout.row_itme_fonud,null);

            TextView code_p_f =v1.findViewById(R.id.tv_code_post_f_list);
            TextView user_name_p_f =v1.findViewById(R.id.tv_email_user_list);
            TextView city_f =v1.findViewById(R.id.tv_city_list);
            TextView date_p_f =v1.findViewById(R.id.tv_datetime_list);
            //TextView phone =v1.findViewById(R.id.tv_phone_list);

            ImageView imgfound =v1.findViewById(R.id.img_post_found_list);

            code_p_f.setText(listA.get(i).code_p_f);
            user_name_p_f.setText(listA.get(i).user_name_f);
            city_f.setText(listA.get(i).city_f);
            date_p_f.setText(listA.get(i).date_p_f);
            // phone.setText(listA.get(i).phone);

            Picasso.with(getApplicationContext()).load("http://192.168.1.3/atfalna_app/img_found/"+listA.get(i).img_f).into(imgfound);

            imgfound.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                Intent openPost= new Intent(getApplicationContext(),Post_Found_Activity.class);

                    openPost.putExtra("text_code_p_f",listA.get(i).code_p_f);
                    openPost.putExtra("text_date_p_f",listA.get(i).date_p_f);
                    openPost.putExtra("text_time_p_f",listA.get(i).time_p_f);

                    openPost.putExtra("text_city_f",listA.get(i).city_f);

                    openPost.putExtra("text_day_f",listA.get(i).day_f);
                    openPost.putExtra("text_month_f",listA.get(i).month_f);
                    openPost.putExtra("text_year_f",listA.get(i).year_f);

                    openPost.putExtra("text_gender_f",listA.get(i).gender_f);
                    openPost.putExtra("text_phone_f",listA.get(i).phone_f);

                    openPost.putExtra("text_place_case_f",listA.get(i).place_case_f);
                    openPost.putExtra("text_info_case_f",listA.get(i).info_case_f);

                    openPost.putExtra("text_img_f",listA.get(i).img_f);

                    openPost.putExtra("text_us_id_f",listA.get(i).us_id_f);
                    openPost.putExtra("text_user_name_f",listA.get(i).user_name_f);

                 startActivity(openPost);
                }
            });

            return v1;
        }
    }

}
