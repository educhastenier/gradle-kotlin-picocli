# gradle-kotlin-picocli
Project to experiment [PicoCLI](https://picocli.info) using
<img src="https://res-5.cloudinary.com/crunchbase-production/image/upload/c_lpad,h_256,w_256,f_auto,q_auto:eco/jx7ub3mumyihohgpufm8" alt="Gradle"  width="20" height="20"/>
as the build tool, and
<img src="https://cdn-images-1.medium.com/max/1600/1*jF8FIzqLxF5pp-13NogRQw.png" alt="Kotlin" width="20" height="20"/>
as the programming language.

## build the project
./gradlew jar

## using bash completion for Checksum application
in ZSH:
```
autoload -U +X compinit && compinit
autoload -U +X bashcompinit && bashcompinit
. ./jchecksum_completion

alias jchecksum='java -cp /home/manu/.gradle/caches/modules-2/files-2.1/info.picocli/picocli/3.8.2/ad74665a1b8d10b45e7c4bfa6c709dc3b3d9ca78/picocli-3.8.2.jar:build/libs/kotlin-picocli-1.0-SNAPSHOT.jar:/home/manu/.gradle/caches/modules-2/files-2.1/org.jetbrains.kotlin/kotlin-stdlib-jdk8/1.3.11/dd9bff00d6cfca58b6c1fe89be8e0678e35cf35f/kotlin-stdlib-jdk8-1.3.11.jar:/home/manu/.gradle/caches/modules-2/files-2.1/org.jetbrains.kotlin/kotlin-stdlib/1.3.11/4cbc5922a54376018307a731162ccaf3ef851a39/kotlin-stdlib-1.3.11.jar CheckSum'
```
Then:
`jchecksum <TAB> <TAB>`


## Sub-commands example

This example also illustrates the usage of color output feature of picocli.

```
autoload -U +X compinit && compinit
autoload -U +X bashcompinit && bashcompinit
. ./mykotlinapp_completion
alias mykotlinapp='java -cp /home/manu/.gradle/caches/modules-2/files-2.1/info.picocli/picocli/3.8.2/ad74665a1b8d10b45e7c4bfa6c709dc3b3d9ca78/picocli-3.8.2.jar:build/libs/kotlin-picocli-1.0-SNAPSHOT.jar:~/.gradle/caches/modules-2/files-2.1/org.jetbrains.kotlin/kotlin-stdlib-jdk8/1.3.11/dd9bff00d6cfca58b6c1fe89be8e0678e35cf35f/kotlin-stdlib-jdk8-1.3.11.jar:/home/manu/.gradle/caches/modules-2/files-2.1/org.jetbrains.kotlin/kotlin-stdlib/1.3.11/4cbc5922a54376018307a731162ccaf3ef851a39/kotlin-stdlib-1.3.11.jar MyKotlinApp'
```

`mykotlinapp --help`:
```bash
Usage: mykotlinapp [-hV] [-c=<count>] [COMMAND]
Kotlin picocli example with color usage show-off.
This application prints out 'Hello World' a certain number of times, according
to numeric Option --count (-c).
  -c, --count=<count>   number of repetitions
  -h, --help            Show this help message and exit.
  -V, --version         Print version information and exit.
Commands:
  sub     Define the main sub-command
  status  Display information about status
  help    Displays help information about the specified command
```

```
$ my-kotlin-app sub
$ my-kotlin-app help status
$ my-kotlin-app status -a myObject
$ my-kotlin-app status -o <TAB>
OBJECT   SOURCE   URL                 <-- Shell completion proposes enum values (for @Option's only, not @Parameters)
```