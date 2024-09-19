package com.example.state;

public class AppContext {

    public static final UserState LOGIN_STATE = new LoginState();

    public static final UserState UNLOGIN_STATE = new UnLoginState();

    private UserState currentState = UNLOGIN_STATE;

    {
        UNLOGIN_STATE.setAppContext(this);
        LOGIN_STATE.setAppContext(this);
    }

    public void setState(UserState state) {
        this.currentState = state;
        this.currentState.setAppContext(this);
    }

    public UserState getState() {
        return this.currentState;
    }

    public void forward() {
        this.currentState.forward();
    }

    public void collect() {
        this.currentState.collect();
    }

    public void comment(String comment) {
        this.currentState.comment(comment);
    }

}

