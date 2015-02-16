package br.com.mixersoundguide.activity;

import com.example.mixersoundguide.R;

import android.app.Activity;
import android.os.Bundle;
import android.view.MenuItem;

public class MedioGraveActivity extends Activity{
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_medio_grave);
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
