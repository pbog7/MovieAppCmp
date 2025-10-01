package com.example.homescreen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.example.core.ActionState
import com.example.core.appLogger
import com.example.domain.models.ExampleModel
import org.koin.compose.viewmodel.koinViewModel

@Composable
fun HomeScreen(
    viewModel: HomeViewModel = koinViewModel()
) {
    val state by viewModel.viewState.collectAsState()
    val onClick = remember { { viewModel.getExamples() } }
    appLogger.i { "Home Screen composition" }
    Column(
        Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        ExampleText(examples = state.examples, getExamples = onClick)
        OtherText(otherText = state.otherText, updateOtherText = { viewModel.updateOtherText() })
    }

}


@Composable
fun ExampleText(examples: ActionState<List<ExampleModel>>, getExamples: () -> Unit) {
    val onClick = remember { getExamples }
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Button(onClick = { onClick() }) {
            Text("Get Examples")
        }
        Text(
            text = examples.data?.first()?.example ?: "",
            style = MaterialTheme.typography.titleLarge
        )
    }
}


@Composable
fun OtherText(otherText: String, updateOtherText: () -> Unit) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Button(onClick = { updateOtherText() }) {
            Text("Update OtherText")
        }
        Text(text = otherText, style = MaterialTheme.typography.titleLarge)
    }
}