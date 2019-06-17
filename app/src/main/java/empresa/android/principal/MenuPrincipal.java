package empresa.android.principal;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class MenuPrincipal   extends AppCompatActivity implements View.OnClickListener
{
    Button  BTNBUSCAR,BTNINSERTAR ;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menuprincipal);
        BTNBUSCAR=(Button)findViewById(R.id.BTNGRABAR);
        BTNINSERTAR=(Button)findViewById(R.id.BTNINSERTAR);
        BTNBUSCAR.setOnClickListener(this);
        BTNINSERTAR.setOnClickListener(this);

    }
     public  void  Buscar()
     {
         Intent   objIntent=new Intent(MenuPrincipal.this,BuscarPersona.class);
                  startActivity(objIntent);
         finish();

     }
     public  void Insertar()
     {
         Intent   objIntent=new Intent(MenuPrincipal.this,InsertarPersona.class);
         startActivity(objIntent);
         finish();
     }

    @Override
    public void onClick(View v)
    {   if(v==BTNBUSCAR)
         {  Buscar();
         }
        if(v==BTNINSERTAR)
        {  Insertar();
        }
    }




    




}
