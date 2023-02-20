package lk.ijse.spring.util;


public class ResponseUtil{
    private String state;
    private String massage;
    private Object data;

    public ResponseUtil(String state, String massage, Object data) {
        this.state = state;
        this.massage = massage;
        this.data = data;
    }

    public ResponseUtil() {
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

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "ResponseUtil{" +
                "state='" + state + '\'' +
                ", massage='" + massage + '\'' +
                ", data=" + data +
                '}';
    }
}
