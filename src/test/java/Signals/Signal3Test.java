package Signals;

import Algo.Algo;
import org.junit.jupiter.api.Test;
import org.mockito.InOrder;

import static org.mockito.Mockito.inOrder;
import static org.mockito.Mockito.mock;

public class Signal3Test {

    @Test
    void testExecuteSignal3() {
        Algo algo = mock(Algo.class);
        Signal3 signal3 = new Signal3();
        signal3.executeSignal(algo);

        InOrder inOrder = inOrder(algo);

        inOrder.verify(algo).setAlgoParam(1,90);
        inOrder.verify(algo).setAlgoParam(2,15);
        inOrder.verify(algo).performCalc();
        inOrder.verify(algo).submitToMarket();

    }
}
