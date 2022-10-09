package com.codecollapse.splashscreenapi

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import com.codecollapse.splashscreenapi.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint
import timber.log.Timber

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    companion object {
        private const val TAG = "MainActivity"
    }

    private val viewBinding by lazy(LazyThreadSafetyMode.NONE){
        ActivityMainBinding.inflate(layoutInflater)
    }

    private val splashViewModel: SplashViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val splashScreen = installSplashScreen()

        // Keep the splash screen visible until get response from api.
        // This approach is best to load some data from api or from local cache.
        splashScreen.apply {
            setKeepOnScreenCondition {
                splashViewModel.splashFakeApiResponse.value.not()
            }

            setOnExitAnimationListener { splashScreenView ->
                Timber.tag(TAG).d("splash screen animation is about to end")
                splashScreenView.remove()
            }
        }

        setContentView(viewBinding.root)
    }
}

/*
Note:
Running application above api 31 from android studio will show white background without icon in splash screen,
so don't worry about that. Close the app recent tray and run the app from launch icon will help you to see the splash icon.
*/
