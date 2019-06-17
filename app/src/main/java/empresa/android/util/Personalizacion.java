package empresa.android.util;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

import empresa.android.bean.PersonaBean;
import empresa.android.principal.R;

public class Personalizacion extends BaseAdapter {
    private static ArrayList<PersonaBean> lista;
    private LayoutInflater minInflater;


    public Personalizacion(Context context, ArrayList<PersonaBean> lista) {
        this.minInflater = minInflater.from(context);
        this.lista = lista;
    }

    @Override
    public int getCount() {
        return lista.size();
    }

    @Override
    public Object getItem(int position) {
        return lista.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    static class ViewHolder {
        TextView LBLCODIGO;
        TextView LBLNOMBRE;
        TextView LBLAPELLIDO;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;

        if (convertView == null)

        {
            convertView = minInflater.inflate(R.layout.grilla, null);
            holder = new ViewHolder();
            holder.LBLCODIGO = (TextView) convertView.findViewById(R.id.LBLCODIGO);
            holder.LBLNOMBRE = (TextView) convertView.findViewById(R.id.LBLNOMBRE);
            holder.LBLAPELLIDO = (TextView) convertView.findViewById(R.id.LBLAPELLIDO);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        holder.LBLCODIGO.setText(lista.get(position).getCODPERSO());
        holder.LBLNOMBRE.setText(lista.get(position).getNOMBPERSO());
        holder.LBLAPELLIDO.setText(lista.get(position).getAPELLIPERSO());

        return convertView;
    }

}