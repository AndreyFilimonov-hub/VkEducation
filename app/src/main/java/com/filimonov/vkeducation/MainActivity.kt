package com.filimonov.vkeducation

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.filimonov.vkeducation.ui.theme.VkEducationTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            VkEducationTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Greeting(
                        name = "Vk Education",
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
                    Content(modifier = Modifier.padding(innerPadding))
                }
            }
        }
    }
}

@Composable
fun Content(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        val context = LocalContext.current
        val focusManager = LocalFocusManager.current

        var text by remember { mutableStateOf("") }
        var isError by remember { mutableStateOf(false) }
        var errorText by remember { mutableStateOf("") }

        TextField(
            value = text,
            onValueChange = { newText ->
                isError = false
                errorText = ""
                text = newText
            },
            keyboardOptions = KeyboardOptions(imeAction = ImeAction.Done),
            keyboardActions = KeyboardActions(onDone = { focusManager.clearFocus() }),
            isError = isError,
            supportingText = {
                if (errorText.isNotEmpty()) {
                    Text(errorText)
                }
            }
        )
        Spacer(Modifier.height(16.dp))
        OpenSecondActivityButton(
            onClick = {
                if (text.isNotBlank()) {
                    val intent = Intent(context, SecondActivity::class.java)
                        .apply {
                            putExtra("value", text)
                        }
                    context.startActivity(intent)
                    isError = false
                    errorText = ""
                } else {
                    isError = true
                    errorText = "Введите текст"
                }
            }
        )
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
private fun OpenSecondActivityButton(
    modifier: Modifier = Modifier,
    onClick: () -> Unit
) {
    Button(
        modifier = modifier,
        onClick = onClick
    ) {
        Text("Открыть вторую Activity")
    }
}

}

@Preview(showBackground = true)
@Composable
fun ContentPreview() {
    VkEducationTheme {
        Content()
    }
}