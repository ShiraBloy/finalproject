package com.example.ex4.controller;

import com.sendgrid.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import javax.servlet.http.HttpSession;
import javax.swing.text.AbstractDocument;
import javax.validation.constraints.Email;
import java.io.IOException;

@Controller
public class ForgotPasswordController {

    public String sendEmail(Model model, HttpSession httpSession, String[] args) throws IOException{
        Email from = new Email("finalprojecttest22@gmail.com");
        String subject = "Password recovery";
        Email to = new Email("finalprojecttest22@gmail.com");
        Content content = new Content("bla bla");
        Mail mail= new Mail(from, subject, to, content);

        SendGrid sg = new SendGrid(System.getenv("SENDGRID_API_KEY"));
        Request request = new Request();

        try {
            request.setMethod(Method.POST);
            request.setEndpoint("mail/send");
            request.setBody(mail.build());
            Response response = sg.api(request);
            System.out.println(response.getStatusCode());
            System.out.println(response.getBody());
            System.out.println(response.getHeaders());
        } catch (IOException ex) {
            throw ex;
        }
        return "jj";

    }
}
