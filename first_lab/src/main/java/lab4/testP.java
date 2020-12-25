package lab4;

import com.fasterxml.jackson.annotation.JsonCreator;

import java.util.ArrayList;

public class testP {
    private String testName;
    private String testExResult;
    private ArrayList<Integer> params;

    @JsonCreator
    public  testP(String testName,String testExResult, ArrayList<Integer> params){
        this.testName = testName;
        this.testExResult = testExResult;
        this.params = params;
    }

}
