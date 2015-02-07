package br.com.mixersoundguide.activity;

import br.com.mixersoundguide.listas.RedroduzirFrequenciaListAdapter;

import com.example.mixersoundguide.R;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.Toast;

public class SubGraveActivity extends Activity{
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_sub_grave);
		
		ListView listaDeFrequecias;
		
		String[] frequencias ={
				"32 Hz",
				"32 Hz",
				"40 Hz",
				"40 Hz",
				"50 Hz",
				"50 Hz",
				"60 Hz",
				"60 Hz",
			};
		
		String[] instrumentos ={
				"Contra Baixo Acústico",
				"Piano",
				"Contra Baixo Acústico",
				"Piano",
				"Contra Baixo Acústico",
				"Piano",
				"Contra Baixo Acústico",
				"Piano",
			};

		RedroduzirFrequenciaListAdapter arrayAdapter = new RedroduzirFrequenciaListAdapter(SubGraveActivity.this, 
				R.layout.lista_reproduz_frequencia, frequencias, instrumentos);
		
		listaDeFrequecias = (ListView) findViewById(R.id.listView);
		listaDeFrequecias.setItemsCanFocus(false);
		listaDeFrequecias.setAdapter(arrayAdapter);
		
		listaDeFrequecias.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
				 Toast.makeText(SubGraveActivity.this, "List Item Clicked:" + position, Toast.LENGTH_LONG).show();
			}
		});
		
	}
}
