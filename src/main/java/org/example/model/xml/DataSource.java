package org.example.model.xml;

public class DataSource {

    public String sourcename;
    public String connectionurl;
    public String driverclass;
    public String username;
    public String password;



    public String getSourcename() {
        return sourcename;
    }

    public void setSourcename(String sourcename) {
        this.sourcename = sourcename;
    }

    public String getConnectionurl() {
        return connectionurl;
    }

    public void setConnectionurl(String connectionurl) {
        this.connectionurl = connectionurl;
    }

    public String getDriverclass() {
        return driverclass;
    }

    public void setDriverclass(String driverclass) {
        this.driverclass = driverclass;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "DataSource{" +
                "sourcename='" + sourcename + '\'' +
                ", connectionurl='" + connectionurl + '\'' +
                ", driverclass='" + driverclass + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
