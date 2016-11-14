package sorte.shubham.appleclinicmanagement;

import android.content.Context;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AdapterView.OnItemClickListener;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import android.database.sqlite.SQLiteDatabase;

public class ListViewActivity extends AppCompatActivity {
    private static String DBNAME = "shubhsin.db";    // THIS IS THE SQLITE DATABASE FILE NAME.
    private static String TABLE = "APPLECLINIC";
    String[] firstnameArray;
    String[] lastnameArray;
    String[] ageArray;
    String[] detailArray;
    int current = 0;
    ListView listView ;
    SQLiteDatabase  db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view);
        db = openOrCreateDatabase(DBNAME, Context.MODE_PRIVATE,null);
        listView = (ListView) findViewById(R.id.listView);


        Cursor allrows  = db.rawQuery("SELECT * FROM "+  TABLE, null);
        int countNum = allrows.getCount();
        firstnameArray = new String[countNum];
        lastnameArray = new String[countNum];
        ageArray = new String[countNum];
        detailArray = new String[countNum];
        if(allrows.moveToFirst()){
            do{
                String fn = allrows.getString(0);
                String ln= allrows.getString(1);
                firstnameArray[current] = fn;
                lastnameArray[current] = ln;
                ageArray[current] = allrows.getString(2);
                detailArray[current] = allrows.getString(3);
                current++;
            } while(allrows.moveToNext());
        }
        db.close();

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1, android.R.id.text1, firstnameArray);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {

                // ListView Clicked item index
                int itemPosition = position;

                // ListView Clicked item value
                String fn = firstnameArray[position];
                String alertMsg = firstnameArray[position] + " " + lastnameArray[position] +"\nAGE - "+ageArray[position]+"\n"+"MEDICAL INFO - \n"+detailArray[position];

                // Show Alert
                Toast.makeText(getApplicationContext(), alertMsg, Toast.LENGTH_LONG).show();

            }

        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_list_view, menu);
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
