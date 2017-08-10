package com.kaneex.day7;

import android.content.Intent;
import android.net.Uri;
import android.provider.MediaStore;
import android.provider.Settings;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.net.URI;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    EditText editText,editText2,editText3;
    Button button,button2,button3,button4;
    Uri uri;
    String text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editText=(EditText)findViewById(R.id.editText);
        editText2=(EditText)findViewById(R.id.editText2);
        editText3=(EditText)findViewById(R.id.editText3);
        button=(Button)findViewById(R.id.button);
        button.setOnClickListener(this);
        button2=(Button)findViewById(R.id.button2);
        button2.setOnClickListener(this);
        button3=(Button)findViewById(R.id.button3);
        button3.setOnClickListener(this);
        button4=(Button)findViewById(R.id.button4);
        button4.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch ((v.getId())) {
            case (R.id.button):
                text = editText.getText().toString();
                Intent inte = new Intent(Intent.ACTION_VIEW, Uri.parse("https://" +text));
                startActivity(inte);
                break;
            case R.id.button2:
                text = editText.getText().toString();
                Intent it=new Intent(Intent.ACTION_VIEW,Uri.parse("geo: "+ text));
                startActivity(it);
                break;
            case R.id.button3:
                Intent sendIntent = new Intent();
                sendIntent.setAction(Intent.ACTION_SEND);
                String sen=editText3.getText().toString();
                sendIntent.putExtra(Intent.EXTRA_TEXT,(sen));
               sendIntent.setType("text/plain");
                startActivity(sendIntent);
                break;
            case R.id.button4:
                Intent itt=new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivity(itt);
                break;
        }

    }
}
