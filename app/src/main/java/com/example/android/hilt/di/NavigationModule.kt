package com.example.android.hilt.di

import com.example.android.hilt.navigator.AppNavigator
import com.example.android.hilt.navigator.AppNavigatorImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent

//The DatabaseModule module is installed in the ApplicationComponent, so that the bindings are available in the application container. Our new navigation information (i.e. AppNavigator) needs information specific from the Activity (as AppNavigatorImpl has an Activity as a dependency).
// Therefore, it must be installed in the Activity container instead of the Application container since that's where information about the Activity is available.
@InstallIn(ActivityComponent::class)
@Module
abstract class NavigationModule {

    @Binds
    abstract fun bindNavigator(impl: AppNavigatorImpl): AppNavigator
}