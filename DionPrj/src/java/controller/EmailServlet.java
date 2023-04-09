/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.util.Properties;
import java.util.Timer;
import java.util.TimerTask;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import model.Tool;
import model.User;

/**
 *
 * @author diond
 */
@WebServlet(name = "EmailServlet", urlPatterns = {"/email"})
public class EmailServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

//
//        String a = (String) request.getAttribute("mis");
//        PrintWriter out = response.getWriter();
//        out.println("<h1>" + a + "</h1>");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id = 9999999;
        try {
            id = (int) request.getAttribute("id");
            String email = (String) request.getAttribute("email");
            System.out.println("id: " + id);
            System.out.println("mail: " + email);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        HttpSession sessionC = request.getSession();
        String s = Tool.createString(8);
        sessionC.setAttribute("codeVerify", s);
        //xóa code sau 2 phút
        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {
                sessionC.removeAttribute("codeVerify");
            }
        }, 120000);

        String newPass = (String) request.getAttribute("newPass");
        String emailRePass = (String) request.getAttribute("emailRePass");

        //mail----------------------------------------------------------------------------
        final String username = "dazsingapore48@gmail.com";
        final String password = "milorwilwctcdstk";
        String targetMail = "phisics0@gmail.com";
        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");
        Session session = Session.getInstance(
                props, new javax.mail.Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }
        });
        System.out.println("successfull mail");
        try {

            Message message = new MimeMessage(session);
            if (newPass != null) {
                message.setSubject("New PassWord");
                message.setText("Your new password is: " + newPass);
                targetMail = emailRePass;
            } else {
                message.setText("Please click the following link to verify your email "
                        + "address: http://localhost:9999/dionprj/setactive?id=" + id + "&codeVerify=" + s);
            }
            message.setFrom(new InternetAddress(username));
            message.setRecipients(Message.RecipientType.TO,
                    InternetAddress.parse(targetMail));
            message.setSubject("Email Verification");

            Transport.send(message);

            System.out.println("Email sent successfully.");

        } catch (MessagingException e) {
            System.out.println(e.getMessage());

            throw new RuntimeException(e);
        }
        //mail----------------------------------------------------------------------------

        response.setContentType(
                "text/html");
        PrintWriter out = response.getWriter();

        out.println("<html><head>");
        out.println("<title>Email Verification</title>");
        out.println("</head><body>");
        out.println("</head><body>");
        if (newPass != null) {
            out.println("<h3>Your new password has been send!</h3>");
            out.println("<h1>Please check your email and login again !.</h1>");
            out.println("<a href=\"http://localhost:9999/dionprj\">HOME</a>");
        } else {
            out.println("<h3>Email Verification Sent</h3>");
            out.println("<h1>Please check your email and click the verification link to complete the process.</h1>");
        }
        out.println("</body></html>");
    }

}
