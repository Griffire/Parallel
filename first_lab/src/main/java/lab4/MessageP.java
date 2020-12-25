package lab4;

import java.util.ArrayList;

public class MessageP {
    private  String idS, res;
    private  ArrayList<String> results;


    public String getIdS() {
        return idS;
    }

    MessageP(String idS){
        this.idS = idS;
        this.res = "none";
        this.results = null;
    }

    public String getRes() {
        return res;
    }

    MessageP(String idS, String res){
        this.idS = idS;
        this.res = res;
        this.results = null;
    }

    public ArrayList<String> getResults() {
        return results;
    }

    MessageP(String idS, ArrayList<String> results){
        this.idS = idS;
        this.res = "none";
        this.results = results;
    }


}
