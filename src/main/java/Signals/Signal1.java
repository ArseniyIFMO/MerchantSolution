package Signals;

import Algo.Algo;

public class Signal1 implements Signal {

    @Override
    public void executeSignal(Algo algo) {
        algo.setAlgoParam(1,60);
        algo.performCalc();
        algo.submitToMarket();
        algo.doAlgo();
    }

    @Override
    public int getSignalId() {
        return 1;
    }

}