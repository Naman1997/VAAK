package c.vaak.vaak;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity implements OnClickListener
{
    private FirebaseAuth firebaseAuth;
    private ProgressDialog progressDialog;
    Button continues;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        firebaseAuth=FirebaseAuth.getInstance();
        Button continues= findViewById(R.id.continues);
        continues.setOnClickListener(this);
    }

    public void login()
    {
        firebaseAuth.signInWithEmailAndPassword("#YOUR_EMAIL","#YOUR_PASSWORD").addOnSuccessListener(new OnSuccessListener<AuthResult>() {
            @Override
            public void onSuccess(AuthResult authResult)
            {
                startActivity(new Intent(MainActivity.this,conversion.class));
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e)
            {
                Toast.makeText(MainActivity.this, "Access Denied", Toast.LENGTH_SHORT).show();
            }
        });

    }

    @Override
    public void onClick(View v)
    {
        switch (v.getId())
        {
            case R.id.continues:
                login();
                break;
            default:
                Toast.makeText(this, "Wrong Option!!!", Toast.LENGTH_SHORT).show();

        }
    }
}
