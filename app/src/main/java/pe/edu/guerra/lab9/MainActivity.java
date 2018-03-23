package pe.edu.guerra.lab9;

import android.content.Intent;
import android.nfc.Tag;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void callActivityA(View view){
        Log.d(TAG, "callActivityA");
        startActivityForResult(new Intent(this, PantallaAActivity.class), ACTIVITY_A_REQUEST);
    }
    public void callActivityB(View view){
        Log.d(TAG, "callActivityB");
        startActivityForResult(new Intent(this, PantallaBActivity.class), ACTIVITY_B_REQUEST);
    }



    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        Log.d(TAG, "requestCode:"+requestCode);
        Log.d(TAG, "resultCode:"+resultCode);
        Log.d(TAG, "data:"+data);
  
        switch (requestCode){
            case ACTIVITY_A_REQUEST:
                Log.d(TAG, "Regresamos del Activity A");
                break;
            case ACTIVITY_B_REQUEST:
                Log.d(TAG, "Regresamos del Activity B");

                if(resultCode == RESULT_OK){
                    String valor = data.getExtras().getString("valor");
                    Log.d(TAG, "valor: " + valor);
                }

                break;
        }

    }
}
