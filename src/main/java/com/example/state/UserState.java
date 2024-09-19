package com.example.state;

public abstract class UserState {

    protected AppContext appContext;

    public void setAppContext(AppContext appContext) {
        this.appContext = appContext;
    }

    public abstract void forward();

    public abstract void collect();

    public abstract void comment(String comment);

}
