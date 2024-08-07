package com.erick.apppasteleria.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
//noinspection UsingMaterialAndMaterial3Libraries
import androidx.compose.material.LeadingIconTab
import androidx.compose.material.TabRow
import androidx.compose.material.TabRowDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.erick.apppasteleria.ui.navigation.Destinations2
import com.erick.apppasteleria.ui.navigation.Tabs_items
import com.erick.apppasteleria.ui.navigation.Tabs_items.*
import com.erick.apppasteleria.ui.theme.Menu1
import com.erick.apppasteleria.ui.theme.Menu2
import com.erick.apppasteleria.ui.theme.Menu3
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.PagerState
import com.google.accompanist.pager.pagerTabIndicatorOffset
import com.google.accompanist.pager.rememberPagerState
import kotlinx.coroutines.launch


@OptIn(ExperimentalPagerApi::class)
@Composable
fun TopMenu(navController: NavHostController) {
    val tabs = listOf(
        Home_item,
        Favorito_item,
        Perfil_item

    )
    val pagerState = rememberPagerState()

    Column {
        Tabs(tabs, pagerState, navController)
        Tabs_content(tabs, pagerState, navController)
    }

}

@OptIn(ExperimentalPagerApi::class)
@Composable
fun Tabs(tabs: List<Tabs_items>, pagerState: PagerState, navController: NavHostController) {
    val scope = rememberCoroutineScope()

    TabRow(selectedTabIndex = pagerState.currentPage, indicator = { tabPositions ->
        TabRowDefaults.Indicator(
            Modifier.pagerTabIndicatorOffset(pagerState, tabPositions), color = Menu1
        )
    }
    ) {
        tabs.forEachIndexed { index, tabsItems ->

            val selected = pagerState.currentPage == index
            val backgroundcolor = if (selected) Menu2 else Menu3
            val contentcolor = if (selected) Color.White else Color.Black

            LeadingIconTab(
                selected = selected,
                onClick = {
                    scope.launch {
                        pagerState.animateScrollToPage(index)
                    }
                },
                text = { Text(tabsItems.title, color = contentcolor) },
                icon = {
                    Icon(
                        imageVector = tabsItems.icon,
                        contentDescription = "",
                        tint = contentcolor
                    )
                }, modifier = Modifier
                    .background(color = backgroundcolor)
                    .padding(5.dp)
            )
        }
    }

}

@OptIn(ExperimentalPagerApi::class)
@Composable
fun Tabs_content(tabs: List<Tabs_items>, pagerState: PagerState, navController: NavHostController) {
    HorizontalPager(state = pagerState, count = tabs.size) { page ->
        tabs[page].screen(navController)

    }
}

@Composable
fun NavigationBar(navController: NavHostController, items: List<Destinations2>) {

    val currentRoute = currentRopute(navController)

    BottomNavigation {
        items.forEach { screen ->
            BottomNavigationItem(
                selected = currentRoute == screen.route,
                onClick = {
                    navController.navigate(screen.route){
                        popUpTo(navController.graph.findStartDestination().id){
                            saveState = true
                        }

                        launchSingleTop = true
                    }
                },
                icon = { Icon(imageVector = screen.icon, contentDescription = "") },
                label = { Text(screen.title) },
                alwaysShowLabel = false

            )

        }
    }

}

@Composable
private fun currentRopute(navController: NavHostController): String? {
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    return navBackStackEntry?.destination?.route
}