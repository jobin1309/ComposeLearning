package com.example.jetpackcomposelearning

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.snapping.SnapLayoutInfoProvider
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.jetpackcomposelearning.ui.theme.JetpackComposeLearningTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetpackComposeLearningTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    composeTestTheme()
//                    conversation(SampleDataSet.conversationSample)
                }
            }
        }
    }
}

data class Message(val author: String, val body: String)

@Composable
fun composeTestTheme() {
    Column(Modifier.fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.SpaceEvenly) {
        Surface(
            modifier = Modifier
                .width(300.dp)
                .height(50.dp), color = MaterialTheme.colorScheme.primary
        ) {
        }
//        Spacer(modifier = Modifier.padding(30.dp))

        Surface(
            modifier = Modifier
                .width(300.dp)
                .height(50.dp), color = MaterialTheme.colorScheme.primary
        ) {
        }
        Surface(
            modifier = Modifier
                .width(300.dp)
                .height(50.dp), color = MaterialTheme.colorScheme.primary
        ) {
        }
        Surface(
            modifier = Modifier
                .width(300.dp)
                .height(50.dp), color = MaterialTheme.colorScheme.primary
        ) {
        }

    }
}

@Composable
fun GreetingCard(message: Message) {
    Row(Modifier.padding(all = 4.dp)) {
        Image(
            painter = painterResource(id = R.drawable.todieformodel),
            contentDescription = "Hot model",
            modifier = Modifier
                .size(70.dp)
                .clip(CircleShape)
                .border(1.dp, MaterialTheme.colorScheme.primary, CircleShape)
        )
        Spacer(modifier = Modifier.width(4.dp))

        var isExpanded by remember { mutableStateOf(false) }



        Column(Modifier.clickable { isExpanded = !isExpanded }) {
            Text(
                text = message.author,
                fontSize = 24.sp,
                color = MaterialTheme.colorScheme.secondary,
                style = MaterialTheme.typography.bodyLarge
            )
            Spacer(modifier = Modifier.padding(2.dp))

            Text(
                text = message.body,
                fontSize = 20.sp,
                color = MaterialTheme.colorScheme.secondary,
                maxLines = if (isExpanded) Int.MAX_VALUE else 1
            )
        }
    }
}

@Composable
fun conversation(messages: List<Message>) {
    LazyColumn {
        items(messages) { message ->
            GreetingCard(message)
        }
    }
}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    JetpackComposeLearningTheme {
    }
}