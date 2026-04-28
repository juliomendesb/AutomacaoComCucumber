package br.com.nttdata.hooks;

import br.com.nttdata.support.DriverManager;
import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hooks {

    @Before()
    public void beforScenario(){
        DriverManager.initDriver();
    }

    @After()
    public void afterScenario(){
        DriverManager.quitDriver();
    }
}
