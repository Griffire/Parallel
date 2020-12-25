package lab4;

import com.fasterxml.jackson.annotation.JsonCreator;

import java.util.ArrayList;

public class testP {
    private String testName;
    private String testExResult;
    private ArrayList<Integer> params;

    public String getTestName() {
        return this.testName;
    }

    public String getTestExResult() {
        return this.testExResult;
    }

    public ArrayList<Integer> getParams() {
        return this.params;
    }

    @JsonCreator
    public  testP(String testName,String testExResult, ArrayList<Integer> params){
        this.testName = testName;
        this.testExResult = testExResult;
        this.params = params;
    }

}
