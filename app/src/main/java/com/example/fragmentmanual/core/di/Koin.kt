package com.example.fragmentmanual.core.di

import com.example.fragmentmanual.ui.compatibility.CompatibilityViewModel
import com.example.fragmentmanual.ui.information.InformationViewModel
import com.example.fragmentmanual.ui.list.ListViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module


val appModule = module {

}

val dataModule = module {

}

val viewModelModule = module {
    viewModel {
        ListViewModel()
    }
    viewModel {
        CompatibilityViewModel()
    }
    viewModel {
        InformationViewModel()
    }
}