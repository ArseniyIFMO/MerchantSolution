package Signals;

import Algo.Algo;

public class Signal2 implements Signal{

    @Override
    public void executeSignal(Algo algo) {
        algo.reverse();
        algo.setAlgoParam(1,80);
        algo.submitToMarket();
        algo.doAlgo();
    }

    @Override
    public int getSignalId() {
        return 2;
    }
}

