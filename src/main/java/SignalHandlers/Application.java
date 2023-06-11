package SignalHandlers;

import Factories.SignalFactory;
import Signals.Signal;
import org.springframework.beans.factory.annotation.Autowired;
import Algo.Algo;
import org.springframework.stereotype.Component;

@Component
public class Application implements SignalHandler {
    @Autowired
    SignalFactory factory;

    public void handleSignal(int signal) {
        System.out.println("Getting signal");
        System.out.println("Signal is" + signal);
        Signal signal1 = factory.getSignal(signal);
        if(signal1 != null)
            signal1.executeSignal(new Algo());
    }

}
