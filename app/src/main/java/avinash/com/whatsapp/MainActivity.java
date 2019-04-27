package avinash.com.whatsapp;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainActivity extends AppCompatActivity {

    private static final String TAG ="whatsapp" ;
    EditText name,pass;
    TextView login;
    Button sign;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        name=findViewById(R.id.nameeditText);
        pass=findViewById(R.id.passwordeditText);
        login=findViewById(R.id.logintextView);
        sign=findViewById(R.id.signUpbutton);

        mAuth = FirebaseAuth.getInstance();

        sign.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            mAuth.createUserWithEmailAndPassword(name.toString(),pass.toString()).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if(task.isSuccessful()){
                        Log.i(TAG, "Email and Pass Created");
                        FirebaseUser user=task.getResult().getUser();

                    }
                    else{
                        Log.i(TAG, "Email or Pass Failed");
                    }
                }
            });
            }
        });
    }
}
