package sorte.shubham.applequizup;

import android.content.Context;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import android.database.sqlite.SQLiteDatabase;


public class MainActivity extends AppCompatActivity {
    String[] questionArray;
    String[] answerArray;
    int current = 0;
    int correctAnswers = 0;
    int j;

    private static String DBNAME = "shubhsin.db";    // THIS IS THE SQLITE DATABASE FILE NAME.
    private static String TABLE = "APPLEMAIN";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SQLiteDatabase  db = openOrCreateDatabase(DBNAME, Context.MODE_PRIVATE,null);

        db.execSQL("CREATE TABLE IF NOT EXISTS "+TABLE+"(question VARCHAR, answer VARCHAR);");

        db.execSQL("INSERT INTO " + TABLE + "(question, answer) VALUES('When was the first iPhone launched?','2007')");
        db.execSQL("INSERT INTO " + TABLE + "(question, answer) VALUES('When was the iPod launched?','2001')");

        //db.execSQL("delete from "+TABLE);
        questionArray = new String[2];
        answerArray = new String[2];
        Cursor allrows  = db.rawQuery("SELECT * FROM "+  TABLE, null);

        if(allrows.moveToFirst()){
            do{
                String ques = allrows.getString(0);
                String ans= allrows.getString(1);
                questionArray[current] = ques;
                answerArray[current] = ans;
                current++;
                if(current>=2)
                    current=0;

            } while(allrows.moveToNext());
        }
        db.close();
       // current = 0;
    j=0;
        TextView tf2 = (TextView)findViewById(R.id.textView2);
        tf2.setText(questionArray[j]);

        Button submitButton = (Button) findViewById(R.id.submitButton);
        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TextView tf = (TextView)findViewById(R.id.editText);
                    String userAnswer = tf.getText().toString();
                tf.setText("");
                if (answerArray[j].equals(userAnswer)){
                    correctAnswers++;
                }

                if ((j +1)<questionArray.length){
                    j++;
                    TextView tf2 = (TextView)findViewById(R.id.textView2);
                    tf2.setText(questionArray[j]);
                }
                else {
                    j = 0;
                    String toastString = "You got "+correctAnswers+ " correct answers!";
                    System.out.println(toastString);
                    Toast toast= Toast.makeText(getApplicationContext(),toastString,Toast.LENGTH_SHORT);
                    toast.show();
                    TextView tf2 = (TextView)findViewById(R.id.textView2);
                    tf2.setText(questionArray[j]);
                    correctAnswers = 0;
                }
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
