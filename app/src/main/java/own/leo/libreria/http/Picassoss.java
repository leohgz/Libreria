package own.leo.libreria.http;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ImageView;

import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;

import java.nio.ByteBuffer;

import own.leo.libreria.R;

/**
 * Created by Leonardo on 7/20/15.
 */
public class Picassoss extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.actividad_picasso);
        final ImageView img = (ImageView)findViewById(R.id.imageView);
        img.setDrawingCacheEnabled(true);


        Picasso.with(getApplicationContext())
                .load("https://cms-assets.tutsplus.com/uploads/users/21/posts/19431/featured_image/CodeFeature.jpg")
                .into(img, new Callback() {
                    public void onSuccess() {

                        int count = img.getDrawingCache().getByteCount();
                        ByteBuffer buffer = ByteBuffer.allocate(count);
                        img.getDrawingCache().copyPixelsToBuffer(buffer);
                        byte[] array = buffer.array();

                        System.out.println("onSuccess " + array);

                    }

                    public void onError() {

                    }
                });


    }
}
