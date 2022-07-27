package org.example.model.xml;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class DataSource {
    @XmlElement(name = "source-name", required = true)
    private String sourcename;
    @XmlElement(name = "connection-url",required = true)
    private String connectionurl;
    @XmlElement(name = "driver-class",required = true)
    private String driverclass;
    @XmlElement(name = "user-name",required = true)
    private String username;
    @XmlElement(required = true)
    private String password;



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
