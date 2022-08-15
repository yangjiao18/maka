package com.example.maka.Util;

import java.sql.*;
import java.util.Properties;

public class AthenaJdbc {

    static final String athenaUrl = "jdbc:awsathena://AwsRegion=us-east-1;";

    public static void main(String[] args) {
        Connection conn = null;
        Statement statement = null;
        try {
            Properties info = new Properties();
            info.put("S3OutputLocation", "s3://jackcodetest/");
            info.put("User", "AKIAXDVBX7SHPS35DJ4K");
            info.put("Password", "7xJWVQUdAO247KzYjiACWsKCILMbf4xgoa7IoEuV");
            info.put("LogPath", "/queryresult2022");
            info.put("LogLevel", "6");
            info.put("AwsCredentialsProviderClass", "com.simba.athena.amazonaws.auth.PropertiesFileCredentialsProvider");
            String databaseName = "demo";

            System.out.println("Connecting to Athena...");
            conn = DriverManager.getConnection(athenaUrl, info);

            System.out.println("Listing tables...");
            String sql = "show tables in " + databaseName;
            statement = conn.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()) {
                String name = rs.getString("tab_name");
                System.out.println("Name: " + name);
            }
            rs.close();
            conn.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            try {
                if (statement != null)
                    statement.close();
            } catch (Exception ex) {

            }
            try {
                if (conn != null)
                    conn.close();
            } catch (Exception ex) {


                ex.printStackTrace();
            }
        }
        System.out.println("Finished connectivity test.");
    }

}
