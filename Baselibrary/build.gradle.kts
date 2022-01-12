plugins {
    id("com.android.library")
    id("kotlin-android")
    id("com.cine.version")
    id("kotlin-kapt")
}

android {
    compileSdkVersion(Version.compileSdkVersion)
    buildToolsVersion(Version.buildToolsVersion)

    defaultConfig {
        minSdkVersion(Version.minSdkVersion)
        targetSdkVersion(Version.targetSdkVersion)
        versionCode(Version.versionCode)
        versionName(Version.versionName)
        multiDexEnabled = true
    }

    buildFeatures {
        dataBinding = true
        viewBinding = true
    }



}

dependencies {
    api(Kotlin.kotlinStdLib)
    api(Android.coreKtx)
    api(Android.appcompat)
    api(Android.lifecycle.viewModelKtx)
    api(Android.material)
    api(ThirdParty.retrofit.retrofit)
    api(ThirdParty.retrofit.scalars)
    api(ThirdParty.retrofit.gson)
    debugApi(ThirdParty.leakCanary.leakCanary)
    api(ThirdParty.blockCanary.blockCanary)
    api(ThirdParty.cookieJar)
}