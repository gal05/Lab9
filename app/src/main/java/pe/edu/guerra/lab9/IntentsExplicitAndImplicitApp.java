package pe.edu.guerra.lab9;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class IntentsExplicitAndImplicitApp extends AppCompatActivity {

    private EditText codeInput;
    private EditText fullnameInput;
    private EditText amountInput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intents_explicit_and_implicit_app);



        codeInput = (EditText)findViewById(R.id.codeInput);
        fullnameInput = (EditText)findViewById(R.id.fullnameInput);
        amountInput = (EditText)findViewById(R.id.amountInput);

    }

    public void sendExplicit(View view){

        String code = codeInput.getText().toString();
        String fullname = fullnameInput.getText().toString();
        String amount = amountInput.getText().toString();

        if("".equals(code) || "".equals(fullname) || "".equals(amount)){
            Toast.makeText(this, "All fields are required", Toast.LENGTH_SHORT).show();
            return;
        }

        Intent intent = new Intent(this, DetailActivity.class);
        intent.putExtra("code", Integer.parseInt(code));
        intent.putExtra("fullname", fullname);
        intent.putExtra("amount", Double.parseDouble(amount));
        startActivity(intent);
    }

    public void sendImplicit(View view){

        String code = codeInput.getText().toString();
        String fullname = fullnameInput.getText().toString();
        String amount = amountInput.getText().toString();

        if("".equals(code) || "".equals(fullname) || "".equals(amount)){
            Toast.makeText(this, "All fields are required", Toast.LENGTH_SHORT).show();
            return;
        }

        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.putExtra(Intent.EXTRA_TEXT, "code: "+code+"\nfullname: "+fullname+"\namount: "+amount);
        intent.setType("text/plain");
        startActivity(intent);
    }

}
