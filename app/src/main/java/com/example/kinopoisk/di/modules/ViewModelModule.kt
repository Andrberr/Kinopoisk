package com.example.kinopoisk.di.modules

import androidx.lifecycle.ViewModel
import com.example.kinopoisk.di.ViewModelKey
import com.example.kinopoisk.ui.dashboard.DashboardViewModel
import com.example.kinopoisk.ui.home.HomeViewModel
import com.example.kinopoisk.ui.notifications.NotificationsViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
interface ViewModelModule {
    @Binds
    @IntoMap
    @ViewModelKey(HomeViewModel::class)
    fun bindHomeViewModel(homeViewModel: HomeViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(DashboardViewModel::class)
    fun bindDashboardViewModel(dashboardViewModel: DashboardViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(NotificationsViewModel::class)
    fun bindNotificationsViewModel(notificationsViewModel: NotificationsViewModel): ViewModel
}