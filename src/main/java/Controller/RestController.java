package Controller;

import SignalHandlers.Application;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
class RestController {

    @Autowired
    Application application;

    @PostMapping("/main/{signal}")
    public String main3(@PathVariable String signal) {
        try {
            int x = Integer.valueOf(signal);
            application.handleSignal(x);
            return "OK";
        }
        catch (NumberFormatException e) {
            return "Invalid integer";
        }
        catch (Exception e) {
            return "Error";
        }
    }

}

