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

public class InsertarPersona extends AppCompatActivity   implements View.OnClickListener
{
    EditText   TXTCODIGO,TXTNOMBRE, TXTAPELLIDO;
    Button     BTNINSERTAR ,BTNREGRESAR;

    ListView LSTPERSONA;
    ArrayList<PersonaBean> listado=null;

    PersonaBean objPersonaBean=null;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {   super.onCreate(savedInstanceState);
        setContentView(R.layout.insertarpersona);

        TXTCODIGO=(EditText)findViewById(R.id.TXTCODIGO);
        TXTNOMBRE=(EditText)findViewById(R.id.TXTNOMBRE);
        TXTAPELLIDO=(EditText)findViewById(R.id.TXTAPELLIDO);
        BTNINSERTAR=(Button)findViewById(R.id.BTNGRABAR);
        BTNINSERTAR.setOnClickListener(this);
        BTNREGRESAR=(Button)findViewById(R.id.BTNREGRESAR);
        BTNREGRESAR.setOnClickListener(this);
        LSTPERSONA=(ListView)findViewById(R.id.LSTPERSONA);
    }
    public  void Regresar()
    {
        Intent  objIntent=new Intent(InsertarPersona.this,MenuPrincipal.class);
        startActivity(objIntent);
        finish();
    }
    @Override
    public void onClick(View v)
    {   if(v==BTNREGRESAR)
    {   Regresar();
    }
        if(v==BTNINSERTAR)
        {
            Insertar();
        }
    }

    public   void Insertar()
    {
        String  txtcodigo,txtnombre,txtapellido;

        txtcodigo=TXTCODIGO.getText().toString();
        txtnombre=TXTNOMBRE.getText().toString();
        txtapellido=TXTAPELLIDO.getText().toString();

        PersonaBean  objpersonabean=new PersonaBean();

        objpersonabean.setCODPERSO(txtcodigo);
        objpersonabean.setNOMBPERSO(txtnombre);
        objpersonabean.setAPELLIPERSO(txtapellido);

        PersonaDAO  objpersonadao=new PersonaDAO();

        listado=objpersonadao.InsertarPersonas(objpersonabean);
        LSTPERSONA.setAdapter(new Personalizacion(this,listado));
    }

}

