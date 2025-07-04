@Composable
fun WalletsScreen(navController: NavHostController) {
    val wallets = remember { mutableStateListOf("MetaMask Wallet 1") }
    var newWalletName by remember { mutableStateOf("") }
    var showAddDialog by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Text("Ваши кошельки", color = AppTheme.TextWhite, style = MaterialTheme.typography.headlineSmall)
        Spacer(modifier = Modifier.height(16.dp))

        wallets.forEach { name ->
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 4.dp),
                colors = CardDefaults.cardColors(containerColor = Color.DarkGray)
            ) {
                Text(name, modifier = Modifier.padding(12.dp), color = AppTheme.TextWhite)
            }
        }

        Spacer(modifier = Modifier.height(24.dp))
        Button(
            onClick = { showAddDialog = true },
            colors = ButtonDefaults.buttonColors(containerColor = AppTheme.Primary)
        ) {
            Text("Добавить кошелек", color = AppTheme.TextWhite)
        }
    }

    if (showAddDialog) {
        AlertDialog(
            onDismissRequest = { showAddDialog = false },
            confirmButton = {
                Column(modifier = Modifier.fillMaxWidth().padding(16.dp)) {
                    OutlinedTextField(
                        value = newWalletName,
                        onValueChange = { newWalletName = it },
                        label = { Text("Название кошелька") },
                        modifier = Modifier.fillMaxWidth()
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                    Button(
                        onClick = {
                            wallets.add(newWalletName)
                            WalletConnectManager.authorize()
                            showAddDialog = false
                            newWalletName = ""
                        },
                        colors = ButtonDefaults.buttonColors(containerColor = AppTheme.Primary),
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Text("Авторизоваться через MetaMask", color = AppTheme.TextWhite)
                    }
                }
            },
            title = { Text("Добавить кошелек", color = AppTheme.TextWhite) },
            containerColor = Color(0xFF10131A),
            titleContentColor = AppTheme.TextWhite
        )
    }
}