package com.nssaap.dao;
import java.sql.*;
import java.util.*;

import com.nssaap.utils.DBConnection;
public class PensionersDAO {
    public List<Map<String, String>> getPensionersData() {
        List<Map<String, String>> dataList = new ArrayList<>();
        String query = "SELECT * FROM pensioners_transections_last_update_details";
        
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(query);
             ResultSet rs = ps.executeQuery()) {
            
            while (rs.next()) {
                Map<String, String> row = new HashMap<>();
                row.put("state_code", rs.getString("state_code"));
                row.put("state_name", rs.getString("state_name"));
                row.put("state_short_name", rs.getString("state_short_name"));
                row.put("igndps_pensioner_last_update_date", rs.getString("igndps_pensioner_last_update_date"));
                row.put("ignoaps_pensioner_last_update_date", rs.getString("ignoaps_pensioner_last_update_date"));
                row.put("ignwps_pensioner_last_update_date", rs.getString("ignwps_pensioner_last_update_date"));
                row.put("igndps_transection_last_update_date", rs.getString("igndps_transection_last_update_date"));
                row.put("ignoaps_transection_last_update_date", rs.getString("ignoaps_transection_last_update_date"));
                row.put("ignwps_transection_last_update_date", rs.getString("ignwps_transection_last_update_date"));
                row.put("state_status", rs.getString("state_status"));
                dataList.add(row);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return dataList;
    }
}