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
        System.out.println("Sygnal is" + signal);
        Signal signal1 = factory.getSignal(signal);
        signal1.executeSignal(new Algo());
    }

}
