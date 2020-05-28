package le_on.iniciosesionsimple;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import static le_on.iniciosesionsimple.Login.EXTRA_MESSAGE;

public class Formulario extends AppCompatActivity
{
    private Button btnSalir;
    private TextView txtvMensaje;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formulario);

        //Unir Vista con Controlador (codigo)
        btnSalir = (Button) findViewById(R.id.btn_salir);
        txtvMensaje = (TextView) findViewById(R.id.txtv_mensaje);

        Intent intent_formulario = getIntent();
        String MensajeRecibido = intent_formulario.getStringExtra(EXTRA_MESSAGE);
        txtvMensaje.setText(getString(R.string.Mensaje_bienveinida) + " " + MensajeRecibido + "!");

        btnSalir.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                Intent intent_login = new Intent(Formulario.this, Login.class);
                startActivity(intent_login);
                finish();
            }
        });
    }
}
