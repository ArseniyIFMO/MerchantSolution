package Signals;

import Algo.Algo;
import org.junit.jupiter.api.Test;
import org.mockito.InOrder;

import static org.mockito.Mockito.inOrder;
import static org.mockito.Mockito.mock;

public class DefaultSignalTest {

    @Test
    void testExecuteSignal2() {
        Algo algo = mock(Algo.class);
        DefaultSignal signal2 = new DefaultSignal();
        signal2.executeSignal(algo);

        InOrder inOrder = inOrder(algo);

        inOrder.verify(algo).cancelTrades();
        inOrder.verify(algo).doAlgo();

    }
}
