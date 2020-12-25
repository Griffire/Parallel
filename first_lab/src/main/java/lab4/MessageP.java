package lab4;

import java.util.ArrayList;

public class MessageP {
    private final String idS, res;


    public String getIdS() {
        return idS;
    }

    MessageP(String idS){
        this.idS = idS;
        this.res = "none";
    }

    public String getRes() {
        return res;
    }

    MessageP(String idS, String res){
        this.idS = idS;
        this.res = res;
    }


}
