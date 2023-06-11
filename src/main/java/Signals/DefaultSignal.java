package Signals;

import Algo.Algo;

public class DefaultSignal implements Signal{

    public void executeSignal(Algo algo) {
        algo.cancelTrades();
        algo.doAlgo();
    }

    public int getSignalId() {
        return 0;
    }
}

