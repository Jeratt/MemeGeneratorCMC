package ru.msu.cmc.memedb.presentation

import android.os.Bundle
import androidx.activity.OnBackPressedCallback
import androidx.appcompat.app.AppCompatActivity
import ru.msu.cmc.memedb.R
import ru.msu.cmc.memedb.presentation.list.FragmentMemeList


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if(savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .add(R.id.fmt_container, FragmentMemeList())
                .commit()
        }

        onBackPressedDispatcher.addCallback(
            this,  // LifecycleOwner
            object : OnBackPressedCallback(true) {
                override fun handleOnBackPressed() {
                    if(supportFragmentManager.fragments.size > 1){
                        supportFragmentManager.popBackStack()
                    }else{
                        finish()
                    }
                }
            }
        )
    }
}