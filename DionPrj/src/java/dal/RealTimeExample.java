/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;


import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class RealTimeExample {
    public static void main(String[] args) {
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String formattedDateTime = now.format(formatter);
        System.out.println("Current Date and Time: " + formattedDateTime);
    }
}


//
//LocalDateTime now = LocalDateTime.now();
//            Timestamp timestamp = Timestamp.valueOf(now);
//            pstmt.setTimestamp(2, timestamp);