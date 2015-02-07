package br.com.mixersoundguide.menu;

import android.app.AlertDialog;
import android.app.Fragment;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.TextView;
import br.com.mixersoundguide.activity.GraveActivity;
import br.com.mixersoundguide.activity.MedioAltoActivity;
import br.com.mixersoundguide.activity.MedioGraveActivity;
import br.com.mixersoundguide.activity.SubGraveActivity;
import br.com.mixersoundguide.listas.FrequenciaListAdapter;

import com.example.mixersoundguide.R;

public class FragmentOne extends Fragment{

	TextView tvItemName;
	ListView lista;
	
	String[] itemnames ={
			"Sub Grave",
			"Grave",
			"Médio Grave",
			"Médio Alto",
		};
		
	String[] descriptions ={
			"de 20 Hz a 60 Hz",
			"de 60 Hz a 250 Hz",
			"de 250 Hz a 2 kHz",
			"de 2 kHz a 6 kHz",
		};
		
		Integer[] imgid ={
			R.drawable.ic_auto_falante,	
			R.drawable.ic_auto_falante,	
			R.drawable.ic_auto_falante,	
			R.drawable.ic_auto_falante,	
		};

	public static final String ITEM_NAME = "itemName";
	
	public FragmentOne() {

	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		
		View view = inflater.inflate(R.layout.fragment_layout_one, container,
				false);
		
		FrequenciaListAdapter arrayAdapter = new FrequenciaListAdapter(getActivity(),itemnames, descriptions, imgid);
		
		lista = (ListView) view.findViewById(R.id.lista);

		tvItemName = (TextView) view.findViewById(R.id.frag1_text);

		lista.setAdapter(arrayAdapter);
		
		lista.setOnItemClickListener(new OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> arrayAdapter, View view, int posicao, long id) {
				onListItemClick(arrayAdapter, view, posicao, id);			
			}
		});
		
		return view;
	}
	
	private void openAlert(String title, int position) {
		AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(getActivity());
		alertDialogBuilder.setTitle(title);
		alertDialogBuilder.setMessage("Para ouvir as frequências com nitidez é recomedável utilizar o Fone de Ouvido. \n"
				+ "Deseja continuar?");
		
		
		switch (position) {
		
		case 0:
			alertDialogBuilder.setPositiveButton("Sim", new DialogInterface.OnClickListener() {
				public void onClick(DialogInterface dialog, int id) {
					Intent subGraveActivity = new Intent(getActivity(), SubGraveActivity.class);
					startActivity(subGraveActivity);
				}
			});
			break;
		case 1:
			alertDialogBuilder.setPositiveButton("Sim", new DialogInterface.OnClickListener() {
				public void onClick(DialogInterface dialog, int id) {
					Intent graveActivity = new Intent(getActivity(), GraveActivity.class);
					startActivity(graveActivity);
				}
			});
			break;
		case 2:
			alertDialogBuilder.setPositiveButton("Sim", new DialogInterface.OnClickListener() {
				public void onClick(DialogInterface dialog, int id) {
					Intent medioGraveActivity = new Intent(getActivity(), MedioGraveActivity.class);
					startActivity(medioGraveActivity);
				}
			});
			break;
		case 3:
			alertDialogBuilder.setPositiveButton("Sim", new DialogInterface.OnClickListener() {
				public void onClick(DialogInterface dialog, int id) {
					Intent medioAltoActivity = new Intent(getActivity(), MedioAltoActivity.class);
					startActivity(medioAltoActivity);
				}
			});
			break;
		default:
			break;
		}
		
		alertDialogBuilder.setNegativeButton("Não", new DialogInterface.OnClickListener() {		
			public void onClick(DialogInterface dialog, int id) {
				dialog.cancel();
			}
		});
		
		AlertDialog alertDialog = alertDialogBuilder.create();
		alertDialog.show();	

	}

	public void onListItemClick(AdapterView<?> arrayAdapter, View view, int position, long id) {  
		
		String text;
		
		switch (position) {
		
		case 0:
			text = (String) arrayAdapter.getItemAtPosition(position);
			openAlert(text, position);
			break;
		case 1:
			text = (String) arrayAdapter.getItemAtPosition(position);
			openAlert(text, position);
			break;
		case 2:
			text = (String) arrayAdapter.getItemAtPosition(position);
			openAlert(text, position);
			break;
		case 3:
			text = (String) arrayAdapter.getItemAtPosition(position);
			openAlert(text, position);
			break;
		default:
			break;
		}
		
	}	
	
}
