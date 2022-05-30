package com.zhang.properties;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author xiaomi
 * @date 2022/5/30
 */
@Component
@ConfigurationProperties(prefix = "spring.jdbc.datasource")
public class DataSourceProperties {

    //@Value("${spring.jdbc.datasource.username}")
    private String username;

    //@Value("${spring.jdbc.datasource.password}")
    private String password;

    //@Value("${spring.jdbc.datasource.url}")
    private String url;

    //@Value("${spring.jdbc.datasource.driverClassName}")
    private String driverClassName;

    @Override
    public String toString() {
        return "DataSourceProperties{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", url='" + url + '\'' +
                ", driverClassName='" + driverClassName + '\'' +
                '}';
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

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getDriverClassName() {
        return driverClassName;
    }

    public void setDriverClassName(String driverClassName) {
        this.driverClassName = driverClassName;
    }
}
