package cn.bikan8.controller;





import cn.bikan8.util.DescribeCaptchaResult;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author lenovo
 */
@Controller
public class TCodeController extends HttpServlet {

    @ResponseBody
    @RequestMapping("/admin/TCode")
    public String tcode(String ticket, String randstr) {

        System.out.println(ticket);
        System.out.println(randstr);
        DescribeCaptchaResult describeCaptchaResult = new DescribeCaptchaResult();

        if (describeCaptchaResult.codeResponse(ticket,randstr)){
             return "ok";
        }else{
            return "fail";
        }



    }


}
