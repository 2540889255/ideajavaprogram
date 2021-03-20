package com.aynu.test.testlanmbda;

public class Show implements ShowService{

    private ShowService target;

    public Show(ShowService showService){

    }

    public Show() {

    }

    @Override
    public void run(){
        if (target != null) {
            target.run();
        }
    };


}
