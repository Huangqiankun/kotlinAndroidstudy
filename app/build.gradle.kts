plugins {
    id("com.android.application")
    id("kotlin-android")
    id("kotlin-android-extensions")
}

android {
    compileSdkVersion(31)

    defaultConfig {
        applicationId = "com.hqk.kotlinstudy"
        minSdkVersion(28)
        targetSdkVersion(31)
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
//        release {
//            zipAlignEnabled true
//        }
//        debug {
//            zipAlignEnabled true
//        }

        getByName("release") {
            zipAlignEnabled(true)
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }

        getByName("debug") {
            zipAlignEnabled(true)
        }

    }

    dexOptions {
        javaMaxHeapSize = "2048m"
        jumboMode = true//忽略方法数限制的检查

        //是否对依赖的库进行dex预处理来是你的增量构建更快速
        //因为这个特性可能会使你的clean构建变慢
        //因此在你的持续集成服务器上你可能想要关闭这个特性
        preDexLibraries = true

        //设置最大的线程数量使用，当运行dex-in-process时，默认是4
        maxProcessCount = 8
    }

    flavorDimensions.add("channel")
    productFlavors {

        create("dev") {
            dimension = "channel"
            resConfigs("en", "xxhdpi")
            resValue("string", "bbb", "nnnn")// 'string', 'bbb', 'nnnn'
            buildConfigField("Boolean", "UM_FLAG", "false")
        }

        create("prod") {
            dimension = "channel"
            buildConfigField("Boolean", "UM_FLAG", "false")
        }

    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }



}

dependencies {

    implementation("androidx.appcompat:appcompat:1.2.0")
    implementation ("com.google.android.material:material:1.1.0")
    implementation ("androidx.constraintlayout:constraintlayout:1.1.3")
    testImplementation ("junit:junit:4.+")
    androidTestImplementation ("androidx.test.ext:junit:1.1.1")
    androidTestImplementation ("androidx.test.espresso:espresso-core:3.2.0")
    implementation ("androidx.core:core-ktx:+")
    implementation ("org.jetbrains.kotlin:kotlin-stdlib-jdk7:1.5.0")
}

afterEvaluate {

    val task = tasks.findByName("packageDebug")
    task?.doFirst {
        println("==============inputs.files====================")
        inputs.files.forEach {
            println(it)
        }
    }

    task?.doLast {
        println("==============outputs.files====================")
        outputs.files.forEach {
            println(it)
        }
    }

}

println(rootProject.ext["name"])



//plugins {
//    id 'com.android.application'
//}
////apply plugin: 'kotlin-android'
////apply plugin: 'kotlin-android-extensions'
//
//android {
//    compileSdkVersion 31
//
//    defaultConfig {
//        applicationId "com.hqk.kotlinstudy"
//        minSdkVersion 28
//        targetSdkVersion 31
//        versionCode 1
//        versionName "1.0"
//
//        testInstrumentationRunner "androidx.test.runner.AndroidJUnitRunner"
//    }
//
//    buildTypes {
//        release {
//            zipAlignEnabled true
//        }
//        debug {
//            zipAlignEnabled true
//        }
//    }
//
//    dexOptions {
//        javaMaxHeapSize "2048m"
//        jumboMode true//忽略方法数限制的检查
//
//        //是否对依赖的库进行dex预处理来是你的增量构建更快速
//        //因为这个特性可能会使你的clean构建变慢
//        //因此在你的持续集成服务器上你可能想要关闭这个特性
//        preDexLibraries true
//
//        //设置最大的线程数量使用，当运行dex-in-process时，默认是4
//        maxProcessCount 8
//    }
//
//
//
//    flavorDimensions 'channel'
//    productFlavors {
//        //本地开发版本可以优化的内容
//        dev {
//            dimension 'channel'
//            //避免编译不必要的资源
//            resConfigs "en","xxhdpi"
//            resValue 'string', 'bbb', 'nnnn'
//
//            //禁止每次构建app都自动压缩图片
//            aaptOptions{
//                cruncherEnabled false
//            }
//
//            //本地开发环境可以停止友盟统计或者三方不需要的工具，这个是自定义的
//            buildConfigField  "Boolean", "UM_FLAG", "false"
//        }
//        //正式版本就需要开启
//        prod {
//            dimension 'channel'
//            buildConfigField  "Boolean", "UM_FLAG", "true"
//        }
//    }
//
//
//    compileOptions {
//        sourceCompatibility JavaVersion.VERSION_1_8
//        targetCompatibility JavaVersion.VERSION_1_8
//    }
//}
//
//dependencies {
//
//    implementation 'androidx.appcompat:appcompat:1.1.0'
//    implementation 'com.google.android.material:material:1.1.0'
//    implementation 'androidx.constraintlayout:constraintlayout:1.1.3'
//    testImplementation 'junit:junit:4.+'
//    androidTestImplementation 'androidx.test.ext:junit:1.1.1'
//    androidTestImplementation 'androidx.test.espresso:espresso-core:3.2.0'
//    implementation "androidx.core:core-ktx:+"
//    implementation "org.jetbrains.kotlin:kotlin-stdlib-jdk7:$kotlin_version"
//}
//repositories {
//    mavenCentral()
//}