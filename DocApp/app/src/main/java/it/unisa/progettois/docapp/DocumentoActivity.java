package it.unisa.progettois.docapp;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.io.File;

public class DocumentoActivity extends AppCompatActivity {
    ImageView likeImage;
    TextView counterFeedback;
    ImageView visualizzaDocumento;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        likeImage = findViewById(R.id.imageFeedback);
        counterFeedback = findViewById(R.id.counterFeedback);
        visualizzaDocumento = findViewById(R.id.visualizzaDocumento);

        //Listener tasto like
        likeImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (likeImage.getContentDescription() == "black_like"){
                    likeImage.setImageResource(R.mipmap.blue_like_is);
                    likeImage.setContentDescription("blue_like");
                }
                else {
                    likeImage.setImageResource(R.mipmap.black_like_is);
                    likeImage.setContentDescription("black_like");
                }
            }
        });

        //Listener visualizzazione documento
        visualizzaDocumento.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //openPdf(getFilesDir().getPath());
            }
        });
    }

    /*public void openPdf(String path){
        File file = new File(path);
        if (file.exists()){
            Uri p = Uri.fromFile(file);
            Intent intent = new Intent(Intent.ACTION_VIEW);
            intent.setDataAndType(p,"it.unisa.progettois.docapp.documenti/pdf");
            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);

            startActivity(intent);
        }
    }*/
}
