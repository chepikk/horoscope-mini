package com.horoscope.mini.presentation.main

import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.rememberPagerState

@OptIn(ExperimentalPagerApi::class)
@Composable
fun HoroscopeTabs() {
    val pagerState = rememberPagerState()
    val scope = rememberCoroutineScope()
    val tabs = listOf("Сегодня", "Завтра", "Неделя")

    TabRow(selectedTabIndex = pagerState.currentPage) {
        tabs.forEachIndexed { index, title ->
            Tab(
                text = { Text(title) },
                selected = pagerState.currentPage == index,
                onClick = { /* TODO: переключение табов */ }
            )
        }
    }

    HorizontalPager(
        count = tabs.size,
        state = pagerState
    ) { page ->
        // TODO: контент табов
        Text(text = "Гороскоп: ${tabs[page]}")
    }
}