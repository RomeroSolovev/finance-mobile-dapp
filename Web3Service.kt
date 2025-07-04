object Web3Service {
    private const val INFURA_URL = "https://mainnet.infura.io/v3/YOUR_INFURA_KEY"
    private val web3 = Web3j.build(HttpService(INFURA_URL))

    suspend fun getBalance(address: String): String {
        return try {
            val ethGetBalance = web3.ethGetBalance(address, DefaultBlockParameterName.LATEST).sendAsync().get()
            val balanceInWei = ethGetBalance.balance
            val balanceInEth = Convert.fromWei(balanceInWei.toString(), Convert.Unit.ETHER)
            "${balanceInEth} ETH"
        } catch (e: Exception) {
            "Ошибка"
        }
    }
}