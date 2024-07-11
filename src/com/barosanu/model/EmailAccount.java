package com.barosanu.model;

import javax.mail.Session;
import javax.mail.Store;
import java.util.Properties;

public class EmailAccount {

    private String address;
    private String password;
    private Properties properties;
    private Store store;

    public Session getSession() {
        return session;
    }

    public void setSession(Session session) {
        this.session = session;
    }

    private Session session;

    public String getAddress() {
        return address;
    }

    public String getPassword() {
        return password;
    }

    public Properties getProperties() {
        return properties;
    }

    public void setProperties(Properties properties) {
        this.properties = properties;
    }

    @Override
    public String toString() {
        return address;
    }

    public Store getStore() {
        return store;
    }

    public void setStore(Store store) {
        this.store = store;
    }

    public EmailAccount(String address, String password) {
        this.address = address;
        this.password = password;
        properties = new Properties();

        // Konfiguracja dla IMAP (Odbieranie poczty)
        properties.put("incomingHost", "imap.wp.pl");  // Serwer IMAP dla WP.pl
        properties.put("mail.store.protocol", "imaps"); // Protokół IMAP przez SSL
        properties.put("mail.imap.port", "993"); // Port IMAP
        properties.put("mail.imap.ssl.enable", "true"); // Wymaganie SSL

        // Konfiguracja dla SMTP (Wysyłanie poczty)
        properties.put("mail.transport.protocol", "smtp"); // Protokół SMTP
        properties.put("mail.smtp.host", "smtp.wp.pl"); // Serwer SMTP dla WP.pl
        properties.put("mail.smtp.port", "465"); // Port SMTP (SSL)
        properties.put("mail.smtp.auth", "true"); // Wymaganie uwierzytelnienia
        properties.put("mail.smtp.ssl.enable", "true"); // Wymaganie SSL
        properties.put("mail.smtp.starttls.enable", "true"); // Wymaganie STARTTLS

        properties.put("outgoingHost", "smtp.wp.pl"); // Alternatywnie, serwer SMTP dla wyjścia
    }

}