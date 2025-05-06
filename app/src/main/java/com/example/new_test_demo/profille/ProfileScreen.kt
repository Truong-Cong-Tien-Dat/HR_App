package com.example.new_test_demo.profille

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun ProfileScreen(viewModel: ProfileViewModel = viewModel(), modifier: Modifier) {
    val isEditing = viewModel.isEditing.value

    if (isEditing) {
        ProfileEditForm(viewModel)
    } else {
        ProfileDisplay(viewModel)
    }
}

@Composable
fun ProfileDisplay(x0: ProfileViewModel) {
    TODO("Not yet implemented")
}
