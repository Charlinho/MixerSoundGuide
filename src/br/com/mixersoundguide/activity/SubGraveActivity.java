package br.com.mixersoundguide.activity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.view.MenuItem;
import android.view.View;
import android.widget.ExpandableListView;
import android.widget.ExpandableListView.OnChildClickListener;
import android.widget.SeekBar;
import android.widget.TextView;
import br.com.mixersoundguide.listas.ExpandableListAdapter;
import br.com.mixersoundguide.listas.ExpandableListDataPump;

import com.example.mixersoundguide.R;

public class SubGraveActivity extends Activity {

	ExpandableListView expandableListView;
	ExpandableListAdapter expandableListAdapter;
	List<String> expandableListTitle;
	HashMap<String, List<String>> expandableListDetail;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_sub_grave);
		getActionBar().setDisplayHomeAsUpEnabled(true);

		expandableListView = (ExpandableListView) findViewById(R.id.expandableListView);

		expandableListDetail = ExpandableListDataPump.getData();
		expandableListTitle = new ArrayList(expandableListDetail.keySet());
		expandableListAdapter = new ExpandableListAdapter(this, expandableListTitle, expandableListDetail);

		expandableListView.setAdapter(expandableListAdapter);

		expandableListView.setOnChildClickListener(new OnChildClickListener() {
			@Override
			public boolean onChildClick(ExpandableListView parent, View v, int groupPosition, int childPosition, long id) {
				Intent playerActivity = new Intent(getBaseContext(), PlayerActivity.class);
				playerActivity.
				startActivity(playerActivity);
				// Toast.makeText(
				// getApplicationContext(),
				// expandableListTitle.get(groupPosition)
				// + " -> "
				// + expandableListDetail.get(
				// expandableListTitle.get(groupPosition)).get(
				// childPosition), Toast.LENGTH_SHORT
				// )
				// .show();
				return true;
			}
		});
	}

//	public void initializeViews() {
//		nomeMidi = (TextView) findViewById(R.id.nomeMidi);
//		mediaPlayer = MediaPlayer.create(this, R.raw.piano_32hz);
//		tempoFinal = mediaPlayer.getDuration();
//		duracao = (TextView) findViewById(R.id.duracao);
//		seekbar = (SeekBar) findViewById(R.id.seekBar);
//		nomeMidi.setText("Piano 32Hz");
//
//		seekbar.setMax((int) tempoFinal);
//		seekbar.setClickable(false);
//	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case android.R.id.home:
			finish();
		}
		return super.onOptionsItemSelected(item);
	}

}
