package Signals;

import Algo.Algo;
import org.junit.jupiter.api.Test;
import org.mockito.InOrder;

import static org.mockito.Mockito.inOrder;
import static org.mockito.Mockito.mock;

public class Signal2Test {
    @Test
    void testExecuteSignal2() {
        Algo algo = mock(Algo.class);
        Signal2 signal2 = new Signal2();
        signal2.executeSignal(algo);

        InOrder inOrder = inOrder(algo);

        inOrder.verify(algo).reverse();
        inOrder.verify(algo).setAlgoParam(1, 80);
        inOrder.verify(algo).submitToMarket();
        inOrder.verify(algo).doAlgo();

    }
}
