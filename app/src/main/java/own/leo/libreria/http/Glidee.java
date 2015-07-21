package own.leo.libreria.http;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;

import com.bumptech.glide.request.animation.GlideAnimation;
import com.bumptech.glide.request.target.SimpleTarget;

import own.leo.libreria.R;

public class Glidee extends ActionBarActivity {

        private byte[] res;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.actividad_picasso);
        final  ImageView img = (ImageView)findViewById(R.id.imageView);
        img.setDrawingCacheEnabled(true);

        com.bumptech.glide.Glide.with(this)
        .load("http://eurunners.miro.beecloud.me/images/recommendations/ten-una-meta-diaria.jpg").asBitmap().toBytes().into(new SimpleTarget<byte[]>() {
                public void onResourceReady(byte[] resource, GlideAnimation<? super byte[]> glideAnimation) {
        System.out.println("bytes[]== " + resource);
        Bitmap bm = BitmapFactory.decodeByteArray(resource, 0, resource.length);
        img.setImageBitmap(bm);
        res = resource.clone();


        }});
    }

    @Override
    public void onSaveInstanceState(Bundle outState, PersistableBundle outPersistentState) {
        outState.putByteArray("array", res);
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_picasso, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
