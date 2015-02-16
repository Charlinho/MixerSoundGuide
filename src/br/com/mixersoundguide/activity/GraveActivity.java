package br.com.mixersoundguide.activity;

import android.app.Activity;
import android.os.Bundle;
import android.view.MenuItem;

import com.example.mixersoundguide.R;

public class GraveActivity extends Activity{
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_grave);
		getActionBar().setDisplayHomeAsUpEnabled(true);
	}
	
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
	    switch (item.getItemId()) {
	    // Id correspondente ao botão Up/Home da actionbar
	    case android.R.id.home:
	    	finish();
	    }
	    return super.onOptionsItemSelected(item);
	}
}
