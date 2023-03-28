package Commencis.step_def;

import Commencis.utils.Drivers;
import io.cucumber.java.After;
import io.cucumber.java.Before;

import java.time.Duration;

public class Hooks {
    @Before
    public void setUp() {
        Drivers.get().manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        Drivers.get().manage().window().maximize();
    }

    @After
    public void tearDown() {
        Drivers.closeDriver();
    }
}
