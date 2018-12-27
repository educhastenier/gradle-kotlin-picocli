import picocli.CommandLine
import picocli.CommandLine.*
import java.io.File

internal class Cat {

    @Command(
        description = ["Concatenate FILE(s) to standard output."],
        mixinStandardHelpOptions = true,
        version = ["3.6.0"]
    )
    fun cat(
        @Option(names = ["-E", "--show-ends"]) showEnds: Boolean,
        @Option(names = ["-n", "--number"]) number: Boolean,
        @Option(names = ["-T", "--show-tabs"]) showTabs: Boolean,
        @Option(names = ["-v", "--show-nonprinting"]) showNonPrinting: Boolean,
        @Parameters(paramLabel = "FILE") files: Array<File>
    ) {
        // process files...
        println("processing your files...\nProcessing done.")
    }

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            CommandLine.invoke("cat", Cat::class.java, *args)
        }
    }
}