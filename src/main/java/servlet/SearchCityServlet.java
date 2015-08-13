package servlet;

import com.google.gson.Gson;
import com.sun.deploy.net.HttpRequest;
import dao.CityDao;
import daoimpl.CityDaoImpl;
import entity.CityEntity;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.List;

/**
 * Created by ZHANGJA4 on 8/11/2015.
 */
@WebServlet(name = "SearchCityServlet", urlPatterns = {"/SearchCityServlet"})
public class SearchCityServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("SearchCityServlet....");
        System.out.println(request.getMethod());
        String city = "";
//        if ("POST".equals(request.getMethod())) {
//            city = URLDecoder.decode(request.getParameter("city"), "utf-8");
//        } else {
//            city = URLDecoder.decode(request.getParameter("city"), "utf-8");
//        }
        System.out.println("city=" + city);
        //request.setCharacterEncoding("UTF-8");
        city = request.getParameter("city");//注意前段

//        city = URLDecoder.decode(city, "UTF-8");
//        city = URLDecoder.decode(city, "UTF-8");
        if (null != city) {
            CityDao cityDao = new CityDaoImpl();
            List<CityEntity> cityEntityList = cityDao.selectCity(city);
            Gson gson = new Gson();
            String resultJson = gson.toJson(cityEntityList);
            System.out.println(resultJson);
//            resultJson = URLEncoder.encode(resultJson, "UTF-8");
//            response.setContentType("application/json;charset=utf-8");
//            response.setContentType("application/json");
            response.setContentType("charset=utf-8");
            System.out.printf(resultJson);
            PrintWriter out = response.getWriter();
            out.write(resultJson);
            out.flush();
            out.close();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
