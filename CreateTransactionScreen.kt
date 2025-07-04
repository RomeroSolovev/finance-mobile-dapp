@Composable
fun CreateTransactionScreen(navController: NavHostController) {
    var title by remember { mutableStateOf("") }
    var recipient by remember { mutableStateOf("") }
    var amount by remember { mutableStateOf("") }
    var token by remember { mutableStateOf("") }
    var comment by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        Column {
            Text("Создание транзакции", color = AppTheme.TextWhite, style = MaterialTheme.typography.headlineSmall)
            Spacer(modifier = Modifier.height(16.dp))

            OutlinedTextField(value = title, onValueChange = { title = it }, label = { Text("Название операции") }, modifier = Modifier.fillMaxWidth())
            Spacer(modifier = Modifier.height(8.dp))
            OutlinedTextField(value = recipient, onValueChange = { recipient = it }, label = { Text("Адрес получателя") }, modifier = Modifier.fillMaxWidth())
            Spacer(modifier = Modifier.height(8.dp))
            OutlinedTextField(value = amount, onValueChange = { amount = it }, label = { Text("Сумма") }, modifier = Modifier.fillMaxWidth())
            Spacer(modifier = Modifier.height(8.dp))
            OutlinedTextField(value = token, onValueChange = { token = it }, label = { Text("Токен") }, modifier = Modifier.fillMaxWidth())
            Spacer(modifier = Modifier.height(8.dp))
            OutlinedTextField(value = comment, onValueChange = { comment = it }, label = { Text("Комментарий") }, modifier = Modifier.fillMaxWidth())
        }

        Button(
            onClick = { println("Создание транзакции...") },
            colors = ButtonDefaults.buttonColors(containerColor = AppTheme.Primary),
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Создать транзакцию", color = AppTheme.TextWhite)
        }
    }
}