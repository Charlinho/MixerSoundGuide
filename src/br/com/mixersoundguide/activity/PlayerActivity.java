package br.com.mixersoundguide.activity;

import java.util.concurrent.TimeUnit;

import com.example.mixersoundguide.R;

import android.app.Activity;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.SeekBar;
import android.widget.TextView;

public class PlayerActivity extends Activity {

	private MediaPlayer mediaPlayer;
	public TextView nomeMidi, duracao;
	private double tempoInicial = 0, tempoFinal = 0;
	private Handler durationHandler = new Handler();
	private SeekBar seekbar;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_player);
		
		initializeViews();

	}

	public void initializeViews() {
		nomeMidi = (TextView) findViewById(R.id.nomeMidi);
		mediaPlayer = MediaPlayer.create(this, R.raw.piano_2_5k);
		tempoFinal = mediaPlayer.getDuration();
		duracao = (TextView) findViewById(R.id.duracao);
		seekbar = (SeekBar) findViewById(R.id.seekBar);
		nomeMidi.setText("Piano - 32 Hz");

		seekbar.setMax((int) tempoFinal);
		seekbar.setClickable(false);
	}

	public void play(View view) {
		mediaPlayer.start();
		tempoInicial = mediaPlayer.getCurrentPosition();
		seekbar.setProgress((int) tempoInicial);
		durationHandler.postDelayed(updateSeekBarTime, 100);
	}

	private Runnable updateSeekBarTime = new Runnable() {
		public void run() {
			// get current position
			tempoInicial = mediaPlayer.getCurrentPosition();
			// set seekbar progress
			seekbar.setProgress((int) tempoInicial);
			// set time remaing
			double timeRemaining = tempoFinal - tempoInicial;
			duracao.setText(String.format(
					"%d min, %d sec",
					TimeUnit.MILLISECONDS.toMinutes((long) timeRemaining),
					TimeUnit.MILLISECONDS.toSeconds((long) timeRemaining)
							- TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes((long) timeRemaining))));

			// repeat yourself that again in 100 miliseconds
			durationHandler.postDelayed(this, 100);
		}
	};

	public void pause(View view) {
		mediaPlayer.pause();
	}

}
