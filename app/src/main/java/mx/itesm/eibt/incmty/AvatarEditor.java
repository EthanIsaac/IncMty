package mx.itesm.eibt.incmty;

import android.content.Context;
import android.content.SharedPreferences;
import android.media.Image;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class AvatarEditor extends AppCompatActivity {

    private SharedPreferences preferences;
    SharedPreferences.Editor editor;
    private int sexo;
    private int color;

    private ImageView avatarSelected;
    private ImageView cabelloSelected;
    private ImageView cejasSelected;
    private ImageView ojosSelected;
    private ImageView barbaSelected;
    private ImageView sudaderaSelected;
    private ImageView pantalonSelected;
    private ImageView tenisSelected;
    private ImageView accesorioSelected;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_avatar_editor);

        cargarAvatar();
        cargarBotones();
    }

    private void cargarAvatar() {
        avatarSelected = findViewById(R.id.avatarImage);
        cabelloSelected = findViewById(R.id.cabelloImage);
        cejasSelected = findViewById(R.id.cejasImage);
        ojosSelected = findViewById(R.id.ojosImage);
        barbaSelected = findViewById(R.id.barbaImage);
        sudaderaSelected = findViewById(R.id.sudaderaImage);
        pantalonSelected = findViewById(R.id.pantalonImage);
        tenisSelected = findViewById(R.id.tenisImage);
        accesorioSelected = findViewById(R.id.accesorioImage);

        preferences = getSharedPreferences("eibt.itesm.mx.IncMty.avatar",Context.MODE_PRIVATE);
        editor = preferences.edit();

        sexo = preferences.getInt("sexo", 0);
        color = preferences.getInt("color", 0);
        setAvatarImage(preferences.getInt("avatar", 0));
        setCabelloImage(preferences.getInt("cabello", 0));
        setCejasImage();
        setOjosImage(preferences.getInt("ojos", 0));
        setBarbaImage(preferences.getInt("barba", 0));
        setSudaderaImage(preferences.getInt("sudadera", 0));
        setPantalonImage(preferences.getInt("pantalon", 0));
        setTenisImage(preferences.getInt("tenis", 0));
        setAccesorioImage(preferences.getInt("accesorio", 0));
    }

    private void cargarBotones() {
        Button sexoButton = (Button) findViewById(R.id.sexo);
        sexoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sexo = (sexo+1)%2;
                String descriptionAvatar = (String)avatarSelected.getContentDescription();
                String descriptionCabello = (String)cabelloSelected.getContentDescription();
                String descriptionOjos = (String)ojosSelected.getContentDescription();
                String descriptionBarba = (String)barbaSelected.getContentDescription();
                String descriptionSudadera = (String)sudaderaSelected.getContentDescription();
                String descriptionPantalon = (String)pantalonSelected.getContentDescription();
                String descriptionTenis = (String)tenisSelected.getContentDescription();
                String descriptionAccesorio = (String)accesorioSelected.getContentDescription();
                int formaAvatar = Integer.parseInt(descriptionAvatar);
                int formaCabello = Integer.parseInt(descriptionCabello);
                int formaOjos = Integer.parseInt(descriptionOjos);
                int formaBarba = Integer.parseInt(descriptionBarba);
                int formaSudadera = Integer.parseInt(descriptionSudadera);
                int formaPantalon = Integer.parseInt(descriptionPantalon);
                int formaTenis = Integer.parseInt(descriptionTenis);
                int formaAccesorio = Integer.parseInt(descriptionAccesorio);
                setAvatarImage(formaAvatar);
                setCabelloImage(formaCabello);
                setCejasImage();
                setOjosImage(formaOjos);
                setBarbaImage(formaBarba);
                setSudaderaImage(formaSudadera);
                setPantalonImage(formaPantalon);
                setTenisImage(formaTenis);
                setAccesorioImage(formaAccesorio);
            }
        });
        Button tonoButton = (Button) findViewById(R.id.tono);
        tonoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String description = (String)avatarSelected.getContentDescription();
                int tono = (Integer.parseInt(description)+1)%4;
                setAvatarImage(tono);
            }
        });
        Button cabelloButton = (Button) findViewById(R.id.cabello);
        cabelloButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String description = (String)cabelloSelected.getContentDescription();
                int tono = (Integer.parseInt(description)+1)%10;
                setCabelloImage(tono);
            }
        });
        Button ojosButton = (Button) findViewById(R.id.ojos);
        ojosButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String description = (String)ojosSelected.getContentDescription();
                int forma = (Integer.parseInt(description)+1)%4;
                setOjosImage(forma);
            }
        });
        Button barbaButton = (Button) findViewById(R.id.barba);
        barbaButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String description = (String)barbaSelected.getContentDescription();
                int forma = (Integer.parseInt(description)+1)%7;
                setBarbaImage(forma);
            }
        });
        Button sudaderaButton = (Button) findViewById(R.id.sudadera);
        sudaderaButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String description = (String)sudaderaSelected.getContentDescription();
                int forma = (Integer.parseInt(description)+1)%6;
                setSudaderaImage(forma);
            }
        });
        final Button pantalonButton = (Button) findViewById(R.id.pantalon);
        pantalonButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String description = (String)pantalonSelected.getContentDescription();
                int forma = (Integer.parseInt(description)+1)%6;
                setPantalonImage(forma);
            }
        });
        Button tenisButton = (Button) findViewById(R.id.tenis);
        tenisButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String description = (String)tenisSelected.getContentDescription();
                int forma = (Integer.parseInt(description)+1)%6;
                setTenisImage(forma);
            }
        });
        Button accesoriosButton = (Button) findViewById(R.id.accesorios);
        accesoriosButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String description = (String)accesorioSelected.getContentDescription();
                int forma = (Integer.parseInt(description)+1)%2;
                setAccesorioImage(forma);
            }
        });
        Button colorButton = (Button) findViewById(R.id.color);
        colorButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                color = (color+1)%3;
                String descriptionCabello = (String)cabelloSelected.getContentDescription();
                String descriptionBarba = (String)barbaSelected.getContentDescription();
                int formaCabello = Integer.parseInt(descriptionCabello);
                int formaBarba = Integer.parseInt(descriptionBarba);
                setCabelloImage(formaCabello);
                setBarbaImage(formaBarba);
                setCejasImage();
            }
        });
        FloatingActionButton guardar = (FloatingActionButton) findViewById(R.id.guardar);
        guardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                guardarAvatar();
            }
        });
    }

    private void guardarAvatar() {
        editor.putInt("sexo", sexo);
        editor.putInt("color", color);
        editor.putInt("avatar", Integer.parseInt((String)avatarSelected.getContentDescription()));
        editor.putInt("cabello", Integer.parseInt((String)cabelloSelected.getContentDescription()));
        editor.putInt("ojos", Integer.parseInt((String)ojosSelected.getContentDescription()));
        editor.putInt("barba", Integer.parseInt((String)barbaSelected.getContentDescription()));
        editor.putInt("sudadera", Integer.parseInt((String)sudaderaSelected.getContentDescription()));
        editor.putInt("pantalon", Integer.parseInt((String)pantalonSelected.getContentDescription()));
        editor.putInt("tenis", Integer.parseInt((String)tenisSelected.getContentDescription()));
        editor.putInt("accesorio", Integer.parseInt((String)accesorioSelected.getContentDescription()));
        editor.commit();
    }

    public void setAvatarImage(int tono) {
        avatarSelected.setContentDescription("" + tono);
        if(sexo == 0)
        {
            switch (tono) {
                case 0:
                    avatarSelected.setImageResource(R.drawable.hombreavatar0);
                    break;
                case 1:
                    avatarSelected.setImageResource(R.drawable.hombreavatar1);
                    break;
                case 2:
                    avatarSelected.setImageResource(R.drawable.hombreavatar2);
                    break;
                case 3:
                    avatarSelected.setImageResource(R.drawable.hombreavatar3);
                    break;
            }
        }
        else
        {
            switch (tono) {
                case 0:
                    avatarSelected.setImageResource(R.drawable.mujeravatar0);
                    break;
                case 1:
                    avatarSelected.setImageResource(R.drawable.mujeravatar1);
                    break;
                case 2:
                    avatarSelected.setImageResource(R.drawable.mujeravatar2);
                    break;
                case 3:
                    avatarSelected.setImageResource(R.drawable.mujeravatar3);
                    break;
            }
        }
    }

    public void setCabelloImage(int forma) {
        cabelloSelected.setContentDescription("" + forma);
        if(sexo == 0)
        {
            switch (color)
            {
                case 0:
                    switch (forma) {
                        case 0:
                            cabelloSelected.setImageResource(R.drawable.hombrecabellonegro0);
                            break;
                        case 1:
                            cabelloSelected.setImageResource(R.drawable.hombrecabellonegro1);
                            break;
                        case 2:
                            cabelloSelected.setImageResource(R.drawable.hombrecabellonegro2);
                            break;
                        case 3:
                            cabelloSelected.setImageResource(R.drawable.hombrecabellonegro3);
                            break;
                        case 4:
                            cabelloSelected.setImageResource(R.drawable.hombrecabellonegro4);
                            break;
                        case 5:
                            cabelloSelected.setImageResource(R.drawable.hombrecabellonegro5);
                            break;
                        case 6:
                            cabelloSelected.setImageResource(R.drawable.hombrecabellonegro6);
                            break;
                        case 7:
                            cabelloSelected.setImageResource(R.drawable.hombrecabellonegro7);
                            break;
                        case 8:
                            cabelloSelected.setImageResource(R.drawable.hombrecabellonegro8);
                            break;
                        case 9:
                            cabelloSelected.setImageResource(R.drawable.hombrecabellonegro9);
                            break;
                    }
                    break;
                case 1:
                    switch (forma) {
                        case 0:
                            cabelloSelected.setImageResource(R.drawable.hombrecabellorojo0);
                            break;
                        case 1:
                            cabelloSelected.setImageResource(R.drawable.hombrecabellorojo1);
                            break;
                        case 2:
                            cabelloSelected.setImageResource(R.drawable.hombrecabellorojo2);
                            break;
                        case 3:
                            cabelloSelected.setImageResource(R.drawable.hombrecabellorojo3);
                            break;
                        case 4:
                            cabelloSelected.setImageResource(R.drawable.hombrecabellorojo4);
                            break;
                        case 5:
                            cabelloSelected.setImageResource(R.drawable.hombrecabellorojo5);
                            break;
                        case 6:
                            cabelloSelected.setImageResource(R.drawable.hombrecabellorojo6);
                            break;
                        case 7:
                            cabelloSelected.setImageResource(R.drawable.hombrecabellorojo7);
                            break;
                        case 8:
                            cabelloSelected.setImageResource(R.drawable.hombrecabellorojo8);
                            break;
                        case 9:
                            cabelloSelected.setImageResource(R.drawable.hombrecabellorojo9);
                            break;
                    }
                    break;
                case 2:
                    switch (forma) {
                        case 0:
                            cabelloSelected.setImageResource(R.drawable.hombrecabellorubio0);
                            break;
                        case 1:
                            cabelloSelected.setImageResource(R.drawable.hombrecabellorubio1);
                            break;
                        case 2:
                            cabelloSelected.setImageResource(R.drawable.hombrecabellorubio2);
                            break;
                        case 3:
                            cabelloSelected.setImageResource(R.drawable.hombrecabellorubio3);
                            break;
                        case 4:
                            cabelloSelected.setImageResource(R.drawable.hombrecabellorubio4);
                            break;
                        case 5:
                            cabelloSelected.setImageResource(R.drawable.hombrecabellorubio5);
                            break;
                        case 6:
                            cabelloSelected.setImageResource(R.drawable.hombrecabellorubio6);
                            break;
                        case 7:
                            cabelloSelected.setImageResource(R.drawable.hombrecabellorubio7);
                            break;
                        case 8:
                            cabelloSelected.setImageResource(R.drawable.hombrecabellorubio8);
                            break;
                        case 9:
                            cabelloSelected.setImageResource(R.drawable.hombrecabellorubio9);
                            break;
                    }
                    break;
            }
        }
        else
        {
            switch (color)
            {
                case 0:
                    switch (forma) {
                        case 0:
                            cabelloSelected.setImageResource(R.drawable.mujercabellonegro0);
                            break;
                        case 1:
                            cabelloSelected.setImageResource(R.drawable.mujercabellonegro1);
                            break;
                        case 2:
                            cabelloSelected.setImageResource(R.drawable.mujercabellonegro2);
                            break;
                        case 3:
                            cabelloSelected.setImageResource(R.drawable.mujercabellonegro3);
                            break;
                        case 4:
                            cabelloSelected.setImageResource(R.drawable.mujercabellonegro4);
                            break;
                        case 5:
                            cabelloSelected.setImageResource(R.drawable.mujercabellonegro5);
                            break;
                        case 6:
                            cabelloSelected.setImageResource(R.drawable.mujercabellonegro6);
                            break;
                        case 7:
                            cabelloSelected.setImageResource(R.drawable.mujercabellonegro7);
                            break;
                        case 8:
                            cabelloSelected.setImageResource(R.drawable.mujercabellonegro8);
                            break;
                        case 9:
                            cabelloSelected.setImageResource(R.drawable.mujercabellonegro9);
                            break;
                    }
                    break;
                case 1:
                    switch (forma) {
                        case 0:
                            cabelloSelected.setImageResource(R.drawable.mujercabellorojo0);
                            break;
                        case 1:
                            cabelloSelected.setImageResource(R.drawable.mujercabellorojo1);
                            break;
                        case 2:
                            cabelloSelected.setImageResource(R.drawable.mujercabellorojo2);
                            break;
                        case 3:
                            cabelloSelected.setImageResource(R.drawable.mujercabellorojo3);
                            break;
                        case 4:
                            cabelloSelected.setImageResource(R.drawable.mujercabellorojo4);
                            break;
                        case 5:
                            cabelloSelected.setImageResource(R.drawable.mujercabellorojo5);
                            break;
                        case 6:
                            cabelloSelected.setImageResource(R.drawable.mujercabellorojo6);
                            break;
                        case 7:
                            cabelloSelected.setImageResource(R.drawable.mujercabellorojo7);
                            break;
                        case 8:
                            cabelloSelected.setImageResource(R.drawable.mujercabellorojo8);
                            break;
                        case 9:
                            cabelloSelected.setImageResource(R.drawable.mujercabellorojo9);
                            break;
                    }
                    break;
                case 2:
                    switch (forma) {
                        case 0:
                            cabelloSelected.setImageResource(R.drawable.mujercabellorubio0);
                            break;
                        case 1:
                            cabelloSelected.setImageResource(R.drawable.mujercabellorubio1);
                            break;
                        case 2:
                            cabelloSelected.setImageResource(R.drawable.mujercabellorubio2);
                            break;
                        case 3:
                            cabelloSelected.setImageResource(R.drawable.mujercabellorubio3);
                            break;
                        case 4:
                            cabelloSelected.setImageResource(R.drawable.mujercabellorubio4);
                            break;
                        case 5:
                            cabelloSelected.setImageResource(R.drawable.mujercabellorubio5);
                            break;
                        case 6:
                            cabelloSelected.setImageResource(R.drawable.mujercabellorubio6);
                            break;
                        case 7:
                            cabelloSelected.setImageResource(R.drawable.mujercabellorubio7);
                            break;
                        case 8:
                            cabelloSelected.setImageResource(R.drawable.mujercabellorubio8);
                            break;
                        case 9:
                            cabelloSelected.setImageResource(R.drawable.mujercabellorubio9);
                            break;
                    }
                    break;
            }
        }
    }

    public void setOjosImage(int color) {
        ojosSelected.setContentDescription("" + color);
        if(sexo == 0)
        {
            switch (color) {
                case 0:
                    ojosSelected.setImageResource(R.drawable.hombreojos0);
                    break;
                case 1:
                    ojosSelected.setImageResource(R.drawable.hombreojos1);
                    break;
                case 2:
                    ojosSelected.setImageResource(R.drawable.hombreojos2);
                    break;
                case 3:
                    ojosSelected.setImageResource(R.drawable.hombreojos3);
                    break;
            }
        }
        else
        {
            switch (color) {
                case 0:
                    ojosSelected.setImageResource(R.drawable.mujerojos0);
                    break;
                case 1:
                    ojosSelected.setImageResource(R.drawable.mujerojos1);
                    break;
                case 2:
                    ojosSelected.setImageResource(R.drawable.mujerojos2);
                    break;
                case 3:
                    ojosSelected.setImageResource(R.drawable.mujerojos3);
                    break;
            }
        }
    }

    private void setBarbaImage(int forma) {
        barbaSelected.setContentDescription("" + forma);
        if(sexo == 0)
        {
            switch(color)
            {
                case 0:
                    switch (forma) {
                        case 0:
                            barbaSelected.setImageResource(R.drawable.barbanegra0);
                            break;
                        case 1:
                            barbaSelected.setImageResource(R.drawable.barbanegra1);
                            break;
                        case 2:
                            barbaSelected.setImageResource(R.drawable.barbanegra2);
                            break;
                        case 3:
                            barbaSelected.setImageResource(R.drawable.barbanegra3);
                            break;
                        case 4:
                            barbaSelected.setImageResource(R.drawable.barbanegra4);
                            break;
                        case 5:
                            barbaSelected.setImageResource(R.drawable.barbanegra5);
                            break;
                        case 6:
                            barbaSelected.setImageResource(R.drawable.barbanegra6);
                            break;
                    }
                    break;
                case 1:
                    switch (forma) {
                        case 0:
                            barbaSelected.setImageResource(R.drawable.barbaroja0);
                            break;
                        case 1:
                            barbaSelected.setImageResource(R.drawable.barbaroja1);
                            break;
                        case 2:
                            barbaSelected.setImageResource(R.drawable.barbaroja2);
                            break;
                        case 3:
                            barbaSelected.setImageResource(R.drawable.barbaroja3);
                            break;
                        case 4:
                            barbaSelected.setImageResource(R.drawable.barbaroja4);
                            break;
                        case 5:
                            barbaSelected.setImageResource(R.drawable.barbaroja5);
                            break;
                        case 6:
                            barbaSelected.setImageResource(R.drawable.barbaroja6);
                            break;
                    }
                    break;
                case 2:
                    switch (forma) {
                        case 0:
                            barbaSelected.setImageResource(R.drawable.barbarubia0);
                            break;
                        case 1:
                            barbaSelected.setImageResource(R.drawable.barbarubia1);
                            break;
                        case 2:
                            barbaSelected.setImageResource(R.drawable.barbarubia2);
                            break;
                        case 3:
                            barbaSelected.setImageResource(R.drawable.barbarubia3);
                            break;
                        case 4:
                            barbaSelected.setImageResource(R.drawable.barbarubia4);
                            break;
                        case 5:
                            barbaSelected.setImageResource(R.drawable.barbarubia5);
                            break;
                        case 6:
                            barbaSelected.setImageResource(R.drawable.barbarubia6);
                            break;
                    }
                    break;
            }
        }
        else
        {
            barbaSelected.setImageResource(R.drawable.nada);
        }
    }

    public void setSudaderaImage(int forma) {
        sudaderaSelected.setContentDescription("" + forma);
        if(sexo == 0)
        {
            switch (forma) {
                case 0:
                    sudaderaSelected.setImageResource(R.drawable.hombresudadera0);
                    break;
                case 1:
                    sudaderaSelected.setImageResource(R.drawable.hombresudadera1);
                    break;
                case 2:
                    sudaderaSelected.setImageResource(R.drawable.hombresudadera2);
                    break;
                default:
                    sudaderaSelected.setImageResource(R.drawable.hombresudadera0);
                    sudaderaSelected.setContentDescription("" + 0);
                    break;
            }
        }
        else
        {
            switch (forma) {
                case 0:
                    sudaderaSelected.setImageResource(R.drawable.mujersudadera0);
                    break;
                case 1:
                    sudaderaSelected.setImageResource(R.drawable.mujersudadera1);
                    break;
                case 2:
                    sudaderaSelected.setImageResource(R.drawable.mujersudadera2);
                    break;
                case 3:
                    sudaderaSelected.setImageResource(R.drawable.mujersudadera3);
                    break;
                case 4:
                    sudaderaSelected.setImageResource(R.drawable.mujersudadera4);
                    break;
                case 5:
                    sudaderaSelected.setImageResource(R.drawable.mujersudadera5);
                    break;
            }
        }
    }

    public void setPantalonImage(int forma) {
        pantalonSelected.setContentDescription("" + forma);
        if(sexo == 0)
        {
            switch (forma) {
                case 0:
                    pantalonSelected.setImageResource(R.drawable.hombrepantalon0);
                    break;
                case 1:
                    pantalonSelected.setImageResource(R.drawable.hombrepantalon1);
                    break;
                case 2:
                    pantalonSelected.setImageResource(R.drawable.hombrepantalon2);
                    break;
                default:
                    pantalonSelected.setImageResource(R.drawable.hombrepantalon0);
                    pantalonSelected.setContentDescription("0");
                    break;
            }
        }
        else
        {
            switch (forma) {
                case 0:
                    pantalonSelected.setImageResource(R.drawable.mujerpantalon0);
                    break;
                case 1:
                    pantalonSelected.setImageResource(R.drawable.mujerpantalon1);
                    break;
                case 2:
                    pantalonSelected.setImageResource(R.drawable.mujerpantalon2);
                    break;
                case 3:
                    pantalonSelected.setImageResource(R.drawable.mujerpantalon3);
                    break;
                case 4:
                    pantalonSelected.setImageResource(R.drawable.mujerpantalon4);
                    break;
                case 5:
                    pantalonSelected.setImageResource(R.drawable.mujerpantalon5);
                    break;
            }
        }
    }

    public void setTenisImage(int forma) {
        tenisSelected.setContentDescription("" + forma);
        if(sexo == 0)
        {
            switch (forma) {
                case 0:
                    tenisSelected.setImageResource(R.drawable.hombretenis0);
                    break;
                case 1:
                    tenisSelected.setImageResource(R.drawable.hombretenis1);
                    break;
                case 2:
                    tenisSelected.setImageResource(R.drawable.hombretenis2);
                    break;
                case 3:
                    tenisSelected.setImageResource(R.drawable.hombretenis3);
                    break;
                default:
                    tenisSelected.setImageResource(R.drawable.hombretenis0);
                    tenisSelected.setContentDescription("0");
                    break;
            }
        }
        else
        {
            switch (forma) {
                case 0:
                    tenisSelected.setImageResource(R.drawable.mujertenis0);
                    break;
                case 1:
                    tenisSelected.setImageResource(R.drawable.mujertenis1);
                    break;
                case 2:
                    tenisSelected.setImageResource(R.drawable.mujertenis2);
                    break;
                case 3:
                    tenisSelected.setImageResource(R.drawable.mujertenis3);
                    break;
                case 4:
                    tenisSelected.setImageResource(R.drawable.mujertenis4);
                    break;
                case 5:
                    tenisSelected.setImageResource(R.drawable.mujertenis5);
                    break;
            }
        }
    }

    public void setAccesorioImage(int forma) {
        accesorioSelected.setContentDescription("" + forma);
        if(sexo == 0)
        {
            switch (forma) {
                case 0:
                    accesorioSelected.setImageResource(R.drawable.nada);
                    break;
                case 1:
                    accesorioSelected.setImageResource(R.drawable.hombreaccesorio0);
                    break;
            }
        }
        else
        {
            switch (forma) {
                case 0:
                    accesorioSelected.setImageResource(R.drawable.nada);
                    break;
                case 1:
                    accesorioSelected.setImageResource(R.drawable.mujeraccesorio0);
                    break;
            }
        }
    }
    public void setCejasImage() {
        if(sexo == 0)
        {
            switch (color) {
                case 0:
                    cejasSelected.setImageResource(R.drawable.hombrecejasnegras);
                    break;
                case 1:
                    cejasSelected.setImageResource(R.drawable.hombrecejasrojas);
                    break;
                case 2:
                    cejasSelected.setImageResource(R.drawable.hombrecejasrubias);
                    break;
            }
        }
        else
        {
            switch (color) {
                case 0:
                    cejasSelected.setImageResource(R.drawable.mujercejasnegras);
                    break;
                case 1:
                    cejasSelected.setImageResource(R.drawable.mujercejasrojas);
                    break;
                case 2:
                    cejasSelected.setImageResource(R.drawable.mujercejasrubias);
                    break;
            }
        }
    }
}
