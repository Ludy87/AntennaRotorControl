package com.example.antennarotorcontrol;
/*
 * Function to process simple two line TLE into array
 */


// import android.app.Activity;
// import android.content.Intent;
// import android.os.Bundle;
// import android.util.Log;
// import android.view.View;
// import android.view.WindowManager;
// import android.widget.Button;

// import android.widget.TextView;

public class TleManualImport {


    public String[] processTLE(String TleData){


		/*

		initialSatValues.put("satname","ISS ZARYA");
		    initialSatValues.put("linenr1","1");
		    initialSatValues.put("satnr1","25544");
		    initialSatValues.put("class","U");
		    initialSatValues.put("launchyr","98");
		    initialSatValues.put("launchnr","067");
		    initialSatValues.put("launchpc","A");
		    initialSatValues.put("epochyr","13");
		    initialSatValues.put("epochday","122.90694444");
		    initialSatValues.put("ftdmm","-0.00013045");
		    initialSatValues.put("stdmm","0.0");
		    initialSatValues.put("drag","-0.00022198");
		    initialSatValues.put("eph","0");
		    initialSatValues.put("ele","734");
		    initialSatValues.put("chksum1","4");
		    initialSatValues.put("linenr2","2");
		    initialSatValues.put("satnr2","25544");
		    initialSatValues.put("incl","51.6485");
		    initialSatValues.put("ra","332.9137");
		    initialSatValues.put("ecc","0.0007705");
		    initialSatValues.put("peri","230.2991");
		    initialSatValues.put("ma","320.0573");
		    initialSatValues.put("mm","15.517388");
		    initialSatValues.put("revnr","628276");
		    initialSatValues.put("chksum2","7");
		    initialSatValues.put("notes","ISS Notes");
		    initialSatValues.put("active","1");
		 */

        String sat_satname=""; // Line 750
        String sat_linenr1="1";
        String sat_satnr1=""; // Line 855
        String sat_class="U";
        String sat_launchyr="";  // Line 678
        String sat_launchnr=""; // Line 679
        String sat_launchpc=""; // Line 680
        String sat_epochyr=""; // Line 598
        String sat_epochday=""; // Line 536 + 579
        String sat_ftdmm=""; // Line 481
        String sat_stdmm=""; // Line 395
        String sat_drag=""; // Line 226
        String sat_eph="0";
        String sat_ele=""; // Line 312
        String sat_chksum1=""; // Line 313 but is never used
        String sat_linenr2="2";
        String sat_satnr2=""; // Line 856
        String sat_incl=""; // Line 937
        String sat_ra=""; // Line 1017
        String sat_ecc=""; // Line 1053
        String sat_peri=""; // Line 1135
        String sat_ma=""; // Line 1219
        String sat_mm=""; // Line 1301
        String sat_revnr=""; // Line 1402
        String sat_chksum2=""; // Line  but is never used
        String sat_notes="Notes";
        String sat_active="1";


        // TleData = "DNEPR OBJECT AE\n" +
        //     		"1 39444U 13066AE 13356.63932284 .00003516 00000-0 48553-3 0 179\n" +
        //     		"2 39444 97.7977 68.2567 0064856 95.8356 265.0220 14.77291204 3390\n" +

        String clipboard_raw = TleData;

        // replace all instances of \n and \r with a single space character
        clipboard_raw = clipboard_raw.replaceAll("\n", " ");
        clipboard_raw = clipboard_raw.replaceAll("\r", " ");

        // add one final space and \n to indicate the end of the text
        clipboard_raw = clipboard_raw + " \n";

        // find the position of the first non-space character
        Integer readpos=0;
        String readchar="";
        Integer lastpos = clipboard_raw.length();
        Integer foundbegin=0;
        Integer errors=0;
        Integer startpos=0;
        Integer tle_lines = 0;
        String field_value="";
        Integer field_len;
        Integer space_counter;
        Integer build_tle_beginpos;
        Integer build_tle_endpos;

        String good_tle=""; // output tle that's build up gradually and correct
        String build_tle=""; // building a single tle from read arguments until it's complete
        Integer marker1,marker2;


        if (lastpos < (10+65+65))
        {
            // not enough characters for a TLE set

        } else {
            // perhaps one TLE set

            while ((readpos < lastpos) && (foundbegin==0))
            {

                // read char
                readchar=clipboard_raw.substring(readpos,readpos+1);  // find

                // skip until we don't see spaces anymore
                if (!(readchar.equals(" ")))
                {
                    // character is not a space, mark this as the begin
                    foundbegin = 1;
                    startpos=readpos;
                    break;
                }
                readpos++;

            }


            // recreate TLE based on fixed format of 24,69,69 and other known positions
            if (foundbegin == 1)
            {
                // run through text, inserting fake newline characters as we go
                // startpos still holds the position of the starting character
                readpos=startpos;
                errors=0;

                while (readpos < lastpos)
                {

                    tle_lines++;

                    // so we have a bunch of characters that have been stripped from line breaks
                    // and multiple consecutive spaces may have been trimmed to just one.
                    // here's how we break it all up and reconstruct a correctly formatted TLE

                    // first we try to find the end of the BSTAR drag term and the Ephemeris type.
                    //
                    // what we're looking for is:  [unk-nr][minus][unk-nr][space][zero][space]
                    // where the unk-nr are single-digit numeric values.
                    //

                    // Step 1a - see if we can find the position of '[space][zero][space]'

                    readpos=readpos + 25; // skip over the description

                    marker1=clipboard_raw.indexOf(" 0 ",readpos);

                    if (marker1 == -1)
                    {
                        // sequence not found, this is not TLE data, abort
                        errors++;
                        break;
                    }

                    // keep track of how far we've searched towards the end
                    build_tle_endpos=marker1 + 2; // // pos of the space right after the ephemeris (64)

                    // marker found, let's see if two positions earlier we see a '-' (minus)

                    if (!(clipboard_raw.substring(marker1-2,marker1-1).equals("-")))
                    {
                        // //Log.e("marker","BSTAR - not found");
                        errors++;
                        break;

                    }

                    // create the BSTAR field
                    field_len=8;

                    // go back to the beginning of the field, prefixed by a space character

                    marker2=clipboard_raw.lastIndexOf(" ",marker1-2);
                    if (marker2 == -1)
                    {
                        // sequence not found, this is not TLE data, abort
                        errors++;
                        break;
                    } else {
                        if (marker2 + 1 < marker1 - field_len)
                        {
                            // too far away, doesn't look like a tle
                            errors++;
                            break;
                        }
                    }

                    // keep track of how far we've searched towards the beginning
                    build_tle_beginpos=marker2; // pos of the space in front of BSTAR value (not field)

                    // copy the field from the raw input string
                    field_value=clipboard_raw.substring(marker2+1,marker1);

                    // add leading spaces if required
                    space_counter=field_len-field_value.length();
                    while (space_counter>0)
                    {
                        field_value = " " + field_value;
                        space_counter--;
                    }
                    // Enter the first values (BSTAR + Ephemeris) into the build_tle string
                    build_tle=field_value + " 0 ";
                    sat_drag = field_value;



                    //Log.e("field","BSTAR = [" + field_value + "]");


                    // build_tle_beginpos is now at the space in front of the BSTAR field (53)

                    // Step 2 - find the element set number and modulo
                    field_len=5;

                    // search for the first value that is non-space after build_tle_endpos
                    readpos = build_tle_endpos;
                    while (readpos < build_tle_endpos + field_len)
                    {
                        // read the next character
                        if (clipboard_raw.substring(readpos,readpos+1).equals(" "))
                        {
                            // not interested in spaces
                            readpos++;

                            if (readpos >= build_tle_endpos + field_len)
                            {
                                // gone too far, not a TLE data set, abort
                                errors++;
                                break;
                            }
                        } else {
                            // found something
                            marker1 = readpos; // marks the beginning of these two fields
                            break;
                        }

                    }


                    if (errors != 0)
                    {
                        // stop processing if this doesn't look like valid TLE data
                        readpos = lastpos;
                        break;
                    }

                    // determine the end of the set number and modulo fields

                    // find the next space, start searching after marker1
                    marker2 = clipboard_raw.indexOf(" ",marker1+1);
                    if (marker2 == -1)
                    {
                        // not found, abort
                        errors++;
                        break;
                    } else {
                        if (marker2 > marker1 + field_len + 2)
                        {
                            // gone too far, not TLE, abort
                            errors++;
                            break;
                        }

                    }

                    // keep track of how far we've searched toward the end
                    build_tle_endpos=marker2; // pos of the space after the modulo character on line 1

                    // copy the field from the raw input string
                    field_value=clipboard_raw.substring(marker1,marker2);


                    // add leading spaces if required
                    space_counter=field_len-field_value.length();
                    while (space_counter>0)
                    {
                        field_value = " " + field_value;
                        space_counter--;

                    }



                    //Log.e("field","SetNr + Mod = [" + field_value + "]");

                    // append these fields (RevNr and Modulo line1) + CRLF to the build_tle string
                    build_tle=build_tle + field_value + "#";

                    sat_ele = field_value.substring(0, field_value.length()-1); // First 3 characters of string is element set number
                    sat_chksum1 = field_value.substring(field_value.length()-1); // Last number is modulo checksum

                    // Step 3 - find the 2nd time derivative of mean motion (before BSTAR drag term)
                    field_len=8;

                    // search for a space character before tle_build_beginpos
                    // build_tle_beginpos is now at the space in front of the BSTAR field (53)


                    // find the end of the field (where the last number can be found)
                    // search for the first value that is non-space before bstar drag
                    readpos = build_tle_beginpos;
                    while (readpos > build_tle_beginpos - field_len)
                    {
                        // read the previous character
                        if (clipboard_raw.substring(readpos,readpos+1).equals(" "))
                        {
                            // not interested in spaces
                            readpos--;

                            if (readpos <= build_tle_beginpos - field_len)
                            {
                                // gone too far, not a TLE data set, abort
                                errors++;
                                break;
                            }
                        } else {
                            // found something
                            marker2 = readpos; // marks the end of the field
                            break;
                        }

                    }


                    if (errors != 0)
                    {
                        // stop processing if this doesn't look like valid TLE data
                        readpos = lastpos;
                        break;
                    }


                    // go back to the beginning of the field, prefixed by a space character
                    marker1=clipboard_raw.lastIndexOf(" ",marker2-2);
                    if (marker1 == -1)
                    {
                        // sequence not found, this is not TLE data, abort
                        errors++;
                        break;
                    } else {
                        if (marker1 + 1 < marker2 - (field_len + 1))
                        {
                            // too far away, doesn't look like a tle
                            errors++;
                            break;
                        }
                    }


                    // copy the field from the raw input string
                    field_value=clipboard_raw.substring(marker1+1,marker2+1);
                    //Log.e("field","2nd tdmm = [" + field_value + "]");

                    // keep track of how far we've searched towards the beginning
                    build_tle_beginpos=marker1; // pos of the space in front of value (not field)


                    // add leading spaces if required
                    space_counter=field_len-field_value.length();
                    while (space_counter>0)
                    {
                        field_value = " " + field_value;
                        space_counter--;

                    }

                    // build_tle_beginpos is now at the space in front of the 2tddmm field (44)

                    // prepend this field (2nd tdmm) to the build_tle string
                    build_tle = field_value + " " + build_tle;

                    sat_stdmm = field_value;






                    // Step 4 - find the 1st tdmm (before 2nd tdmm)
                    field_len=10;

                    // search for a space character before tle_build_beginpos
                    // build_tle_beginpos = pos of the space in front of 2nd tdmm value (not field)


                    // find the end of the field (where the last number can be found)
                    // search for the first value that is non-space before 2nd tdmm
                    readpos = build_tle_beginpos;
                    while (readpos > build_tle_beginpos - field_len)
                    {
                        // read the previous character
                        if (clipboard_raw.substring(readpos,readpos+1).equals(" "))
                        {

                            // not interested in spaces
                            readpos--;

                            if (readpos <= build_tle_beginpos - field_len)
                            {
                                // gone too far, not a TLE data set, abort
                                errors++;
                                break;
                            }
                        } else {
                            // found something
                            marker2 = readpos; // marks the end of the field
                            break;
                        }

                    }


                    if (errors != 0)
                    {
                        // stop processing if this doesn't look like valid TLE data
                        readpos = lastpos;
                        break;
                    }


                    // go back to the beginning of the field, prefixed by a space character
                    marker1=clipboard_raw.lastIndexOf(" ",marker2-2);
                    if (marker1 == -1)
                    {
                        // sequence not found, this is not TLE data, abort
                        errors++;
                        break;
                    } else {
                        if (marker1 + 1 < marker2 - field_len)
                        {
                            // too far away, doesn't look like a tle
                            errors++;
                            break;
                        }
                    }

                    // keep track of how far we've searched towards the beginning
                    build_tle_beginpos=marker1; // pos of the space in front of value (not field)

                    // copy the field from the raw input string
                    field_value=clipboard_raw.substring(marker1+1,marker2+1);


                    // add leading spaces if required
                    space_counter=field_len-field_value.length();
                    while (space_counter>0)
                    {
                        field_value = " " + field_value;

                        space_counter--;
                    }

                    //Log.e("field","1st tdmm = [" + field_value + "]");

                    // prepend this field (1st tdmm) to the build_tle string
                    build_tle = field_value + " " + build_tle;

                    sat_ftdmm = field_value;








                    // Step 5a - find the epoch day fraction (before 1st tdmm)
                    field_len=8; // only the decimals behind the dot (the fraction)

                    // search for a dot character before tle_build_beginpos
                    // build_tle_beginpos = pos of the space in front of value (not field)
                    marker2=build_tle_beginpos;


                    // go back to the beginning of the field, prefixed by a space character
                    marker1=clipboard_raw.lastIndexOf(".",marker2-2);
                    if (marker1 == -1)
                    {
                        // sequence not found, this is not TLE data, abort
                        errors++;
                        break;
                    } else {

                        if (marker1 + 2 < marker2 - field_len)
                        {
                            // too far away, doesn't look like a tle
                            errors++;
                            break;
                        }
                    }

                    // keep track of how far we've searched towards the beginning
                    build_tle_beginpos=marker1; // pos of the dot in front of value (not field)

                    // copy the field from the raw input string
                    field_value=clipboard_raw.substring(marker1,marker1+field_len+1);

                    //Log.e("field","day frac = [" + field_value + "]");

                    // add trailing spaces if required
                    //space_counter=field_len-field_value.length();
                    //while (space_counter>0)
                    //{
                    //	field_value = field_value + " ";
                    //	space_counter--;
                    //}



                    // prepend this field (day fraction) to the build_tle string
                    build_tle = field_value + " " + build_tle;

                    sat_epochday = field_value;






                    // Step 5b - find the epoch day (integers)

                    marker1=build_tle_beginpos;
                    marker2=build_tle_beginpos;

                    // check if the SECOND position before the dot is a space (day < 10)
                    if (clipboard_raw.substring(marker1-1,marker1).equals(" "))
                    {
                        // day integer is 1-9    YY  D.FFFFFFFF
                        marker1=marker1-1;
                        field_value="  ";
                    } else {
                        // day >= 10
                        if (clipboard_raw.substring(marker1-2,marker1-1).equals(" "))
                        {
                            // day integer is 10-99    YY DD.FFFFFFFF
                            marker1=marker1-2;
                            field_value=" ";
                        } else {
                            // day integer is 100-365    YYDDD.FFFFFFFF
                            marker1=marker1-3;
                            field_value="";
                        }
                    }

                    // keep track of how far we've searched towards the beginning
                    build_tle_beginpos=marker1; // pos of the first (of three, with padding) characters of the epoch day


                    // copy the field from the raw input string
                    field_value = field_value + clipboard_raw.substring(marker1,marker2);
                    //Log.e("field","day int = [" + field_value + "]");

                    // prepend this field (day) to the build_tle string
                    build_tle = field_value + build_tle;

                    sat_epochday = field_value + sat_epochday;



                    // Step 5c - add the epoch year (integers)

                    marker1=build_tle_beginpos-2;
                    marker2=build_tle_beginpos;

                    // keep track of how far we've searched towards the beginning
                    build_tle_beginpos=marker1-1; // pos of the first (of two) characters of the epoch year

                    // copy the field from the raw input string
                    field_value = clipboard_raw.substring(marker1,marker2);
                    //Log.e("field","ep year = [" + field_value + "]");

                    // prepend this field (day) to the build_tle string
                    build_tle = " " + field_value + build_tle;

                    sat_epochyr = field_value;





                    // Step 6 - find Launch Year-Nr-Piece (before epoch year)
                    field_len=8;

                    // build_tle_beginpos = pos of the space in front of epoch year value

                    // find the end of the field (where the last number can be found)
                    // search for the first value that is non-space before epoch year
                    readpos = build_tle_beginpos;
                    while (readpos > build_tle_beginpos - field_len)
                    {
                        // read the previous character
                        if (clipboard_raw.substring(readpos,readpos+1).equals(" "))
                        {

                            // not interested in spaces
                            readpos--;

                            if (readpos <= build_tle_beginpos - field_len)
                            {
                                // gone too far, not a TLE data set, abort
                                errors++;
                                break;
                            }
                        } else {
                            // found something
                            marker2 = readpos; // marks the end of the field
                            break;
                        }

                    }


                    if (errors != 0)
                    {
                        // stop processing if this doesn't look like valid TLE data
                        readpos = lastpos;
                        break;
                    }


                    // go back to the beginning of the field, prefixed by a space character
                    marker1=clipboard_raw.lastIndexOf(" ",marker2-4);
                    if (marker1 == -1)
                    {
                        // sequence not found, this is not TLE data, abort
                        errors++;
                        break;
                    } else {
                        if (marker1 + 1 < marker2 - field_len)
                        {
                            // too far away, doesn't look like a tle
                            errors++;
                            break;
                        }
                    }

                    // keep track of how far we've searched towards the beginning
                    build_tle_beginpos=marker1; // pos of the space in front of value (not field)

                    // copy the field from the raw input string
                    field_value=clipboard_raw.substring(marker1+1,marker2+1);


                    // add trailing spaces if required
                    space_counter=field_len-field_value.length();
                    while (space_counter>0)
                    {
                        field_value = field_value + " ";
                        space_counter--;
                    }
                    //Log.e("field","launch = [" + field_value + "]");

                    // prepend this field (launch) to the build_tle string
                    build_tle = field_value + build_tle;
                    sat_launchyr = field_value.substring(0, field_value.length()-6); // first 2 numbers
                    sat_launchnr = field_value.substring(2, field_value.length()-3); // second 3 numbers
                    sat_launchpc = field_value.substring(field_value.length()-3); // last 3 characters

                    // Step 7 - add line number + Satellite Norad Number (before launch year-nr-piece)
                    field_len=6;

                    // search for a space character before tle_build_beginpos
                    // build_tle_beginpos = pos of the space in front of epoch year value
                    marker2=build_tle_beginpos;

                    // go back to the beginning of the field, prefixed by a space character
                    marker1=clipboard_raw.lastIndexOf(" ",marker2-2);
                    if (marker1 == -1)
                    {
                        // sequence not found, this is not TLE data, abort
                        errors++;
                        break;
                    } else {
                        if (marker1 + 1 < marker2 - field_len)
                        {
                            // too far away, doesn't look like a tle
                            errors++;
                            break;
                        }
                    }



                    // copy the field from the raw input string
                    field_value=clipboard_raw.substring(marker1,marker2);


                    // add trailing spaces if required
                    space_counter=field_len-field_value.length();
                    while (space_counter>0)
                    {
                        field_value = field_value + " ";
                        space_counter--;
                    }

                    // keep track of how far we've searched towards the beginning
                    build_tle_beginpos=marker1-1; // pos of the number '1' at the beginning of line 1

                    //Log.e("field","sat id = [" + field_value + "]");

                    // prepend this field (launch-nr) to the build_tle string
                    build_tle = "1" + field_value + " " + build_tle;
                    sat_launchnr = "1" + field_value;


                    // Step 8 - add the satellite description (before the '1' line number)
                    field_len=24;

                    // read everything from 'startpos' onwards

                    // copy the field from the raw input string
                    field_value = clipboard_raw.substring(startpos,build_tle_beginpos-1);

                    // add trailing spaces if required
                    space_counter=field_len-field_value.length();
                    while (space_counter>0)
                    {
                        field_value = field_value + " ";
                        space_counter--;
                    }

                    //Log.e("field","sat desc = " + field_value);


                    // prepend this field (sat description) to the build_tle string
                    build_tle = field_value + "#" + build_tle;
                    sat_satname = field_value;


                    // that's it for the description line and the first TLE line
                    // let's add the fields from the last TLE data line

                    // build_tle_endpos now contains the position of the very last character of
                    // TLE data line 1 (probably a space)

                    // Step 9 - add the '2' line number

                    // search for the first value that is non-space after build_tle_endpos,
                    // this should only be 1 or 2 positions further
                    readpos = build_tle_endpos;
                    while (readpos < build_tle_endpos + 3)
                    {
                        // read the next character
                        if (clipboard_raw.substring(readpos,readpos+1).equals(" "))
                        {
                            // not interested in spaces
                            readpos++;

                            if (readpos >= build_tle_endpos + 3)
                            {
                                // gone too far, not a TLE data set, abort
                                errors++;
                                break;
                            }
                        } else {
                            // found something

                            // check if character is a '2'
                            if (clipboard_raw.substring(readpos,readpos+1).equals("2"))
                            {
                                // looking good

                                // confirm that the next value is a space
                                if (clipboard_raw.substring(readpos+1,readpos+2).equals(" "))
                                {
                                    // found '2' surrounded by spaces, this is correct
                                    field_value="2";
                                    marker1 = readpos + 1; // marks the position of the space after the '2' number
                                    break;
                                } else {
                                    // doesn't look like TLE data, abort
                                    errors++;
                                    break;
                                }
                            }
                        }

                    }


                    if (errors != 0)
                    {
                        // stop processing if this doesn't look like valid TLE data
                        readpos = lastpos;
                        break;
                    }

                    // keep track of how far we've searched towards the end
                    build_tle_endpos=marker1; // pos of the space after the line number on data line 2

                    // prepend this field (line nr) to the build_tle string
                    build_tle = build_tle + field_value;


                    // Step 10 - add the satellite norad id (after '2' on line 2)
                    field_len=5;

                    // search for a space character after tle_build_endpos
                    // build_tle_endpos = pos of the space right after '2' on line 2
                    marker1=build_tle_endpos;


                    // find the next space character
                    marker2=clipboard_raw.indexOf(" ",marker1+1);


                    if (marker2 == -1)
                    {
                        // sequence not found, this is not TLE data, abort
                        errors++;
                        break;
                    } else {

                        if (marker2 + 1 < marker1 - field_len)
                        {
                            // too far away, doesn't look like a tle
                            errors++;
                            break;
                        }
                    }

                    // keep track of how far we've searched towards the end
                    build_tle_endpos=marker2; // pos of the space

                    // copy the field from the raw input string
                    field_value=clipboard_raw.substring(marker1+1,marker2);


                    //Log.e("field","sat id2 = [" + field_value +"]");

                    // append this field (norad sat id) to the build_tle string
                    build_tle = build_tle + " " + field_value;
                    sat_satnr1 = field_value;
                    sat_satnr2 = field_value;

                    // Step 11 - add the Inclination (after norad sat id on line 2)
                    // can have up to two leading spaces
                    // ends at fixed position
                    field_len=8;

                    field_value="";
                    // search for the first value that is non-space after build_tle_endpos,
                    // this should only be 1 or 2 positions further
                    readpos = build_tle_endpos;
                    while (readpos < build_tle_endpos + field_len)
                    {
                        // read the next character
                        if (clipboard_raw.substring(readpos,readpos+1).equals(" "))
                        {
                            // detected a space character

                            readpos++;

                            if (readpos >= build_tle_endpos + field_len)
                            {
                                // gone too far, not a TLE data set, abort
                                errors++;
                                break;
                            }
                        } else {
                            // found something

                            marker1 = readpos; // marks the beginning of this field
                            break;
                        }

                    }

                    if (errors != 0)
                    {
                        // stop processing if this doesn't look like valid TLE data
                        readpos = lastpos;
                        break;
                    }


                    // determine the end of inclination field

                    // find the next space, start searching after marker1
                    marker2 = clipboard_raw.indexOf(" ",marker1+1);
                    if (marker2 == -1)
                    {
                        // not found, abort
                        errors++;
                        break;
                    } else {
                        if (marker2 > marker1 + field_len + 2)
                        {
                            // gone too far, not TLE, abort
                            errors++;
                            break;
                        }

                    }

                    // include leading spaces
                    readpos=marker2-marker1; // re-use the readpos variable for this calculation
                    while (readpos < field_len)
                    {
                        field_value=field_value+" ";
                        readpos++;
                    }


                    // keep track of how far we've searched toward the end
                    build_tle_endpos=marker2; // pos of the space after the inclination

                    // copy the field from the raw input string
                    field_value=field_value+clipboard_raw.substring(marker1,marker2);
                    //Log.e("field","inclination = [" + field_value + "]");

                    // append this field (inclination) to the build_tle string
                    build_tle = build_tle + " " + field_value;
                    sat_incl = field_value;

                    // Step 12 - add the RAAN (after inclination)
                    // can have up to two leading spaces
                    // ends at fixed position
                    field_len=8;

                    field_value="";
                    // search for the first value that is non-space after build_tle_endpos,
                    // this should only be 1 or 2 positions further
                    readpos = build_tle_endpos;
                    while (readpos < build_tle_endpos + field_len)
                    {
                        // read the next character
                        if (clipboard_raw.substring(readpos,readpos+1).equals(" "))
                        {
                            // detected a space character
                            readpos++;

                            if (readpos >= build_tle_endpos + field_len)
                            {
                                // gone too far, not a TLE data set, abort
                                errors++;
                                break;
                            }
                        } else {
                            // found something

                            marker1 = readpos; // marks the beginning of this field
                            break;
                        }

                    }

                    if (errors != 0)
                    {
                        // stop processing if this doesn't look like valid TLE data
                        readpos = lastpos;
                        break;
                    }


                    // determine the end of RAAN field

                    // find the next space, start searching after marker1
                    marker2 = clipboard_raw.indexOf(" ",marker1+1);
                    if (marker2 == -1)
                    {
                        // not found, abort
                        errors++;
                        break;
                    } else {
                        if (marker2 > marker1 + field_len + 2)
                        {
                            // gone too far, not TLE, abort
                            errors++;
                            break;
                        }

                    }

                    // include leading spaces
                    readpos=marker2-marker1; // re-use the readpos variable for this calculation

                    while (readpos < field_len)
                    {
                        field_value=field_value+" ";
                        readpos++;

                    }

                    // keep track of how far we've searched toward the end
                    build_tle_endpos=marker2; // pos of the space after the inclination

                    // copy the field from the raw input string
                    field_value=field_value+clipboard_raw.substring(marker1,marker2);
                    //Log.e("field","RAAN = [" + field_value + "]");

                    // append this field (RAAN) to the build_tle string
                    build_tle = build_tle + " " + field_value;
                    sat_ra = field_value;


                    // Step 13 - eccentricity
                    field_len=7;

                    // search for a space character after tle_build_endpos
                    marker1=build_tle_endpos;

                    // find the next space character
                    marker2=clipboard_raw.indexOf(" ",marker1+1);

                    if (marker2 == -1)
                    {
                        // sequence not found, this is not TLE data, abort
                        errors++;
                        break;
                    } else {

                        if (marker2 + 1 < marker1 - field_len)
                        {
                            // too far away, doesn't look like a tle
                            errors++;
                            break;
                        }
                    }

                    // keep track of how far we've searched towards the end
                    build_tle_endpos=marker2; // pos of the space

                    // copy the field from the raw input string
                    field_value=clipboard_raw.substring(marker1+1,marker2);

                    //Log.e("field","eccentricity = [" + field_value + "]");

                    // append this field (eccentricity) to the build_tle string
                    build_tle = build_tle + " " + field_value;

                    sat_ecc = field_value;

                    // step 14 - argument of perigee

                    // can have up to two leading spaces
                    // ends at fixed position
                    field_len=8;

                    field_value="";
                    // search for the first value that is non-space after build_tle_endpos,
                    // this should only be 1 or 2 positions further
                    readpos = build_tle_endpos;
                    while (readpos < build_tle_endpos + field_len)
                    {
                        // read the next character
                        if (clipboard_raw.substring(readpos,readpos+1).equals(" "))
                        {
                            // detected a space character

                            readpos++;

                            if (readpos >= build_tle_endpos + field_len)
                            {
                                // gone too far, not a TLE data set, abort
                                errors++;
                                break;
                            }
                        } else {
                            // found something

                            marker1 = readpos; // marks the beginning of this field
                            break;
                        }

                    }

                    if (errors != 0)
                    {
                        // stop processing if this doesn't look like valid TLE data
                        readpos = lastpos;
                        break;
                    }


                    // determine the end of argument of perigee field

                    // find the next space, start searching after marker1
                    marker2 = clipboard_raw.indexOf(" ",marker1+1);
                    if (marker2 == -1)
                    {
                        // not found, abort
                        errors++;
                        break;
                    } else {
                        if (marker2 > marker1 + field_len + 2)
                        {
                            // gone too far, not TLE, abort
                            errors++;
                            break;
                        }

                    }

                    // include leading spaces
                    readpos=marker2-marker1; // re-use the readpos variable for this calculation

                    while (readpos < field_len)
                    {
                        field_value=field_value+" ";
                        readpos++;
                    }

                    // keep track of how far we've searched toward the end
                    build_tle_endpos=marker2; // pos of the space after the argument of perigee

                    // copy the field from the raw input string
                    field_value=field_value+clipboard_raw.substring(marker1,marker2);
                    //Log.e("field","arg p = [" + field_value + "]");

                    // append this field (arg p) to the build_tle string
                    build_tle = build_tle + " " + field_value;

                    sat_peri = field_value;



                    // step 15 - mean anomaly

                    // can have up to two leading spaces
                    // ends at fixed position
                    field_len=8;

                    field_value="";
                    // search for the first value that is non-space after build_tle_endpos,
                    // this should only be 1 or 2 positions further
                    readpos = build_tle_endpos;
                    while (readpos < build_tle_endpos + field_len)
                    {
                        // read the next character
                        if (clipboard_raw.substring(readpos,readpos+1).equals(" "))
                        {
                            // detected a space character

                            readpos++;

                            if (readpos >= build_tle_endpos + field_len)
                            {
                                // gone too far, not a TLE data set, abort
                                errors++;
                                break;
                            }
                        } else {
                            // found something

                            marker1 = readpos; // marks the beginning of this field
                            break;
                        }

                    }

                    if (errors != 0)
                    {
                        // stop processing if this doesn't look like valid TLE data
                        readpos = lastpos;
                        break;
                    }


                    // determine the end of argument of perigee field

                    // find the next space, start searching after marker1
                    marker2 = clipboard_raw.indexOf(" ",marker1+1);
                    if (marker2 == -1)
                    {
                        // not found, abort
                        errors++;
                        break;
                    } else {
                        if (marker2 > marker1 + field_len + 2)
                        {
                            // gone too far, not TLE, abort
                            errors++;
                            break;
                        }

                    }

                    // include leading spaces
                    readpos=marker2-marker1; // re-use the readpos variable for this calculation

                    while (readpos < field_len)
                    {
                        field_value=field_value+" ";
                        readpos++;
                    }

                    // keep track of how far we've searched toward the end
                    build_tle_endpos=marker2; // pos of the space after the mean anomaly

                    // copy the field from the raw input string
                    field_value=field_value+clipboard_raw.substring(marker1,marker2);
                    //Log.e("field","mean an = [" + field_value + "]");

                    // append this field (mean anomaly) to the build_tle string
                    build_tle = build_tle + " " + field_value;

                    sat_ma = field_value;


                    // step 16 - mean motion

                    // can have up to two leading spaces
                    // ends at fixed position
                    field_len=11;

                    field_value="";

                    //             53         64   69
                    //           52|          |    |
                    //     ma     |mmmmmmmmmmmrrrrrM
                    //     80.5063 13.99471632525847\n"

                    // build_tle_endpos  =  pos of the space after the mean anomaly

                    marker1 = build_tle_endpos;
                    marker2 = clipboard_raw.indexOf(".",marker1);
                    if (marker2 == -1)
                    {
                        // not found, abort
                        errors++;
                        break;
                    } else {
                        if (marker2 > marker1 + field_len + 2)
                        {
                            // gone too far, not TLE, abort
                            errors++;
                            break;
                        }
                    }
                    // search backwards to find out how many integers there are in front of the dot


                    // marker2 is where the dot is
                    marker1=marker2;
                    marker1--;


                    if (clipboard_raw.substring(marker1,marker1+1).equals(" "))
                    {
                        // first character before the dot is a space, integer is < 0
                        field_value="   ";

                    } else {

                        marker1--;
                        if (clipboard_raw.substring(marker1,marker1+1).equals(" "))
                        {
                            // second character before the dot is a space, integer is < 10
                            field_value=" ";

                        } else {
                            marker1--;
                            if (clipboard_raw.substring(marker1,marker1+1).equals(" "))
                            {
                                // third character before the dot is a space, integer is between 10 - 99
                                field_value="";

                            } else {
                                // no way we can have three integer characters in front of the dot, invalide TLE, abort
                                errors++;
                                break;
                            }
                        }
                    }

                    // now that we know how many integers we have in front of the dot we can reconstruct the field

                    // copy the field from the raw input string
                    field_value=field_value+clipboard_raw.substring(marker1+1,(marker2 + field_len - 2));
                    //Log.e("field","mean motion = [" + field_value + "]");

                    // keep track of how far we've searched toward the end
                    build_tle_endpos=marker2 + field_len - 3; // pos of the last character of mean motion


                    // append this field (mean motion) to the build_tle string
                    build_tle = build_tle + " " + field_value;

                    sat_mm = field_value;


                    // Step 17 - revnumber and modulo
                    field_len=6;

                    field_value="";
                    marker1 = build_tle_endpos+1; // marker1 is the first value of revnr (can be space)

                    // see if there's a space between mean motion and revnr

                    if (clipboard_raw.substring(marker1,marker1+1).equals(" "))
                    {
                        // space found at marker1, revnr is not 5 characters

                        // add leading spaces
                        field_value="";
                        // search for the first value that is non-space after marker1,
                        // this should only be 1-4 positions further
                        readpos = marker1;
                        while (readpos < build_tle_endpos + field_len)
                        {
                            // read the next character
                            if (clipboard_raw.substring(readpos,readpos+1).equals(" "))
                            {
                                // detected a space character

                                readpos++;

                                if (readpos >= build_tle_endpos + field_len)
                                {
                                    // gone too far, not a TLE data set, abort
                                    errors++;
                                    break;
                                }
                            } else {
                                // found something

                                marker1 = readpos; // marks the beginning of this field
                                break;
                            }

                        }

                        if (errors != 0)
                        {
                            // stop processing if this doesn't look like valid TLE data
                            readpos = lastpos;
                            break;
                        }


                    } else {
                        // revnr starts immediatly at marker1
                        // find the next space (as this will indicate the end of the line)
                        // marker1 is the position of the first value of revnr
                    }

                    // find the next space, start searching after marker1
                    marker2 = clipboard_raw.indexOf(" ",marker1);
                    if (marker2 == -1)
                    {
                        // not found, abort
                        errors++;
                        break;
                    } else {
                        if (marker2 > marker1 + field_len + 2)
                        {
                            // gone too far, not TLE, abort
                            errors++;
                            break;
                        }
                    }


                    // include leading spaces
                    readpos=marker2-marker1; // re-use the readpos variable for this calculation

                    while (readpos < field_len)
                    {
                        field_value=field_value+" ";
                        readpos++;
                    }


                    // copy the field from the raw input string
                    field_value=field_value+clipboard_raw.substring(marker1,marker2);


                    //Log.e("field","revnr and modulo = [" + field_value + "]");


                    // keep track of how far we've searched toward the end
                    build_tle_endpos=marker2; // pos of the space after the modulo on line 2


                    // append this field (revnr) to the build_tle string
                    build_tle = build_tle + field_value;

                    sat_revnr = field_value;



                    // reached the end of reading one full TLE data set

                    build_tle=build_tle+"#";

                    //Log.e("total-1",""+build_tle.substring(0,24+1));
                    //Log.e("total-2",""+build_tle.substring(25,25+69+1));
                    //Log.e("total-3",""+build_tle.substring(25+1+69,25+1+69+69+1));


                    good_tle = good_tle + build_tle;  // append to the good TLE set


                    if ((build_tle_endpos + (10+65+65)) <  lastpos)
                    {
                        // enough characters for another run
                        startpos=build_tle_endpos+1; // point to the first character of the description
                        readpos=startpos;
                    } else {
                        // not enough remaining characters for there to be a valid TLE present

                        break;
                    }

                }


            }

            if (errors==0)
            {

                // Intent TM = new Intent(TleManualImport.this, TleUpdate.class);
                // TM.putExtra("target","clipboard");
                // TM.putExtra("clipboard",good_tle);
                // startActivityForResult(TM, 0);
                // return good_tle;

            }
        }

        String[] values = {sat_satname,sat_linenr1,sat_satnr1,sat_class,sat_launchyr,sat_launchnr,sat_launchpc,sat_epochyr,sat_epochday,sat_ftdmm,sat_stdmm,sat_drag,
                sat_eph,sat_ele,sat_chksum1,sat_linenr2,sat_satnr2,sat_incl,sat_ra,sat_ecc,sat_peri,sat_ma,sat_mm,sat_revnr,sat_chksum2,sat_notes,sat_active};

        // String[] values = good_tle.split(" ");

        return values;

    }
}


