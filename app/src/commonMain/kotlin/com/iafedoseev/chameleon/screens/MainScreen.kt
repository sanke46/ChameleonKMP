package com.iafedoseev.chameleon.screens

import androidx.compose.foundation.layout.RowScope
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.tab.CurrentTab
import cafe.adriel.voyager.navigator.tab.LocalTabNavigator
import cafe.adriel.voyager.navigator.tab.Tab
import cafe.adriel.voyager.navigator.tab.TabNavigator
import cafe.adriel.voyager.navigator.tab.TabOptions

object HomeTab : Tab {
    override val options: TabOptions
        @Composable
        get() {
            val title = "Home"
            val icon = rememberVectorPainter(Icons.Default.Home)
            
            return remember {
                TabOptions(
                    index = 0u,
                    title = title,
                    icon = icon
                )
            }
        }
    
    @Composable
    override fun Content() {
        HomeScreen().Content()
    }
}

object NetworkTab : Tab {
    override val options: TabOptions
        @Composable
        get() {
            val title = "Network"
            val icon = rememberVectorPainter(Icons.Default.Settings)
            
            return remember {
                TabOptions(
                    index = 2u,
                    title = title,
                    icon = icon
                )
            }
        }
    
    @Composable
    override fun Content() {
        NetworkScreen().Content()
    }
}

class MainScreen : Screen {
    @Composable
    override fun Content() {
        TabNavigator(HomeTab) {
            Scaffold(
                bottomBar = {
                    NavigationBar {
                        TabNavigationItem(HomeTab)
                        TabNavigationItem(NetworkTab)
                    }
                }
            ) {
                CurrentTab()
            }
        }
    }
}

@Composable
private fun RowScope.TabNavigationItem(tab: Tab) {
    val tabNavigator = LocalTabNavigator.current
    
    NavigationBarItem(
        selected = tabNavigator.current == tab,
        onClick = { tabNavigator.current = tab },
        label = { Text(tab.options.title) },
        icon = { Icon(painter = tab.options.icon!!, contentDescription = tab.options.title) }
    )
}