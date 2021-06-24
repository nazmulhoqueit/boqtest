package com.example.boqtest.injection.components

import com.boqtest.boqtest.injection.components.ApplicationComponent
import com.example.boqtest.injection.annotation.PerService
import dagger.Component

/**
 * @author nazmul
 */
@PerService
@Component(dependencies = arrayOf(ApplicationComponent::class))
interface ServiceComponent {

}