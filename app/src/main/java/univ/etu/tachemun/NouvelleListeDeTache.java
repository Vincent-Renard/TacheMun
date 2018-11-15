package univ.etu.tachemun;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import java.util.Date;
import java.util.Random;

import univ.etu.tachemun.TimeDate.DatePickerFragment;
import univ.etu.tachemun.TimeDate.TimePickerFragment;
import univ.etu.tachemun.db.managers.ListeTacheManager;
import univ.etu.tachemun.db.managers.ProprietaireListeManager;
import univ.etu.tachemun.db.tableclass.ListeTache;
import univ.etu.tachemun.db.tableclass.ProprietaireListe;


public class NouvelleListeDeTache extends AppCompatActivity {

    private LinearLayout linearLayout;
    private EditText nomListeTache;
    private EditText descriptionListeTache;
    private Button createButton;
    private Button checkButton;
    private Button timePicker;
    private Button datePicker;

    private int choixCouleur;
    private ListeTacheManager listeTacheManager;
    private ProprietaireListeManager proprietaireListeManager;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nouvelle_liste_de_tache);

        creationImage();

        nomListeTache = (EditText) findViewById(R.id.nomListTache);
        descriptionListeTache = (EditText) findViewById(R.id.nouvListeTache_descr_input);
        createButton = (Button) findViewById(R.id.cree_nouvListe);
        listeTacheManager = new ListeTacheManager(NouvelleListeDeTache.this);
        proprietaireListeManager = new ProprietaireListeManager(NouvelleListeDeTache.this);
        createButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //ajouter l'ajout à la base de donnee
                if (!checkTitre(getTitreListe())) {
                    /*Snackbar.make(v, "Le nom de votre tache est invalide", Snackbar.LENGTH_LONG)
                                .setAction("Action", null).show();*/

                    AlertDialog.Builder builder = new AlertDialog.Builder(NouvelleListeDeTache.this);
                    builder.setMessage("Le nom de votre liste de tache est incorrect.");
                    builder.setCancelable(true);
                    builder.setPositiveButton("Suivant", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            Toast.makeText(getApplicationContext(), "Activity will continue",
                                    Toast.LENGTH_LONG).show();
                        }
                    });
                    /*
                    builder.setNegativeButton("No, no", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                finish();
                            }
                    });

                    */
                    AlertDialog dialog = builder.create();
                    dialog.show();

                } else {
                    Intent intent = new Intent(NouvelleListeDeTache.this, Listeliste.class);
                    String userName = getIntent().getStringExtra("ID_UTILISATEUR");
                    Random random = new Random();

                    ListeTache listeTache = new ListeTache(-1, getTitreListe(), true,
                            getDescriptionListe(), System.currentTimeMillis()
                            , false, 0, choixCouleur);
                    long id = listeTacheManager.insertNew(listeTache);
                    ProprietaireListe proprietaireListe = new ProprietaireListe(-1, userName, (int) id);
                    proprietaireListeManager.insert(proprietaireListe);


                    intent.putExtra("ID_UTILISATEUR", userName);
                    startActivity(intent);
                    setResult(0);
                    finish();
                }
            }
        });

        checkButton = (Button) findViewById(R.id.check);
        checkButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Snackbar.make(v, "info : " + nomListeTache.getText().toString() + " et " + choixCouleur, Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    private Date getDateOfPickers() {
        return null;
    }

    private boolean checkTitre(String titreListe) {
        return !titreListe.equals("");
    }

    private String getTitreListe() {
        return this.nomListeTache.getText().toString();
    }

    private String getDescriptionListe() {
        return this.descriptionListeTache.getText().toString();
    }

    public void showTimePickerDialog(View v) {
        timePicker = (Button) findViewById(R.id.settime);
        DialogFragment newFragment = new TimePickerFragment(timePicker);
        newFragment.show(getSupportFragmentManager(), "timePicker");

    }

    public void showDatePickerDialog(View v) {
        datePicker = (Button) findViewById(R.id.setdate);
        DialogFragment newFragment = new DatePickerFragment(datePicker);
        newFragment.show(getSupportFragmentManager(), "datePicker");
    }


    private void creationImage() {
        linearLayout = (LinearLayout) findViewById(R.id.couleurs);
        //création image
        //noir
        final ImageView imageView0 = new ImageView(this);
        imageView0.setImageResource(R.drawable.carreblanc);
        imageView0.setClickable(true);
        imageView0.setColorFilter(Color.argb(255, 0, 0, 0));


        //gris
        final ImageView imageView1 = new ImageView(this);
        imageView1.setImageResource(R.drawable.carreblanc);
        imageView1.setClickable(true);
        imageView1.setColorFilter(Color.argb(255, 64, 64, 64));


        //rouge
        final ImageView imageView2 = new ImageView(this);
        imageView2.setImageResource(R.drawable.carreblanc);
        imageView2.setClickable(true);
        imageView2.setColorFilter(Color.argb(255, 255, 0, 0));


        //orange
        final ImageView imageView3 = new ImageView(this);
        imageView3.setImageResource(R.drawable.carreblanc);
        imageView3.setClickable(true);
        imageView3.setColorFilter(Color.argb(255, 255, 106, 0));


        //jaune
        final ImageView imageView4 = new ImageView(this);
        imageView4.setImageResource(R.drawable.carreblanc);
        imageView4.setClickable(true);
        imageView4.setColorFilter(Color.argb(255, 255, 255, 0));


        //vert
        final ImageView imageView5 = new ImageView(this);
        imageView5.setImageResource(R.drawable.carreblanc);
        imageView5.setClickable(true);
        imageView5.setColorFilter(Color.argb(255, 0, 255, 0));


        //tur
        final ImageView imageView6 = new ImageView(this);
        imageView6.setImageResource(R.drawable.carreblanc);
        imageView6.setClickable(true);
        imageView6.setColorFilter(Color.argb(255, 0, 255, 255));


        //bleu cobalte
        final ImageView imageView7 = new ImageView(this);
        imageView7.setImageResource(R.drawable.carreblanc);
        imageView7.setClickable(true);
        imageView7.setColorFilter(Color.argb(255, 0, 148, 255));


        //bleu
        final ImageView imageView8 = new ImageView(this);
        imageView8.setImageResource(R.drawable.carreblanc);
        imageView8.setClickable(true);
        imageView8.setColorFilter(Color.argb(255, 0, 0, 255));


        //violet
        final ImageView imageView9 = new ImageView(this);
        imageView9.setImageResource(R.drawable.carreblanc);
        imageView9.setClickable(true);
        imageView9.setColorFilter(Color.argb(255, 178, 0, 255));


        //magenta
        final ImageView imageView10 = new ImageView(this);
        imageView10.setImageResource(R.drawable.carreblanc);
        imageView10.setClickable(true);
        imageView10.setColorFilter(Color.argb(255, 255, 0, 255));

        //click image

        imageView0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                choixCouleur = 0;
                //deselection autre image
                imageView0.setPadding(0, 0, 0, 0);
                imageView1.setPadding(0, 0, 0, 0);
                imageView2.setPadding(0, 0, 0, 0);
                imageView3.setPadding(0, 0, 0, 0);
                imageView4.setPadding(0, 0, 0, 0);
                imageView5.setPadding(0, 0, 0, 0);
                imageView6.setPadding(0, 0, 0, 0);
                imageView7.setPadding(0, 0, 0, 0);
                imageView8.setPadding(0, 0, 0, 0);
                imageView9.setPadding(0, 0, 0, 0);
                imageView10.setPadding(0, 0, 0, 0);
                //selection de l'image
                imageView0.setPadding(10, 10, 10, 10);

            }
        });

        imageView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                choixCouleur = 1;
                //deselection autre image
                imageView0.setPadding(0, 0, 0, 0);
                imageView1.setPadding(0, 0, 0, 0);
                imageView2.setPadding(0, 0, 0, 0);
                imageView3.setPadding(0, 0, 0, 0);
                imageView4.setPadding(0, 0, 0, 0);
                imageView5.setPadding(0, 0, 0, 0);
                imageView6.setPadding(0, 0, 0, 0);
                imageView7.setPadding(0, 0, 0, 0);
                imageView8.setPadding(0, 0, 0, 0);
                imageView9.setPadding(0, 0, 0, 0);
                imageView10.setPadding(0, 0, 0, 0);
                //selection de l'image
                imageView1.setPadding(10, 10, 10, 10);
            }
        });

        imageView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                choixCouleur = 2;
                //deselection autre image
                imageView0.setPadding(0, 0, 0, 0);
                imageView1.setPadding(0, 0, 0, 0);
                imageView2.setPadding(0, 0, 0, 0);
                imageView3.setPadding(0, 0, 0, 0);
                imageView4.setPadding(0, 0, 0, 0);
                imageView5.setPadding(0, 0, 0, 0);
                imageView6.setPadding(0, 0, 0, 0);
                imageView7.setPadding(0, 0, 0, 0);
                imageView8.setPadding(0, 0, 0, 0);
                imageView9.setPadding(0, 0, 0, 0);
                imageView10.setPadding(0, 0, 0, 0);
                //selection de l'image
                imageView2.setPadding(10, 10, 10, 10);
            }
        });

        imageView3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                choixCouleur = 3;
                //deselection autre image
                imageView0.setPadding(0, 0, 0, 0);
                imageView1.setPadding(0, 0, 0, 0);
                imageView2.setPadding(0, 0, 0, 0);
                imageView3.setPadding(0, 0, 0, 0);
                imageView4.setPadding(0, 0, 0, 0);
                imageView5.setPadding(0, 0, 0, 0);
                imageView6.setPadding(0, 0, 0, 0);
                imageView7.setPadding(0, 0, 0, 0);
                imageView8.setPadding(0, 0, 0, 0);
                imageView9.setPadding(0, 0, 0, 0);
                imageView10.setPadding(0, 0, 0, 0);
                //selection de l'image
                imageView3.setPadding(10, 10, 10, 10);
            }
        });

        imageView4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                choixCouleur = 4;
                //deselection autre image
                imageView0.setPadding(0, 0, 0, 0);
                imageView1.setPadding(0, 0, 0, 0);
                imageView2.setPadding(0, 0, 0, 0);
                imageView3.setPadding(0, 0, 0, 0);
                imageView4.setPadding(0, 0, 0, 0);
                imageView5.setPadding(0, 0, 0, 0);
                imageView6.setPadding(0, 0, 0, 0);
                imageView7.setPadding(0, 0, 0, 0);
                imageView8.setPadding(0, 0, 0, 0);
                imageView9.setPadding(0, 0, 0, 0);
                imageView10.setPadding(0, 0, 0, 0);
                //selection de l'image
                imageView4.setPadding(10, 10, 10, 10);
            }
        });

        imageView5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                choixCouleur = 5;
                //deselection autre image
                imageView0.setPadding(0, 0, 0, 0);
                imageView1.setPadding(0, 0, 0, 0);
                imageView2.setPadding(0, 0, 0, 0);
                imageView3.setPadding(0, 0, 0, 0);
                imageView4.setPadding(0, 0, 0, 0);
                imageView5.setPadding(0, 0, 0, 0);
                imageView6.setPadding(0, 0, 0, 0);
                imageView7.setPadding(0, 0, 0, 0);
                imageView8.setPadding(0, 0, 0, 0);
                imageView9.setPadding(0, 0, 0, 0);
                imageView10.setPadding(0, 0, 0, 0);
                //selection de l'image
                imageView5.setPadding(10, 10, 10, 10);
            }
        });

        imageView6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                choixCouleur = 6;
                //deselection autre image
                imageView0.setPadding(0, 0, 0, 0);
                imageView1.setPadding(0, 0, 0, 0);
                imageView2.setPadding(0, 0, 0, 0);
                imageView3.setPadding(0, 0, 0, 0);
                imageView4.setPadding(0, 0, 0, 0);
                imageView5.setPadding(0, 0, 0, 0);
                imageView6.setPadding(0, 0, 0, 0);
                imageView7.setPadding(0, 0, 0, 0);
                imageView8.setPadding(0, 0, 0, 0);
                imageView9.setPadding(0, 0, 0, 0);
                imageView10.setPadding(0, 0, 0, 0);
                //selection de l'image
                imageView6.setPadding(10, 10, 10, 10);
            }
        });

        imageView7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                choixCouleur = 7;
                //deselection autre image
                imageView0.setPadding(0, 0, 0, 0);
                imageView1.setPadding(0, 0, 0, 0);
                imageView2.setPadding(0, 0, 0, 0);
                imageView3.setPadding(0, 0, 0, 0);
                imageView4.setPadding(0, 0, 0, 0);
                imageView5.setPadding(0, 0, 0, 0);
                imageView6.setPadding(0, 0, 0, 0);
                imageView7.setPadding(0, 0, 0, 0);
                imageView8.setPadding(0, 0, 0, 0);
                imageView9.setPadding(0, 0, 0, 0);
                imageView10.setPadding(0, 0, 0, 0);
                //selection de l'image
                imageView7.setPadding(10, 10, 10, 10);
            }
        });

        imageView8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                choixCouleur = 8;
                //deselection autre image
                imageView0.setPadding(0, 0, 0, 0);
                imageView1.setPadding(0, 0, 0, 0);
                imageView2.setPadding(0, 0, 0, 0);
                imageView3.setPadding(0, 0, 0, 0);
                imageView4.setPadding(0, 0, 0, 0);
                imageView5.setPadding(0, 0, 0, 0);
                imageView6.setPadding(0, 0, 0, 0);
                imageView7.setPadding(0, 0, 0, 0);
                imageView8.setPadding(0, 0, 0, 0);
                imageView9.setPadding(0, 0, 0, 0);
                imageView10.setPadding(0, 0, 0, 0);
                //selection de l'image
                imageView8.setPadding(10, 10, 10, 10);
            }
        });

        imageView9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                choixCouleur = 9;
                //deselection autre image
                imageView0.setPadding(0, 0, 0, 0);
                imageView1.setPadding(0, 0, 0, 0);
                imageView2.setPadding(0, 0, 0, 0);
                imageView3.setPadding(0, 0, 0, 0);
                imageView4.setPadding(0, 0, 0, 0);
                imageView5.setPadding(0, 0, 0, 0);
                imageView6.setPadding(0, 0, 0, 0);
                imageView7.setPadding(0, 0, 0, 0);
                imageView8.setPadding(0, 0, 0, 0);
                imageView9.setPadding(0, 0, 0, 0);
                imageView10.setPadding(0, 0, 0, 0);
                //selection de l'image
                imageView9.setPadding(10, 10, 10, 10);
            }
        });

        imageView10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                choixCouleur = 10;
                //deselection autre image
                imageView0.setPadding(0, 0, 0, 0);
                imageView1.setPadding(0, 0, 0, 0);
                imageView2.setPadding(0, 0, 0, 0);
                imageView3.setPadding(0, 0, 0, 0);
                imageView4.setPadding(0, 0, 0, 0);
                imageView5.setPadding(0, 0, 0, 0);
                imageView6.setPadding(0, 0, 0, 0);
                imageView7.setPadding(0, 0, 0, 0);
                imageView8.setPadding(0, 0, 0, 0);
                imageView9.setPadding(0, 0, 0, 0);
                imageView10.setPadding(0, 0, 0, 0);
                //selection de l'image
                imageView10.setPadding(10, 10, 10, 10);
            }
        });

        imageView0.setAdjustViewBounds(true);
        linearLayout.addView(imageView0);
        imageView1.setAdjustViewBounds(true);
        linearLayout.addView(imageView1);
        imageView2.setAdjustViewBounds(true);
        linearLayout.addView(imageView2);
        imageView3.setAdjustViewBounds(true);
        linearLayout.addView(imageView3);
        imageView4.setAdjustViewBounds(true);
        linearLayout.addView(imageView4);
        imageView5.setAdjustViewBounds(true);
        linearLayout.addView(imageView5);
        imageView6.setAdjustViewBounds(true);
        linearLayout.addView(imageView6);
        imageView7.setAdjustViewBounds(true);
        linearLayout.addView(imageView7);
        imageView8.setAdjustViewBounds(true);
        linearLayout.addView(imageView8);
        imageView9.setAdjustViewBounds(true);
        linearLayout.addView(imageView9);
        imageView10.setAdjustViewBounds(true);
        linearLayout.addView(imageView10);


    }
}


