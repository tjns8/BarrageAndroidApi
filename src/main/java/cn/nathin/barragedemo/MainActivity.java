package cn.nathin.barragedemo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;


public class MainActivity extends Activity implements OnClickListener{
	EditText editText=null;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		findViewById(R.id.button_1).setOnClickListener(this);
		findViewById(R.id.button_2).setOnClickListener(this);
	}

	@Override
	public void onClick(View arg0) {
		// TODO Auto-generated method stub
		switch (arg0.getId()){
			case R.id.button_1:
				startActivity(new Intent(this,VideoActivity.class));
				break;
			case R.id.button_2:
				startActivity(new Intent(this,ImageActivity.class));
				break;
		}
	}
}
