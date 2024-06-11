package com.android.typesafenavigation

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
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
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import com.android.typesafenavigation.ui.Bottombar
import com.android.typesafenavigation.ui.theme.TypesafenavigationTheme
import com.android.typesafenavigation.ui.theme.navigation.Chat
import com.android.typesafenavigation.ui.theme.navigation.Chats
import com.android.typesafenavigation.ui.theme.navigation.Contact
import com.android.typesafenavigation.ui.theme.navigation.Main
import com.android.typesafenavigation.ui.theme.navigation.Routes

class MainActivity : ComponentActivity() {
    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            TypesafenavigationTheme {
                val navHostController = rememberNavController()

                Scaffold(modifier = Modifier.fillMaxSize(),
                    bottomBar = {
                        Bottombar(navHostController = navHostController)
                    }
                ) {internalPadding->
                    NavHost(navController = navHostController ,  startDestination = Routes.Home.destination){
                        composable<Main> {
                            Testcomp("main")
                        }

                        composable<Chat> {
                            var text by remember {
                                mutableStateOf("hello world")
                            }
                            Box(modifier = Modifier.fillMaxSize(),
                                contentAlignment = Alignment.Center
                                ){
                                Column {
                                    TextField(value = text, onValueChange = {
                                        text = it
                                    })
                                    Button(onClick = {
                                        navHostController.navigate(
                                            Chats(
                                                id = 234,
                                                message = text
                                            )
                                        )
                                    }) {

                                        Text(text = "button")
                                    }
                                }
                            }
                        }
                        composable<Chats> {
                            val arguments = it.toRoute<Chats>()
                            Testcomp("chatid ${arguments.id} message : ${arguments.message}")
                        }
                        composable<Contact> {
                            Testcomp("Contact")

                        }
                    }

                }
            }
        }
    }
}

@Composable
fun Testcomp(demo : String) {
    Box(modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ){
        Text(text = demo)
    }

}
