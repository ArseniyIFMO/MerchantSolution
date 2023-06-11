package Controller;

import SignalHandlers.Application;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
class SignalController {

    @Autowired
    Application application;

    @PostMapping("/main/{signal}")
    public String main(@PathVariable String signal) {
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

