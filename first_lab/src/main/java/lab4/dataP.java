package lab4;


import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;

public class dataP {
    @JsonProperty("idS") String idS;
    @JsonProperty("tests") ArrayList<testP> tests;
    @JsonProperty("function") String function;
    @JsonProperty("jsS") String jsS;



    @JsonCreator dataP(String idS, ArrayList<testP> tests, String function , String jsS){
        this.idS = idS;
        this.tests = tests;
        this.function = function;
        this.jsS = jsS;
    }


    public String getFunction() {
        return this.function;
    }

    public String getJsS() {
        return this.jsS;
    }


    String getIdS(){
        return this.idS;
    }

    public ArrayList<testP> getTests() {
        return this.tests;
    }
}
