package lk.ijse.spring.util;

public class ResponseUtil{
    private String state;
    private String massage;
    private String data;

    public ResponseUtil() {
    }

    public ResponseUtil(String state, String massage, String data) {
        this.state = state;
        this.massage = massage;
        this.data = data;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getMassage() {
        return massage;
    }

    public void setMassage(String massage) {
        this.massage = massage;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "ResponseUtil{" +
                "state='" + state + '\'' +
                ", massage='" + massage + '\'' +
                ", data='" + data + '\'' +
                '}';
    }
}
