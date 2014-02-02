package org.gedcomx.rt;

import org.simpleframework.xml.transform.Transform;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * @author Reed Ellsworth
 */
public class DateTransformer implements Transform<Date>
{
  @Override
  public Date read( String value ) throws Exception {
    Date date = toDate( value );
    return date;
  }

  @Override
  public String write( Date value ) throws Exception {
    return gdxFormat.format( value );
  }


  public static final Date toDate( String str ) throws ParseException {
    if (str == null || str.length() == 0) {
      return null;
    }
    DateFormat format = dateTimeFormatShort2;
    ParsePosition pos = new ParsePosition( 0 );
    int len = str.length();
    for (int i = 0; i < 39; i++) {
      switch (i) {
        case 0:
          format = dateTimeFormatShort1;
          break;
        case 1:
          format = dateTimeFormatShort2;
          break;
        case 2:
          format = dateTimeFormat1;
          break;
        case 3:
          format = dateFormat1;
          break;
        case 4:
          format = dateFormat2;
          break;
        case 5:
          format = dateFormat3;
          break;
        case 6:
          format = gdxFormat;
          break;
        case 7:
          format = gdxFormat1;
          break;
        case 8:
          format = gdxFormat2;
          break;
        case 9:
          format = dateTimeFormatMed1;
          break;
        case 10:
          format = dateTimeFormatMed2;
          break;
        case 11:
          format = dateTimeFormatMed3;
          break;

        case 13:
          format = dateTimeFormatLong1;
          break;
        case 14:
          format = dateTimeFormatLong2;
          break;
        case 15:
          format = dateTimeFormatLong3;
          break;
        case 16:
          format = dateTimeFormatFull1;
          break;
        case 17:
          format = dateTimeFormatFull2;
          break;
        case 18:
          format = dateTimeFormatFull3;
          break;
        case 19:
          format = timeFormat3;
          break;
        case 20:
          format = timeFormat4;
          break;
        case 21:
          format = db2Format1;
          break;
        case 22:
          format = db2Format2;
          break;
        case 23:
          format = dateTimeFormatShort3;
          break;
        case 24:
          format = dateTimeFormatShort4;
          break;
        case 25:
          format = dateTimeFormatMed4;
          break;
        case 26:
          format = dateTimeFormatLong4;
          break;
        case 27:
          format = dateTimeFormatFull4;
          break;
        case 28:
          format = dateTimeFormat2;
          break;
        case 29:
          format = dateTimeFormat3;
          break;
        case 30:
          format = dateTimeFormat4;
          break;
        case 31:
          format = dateTimeFormat5;
          break;
        case 32:
          format = dateTimeFormat6;
          break;
        case 33:
          format = dateFormat4;
          break;
        case 34:
          format = dateFormat5;
          break;
        case 35:
          format = dateFormat6;
          break;
        case 36:
          format = dateFormat7;
          break;
        case 37:
          format = dateFormat8;
          break;

        case 12:
          format = toStringFormat1;
          break;
        case 38:
          format = toStringFormat2;
          break;
      }
      // System.out.println("parsing with (" + i + ") " + ((SimpleDateFormat)format).toPattern() + ": " + str );
      pos.setIndex( 0 );
      Date d = format.parse( str, pos );
      // System.out.println("parsed: " + d);
      if (d != null && pos.getIndex() >= len) {
        return d;
      }
    }

    throw new ParseException( "Unparseable date: " + str, 0 );
  }

  // Short Time:  h:mm a
  // Medium Time: h:mm:ss a
  // Long Time:   h:mm:ss a z
  // Short Date:  M/d/yy
  // Medium Date: MMM d, yyyy
  // Long Date:   MMMM d, yyyy
  // Full Date:   EEEE, MMMM d, yyyy
  // us formats   "h:mm:ss a z", "h:mm:ss a z", "h:mm:ss a", "h:mm a", "EEEE, MMMM d, yyyy", "MMMM d, yyyy", "MMM d, yyyy", "M/d/yy"
  // fr formats   "HH' h 'mm z", "HH:mm:ss z", "HH:mm:ss", "HH:mm",    "EEEE d MMMM yyyy", "d MMMM yyyy", "d MMM yyyy", "dd/MM/yy"
  // formats used by toDate(String) to parse dates and times
  private static DateFormat dateTimeFormatShort1 = DateFormat.getDateTimeInstance( DateFormat.SHORT, DateFormat.SHORT );
  private static DateFormat dateTimeFormatShort2 = DateFormat.getDateTimeInstance( DateFormat.SHORT, DateFormat.MEDIUM );  // default VB format: M/d/yy h:mm:ss a
  private static DateFormat dateTimeFormatShort3 = DateFormat.getDateTimeInstance( DateFormat.SHORT, DateFormat.LONG );
  private static DateFormat dateTimeFormatShort4 = DateFormat.getDateTimeInstance( DateFormat.SHORT, DateFormat.FULL );
  private static DateFormat dateTimeFormatMed1 = DateFormat.getDateTimeInstance( DateFormat.MEDIUM, DateFormat.SHORT );
  private static DateFormat dateTimeFormatMed2 = DateFormat.getDateTimeInstance( DateFormat.MEDIUM, DateFormat.MEDIUM );
  private static DateFormat dateTimeFormatMed3 = DateFormat.getDateTimeInstance( DateFormat.MEDIUM, DateFormat.LONG );
  private static DateFormat dateTimeFormatMed4 = DateFormat.getDateTimeInstance( DateFormat.MEDIUM, DateFormat.LONG );
  private static DateFormat dateTimeFormatLong1 = DateFormat.getDateTimeInstance( DateFormat.LONG, DateFormat.SHORT );
  private static DateFormat dateTimeFormatLong2 = DateFormat.getDateTimeInstance( DateFormat.LONG, DateFormat.MEDIUM );
  private static DateFormat dateTimeFormatLong3 = DateFormat.getDateTimeInstance( DateFormat.LONG, DateFormat.LONG );
  private static DateFormat dateTimeFormatLong4 = DateFormat.getDateTimeInstance( DateFormat.LONG, DateFormat.FULL );
  private static DateFormat dateTimeFormatFull1 = DateFormat.getDateTimeInstance( DateFormat.FULL, DateFormat.SHORT );
  private static DateFormat dateTimeFormatFull2 = DateFormat.getDateTimeInstance( DateFormat.FULL, DateFormat.MEDIUM );
  private static DateFormat dateTimeFormatFull3 = DateFormat.getDateTimeInstance( DateFormat.FULL, DateFormat.LONG );
  private static DateFormat dateTimeFormatFull4 = DateFormat.getDateTimeInstance( DateFormat.FULL, DateFormat.FULL );
  private static DateFormat dateFormat1 = DateFormat.getDateInstance( DateFormat.SHORT );
  private static DateFormat dateFormat2 = DateFormat.getDateInstance( DateFormat.MEDIUM );
  private static DateFormat dateFormat3 = DateFormat.getDateInstance( DateFormat.LONG );
  private static DateFormat dateFormat4 = DateFormat.getDateInstance( DateFormat.FULL );
  private static DateFormat timeFormat1 = DateFormat.getTimeInstance( DateFormat.SHORT );
  private static DateFormat timeFormat2 = DateFormat.getTimeInstance( DateFormat.MEDIUM );
  private static DateFormat timeFormat3 = DateFormat.getTimeInstance( DateFormat.LONG );
  private static DateFormat timeFormat4 = DateFormat.getTimeInstance( DateFormat.FULL );
  private static DateFormat toStringFormat1 = new SimpleDateFormat( "EEE MMM dd H:mm:ss zzz yyyy", Locale.US );
  private static DateFormat toStringFormat2 = new SimpleDateFormat( "EEE MMM dd H:mm:ss yyyy", Locale.US );
  private static DateFormat db2Format1 = new SimpleDateFormat( "yyyy-M-d H:mm:ss" );
  private static DateFormat db2Format2 = new SimpleDateFormat( "yyyy-M-d H:mm:ss.S" );
  private static DateFormat dateTimeFormat1 = new SimpleDateFormat( "M/d/yy H:mm" );
  private static DateFormat dateTimeFormat2 = new SimpleDateFormat( "M/d/yy H:mm:ss" );
  private static DateFormat dateTimeFormat3 = new SimpleDateFormat( "d-MMM-yy H:mm" );
  private static DateFormat dateTimeFormat4 = new SimpleDateFormat( "d-MMM-yy h:mm a" );
  private static DateFormat dateTimeFormat5 = new SimpleDateFormat( "d-MMM-yy H:mm:ss" );
  private static DateFormat dateTimeFormat6 = new SimpleDateFormat( "d-MMM-yy h:mm:ss a" );
  private static DateFormat dateFormat5 = new SimpleDateFormat( "M-d-yy" );
  private static DateFormat dateFormat6 = new SimpleDateFormat( "d-MMM-yy" );
  private static DateFormat dateFormat7 = new SimpleDateFormat( "d MMM yy" );
  private static DateFormat dateFormat8 = new SimpleDateFormat( "d.MMM.yy" );
  private static DateFormat gdxFormat = new SimpleDateFormat( "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'" ); //"2013-02-27T17:24:10.866Z"
  private static DateFormat gdxFormat1 = new SimpleDateFormat( "yyyy-MM-dd'T'HH:mm:ss'Z'" ); //"2013-02-27T17:24:10Z"
  private static DateFormat gdxFormat2 = new SimpleDateFormat( "+yyyy-MM-dd'T'HH:mm:ss.SSS'Z'" ); //"2013-02-27T17:24:10.866Z"

  private static DateFormat outputDateFormat = DateFormat.getDateInstance( DateFormat.SHORT );
  private static DateFormat outputDateTimeFormat = DateFormat.getDateTimeInstance( DateFormat.SHORT, DateFormat.MEDIUM );  // default VB format: M/d/yy h:mm:ss a
  private static DateFormat outputTimeFormat = DateFormat.getTimeInstance( DateFormat.MEDIUM );
}