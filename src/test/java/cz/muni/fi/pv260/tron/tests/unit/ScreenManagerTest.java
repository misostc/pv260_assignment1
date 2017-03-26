package cz.muni.fi.pv260.tron.tests.unit;

import cz.muni.fi.pv260.ScreenManager;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.mockito.Mock;

import java.awt.*;

@RunWith(JUnit4.class)
public class ScreenManagerTest {

    private ScreenManager screenManager = new ScreenManager();

    @Test
    public void DisplayModeMatchInvalidDisplaySize(){
        DisplayMode firstDisplayMode = new DisplayMode(800,600,DisplayMode.BIT_DEPTH_MULTI,DisplayMode.BIT_DEPTH_MULTI);
        DisplayMode secondDisplayMode = new DisplayMode(600,800,DisplayMode.BIT_DEPTH_MULTI,DisplayMode.REFRESH_RATE_UNKNOWN);
        Assert.assertFalse(screenManager.displayModesMatch(firstDisplayMode,secondDisplayMode));
        Assert.assertFalse(screenManager.displayModesMatch(secondDisplayMode,firstDisplayMode));
    }

    @Test
    public void DisplayModeMatchInvalidBitDepth(){
        int width = 600;
        int height = 800;
        int bitDepth = 24;
        DisplayMode modeWithMultiBitDepth = new DisplayMode(width,height,bitDepth,DisplayMode.REFRESH_RATE_UNKNOWN);
        Assert.assertFalse(screenManager.displayModesMatch(new DisplayMode(width,height,
                bitDepth + 1,DisplayMode.REFRESH_RATE_UNKNOWN),modeWithMultiBitDepth));

    }

    @Test
    public void DisplayModeMatchInvalidRefreshRate(){
        int width = 600;
        int height = 800;
        int bitDepth = 24;
        int refreshRate = 60;
        Assert.assertFalse(screenManager.displayModesMatch(
                new DisplayMode(width,height,bitDepth,refreshRate),new DisplayMode(width,height,bitDepth,refreshRate + 1)));
    }

    @Test
    public void DisplayModeMatchValid(){
        DisplayMode dummyDisplayMode = new DisplayMode(1024,768,24,60);
        Assert.assertTrue(screenManager.displayModesMatch(dummyDisplayMode,dummyDisplayMode));
    }

}
