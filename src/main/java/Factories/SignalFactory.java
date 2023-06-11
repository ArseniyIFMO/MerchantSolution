package Factories;


import Signals.Signal;
import org.reflections.Reflections;
import org.springframework.stereotype.Service;


import java.util.HashMap;
import java.util.Map;
import java.util.Set;

@Service
public class SignalFactory {
    Map<Integer, Class> idClassMap;

    public SignalFactory() {
        idClassMap = new HashMap<>();


        Reflections reflections = new Reflections("Signals");
        Set<Class<? extends Signal>> classes;
        classes = reflections.getSubTypesOf(Signal.class);

        for (Class t : classes) {
            try {
                Signal sig = (Signal) t.getConstructor().newInstance();
                idClassMap.put(sig.getSignalId(), t);
            } catch (Exception e) {

            }
        }
    }

    public Signal getSignal(int signalId) {
        Signal signal = null;
        try {
            signal = (Signal) idClassMap.get(signalId).getConstructor().newInstance();
            if (signal != null)
                System.out.println("Succesfully get signal");
            else
                System.out.println("Get Sygnal null");
        } catch (Exception e) {

        }
        return signal;
    }
}
