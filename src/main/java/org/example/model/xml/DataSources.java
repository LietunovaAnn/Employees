package org.example.model.xml;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "datasources")
@XmlAccessorType(XmlAccessType.FIELD)
public class DataSources {
    @XmlElement(name = "datasource", required = true)
    private DataSource dataSource;


    public DataSource getDataSource() {
        return dataSource;
    }

    public void setDataSource(DataSource dataSource) {

        this.dataSource = dataSource;
    }
}
