package c.vaak.vaak;

import android.os.Build;
import android.speech.tts.TextToSpeech;
import android.support.annotation.NonNull;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import com.firebase.client.Firebase;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.Locale;
import java.util.Objects;

public class conversion extends AppCompatActivity
{

    FirebaseAuth firebaseAuth;
    FirebaseDatabase database;
    TextView textView;
    DatabaseReference dbref;
    Firebase url;
    private TextToSpeech mTTs;
    SeekBar seek_pitch,seek_vol;
    Button speak_button;
    String value;


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.conversion);
        Firebase.setAndroidContext(this);
        firebaseAuth= FirebaseAuth.getInstance();
        firebaseAuth.getCurrentUser();
        textView=findViewById(R.id.textView);
        seek_pitch=findViewById(R.id.seekBar_pitch);
        seek_vol=findViewById(R.id.seekBar_volume);
        speak_button=findViewById(R.id.button);

        Toast.makeText(this, "Welcoming:"+firebaseAuth.getCurrentUser().getEmail(), Toast.LENGTH_SHORT).show();


        speak_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!value.equalsIgnoreCase("no")) {
                    Toast.makeText(conversion.this, value, Toast.LENGTH_SHORT).show();
                    textView.setText(value);
                    speak();
                }
            }
        });


        mTTs= new TextToSpeech(this, new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int status)
            {
                if(status==TextToSpeech.SUCCESS){
                    int result=mTTs.setLanguage(Locale.ENGLISH);
                    if(result == TextToSpeech.LANG_MISSING_DATA || result == TextToSpeech.LANG_NOT_SUPPORTED)
                    {
                        Log.e("TTS", "Language not supported");
                    }
                }
                else
                {
                    Log.e("TTS","Initialization fail");
                }
            }
        });

        dbref=FirebaseDatabase.getInstance().getReference().child("Data");
        dbref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot)
            {
                value=dataSnapshot.getValue().toString();
                /*if(value.equalsIgnoreCase("no"))
                {
                    Toast.makeText(conversion.this, value, Toast.LENGTH_SHORT).show();
                    textView.setText(value);
                    speak();
                }*/
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });


    }

    @Override
    protected void onDestroy() {
        if(mTTs!=null)
        {
            mTTs.stop();
            mTTs.shutdown();
        }
        super.onDestroy();
    }

    private void speak()
    {
        String text=textView.getText().toString();
        float pitch =(float) seek_pitch.getProgress()/50;
        if(pitch<0.1) pitch =0.1f;
        float volum =(float) seek_vol.getProgress()/50;
        if(volum<0.1) pitch =0.1f;

        mTTs.setPitch(pitch);
        mTTs.setSpeechRate(volum);

        mTTs.speak(text,TextToSpeech.QUEUE_FLUSH,null);


    }
}
