package lab4;

import java.util.ArrayList;

public class executeMSG {
    private  ArrayList<Object> params;
    private String idS , function, jsS , testName ,  testExResult;


    public executeMSG(ArrayList<Object> params, String idS, String function, String jsS, String testName, String testExResult) {
        this.params = params;
        this.idS = idS;
        this.function = function;
        this.jsS = jsS;
        this.testName = testName;
        this.testExResult = testExResult;
    }

    public ArrayList<Object> getParams() {
        return this.params;
    }

    public String getIdS() {
        return this.idS;
    }

    public String getFunction() {
        return this.function;
    }

    public String getJsS() {
        return this.jsS;
    }

    public String getTestName() {
        return this.testName;
    }

    public String getTestExResult() {
        return this.testExResult;
    }
}
