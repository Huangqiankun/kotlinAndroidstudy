//// Top-level build file where you can add configuration options common to all sub-projects/modules.

buildscript {
    val kotlinVersion = "1.5.0"

    repositories {
        google()
//        jcenter()
        mavenCentral()
    }
    dependencies {
        classpath("com.android.tools.build:gradle:4.1.2")
//        classpath ("org.jetbrains.kotlin:kotlin-gradle-plugin:$kotlin_version")
        classpath(kotlin("gradle-plugin", kotlinVersion))
    }
}

allprojects {
    repositories {
        google()
//        jcenter()
        mavenCentral()
    }
}

//task clean(type: Delete) {
//    delete rootProject.buildDir
//}

tasks {
    val clean by registering(Delete::class) {
        delete(buildDir)
    }

}

task("add") {
    println("config ")
    this.doFirst {
        println("doFirst")
    }
    doLast {
        val num1 = 10
        val num2 = 20
        println("name is ${ext["name"]} ,sum=${num1 + num2}")
    }

}


project.ext {
    //name = "hqk"
    set("name", "hqk")
    set("kotlinVersion","1.5.0")
}

ext["name"]


