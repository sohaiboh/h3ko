package com.example.suhayb.h3ko.Utils;

public class Constants {

    public Constants() {}

//    Server url
    public static final String SERVER_URL = "http://dowser-medi-app.com.w00ffa2d.kasserver.com/index.php?";
    public static final String GET_PATIENT_BY_CARD_ID = SERVER_URL + "getPatientByCardId=";
    public static final String CARD_ID = "1";

//    Form Data
    public static final String CARD_ID_KEY = "card_id";
    public static final String CARD_VALUE = "AX34K75";

    // SHARED PREF PARAMS
    public static final String PREF_FILE = "MyPref";

    //    Personendaten
    public static final String name = "name";
    public static final String gewicht = "gewicht";
    public static final String groesse = "groesse";
    public static final String geschlecht = "geschlecht";

    //    Generelle Dokumentaiton
    public static final String vorerkrankungen = "vorerkrankungen";
    public static final String aktuelle_behandlungen = "aktuelle_behandlungen";
    public static final String aktuelle_mediaktion = "aktuelle_mediaktion";
    public static final String aktuelle_vergangene_symptomen = "aktuelle_vergangene_symptomen";
    public static final String andere = "andere";

    //    visuelle Dokumentaiton
    public static final String roentgentbilder = "roentgentbilder";
    public static final String mrt_bilder = "mrt_bilder";
    public static final String ultrashall = "ultrashall";

    //    akustische Dokumentaiton
    public static final String herztoene = "herztoene";

//    Permissions
    public static final int REQUEST_PERM_CAMERA = 1;
    public static final int CAPTURE_PHOTO = 2;

    //UTF
    static final String UTF_VERSION = "UTF-8";
}
