@Composable
fun HoroscopeTabs(viewModel: HoroscopeViewModel = hiltViewModel()) {
    val horoscopes by viewModel.horoscopes.collectAsState()
    var selectedTab by remember { mutableStateOf(0) }
    val tabs = listOf("Сегодня", "Неделя", "Месяц")

    Column {
        TabRow(selectedTabIndex = selectedTab) {
            tabs.forEachIndexed { index, title ->
                Tab(
                    selected = selectedTab == index,
                    onClick = { selectedTab = index },
                    text = { Text(title) }
                )
            }
        }

        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
        ) {
            items(horoscopes) { item ->
                val text = when (selectedTab) {
                    0 -> item.today
                    1 -> item.week
                    else -> item.month
                }
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 4.dp),
                    elevation = CardDefaults.cardElevation(2.dp)
                ) {
                    Text(
                        text = "${item.sign}\n$text",
                        modifier = Modifier.padding(16.dp)
                    )
                }
            }
        }
    }
}