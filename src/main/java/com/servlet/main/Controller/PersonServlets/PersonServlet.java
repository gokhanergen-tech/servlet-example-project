package com.servlet.main.Controller.PersonServlets;

import com.servlet.main.Model.Person;
import com.servlet.main.Service.PersonService;
import com.servlet.main.Utils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.Map;

public class PersonServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        resp.setStatus(200);

        Map<String,String> body= Utils.parseJSON(req.getReader());

        PersonService.addPerson(new Person(Utils.generateRandomId(),body.get("name"),
                    body.get("surname"),
                    LocalDate.parse(body.get("birth_date")),
                    body.get("city"),
                    body.get("country")));

    }
}
