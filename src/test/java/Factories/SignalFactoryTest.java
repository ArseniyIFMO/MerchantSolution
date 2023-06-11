package Factories;

import Signals.DefaultSignal;
import Signals.Signal;
import Signals.Signal1;
import org.junit.jupiter.api.Test;
import org.reflections.Reflections;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.assertj.core.api.Assertions.assertThat;

public class SignalFactoryTest {
    // Assert that every added algorithm has unique Ids
    @Test
    public void assertUniqueId() {
        Set<Integer> idClassSet = new HashSet<>();

        Reflections reflections = new Reflections("Signals");
        Set<Class<? extends Signal>> classes;
        classes = reflections.getSubTypesOf(Signal.class);

        for (Class t : classes) {
            try {
                Signal sig = (Signal) t.getConstructor().newInstance();
                assertTrue(idClassSet.add(sig.getSignalId()));
            } catch (Exception e) {

            }
        }

        assertEquals(idClassSet.size(), 4);
    }

    // Assert that signal factory produce necessary
    @Test
    public void testGetSignal() {
        SignalFactory factory = new SignalFactory();
        Signal signal1 = factory.getSignal(1);
        assertThat(signal1).isInstanceOf(Signal1.class);

        Signal signal2 = factory.getSignal(100);
        assertThat(signal2).isInstanceOf(DefaultSignal.class);
    }
}
