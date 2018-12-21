package tr.edu.osmangazi.eskisehirhaber;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.provider.Settings;
import android.speech.tts.TextToSpeech;
import android.speech.tts.TextToSpeech.OnInitListener;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import java.util.Locale;

import org.w3c.dom.Text;

import java.util.Locale;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    RecyclerView recyclerView;
    TextToSpeech toSpeech;
    TextView textView;
    TextToSpeech toSpeech1;
    TextView textView1;
    int results;
    String text;
    String text1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = getIntent();
                finish();
                startActivity(intent);
            }
        });
        FloatingActionButton fab1 = (FloatingActionButton) findViewById(R.id.fab1);
        fab1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                textView=(TextView) findViewById(R.id.description_text);
                toSpeech=new TextToSpeech(MainActivity.this, new OnInitListener() {
                    @Override
                    public void onInit(int status) {
                        //Locale locale=new Locale("tr-TR");
                        toSpeech.setLanguage(new Locale("tr-TR"));
                        text=textView.getText().toString();
                        toSpeech.speak(text,TextToSpeech.QUEUE_FLUSH,null);
                    }
                });


            }
        });
        FloatingActionButton fab2 = (FloatingActionButton) findViewById(R.id.fab2);
        fab2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                textView1=(TextView) findViewById(R.id.title_text);
                toSpeech1=new TextToSpeech(MainActivity.this, new OnInitListener() {
                    @Override
                    public void onInit(int status) {
                        //Locale locale=new Locale("tr-TR");
                        toSpeech1.setLanguage(new Locale("tr-TR"));
                        text1=textView1.getText().toString();
                        toSpeech1.speak(text1,TextToSpeech.QUEUE_FLUSH,null);
                    }
                });
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        recyclerView= (RecyclerView) findViewById(R.id.recyclerview);
        ReadRss5 readRss=new ReadRss5(this,recyclerView);
        readRss.execute();
    }


    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            finish();
            System.exit(0);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();


        if (id == R.id.nav_gundem) {
            recyclerView= (RecyclerView) findViewById(R.id.recyclerview);
            ReadRss readRss=new ReadRss(this,recyclerView);
            readRss.execute();
        } else if (id == R.id.nav_ekonomi) {
            recyclerView= (RecyclerView) findViewById(R.id.recyclerview);
            ReadRss2 readRss=new ReadRss2(this,recyclerView);
            readRss.execute();

        } else if (id == R.id.nav_spor) {
            recyclerView= (RecyclerView) findViewById(R.id.recyclerview);
            ReadRss3 readRss=new ReadRss3(this,recyclerView);
            readRss.execute();

        } else if (id == R.id.nav_yasam) {
            recyclerView= (RecyclerView) findViewById(R.id.recyclerview);
            ReadRss4 readRss=new ReadRss4(this,recyclerView);
            readRss.execute();
        } else if (id == R.id.nav_teknoloji) {
            recyclerView= (RecyclerView) findViewById(R.id.recyclerview);
            ReadRss6 readRss=new ReadRss6(this,recyclerView);
            readRss.execute();
        } else if (id == R.id.nav_saglık) {
            recyclerView= (RecyclerView) findViewById(R.id.recyclerview);
            ReadRss7 readRss=new ReadRss7(this,recyclerView);
            readRss.execute();
        } else if (id == R.id.nav_dunya) {
            recyclerView= (RecyclerView) findViewById(R.id.recyclerview);
            ReadRss8 readRss=new ReadRss8(this,recyclerView);
            readRss.execute();

        } else if (id == R.id.nav_hakkımızda) {
           TextView toast=new TextView(this);
             toast.setText("Caner Konuk, Eskişehir Osmangazi Üniversitesi - Matematik ve Bilgisayar Bölümü, Haber Kaynağı: Eskişehir Sakarya Gazetesi");
            toast.setBackgroundColor(Color.BLUE);
            toast.setTextColor(Color.WHITE);
            toast.setPadding(100,100,100,100);
            Toast yazı=new Toast(this);
            yazı.setView(toast);
            yazı.setDuration(Toast.LENGTH_LONG);
            yazı.show();




        } else if (id == R.id.nav_send) {
            TextView nesne=new TextView(this);
            nesne.setText("https://github.com/canerkonuk");
            nesne.setBackgroundColor(Color.BLUE);
            nesne.setTextColor(Color.WHITE);
            nesne.setPadding(100,100,100,100);
            Toast iletişim=new Toast(this);
            iletişim.setView(nesne);
            iletişim.setDuration(Toast.LENGTH_LONG);
            iletişim.show();

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
