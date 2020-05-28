package le_on.iniciosesionsimple;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Login extends AppCompatActivity
{
    private Button btnLogin;
    private EditText etxtUser, etxtPass;
    private String Usuario="HLeon", Password="1234";
    public final static String EXTRA_MESSAGE="Usuario";
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        //Unir Vista con controlador
        btnLogin = (Button) findViewById(R.id.btn_login);
        etxtUser = (EditText) findViewById(R.id.etxt_user);
        etxtPass = (EditText) findViewById(R.id.etxt_pass);

        btnLogin.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                if(etxtUser.getText().toString().equals(Usuario) && etxtPass.getText().toString().equals(Password))
                {
                    //Iniciar la segunda actividad
                    /*
                        C#
                        Form1 frm_nombre = new Form1();
                        frm_nombre.Show();
                        this.close();

                        Java Android
                        Intent intent_nombre = new Intent(ClasePadre.this, ClasePadre del segundo formulario.class);
                        startActivity(intent_nombre);
                        finish();
                    */
                    //Obj  Nombre al objeto   Instanciar (Nombre de la class actual, Nombre del formulario abrir)
                    Intent intent_formulario = new Intent(Login.this, Formulario.class);
                    //Pasar Datos al siguiente formulario
                    /*
                        C#
                        Form1 frm_nombre = new Form1(Parametros);

                        Java Android

                        intent_nombre.putExtra(Tipo Mensaje, Objeto que tiene el dato a pasar);
                    */
                    intent_formulario.putExtra(EXTRA_MESSAGE, etxtUser.getText().toString());
                    startActivity(intent_formulario);
                    finish();
                }
                else
                {
                    //Mandar mensaje de error
                    /*
                        C#
                        MessagBox.Show("Titulo","Mensaje", Buttons.Accept);

                        Java Android
                        Toast.makeText(ClasePadre.this, "Mensaje", Toast.LENGTH_SHORT).show();
                    */
                    Toast.makeText(Login.this, "Usuario y/o Contraseña incorrectos", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
