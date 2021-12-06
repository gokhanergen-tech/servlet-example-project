package com.servlet.main.Controller.PersonServlets;

import com.servlet.main.Model.Person;
import com.servlet.main.Service.PersonService;
import com.servlet.main.Utils;
import com.servlet.main.Validators.MainValidator;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.*;


public class PersonsServlet extends HttpServlet{

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        resp.setCharacterEncoding("UTF-8");
        resp.setStatus(200);

        String username=req.getParameter("username");
        String password=req.getParameter("password");

        if(MainValidator.isValidPassAndUsername(username,password)){
            System.out.println("Username = "+username+","+"password = "+password);
        }

        List<Person> personList= PersonService.getPersonList();

        StringBuffer stringBuffer=new StringBuffer();
        personList.forEach(p->{
            stringBuffer.append("<tr>" +
                    "<td>"+p.getId()+"</td>" +
                    "<td>"+p.getName()+"</td>" +
                    "<td>"+p.getSurname()+"</td>" +
                    "<td>"+p.getBirthDate().toString()+"</td>" +
                    "<td>"+p.getCity()+"</td>" +
                    "<td>"+p.getCountry()+"</td>" +
                    "</tr>");
        });
        try(PrintWriter printWriter=resp.getWriter()) {
            printWriter.print("<html><head>" +
                    "<meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\" />" +
                    "<style>tr:nth-child(even){background-color:rgba(0,0,0,0.5)} *{font-family:'Times New Roman',Times,herif;}</style>"+
                    "<title>Persons</title>"+
                    "</head><body>" +
                    "<div style='background-color:red;width:100%;height:100%;position:abdolute;display:flex;justify-content:center;'><table style='background-color:white;align-self:center;'>" +
                    "<tr><th>ID</th><th>Ad</th><th>Soyad</th><th>Doğum tarihi</th><th>Şehir</th><th>Ülke</th></tr>"+
                    stringBuffer.toString()+
                            "</table></div>"+
                    "</body></html>");
        }


    }

}
