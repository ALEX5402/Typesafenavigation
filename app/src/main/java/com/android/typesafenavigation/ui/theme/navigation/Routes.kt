package com.android.typesafenavigation.ui.theme.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Home
import androidx.compose.ui.graphics.vector.ImageVector
import kotlinx.serialization.Serializable

sealed class Routes(
     val title : String,
     val icons : ImageVector,
     val destination : Any,
 ) {
    data object Home : Routes(
        title = "Home",
        icons = Icons.Default.Home,
        destination = Main
    )
    data object Messages : Routes(
        title = "Messages",
        icons = Icons.Default.Email,
        destination = Chat
    )
    data object Contacts : Routes(
        title = "Contacts",
        icons = Icons.Default.AccountBox,
        destination = Contact
    )
}

@Serializable
object Main

@Serializable
object Chat

@Serializable
data class Chats(
    val id : Int ,
    val message : String
)

@Serializable
object Contact



