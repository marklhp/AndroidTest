package bean;

public class WifiInfo {
    public String Ssid="";
    public String Password="";

    public String getSsid() {
        return Ssid;
    }

    public void setSsid(String ssid) {
        Ssid = ssid;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    @Override
    public String toString() {
        return "WifiInfo{" +
                "Ssid='" + Ssid + '\'' +
                ", Password='" + Password + '\'' +
                '}';
    }
}
