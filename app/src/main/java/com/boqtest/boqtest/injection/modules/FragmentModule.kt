package com.example.boqtest.injection.modules

import android.content.Context
import androidx.fragment.app.Fragment
import dagger.Module
import dagger.Provides

/**
 * @author nazmul
 */
@Module
class FragmentModule(private val fragment: Fragment) {

    @Provides
    fun provideContext(): Context = fragment.context!!
}