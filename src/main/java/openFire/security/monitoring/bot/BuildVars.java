package openFire.security.monitoring.bot;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Ruben Bermudez
 * @version 1.0
 * @brief Custom build vars FILL EVERYTHING CORRECTLY
 * @date 20 of June of 2015
 */

public class BuildVars {
    public static final Boolean debug = true;
    public static final Boolean useWebHook = false;
    public static final int PORT = 8443;
    public static final String EXTERNALWEBHOOKURL = "https://example.changeme.com:" + PORT; // https://(xyz.)externaldomain.tld
    public static final String INTERNALWEBHOOKURL = "https://localhost.changeme.com:" + PORT; // https://(xyz.)localip/domain(.tld)
    public static final String pathToCertificatePublicKey = "./YOURPEM.pem"; //only for self-signed webhooks
    public static final String pathToCertificateStore = "./YOURSTORE.jks"; //self-signed and non-self-signed.
    public static final String certificateStorePassword = "yourpass"; //password for your certificate-store

    public static final String OPENWEATHERAPIKEY = "<your-api-key>";

    public static final String DirectionsApiKey = "<your-api-key>";

    public static final String TRANSIFEXUSER = "<transifex-user>";
    public static final String TRANSIFEXPASSWORD = "<transifex-password>";
    public static final List<Integer> ADMINS = new ArrayList<>();

    public static final String pathToLogs = "./";

    public static final String linkDB = "jdbc:mysql://localhost:3306/bot?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
    public static final String controllerDB = "com.mysql.cj.jdbc.Driver";
    public static final String userDB = "admin";
    public static final String password = "zaq1xsw2";

    public static final String COMMANDS_USER = "ClearFireSafetyBot";
    public static final String COMMANDS_TOKEN = "481742080:AAHo1XkPXHhcoAyonsP8wK97jdO1FgGGjeo";


    static {
        // Add elements to ADMIN array here
    }
}
