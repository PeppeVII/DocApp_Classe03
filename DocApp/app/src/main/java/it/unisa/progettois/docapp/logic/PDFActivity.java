package it.unisa.progettois.docapp.logic;

import android.annotation.SuppressLint;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.github.barteksc.pdfviewer.PDFView;
import com.github.barteksc.pdfviewer.source.DocumentSource;
import com.github.barteksc.pdfviewer.source.FileSource;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

import it.unisa.progettois.docapp.R;

public class PDFActivity extends AppCompatActivity {

    PDFView pdfView;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_pdf_viewer);

        pdfView = findViewById(R.id.pdf_view);
        String path = getIntent().getExtras().getString("percorso");
        File file = new File(path);
        pdfView.fromFile(file).load();

        Log.d("Path", "Percorso:"+path);
    }
}
