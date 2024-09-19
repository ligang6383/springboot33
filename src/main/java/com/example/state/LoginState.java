package com.example.state;

public class LoginState extends UserState {

    @Override
    public void forward() {
        System.out.println("forward success!");
    }

    @Override
    public void collect() {
        System.out.println("收藏成功！");
    }

    @Override
    public void comment(String comment) {
        System.out.println("评论成功,内容是：" + comment);
    }
}
