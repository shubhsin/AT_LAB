package sorte.shubham.appleclinicmanagement;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.database.sqlite.SQLiteDatabase;
import android.widget.Toast;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    private static String DBNAME = "shubhsin.db";    // THIS IS THE SQLITE DATABASE FILE NAME.
    private static String TABLE = "APPLECLINIC";
    SQLiteDatabase  db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Button submitButton = (Button) findViewById(R.id.addPatientButton);
        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                db = openOrCreateDatabase(DBNAME, Context.MODE_PRIVATE,null);

                db.execSQL("CREATE TABLE IF NOT EXISTS " + TABLE + "(firstname VARCHAR, lastname VARCHAR,age VARCHAR,detail VARCHAR);");

                TextView tf = (TextView) findViewById(R.id.firstnameTextField);
                String firstname = tf.getText().toString();
                TextView tf1 = (TextView) findViewById(R.id.lastnameTextField);
                String lastname = tf1.getText().toString();
                TextView tf2 = (TextView) findViewById(R.id.ageTextField);
                String age = tf2.getText().toString();
                TextView tf3 = (TextView) findViewById(R.id.medicalTextField);
                String medical = tf3.getText().toString();

                if (firstname.equals("") || lastname.equals("") || age.equals("") || medical.equals("")) {
                    Toast toast = Toast.makeText(getApplicationContext(), "Enter data for all fields", Toast.LENGTH_SHORT);
                    toast.show();
                } else {
                    db.execSQL("INSERT INTO " + TABLE + "(firstname, lastname, age, detail) VALUES('" + firstname + "','" + lastname + "','" + age + "','" + medical + "')");
                    Toast toast = Toast.makeText(getApplicationContext(), firstname + " successfully saved", Toast.LENGTH_SHORT);
                    toast.show();
                }
                db.close();

            }

        });

        Button viewLView = (Button) findViewById(R.id.viewListViewButton);
        viewLView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getBaseContext(),ListViewActivity.class);
                Bundle b = new Bundle();
                startActivity(i);
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
