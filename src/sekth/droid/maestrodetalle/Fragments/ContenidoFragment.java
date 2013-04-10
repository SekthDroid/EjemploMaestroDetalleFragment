package sekth.droid.maestrodetalle.Fragments;

import sekth.droid.maestrodetalle.R;
import sekth.droid.maestrodetalle.Clases.Contenido;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class ContenidoFragment extends Fragment {
	public static final String POSICION = "position";
	int position = -1;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		
		// Comprobamos si se recupera de un estado anterior
		if (savedInstanceState != null){
			position = savedInstanceState.getInt("position");
		}
		
		return inflater.inflate(R.layout.contenido_fragment, container, false);
	}

	@Override
	public void onStart() {
		// TODO Auto-generated method stub
		super.onStart();
		
		// Comprobamos si tenemos argumentos
		Bundle args = getArguments();
		if (args != null){
			// Si tenemos argumentos, establecemos la posicion
			actualizarContenido(args.getInt(POSICION));
		}else if(position != -1){
			// Si la variable de instancia es diferente a -1
			// quiere decir que nos hemos recuperado de un estado anterior
			// y actualizamos el contenido
			actualizarContenido(position);
		}
	}
	
	public void actualizarContenido(int position){
		
		// Instanciamos el TextView y establecemos el contenido
		TextView tvContenido = (TextView)getActivity().findViewById(R.id.tvContenido);
		tvContenido.setText(Contenido.descripcion[position]);
		
		// Guardamos la posicion del elemento que estamos consultando
		this.position = position;
	}
	
	@Override
	public void onSaveInstanceState(Bundle outState) {
		// TODO Auto-generated method stub
		super.onSaveInstanceState(outState);
		
		// Guardamos el estado de la posicion del elemento
		// que estábamos consultando
		outState.putInt(POSICION, position);
	}

}
