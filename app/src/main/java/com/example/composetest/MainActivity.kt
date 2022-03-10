package com.example.composetest

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.composetest.ui.theme.ComposeTestTheme


data class User(val name : String, val description : String, val text : String)
private var listText = mutableListOf<User>()

class MainActivity : ComponentActivity() {
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val user1 = User("Unai", "Pianista y filántropo", "Hola buenas tardes")
        val user2 = User("Unai", "Pianista y filántropo", "Locooo, mira lo que dijo ElXOCAS, esta loco este hombre, se puso a decir que un seguidor le había dicho roscilla, roscilla jajajajam, es que es buenísimo, el se enfado y empezó a decirle de todo como siempre.")
        val user3 = User("Unai", "Pianista y filántropo", "Otro mensaje mas para probar si esto funciona, afdkasfjasifjasofasfjasfasfafjaifiqejfiefjeifjeifeifwqjfrwefwfj")
        val user4 = User("Unai", "Pianista y filántropo", "Otro mensaje mas para probar si esto funciona, afdkasfjasifjasofasfjasfasfafjaifiqejfiefjeifjeifeifwqjfrwefwfj")
        val user5 = User("Unai", "Pianista y filántropo", "Otro mensaje mas para probar si esto funciona, afdkasfjasifjasofasfjasfasfafjaifiqejfiefjeifjeifeifwqjfrwefwfj")
        val user6 = User("Unai", "Pianista y filántropo", "Otro mensaje mas para probar si esto funciona, afdkasfjasifjasofasfjasfasfafjaifiqejfiefjeifjeifeifwqjfrwefwfj")
        val user7 = User("Unai", "Pianista y filántropo", "Otro mensaje mas para probar si esto funciona, afdkasfjasifjasofasfjasfasfafjaifiqejfiefjeifjeifeifwqjfrwefwfj")
        val user8 = User("Unai", "Pianista y filántropo", "Otro mensaje mas para probar si esto funciona, afdkasfjasifjasofasfjasfasfafjaifiqejfiefjeifjeifeifwqjfrwefwfj")
        val user9 = User("Unai", "Pianista y filántropo", "Otro mensaje mas para probar si esto funciona, afdkasfjasifjasofasfjasfasfafjaifiqejfiefjeifjeifeifwqjfrwefwfj")

        listText.add(user1)
        listText.add(user2)
        listText.add(user3)
        listText.add(user4)
        listText.add(user5)
        listText.add(user6)
        listText.add(user7)
        listText.add(user8)
        listText.add(user9)

        setContent {
            ComposeTestTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                    showConversation(list = listText)
                }
            }
        }
    }
}

@Composable
fun showChat(name: String, description : String, text : String){
    Row(modifier = Modifier.padding(all = 8.dp)){
        Image(
            painter = painterResource(R.drawable.unai),
            contentDescription = "Chat user",
            modifier = Modifier
                .size(40.dp)
                .clip(CircleShape)
                .border(1.5.dp, MaterialTheme.colors.secondary, CircleShape)

        )
        Spacer(modifier = Modifier.width(8.dp))
        var isExpanded by remember { mutableStateOf(false) }

        Column(modifier = Modifier.clickable { isExpanded = !isExpanded }){
            Text(name)
            Spacer(modifier = Modifier.height(4.dp))
            Text(description)
            Spacer(modifier = Modifier.height(8.dp))

            Surface(
                shape = MaterialTheme.shapes.medium,
                elevation = 1.dp,
            ){
                Text(text = text,
                    modifier = Modifier.padding(all = 4.dp),
                    maxLines = if (isExpanded) Int.MAX_VALUE else 1,
                    style = MaterialTheme.typography.body2)
            }
        }
    }
}

@Composable
fun showConversation(list : List<User>){
    LazyColumn {
        items(list){
            showChat(it.name, it.description, it.text)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ComposeTestTheme {
        showConversation(list = listText)
    }
}