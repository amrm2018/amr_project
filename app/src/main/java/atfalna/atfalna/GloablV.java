package atfalna.atfalna;

import android.app.Application;

/**
 * Created by amr1 on 2/28/2018.
 */


public class GloablV extends Application {

    private String email_user ;
    private String user_id ;
    private String user_name ;

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }



    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getEmail_user() {
        return email_user;
    }

    public void setEmail_user(String email_user) {
        this.email_user = email_user;
    }




}
