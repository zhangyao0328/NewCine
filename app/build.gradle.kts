plugins {
    id("com.android.application")
    id("kotlin-android")
    id("kotlin-kapt")
    id("com.cine.version")

}
//apply("../basic.gradle.kts")

android {
    compileSdkVersion(Version.compileSdkVersion)
    buildToolsVersion(Version.buildToolsVersion)

    defaultConfig {
        minSdkVersion(Version.minSdkVersion)
        targetSdkVersion(Version.targetSdkVersion)
        applicationId("com.cine.newcine")
        versionCode(Version.versionCode)
        versionName(Version.versionName)
        multiDexEnabled = true
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }

    kotlinOptions{
        jvmTarget = "1.8"
    }


    buildFeatures {
        dataBinding = true
        viewBinding = true
    }
}

dependencies {

    implementation(project(":Baselibrary"))
    api(Android.constraintlayout)
    api(Android.lifecycle.livedataKtx)
    api(Android.navigation.fragmentKtx)
    api(Android.navigation.uiKtx)
    api(ThirdParty.smartRefreshLayout.refreshLayoutKernel)
    api(ThirdParty.smartRefreshLayout.refreshHeaderClassics)
    api(ThirdParty.recyclerViewAdapter.baseRecyclerViewAdapterHelper)
    api(ThirdParty.glide.glide)
    api(ThirdParty.glide.transformations)
    implementation ("cn.com.postrock.yaolib:yaolib:1.0.0")
}