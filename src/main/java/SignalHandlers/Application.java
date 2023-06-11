package SignalHandlers;

import Factories.SignalFactory;
import Signals.Signal;
import org.springframework.beans.factory.annotation.Autowired;
import Algo.Algo;

public class Application implements SignalHandler {
    @Autowired
    SignalFactory factory;

    public void handleSignal(int signal) {
        System.out.println("Getting signal");
        System.out.println("Sygnal is" + signal);
        Signal signal1 = factory.getSignal(signal);
        System.out.println("handle sygnal type is");
        System.out.println(signal1.getClass());
        signal1.executeSignal(new Algo());
    }

}
