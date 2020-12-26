package lab4;

public class MessageS {
    private String adress;
    private  float time;


    public String getAdress() {
        return this.adress;
    }

    public float getTime() {
        return this.time;
    }

    public MessageS(String adress, float time) {
        this.adress = adress;
        this.time = time;
    }
}
