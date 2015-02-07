package br.com.mixersoundguide.listas;

import com.example.mixersoundguide.R;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class RedroduzirFrequenciaListAdapter extends ArrayAdapter<String>{
	
	private Context context;
	private int layoutResourceId;
	private String[] frequencias;
	private String[] instrumentos;
	
	public RedroduzirFrequenciaListAdapter(Context context, int layoutResourceId, String[] frequencias, String[] instrumentos) {
		super(context, layoutResourceId, frequencias);
		this.context = context;
		this.layoutResourceId = layoutResourceId;
		this.frequencias = frequencias;
		this.instrumentos = instrumentos;
	}
	
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		
		View item = convertView;
		LayoutInflater inflater = ((Activity) context).getLayoutInflater();
		item = inflater.inflate(layoutResourceId, parent, false);
		
		TextView txtFrequencia = (TextView) item.findViewById(R.id.Frequencia);
		TextView txtInstrumento = (TextView) item.findViewById(R.id.Instrumento);
		Button btnReproduzir = (Button) item.findViewById(R.id.btnReproduzir);
		Button btnParar = (Button) item.findViewById(R.id.btnParar);
		
		txtFrequencia.setText(frequencias[position]);
		txtInstrumento.setText(instrumentos[position]);
		
		btnReproduzir.setOnClickListener(new OnClickListener() {
		
			@Override
			public void onClick(View v) {
				Toast.makeText(context, "Reproduzir", Toast.LENGTH_LONG).show();
			}
			
		});
		
		btnParar.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Toast.makeText(context, "Parar", Toast.LENGTH_LONG).show();
			}
			
		});
		
		return item;
	}
}
