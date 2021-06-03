package stateStore;

import engine.CurrentAgent;

/**
 * Custom state store for writing and reading the current agent of the pipeline
 */
public interface SeraphStateStore {
    void writeState(String channel, CurrentAgent message);
    void readState(String channel);
}
