/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.antennarotorcontrol;

import android.annotation.SuppressLint;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Calendar;

/**
 *
 * @author marcel
 */

@SuppressLint("SimpleDateFormat")
public class SharedFunctions {

    static String threeLineElement;

    static double secs;
    static int playsound=0;
    static int playing=0;
    static String msgnr="";  // debug
    static int snd_alarm_done=0;
    static int snd_abovehorizon=0;
    static int snd_receding=0;
    static int snd_receding_alarm_done=0;
    static int snd_announce=0;
    static int snd_eclipsesun=0;
    static int snd_los=0;
    static int snd_direction=0;
    static int satlist_sort_number=0;
    static String debug="";
    static int show_compass=1;


    static int init_prog;
    static int ioio_led;
    static long ntp_offset;
    static int load_offset;
    static int compass_match_margin = 10;

    static int pos_fromgooglemaps=0;
    static int pos_editgooglemaps=0;
    static double obs_lat;
    static double obs_lon;
    static String obs_newloc_name="";

    static int scrollpos_top=0;
    static int scrollpos_index=0;

    static int i2c_id=60;
    static String daycolour="#C1C1C2";
    static String nightcolour="#800000";
    static int NightMode=0;  // only applies to SingleTrack so far

    static Integer show_welcome = 0;
    static Integer show_whatsnew = 0;


    static String qth_stnname;
    static double qth_stnlat;
    static double qth_stnlon;
    static double qth_stnalt;
    static double obs_geodetic_lat;
    static double obs_geodetic_lon;
    static double obs_geodetic_alt;
    static double obs_geodetic_theta;
    static double pos_x;
    static double pos_y;
    static double pos_z;
    static double pos_w;
    static double vel_x;
    static double vel_y;
    static double vel_z;
    static double vel_w;
    static double obs_pos_x;
    static double obs_pos_y;
    static double obs_pos_z;
    static double obs_pos_w;
    static double obs_vel_x;
    static double obs_vel_y;
    static double obs_vel_z;
    static double obs_vel_w;
    static double obs_set_x;
    static double obs_set_y;
    static double obs_set_z;
    static double obs_set_w;
    static double solar_set_x;
    static double solar_set_y;
    static double solar_set_z;
    static double solar_set_w;
    static double solar_vector_x;
    static double solar_vector_y;
    static double solar_vector_z;
    static double solar_vector_w;
    static double range_x;
    static double range_y;
    static double range_z;
    static double range_w;
    static double rgvel_x;
    static double rgvel_y;
    static double rgvel_z;
    static double rgvel_w;
    static double sat_geodetic_lat;
    static double sat_geodetic_lon;
    static double sat_geodetic_alt;
    static double sat_geodetic_theta;

    static int pass_array_max = 50;
    static String[] pass_array = new String[pass_array_max];
    static int pass_array_counter;

    static String  sat_line1;       //the 1st TLE line with orbital details
    static String  sat_line2;       //the 2nd TLE line with orbital details
    static long    sat_setnum;      //

    static String  sat_name;        // the satellite name
    static String  sat_designator;  //
    static long    sat_catnum;      //

    static int     sat_year;        //
    static double  sat_refepoch;    //
    static double  sat_drag;
    static double  sat_nddot6;
    static double  sat_bstar;
    static double  sat_incl;        //
    static double  sat_raan;
    static double  sat_eccn;
    static double  sat_argper;
    static double  sat_meanan;
    static double  sat_meanmo;  // Mean Motion in revs per day
    static long    sat_orbitnum;

    static String tle_sat_name;
    static String tle_idesg;
    static long   tle_catnr;
    static double tle_epoch;
    static double tle_xndt2o;
    static double tle_xndd6o;
    static double tle_bstar;
    static double tle_xincl;
    static double tle_xnodeo;
    static double tle_eo;
    static double tle_omegao;
    static double tle_xmo;
    static double tle_xno;
    static long   tle_revnum;

    /* Global variables for sharing data among functions... */

    static double rx, ry, rz, sun_range, sun_range_rate, sun_lat, sun_lon, squint,
            ax, ay, az, jul_utc, jul_epoch, tsince, age, sat_vel, sat_azi,
            sat_range, sat_range_rate, sat_lat, sat_lon, fk, fm, eclipse_depth=0,
            phase;

    static String approaching, visibility;


    static double aodp = 0, aycof=0, c1 = 0, c4 = 0, c5 = 0, cosio=0, d2 = 0, d3 = 0, d4 = 0, delmo = 0,
            omgcof = 0, eta = 0, omgdot = 0, sinio = 0, xnodp=0, sinmo = 0, t2cof = 0, t3cof = 0, t4cof = 0,
            t5cof = 0, x1mth2 = 0, x3thm1 = 0, x7thm1 = 0, xmcof = 0, xmdot = 0, xnodcf = 0, xnodot = 0, xlcof=0;

    static double cosuk, sinuk, rfdotk, vx, vy, vz, ux, uy, uz, xmy, xmx, cosnok,
            sinnok, cosik, sinik, rdotk, xinck, xnodek, uk, rk, cos2u, sin2u,
            u, sinu, cosu, betal, rfdot, rdot, r, pl, elsq, esine, ecose, epw,
            cosepw, x1m5th, xhdot1, tfour, sinepw, capu, ayn, xlt, aynl, xll,
            axn, xn, beta, xl, e, a, tcube, delm, delomg, templ, tempe, tempa,
            xnode, tsq, xmp, omega, xnoddf, omgadf, xmdf, a1, a3ovk2, ao,
            betao, betao2, c1sq, c2, c3, coef, coef1, del1, delo, eeta, eosq,
            etasq, perigee, pinvsq, psisq, qoms24, s4, temp, temp1, temp2,
            temp3, temp4, temp5, temp6, theta2, theta4, tsi;

    static double xmam, bx, by, bz, cx, cy, cz;

    long irk, rv;

    static double daynum, alat, alon, lostime, aostime, sat_ele, sun_ele, sun_azi, sat_alt, obs_heading;
    static int indx, sat_sun_status;
    static boolean calc_squint;
    static int ds, utc;
    static double timezone;
    String ephem, findsun;
    static int antfd, iaz, iel, ma256, isplat, isplong, socket_flag=0, Flags=0;

    static double sin_lat, cos_lat, sin_theta, cos_theta, el, azim, top_s, top_e, top_z;  // duh

    static  double thgr=0, xnq=0, xqncl=0, omegaq=0, zmol=0, zmos=0, savtsn=0, ee2=0, e3=0, xi2=0,
            xl2=0, xl3=0, xl4=0, xgh2=0, xgh3=0, xgh4=0, xh2=0, xh3=0, sse=0, ssi=0, ssg=0, xi3=0,
            se2=0, si2=0, sl2=0, sgh2=0, sh2=0, se3=0, si3=0, sl3=0, sgh3=0, sh3=0, sl4=0, sgh4=0, ssl=0,
            ssh=0, d3210=0, d3222=0, d4410=0, d4422=0, d5220=0, d5232=0, d5421=0, d5433=0,
            del2=0, del3=0, fasx2=0, fasx4=0, fasx6=0, xlamo=0, xfact=0, xni=0, atime=0, stepp=0,
            stepn=0, step2=0, preep=0, sghs=0, xli=0, d2201=0, d2211=0, sghl=0, sh1=0, pinc=0,
            pe=0, shs=0, zsingl=0, zcosgl=0, zsinhl=0, zcoshl=0, zsinil=0, zcosil=0;

    static double a2, a3, a4, a5, a6, a7, a8, a9, a10, ainv2, alfdp, aqnv,
            sgh, sini2, sinis, sinok, sh, si, sil, day, betdp, dalf, bfact, c,
            cc, cosis, cosok, cosq, ctem, f322, zx, zy, dbet, dls, eoc, eq, f2,
            f220, f221, f3, f311, f321, xnoh, f330, f441, f442, f522, f523,
            f542, f543, g200, g201, g211, pgh, ph, s1, s2, s3, s5, s6, s7,
            se, sel, ses, xls, g300, g310, g322, g410, g422, g520, g521, g532,
            g533, gam, sinq, sinzf, sis, sl, sll, sls, stem, x1,
            x2, x2li, x2omi, x3, x4, x5, x6, x7, x8, xldot, xmao, xnddt,
            xndot, xno2, xnodce, xnoi, xomi, xpidot, z1, z2, z11, z12, z13,
            z21, z22, z23, z3, z31, z32, z33, ze, zf, zm, zmo, zn, zsing,
            zsinh, zsini, zcosg, zcosh, zcosi=0, delt=0, ft=0;

    static double moon_el, moon_az, moon_dx, moon_ra, moon_dec, moon_gha, moon_dv;

    /* Constants used by SGP4/SDP4 code */


    final double AU =         1.49597870691E8;        /* Astronomical unit - km (IAU 76) */
    final double secday =     8.6400E4;               /* Seconds per day */
    final double twopi =      6.28318530717958623;    /* 2*Pi  */
    final double f =          3.35281066474748E-3;    /* Flattening factor */
    final static double xkmper =     6.378137E3;             /* WGS 84 Earth radius km */
    final double mfactor =    7.292115E-5;
    final double omega_E =    1.00273790934;          /* Earth rotations/siderial day */
    final double pi =         3.14159265358979323846; /* Pi */
    //final double deg2rad =    1.745329251994330E-2;   /* Degrees to radians */
    final static double deg2rad =    1.745329251994330E-2;   /* Degrees to radians */
    final double pio2 =       1.57079632679489656;    /* Pi/2 */
    final double x3pio2 =     4.71238898038468967;     /* 3*Pi/2 */
    final double xmnpda =     1.44E3;                 /* Minutes per day */
    final double ae =         1.0;
    final double xke =        7.43669161E-2;
    final double tothrd =     6.6666666666666666E-1;  /* 2/3 */
    final double ck2 =        5.413079E-4;
    final double sr =         6.96000E5;              /* Solar radius - km (IAU 76) */
    final double s =          1.012229;
    final double qoms2t=      1.880279E-09;
    final double xj3 =        -2.53881E-6;             /* J3 Harmonic (WGS '72) */
    final double ck4 =        6.209887E-7;
    final double e6a =        1.0E-6;
    final double zns =        1.19459E-5;
    final double c1ss =       2.9864797E-6;
    final double zes =        1.675E-2;
    final double znl =        1.5835218E-4;
    final double c1l =        4.7968065E-7;
    final double zel =        5.490E-2;
    final double zcosis =     9.1744867E-1;  // gives error in Deep() method
    final double zsinis =     3.9785416E-1;
    final double zsings =     -9.8088458E-1;
    final double zcosgs =     1.945905E-1;
    final double zcoshs =     1;
    final double zsinhs =     0;
    final double q22 =        1.7891679E-6;
    final double q31 =        2.1460748E-6;
    final double q33 =        2.2123015E-7;
    final double g22 =        5.7686396;
    final double g32 =        9.5240898E-1;
    final double g44 =        1.8014998;
    final double g52 =        1.0508330;
    final double g54 =        4.4108898;
    final double root22 =     1.7891679E-6;
    final double root32 =     3.7393792E-7;
    final double root44 =     7.3636953E-9;
    final double root52 =     1.1428639E-7;
    final double root54 =     2.1765803E-9;
    final double thdt =       4.3752691E-3;
    final double rho =        1.5696615E-1;
    final static double km2mi =      0.621371;               /* km to miles */

    double sun_ra, sun_dec;

    /* Entry points of Deep() */

    final int dpinit =        1; /* Deep-space initialization code */
    final int dpsec =         2; /* Deep-space secular code        */
    final int dpper =         3; /* Deep-space periodic code       */

    /* Two-line Orbital Elements for the satellite used by SGP4/SDP4 code. */

    static int rise_az, set_az, max_el;

    static int SingleTrack_loop;

    // variables for calculating the phase of the moon
    public static final double PI = 3.1415926535897932384626433832795;
    public static final double RAD = (PI/180.0);
    public static final double SMALL_FLOAT = (1e-12);
    static int m_year,m_month,m_day;
    static double m_hour;

    class tle_t
    {

        String sat_name;
        String idesg;
        int catnr;
        double epoch;
        double xndt2o;  // drag
        double xndd6o;  // nddot6
        double bstar;   // bstar
        double xincl;   // incl
        double xnodeo;  // raan
        double eo;      // eccn
        double omegao;  // argper
        double xmo;     // meanan
        double xno;     // meanmo
        int elset;      // ?
        int revnum;     // orbitnum


    }


    /* Flow control flag definitions */

    int VISIBLE_FLAG;
    int DEEP_SPACE_EPHEM_FLAG;
    int SAT_ECLIPSED_FLAG;
    int SDP4_INITIALIZED_FLAG;
    int SGP4_INITIALIZED_FLAG;
    int RESONANCE_FLAG;
    int SIMPLE_FLAG;
    int LUNAR_TERMS_DONE_FLAG;
    int DO_LOOP_FLAG;
    int SYNCHRONOUS_FLAG;
    int EPOCH_RESTART_FLAG;

    /** Type definitions **/

    class vector_t
    {

        double x=0;
        double y=0;
        double z=0;
        double w=0;

    }

    class geodetic_t
    {

        double lat;
        double lon;
        double alt;
        double theta;

    }




    /* Common arguments between deep-space functions used by SGP4/SDP4 code. */

    class deep_arg_t
    {

        /* Used by dpinit part of Deep() */
        double  eosq, sinio, cosio, betao, aodp, theta2, sing, cosg, betao2, xmdot, omgdot, xnodot, xnodp;

        /* Used by dpsec and dpper parts of Deep() */
        double  xll, omgadf, xnode, em, xinc, xn, t;

        /* Used by thetg and Deep() */
        double  ds50;
    }




    void Calculate_Solar_Position (double time)
    {
        /* Calculates solar position vector */

        double mjd, year, T, M, L, e, C, O, Lsa, nu, R, eps;

        mjd=time-2415020.0;
        year=1900+mjd/365.25;
        T=(mjd+Delta_ET2(year)/secday)/36525.0;
        M=Math.toRadians(((358.47583+((35999.04975*T) % 360.0)-(0.000150+0.0000033*T)*Math.pow(T,2)) % 360.0));
        L=Math.toRadians((279.69668+((36000.76892*T) % 360.0)+0.0003025*Math.pow(T,2)) % 360.0);
        e=0.01675104-(0.0000418+0.000000126*T)*T;
        C=Math.toRadians((1.919460-(0.004789+0.000014*T)*T)*Math.sin(M)+(0.020094-0.000100*T)*Math.sin(2*M)+0.000293*Math.sin(3*M));
        O=Math.toRadians((259.18-1934.142*T) % 360.0);
        Lsa=(L+C-Math.toRadians(0.00569-0.00479*Math.sin(O))) % twopi;
        nu=M+C % twopi;
        R=1.0000002*(1.0-Math.pow(e,2))/(1.0+e*Math.cos(nu));
        eps=Math.toRadians(23.452294-(0.0130125+(0.00000164-0.000000503*T)*T)*T+0.00256*Math.cos(O));
        R=AU*R;
        solar_vector_x=R*Math.cos(Lsa);
        solar_vector_y=R*Math.sin(Lsa)*Math.cos(eps);
        solar_vector_z=R*Math.sin(Lsa)*Math.sin(eps);
        solar_vector_w=R;

    }

    double Delta_ET2(double year)
    {
        /* The function Delta_ET has been added to allow calculations on   */
        /* the position of the sun.  It provides the difference between UT */
        /* (approximately the same as UTC) and ET (now referred to as TDT).*/
        /* This function is based on a least squares fit of data from 1950 */
        /* to 1991 and will need to be updated periodically. */

        /* Values determined using data from 1950-1991 in the 1990
        Astronomical Almanac.  See DELTA_ET.WQ1 for details. */

        double delta_et;

        delta_et=26.465+0.747622*(year-1950)+1.886913*Math.sin(twopi*(year-1975)/33);

        return delta_et;
    }


    @SuppressLint("SimpleDateFormat")
    public String Daynum2String (double daynum_double)
    {
        /* This function takes the given epoch as a fractional number of
           days since 31Dec79 00:00:00 UTC and returns the corresponding
           date as a string of the form "Tue 12Oct99 17:22:37". */


        /* Convert daynum to Unix time (seconds since 01-Jan-70) */
        daynum_double=(daynum_double+3651)*86400;




        if (SharedFunctions.utc == 1)
        {

            // Display times in UTC

            // compensate for timezone
            daynum_double = daynum_double - SharedFunctions.timezone *3600;

            // possibly compensate for daylight savings
            if (SharedFunctions.ds==1)
            {
                // daylight savings flag is set

                if (SharedFunctions.timezone > 0)
                {
                    // timezone is east of GMT, subtract one hour
                    daynum_double = daynum_double - 3600;
                } else {

                    // timezone is east of GMT, subtract one hour
                    daynum_double = daynum_double + 3600;
                }

            }

        }



        /* convert unix time to readable format with time and date */
        int daynum_int = (int) daynum_double;



        String daynum_string=Integer.toString(daynum_int);

        long dv = Long.valueOf(daynum_string)*1000;// needs to be in milisecond
        Date df = new Date(dv);

        String vv = new SimpleDateFormat("E dd-MM-yyyy HH:mm:ss").format(df);

        return vv;

    }

    double AcTan(double sinx, double cosx)
    {
        /* Four-quadrant arctan function */

        if (cosx==0.0)
        {
            if (sinx>0.0)
                return (pio2);
            else
                return (x3pio2);
        }

        else
        {
            if (cosx>0.0)
            {
                if (sinx>0.0)
                    return (Math.atan(sinx/cosx));
                else
                    return (twopi+Math.atan(sinx/cosx));
            }

            else
                return (pi+Math.atan(sinx/cosx));
        }
    }



    double Degrees(double arg)
    {
        /* Returns angle in degrees from argument in radians */
        return (arg/deg2rad);
    }


    double ThetaG_JD(double jd)
    {
        /* Reference:  The 1992 Astronomical Almanac, page B6. */

        double UT, TU, GMST;

        UT=Frac(jd+0.5);
        jd=jd-UT;
        TU=(jd-2451545.0)/36525;
        GMST=24110.54841+TU*(8640184.812866+TU*(0.093104-TU*6.2E-6));
        GMST=(GMST+secday*omega_E*UT % secday);

        return (twopi*GMST/secday);
    }

    double Frac(double arg)
    {
        /* Returns fractional part of double argument */
        return(arg-Math.floor(arg));
    }

    double FMod2p(double x)
    {
        /* Returns mod 2PI of argument */

        int i;
        double ret_val;

        ret_val=x;
        i=(int) (ret_val/twopi);
        ret_val-=i*twopi;

        if (ret_val<0.0)
            ret_val+=twopi;

        return ret_val;
    }

    double mod(double x, int y)
    {
        double result = x % y;
        if (result < 0)
            result += y;
        return result;
    }


    double Delta_ET(double year)
    {
        /* The function Delta_ET has been added to allow calculations on   */
        /* the position of the sun.  It provides the difference between UT */
        /* (approximately the same as UTC) and ET (now referred to as TDT).*/
        /* This function is based on a least squares fit of data from 1950 */
        /* to 1991 and will need to be updated periodically. */

        /* Values determined using data from 1950-1991 in the 1990
        Astronomical Almanac.  See DELTA_ET.WQ1 for details. */

        double delta_et;

        delta_et=26.465+0.747622*(year-1950)+1.886913*Math.sin(twopi*(year-1975)/33);

        return delta_et;
    }

    double GetStartTime_old()
    {

        // this function has been rewritten as GetStartTime.java (class) and
        // grabs the time and date through on-screen time and date pickers

        /* This function prompts the user for the time and date
           the user wishes to begin prediction calculations,
           and returns the corresponding fractional day number.
           31Dec79 00:00:00 returns 0.  Default is NOW. */

        /* This module is to allow the user to enter their custom
           time and date. Since this isn't programmed yet we will
           just use the current time and date. */

        return (CurrentDaynum());
    }

    static double CurrentDaynum()
    {
        /* Read the system clock and return the number
           of days since 31Dec79 00:00:00 UTC (daynum 0) */


        // 1369090640
        secs = (System.currentTimeMillis()+ntp_offset)/1000;


        //double systemTimeStamp=((((System.currentTimeMillis()+ntp_offset)/1000.0)/86400.0)-3651.0);
        double systemTimeStamp=((secs/86400.0)-3651.0);

        double UTCTimeStamp=systemTimeStamp;

        return UTCTimeStamp;
    }

    static double CurrentDaynum_orig()
    {
        /* Read the system clock and return the number
           of days since 31Dec79 00:00:00 UTC (daynum 0) */

        double systemTimeStamp=((((System.currentTimeMillis()+ntp_offset)/1000.0)/86400.0)-3651.0);

        double UTCTimeStamp=systemTimeStamp;

        return UTCTimeStamp;
    }



    double PrimeAngle(double x)
    {
        /* This function is used in the FindMoon() function. */

        x=x-360.0*Math.floor(x/360.0);
        return x;
    }

    double FixAngle(double x)
    {
        /* This function reduces angles greater than
           two pi by subtracting two pi from the angle */

        while (x>twopi)
            x-=twopi;

        return x;
    }



    //    void Calculate_Obs(double time, vector_t pos, vector_t vel, geodetic_t geodetic, vector_t obs_set)
    void Calculate_Obs(double time)
    {
        // obs_set_x,y,z

        /* The procedures Calculate_Obs and Calculate_RADec calculate         */
        /* the *topocentric* coordinates of the object with ECI position,     */
        /* {pos}, and velocity, {vel}, from location {geodetic} at {time}.    */
        /* The {obs_set} returned for Calculate_Obs consists of azimuth,      */
        /* elevation, range, and range rate (in that order) with units of     */
        /* radians, radians, kilometers, and kilometers/second, respectively. */
        /* The WGS '72 geoid is used and the effect of atmospheric refraction */
        /* (under standard temperature and pressure) is incorporated into the */
        /* elevation calculation; the effect of atmospheric refraction on     */
        /* range and range rate has not yet been quantified.                  */

        /* The {obs_set} for Calculate_RADec consists of right ascension and  */
        /* declination (in that order) in radians.  Again, calculations are   */
        /* based on *topocentric* position using the WGS '72 geoid and        */
        /* incorporating atmospheric refraction.                              */

        //     Log.i("info","(Calculate_Obs) (1) pos_x = " + pos_x);



        //   SharedFunctions.vector_t obs_pos = this.new vector_t();  // create new instance of vector_t
        //   SharedFunctions.vector_t obs_vel = this.new vector_t();  // create new instance of vector_t
        //    SharedFunctions.vector_t range = this.new vector_t();  // create new instance of vector_t
        //     SharedFunctions.vector_t rgvel = this.new vector_t();  // create new instance of vector_t


        //      Log.i("info","(Calc_Obs) geodetic.lon (1) = " + geodetic.lon);

        // Calculate_User_PosVel(time, geodetic, obs_pos, obs_vel);
        Calculate_User_PosVel(time);

        //      Log.i("info","(Calc_Obs) geodetic.lon (2) = " + geodetic.lon);


        range_x=pos_x-obs_pos_x;   // differs with calculate_obs2
        range_y=pos_y-obs_pos_y;   // differs with calculate_obs2
        range_z=pos_z-obs_pos_z;   // differs with calculate_obs2

        /* Save these values globally for calculating squint angles later... */

        rx=range_x;
        ry=range_y;
        rz=range_z;

        rgvel_x=vel_x-obs_vel_x;   // differs with calculate_obs2
        rgvel_y=vel_y-obs_vel_y;   // differs with calculate_obs2
        rgvel_z=vel_z-obs_vel_z;   // differs with calculate_obs2



        // Magnitude(range);
        range_w = Math.sqrt(Math.pow(range_x,2)+Math.pow(range_y,2)+Math.pow(range_z,2));


        sin_lat=Math.sin(obs_geodetic_lat);
        cos_lat=Math.cos(obs_geodetic_lat);
        sin_theta=Math.sin(obs_geodetic_theta);
        cos_theta=Math.cos(obs_geodetic_theta);
        top_s=sin_lat*cos_theta*range_x+sin_lat*sin_theta*range_y-cos_lat*range_z;
        top_e=-sin_theta*range_x+cos_theta*range_y;
        top_z=cos_lat*cos_theta*range_x+cos_lat*sin_theta*range_y+sin_lat*range_z;
        azim=Math.atan(-top_e/top_s); /* Azimuth */

        if (top_s>0.0)
            azim=azim+pi;

        if (azim<0.0)
            azim=azim+twopi;





        el=ArcSin(top_z/range_w);


        //     Log.i("info","(Calculate_Obs) (2) pos_x = " + pos_x);


        obs_set_x=azim;        /* Azimuth (radians)   */   // differs with calculate_obs2
        obs_set_y=el;          /* Elevation (radians) */   // differs with calculate_obs2
        obs_set_z=range_w;     /* Range (kilometers)  */   // differs with calculate_obs2


        /* Range Rate (kilometers/second) */

        //obs_set_w=Dot(range, rgvel)/range_w;
        /* Returns the dot product of two vectors */
        obs_set_w=(range_x*rgvel_x+range_y*rgvel_y+range_z*rgvel_z);

        //Log.e("Calculate_Obs","obs_set_w = " + obs_set_w);

        /* Corrections for atmospheric refraction */
        /* Reference:  Astronomical Algorithms by Jean Meeus, pp. 101-104    */
        /* Correction is meaningless when apparent elevation is below horizon */

        /*** The following adjustment for
         atmospheric refraction is bypassed ***/

        /* obs_set->y=obs_set->y+Radians((1.02/tan(Radians(Degrees(el)+10.3/(Degrees(el)+5.11))))/60); */

        obs_set_y=el;   // differs with calculate_obs2

        /**** End bypass ****/

        if (obs_set_y>=0.0)   // differs with calculate_obs2
            VISIBLE_FLAG=1;
        else
        {
            obs_set_y=el;  /* Reset to true elevation */   // differs with calculate_obs2
            VISIBLE_FLAG=0;
        }


    }



    //    void Calculate_Obs(double time, vector_t pos, vector_t vel, geodetic_t geodetic, vector_t obs_set)
    //Calculate_Obs(jul_utc, solar_vector, zero_vector, obs_geodetic, solar_set);
    void Calculate_Obs_2(double time)
    {

        // solar_set_x,y,z

        /* The procedures Calculate_Obs and Calculate_RADec calculate         */
        /* the *topocentric* coordinates of the object with ECI position,     */
        /* {pos}, and velocity, {vel}, from location {geodetic} at {time}.    */
        /* The {obs_set} returned for Calculate_Obs consists of azimuth,      */
        /* elevation, range, and range rate (in that order) with units of     */
        /* radians, radians, kilometers, and kilometers/second, respectively. */
        /* The WGS '72 geoid is used and the effect of atmospheric refraction */
        /* (under standard temperature and pressure) is incorporated into the */
        /* elevation calculation; the effect of atmospheric refraction on     */
        /* range and range rate has not yet been quantified.                  */

        /* The {obs_set} for Calculate_RADec consists of right ascension and  */
        /* declination (in that order) in radians.  Again, calculations are   */
        /* based on *topocentric* position using the WGS '72 geoid and        */
        /* incorporating atmospheric refraction.                              */


        //double sin_lat, cos_lat, sin_theta, cos_theta, el, azim, top_s, top_e, top_z;  // not used

        //   SharedFunctions.vector_t obs_pos = this.new vector_t();  // create new instance of vector_t
        //   SharedFunctions.vector_t obs_vel = this.new vector_t();  // create new instance of vector_t
        //   SharedFunctions.vector_t range = this.new vector_t();  // create new instance of vector_t
        //   SharedFunctions.vector_t rgvel = this.new vector_t();  // create new instance of vector_t


        //      Log.i("info","(Calc_Obs) geodetic.lon (1) = " + geodetic.lon);

        // Calculate_User_PosVel(time, geodetic, obs_pos, obs_vel);
        Calculate_User_PosVel(time);

        //      Log.i("info","(Calc_Obs) geodetic.lon (2) = " + geodetic.lon);



        range_x=solar_vector_x-obs_pos_x;   // differs with calculate_obs
        range_y=solar_vector_y-obs_pos_y;   // differs with calculate_obs
        range_z=solar_vector_z-obs_pos_z;   // differs with calculate_obs

        /* Save these values globally for calculating squint angles later... */

        rx=range_x;
        ry=range_y;
        rz=range_z;

        rgvel_x=0-obs_vel_x;   // differs with calculate_obs
        rgvel_y=0-obs_vel_y;   // differs with calculate_obs
        rgvel_z=0-obs_vel_z;   // differs with calculate_obs



        // Magnitude(range);
        range_w = Math.sqrt(Math.pow(range_x,2)+Math.pow(range_y,2)+Math.pow(range_z,2));


        sin_lat=Math.sin(obs_geodetic_lat);
        cos_lat=Math.cos(obs_geodetic_lat);
        sin_theta=Math.sin(obs_geodetic_theta);
        cos_theta=Math.cos(obs_geodetic_theta);
        top_s=sin_lat*cos_theta*range_x+sin_lat*sin_theta*range_y-cos_lat*range_z;
        top_e=-sin_theta*range_x+cos_theta*range_y;
        top_z=cos_lat*cos_theta*range_x+cos_lat*sin_theta*range_y+sin_lat*range_z;
        azim=Math.atan(-top_e/top_s); /* Azimuth */

        if (top_s>0.0)
            azim=azim+pi;

        if (azim<0.0)
            azim=azim+twopi;



        el=ArcSin(top_z/range_w);



        solar_set_x=azim;        /* Azimuth (radians)   */   // differs with calculate_obs
        solar_set_y=el;          /* Elevation (radians) */   // differs with calculate_obs
        solar_set_z=range_w;     /* Range (kilometers)  */   // differs with calculate_obs

        /* Range Rate (kilometers/second) */

        //solar_set_w=Dot(range, rgvel)/range_w;

        // to do  this was changed from obs_set_w to solar_set_w

        /* Returns the dot product of two vectors */   // this was originally in a separate function
        solar_set_w=(range_x*rgvel_x+range_y*rgvel_y+range_z*rgvel_z);

        //Log.e("Calculate_Obs_2","obs_set_x = " + obs_set_x);

        /* Corrections for atmospheric refraction */
        /* Reference:  Astronomical Algorithms by Jean Meeus, pp. 101-104    */
        /* Correction is meaningless when apparent elevation is below horizon */

        /*** The following adjustment for
         atmospheric refraction is bypassed ***/

        /* obs_set->y=obs_set->y+Radians((1.02/tan(Radians(Degrees(el)+10.3/(Degrees(el)+5.11))))/60); */

        solar_set_y=el;   // differs with calculate_obs

        /**** End bypass ****/

        if (solar_set_y>=0.0)   // differs with calculate_obs
            VISIBLE_FLAG=1;
        else
        {
            solar_set_y=el;  /* Reset to true elevation */   // differs with calculate_obs
            VISIBLE_FLAG=0;
        }

    }

    void Calculate_User_PosVel(double time)
    {
        /* Calculate_User_PosVel() passes the user's geodetic position
           and the time of interest and returns the ECI position and
           velocity of the observer.  The velocity calculation assumes
           the geodetic position is stationary relative to the earth's
           surface. */

        /* Reference:  The 1992 Astronomical Almanac, page K11. */

        double c, sq, achcp;

        obs_geodetic_theta=FMod2p(ThetaG_JD(time)+obs_geodetic_lon); /* LMST */
        c=1/Math.sqrt(1+f*(f-2)*Math.pow(((Math.sin(obs_geodetic_lat))),2));
        sq=Math.pow((1-f),2)*c;
        achcp=(xkmper*c+obs_geodetic_alt)*Math.cos(obs_geodetic_lat);
        obs_pos_x=achcp*Math.cos(obs_geodetic_theta); /* kilometers */
        obs_pos_y=achcp*Math.sin(obs_geodetic_theta);
        obs_pos_z=(xkmper*sq+obs_geodetic_alt)*Math.sin(obs_geodetic_lat);
        obs_vel_x=-mfactor*obs_pos_y; /* kilometers/second */
        obs_vel_y=mfactor*obs_pos_x;
        obs_vel_z=0;
        //Magnitude(obs_pos);
        /* Calculate scalar magnitude of a vector_t argument */
        obs_pos_w = Math.sqrt(Math.pow(obs_pos_x,2)+Math.pow(obs_pos_y,2)+Math.pow(obs_pos_z,2));

        //Magnitude(obs_vel);
        /* Calculate scalar magnitude of a vector_t argument */
        obs_vel_w = Math.sqrt(Math.pow(obs_vel_x,2)+Math.pow(obs_vel_y,2)+Math.pow(obs_vel_z,2));



    }


    void Magnitude(vector_t v)
    {
        /* Calculates scalar magnitude of a vector_t argument */
        v.w = Math.sqrt(Math.pow(v.x,2)+Math.pow(v.y,2)+Math.pow(v.z,2));

    }



    double Dot(vector_t v1, vector_t v2)
    {
        /* Returns the dot product of two vectors */
        return (v1.x*v2.x+v1.y*v2.y+v1.z*v2.z);
    }







    void Calculate_LatLonAlt(double time)
    {
        /* Procedure Calculate_LatLonAlt will calculate the geodetic  */
        /* position of an object given its ECI position pos and time. */
        /* It is intended to be used to determine the ground track of */
        /* a satellite.  The calculations  assume the earth to be an  */
        /* oblate spheroid as defined in WGS '72.                     */

        /* Reference:  The 1992 Astronomical Almanac, page K12. */

        double r, e2, phi, c;

        // solar_vector was 'pos' (arg 2)
        // solar_latlonalt was 'geodetic' (arg 3)

        sat_geodetic_theta=AcTan(pos_y,pos_x); /* radians */
        sat_geodetic_lon=FMod2p(sat_geodetic_theta-ThetaG_JD(time)); /* radians */
        r=Math.sqrt(Math.pow(pos_x,2)+Math.pow(pos_y,2));
        e2=f*(2-f);
        sat_geodetic_lat=AcTan(pos_z,r); /* radians */

        do
        {
            phi=sat_geodetic_lat;
            c=1/Math.sqrt(1-e2*Math.pow(Math.sin(phi),2));
            sat_geodetic_lat=AcTan(pos_z+xkmper*c*e2*Math.sin(phi),r);

        } while (Math.abs(sat_geodetic_lat-phi)>=1E-10);

        sat_geodetic_alt=r/Math.cos(sat_geodetic_lat)-xkmper*c; /* kilometers */

        if (sat_geodetic_lat>pio2)
            sat_geodetic_lat-=twopi;
    }


    //                                     solar_vector       solar_latlonalt
    void Calculate_LatLonAlt2(double time,               geodetic_t geodetic)
    // void Calculate_LatLonAlt2(double time, vector_t pos, geodetic_t geodetic)
    {
        /* Procedure Calculate_LatLonAlt will calculate the geodetic  */
        /* position of an object given its ECI position pos and time. */
        /* It is intended to be used to determine the ground track of */
        /* a satellite.  The calculations  assume the earth to be an  */
        /* oblate spheroid as defined in WGS '72.                     */

        /* Reference:  The 1992 Astronomical Almanac, page K12. */

        double r, e2, phi, c;

        // solar_vector was 'pos' (arg 2)
        // solar_latlonalt was 'geodetic' (arg 3)

        geodetic.theta=AcTan(solar_vector_y,solar_vector_x); /* radians */
        geodetic.lon=FMod2p(geodetic.theta-ThetaG_JD(time)); /* radians */
        r=Math.sqrt(Math.pow(solar_vector_x,2)+Math.pow(solar_vector_y,2));
        e2=f*(2-f);
        geodetic.lat=AcTan(solar_vector_z,r); /* radians */

        do
        {
            phi=geodetic.lat;
            c=1/Math.sqrt(1-e2*Math.pow(Math.sin(phi),2));
            geodetic.lat=AcTan(solar_vector_z+xkmper*c*e2*Math.sin(phi),r);

        } while (Math.abs(geodetic.lat-phi)>=1E-10);   // [UNSURE] was fabs (floating-point abs??)

        geodetic.alt=r/Math.cos(geodetic.lat)-xkmper*c; /* kilometers */

        if (geodetic.lat>pio2)
            geodetic.lat-=twopi;
    }


    void Calculate_RADec(double time, vector_t pos, vector_t vel)
    {
        /* Reference:  Methods of Orbit Determination by  */
        /*             Pedro Ramon Escobal, pp. 401-402   */

        double  phi, theta, sin_theta, cos_theta, sin_phi, cos_phi, az, el,
                Lxh, Lyh, Lzh, Sx, Ex, Zx, Sy, Ey, Zy, Sz, Ez, Zz, Lx, Ly,
                Lz, cos_delta, sin_alpha, cos_alpha;

        Calculate_Obs(time);

        az=obs_set_x;
        el=obs_set_y;
        phi=obs_geodetic_lat;
        theta=FMod2p(ThetaG_JD(time)+obs_geodetic_lon);
        sin_theta=Math.sin(theta);
        cos_theta=Math.cos(theta);
        sin_phi=Math.sin(phi);
        cos_phi=Math.cos(phi);
        Lxh=-Math.cos(az)*Math.cos(el);
        Lyh=Math.sin(az)*Math.cos(el);
        Lzh=Math.sin(el);
        Sx=sin_phi*cos_theta;
        Ex=-sin_theta;
        Zx=cos_theta*cos_phi;
        Sy=sin_phi*sin_theta;
        Ey=cos_theta;
        Zy=sin_theta*cos_phi;
        Sz=-cos_phi;
        Ez=0.0;
        Zz=sin_phi;
        Lx=Sx*Lxh+Ex*Lyh+Zx*Lzh;
        Ly=Sy*Lxh+Ey*Lyh+Zy*Lzh;
        Lz=Sz*Lxh+Ez*Lyh+Zz*Lzh;
        obs_set_y=ArcSin(Lz);  /* Declination (radians) */
        cos_delta=Math.sqrt(1.0-Math.pow(Lz,2));
        sin_alpha=Ly/cos_delta;
        cos_alpha=Lx/cos_delta;
        obs_set_x=AcTan(sin_alpha,cos_alpha); /* Right Ascension (radians) */
        obs_set_x=FMod2p(obs_set_x);
    }


    // satellite predict functions

    //-- NEW CODE BEGIN--



    void Deep(int ientry, deep_arg_t deep_arg)
    {
        /* This function is used by SDP4 to add lunar and solar */
        /* perturbation effects to deep-space orbit objects.    */

        if (ientry==dpinit)
        {

            /* Entrance for deep space initialization */

            thgr=ThetaG(tle_epoch,deep_arg);
            eq=tle_eo;
            xnq=deep_arg.xnodp;
            aqnv=1/deep_arg.aodp;
            xqncl=tle_xincl;
            xmao=tle_xmo;
            xpidot=deep_arg.omgdot+deep_arg.xnodot;
            sinq=Math.sin(tle_xnodeo);
            cosq=Math.cos(tle_xnodeo);
            omegaq=tle_omegao;

            /* Initialize lunar solar terms */
            day=deep_arg.ds50+18261.5;  /* Days since 1900 Jan 0.5 */

            // errors below

            if (day!=preep)
            {
                preep=day;
                xnodce=4.5236020-9.2422029E-4*day;
                stem=Math.sin(xnodce);
                ctem=Math.cos(xnodce);
                zcosil=0.91375164-0.03568096*ctem;
                zsinil=Math.sqrt(1-zcosil*zcosil);
                zsinhl=0.089683511*stem/zsinil;
                zcoshl=Math.sqrt(1-zsinhl*zsinhl);
                c=4.7199672+0.22997150*day;
                gam=5.8351514+0.0019443680*day;
                zmol=FMod2p(c-gam);
                zx=0.39785416*stem/zsinil;
                zy=zcoshl*ctem+0.91744867*zsinhl*stem;
                zx=AcTan(zx,zy);
                zx=gam+zx-xnodce;
                zcosgl=Math.cos(zx);
                zsingl=Math.sin(zx);
                zmos=6.2565837+0.017201977*day;
                zmos=FMod2p(zmos);
            }


            /* Do solar terms */
            savtsn=1E20;
            zcosg=zcosgs;
            zsing=zsings;
            zcosi=zcosis;
            zsini=zsinis;
            zcosh=cosq;
            zsinh=sinq;
            cc=c1ss;
            zn=zns;
            ze=zes;
            zmo=zmos;
            xnoi=1/xnq;


            /* Loop breaks when Solar terms are done a second */
            /* time, after Lunar terms are initialized        */

            for (;;)
            {
                /* Solar terms done again after Lunar terms are done */
                a1=zcosg*zcosh+zsing*zcosi*zsinh;
                a3=-zsing*zcosh+zcosg*zcosi*zsinh;
                a7=-zcosg*zsinh+zsing*zcosi*zcosh;
                a8=zsing*zsini;
                a9=zsing*zsinh+zcosg*zcosi*zcosh;
                a10=zcosg*zsini;

                // code below may have been expanded

                a2=-zcosg*zsinh+zsing*zcosi*zcosh;
                a4=deep_arg.cosio*(zsing*zsinh+zcosg*zcosi*zcosh)+deep_arg.sinio*(zcosg*zsini);
                a5=-deep_arg.sinio*(-zcosg*zsinh+zsing*zcosi*zcosh)+deep_arg.cosio*(zsing*zsini);
                a6=-deep_arg.sinio*(zsing*zsinh+zcosg*zcosi*zcosh)+deep_arg.cosio*(zcosg*zsini);
                x1=(zcosg*zcosh+zsing*zcosi*zsinh)*deep_arg.cosg+(-zcosg*zsinh+zsing*zcosi*zcosh)*deep_arg.sing;
                x2=(-zsing*zcosh+zcosg*zcosi*zsinh)*deep_arg.cosg+(deep_arg.cosio*(zsing*zsinh+zcosg*zcosi*zcosh)+deep_arg.sinio*(zcosg*zsini))*deep_arg.sing;
                x3=-(zcosg*zcosh+zsing*zcosi*zsinh)*deep_arg.sing+(-zcosg*zsinh+zsing*zcosi*zcosh)*deep_arg.cosg;
                x4=-(-zsing*zcosh+zcosg*zcosi*zsinh)*deep_arg.sing+(deep_arg.cosio*(zsing*zsinh+zcosg*zcosi*zcosh)+deep_arg.sinio*(zcosg*zsini))*deep_arg.cosg;
                x5=(-deep_arg.sinio*(-zcosg*zsinh+zsing*zcosi*zcosh)+deep_arg.cosio*(zsing*zsini))*deep_arg.sing;
                x6=(-deep_arg.sinio*(zsing*zsinh+zcosg*zcosi*zcosh)+deep_arg.cosio*(zcosg*zsini))*deep_arg.sing;
                x7=(-deep_arg.sinio*(-zcosg*zsinh+zsing*zcosi*zcosh)+deep_arg.cosio*(zsing*zsini))*deep_arg.cosg;
                x8=(-deep_arg.sinio*(zsing*zsinh+zcosg*zcosi*zcosh)+deep_arg.cosio*(zcosg*zsini))*deep_arg.cosg;
                z31=12*x1*x1-3*x3*x3;
                z32=24*x1*x2-6*x3*x4;
                z33=12*x2*x2-3*x4*x4;
                z1=3*((zcosg*zcosh+zsing*zcosi*zsinh)*(zcosg*zcosh+zsing*zcosi*zsinh)+(-zcosg*zsinh+zsing*zcosi*zcosh)*(-zcosg*zsinh+zsing*zcosi*zcosh))+(12*x1*x1-3*x3*x3)*deep_arg.eosq;

                // end expanded code

                z2=6*(a1*a3+a2*a4)+z32*deep_arg.eosq;
                z3=3*(a3*a3+a4*a4)+z33*deep_arg.eosq;
                z11=-6*a1*a5+deep_arg.eosq*(-24*x1*x7-6*x3*x5);
                z12=-6*(a1*a6+a3*a5)+deep_arg.eosq*(-24*(x2*x7+x1*x8)-6*(x3*x6+x4*x5));
                z13=-6*a3*a6+deep_arg.eosq*(-24*x2*x8-6*x4*x6);
                z21=6*a2*a5+deep_arg.eosq*(24*x1*x5-6*x3*x7);
                z22=6*(a4*a5+a2*a6)+deep_arg.eosq*(24*(x2*x5+x1*x6)-6*(x4*x7+x3*x8));
                z23=6*a4*a6+deep_arg.eosq*(24*x2*x6-6*x4*x8);
                z1=z1+z1+deep_arg.betao2*z31;
                z2=z2+z2+deep_arg.betao2*z32;
                z3=z3+z3+deep_arg.betao2*z33;
                s3=cc*xnoi;
                s2=-0.5*s3/deep_arg.betao;
                s4=s3*deep_arg.betao;
                s1=-15*eq*s4;
                s5=x1*x3+x2*x4;
                s6=x2*x3+x1*x4;
                s7=x2*x4-x1*x3;
                se=s1*zn*s5;
                si=s2*zn*(z11+z13);
                sl=-zn*s3*(z1+z3-14-6*deep_arg.eosq);
                sgh=s4*zn*(z31+z33-6);
                sh=-zn*s2*(z21+z23);

                if (xqncl<5.2359877E-2)
                    sh=0;

                ee2=2*s1*s6;
                e3=2*s1*s7;
                xi2=2*s2*z12;
                xi3=2*s2*(z13-z11);
                xl2=-2*s3*z2;
                xl3=-2*s3*(z3-z1);
                xl4=-2*s3*(-21-9*deep_arg.eosq)*ze;
                xgh2=2*s4*z32;
                xgh3=2*s4*(z33-z31);
                xgh4=-18*s4*ze;
                xh2=-2*s2*z22;
                xh3=-2*s2*(z23-z21);

                if (LUNAR_TERMS_DONE_FLAG==1)
                    break;


                /* Do lunar terms */
                sse=se;
                ssi=si;
                ssl=sl;
                ssh=sh/deep_arg.sinio;
                ssg=sgh-deep_arg.cosio*ssh;
                se2=ee2;
                si2=xi2;
                sl2=xl2;
                sgh2=xgh2;
                sh2=xh2;
                se3=e3;
                si3=xi3;
                sl3=xl3;
                sgh3=xgh3;
                sh3=xh3;
                sl4=xl4;
                sgh4=xgh4;
                zcosg=zcosgl;
                zsing=zsingl;
                zcosi=zcosil;
                zsini=zsinil;
                zcosh=zcoshl*cosq+zsinhl*sinq;
                zsinh=sinq*zcoshl-cosq*zsinhl;
                zn=znl;
                cc=c1l;
                ze=zel;
                zmo=zmol;
                LUNAR_TERMS_DONE_FLAG=1;

            }

            // ok

            sse=sse+se;
            ssi=ssi+si;
            ssl=ssl+sl;
            ssg=ssg+sgh-deep_arg.cosio/deep_arg.sinio*sh;
            ssh=ssh+sh/deep_arg.sinio;


            /* Geopotential resonance initialization for 12 hour orbits */
            RESONANCE_FLAG=0;
            SYNCHRONOUS_FLAG=0;


            if (!((xnq<0.0052359877) && (xnq>0.0034906585)))
            {
                if ((xnq<0.00826) || (xnq>0.00924))
                    return;

                if (eq<0.5)
                    return;

                RESONANCE_FLAG=1;
                eoc=eq*deep_arg.eosq;
                g201=-0.306-(eq-0.64)*0.440;

                if (eq<=0.65)
                {
                    g211=3.616-13.247*eq+16.290*deep_arg.eosq;
                    g310=-19.302+117.390*eq-228.419*deep_arg.eosq+156.591*eoc;
                    g322=-18.9068+109.7927*eq-214.6334*deep_arg.eosq+146.5816*eoc;
                    g410=-41.122+242.694*eq-471.094*deep_arg.eosq+313.953*eoc;
                    g422=-146.407+841.880*eq-1629.014*deep_arg.eosq+1083.435 * eoc;
                    g520=-532.114+3017.977*eq-5740*deep_arg.eosq+3708.276*eoc;
                }

                else
                {
                    g211=-72.099+331.819*eq-508.738*deep_arg.eosq+266.724*eoc;
                    g310=-346.844+1582.851*eq-2415.925*deep_arg.eosq+1246.113*eoc;
                    g322=-342.585+1554.908*eq-2366.899*deep_arg.eosq+1215.972*eoc;
                    g410=-1052.797+4758.686*eq-7193.992*deep_arg.eosq+3651.957*eoc;
                    g422=-3581.69+16178.11*eq-24462.77*deep_arg.eosq+12422.52*eoc;

                    if (eq<=0.715)
                        g520=1464.74-4664.75*eq+3763.64*deep_arg.eosq;

                    else
                        g520=-5149.66+29936.92*eq-54087.36*deep_arg.eosq+31324.56*eoc;
                }

                if (eq<0.7)
                {
                    g533=-919.2277+4988.61*eq-9064.77*deep_arg.eosq+5542.21*eoc;
                    g521=-822.71072+4568.6173*eq-8491.4146*deep_arg.eosq+5337.524*eoc;
                    g532=-853.666+4690.25*eq-8624.77*deep_arg.eosq+5341.4*eoc;
                }

                else
                {
                    g533=-37995.78+161616.52*eq-229838.2*deep_arg.eosq+109377.94*eoc;
                    g521 =-51752.104+218913.95*eq-309468.16*deep_arg.eosq+146349.42*eoc;
                    g532 =-40023.88+170470.89*eq-242699.48*deep_arg.eosq+115605.82*eoc;
                }

                sini2=deep_arg.sinio*deep_arg.sinio;
                f220=0.75*(1+2*deep_arg.cosio+deep_arg.theta2);
                f221=1.5*sini2;
                f321=1.875*deep_arg.sinio*(1-2*deep_arg.cosio-3*deep_arg.theta2);
                f322=-1.875*deep_arg.sinio*(1+2*deep_arg.cosio-3*deep_arg.theta2);
                f441=35*sini2*f220;
                f442=39.3750*sini2*sini2;
                f522=9.84375*deep_arg.sinio*(sini2*(1-2*deep_arg.cosio-5*deep_arg.theta2)+0.33333333*(-2+4*deep_arg.cosio+6*deep_arg.theta2));
                f523=deep_arg.sinio*(4.92187512*sini2*(-2-4*deep_arg.cosio+10*deep_arg.theta2)+6.56250012*(1+2*deep_arg.cosio-3*deep_arg.theta2));
                f542=29.53125*deep_arg.sinio*(2-8*deep_arg.cosio+deep_arg.theta2*(-12+8*deep_arg.cosio+10*deep_arg.theta2));
                f543=29.53125*deep_arg.sinio*(-2-8*deep_arg.cosio+deep_arg.theta2*(12+8*deep_arg.cosio-10*deep_arg.theta2));
                xno2=xnq*xnq;
                ainv2=aqnv*aqnv;
                temp1=3*xno2*ainv2;
                temp=temp1*root22;
                d2201=temp*f220*g201;
                d2211=temp*f221*g211;
                temp1=temp1*aqnv;
                temp=temp1*root32;
                d3210=temp*f321*g310;
                d3222=temp*f322*g322;
                temp1=temp1*aqnv;
                temp=2*temp1*root44;
                d4410=temp*f441*g410;
                d4422=temp*f442*g422;
                temp1=temp1*aqnv;
                temp=temp1*root52;
                d5220=temp*f522*g520;
                d5232=temp*f523*g532;
                temp=2*temp1*root54;
                d5421=temp*f542*g521;
                d5433=temp*f543*g533;
                xlamo=xmao+tle_xnodeo+tle_xnodeo-thgr-thgr;
                bfact=deep_arg.xmdot+deep_arg.xnodot+deep_arg.xnodot-thdt-thdt;
                bfact=bfact+ssl+ssh+ssh;

            } else {

                RESONANCE_FLAG=1;
                SYNCHRONOUS_FLAG=1;

                /* Synchronous resonance terms initialization */
                g200=1+deep_arg.eosq*(-2.5+0.8125*deep_arg.eosq);
                g310=1+2*deep_arg.eosq;
                g300=1+deep_arg.eosq*(-6+6.60937*deep_arg.eosq);
                f220=0.75*(1+deep_arg.cosio)*(1+deep_arg.cosio);
                f311=0.9375*deep_arg.sinio*deep_arg.sinio*(1+3*deep_arg.cosio)-0.75*(1+deep_arg.cosio);
                f330=1+deep_arg.cosio;
                f330=1.875*f330*f330*f330;
                del1=3*xnq*xnq*aqnv*aqnv;
                del2=2*del1*f220*g200*q22;
                del3=3*del1*f330*g300*q33*aqnv;
                del1=del1*f311*g310*q31*aqnv;
                fasx2=0.13130908;
                fasx4=2.8843198;
                fasx6=0.37448087;
                xlamo=xmao+tle_xnodeo+tle_omegao-thgr;
                bfact=deep_arg.xmdot+xpidot-thdt;
                bfact=bfact+ssl+ssg+ssh;
            }

            xfact=bfact-xnq;

            /* Initialize integrator */
            xli=xlamo;
            xni=xnq;
            atime=0;
            stepp=720;
            stepn=-720;
            step2=259200;

        }


        if (ientry==dpsec)  /* Entrance for deep space secular effects */
        {
            deep_arg.xll=deep_arg.xll+ssl*deep_arg.t;
            deep_arg.omgadf=deep_arg.omgadf+ssg*deep_arg.t;
            deep_arg.xnode=deep_arg.xnode+ssh*deep_arg.t;
            deep_arg.em=tle_eo+sse*deep_arg.t;
            deep_arg.xinc=tle_xincl+ssi*deep_arg.t;

            if (deep_arg.xinc<0)
            {
                deep_arg.xinc=-deep_arg.xinc;
                deep_arg.xnode=deep_arg.xnode+pi;
                deep_arg.omgadf=deep_arg.omgadf-pi;
            }

            if (RESONANCE_FLAG==0)
                return;

            do
            {
                if ((atime==0) || ((deep_arg.t>=0) && (atime<0)) || ((deep_arg.t<0) && (atime>=0)))
                {
                    /* Epoch restart */

                    if (deep_arg.t>=0)
                        delt=stepp;
                    else
                        delt=stepn;

                    atime=0;
                    xni=xnq;

                    xli=xlamo;
                }

                else
                {
                    if (Math.abs(deep_arg.t)>=Math.abs(atime))
                    {
                        if (deep_arg.t>0)
                            delt=stepp;
                        else
                            delt=stepn;
                    }
                }

                do
                {
                    if (Math.abs(deep_arg.t-atime)>=stepp)
                    {
                        DO_LOOP_FLAG=1;
                        EPOCH_RESTART_FLAG=0;
                    }

                    else
                    {
                        ft=deep_arg.t-atime;
                        DO_LOOP_FLAG=0;
                    }

                    if (Math.abs(deep_arg.t)<Math.abs(atime))
                    {
                        if (deep_arg.t>=0)
                            delt=stepn;
                        else
                            delt=stepp;

                        // SetFlag(DO_LOOP_FLAG | EPOCH_RESTART_FLAG);  [UNSURE] or'ed?
                        DO_LOOP_FLAG=1;
                        EPOCH_RESTART_FLAG=1;
                    }

                    /* Dot terms calculated */
                    if (SYNCHRONOUS_FLAG==1)
                    {
                        xndot=del1*Math.sin(xli-fasx2)+del2*Math.sin(2*(xli-fasx4))+del3*Math.sin(3*(xli-fasx6));
                        xnddt=del1*Math.cos(xli-fasx2)+2*del2*Math.cos(2*(xli-fasx4))+3*del3*Math.cos(3*(xli-fasx6));
                    }

                    else
                    {
                        xomi=omegaq+deep_arg.omgdot*atime;
                        x2omi=xomi+xomi;
                        x2li=xli+xli;
                        xndot=d2201*Math.sin(x2omi+xli-g22)+d2211*Math.sin(xli-g22)+d3210*Math.sin(xomi+xli-g32)+d3222*Math.sin(-xomi+xli-g32)+d4410*Math.sin(x2omi+x2li-g44)+d4422*Math.sin(x2li-g44)+d5220*Math.sin(xomi+xli-g52)+d5232*Math.sin(-xomi+xli-g52)+d5421*Math.sin(xomi+x2li-g54)+d5433*Math.sin(-xomi+x2li-g54);
                        xnddt=d2201*Math.cos(x2omi+xli-g22)+d2211*Math.cos(xli-g22)+d3210*Math.cos(xomi+xli-g32)+d3222*Math.cos(-xomi+xli-g32)+d5220*Math.cos(xomi+xli-g52)+d5232*Math.cos(-xomi+xli-g52)+2*(d4410*Math.cos(x2omi+x2li-g44)+d4422*Math.cos(x2li-g44)+d5421*Math.cos(xomi+x2li-g54)+d5433*Math.cos(-xomi+x2li-g54));
                    }

                    xldot=xni+xfact;
                    xnddt=xnddt*xldot;

                    if (DO_LOOP_FLAG==1)
                    {
                        xli=xli+xldot*delt+xndot*step2;
                        xni=xni+xndot*delt+xnddt*step2;
                        atime=atime+delt;
                    }
                } while ((DO_LOOP_FLAG==1) && (EPOCH_RESTART_FLAG==0));

            } while ((DO_LOOP_FLAG==1) && (EPOCH_RESTART_FLAG==1));

            deep_arg.xn=xni+xndot*ft+xnddt*ft*ft*0.5;
            xl=xli+xldot*ft+xndot*ft*ft*0.5;
            temp=-deep_arg.xnode+thgr+deep_arg.t*thdt;

            if (SYNCHRONOUS_FLAG==0)
                deep_arg.xll=xl+temp+temp;
            else
                deep_arg.xll=xl-deep_arg.omgadf+temp;


        }


        if (ientry==dpper)
        {

            /* Entrance for lunar-solar periodics */

            sinis=Math.sin(deep_arg.xinc);
            cosis=Math.cos(deep_arg.xinc);

            if (Math.abs(savtsn-deep_arg.t)>=30)
            {
                savtsn=deep_arg.t;
                zm=zmos+zns*deep_arg.t;
                zf=zm+2*zes*Math.sin(zm);
                sinzf=Math.sin(zf);
                f2=0.5*sinzf*sinzf-0.25;
                f3=-0.5*sinzf*Math.cos(zf);
                ses=se2*f2+se3*f3;
                sis=si2*f2+si3*f3;
                sls=sl2*f2+sl3*f3+sl4*sinzf;
                sghs=sgh2*f2+sgh3*f3+sgh4*sinzf;

                shs=sh2*f2+sh3*f3;
                zm=zmol+znl*deep_arg.t;
                zf=zm+2*zel*Math.sin(zm);
                sinzf=Math.sin(zf);
                f2=0.5*sinzf*sinzf-0.25;
                f3=-0.5*sinzf*Math.cos(zf);
                sel=ee2*f2+e3*f3;
                sil=xi2*f2+xi3*f3;
                sll=xl2*f2+xl3*f3+xl4*sinzf;
                sghl=xgh2*f2+xgh3*f3+xgh4*sinzf;
                sh1=xh2*f2+xh3*f3;
                pe=ses+sel;
                pinc=sis+sil;
                pl=sls+sll;
            }

            pgh=sghs+sghl;
            ph=shs+sh1;
            deep_arg.xinc=deep_arg.xinc+pinc;
            deep_arg.em=deep_arg.em+pe;

            if (xqncl>=0.2)
            {
                /* Apply periodics directly */
                ph=ph/deep_arg.sinio;
                pgh=pgh-deep_arg.cosio*ph;
                deep_arg.omgadf=deep_arg.omgadf+pgh;
                deep_arg.xnode=deep_arg.xnode+ph;
                deep_arg.xll=deep_arg.xll+pl;

            } else {

                /* Apply periodics with Lyddane modification */
                sinok=Math.sin(deep_arg.xnode);
                cosok=Math.cos(deep_arg.xnode);
                alfdp=sinis*sinok;
                betdp=sinis*cosok;
                dalf=ph*cosok+pinc*cosis*sinok;
                dbet=-ph*sinok+pinc*cosis*cosok;
                alfdp=alfdp+dalf;
                betdp=betdp+dbet;
                deep_arg.xnode=FMod2p(deep_arg.xnode);
                xls=deep_arg.xll+deep_arg.omgadf+cosis*deep_arg.xnode;
                dls=pl+pgh-pinc*deep_arg.xnode*sinis;
                xls=xls+dls;
                xnoh=deep_arg.xnode;
                deep_arg.xnode=AcTan(alfdp,betdp);

                /* This is a patch to Lyddane modification */
                /* suggested by Rob Matson. */

                if (Math.abs(xnoh-deep_arg.xnode)>pi)
                {
                    if (deep_arg.xnode<xnoh)
                        deep_arg.xnode+=twopi;
                    else
                        deep_arg.xnode-=twopi;
                }

                deep_arg.xll=deep_arg.xll+pl;
                deep_arg.omgadf=xls-deep_arg.xll-Math.cos(deep_arg.xinc)*deep_arg.xnode;
            }

        }
    }



    double ThetaG(double epoch, deep_arg_t deep_arg)
    {
        /* The function ThetaG calculates the Greenwich Mean Sidereal Time */
        /* for an epoch specified in the format used in the NORAD two-line */
        /* element sets. It has now been adapted for dates beyond the year */
        /* 1999, as described above. The function ThetaG_JD provides the   */
        /* same calculation except that it is based on an input in the     */
        /* form of a Julian Date. */

        /* Reference:  The 1992 Astronomical Almanac, page B6. */

        double year, day, UT, jd, TU, GMST, ThetaG;

        /* Modification to support Y2K */
        /* Valid 1957 through 2056     */

        //day=modf(epoch*1E-3,year)*1E3;  // java doesn't know modf
        day=modf_fract(epoch*1E-3)*1E3;
        year=modf_int(epoch*1E-3);

        if (year<57)
            year+=2000;
        else
            year+=1900;

        //UT=modf(day,day);
        UT=modf_fract(day);
        day=modf_int(day);

        jd=Julian_Date_of_Year(year)+day;
        TU=(jd-2451545.0)/36525;
        GMST=24110.54841+TU*(8640184.812866+TU*(0.093104-TU*6.2E-6));
        GMST=Modulus(GMST+secday*omega_E*UT,secday);
        ThetaG=twopi*GMST/secday;
        deep_arg.ds50=jd-2433281.5+UT;
        ThetaG=FMod2p(6.3003880987*deep_arg.ds50+1.72944494);

        return ThetaG;
    }


    double Modulus(double arg1, double arg2)
    {
        /* Returns arg1 mod arg2 */

        int i;
        double ret_val;

        ret_val=arg1;
        i= (int) (ret_val/arg2);
        ret_val-=i*arg2;

        if (ret_val<0.0)
            ret_val+=arg2;

        return ret_val;
    }

    double Julian_Date_of_Year(double year)
    {
        /* The function Julian_Date_of_Year calculates the Julian Date  */
        /* of Day 0.0 of {year}. This function is used to calculate the */
        /* Julian Date of any date by using Julian_Date_of_Year, DOY,   */
        /* and Fraction_of_Day. */

        /* Astronomical Formulae for Calculators, Jean Meeus, */
        /* pages 23-25. Calculate Julian Date of 0.0 Jan year */

        long A, B, i;
        double jdoy;

        year=year-1;
        i=(long) (year/100);
        A=i;
        i=A/4;
        B=2-A+i;
        i=(long) (365.25*year);
        i+=30.6001*14;
        jdoy=i+1720994.5+B;

        return jdoy;
    }

    double Julian_Date_of_Epoch(double epoch)
    {
        /* The function Julian_Date_of_Epoch returns the Julian Date of     */
        /* an epoch specified in the format used in the NORAD two-line      */
        /* element sets. It has been modified to support dates beyond       */
        /* the year 1999 assuming that two-digit years in the range 00-56   */
        /* correspond to 2000-2056. Until the two-line element set format   */
        /* is changed, it is only valid for dates through 2056 December 31. */

        double year, day;

        /* Modification to support Y2K */
        /* Valid 1957 through 2056     */

        //day=modf(epoch*1E-3, year)*1E3;   // original command

        day=modf_fract(epoch*1E-3)*1E3;
        year=modf_int(epoch*1E-3);

        if (year<57)
            year=year+2000;
        else
            year=year+1900;

        return (Julian_Date_of_Year(year)+day);
    }



    double modf_fract (double dVal)
    {
        /*
         * modf is not available in java
         *
         * the above function does splits up the fractional and integral part
         *
         * Example:    0.1415 = modf(3.1415, 3)
         *              var1         input   var2
         *
         * The modf function outputs the fractional part as a value (var1) but
         * puts the integral in the variable to which a pointer is given (var2).
         *
         * Essentially the command can be rewritten as two java functions.
         *
         * to get the fractional part:
         *        fractpart = dVal - Math.floor(dVal);
         *
         * to get the integral part:
         *        intpart   = Math.floor(dVal);
         *
         *
         */


        return dVal - Math.floor(dVal);
    }

    double modf_int (double dVal)
    {
        return Math.floor(dVal);
    }

    long DayNum(int m, int d, int y)
    {
        /* This function calculates the day number from m/d/y. */

        long dn;
        double mm, yy;

        if (m<3)
        {
            y--;
            m+=12;
        }

        if (y<57)
            y+=100;

        yy=(double)y;
        mm=(double)m;
        dn=(long)(Math.floor(365.25*(yy-80.0))-Math.floor(19.0+yy/100.0)+Math.floor(4.75+yy/400.0)-16.0);
        dn+=d+30*m+(long)Math.floor(0.6*mm-0.3);
        return dn;
    }

    int Decayed(double time)
    {
        /* This function returns a 1 if it appears that the
           satellite pointed to by 'x' has decayed at the
           time of 'time'.  If 'time' is 0.0, then the
           current date/time is used. */

        double satepoch;

        if (time==0.0)
            time=CurrentDaynum();

        satepoch=DayNum(1,0,sat_year)+sat_refepoch;

        if (satepoch+((16.666666-sat_meanmo)/(10.0*Math.abs(sat_drag))) < time)
            return 1;
        else
            return 0;
    }


    int Geostationary()
    {
        /* This function returns a 1 if the satellite pointed
           to by "x" appears to be in a geostationary orbit */

        // found satellites that are moving more than 0.0002 revs per day,
        // updated formula here to increase range of near-non-moving objects

        if (Math.abs(sat_meanmo-1.0027)<0.02)

            return 1;
        else
            return 0;
    }


    int AosHappens()
    {
        /* This function returns a 1 if the satellite pointed to by
           "x" can ever rise above the horizon of the ground station. */

        double lin, sma, apogee;

        if (sat_meanmo==0.0)
            return 0;
        else
        {
            lin=sat_incl;

            if (lin>=90.0)
                lin=180.0-lin;

            sma=331.25*Math.exp(Math.log(1440.0/sat_meanmo)*(2.0/3.0));
            apogee=sma*(1.0+sat_eccn)-xkmper;

            if ((Math.acos(xkmper/(apogee+xkmper))+(lin*deg2rad)) > Math.abs(qth_stnlat*deg2rad))
                return 1;
            else
                return 0;
        }
    }



    void select_ephemeris()
    {
        /* Selects the apropriate ephemeris type to be used */
        /* for predictions according to the data in the TLE */
        /* It also processes values in the tle set so that  */
        /* they are apropriate for the sgp4/sdp4 routines   */

        double ao, xnodp, dd1, dd2, delo, temp, a1, del1, r1;

        /* Preprocess tle set */
        tle_xnodeo*=deg2rad;
        tle_omegao*=deg2rad;
        tle_xmo*=deg2rad;
        tle_xincl*=deg2rad;
        temp=twopi/xmnpda/xmnpda;
        tle_xno=tle_xno*temp*xmnpda;
        tle_xndt2o*=temp;
        tle_xndd6o=tle_xndd6o*temp/xmnpda;
        tle_bstar/=ae;

        /* Period > 225 minutes is deep space */
        dd1=(xke/tle_xno);
        dd2=tothrd;
        a1=Math.pow(dd1,dd2);
        r1=Math.cos(tle_xincl);
        dd1=(1.0-tle_eo*tle_eo);
        temp=ck2*1.5f*(r1*r1*3.0-1.0)/Math.pow(dd1,1.5);    // [UNSURE] is pow(x) the same as sqr(x) ?
        del1=temp/(a1*a1);
        ao=a1*(1.0-del1*(tothrd*.5+del1*(del1*1.654320987654321+1.0)));
        delo=temp/(ao*ao);
        xnodp=tle_xno/(delo+1.0);

        /* Select a deep-space/near-earth ephemeris */

        if (twopi/xnodp/xmnpda>=0.15625)
            DEEP_SPACE_EPHEM_FLAG=1;
        else
            DEEP_SPACE_EPHEM_FLAG=0;
    }


    int Sat_Eclipsed(double depth)
    {
        /* Calculates satellite's eclipse status and depth */

        double sd_sun, sd_earth, delta;

        vector_t Rho = new vector_t();  // create new instance of vector_t
        vector_t earth = new vector_t();  // create new instance of vector_t

        Rho.x = 0;
        Rho.y = 0;
        Rho.z = 0;
        Rho.w = 0;

        earth.x = 0;
        earth.y = 0;
        earth.z = 0;
        earth.w = 0;


        /* Determine partial eclipse */

        //sd_earth=Math.asin(xkmper/pos.w);   // [UNSURE] was: ArcSin
        sd_earth=ArcSin(xkmper/pos_w);

        // Vec_Sub(sol,pos,Rho);

        /* Subtracts vector v2 from v1 to produce v3 */
        Rho.x=solar_vector_x-pos_x;
        Rho.y=solar_vector_y-pos_y;
        Rho.z=solar_vector_z-pos_z;

        //Magnitude(v3);
        Rho.w = Math.sqrt(Math.pow(Rho.x,2)+Math.pow(Rho.y,2)+Math.pow(Rho.z,2));


        sd_sun=ArcSin(sr/Rho.w);

        //Scalar_Multiply(-1,pos,earth);

        /* Multiplies the vector v1 by the scalar k to produce the vector v2 */
        earth.x=-1*pos_x;
        earth.y=-1*pos_y;
        earth.z=-1*pos_z;
        earth.w=Math.abs(-1)*pos_w;



        //delta=Angle(sol,earth);


        /* Calculates the angle between vectors v1 and v2 */
        //Magnitude(v1);
        solar_vector_w = Math.sqrt(Math.pow(solar_vector_x,2)+Math.pow(solar_vector_y,2)+Math.pow(solar_vector_z,2));

        //Magnitude(v2);
        earth.w = Math.sqrt(Math.pow(earth.x,2)+Math.pow(earth.y,2)+Math.pow(earth.z,2));

        /* Returns the dot product of two vectors */
        delta = (solar_vector_x*earth.x+solar_vector_y*earth.y+solar_vector_z*earth.z);


        delta=ArcCos(delta/(solar_vector_w*earth.w));


        depth=sd_earth-sd_sun-delta;


        if (sd_earth<sd_sun)
            return 0;
        else
        if (depth>=0)
            return 1;
        else
            return 0;

    }

    void Vec_Sub(vector_t v1, vector_t v2, vector_t v3)
    {
        /* Subtracts vector v2 from v1 to produce v3 */
        v3.x=v1.x-v2.x;
        v3.y=v1.y-v2.y;
        v3.z=v1.z-v2.z;

        //Magnitude(v3);
        v3.w = Math.sqrt(Math.pow(v3.x,2)+Math.pow(v3.y,2)+Math.pow(v3.z,2));

    }

    void Scalar_Multiply(double k, vector_t v1, vector_t v2)
    {
        /* Multiplies the vector v1 by the scalar k to produce the vector v2 */
        v2.x=k*v1.x;
        v2.y=k*v1.y;
        v2.z=k*v1.z;
        v2.w=Math.abs(k)*v1.w;
    }

    double An2gle(vector_t v1, vector_t v2)
    {
        /* Calculates the angle between vectors v1 and v2 */
        //Magnitude(v1);
        v1.w = Math.sqrt(Math.pow(v1.x,2)+Math.pow(v1.y,2)+Math.pow(v1.z,2));

        //Magnitude(v2);
        v2.w = Math.sqrt(Math.pow(v2.x,2)+Math.pow(v2.y,2)+Math.pow(v2.z,2));
        return(ArcCos(Dot(v1,v2)/(v1.w*v2.w)));


    }

    void Convert_Sat_State()
    {
        /* Converts the satellite's position and velocity  */
        /* vectors from normalized values to km and km/sec */


        //Scale_Vector(xkmper, pos);

        /* Multiplies the vector v1 by the scalar k */
        pos_x*=xkmper;
        pos_y*=xkmper;
        pos_z*=xkmper;
        //Magnitude(v);
        pos_w = Math.sqrt(Math.pow(pos_x,2)+Math.pow(pos_y,2)+Math.pow(pos_z,2));


        //Scale_Vector(xkmper*xmnpda/secday, vel);

        /* Multiplies the vector v1 by the scalar k */
        vel_x*=(xkmper*xmnpda/secday);
        vel_y*=(xkmper*xmnpda/secday);
        vel_z*=(xkmper*xmnpda/secday);
        //Magnitude(v);
        vel_w = Math.sqrt(Math.pow(vel_x,2)+Math.pow(vel_y,2)+Math.pow(vel_z,2));

    }

    void Scale_Vector_empty(double k, vector_t v)
    {
        // taken out because java doesn't have pointers
    }




    @SuppressWarnings("null")
    void SDP4(double tsince)
    {
        /* This function is used to calculate the position and velocity */
        /* of deep-space (period > 225 minutes) satellites. tsince is   */
        /* time since epoch in minutes, tle is a pointer to a tle_t     */
        /* structure with Keplerian orbital elements and pos and vel    */
        /* are vector_t structures returning ECI satellite position and */
        /* velocity. Use Convert_Sat_State() to convert to km and km/s. */

        int i;




        deep_arg_t deep_arg = new deep_arg_t();
        deep_arg.cosio = 0;

        /* Initialization */

        if (SDP4_INITIALIZED_FLAG==0)
        {
            SDP4_INITIALIZED_FLAG=1;

            /* Recover original mean motion (xnodp) and   */
            /* semimajor axis (aodp) from input elements. */

            a1=Math.pow(xke/tle_xno,tothrd);   // [UNSURE] is pow the same as sqr ?
            deep_arg.cosio=Math.cos(tle_xincl);
            deep_arg.theta2=deep_arg.cosio*deep_arg.cosio;
            x3thm1=3*deep_arg.theta2-1;
            deep_arg.eosq=tle_eo*tle_eo;
            deep_arg.betao2=1-deep_arg.eosq;
            deep_arg.betao=Math.sqrt(deep_arg.betao2);
            del1=1.5*ck2*x3thm1/(a1*a1*deep_arg.betao*deep_arg.betao2);
            ao=a1*(1-del1*(0.5*tothrd+del1*(1+134/81*del1)));
            delo=1.5*ck2*x3thm1/(ao*ao*deep_arg.betao*deep_arg.betao2);
            deep_arg.xnodp=tle_xno/(1+delo);
            deep_arg.aodp=ao/(1-delo);

            /* For perigee below 156 km, the values */
            /* of s and qoms2t are altered.         */

            s4=s;

            qoms24=qoms2t;
            perigee=(deep_arg.aodp*(1-tle_eo)-ae)*xkmper;

            if (perigee<156.0)
            {
                if (perigee<=98.0)
                    s4=20.0;
                else
                    s4=perigee-78.0;

                qoms24=Math.pow((120-s4)*ae/xkmper,4);
                s4=s4/xkmper+ae;
            }

            pinvsq=1/(deep_arg.aodp*deep_arg.aodp*deep_arg.betao2*deep_arg.betao2);
            deep_arg.sing=Math.sin(tle_omegao);
            deep_arg.cosg=Math.cos(tle_omegao);
            tsi=1/(deep_arg.aodp-s4);
            eta=deep_arg.aodp*tle_eo*tsi;
            etasq=eta*eta;
            eeta=tle_eo*eta;
            psisq=Math.abs(1-etasq);
            coef=qoms24*Math.pow(tsi,4);
            coef1=coef/Math.pow(psisq,3.5);
            c2=coef1*deep_arg.xnodp*(deep_arg.aodp*(1+1.5*etasq+eeta*(4+etasq))+0.75*ck2*tsi/psisq*x3thm1*(8+3*etasq*(8+etasq)));
            c1=tle_bstar*c2;
            deep_arg.sinio=Math.sin(tle_xincl);
            a3ovk2=-xj3/ck2*Math.pow(ae,3);
            x1mth2=1-deep_arg.theta2;
            c4=2*deep_arg.xnodp*coef1*deep_arg.aodp*deep_arg.betao2*(eta*(2+0.5*etasq)+tle_eo*(0.5+2*etasq)-2*ck2*tsi/(deep_arg.aodp*psisq)*(-3*x3thm1*(1-2*eeta+etasq*(1.5-0.5*eeta))+0.75*x1mth2*(2*etasq-eeta*(1+etasq))*Math.cos(2*tle_omegao)));
            theta4=deep_arg.theta2*deep_arg.theta2;
            temp1=3*ck2*pinvsq*deep_arg.xnodp;
            temp2=temp1*ck2*pinvsq;
            temp3=1.25*ck4*pinvsq*pinvsq*deep_arg.xnodp;
            deep_arg.xmdot=deep_arg.xnodp+0.5*temp1*deep_arg.betao*x3thm1+0.0625*temp2*deep_arg.betao*(13-78*deep_arg.theta2+137*theta4);
            x1m5th=1-5*deep_arg.theta2;
            deep_arg.omgdot=-0.5*temp1*x1m5th+0.0625*temp2*(7-114*deep_arg.theta2+395*theta4)+temp3*(3-36*deep_arg.theta2+49*theta4);
            xhdot1=-temp1*deep_arg.cosio;
            deep_arg.xnodot=xhdot1+(0.5*temp2*(4-19*deep_arg.theta2)+2*temp3*(3-7*deep_arg.theta2))*deep_arg.cosio;
            xnodcf=3.5*deep_arg.betao2*xhdot1*c1;
            t2cof=1.5*c1;
            xlcof=0.125*a3ovk2*deep_arg.sinio*(3+5*deep_arg.cosio)/(1+deep_arg.cosio);
            aycof=0.25*a3ovk2*deep_arg.sinio;
            x7thm1=7*deep_arg.theta2-1;

            /* initialize Deep() */

            Deep(dpinit,deep_arg);
        }

        /* Update for secular gravity and atmospheric drag */
        xmdf=tle_xmo+deep_arg.xmdot*tsince;
        deep_arg.omgadf=tle_omegao+deep_arg.omgdot*tsince;
        xnoddf=tle_xnodeo+deep_arg.xnodot*tsince;
        tsq=tsince*tsince;
        deep_arg.xnode=xnoddf+xnodcf*tsq;
        tempa=1-c1*tsince;
        tempe=tle_bstar*c4*tsince;
        templ=t2cof*tsq;
        deep_arg.xn=deep_arg.xnodp;

        /* Update for deep-space secular effects */
        deep_arg.xll=xmdf;
        deep_arg.t=tsince;

        Deep(dpsec,deep_arg);

        xmdf=deep_arg.xll;
        a=Math.pow(xke/deep_arg.xn,tothrd)*tempa*tempa;
        deep_arg.em=deep_arg.em-tempe;
        xmam=xmdf+deep_arg.xnodp*templ;

        /* Update for deep-space periodic effects */
        deep_arg.xll=xmam;

        Deep(dpper,deep_arg);

        xmam=deep_arg.xll;
        xl=xmam+deep_arg.omgadf+deep_arg.xnode;
        beta=Math.sqrt(1-deep_arg.em*deep_arg.em);
        deep_arg.xn=xke/Math.pow(a,1.5);

        /* Long period periodics */
        axn=deep_arg.em*Math.cos(deep_arg.omgadf);
        temp=1/(a*beta*beta);
        xll=temp*xlcof*axn;
        aynl=temp*aycof;
        xlt=xl+xll;
        ayn=deep_arg.em*Math.sin(deep_arg.omgadf)+aynl;

        /* Solve Kepler's Equation */
        capu=FMod2p(xlt-deep_arg.xnode);
        temp2=capu;
        i=0;

        do
        {
            sinepw=Math.sin(temp2);
            cosepw=Math.cos(temp2);
            temp3=axn*sinepw;
            temp4=ayn*cosepw;
            temp5=axn*cosepw;
            temp6=ayn*sinepw;
            epw=(capu-temp4+temp3-temp2)/(1-temp5-temp6)+temp2;

            if (Math.abs(epw-temp2)<=e6a)
                break;

            temp2=epw;

        } while (i++<10);

        /* Short period preliminary quantities */
        ecose=temp5+temp6;
        esine=temp3-temp4;
        elsq=axn*axn+ayn*ayn;
        temp=1-elsq;
        pl=a*temp;
        r=a*(1-ecose);
        temp1=1/r;
        rdot=xke*Math.sqrt(a)*esine*temp1;
        rfdot=xke*Math.sqrt(pl)*temp1;
        temp2=a*temp1;
        betal=Math.sqrt(temp);
        temp3=1/(1+betal);
        cosu=temp2*(cosepw-axn+ayn*esine*temp3);
        sinu=temp2*(sinepw-ayn-axn*esine*temp3);
        u=AcTan(sinu,cosu);
        sin2u=2*sinu*cosu;
        cos2u=2*cosu*cosu-1;
        temp=1/pl;
        temp1=ck2*temp;
        temp2=temp1*temp;

        /* Update for short periodics */
        rk=r*(1-1.5*temp2*betal*x3thm1)+0.5*temp1*x1mth2*cos2u;
        uk=u-0.25*temp2*x7thm1*sin2u;
        xnodek=deep_arg.xnode+1.5*temp2*deep_arg.cosio*sin2u;
        xinck=deep_arg.xinc+1.5*temp2*deep_arg.cosio*deep_arg.sinio*cos2u;
        rdotk=rdot-deep_arg.xn*temp1*x1mth2*sin2u;
        rfdotk=rfdot+deep_arg.xn*temp1*(x1mth2*cos2u+1.5*x3thm1);

        /* Orientation vectors */

        sinuk=Math.sin(uk);
        cosuk=Math.cos(uk);
        sinik=Math.sin(xinck);
        cosik=Math.cos(xinck);
        sinnok=Math.sin(xnodek);
        cosnok=Math.cos(xnodek);
        xmx=-sinnok*cosik;
        xmy=cosnok*cosik;
        ux=xmx*sinuk+cosnok*cosuk;
        uy=xmy*sinuk+sinnok*cosuk;
        uz=sinik*sinuk;
        vx=xmx*cosuk-cosnok*sinuk;
        vy=xmy*cosuk-sinnok*sinuk;
        vz=sinik*cosuk;

        /* Position and velocity */
        pos_x=rk*ux;
        pos_y=rk*uy;
        pos_z=rk*uz;
        vel_x=rdotk*ux+rfdotk*vx;
        vel_y=rdotk*uy+rfdotk*vy;
        vel_z=rdotk*uz+rfdotk*vz;

        /* Calculations for squint angle begin here... */

        if (calc_squint)
        {
            bx=Math.cos(alat)*Math.cos(alon+deep_arg.omgadf);
            by=Math.cos(alat)*Math.sin(alon+deep_arg.omgadf);
            bz=Math.sin(alat);
            cx=bx;
            cy=by*Math.cos(xinck)-bz*Math.sin(xinck);
            cz=by*Math.sin(xinck)+bz*Math.cos(xinck);
            ax=cx*Math.cos(xnodek)-cy*Math.sin(xnodek);
            ay=cx*Math.sin(xnodek)+cy*Math.cos(xnodek);
            az=cz;
        }

        /* Phase in radians */
        phase=xlt-deep_arg.xnode-deep_arg.omgadf+twopi;

        if (phase<0.0)
            phase+=twopi;

        phase=FMod2p(phase);
    }


    void SGP4(double tsince)
    {
        /* This function is used to calculate the position and velocity */
        /* of near-earth (period < 225 minutes) satellites. tsince is   */
        /* time since epoch in minutes, tle is a pointer to a tle_t     */
        /* structure with Keplerian orbital elements and pos and vel    */
        /* are vector_t structures returning ECI satellite position and */
        /* velocity. Use Convert_Sat_State() to convert to km and km/s. */


        //     Log.i("info","(SGP4) (1) pos_x= " + pos_x);



        int i;

        /* Initialization */

        if (SGP4_INITIALIZED_FLAG==0)
        {
            SGP4_INITIALIZED_FLAG=1;

            /* Recover original mean motion (xnodp) and   */
            /* semimajor axis (aodp) from input elements. */

            a1=Math.pow(xke/tle_xno,tothrd);
            cosio=Math.cos(tle_xincl);
            theta2=cosio*cosio;
            x3thm1=3*theta2-1.0;
            eosq=tle_eo*tle_eo;
            betao2=1.0-eosq;
            betao=Math.sqrt(betao2);
            del1=1.5*ck2*x3thm1/(a1*a1*betao*betao2);
            ao=a1*(1.0-del1*(0.5*tothrd+del1*(1.0+134.0/81.0*del1)));
            delo=1.5*ck2*x3thm1/(ao*ao*betao*betao2);
            xnodp=tle_xno/(1.0+delo);
            aodp=ao/(1.0-delo);

            /* For perigee less than 220 kilometers, the "simple"     */
            /* flag is set and the equations are truncated to linear  */
            /* variation in sqrt a and quadratic variation in mean    */
            /* anomaly.  Also, the c3 term, the delta omega term, and */
            /* the delta m term are dropped.                          */

            if ((aodp*(1-tle_eo)/ae)<(220/xkmper+ae))
                SIMPLE_FLAG=1;

            else
                SIMPLE_FLAG=0;

            /* For perigees below 156 km, the      */
            /* values of s and qoms2t are altered. */

            s4=s;
            qoms24=qoms2t;
            perigee=(aodp*(1-tle_eo)-ae)*xkmper;

            if (perigee<156.0)
            {
                if (perigee<=98.0)
                    s4=20;
                else
                    s4=perigee-78.0;

                qoms24=Math.pow((120-s4)*ae/xkmper,4);
                s4=s4/xkmper+ae;
            }

            pinvsq=1/(aodp*aodp*betao2*betao2);
            tsi=1/(aodp-s4);
            eta=aodp*tle_eo*tsi;
            etasq=eta*eta;
            eeta=tle_eo*eta;
            psisq=Math.abs(1-etasq);
            coef=qoms24*Math.pow(tsi,4);
            coef1=coef/Math.pow(psisq,3.5);
            c2=coef1*xnodp*(aodp*(1+1.5*etasq+eeta*(4+etasq))+0.75*ck2*tsi/psisq*x3thm1*(8+3*etasq*(8+etasq)));
            c1=tle_bstar*c2;
            sinio=Math.sin(tle_xincl);
            a3ovk2=-xj3/ck2*Math.pow(ae,3);
            c3=coef*tsi*a3ovk2*xnodp*ae*sinio/tle_eo;
            x1mth2=1-theta2;

            c4=2*xnodp*coef1*aodp*betao2*(eta*(2+0.5*etasq)+tle_eo*(0.5+2*etasq)-2*ck2*tsi/(aodp*psisq)*(-3*x3thm1*(1-2*eeta+etasq*(1.5-0.5*eeta))+0.75*x1mth2*(2*etasq-eeta*(1+etasq))*Math.cos(2*tle_omegao)));
            c5=2*coef1*aodp*betao2*(1+2.75*(etasq+eeta)+eeta*etasq);

            theta4=theta2*theta2;
            temp1=3*ck2*pinvsq*xnodp;
            temp2=temp1*ck2*pinvsq;
            temp3=1.25*ck4*pinvsq*pinvsq*xnodp;
            xmdot=xnodp+0.5*temp1*betao*x3thm1+0.0625*temp2*betao*(13-78*theta2+137*theta4);
            x1m5th=1-5*theta2;
            omgdot=-0.5*temp1*x1m5th+0.0625*temp2*(7-114*theta2+395*theta4)+temp3*(3-36*theta2+49*theta4);
            xhdot1=-temp1*cosio;
            xnodot=xhdot1+(0.5*temp2*(4-19*theta2)+2*temp3*(3-7*theta2))*cosio;
            omgcof=tle_bstar*c3*Math.cos(tle_omegao);
            xmcof=-tothrd*coef*tle_bstar*ae/eeta;
            xnodcf=3.5*betao2*xhdot1*c1;
            t2cof=1.5*c1;
            xlcof=0.125*a3ovk2*sinio*(3+5*cosio)/(1+cosio);
            aycof=0.25*a3ovk2*sinio;
            delmo=Math.pow(1+eta*Math.cos(tle_xmo),3);
            sinmo=Math.sin(tle_xmo);
            x7thm1=7*theta2-1;

            if (SIMPLE_FLAG==0)
            {
                c1sq=c1*c1;
                d2=4*aodp*tsi*c1sq;
                temp=d2*tsi*c1/3;
                d3=(17*aodp+s4)*temp;
                d4=0.5*temp*aodp*tsi*(221*aodp+31*s4)*c1;
                t3cof=d2+2*c1sq;
                t4cof=0.25*(3*d3+c1*(12*d2+10*c1sq));
                t5cof=0.2*(3*d4+12*c1*d3+6*d2*d2+15*c1sq*(2*d2+c1sq));
            }
        }

        /* Update for secular gravity and atmospheric drag. */
        xmdf=tle_xmo+xmdot*tsince;
        omgadf=tle_omegao+omgdot*tsince;
        xnoddf=tle_xnodeo+xnodot*tsince;
        omega=omgadf;
        xmp=xmdf;
        tsq=tsince*tsince;
        xnode=xnoddf+xnodcf*tsq;
        tempa=1-c1*tsince;
        tempe=tle_bstar*c4*tsince;
        templ=t2cof*tsq;

        if (SIMPLE_FLAG==0)
        {
            delomg=omgcof*tsince;
            delm=xmcof*(Math.pow(1+eta*Math.cos(xmdf),3)-delmo);
            temp=delomg+delm;
            xmp=xmdf+temp;
            omega=omgadf-temp;
            tcube=tsq*tsince;
            tfour=tsince*tcube;
            tempa=tempa-d2*tsq-d3*tcube-d4*tfour;
            tempe=tempe+tle_bstar*c5*(Math.sin(xmp)-sinmo);
            templ=templ+t3cof*tcube+tfour*(t4cof+tsince*t5cof);
        }

        a=aodp*Math.pow(tempa,2);
        e=tle_eo-tempe;
        xl=xmp+omega+xnode+xnodp*templ;
        beta=Math.sqrt(1-e*e);
        xn=xke/Math.pow(a,1.5);

        /* Long period periodics */
        axn=e*Math.cos(omega);
        temp=1/(a*beta*beta);
        xll=temp*xlcof*axn;
        aynl=temp*aycof;
        xlt=xl+xll;
        ayn=e*Math.sin(omega)+aynl;

        /* Solve Kepler's Equation */
        capu=FMod2p(xlt-xnode);
        temp2=capu;
        i=0;

        do
        {
            sinepw=Math.sin(temp2);
            cosepw=Math.cos(temp2);
            temp3=axn*sinepw;
            temp4=ayn*cosepw;
            temp5=axn*cosepw;
            temp6=ayn*sinepw;
            epw=(capu-temp4+temp3-temp2)/(1-temp5-temp6)+temp2;

            if (Math.abs(epw-temp2)<= e6a)
                break;

            temp2=epw;

        } while (i++<10);

        /* Short period preliminary quantities */
        ecose=temp5+temp6;
        esine=temp3-temp4;
        elsq=axn*axn+ayn*ayn;
        temp=1-elsq;
        pl=a*temp;
        r=a*(1-ecose);
        temp1=1/r;
        rdot=xke*Math.sqrt(a)*esine*temp1;
        rfdot=xke*Math.sqrt(pl)*temp1;
        temp2=a*temp1;
        betal=Math.sqrt(temp);
        temp3=1/(1+betal);
        cosu=temp2*(cosepw-axn+ayn*esine*temp3);
        sinu=temp2*(sinepw-ayn-axn*esine*temp3);
        u=AcTan(sinu,cosu);
        sin2u=2*sinu*cosu;
        cos2u=2*cosu*cosu-1;
        temp=1/pl;
        temp1=ck2*temp;
        temp2=temp1*temp;

        /* Update for short periodics */
        rk=r*(1-1.5*temp2*betal*x3thm1)+0.5*temp1*x1mth2*cos2u;
        uk=u-0.25*temp2*x7thm1*sin2u;
        xnodek=xnode+1.5*temp2*cosio*sin2u;
        xinck=tle_xincl+1.5*temp2*cosio*sinio*cos2u;
        rdotk=rdot-xn*temp1*x1mth2*sin2u;
        rfdotk=rfdot+xn*temp1*(x1mth2*cos2u+1.5*x3thm1);

        /* Orientation vectors */
        sinuk=Math.sin(uk);
        cosuk=Math.cos(uk);
        sinik=Math.sin(xinck);
        cosik=Math.cos(xinck);
        sinnok=Math.sin(xnodek);
        cosnok=Math.cos(xnodek);
        xmx=-sinnok*cosik;
        xmy=cosnok*cosik;
        ux=xmx*sinuk+cosnok*cosuk;
        uy=xmy*sinuk+sinnok*cosuk;
        uz=sinik*sinuk;
        vx=xmx*cosuk-cosnok*sinuk;
        vy=xmy*cosuk-sinnok*sinuk;
        vz=sinik*cosuk;

        /* Position and velocity */
        pos_x=rk*ux;
        pos_y=rk*uy;
        pos_z=rk*uz;
        vel_x=rdotk*ux+rfdotk*vx;
        vel_y=rdotk*uy+rfdotk*vy;
        vel_z=rdotk*uz+rfdotk*vz;

        /* Phase in radians */
        phase=xlt-xnode-omgadf+twopi;

        if (phase<0.0)
            phase+=twopi;

        phase=FMod2p(phase);

        //     Log.i("info","(SGP4) (2) pos_x= " + pos_x);

    }





    void PreCalc()
    {
        /* This function copies TLE data from PREDICT's sat structure
           to the SGP4/SDP4's single dimensioned tle structure, and
           prepares the tracking code for the update. */


        /*
         * sat[24] holds an individual satellite data set
         *         is uses the sat class from this class
         *
         * Originally the sat struct also held the 3 TLE lines, but
         * since this java version uses a database those variables are not used
         *
         *
         * select_ephemeris uses the tle_t class
         *
         */


        // tle_t is created as a static variable in the SharedFunctions class

        // sat is populated when we select our satellite from the database




        //  if (sat_db[x].squintflag)
        //  {
        //      calc_squint=true;
        //      alat=deg2rad*sat_db[x].alat;
        //      alon=deg2rad*sat_db[x].alon;
        //  }
        //  else
        calc_squint=false;

        /* Clear all flags */

        //ClearFlag("ALL_FLAGS");

        /* Select ephemeris type.  This function will set or clear the
           DEEP_SPACE_EPHEM_FLAG depending on the TLE parameters of the
           satellite.  It will also pre-process tle members for the
           ephemeris functions SGP4 or SDP4, so this function must
           be called each time a new tle set is used. */

        select_ephemeris();


    }





    double FindAOS()
    {
        /* This function finds and returns the time of AOS (aostime). */

        aostime=0.0;
        //    Log.i("info","(FindAOS) (1) --new FindAOS--");
        //    Log.i("info","(FindAOS) (1) obs_set_x= " + obs_set_x);
        if (AosHappens()==1 && Geostationary()==0 && Decayed(daynum)==0)
        {

            Calc();
            // sat_ele successfully set by calc

            /* Get the satellite in range */

            if (sat_ele < -1.0)
            {
                //           Log.i("info","(FindAOS) (2) sat_ele < -1.0 ");
            } else {
                //           Log.i("info","(FindAOS) (2) sat_ele >= -1.0 ");
            }

            while (sat_ele<-1.0)
            {

                daynum-=0.00035*(sat_ele*((sat_alt/8400.0)+0.46)-2.0);


                // sat_ele, obs_set_x are still okay here
                //                Log.i("info","(FindAOS) (bc) sat_ele= " + sat_ele);
                Calc();
                //              Log.i("info","(FindAOS) (ac) sat_ele= " + sat_ele);
                // sat_ele, obs_set_x are now NaN



            }

            /* Find AOS */

            // daynum should now be set to a real time (e.g. 11729.32)
            // Log.i("info","(FindAOS) (1) daynum= " + daynum);
            // Log.i("info","(FindAOS) (1) sat_ele= " + sat_ele);   // not set ??
            // Log.i("info","(FindAOS) (1) sat_alt " + sat_alt);    // not set ??


            //       Log.i("info","(FindAOS) (3) --calculating aos time, entering loop 2-- ");


            while (aostime==0.0)
            {
                //      Log.i("info","(FindAOS) (4a) aostime = " + aostime);
                //    Log.i("info","(FindAOS) (4b) sat_ele = " + sat_ele);
                //      Log.i("info","(FindAOS) (4c) daynum = " + daynum);

                if (Math.abs(sat_ele)<0.03)
                {
                    //                    Log.i("info","(FindAOS) (5a) setting aostime todaynum");

                    aostime=daynum;
                }
                else
                {
                    //                          Log.i("info","(FindAOS) (5b) do another calc");

                    daynum-=sat_ele*Math.sqrt(sat_alt)/530000.0;
                    Calc();
                }

                //            Log.i("info","(FindAOS) (6a) aostime = " + aostime);
                //            Log.i("info","(FindAOS) (6b) sat_ele = " + sat_ele);
                //            Log.i("info","(FindAOS) (6c) daynum = " + daynum);



            }

        }

        return aostime;
    }


    double FindLOS()
    {
        lostime=0.0;

        if (Geostationary()==0 && AosHappens()==1 && Decayed(daynum)==0)
        {
            Calc();

            do
            {
                daynum+=sat_ele*Math.sqrt(sat_alt)/502500.0;
                Calc();

                if (Math.abs(sat_ele) < 0.03)
                    lostime=daynum;

            } while (lostime==0.0);
        }

        return lostime;
    }

    double FindLOS2()
    {
        /* This function steps through the pass to find LOS.
           FindLOS() is called to "fine tune" and return the result. */

        do
        {
            daynum+=Math.cos((sat_ele-1.0)*deg2rad)*Math.sqrt(sat_alt)/25000.0;
            Calc();

        } while (sat_ele>=0.0);

        return(FindLOS());
    }

    double NextAOS()
    {
        /* This function finds and returns the time of the next
           AOS for a satellite that is currently in range. */

        aostime=0.0;

        if (AosHappens()==1 && Geostationary()==0 && Decayed(daynum)==0)
            daynum=FindLOS2()+0.014;  /* Move to LOS + 20 minutes */

        return (FindAOS());
    }





    void Calc()
    {
        /* This is the stuff we need to do repetitively while tracking. */



        /* Zero vector for initializations */
        //vector_t zero_vector = new vector_t();  // create new instance of vector_t

        /* Satellite position and velocity vectors */

        //       SharedFunctions.vector_t vel = new SharedFunctions.vector_t();  // create new instance of vector_t
        //vector_t vel=zero_vector;

        //       SharedFunctions.vector_t pos = new SharedFunctions.vector_t();  // create new instance of vector_t
        //vector_t pos=zero_vector;

        /* Satellite Az, El, Range, Range rate */
        //       SharedFunctions.vector_t obs_set = new SharedFunctions.vector_t();  // create new instance of vector_t
        //vector_t obs_set;

        /* Solar ECI position vector  */
        //     SharedFunctions.vector_t solar_vector = new SharedFunctions.vector_t();  // create new instance of vector_t
        //vector_t solar_vector=zero_vector;

        /* Solar observed azi and ele vector  */
        //      SharedFunctions.vector_t solar_set = new SharedFunctions.vector_t();  // create new instance of vector_t
        //vector_t solar_set;

        /* Satellite's predicted geodetic position */
        //     SharedFunctions.geodetic_t sat_geodetic = new SharedFunctions.geodetic_t();  // create new instance of vector_t
        //geodetic_t sat_geodetic;

        jul_utc=daynum+2444238.5;


        /* Convert satellite's epoch time to Julian  */
        /* and calculate time since epoch in minutes */

        jul_epoch=Julian_Date_of_Epoch(tle_epoch);
        tsince=(jul_utc-jul_epoch)*xmnpda;
        age=jul_utc-jul_epoch;


        /* Copy the ephemeris type in use to ephem string. */

        if (DEEP_SPACE_EPHEM_FLAG==1)
            ephem="SDP4";
        else
            ephem="SGP4";

        /* Call NORAD routines according to deep-space flag. */

        //    Log.i("info","(Calc) (1) pos_x = " + pos_x);


        if (DEEP_SPACE_EPHEM_FLAG==1)
            SDP4(tsince);
        else
            SGP4(tsince);

        //    Log.i("info","(Calc) (2) pos_x = " + pos_x);


        /* Scale position and velocity vectors to km and km/sec */

        Convert_Sat_State();



        /* Calculate velocity of satellite */

        //Magnitude(vel);
        vel_w = Math.sqrt(Math.pow(vel_x,2)+Math.pow(vel_y,2)+Math.pow(vel_z,2));

        sat_vel=vel_w;

        //  SharedFunctions.geodetic_t obs_geodetic = new geodetic_t();  // create new instance of vector_t


        /** All angles in rads. Distance in km. Velocity in km/s **/
        /* Calculate satellite Azi, Ele, Range and Range-rate */





        //  Log.i("info","(Calc) (1) obs_set.y= " + obs_set.y);

        //Calculate_Obs(jul_utc, pos, vel, obs_geodetic, obs_set);


        Calculate_Obs(jul_utc);


        //  Log.i("info","(Calc) (2) obs_set.y= " + obs_set.y);





        /* Calculate satellite Lat North, Lon East and Alt. */

        Calculate_LatLonAlt(jul_utc);



        /* Calculate squint angle */

        if (calc_squint)
            squint=(Math.acos(-(ax*rx+ay*ry+az*rz)/obs_set_z))/deg2rad;

        /* Calculate solar position and satellite eclipse depth. */
        /* Also set or clear the satellite eclipsed flag accordingly. */


        Calculate_Solar_Position(jul_utc);



        //Calculate_Obs(jul_utc, solar_vector, zero_vector, obs_geodetic, solar_set);
        Calculate_Obs_2(jul_utc);

        if (Sat_Eclipsed(eclipse_depth)==1)
            SAT_ECLIPSED_FLAG=1;
        else
            SAT_ECLIPSED_FLAG=0;


        if (SAT_ECLIPSED_FLAG==1)
            sat_sun_status=0;  /* Eclipse */
        else
            sat_sun_status=1; /* In sunlight */



        /* Convert satellite and solar data */
        sat_azi=Degrees(obs_set_x);


        sat_ele=Degrees(obs_set_y);


        sat_range=obs_set_z;
        sat_range_rate=obs_set_w;
        sat_lat=Degrees(sat_geodetic_lat);
        sat_lon=Degrees(sat_geodetic_lon);
        sat_alt=sat_geodetic_alt;




        fk=12756.33*Math.acos(xkmper/(xkmper+sat_alt));
        fm=fk/1.609344;

        rv=(long)Math.floor((tle_xno*xmnpda/twopi+age*tle_bstar*ae)*age+tle_xmo/twopi)+tle_revnum;

        sun_azi=Degrees(solar_set_x);
        sun_ele=Degrees(solar_set_y);

        irk=(long)Math.rint(sat_range);

        isplat=(int)Math.rint(sat_lat);
        isplong=(int)Math.rint(360.0-sat_lon);
        iaz=(int)Math.rint(sat_azi);
        iel=(int)Math.rint(sat_ele);
        ma256=(int)Math.rint(256.0*(phase/twopi));



        if (sat_sun_status==1)
        {
            if (sun_ele<=-12.0 && Math.rint(sat_ele)>=0.0)
                findsun="+";
            else
                findsun="*";
        }
        else
            findsun=" ";



    }

    double ArcSin(double arg)
    {
        /* Returns the arcsine of the argument */

        if (Math.abs(arg)>=1.0)
            return(Sign(arg)*pio2);
        else

            return(Math.atan(arg/Math.sqrt(1.0-arg*arg)));
    }

    int Sign(double arg)
    {
        /* Returns sign of a double */

        if (arg>0)
            return 1;

        else if (arg<0)
            return -1;

        else
            return 0;
    }

    double ArcCos(double arg)
    {
        /* Returns arccosine of argument */
        return(pio2-ArcSin(arg));
    }


    void FindMoon(double daynum)
    {

           /* This function determines the position of the moon, including
           the azimuth and elevation headings, relative to the latitude
           and longitude of the tracking station.  This code was derived
           from a Javascript implementation of the Meeus method for
           determining the exact position of the Moon found at:
           http://www.geocities.com/s_perona/ingles/poslun.htm. */

        double  jd, ss, t, t1, t2, t3, d, ff, l1, m, m1, ex, om, l,
                b, w1, w2, bt, p, lm, h, ra, dec, z, ob, n, el,
                az, teg, th, mm, dv;

        jd=daynum+2444238.5;

        t=(jd-2415020.0)/36525.0;
        t2=t*t;
        t3=t2*t;
        l1=270.434164+481267.8831*t-0.001133*t2+0.0000019*t3;
        m=358.475833+35999.0498*t-0.00015*t2-0.0000033*t3;
        m1=296.104608+477198.8491*t+0.009192*t2+0.0000144*t3;
        d=350.737486+445267.1142*t-0.001436*t2+0.0000019*t3;
        ff=11.250889+483202.0251*t-0.003211*t2-0.0000003*t3;
        om=259.183275-1934.142*t+0.002078*t2+0.0000022*t3;
        om=om*deg2rad;

        /* Additive terms */

        l1=l1+0.000233*Math.sin((51.2+20.2*t)*deg2rad);
        ss=0.003964*Math.sin((346.56+132.87*t-0.0091731*t2)*deg2rad);
        l1=l1+ss+0.001964*Math.sin(om);
        m=m-0.001778*Math.sin((51.2+20.2*t)*deg2rad);
        m1=m1+0.000817*Math.sin((51.2+20.2*t)*deg2rad);
        m1=m1+ss+0.002541*Math.sin(om);
        d=d+0.002011*Math.sin((51.2+20.2*t)*deg2rad);
        d=d+ss+0.001964*Math.sin(om);
        ff=ff+ss-0.024691*Math.sin(om);
        ff=ff-0.004328*Math.sin(om+(275.05-2.3*t)*deg2rad);
        ex=1.0-0.002495*t-0.00000752*t2;
        om=om*deg2rad;

        l1=PrimeAngle(l1);
        m=PrimeAngle(m);
        m1=PrimeAngle(m1);
        d=PrimeAngle(d);
        ff=PrimeAngle(ff);
        om=PrimeAngle(om);

        m=m*deg2rad;
        m1=m1*deg2rad;
        d=d*deg2rad;
        ff=ff*deg2rad;

        /* Ecliptic Longitude */

        l=l1+6.28875*Math.sin(m1)+1.274018*Math.sin(2.0*d-m1)+0.658309*Math.sin(2.0*d);
        l=l+0.213616*Math.sin(2.0*m1)-ex*0.185596*Math.sin(m)-0.114336*Math.sin(2.0*ff);
        l=l+0.058793*Math.sin(2.0*d-2.0*m1)+ex*0.057212*Math.sin(2.0*d-m-m1)+0.05332*Math.sin(2.0*d+m1);
        l=l+ex*0.045874*Math.sin(2.0*d-m)+ex*0.041024*Math.sin(m1-m)-0.034718*Math.sin(d);
        l=l-ex*0.030465*Math.sin(m+m1)+0.015326*Math.sin(2.0*d-2.0*ff)-0.012528*Math.sin(2.0*ff+m1);

        l=l-0.01098*Math.sin(2.0*ff-m1)+0.010674*Math.sin(4.0*d-m1)+0.010034*Math.sin(3.0*m1);
        l=l+0.008548*Math.sin(4.0*d-2.0*m1)-ex*0.00791*Math.sin(m-m1+2.0*d)-ex*0.006783*Math.sin(2.0*d+m);

        l=l+0.005162*Math.sin(m1-d)+ex*0.005*Math.sin(m+d)+ex*0.004049*Math.sin(m1-m+2.0*d);
        l=l+0.003996*Math.sin(2.0*m1+2.0*d)+0.003862*Math.sin(4.0*d)+0.003665*Math.sin(2.0*d-3.0*m1);

        l=l+ex*0.002695*Math.sin(2.0*m1-m)+0.002602*Math.sin(m1-2.0*ff-2.0*d)+ex*0.002396*Math.sin(2.0*d-m-2.0*m1);

        l=l-0.002349*Math.sin(m1+d)+ex*ex*0.002249*Math.sin(2.0*d-2.0*m)-ex*0.002125*Math.sin(2.0*m1+m);

        l=l-ex*ex*0.002079*Math.sin(2.0*m)+ex*ex*0.002059*Math.sin(2.0*d-m1-2.0*m)-0.001773*Math.sin(m1+2.0*d-2.0*ff);

        l=l+ex*0.00122*Math.sin(4.0*d-m-m1)-0.00111*Math.sin(2.0*m1+2.0*ff)+0.000892*Math.sin(m1-3.0*d);

        l=l-ex*0.000811*Math.sin(m+m1+2.0*d)+ex*0.000761*Math.sin(4.0*d-m-2.0*m1)+ex*ex*.000717*Math.sin(m1-2.0*m);

        l=l+ex*ex*0.000704*Math.sin(m1-2.0*m-2.0*d)+ex*0.000693*Math.sin(m-2.0*m1+2.0*d)+ex*0.000598*Math.sin(2.0*d-m-2.0*ff)+0.00055*Math.sin(m1+4.0*d);

        l=l+0.000538*Math.sin(4.0*m1)+ex*0.000521*Math.sin(4.0*d-m)+0.000486*Math.sin(2.0*m1-d);

        l=l-0.001595*Math.sin(2.0*ff+2.0*d);

        /* Ecliptic latitude */

        b=5.128189*Math.sin(ff)+0.280606*Math.sin(m1+ff)+0.277693*Math.sin(m1-ff)+0.173238*Math.sin(2.0*d-ff);
        b=b+0.055413*Math.sin(2.0*d+ff-m1)+0.046272*Math.sin(2.0*d-ff-m1)+0.032573*Math.sin(2.0*d+ff);

        b=b+0.017198*Math.sin(2.0*m1+ff)+9.266999e-03*Math.sin(2.0*d+m1-ff)+0.008823*Math.sin(2.0*m1-ff);
        b=b+ex*0.008247*Math.sin(2.0*d-m-ff)+0.004323*Math.sin(2.0*d-ff-2.0*m1)+0.0042*Math.sin(2.0*d+ff+m1);

        b=b+ex*0.003372*Math.sin(ff-m-2.0*d)+ex*0.002472*Math.sin(2.0*d+ff-m-m1)+ex*0.002222*Math.sin(2.0*d+ff-m);

        b=b+0.002072*Math.sin(2.0*d-ff-m-m1)+ex*0.001877*Math.sin(ff-m+m1)+0.001828*Math.sin(4.0*d-ff-m1);

        b=b-ex*0.001803*Math.sin(ff+m)-0.00175*Math.sin(3.0*ff)+ex*0.00157*Math.sin(m1-m-ff)-0.001487*Math.sin(ff+d)-ex*0.001481*Math.sin(ff+m+m1)+ex*0.001417*Math.sin(ff-m-m1)+ex*0.00135*Math.sin(ff-m)+0.00133*Math.sin(ff-d);

        b=b+0.001106*Math.sin(ff+3.0*m1)+0.00102*Math.sin(4.0*d-ff)+0.000833*Math.sin(ff+4.0*d-m1);

        b=b+0.000781*Math.sin(m1-3.0*ff)+0.00067*Math.sin(ff+4.0*d-2.0*m1)+0.000606*Math.sin(2.0*d-3.0*ff);

        b=b+0.000597*Math.sin(2.0*d+2.0*m1-ff)+ex*0.000492*Math.sin(2.0*d+m1-m-ff)+0.00045*Math.sin(2.0*m1-ff-2.0*d);

        b=b+0.000439*Math.sin(3.0*m1-ff)+0.000423*Math.sin(ff+2.0*d+2.0*m1)+0.000422*Math.sin(2.0*d-ff-3.0*m1);

        b=b-ex*0.000367*Math.sin(m+ff+2.0*d-m1)-ex*0.000353*Math.sin(m+ff+2.0*d)+0.000331*Math.sin(ff+4.0*d);

        b=b+ex*0.000317*Math.sin(2.0*d+ff-m+m1)+ex*ex*0.000306*Math.sin(2.0*d-2.0*m-ff)-0.000283*Math.sin(m1+3.0*ff);

        w1=0.0004664*Math.cos(om*deg2rad);
        w2=0.0000754*Math.cos((om+275.05-2.3*t)*deg2rad);
        bt=b*(1.0-w1-w2);

        /* Parallax calculations */

        p=0.950724+0.051818*Math.cos(m1)+0.009531*Math.cos(2.0*d-m1)+0.007843*Math.cos(2.0*d)+0.002824*Math.cos(2.0*m1)+0.000857*Math.cos(2.0*d+m1)+ex*0.000533*Math.cos(2.0*d-m)+ex*0.000401*Math.cos(2.0*d-m-m1);

        p=p+0.000173*Math.cos(3.0*m1)+0.000167*Math.cos(4.0*d-m1)-ex*0.000111*Math.cos(m)+0.000103*Math.cos(4.0*d-2.0*m1)-0.000084*Math.cos(2.0*m1-2.0*d)-ex*0.000083*Math.cos(2.0*d+m)+0.000079*Math.cos(2.0*d+2.0*m1);

        p=p+0.000072*Math.cos(4.0*d)+ex*0.000064*Math.cos(2.0*d-m+m1)-ex*0.000063*Math.cos(2.0*d+m-m1);

        p=p+ex*0.000041*Math.cos(m+d)+ex*0.000035*Math.cos(2.0*m1-m)-0.000033*Math.cos(3.0*m1-2.0*d);

        p=p-0.00003*Math.cos(m1+d)-0.000029*Math.cos(2.0*ff-2.0*d)-ex*0.000029*Math.cos(2.0*m1+m);

        p=p+ex*ex*0.000026*Math.cos(2.0*d-2.0*m)-0.000023*Math.cos(2.0*ff-2.0*d+m1)+ex*0.000019*Math.cos(4.0*d-m-m1);

        b=bt*deg2rad;
        lm=l*deg2rad;
        moon_dx=3.0/(pi*p);

        /* Semi-diameter calculation */
        /* sem=10800.0*asin(0.272488*p*deg2rad)/pi; */

        /* Convert ecliptic coordinates to equatorial coordinates */

        z=(jd-2415020.5)/365.2422;
        ob=23.452294-(0.46845*z+5.9e-07*z*z)/3600.0;
        ob=ob*deg2rad;
        dec=Math.asin(Math.sin(b)*Math.cos(ob)+Math.cos(b)*Math.sin(ob)*Math.sin(lm));
        ra=Math.acos(Math.cos(b)*Math.cos(lm)/Math.cos(dec));

        if (lm>pi)
            ra=twopi-ra;

        /* ra = right ascension */
        /* dec = declination */






        n=SharedFunctions.qth_stnlat*deg2rad;    /* North latitude of tracking station */
        t=(jd-2451545.0)/36525.0;
        teg=280.46061837+360.98564736629*(jd-2451545.0)+(0.000387933*t-t*t/38710000.0)*t;

        while (teg>360.0)
            teg-=360.0;

        th=FixAngle((teg-SharedFunctions.qth_stnlon)*deg2rad);
        h=th-ra;

        az=Math.atan2(Math.sin(h),Math.cos(h)*Math.sin(n)-Math.tan(dec)*Math.cos(n))+pi;
        el=Math.asin(Math.sin(n)*Math.sin(dec)+Math.cos(n)*Math.cos(dec)*Math.cos(h));

        moon_az=az/deg2rad;
        moon_el=el/deg2rad;

        /* Radial velocity approximation.  This code was derived
           from "Amateur Radio Software", by John Morris, GM4ANB,
           published by the RSGB in 1985. */

        mm=FixAngle(1.319238+daynum*0.228027135);  /* mean moon position */
        t2=0.10976;
        t1=mm+t2*Math.sin(mm);
        dv=0.01255*moon_dx*moon_dx*Math.sin(t1)*(1.0+t2*Math.cos(mm));
        dv=dv*4449.0;
        t1=6378.0;
        t2=384401.0;
        t3=t1*t2*(Math.cos(dec)*Math.cos(n)*Math.sin(h));
        t3=t3/Math.sqrt(t2*t2-t2*t1*Math.sin(el));
        moon_dv=dv+t3*0.0753125;

        moon_dec=dec/deg2rad;
        moon_ra=ra/deg2rad;
        moon_gha=teg-moon_ra;

        if (moon_gha<0.0)
            moon_gha+=360.0;

    }

    void FindSun(double daynum)
    {
        /* This function finds the position of the Sun */

        vector_t zero_vector = new vector_t();  // create new instance of vector_t

        zero_vector.x=0;
        zero_vector.y=0;
        zero_vector.z=0;
        zero_vector.w=0;


        vector_t solar_vector = new vector_t();  // create new instance of vector_t

        solar_vector.x=0;
        solar_vector.y=0;
        solar_vector.z=0;
        solar_vector.w=0;


        /* Solar lat, long, alt vector */
        geodetic_t solar_latlonalt = new geodetic_t();  // create new instance of vector_t

        jul_utc=daynum+2444238.5;

        Calculate_Solar_Position(jul_utc);

        Calculate_Obs_2(jul_utc);

        sun_azi=Degrees(SharedFunctions.solar_set_x);
        sun_ele=Degrees(SharedFunctions.solar_set_y);
        sun_range=1.0+((SharedFunctions.solar_set_z-AU)/AU);
        sun_range_rate=1000.0*SharedFunctions.solar_set_w;

        Calculate_LatLonAlt2(jul_utc, solar_latlonalt);

        sun_lat=Degrees(solar_latlonalt.lat);
        sun_lon=360.0-Degrees(solar_latlonalt.lon);

        Calculate_RADec(jul_utc, solar_vector, zero_vector);

        sun_ra=Degrees(SharedFunctions.obs_set_x);
        sun_dec=Degrees(SharedFunctions.obs_set_y);

    }

    // functions to calculate the current phase of the moon
    public static double moonphase()
    {

        int y, m, d;
        int h;

        // get current local date and time variables
        Calendar cal = Calendar.getInstance();

        y  = cal.get(Calendar.YEAR);
        m  = cal.get(Calendar.MONTH) + 1;
        d  = cal.get(Calendar.DATE);
        h  = cal.get(Calendar.HOUR_OF_DAY);

        double p;
        p = moon_phase(y, m, d, h);

        //System.out.printf(y + "  " + m + "  " + "" + d + "  " + h + "  " + Math.floor(p*1000+0.5)/10);

        return Math.floor(p*1000+0.5)/10;
    }


    void JulianToDate(double jd)
    {
        long jdi, b;
        long c,d,e,g,g1;

        jd += 0.5;
        jdi = (long) jd;
        if (jdi > 2299160) {
            long a = (long) ((jdi - 1867216.25)/36524.25);
            b = jdi + 1 + a - a/4;
        }
        else b = jdi;

        c = b + 1524;
        d = (long) ((c - 122.1)/365.25);
        e = (long) (365.25 * d);
        g = (long) ((c - e)/30.6001);
        g1 = (long) (30.6001 * g);
        day = (int) (c - e - g1);
        m_hour = (jd - jdi) * 24.0;
        if (g <= 13) m_month = (int) (g - 1);
        else m_month = (int) (g - 13);
        if (m_month > 2) m_year = (int) (d - 4716);
        else m_year = (int) (d - 4715);
    }

    static double Julian(int year,int month,double day)
    {
	    /*
	      Returns the number of julian days for the specified day.
	      */

        int a,b,c,e;
        b=0;
        if (month < 3) {
            year--;
            month += 12;
        }
        if (year > 1582 || (year == 1582 && month>10) ||
                (year == 1582 && month==10 && day > 15)) {
            a=year/100;
            b=2-a+a/4;
        }
        c = (int) (365.25*year);
        e = (int) (30.6001*(month+1));
        return b+c+e+day+1720994.5;
    }

    static double sun_position(double j)
    {
        double n,x,e,l,dl,v;

        int i;

        n=360/365.2422*j;
        i=(int) (n/360);
        n=n-i*360.0;
        x=n-3.762863;
        if (x<0) x += 360;
        x *= RAD;
        e=x;
        do {
            dl=e-.016718*Math.sin(e)-x;
            e=e-dl/(1-.016718*Math.cos(e));
        } while (Math.abs(dl)>=SMALL_FLOAT);
        v=360/PI*Math.atan(1.01686011182*Math.tan(e/2));
        l=v+282.596403;
        i=(int) (l/360);
        l=l-i*360.0;
        return l;
    }

    static double moon_position(double j, double ls)
    {

        double ms,l,mm,n,ev,sms,ae,ec;

        int i;

        /* ls = sun_position(j) */
        ms = 0.985647332099*j - 3.762863;
        if (ms < 0) ms += 360.0;
        l = 13.176396*j + 64.975464;
        i = (int) (l/360);
        l = l - i*360.0;
        if (l < 0) l += 360.0;
        mm = l-0.1114041*j-349.383063;
        i = (int) (mm/360);
        mm -= i*360.0;
        n = 151.950429 - 0.0529539*j;
        i = (int) (n/360);
        n -= i*360.0;
        ev = 1.2739*Math.sin((2*(l-ls)-mm)*RAD);
        sms = Math.sin(ms*RAD);
        ae = 0.1858*sms;
        mm += ev-ae- 0.37*sms;
        ec = 6.2886*Math.sin(mm*RAD);
        l += ev+ec-ae+ 0.214*Math.sin(2*mm*RAD);
        l= 0.6583*Math.sin(2*(l-ls)*RAD)+l;
        return l;
    }

    static double moon_phase(int year,int month,int day, double hour)
    {
	    /*
	      Calculates more accurately than Moon_phase , the phase of the moon at
	      the given epoch.
	      returns the moon phase as a real number (0-1)
	      */

        double j= Julian(year,month,(double)day+hour/24.0)-2444238.5;
        double ls = sun_position(j);
        double lm = moon_position(j, ls);

        double t = lm - ls;
        if (t < 0) t += 360;

        return (1.0 - Math.cos((lm - ls)*RAD))/2;
    }


}
