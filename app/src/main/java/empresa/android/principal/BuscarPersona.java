package empresa.android.principal;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;
import empresa.android.bean.PersonaBean;
import empresa.android.util.Personalizacion;
import  empresa.android.dao.PersonaDAO;

public class BuscarPersona extends AppCompatActivity   implements View.OnClickListener {

    EditText TXTAPELLIDO;
    Button   BTNBUSCAR ,BTNREGRESAR;

    ListView LSTPERSONA;
    ArrayList<PersonaBean> listado=null;

    PersonaBean objPersonaBean=null;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {   super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);
        LSTPERSONA=(ListView)findViewById(R.id.LSTPERSONA);

        TXTAPELLIDO=(EditText)findViewById(R.id.TXTAPELLIDO);
        BTNBUSCAR=(Button)findViewById(R.id.BTNGRABAR);
        BTNBUSCAR.setOnClickListener(this);
        BTNREGRESAR=(Button)findViewById(R.id.BTNREGRESAR);
        BTNREGRESAR.setOnClickListener(this);
    }
    public  void Regresar()
    {
        Intent  objIntent=new Intent(BuscarPersona.this,MenuPrincipal.class);
        startActivity(objIntent);
        finish();
    }
    @Override
    public void onClick(View v)
    {   if(v==BTNREGRESAR)
        {   Regresar();
        }
        if(v==BTNBUSCAR)
        {
           Buscar();
        }
    }

   public   void Buscar()
   {
          String  txtapellido;
          txtapellido=TXTAPELLIDO.getText().toString();
          PersonaBean  objpersonabean=new PersonaBean();
                       objpersonabean.setAPELLIPERSO(txtapellido);
          PersonaDAO  objpersonadao=new PersonaDAO();
              listado=objpersonadao.BuscarPersonas(objpersonabean);
              LSTPERSONA.setAdapter(new Personalizacion(this,listado));
   }

}

