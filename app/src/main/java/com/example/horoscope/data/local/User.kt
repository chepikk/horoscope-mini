@Entity(tableName = "users")
data class User(
    @PrimaryKey val id: Int = 1,
    val name: String = "",
    val birthDate: String = "",      // формат "dd.MM.yyyy"
    val zodiacSign: String = "",
    val email: String = ""
)