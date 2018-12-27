import picocli.CommandLine
import picocli.CommandLine.Command
import picocli.CommandLine.Option

@CommandLine.Command(
    name = "kotlin-app", version = ["Kotlin picocli v3.0 demo"],
    mixinStandardHelpOptions = true, // add --help and --version options
    description = ["""@|bold,fg(red) Kotlin|@ @|underline,italic picocli|@ @|bg(white),blink,fg(blue) example|@ with color usage show-off.
This application prints out 'Hello World' a certain number of times, according to numeric Option --count (-c)."""],
    subcommands = [
        MyKotlinApp.SubCmd::class,
        MyKotlinApp.Status::class,
        picocli.CommandLine.HelpCommand::class // for default usage help about the subCommands
    ]
)
class MyKotlinApp : Runnable {

    @Option(names = ["-c", "--count"], description = ["number of repetitions"])
    private var count: Int = 1

    private var sub: SubCmd? = null

    override fun run() {
        println(sub?.default)
        for (i in 0 until count) {
            println("hello world $i...")
        }
    }

    companion object {
        @Throws(Exception::class)
        @JvmStatic
        fun main(args: Array<String>) = CommandLine.run(MyKotlinApp(), *args)
    }

    @Command(name = "sub", description = ["Define the main sub-command"])
    class SubCmd : Runnable {
        override fun run() {
            println("Sub-command is default: $default")
        }

        @Option(names = ["-d", "--default"], description = ["is this sub the default one [default value is false]"])
        var default: Boolean = false

    }

    @Command(name = "status", description = ["Display information about status"])
    class Status : Runnable {
        override fun run() {
            println("Status of object $obj: ON")
        }

        @Option(names = ["-a", "--all"], description = ["Shows the status of all object, not only the current one"])
        var all: Boolean = false

        @CommandLine.Parameters(index = "0", description = ["The object on which to show the status."])
        var obj: String = ""
    }
}
