package Signals;

import Algo.Algo;

public class Signal3 implements Signal{

    @Override
    public void executeSignal(Algo algo) {
        algo.setAlgoParam(1,90);
        algo.setAlgoParam(2,15);
        algo.performCalc();
        algo.submitToMarket();
    }

    @Override
    public int getSignalId() {
        return 3;
    }
}
