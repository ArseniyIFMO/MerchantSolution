package Factories;

import Signals.Signal;
import org.junit.jupiter.api.Test;
import org.reflections.Reflections;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class SignalFactoryTest {
    // Assert that every added alghorithm has unique Ids
    @Test
    public void assertUniqueId() {
        Set<Integer> idClassSet = new HashSet<>();

        Reflections reflections = new Reflections("MerchantSolutions");
        Set<Class<? extends Signal>> classes;
        classes = reflections.getSubTypesOf(Signal.class);

        for (Class t : classes) {
            try {
                Signal sig = (Signal) t.getConstructor().newInstance();
                assertTrue(idClassSet.add(sig.getSignalId()));
            } catch (Exception e) {

            }
        }
    }
}
