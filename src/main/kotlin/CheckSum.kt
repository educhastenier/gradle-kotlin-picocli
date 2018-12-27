import picocli.CommandLine
import java.io.File
import java.nio.file.Files
import java.security.MessageDigest
import java.util.concurrent.Callable

@CommandLine.Command(
    description = ["Prints the checksum (MD5 by default) of a file to STDOUT."],
    name = "checksum",
    mixinStandardHelpOptions = true,
    version = ["File Checksum 3.0"]
)
internal class CheckSum : Callable<Void> {

    @CommandLine.Parameters(index = "0", description = ["The file whose checksum to calculate."])
    private val file: File? = null

    @CommandLine.Option(names = ["-a", "--algorithm"], description = ["MD5, SHA-1, SHA-256, ..."])
    private var algorithm = "MD5"

    @CommandLine.Option(names = ["-p", "--password"], description = ["Passphrase"], interactive = true)
    var password: String? = null


    @Throws(Exception::class)
    override fun call(): Void? {
        // your business logic goes here...
        val fileContents = Files.readAllBytes(file!!.toPath())
        val digest = MessageDigest.getInstance(algorithm).digest(fileContents)
        println(javax.xml.bind.DatatypeConverter.printHexBinary(digest))
        return null
    }

    companion object {

        @Throws(Exception::class)
        @JvmStatic
        fun main(args: Array<String>) {
            // CheckSum implements Callable, so parsing, error handling and handling user
            // requests for usage help or version help can be done with one line of code.
            CommandLine.call(CheckSum(), *args)
        }
    }
}