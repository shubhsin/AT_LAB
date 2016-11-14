package sorte.shubham.encryptproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    public static final String ALPHABET = "abcdefghijklmnopqrstuvwxyz";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button b1 = (Button) findViewById(R.id.encryptButton);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                TextView t = (TextView) findViewById(R.id.editText);
                String inputText = t.getText().toString();
                inputText = inputText.toLowerCase();
                String cipherText = "";
                for (int i = 0; i < inputText.length(); i++) {
                    int charPosition = ALPHABET.indexOf(inputText.charAt(i));
                    int keyVal = (3 + charPosition) % 26;
                    char replaceVal = ALPHABET.charAt(keyVal);
                    cipherText += replaceVal;
                }
                t.setText(cipherText);

            }
        });

        Button b2 = (Button) findViewById(R.id.decryptButton);
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                TextView t = (TextView) findViewById(R.id.editText);
                String inputText = t.getText().toString();
                inputText = inputText.toLowerCase();
                String plainText = "";
                for (int i = 0; i < inputText.length(); i++)
                {
                    int charPosition = ALPHABET.indexOf(inputText.charAt(i));
                    int keyVal = (charPosition - 3) % 26;
                    if (keyVal < 0)
                    {
                        keyVal = ALPHABET.length() + keyVal;
                    }
                    char replaceVal = ALPHABET.charAt(keyVal);
                    plainText += replaceVal;
                }
                t.setText(plainText);

            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
