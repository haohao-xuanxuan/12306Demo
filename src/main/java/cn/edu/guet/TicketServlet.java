package cn.edu.guet;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;

public class TicketServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("余票查询");
        request.setCharacterEncoding("UTF-8");
        String toStation=request.getParameter("toStation");
        String departureData=request.getParameter("departureData");
        String fromStation=request.getParameter("fromStation");

       String allTicket =  TicketSearch.search(fromStation,toStation,departureData);
        response.setContentType("application/json;charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.print(allTicket);
        out.flush();
        out.close();
//        System.out.println(fromStation);
//        System.out.println(departureData);
//        System.out.println(toStation);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    doGet(request,response);
    }
}
