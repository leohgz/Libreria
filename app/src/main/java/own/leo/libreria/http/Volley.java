package own.leo.libreria.http;

import android.app.Activity;
import android.os.Bundle;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

import own.leo.libreria.R;

/**
 * Created by Leonardo on 7/20/15.
 */
public class Volley extends Activity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.actividad_picasso);


        RequestQueue queue = com.android.volley.toolbox.Volley.newRequestQueue(this);

        String url ="http://eurunners.miro.beecloud.me/api/1/recommendations/listing";

        final Map<String,String> mapa = new HashMap<>();
        mapa.put("last_id","0");
        mapa.put("page", "2");
        mapa.put("pageSize", "1");

        StringRequest reque = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                try {
                    JSONObject obj = new JSONObject(response);
                    JSONObject obj2  = obj.getJSONObject("meta");
                    JSONObject obj3 = obj.getJSONObject("data");

                    JSONArray arra = obj3.getJSONArray("recommendations");

                    System.out.println("respuesta__  "+response.toString());


                } catch (JSONException e) {
                    e.printStackTrace();
                }



            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }}
        ){
            @Override
            protected Map<String, String> getParams() {
                System.out.println("getParams() ");

                Map<String, String> params = new HashMap<String, String>();
                params.put("last_id","0");
                params.put("page", "2");
                params.put("pageSize", "1");

                return params;
            }}
                ;
        queue.add(reque);

    }
}
