package in.errorlabs.jbtransport.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Base64;

/**
 * Created by root on 6/27/17.
 */

public class SharedPrefs{
    Context context;
    public static final String myprefs = "myprefs";
    public static final String FirstOpen = "FirstOpen";
    public static final String FirebaseInstanceToken = "Token";
    public static final String RouteSelected = "Route";
    public static final String SelectedRouteNumber = "selectedRoute";
    public static final String SelectedRouteFcmID = "fcm";
    public static final String AlreadySkipped = "skipped";
    public static final String LocationSendFcmID= "location";

    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;

    public SharedPrefs(Context context){
        this.context=context;
        sharedPreferences = context.getSharedPreferences(myprefs,Context.MODE_PRIVATE);
    }

    public String encode(String data){
        if (data!=null){
            return Base64.encodeToString(data.getBytes(), Base64.DEFAULT);
        }
        return null;
    }

    private String decode(String data){
        if (data!=null){
            return new String(Base64.decode(data, Base64.DEFAULT));
        }
        return null;
    }

    public void setFirebaseInstanceToken(String token){
        editor = sharedPreferences.edit();
        editor.putString(FirebaseInstanceToken,encode(token));
        editor.commit();
    }

    public String getFirebaseInstanceToken(){
        String value = sharedPreferences.getString(FirebaseInstanceToken,null);
        return decode(value);
    }

    public void setRouteSelected(){
        editor = sharedPreferences.edit();
        editor.putBoolean(RouteSelected,true);
        editor.commit();
    }

    public void setRouteSelectedAsFalse(){
        editor = sharedPreferences.edit();
        editor.putBoolean(RouteSelected,false);
        editor.commit();
    }

    public boolean getRouteSelected(){
        return sharedPreferences.getBoolean(RouteSelected,false);
    }

    public void setSelectedRouteNumber(String number){
        editor = sharedPreferences.edit();
        editor.putString(SelectedRouteNumber,encode(number));
        editor.commit();
    }

    public String getSelectedRouteNumber(){
        String value =  sharedPreferences.getString(SelectedRouteNumber,null);
        return decode(value);
    }

    public void setSelectedRouteFcmID(String fcmID){
        editor = sharedPreferences.edit();
        editor.putString(SelectedRouteFcmID,encode(fcmID));
        editor.commit();
    }

    public String getSelectedRouteFcmID(){
        String value = sharedPreferences.getString(SelectedRouteFcmID,null);
        return decode(value);
    }

    public void setLocationSendFcmID(String fcmID){
        editor = sharedPreferences.edit();
        editor.putString(LocationSendFcmID,encode(fcmID));
        editor.commit();
    }

    public String getLocationSendFcmID(){
        String value = sharedPreferences.getString(LocationSendFcmID,null);
        return decode(value);
    }

    public void setAlreadySkipped(){
        editor = sharedPreferences.edit();
        editor.putBoolean(AlreadySkipped,true);
        editor.commit();
    }

    public boolean getAlreadySkipped(){
        return sharedPreferences.getBoolean(AlreadySkipped,false);
    }

}
