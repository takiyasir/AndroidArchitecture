package com.example.architectueexample;

import android.os.Bundle;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    private NoteViewModel noteViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        noteViewModel = ViewModelProviders.of(this).get(NoteViewModel.class);
        noteViewModel.getAllNotes().observe(this,new Observer<List<Note>>(){
            @Override
            public void onChanged(@Nullable List<Note>notes){
                //update RecyclearView
                Toast.makeText(MainActivity.this, "onChanged", Toast.LENGTH_SHORT).show();

            }
        });
    }
}