package controller;

public class ifLogged {

    public static Boolean ifLoginOk = false;

    public ifLogged(){

    }

    public static void setIfLoginOk(Boolean ifLoginOk) {
        ifLogged.ifLoginOk = ifLoginOk;
    }

    public static Boolean getIfLoginOk() {
        return ifLoginOk;
    }
}
