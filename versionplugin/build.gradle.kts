import org.jetbrains.kotlin.ir.backend.js.compile
buildscript {
    repositories {
        // 需要添加 jcenter 否则会提示找不到 gradlePlugin
        jcenter()
        google()
    }
    dependencies {
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:1.5.0")
    }
}

plugins {
    `kotlin-dsl`
}

repositories {
    google()
    mavenCentral()
    jcenter()
}

gradlePlugin{
    plugins{
        create("versionPlugin"){
            id = "com.cine.version"
            implementationClass = "VersionPlugin"
            description = "插件测试"
        }
    }
}


