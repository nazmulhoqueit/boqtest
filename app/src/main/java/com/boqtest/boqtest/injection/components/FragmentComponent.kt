package com.example.boqtest.injection.components

import com.boqtest.boqtest.injection.components.ApplicationComponent
import com.example.boqtest.injection.annotation.PerScreen
import com.example.boqtest.injection.modules.ComponentModule
import com.example.boqtest.injection.modules.FragmentModule
import dagger.Component

/**
 * @author nazmul
 */
@PerScreen
@Component(dependencies = arrayOf(ApplicationComponent::class),
    modules = arrayOf(FragmentModule::class, ComponentModule::class))
interface FragmentComponent {

}