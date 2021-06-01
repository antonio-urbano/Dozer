package stateStore;

import engine.CurrentAgent;

public interface SeraphStateStore {

    void writeState(String channel, CurrentAgent message);
    void subscribeChannel(String channel);
}
