@Composable
fun TransactionDetailScreen(transactionId: Int) {
    val sampleTransactions = listOf(
        Transaction("Перевод", "0x123...DEF", "0.1 ETH", "ETH", "2025-07-04 14:23"),
        Transaction("Получение", "0x456...ABC", "0.25 ETH", "ETH", "2025-07-03 10:17")
    )
    val transaction = sampleTransactions.getOrNull(transactionId)

    transaction?.let {
        Column(modifier = Modifier.padding(16.dp)) {
            Text("Название: ${it.title}", color = AppTheme.TextWhite)
            Text("Адрес: ${it.address}", color = AppTheme.TextWhite)
            Text("Сумма: ${it.amount}", color = AppTheme.TextWhite)
            Text("Токен: ${it.token}", color = AppTheme.TextWhite)
            Text("Дата и время: ${it.date}", color = AppTheme.TextWhite)
        }
    } ?: run {
        Text("Транзакция не найдена", color = AppTheme.TextWhite)
    }
}