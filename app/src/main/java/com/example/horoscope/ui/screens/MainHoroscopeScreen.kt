@Composable
fun MainHoroscopeScreen() {
    val tabs = listOf("Сегодня", "Завтра", "Неделя")
    var selectedTab by remember { mutableStateOf(0) }
    
    TabRow(selectedTabIndex = selectedTab) { ... }
    when (selectedTab) {
        0 -> HoroscopeContent("today")
        // ...
    }
}