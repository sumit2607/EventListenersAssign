package com.sumit.eventlistenersassign;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Button btn;
    private  EditText editText = findViewById(R.id.edittext);
    private static final String TAG = MainActivity.class.getSimpleName();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setContentView(R.layout.activity_main); // Inflate the layout i.e so that the user can see it on the screen.
        initViewsAndListeners();
        btn = findViewById(R.id.btn);
        editText = findViewById(R.id.edittext);
        btn.addTextChangedListener(textWatcher);
    }

    private void initViewsAndListeners() {
        btn = findViewById(R.id.btn); // connects the button defined in the xml using the id
        btn.setOnClickListener(this); // We need to set the click listeners on the view so that the callback is received in onClick(View view) method
    }


    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btn) {
            Toast.makeText(MainActivity.this, "Btn clicked", Toast.LENGTH_SHORT).show();
            Log.d("mainActivity", "Button clicked"); // called when the user clicks the button
        }
    }

    private final TextWatcher textWatcher = new TextWatcher() {
        /*
       This method is called to notify you that, within charSequence, the count characters beginning at start are
       about to be replaced by new text with length after. It is an error to attempt to make changes to charSequence from this callback.
        */
        @Override
        public void beforeTextChanged(CharSequence charSequence, int start, int count, int after) {
            Log.d(TAG, "before " + charSequence.toString() + " start " + start + " count " + count + " after " + after);
        }

        /*
        This method is called to notify you that, within charSequence, the count characters beginning at start have
         just replaced old text that had length before. It is an error to attempt to make changes to charSequence from this callback.
         */
        @Override
        public void onTextChanged(CharSequence charSequence, int start, int before, int count) {
            Log.d(TAG, "after " + charSequence.toString() + " start " + start + " count " + count + " before " + before);
        }

        /*
        This method is called to notify you that, somewhere within s, the text has been changed.
        It is legitimate to make further changes to s from this callback, but be careful not to get yourself
         into an infinite loop, because any changes you make will cause this method to be called again recursively.
         */
        @Override
        public void afterTextChanged(Editable s) {
            if( s.toString().length()>=6){
                Toast.makeText(MainActivity.this, "MasaiSchool", Toast.LENGTH_SHORT).show();
            }
        }
    };


}
