package sorte.shubham.myapplication;

import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    public static Integer a;
    public static Integer b;
    public static Integer answer;
    public  static char operation;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button plusButton = (Button) findViewById(R.id.plus);
        Button subtractButton = (Button) findViewById(R.id.subtract);
        Button multiplyButton = (Button) findViewById(R.id.multiply);
        Button divideButton = (Button) findViewById(R.id.divide);
        Button equalsButton = (Button) findViewById(R.id.equalButton);
        Button acButton = (Button) findViewById(R.id.acButton);
        Button decButton = (Button) findViewById(R.id.buttonDecimal);

        // Operations
        plusButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TextView tf = (TextView)findViewById(R.id.editText);
                if (a== null) {
                a = Integer.parseInt(tf.getText().toString());
                }
                else {
                    a = answer;
                }
                tf.setText("");
                operation = '+';
            }
        });

        subtractButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TextView tf = (TextView)findViewById(R.id.editText);
                if (a== null) {
                    a = Integer.parseInt(tf.getText().toString());
                }
                else {
                    a = answer;
                }
                tf.setText("");
                operation = '-';
            }
        });

        divideButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TextView tf = (TextView)findViewById(R.id.editText);
                if (a== null) {
                    a = Integer.parseInt(tf.getText().toString());
                }
                else {
                    a = answer;
                }
                tf.setText("");
                operation = '/';
            }
        });

        multiplyButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TextView tf = (TextView)findViewById(R.id.editText);
                if (a== null) {
                    a = Integer.parseInt(tf.getText().toString());
                }
                else {
                    a = answer;
                }
                tf.setText("");
                operation = '*';
            }
        });

        equalsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TextView tf = (TextView)findViewById(R.id.editText);
                b = Integer.parseInt(tf.getText().toString());

                switch (operation) {
                    case '+':answer = a+b;
                            break;
                    case '-':answer = a-b;
                            break;
                    case '/': answer = a/b;
                            break;
                    case '*':answer = a*b;
                            break;
                    default:break;
                }

                tf.setText(""+answer);
            }
        });

        acButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TextView tf = (TextView)findViewById(R.id.editText);
                tf.setText("");
                a= null;
                b = null;
                answer = null;
            }
        });

        // Number Buttons
        Button buttonOne = (Button) findViewById(R.id.buttonOne);
        Button buttonTwo = (Button) findViewById(R.id.buttonTwo);
        Button buttonThree = (Button) findViewById(R.id.buttonThree);
        Button buttonFour = (Button) findViewById(R.id.buttonFour);
        Button buttonFive = (Button) findViewById(R.id.buttonFive);
        Button buttonSix = (Button) findViewById(R.id.buttonSix);
        Button buttonSeven = (Button) findViewById(R.id.buttonSeven);
        Button buttonEight = (Button) findViewById(R.id.buttonEight);
        Button buttonNine = (Button) findViewById(R.id.buttonNine);
        Button buttonZero = (Button) findViewById(R.id.buttonZero);

        buttonOne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                changeTextFieldContent(1);
            }
        });

        buttonTwo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                changeTextFieldContent(2);
            }
        });
        buttonThree.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                changeTextFieldContent(3);
            }
        });
        buttonFour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                changeTextFieldContent(4);
            }
        });
        buttonFive.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                changeTextFieldContent(5);
            }
        });
        buttonSix.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                changeTextFieldContent(6);
            }
        });
        buttonSeven.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                changeTextFieldContent(7);
            }
        });
        buttonEight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                changeTextFieldContent(8);
            }
        });
        buttonNine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                changeTextFieldContent(9);
            }
        });
        buttonZero.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                changeTextFieldContent(0);
            }
        });

    }

    public void changeTextFieldContent(Integer x) {
        TextView tf = (TextView)findViewById(R.id.editText);
        //tf.setText(""+x);
//        if (a == null) {
//            a = new Float(x);
//        }
//        else if ((a!=null)&&(b!=null)) {
//            a = new Float(answer);
//            b = new Float(x);
//        }
//        else {
//            a = new Float(b);
//            b = new Float(x);
//        }
        if (tf.getText().toString() != "0") {
            String str = tf.getText().toString();
            tf.setText(str + "" + x);
        }
        else
            tf.setText(""+x);

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
