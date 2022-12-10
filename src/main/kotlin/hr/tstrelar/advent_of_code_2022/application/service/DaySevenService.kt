package hr.tstrelar.advent_of_code_2022.application.service

import hr.tstrelar.NL
import hr.tstrelar.advent_of_code_2022.application.port.`in`.FindDirsOfSizeUseCase
import hr.tstrelar.advent_of_code_2022.application.port.`in`.FreeEnoughSpaceUseCase
import java.lang.IllegalStateException

private const val DIR_MARKER = "\$\$dir"
private const val TOTAL_SIZE = 70_000_000
private const val UPDATE_SIZE = 30_000_000

class DaySevenService : FindDirsOfSizeUseCase, FreeEnoughSpaceUseCase {
    override fun sumDirsOfSizeAtMost100000(input: String) = parseDirStructure(input)
        .getSizeOfAllDirsSmallerThan(100000)
        .reduce { acc, size -> acc + size }
        .toString()

    override fun freeSpace(input: String): String {
        val root = parseDirStructure(input)
        val usedSpace = root.getDirSize()
        val freeSpace = TOTAL_SIZE - usedSpace
        val freeAtLeast = UPDATE_SIZE - freeSpace
        return root.getSizeOfDirToFreeAtLeast(freeAtLeast).toString()
    }
    private fun parseDirStructure(input: String) =  input.split(NL).drop(1).fold(File("/")) { workingDir, s ->
        if (s.startsWith("$ ")) {
            val command = s.drop("$ ".length)
            if (command.startsWith("cd")) {
                val argument = command.drop("cd ".length)
                if (argument == "..") {
                    workingDir.parent ?: workingDir
                } else {
                    workingDir.changeDir(argument)
                }
            } else {
                workingDir
            }
        } else {
            workingDir.addFile(s)
            workingDir
        }
    }.getRoot()
    class File(input: String, val parent: File? = null) {
        private val size: Long
        private val isDir: Boolean
        private val kids: MutableMap<String, File> = mutableMapOf()
        init {
            if (input == "/") {
                size = 0
                isDir = true
            } else if (input.startsWith("dir")) {
                size = 0
                isDir = true
            } else {
                size = input.split(" ").first().toLong()
                isDir = false
            }
        }
        fun addFile(input: String) {
            if (this.isDir) {
                val split = input.split(" ")
                val type = split[0]
                val name = split[1]
                val dirSuffix = if (type == "dir") DIR_MARKER else ""
                kids["$name$dirSuffix"] = File(input, this)
            }
        }
        fun changeDir(name: String) = kids["$name$DIR_MARKER"] ?: throw IllegalStateException("No such file: $name")
        fun getRoot() = doGetRoot(this)
        fun getSizeOfAllDirsSmallerThan(size: Long) = getSizeOfAllDirs().filter { it < size }
        fun getDirSize() = getSizeOfDir(this)
        fun getSizeOfDirToFreeAtLeast(size: Long) = getSizeOfAllDirs().sorted().first { it >= size }
        private fun getSizeOfAllDirs(): List<Long> = flatten(this).map(this::getSizeOfDir)
        private fun doGetRoot(file: File): File = when (file.parent) {
            null -> file
            else -> doGetRoot(file.parent)
        }
        private fun flatten(file: File): List<File> {
            return if (file.kids.isEmpty()) {
                listOf(file)
            } else {
                listOf(file) + file.getSubDirs().fold(listOf()) { acc, f -> acc + flatten(f) }
            }
        }
        private fun getSubDirs() = this.kids.values.filter { it.isDir }
        private fun getSizeOfDir(file: File): Long {
            return if (file.isDir) {
                file.kids.values.fold(0L) { acc, f ->
                    acc + getSizeOfDir(f)
                }
            } else {
                file.size
            }
        }
    }
}