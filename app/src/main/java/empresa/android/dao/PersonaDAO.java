package empresa.android.dao;


import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import empresa.android.bean.PersonaBean;

public class PersonaDAO
{
    ArrayList<PersonaBean> listado=null;
    String ruta1="http://10.0.3.2:80/PROYECTOSERVIDORHTTPBUSCAR/controlador/personacontrolador.php";
    String ruta2="http://10.0.3.2:80/PROYECTOSERVIDORHTTPINSERTAR/CONTROLADOR/PersonaControlador.php";
    public  ArrayList<PersonaBean> BuscarPersonas(PersonaBean  objPersonaBean)
    {
        InputStream is = null;
        String linea,txtapellido;

        try
        {
                txtapellido=objPersonaBean.getAPELLIPERSO();

                List<NameValuePair> parametros = new ArrayList<NameValuePair>();

                parametros.add(new BasicNameValuePair("TXTAPELLIDO",txtapellido));
                listado=new ArrayList<PersonaBean>();
                HttpClient cn = new DefaultHttpClient();
                HttpPost post = new HttpPost(ruta1);

                post.setEntity(new UrlEncodedFormEntity(parametros));

                HttpResponse respuesta = cn.execute(post);
                HttpEntity entidad = respuesta.getEntity();

                is = entidad.getContent();

                BufferedReader reader = new BufferedReader(new InputStreamReader(is));
                StringBuilder trama = new StringBuilder();

                while ((linea=reader.readLine())!=null)
                {
                    trama.append(linea + "\n");
                }

                JSONObject json=new JSONObject(trama.toString());
                JSONArray personas=json.getJSONArray("PERSONA");

                for (int i=0;i<personas.length();i++)
                {
                    JSONObject formato=personas.getJSONObject(i);
                    objPersonaBean=new PersonaBean();
                    objPersonaBean.setCODPERSO(formato.getString("CODPERSO"));
                    objPersonaBean.setNOMBPERSO(formato.getString("NOMBPERSO"));
                    objPersonaBean.setAPELLIPERSO(formato.getString("APELLIPERSO"));
                    listado.add(objPersonaBean);
                }

        } catch (Exception e)
        {
        }
        return listado;
    }

    public  ArrayList<PersonaBean> InsertarPersonas(PersonaBean  objPersonaBean)
    {
        InputStream is = null;
        String linea,txtcodigo,txtnombre,txtapellido;

        try
        {
            txtcodigo=objPersonaBean.getCODPERSO();
            txtnombre=objPersonaBean.getNOMBPERSO();
            txtapellido=objPersonaBean.getAPELLIPERSO();


            List<NameValuePair> parametros = new ArrayList<NameValuePair>();

            parametros.add(new BasicNameValuePair("TXTCODIGO",txtcodigo));
            parametros.add(new BasicNameValuePair("TXTNOMBRE", txtnombre));
            parametros.add(new BasicNameValuePair("TXTAPELLIDO",txtapellido));

            listado=new ArrayList<PersonaBean>();
            HttpClient cn = new DefaultHttpClient();
            HttpPost post = new HttpPost(ruta2);

            post.setEntity(new UrlEncodedFormEntity(parametros));

            HttpResponse respuesta = cn.execute(post);
            HttpEntity entidad = respuesta.getEntity();

            is = entidad.getContent();

            BufferedReader reader = new BufferedReader(new InputStreamReader(is));
            StringBuilder trama = new StringBuilder();

            while ((linea=reader.readLine())!=null)
            {
                trama.append(linea + "\n");
            }

            JSONObject json=new JSONObject(trama.toString());
            JSONArray personas=json.getJSONArray("PERSONA");

            for (int i=0;i<personas.length();i++)
            {
                JSONObject formato=personas.getJSONObject(i);
                objPersonaBean=new PersonaBean();
                objPersonaBean.setCODPERSO(formato.getString("CODPERSO"));
                objPersonaBean.setNOMBPERSO(formato.getString("NOMBPERSO"));
                objPersonaBean.setAPELLIPERSO(formato.getString("APELLIPERSO"));
                listado.add(objPersonaBean);
            }

        } catch (Exception e)
        {
        }
        return listado;
    }
}
