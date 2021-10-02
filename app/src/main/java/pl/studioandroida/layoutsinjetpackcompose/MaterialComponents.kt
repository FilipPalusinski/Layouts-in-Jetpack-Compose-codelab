package pl.studioandroida.layoutsinjetpackcompose

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import pl.studioandroida.layoutsinjetpackcompose.ui.theme.LayoutsInJetpackComposeTheme

class MaterialComponents : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LayoutsInJetpackComposeTheme {
                LayoutsCodelab()
            }
        }
    }
}

@Composable
fun LayoutsCodelab() {
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(text = "LayoutsCodelab")
                },
                actions = {
                    IconButton(onClick = { /* doSomething() */}) {
                        Icon(Icons.Filled.AttachMoney, contentDescription = null)
                    }
                }
            )
        }
    ) { innerPadding ->
        Column(modifier = Modifier.padding(innerPadding)){
         BodyContent(
             Modifier
                 .padding(innerPadding)
                 .padding(8.dp))
        }
    }
}

@Composable
fun BottomNavigation() {
    var selectedItem by remember { mutableStateOf(0)}
    val items = listOf("Songs", "Artists", "Playlists")

    Scaffold(
        bottomBar = {
            BottomNavigation {
                items.forEachIndexed { index, item ->
                    BottomNavigationItem(
                        icon = {
                            when(item) {
                                "Songs" -> Icon(Icons.Filled.LibraryMusic, contentDescription = null)
                                "Artists" -> Icon(Icons.Filled.Album, contentDescription = null)
                                "Playlists" -> Icon(Icons.Filled.PlaylistPlay, contentDescription = null)
                            }},
                        label = { Text(item)},
                        selected = selectedItem == index,
                        onClick = {selectedItem = index}

                    )
                }
            }
        }
    ) { innerPadding ->
        Column(modifier = Modifier.padding(innerPadding)){
            BodyContent(
                Modifier
                    .padding(innerPadding)
                    .padding(8.dp))
        }
    }
}

@Composable
fun NavigationDrawer(){
    Scaffold(
        drawerContent = {Text(text = "drawerContent")},
    ){ innerPadding ->
        Column(modifier = Modifier.padding(innerPadding)){
            BodyContent(
                Modifier
                    .padding(innerPadding)
                    .padding(8.dp))
        }
    }
}

@Composable
fun BodyContent(modifier: Modifier = Modifier) {
//    Column(modifier = modifier/*.padding(8.dp)*/) {
//        Text(text = "Hi there!")
//        Text(text = "Thanks for going through the Layouts codelab")
//    }
    MyOwnColumn(modifier.padding(8.dp)) {
        Text("MyOwnColumn")
        Text("places items")
        Text("vertically.")
        Text("We've done it by hand!")
    }

}

@Preview
@Composable
fun NavigationDrawerPreview() {
    LayoutsInJetpackComposeTheme {
        NavigationDrawer()
    }
}


@Preview
@Composable
fun LayoutsCodelabPreview() {
    LayoutsInJetpackComposeTheme {
        LayoutsCodelab()
    }
}

@Preview
@Composable
fun BottomNavigationPreview() {
    LayoutsInJetpackComposeTheme {
        BottomNavigation()
    }
}