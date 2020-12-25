package lab4;


import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;

public class dataP {
    @JsonProperty("idS") String idS;

    @JsonCreator dataP(String idS, ArrayList<testP> tests){
        this.idS = idS;
    }

}
