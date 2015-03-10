package ro.pub.cs.systems.pdsd.lab03.phonedialer;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;


public class PhoneDialerActivity extends Activity {

    private Button [] bs;
    ImageButton call,hangup,delete;
    EditText text;
    String inputText;
    int i;

	@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_phone_dialer);
    //    setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        inputText="";
        text=(EditText) findViewById(R.id.introduce_yourself_edit_text);
        bs=new Button[13];
        bs[0]=(Button) findViewById(R.id.submit_button0);
        bs[1]=(Button) findViewById(R.id.submit_button1);
        bs[2]=(Button) findViewById(R.id.submit_button2);
        bs[3]=(Button) findViewById(R.id.submit_button3);
        bs[4]=(Button) findViewById(R.id.submit_button4);
        bs[5]=(Button) findViewById(R.id.submit_button5);
        bs[6]=(Button) findViewById(R.id.submit_button6);
        bs[7]=(Button) findViewById(R.id.submit_button7);
        bs[8]=(Button) findViewById(R.id.submit_button8);
        bs[9]=(Button) findViewById(R.id.submit_button9);
        bs[10]=(Button) findViewById(R.id.submit_button_star);
        bs[11]=(Button) findViewById(R.id.submit_button_diez);
        call=(ImageButton) findViewById(R.id.imageButton2);
        hangup=(ImageButton) findViewById(R.id.imageButton3);
        delete=(ImageButton) findViewById(R.id.imageButton1);
        
        
        for (int i=0;i<=9;i++){
        	final int number=i;
        	bs[i].setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View v) {
					// TODO Auto-generated method stub
					
					inputText=inputText.concat(""+number);
					System.out.println ("TEXTTT " + inputText);
					text.setText(inputText);
					
				}
			});
        }
    
	
	bs[10].setOnClickListener(new OnClickListener() {
		
		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			inputText=inputText.concat("*");
			text.setText(inputText);
			
		}
	});
	
	bs[11].setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				inputText=inputText.concat("#");
				text.setText(inputText);
				
			}
		});
	
	call.setOnClickListener(new OnClickListener() {
		
		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			Intent intent = new Intent(Intent.ACTION_CALL);
			intent.setData(Uri.parse("tel:"+inputText));
			startActivity(intent);
			
		}
	});
	
	
	hangup.setOnClickListener(new OnClickListener() {
		
		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			finish();
			
		}
	});
	
	delete.setOnClickListener(new OnClickListener() {
		
		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			inputText=inputText.substring(0, inputText.length()-1);
			text.setText(inputText);
			
		}
	});
}


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.phone_dialer, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
