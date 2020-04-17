package com.example.antennarotorcontrol;

import android.Manifest;
import android.annotation.SuppressLint;
import android.app.DownloadManager;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationManager;
import android.media.Ringtone;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.provider.Settings;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.app.ActivityCompat;

import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationCallback;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationResult;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import ioio.lib.api.DigitalInput;
import ioio.lib.api.DigitalOutput;
import ioio.lib.api.IOIO;
import ioio.lib.api.IOIO.VersionType;
import ioio.lib.api.exception.ConnectionLostException;
import ioio.lib.util.BaseIOIOLooper;
import ioio.lib.util.IOIOLooper;

//extends AppCompatActivity
public class MainActivity extends AppCompatActivity implements Runnable, IOIOinterface {

    public ToggleButton button_;
    public ToggleButton toggle_tracker;


    public boolean output1_ = false; // Pin 37 (step)
    public boolean output2_ = false; // Pin 38 (dir)
    public boolean output3_ = false; // Pin 39 (step)
    public boolean output4_ = false; // Pin 40 (dir)

    private float latitude = 56.8582f;
    private float longitude = 14.7662f;
    private int altitude = 180;
    private String TLE1;
    private String TLE2;
    private String TLE3;


    /***************************
    *** SAT PREDICTION VARIABLES
    ***************************/

    static String infoString;
    static String speak="T";
    static String plusSign;
    int alarm_done;
    final double xkmper =     6.378137E3;             /* WGS 84 Earth radius km */
    final double km2mi =      0.621371;               /* km to miles */
    static int	ans, oldaz=0, oldel=0, length, xponder=0, polarity=0, tshift, bshift;
    static String  command;
    static int     comsat, aos_alarm=0, geostationary=0, aoshappens=0, decayed=0, eclipse_alarm=0, los_alarm=0;
    static String  old_visibility;
    static double	oldtime=0.0, nextaos=0.0, lostime=0.0, aoslos=0.0,
            downlink=0.0, uplink=0.0, downlink_start=0.0,
            downlink_end=0.0, uplink_start=0.0, uplink_end=0.0,
            dopp, doppler100=0.0, delay, loss, shift;
    static long	newtime, lasttime=0;
    static String AosString;
    static int loop_counter;
    SharedFunctions sf = new SharedFunctions();   // create helper object to SharedFunctions (the Outer Class) that contains helper classes

    public double roundToDecimals(double d, int c){
        int temp = (int)(d * Math.pow(10 , c));
        return ((double)temp)/Math.pow(10 , c);
    }

    /*******************************
     *******************************
     ******************************/


    private static final int PERMISSION_ID = 44;
    private static final int PERMISSION_STORAGE_CODE = 1000;

    FusedLocationProviderClient mFusedLocationClient;

    double lat, lon;
    float fLat=0;
    float fLon=0;
    String strLocator="";
    TextView tv_qth_on_main_activity;
    CoordToLoc objCoordToLoc;
    private Toolbar toolbar;
    ListView list;
    String[] titles = {"Track Satellite", "ISS", "Amateur Radio Satellites",
            "Manual Rotor Control", "Search Satellites"};
    int[] imgs = {R.drawable.ic_hamsat_white_48dp, R.drawable.ic_hamsat_white_48dp, R.drawable.ic_hamsat_white_48dp,
            R.drawable.ic_hamsat_white_48dp, R.drawable.ic_hamsat_white_48dp};

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
    }

    /*********************************************************
     * ONCREATE MAIN
     *
     */

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        objCoordToLoc = new CoordToLoc();
        tv_qth_on_main_activity=findViewById(R.id.tv_qth_on_main_activity);

        //Download latest TLE-DATA
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.M){
            if(checkSelfPermission(Manifest.permission.WRITE_EXTERNAL_STORAGE) == PackageManager.PERMISSION_DENIED){
                String[] permissions = {Manifest.permission.WRITE_EXTERNAL_STORAGE};
                requestPermissions(permissions, PERMISSION_STORAGE_CODE);
            }
            else{
                startDownloading();
            }
        }
        else{
            startDownloading();
        }


        //Get GPS-Coordinates
        mFusedLocationClient = LocationServices.getFusedLocationProviderClient(this);

        //Main Toolbar
        toolbar = findViewById(R.id.myToolbar);
        setSupportActionBar(toolbar);

        // MENU ENTRIES MAIN MENU
        list = findViewById(R.id.list1);
        MyAdapter adapter = new MyAdapter(this, titles, imgs);
        list.setAdapter(adapter);
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (position == 0){
                    Intent intent1 = new Intent(MainActivity.this, SettingsActivity.class);
                    startActivity(intent1);
                }
                if (position==1) {
                    Intent intent2 = new Intent(MainActivity.this, HelpActivity.class);
                    startActivity(intent2);
                }
                if (position==2) {
                    Intent intent3 = new Intent(MainActivity.this, HamSatMenu.class);
                    startActivity(intent3);
                }
                if (position==3) {
                    Intent intent3 = new Intent(MainActivity.this, HelpActivity.class);
                    startActivity(intent3);
                }
                if (position==4) {
                    Intent intent3 = new Intent(MainActivity.this, HelpActivity.class);
                    startActivity(intent3);
                }

            }
        });


        // SharedFunctions.obs_lat = latitude;
        // SharedFunctions.obs_lon = longitude;
        // SharedFunctions.obs_lat = roundToDecimals(latitude, 4);
        // SharedFunctions.obs_lon = roundToDecimals(longitude, 4);

        SharedFunctions.qth_stnname = "PATRICK";
        SharedFunctions.qth_stnlat  = 56.8582;
        SharedFunctions.qth_stnlon  = 14.7662; //Double.parseDouble(longitude)
        SharedFunctions.qth_stnalt  = altitude;
        // SharedFunctions.qth_stnlat  = latitude;
        // SharedFunctions.qth_stnlon  = longitude;

        SharedFunctions.obs_geodetic_lat   =  latitude * SharedFunctions.deg2rad;    // Observer's latitude in radians
        SharedFunctions.obs_geodetic_lon   = longitude * SharedFunctions.deg2rad;    // Observer's longitude in radians
        SharedFunctions.obs_geodetic_alt   =  0.18;       // Observer's altitude in km

        String tempval_str = "";

        /***
         * TLE MANUELL IMPORTIEREN
         */

        TleManualImport tleFunction = new TleManualImport();
        ReadTxtFile readTxtFile = new ReadTxtFile(MainActivity.this);
        try {
            readTxtFile.readFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
        String tleElement = readTxtFile.threeLineElement;


       /* String tleElement = "SAUDISAT 1C (SO-50)\n" +
                "1 27607U 02058C   20106.54414103  .00000007  00000-0  21737-4 0  9999\n" +
                "2 27607  64.5556 206.7081 0055918 193.7297 166.2289 14.75625318931442\n";
*/
        String[] SatData = tleFunction.processTLE(tleElement); //tleElement


        SharedFunctions.sat_name = SatData[0];                         // name
        SharedFunctions.sat_catnum = Long.parseLong(SatData[2]);       // catalog number
        SharedFunctions.sat_designator = SatData[3];                   // class
        SharedFunctions.sat_year = Integer.valueOf(SatData[7]);        // epochyear

        try {
            SharedFunctions.sat_refepoch = Double.parseDouble(SatData[8]); // epochday
            SharedFunctions.sat_drag = Double.parseDouble(SatData[9]);     // ftdmm
			/* if(!TextUtils.isEmpty(SatData[10])){
				SharedFunctions.sat_nddot6 = Double.parseDouble(SatData[10]);  // stdmm which is usually 0000-0 interpreted to decimal somehow
			} */

            // Enter 'drag' (Bstar Drag Parameter, EEEEE-E) as follows:
            // TLE provides: 17950-3   enter in database: -0.00017950
            // We just assume the value is always negative..??
            int exponent = Integer.parseInt( SatData[11].substring(SatData[11].length()-2) );
            String tempvalue = SatData[11].substring(0, 1) + "." + SatData[11].substring(1, 6);
            double dragvalue = Double.valueOf(tempvalue);
            dragvalue = dragvalue * 0.001;
            SharedFunctions.sat_bstar = dragvalue;

            SharedFunctions.sat_incl = Double.parseDouble(SatData[17]);    // incl
            SharedFunctions.sat_raan = Double.parseDouble(SatData[18]);    // ra
            SharedFunctions.sat_eccn = Double.parseDouble("0."+SatData[19]);    // ecc
            SharedFunctions.sat_argper = Double.parseDouble(SatData[20]);  // peri
            SharedFunctions.sat_meanan = Double.parseDouble(SatData[21]);  // ma
            SharedFunctions.sat_meanmo = Double.parseDouble(SatData[22]);  // mm

        } catch (NumberFormatException e) {
            // Handle error here, perhaps notify the user to input some data
            Toast.makeText(this,"Error! " + e, Toast.LENGTH_LONG).show();

        }

        // For some reason the orbit number sometimes has a leading space in the database field.
        // This causes the error: NumberFormatException.
        // Here I use a temporary string that holds the database value and then use trim()
        // to remove any leading and/or trailing spaces so the conversion doesn't throw an error.
        // This hack is also used in SatPredict

        tempval_str = SatData[23];  // revnr
        tempval_str=tempval_str.trim();
        SharedFunctions.sat_orbitnum = Long.parseLong(tempval_str);

        SharedFunctions.tle_sat_name = SharedFunctions.sat_name;
        SharedFunctions.tle_idesg    = SharedFunctions.sat_designator;
        SharedFunctions.tle_catnr    = (int) SharedFunctions.sat_catnum;
        SharedFunctions.tle_epoch    = (1000.0*(double)SharedFunctions.sat_year)+SharedFunctions.sat_refepoch;
        SharedFunctions.tle_xndt2o   = SharedFunctions.sat_drag;
        SharedFunctions.tle_xndd6o   = SharedFunctions.sat_nddot6;
        SharedFunctions.tle_bstar    = SharedFunctions.sat_bstar;
        SharedFunctions.tle_xincl    = SharedFunctions.sat_incl;
        SharedFunctions.tle_xnodeo   = SharedFunctions.sat_raan;
        SharedFunctions.tle_eo       = SharedFunctions.sat_eccn;
        SharedFunctions.tle_omegao   = SharedFunctions.sat_argper;
        SharedFunctions.tle_xmo      = SharedFunctions.sat_meanan;
        SharedFunctions.tle_xno      = SharedFunctions.sat_meanmo;
        SharedFunctions.tle_revnum   = (int) SharedFunctions.sat_orbitnum;

        /*final TextView SingleTrackText = (TextView)  this.findViewById(R.id.SingleTrackText);
        SingleTrackTime    = (TextView)  this.findViewById(R.id.SingleTrackTime);
        SatAz              = (TextView)  this.findViewById(R.id.AziText);
        SatEl              = (TextView)  this.findViewById(R.id.EleText);
        SatDetails         = (TextView)  this.findViewById(R.id.SatDetails);
        AosInfo            = (TextView)  this.findViewById(R.id.AosInfo);
        */

        if (sf.Geostationary()==1)
        {
            //SatDetails.setText("\n\nGeostationary satellites cannot be tracked in Realtime!\n");

        } else {

            //SatDetails.setText("Loading data..\n\n\n");

            //SingleTrackText.setText("\n" + SharedFunctions.tle_sat_name + " (" + SharedFunctions.tle_catnr + ")");

            // initializing and starting a new local Thread object

            /**
             * MODIFIED Thread currentThread = new Thread(this);
             */
            Thread currentThread = new Thread((Runnable) this);

            currentThread.start();


        } // end-if when object is non-geostationary

    }

    // PREDICT THREAD

    // Method you must override to control what the Thread is doing
    @SuppressLint("UseSparseArrays")
    public void run()
    {
        try
        {

            loop_counter=0;
            AosString="";
            SharedFunctions.approaching="";
            infoString = "1";
            alarm_done=0;

            // all the stuff we want our Thread to do goes here

    		/* This function tracks a single satellite in real-time
			   until 'Q' or ESC is pressed.  x represents the index
			   of the satellite being tracked.  If speak=='T', then
			   the speech routines are enabled. */

            sf.PreCalc();

            comsat=0;
            tshift=2;
            bshift=-2;


            SharedFunctions.daynum=SharedFunctions.CurrentDaynum();
            aoshappens=sf.AosHappens();
            geostationary=sf.Geostationary();
            decayed=sf.Decayed(0.0);


            SharedFunctions.SingleTrack_loop=1;
            while(SharedFunctions.SingleTrack_loop==1)
            {


                SharedFunctions.daynum=SharedFunctions.CurrentDaynum();

                sf.Calc();


                SharedFunctions.fk=12756.33*Math.acos(xkmper/(xkmper+SharedFunctions.sat_alt));
                SharedFunctions.fm=SharedFunctions.fk*km2mi;

                if (SharedFunctions.sat_sun_status==1)
                {
                    if (SharedFunctions.sun_ele<=-12.0 && SharedFunctions.sat_ele>=0.0)
                        SharedFunctions.visibility="V";  // visible
                    else
                        SharedFunctions.visibility="D";  // in daylight
                }
                else
                    SharedFunctions.visibility="N";  // in night



                doppler100=-100.0e06*((SharedFunctions.sat_range_rate*1000.0)/299792458.0);
                delay=1000.0*((1000.0*SharedFunctions.sat_range)/299792458.0);




                // only play sounds when satellite is above horizon

                if (SharedFunctions.sat_ele>=0.0)   // original statement
                {

                    if ((SharedFunctions.snd_receding_alarm_done==0) && (SharedFunctions.snd_receding==1))
                    {
                        // receding alarm has not yet been sounded

                        if (SharedFunctions.sat_range_rate>0.0)
                        {
                            // sat is receding

                            if (loop_counter == 0)
                            {
                                // do not play receding alarm if sat is receding at the very first run

                            } else {

                                // sound alert
                                // playSound("recede_alert");
                            }

                            // set alarm flag
                            SharedFunctions.snd_receding_alarm_done=1;

                        }

                    }



                    if (SharedFunctions.snd_alarm_done==0)
                    {

                        // satellite is above horizon, sound the bell

                        if (SharedFunctions.snd_abovehorizon==1)
                        {
                            // todo
                            // play alarm when above horizon
                            try {
                                Uri notification = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
                                Ringtone r = RingtoneManager.getRingtone(getApplicationContext(), notification);
                                r.play();
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        }

                        //alarm_done=1;   // only sound the bell once, so we set a flag

                    }

                    if (aos_alarm==0)
                    {

                        // aos alarm goes here..
                        aos_alarm=1;
                    }




                    if (eclipse_alarm==0 && Math.abs(SharedFunctions.eclipse_depth)<0.015) /* ~1 deg */
                    {
        				/* Hold off regular announcements if
						   satellite is within about 2 degrees
						   of entering into or out of an
						   eclipse. */


                        // there is a problem with calculating the eclipse_depth
                        // because of this, the value for eclipse_depth is always zero
                        // this means we will always enter this loop and update oldtime
                        // to the current time
                        // this has then the effect that the value of 'oldtime' will never
                        // be great enough to trigger regular voice announcements.

                        // commented this function to allow oldtime to do its thing
                        //oldtime=SharedFunctions.CurrentDaynum();

                        if ((old_visibility=="V" || old_visibility=="D") && SharedFunctions.visibility=="N")
                        {
                            infoString = "2.1";

                            if (SharedFunctions.snd_eclipsesun==1)
                            {
                                SharedFunctions.msgnr="ecl";
                                //playSound("eclipse");
                            }
                            eclipse_alarm=1;
                            oldtime-=0.000015*Math.sqrt(SharedFunctions.sat_alt);

                        }

                        if (old_visibility=="N" && (SharedFunctions.visibility=="V" || SharedFunctions.visibility=="D"))
                        {
                            infoString = "2.1";

                            if (SharedFunctions.snd_eclipsesun==1)
                            {
                                SharedFunctions.msgnr="sun";
                                //playSound("sunlight");
                            }
                            eclipse_alarm=1;
                            oldtime-=0.000015*Math.sqrt(SharedFunctions.sat_alt);

                        }
                    }


                    // trigger regular announcements about the satellite status

                    if ((SharedFunctions.CurrentDaynum()-oldtime)>(0.00003*Math.sqrt(SharedFunctions.sat_alt)))
                    {

                        infoString = "3";

                        if (SharedFunctions.sat_range_rate<0.0)
                            SharedFunctions.approaching="+";

                        if (SharedFunctions.sat_range_rate>0.0)
                            SharedFunctions.approaching="-";


                        oldtime=SharedFunctions.CurrentDaynum();
                        old_visibility=SharedFunctions.visibility;
                    }



                    if (SharedFunctions.sat_ele<=1.0 && SharedFunctions.approaching=="-")
                    {
        				/* Suspend regular announcements
					       as we approach LOS. */

                        infoString = "4";

                        oldtime=SharedFunctions.CurrentDaynum();
                    }


                } else {

                    // satellite is below observer's horizon

                    infoString = "bh";

                    lostime=0.0;
                    aos_alarm=0;
                    los_alarm=0;
                    eclipse_alarm=0;

                }


        		/* Send data to serial port antenna tracker
		   		   either as needed (when it changes), or
		   		   once per second. */

                if (SharedFunctions.sat_ele>=0.0 && SharedFunctions.antfd!=-1)
                {

                    // once_per_second is provided on the command line
                    if ((oldel!=SharedFunctions.iel || oldaz!=SharedFunctions.iaz) || (newtime>lasttime))
                    {
                        oldel=SharedFunctions.iel;
                        oldaz=SharedFunctions.iaz;
                        lasttime=newtime;
                    }
                }

                sf.FindMoon(SharedFunctions.daynum);

                if (geostationary==1 && SharedFunctions.sat_ele>=0.0)
                {
                    AosString="Satellite orbit is geostationary";
                    aoslos=-3651.0;
                }

                if (geostationary==1 && SharedFunctions.sat_ele<0.0)
                {
                    AosString="This satellite never reaches AOS";
                    aoslos=-3651.0;
                }

                if (aoshappens==0 || decayed==1)
                {
                    AosString="This satellite never reaches AOS";
                    aoslos=-3651.0;
                }

                if (SharedFunctions.sat_ele>=0.0 && geostationary==0 && decayed==0 && SharedFunctions.daynum>lostime)
                {
                    lostime=sf.FindLOS2();
                    AosString="LOS at: " + sf.Daynum2String(lostime);
                    aoslos=lostime;
                }

                else if (SharedFunctions.sat_ele<0.0 && geostationary==0 && decayed==0 && aoshappens==1 && SharedFunctions.daynum>aoslos)
                {
                    SharedFunctions.daynum+=0.003;  /* Move ahead slightly... */

                    nextaos=sf.FindAOS();
                    AosString="Next AOS: " + sf.Daynum2String(nextaos);
                    aoslos=nextaos;

                    if (oldtime!=0.0 && speak=="T")
                    {
                        /* Announce LOS = Spacecraft has moved out of range */
                        if (SharedFunctions.snd_los==1)
                        {
                            SharedFunctions.msgnr="los";
                            // playSound("los");
                        }
                    }
                }


                loop_counter++;

                Thread.sleep(250);

                // signaling things to the outside world goes like this
                threadHandler.sendEmptyMessage(0);

            }   // end while-true loop

            finish();

        } catch (InterruptedException e) {
            //don't forget to deal with the Exception !!!!!
        }
    }


    // Receives Thread's messages, interprets them and acts on the current Activity as needed
    @SuppressLint("HandlerLeak")
    private Handler threadHandler = new Handler()
    {
        @Override
        public void handleMessage(android.os.Message msg)
        {
            // whenever the Thread notifies this handler we update the screen
            // (updating the screen from run() will throw an exception!)

            //SingleTrackTime.setText(sf.Daynum2String(SharedFunctions.daynum));

            if (SharedFunctions.utc==1)
            {
                //SingleTrackTime.append(" UTC\n");
            } else {
                //SingleTrackTime.append(" Local Time\n");
            }


            //SatAz.setText(String.format("%.2f",SharedFunctions.sat_azi));

            plusSign = "";
            if (SharedFunctions.sat_ele > 0)
            {
                plusSign = "+";
            }
            //SatEl.setText(plusSign + String.format("%.2f",SharedFunctions.sat_ele));

            //SatDetails.setText("");
            if (SharedFunctions.sat_range_rate<0.0)
            {
                //SatDetails.setText("Spacecraft is approaching\n");
            } else {
                //SatDetails.setText("Spacecraft is receding\n");
            }



            //SatDetails.append("Spacecraft is currently ");
            if ("V".equals(SharedFunctions.visibility)) {
                //SatDetails.append("visible");
            }

            if ("D".equals(SharedFunctions.visibility)){
                //SatDetails.append("in sunlight");
            }

            if ("N".equals(SharedFunctions.visibility)){

            }
                //SatDetails.append("in eclipse");



            //AosInfo.setText(AosString);

        }
    };



    /**
     * This is the thread on which all the IOIO activity happens. It will be run
     * every time the application is resumed and aborted when it is paused. The
     * method setup() will be called right after a connection with the IOIO has
     * been established (which might happen several times!). Then, loop() will
     * be called repetitively until the IOIO gets disconnected.
     */

    class Looper extends BaseIOIOLooper {
        /** The on-board LED. */
        private DigitalOutput led_;
        private DigitalOutput step1_;
        private DigitalOutput step2_;
        private DigitalOutput dir1_;
        private DigitalOutput dir2_;
        private DigitalInput endstop1_;
        private DigitalInput endstop2_;

        //public TextView azimuth = (TextView) findViewById(R.id.textView);
        //public TextView elevation = (TextView) findViewById(R.id.textView2);

        private double azimuth_val = 0;
        private double elevation_val = 0;

        double sat_ele_decimals;
        double sat_azi_decimals;

        byte ele_sign;
        byte ele_huns=0x30;  // always zero
        byte ele_tens;
        byte ele_ones;
        byte ele_dec_1;
        byte ele_dec_2;

        byte azi_huns;
        byte azi_tens;
        byte azi_ones;
        byte azi_dec_1;
        byte azi_dec_2;


        /**
         * Called every time a connection with IOIO has been established.
         * Typically used to open pins.
         *
         * @throws ConnectionLostException
         *             When IOIO connection is lost.
         *
         */

        @Override
        protected void setup() throws ConnectionLostException {
            showVersions(ioio_, "IOIO connected!");
            led_ = ioio_.openDigitalOutput(0);
            step1_ = ioio_.openDigitalOutput(39); // Step Azimuth
            step2_ = ioio_.openDigitalOutput(37); // Step Elevation
            dir1_ = ioio_.openDigitalOutput(40); // Dir Azimuth
            dir2_ = ioio_.openDigitalOutput(38); // Dir Elevation
            endstop1_ = ioio_.openDigitalInput(35, DigitalInput.Spec.Mode.PULL_UP); // Endstop Azimuth
            endstop2_ = ioio_.openDigitalInput(36, DigitalInput.Spec.Mode.PULL_UP); // Endstop Elevation
            enableUi(true);
        }

        /**
         * Called repetitively while the IOIO is connected.
         *
         * @throws ConnectionLostException
         *             When IOIO connection is lost.
         * @throws InterruptedException
         * 				When the IOIO thread has been interrupted.
         *
         * @see ioio.lib.util.IOIOLooper#loop()
         */
        @Override
        public void loop() throws ConnectionLostException, InterruptedException {

            // -- elevation --
            // -- elevation --

            // work out above or below horizon
            if (SharedFunctions.sat_ele >= 0)
            {
                ele_sign=0x2B;  // '+'

            } else {

                ele_sign=0x2D;  // '-'
            }


            // work out stuff before decimal point
            if (Math.abs(SharedFunctions.sat_ele) >= 10)
            {

                ele_tens = (byte) ( ( (int) (Math.abs(SharedFunctions.sat_ele) / 10) ) + 48);
                ele_ones = (byte)  (( Math.abs(SharedFunctions.sat_ele)    -    (((int) (Math.abs(SharedFunctions.sat_ele) / 10)) * 10))+48);

            } else {

                ele_tens = 0x30;
                ele_ones = (byte) (Math.abs(SharedFunctions.sat_ele)+48);

            }


            // work out stuff after decimal point
            sat_ele_decimals=Math.abs(SharedFunctions.sat_ele) - (((ele_tens - 48)*10)+(ele_ones-48));

            ele_dec_1 = (byte) ((int) (sat_ele_decimals * 10) + 48);
            ele_dec_2 = (byte) ((int) (sat_ele_decimals * 100) - ((ele_dec_1 - 48) * 10) + 48);



            // -- azimuth --
            // -- azimuth --

            // work out stuff before decimal point
            if (Math.abs(SharedFunctions.sat_azi) >= 10)
            {

                if (Math.abs(SharedFunctions.sat_azi) >= 100)
                {

                    azi_huns = (byte) (((int) (Math.abs(SharedFunctions.sat_azi) / 100)) + 48);
                    azi_tens = (byte)  (int) (((Math.abs(SharedFunctions.sat_azi) - ((azi_huns-48)*100))/10) + 48);
                    azi_ones = (byte)  (int) ((Math.abs(SharedFunctions.sat_azi) - (((azi_huns-48)*100) + ((azi_tens-48)*10))) + 48);

                } else {

                    azi_huns = 0x30;  // 0
                    azi_tens = (byte) (((int) (Math.abs(SharedFunctions.sat_azi) / 10) ) + 48);
                    azi_ones = (byte) (int) ((Math.abs(SharedFunctions.sat_azi) - ((azi_tens-48)*10)) + 48);
                }

            } else {

                azi_huns = 0x30;  // 0
                azi_tens = 0x30;  // 0
                azi_ones = (byte) (Math.abs(SharedFunctions.sat_azi) + 48);

            }


            // work out stuff after decimal point
            sat_azi_decimals=Math.abs(SharedFunctions.sat_azi) - (((azi_huns - 48)*100) + ((azi_tens - 48)*10) +(azi_ones - 48));

            azi_dec_1 = (byte) ((int) (sat_azi_decimals * 10) + 48);
            azi_dec_2 = (byte) ((int) (sat_azi_decimals * 100) - ((azi_dec_1 - 48) * 10) + 48);




            // If activated, compare antenna position to realtime satellite

            if(toggle_tracker.isChecked()){

                // ELEVATION REALTIME TRACKER
                if(SharedFunctions.sat_ele >= elevation_val+2 && SharedFunctions.sat_ele > 0){
                    // if sat is above horizon and more than 2 degrees higher than antenna
                    output3_ = true;
                    output4_ = false;
                } else if(SharedFunctions.sat_ele <= elevation_val-2 && SharedFunctions.sat_ele > 0){
                    // if sat is above horizon but lower than antenna
                    output3_ = true;
                    output4_ = true;
                } else {
                    output3_ = false;
                }

                // AZIMUTH REALTIME TRACKER
                if(SharedFunctions.sat_azi >= azimuth_val+2){
                    // if sat is more than 2 degrees higher CW than antenna
                    output1_ = true;
                    output2_ = true;
                } else if(SharedFunctions.sat_azi <= azimuth_val-2){
                    // if sat is more than 2 degrees lower (CCW) than antenna
                    output1_ = true;
                    output2_ = false;
                } else {
                    output1_ = false;
                }
            }

            boolean endstop1 = endstop1_.read();
            boolean endstop2 = endstop2_.read();

            if(!endstop1){
                // ENDSTOP azimuth aktiverad
                azimuth_val = 0;

                // if direction is negative, inactivate steps in CCW direction
                if(!output2_){
                    output1_ = false;
                }
            } else {
                // Update current antenna AZIMUTH position
                if(output1_ == true && azimuth_val < 355 && output2_){
                    azimuth_val += 0.9; // Gear ratio 2:1
                } else if(output1_ == true && azimuth_val > -200 && !output2_){
                    azimuth_val -= 0.9;
                } else {
                    // In case we've reached maximum/minimum angle, stop stepper motor
                    output1_ = false;
                }

            }

            if(!endstop2){
                // ENDSTOP elevation aktiverad
                elevation_val = 0;

                // if direction is negative, inactivate step
                if(output4_){
                    output3_ = false;
                }
            } else {
                // Update current antenna ELEVATION position
                if(output3_ == true && elevation_val < 70 && !output4_){
                    elevation_val += 1.8;
                } else if(output3_ == true && elevation_val > -90 && output4_){
                    elevation_val -= 1.8;
                } else {
                    // In case we've reached maximum/minimum angle, stop stepper motor
                    output3_ = false;
                }
            }

            led_.write(!button_.isChecked());
            dir1_.write(output2_);
            step1_.write(output1_);
            dir2_.write(output4_);
            step2_.write(output3_);

            Thread.sleep(15); // Millisecond length of stepper motor signal

            // End all pulses to motors
            step1_.write(false);
            step2_.write(false);

            // Update UI with current antenna position
            final String str_azimuth = String.valueOf( roundToDecimals(azimuth_val, 1) );
            final String str_elevation = String.valueOf( roundToDecimals(elevation_val, 1) );

            runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    //update textviews
                    //azimuth.setText(str_azimuth);
                    //elevation.setText(str_elevation);
                }
            });

            Thread.sleep(250); // Pause the thread for 150milliseconds

        }


        /**
         * Called when the IOIO is disconnected.
         *
         * @see ioio.lib.util.IOIOLooper#disconnected()
         */
        @Override
        public void disconnected() {
            enableUi(false);
            toast("IOIO disconnected");
        }

        /**
         * Called when the IOIO is connected, but has an incompatible firmware version.
         *
         * @see ioio.lib.util.IOIOLooper#incompatible(IOIO)
         */
        @Override
        public void incompatible() {
            showVersions(ioio_, "Incompatible firmware version!");
        }
    }

    /**
     * A method to create our IOIO thread.
     *
     * //@see ioio.lib.util.AbstractIOIOActivity#createIOIOThread()
     */

    //@Override
    protected IOIOLooper createIOIOLooper() {
        return new Looper();
    }

    public static String[] joinArrays(String[]...arrays) {

        final List<String> output = new ArrayList<String>();

        for(String[] array : arrays) {
            output.addAll(Arrays.asList(array));
        }

        return output.toArray(new String[output.size()]);

    }


    @Override
    public void onBackPressed()
    {
        SharedFunctions.SingleTrack_loop=0;
        SharedFunctions.playing=0;

        finish();
    }

    private void showVersions(IOIO ioio, String title) {
        toast(String.format("%s\n" +
                        "IOIOLib: %s\n" +
                        "Application firmware: %s\n" +
                        "Bootloader firmware: %s\n" +
                        "Hardware: %s",
                title,
                ioio.getImplVersion(VersionType.IOIOLIB_VER),
                ioio.getImplVersion(VersionType.APP_FIRMWARE_VER),
                ioio.getImplVersion(VersionType.BOOTLOADER_VER),
                ioio.getImplVersion(VersionType.HARDWARE_VER)));
    }

    private void toast(final String message) {
        final Context context = this;
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                Toast.makeText(context, message, Toast.LENGTH_LONG).show();
            }
        });
    }

    private int numConnected_ = 0;

    private void enableUi(final boolean enable) {
        // This is slightly trickier than expected to support a multi-IOIO use-case.
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                if (enable) {
                    if (numConnected_++ == 0) {
                        button_.setEnabled(true);
                    }
                } else {
                    if (--numConnected_ == 0) {
                        button_.setEnabled(false);
                    }
                }
            }
        });
    }


    /**
     * MAIN MENU LIST
     */
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        switch (item.getItemId()){
            case R.id.action_settings:
                Intent intent1 = new Intent(MainActivity.this, SettingsActivity.class);
                //an SettingsActivity übergeben
                intent1.putExtra("strLocator", strLocator);
                startActivity(intent1);
                return true;

            case R.id.action_info:
                Intent intent2 = new Intent(MainActivity.this, InfoActivity.class);
                startActivity(intent2);
                return true;

            case R.id.action_help:
                Intent intent3 = new Intent(MainActivity.this, HelpActivity.class);
                startActivity(intent3);
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }

    class MyAdapter extends ArrayAdapter<String>{
        Context context;
        String[] myTitles;
        int[] imgs;

        MyAdapter (Context c, String[] titles, int[] imgs){
            super(c, R.layout.activity_listview, R.id.text1, titles);
            this.context = c;
            this.myTitles = titles;
            this.imgs = imgs;
        }

        @NonNull
        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
            LayoutInflater layoutInflater = (LayoutInflater)getApplicationContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            @SuppressLint("ViewHolder") View row2 = layoutInflater.inflate(R.layout.activity_listview, parent, false);
            ImageView images = row2.findViewById(R.id.imageViewLogo);
            TextView myTitle = row2.findViewById(R.id.text1);
            images.setImageResource(imgs[position]);
            myTitle.setText(titles[position]);
            return row2;
        }
    }

    @SuppressLint("MissingPermission")
    public void getLastLocation() {
        if (checkPermissions()) {
            if (isLocationEnabled()) {
                mFusedLocationClient.getLastLocation().addOnCompleteListener(
                        new OnCompleteListener<Location>() {
                            @Override
                            public void onComplete(@NonNull Task<Location> task) {
                                Location location = task.getResult();
                                if (location == null) {
                                    requestNewLocationData();
                                } else {

                                    lat = location.getLatitude();
                                    lon = location.getLongitude();
                                    fLat = (float) lat;
                                    fLon = (float) lon;
                                    strLocator=objCoordToLoc.latLonToGridSquare(fLat, fLon);
                                    tv_qth_on_main_activity.setText("QTH: "+strLocator);
                                }
                            }
                        }
                );
            } else {
                Toast.makeText(this, "Turn on location", Toast.LENGTH_LONG).show();
                Intent intent = new Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS);
                startActivity(intent);
            }
        } else {
            requestPermissions();
        }
    }


    @SuppressLint("MissingPermission")
    private void requestNewLocationData() {

        LocationRequest mLocationRequest = new LocationRequest();
        mLocationRequest.setPriority(LocationRequest.PRIORITY_HIGH_ACCURACY);
        mLocationRequest.setInterval(0);
        mLocationRequest.setFastestInterval(0);
        mLocationRequest.setNumUpdates(1);
        mFusedLocationClient = LocationServices.getFusedLocationProviderClient(this);
        mFusedLocationClient.requestLocationUpdates(mLocationRequest, mLocationCallback, android.os.Looper.myLooper());

    }

    private LocationCallback mLocationCallback = new LocationCallback() {
        @Override
        public void onLocationResult(LocationResult locationResult) {
            Location mLastLocation = locationResult.getLastLocation();
            lat = mLastLocation.getLatitude();
            lon = mLastLocation.getLongitude();
        }
    };

    private boolean checkPermissions() {
        return ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) == PackageManager.PERMISSION_GRANTED &&
                ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED;
    }

    private void requestPermissions() {
        ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.ACCESS_COARSE_LOCATION, Manifest.permission.ACCESS_FINE_LOCATION}, PERMISSION_ID);
    }

    private boolean isLocationEnabled() {
        LocationManager locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
        return locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER) || locationManager.isProviderEnabled(
                LocationManager.NETWORK_PROVIDER
        );
    }


    @Override
    public void onResume() {
        super.onResume();
        if (checkPermissions()) {
            getLastLocation();
        }
    }


    private void startDownloading() {
        File file = new File(getExternalFilesDir(null), "amateur.txt");
        if(file.exists()){
            file.delete();
            Log.i("myLog", "File deleted");
        }

        DownloadManager.Request request = new DownloadManager.Request(Uri.parse("https://www.celestrak.com/NORAD/elements/amateur.txt"));
        request.setAllowedNetworkTypes(DownloadManager.Request.NETWORK_WIFI | DownloadManager.Request.NETWORK_MOBILE);
        request.setTitle("Download");
        request.setDescription("Downloading File");
        request.setNotificationVisibility(DownloadManager.Request.VISIBILITY_HIDDEN); //VISIBILITY_HIDDEN
        request.setDestinationUri(Uri.fromFile(file));
        DownloadManager manager = (DownloadManager)getSystemService(Context.DOWNLOAD_SERVICE);
        manager.enqueue(request);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        switch(requestCode){
            case PERMISSION_STORAGE_CODE:{
                if(grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED){
                    startDownloading();
                }
                else{
                    Toast.makeText(this, "Permission denied", Toast.LENGTH_LONG).show();
                }
            }
            case PERMISSION_ID:{
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    getLastLocation();
                }
            }
        }
    }

}