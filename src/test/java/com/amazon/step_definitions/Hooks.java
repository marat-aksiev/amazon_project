package com.amazon.step_definitions;

import com.amazon.utilities.Driver;
import org.junit.After;

public class Hooks {

    @After
    public static void teardown(){
        Driver.closeDriver();
    }

}
