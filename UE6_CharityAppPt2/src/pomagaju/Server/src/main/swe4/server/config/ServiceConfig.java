package swe4.server.config;

public class ServiceConfig {
    public static String benutzerServiceName() {
        return "BenutzerService";
    }

    public static String annahmestelleServiceName() {
        return "AnnahmestelleService";
    }

    public static String bedarfServiceName() {
        return "BedarfService";
    }

    public static String spendenank├╝ndigungServiceName() {
        return "Spendenank├╝ndigungService";
    }
    public static int port(){
        return 1099;
    }
}
