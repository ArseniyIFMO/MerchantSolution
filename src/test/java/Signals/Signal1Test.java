package Signals;

import Algo.Algo;
import org.junit.jupiter.api.Test;
import org.mockito.InOrder;

import static org.mockito.Mockito.inOrder;
import static org.mockito.Mockito.mock;

public class Signal1Test {

    @Test
    void testExecuteSignal1() {
        Algo algo = mock(Algo.class);
        Signal1 signal1 = new Signal1();
        signal1.executeSignal(algo);

        InOrder inOrder = inOrder(algo);

        inOrder.verify(algo).setAlgoParam(1, 60);
        inOrder.verify(algo).performCalc();
        inOrder.verify(algo).submitToMarket();
        inOrder.verify(algo).doAlgo();

    }
}
