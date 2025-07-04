@Composable
fun HomeScreen(navController: NavHostController) {
    val walletAddress = remember { mutableStateOf("0xABC...123") }
    val balance = remember { mutableStateOf("0.00 ETH") }
    val transactions = remember { mutableStateListOf(
        "Перевод на 0x123...DEF — 0.1 ETH",
        "Получено от 0x456...ABC — 0.25 ETH"
    ) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
            .verticalScroll(rememberScrollState()),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("Кошелек: ${walletAddress.value}", color = AppTheme.TextWhite)
        Spacer(modifier = Modifier.height(16.dp))
        Text("Баланс", color = AppTheme.TextWhite)
        Text(balance.value, color = AppTheme.Primary, style = MaterialTheme.typography.displaySmall)

        Spacer(modifier = Modifier.height(32.dp))
        Text("Последние транзакции", color = AppTheme.TextWhite)
        Spacer(modifier = Modifier.height(8.dp))
        transactions.forEachIndexed { index, tx ->
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 4.dp)
                    .clickable { navController.navigate("transactionDetail/$index") },
                colors = CardDefaults.cardColors(containerColor = Color.DarkGray)
            ) {
                Text(
                    text = tx,
                    modifier = Modifier.padding(12.dp),
                    color = AppTheme.TextWhite
                )
            }
        }
    }
}