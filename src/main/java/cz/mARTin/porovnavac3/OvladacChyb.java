package cz.mARTin.porovnavac3;
import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.boot.web.servlet.error.ErrorController;

@Controller
public class OvladacChyb implements ErrorController {

    @RequestMapping("/error")
    public String handleError(HttpServletRequest request, Model model) {
        Object status = request.getAttribute(RequestDispatcher.ERROR_STATUS_CODE);

        if (status != null) {
            Integer statusCode = Integer.valueOf(status.toString());
            if(statusCode == HttpStatus.NOT_FOUND.value()) {
                return "chyba404";
            } else if(statusCode == HttpStatus.INTERNAL_SERVER_ERROR.value()) {
                Throwable throwable = (Throwable) request.getAttribute(RequestDispatcher.ERROR_EXCEPTION);
                model.addAttribute("exception", throwable.getCause().getMessage());
                return "chyba500";
            } else if(statusCode == HttpStatus.BAD_REQUEST.value()){
                return "chyba400";
            }
        }
        return "error";
    }


    public String getErrorPath() {
        return "/error";
    }

}
