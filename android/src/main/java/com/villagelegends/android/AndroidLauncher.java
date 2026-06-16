package com.villagelegends.android;

import android.os.Bundle;
import android.view.WindowManager;
import android.view.View;
import com.badlogic.gdx.backends.android.AndroidApplication;
import com.badlogic.gdx.backends.android.AndroidApplicationConfiguration;
import com.villagelegends.VillageLegends;

public class AndroidLauncher extends AndroidApplication {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Keep screen on
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);

        // Full immersive mode
        getWindow().getDecorView().setSystemUiVisibility(
            View.SYSTEM_UI_FLAG_FULLSCREEN |
            View.SYSTEM_UI_FLAG_HIDE_NAVIGATION |
            View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY |
            View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN |
            View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION |
            View.SYSTEM_UI_FLAG_LAYOUT_STABLE
        );

        AndroidApplicationConfiguration config = new AndroidApplicationConfiguration();
        
        // Use default settings for these; setting them manually is often what causes compilation errors
        // in newer LibGDX versions.
        config.useAccelerometer = false;
        config.useCompass = false;
        config.useWakelock = true;
        
        initialize(new VillageLegends(), config);
    }
}
