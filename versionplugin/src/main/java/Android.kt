/**
 *  @author zhangyao
 *  @date 2021/11/4  11:18
 *  @E-mail android_n@163.com
 */
@Suppress("SpellCheckingInspection")
object Android {

    const val coreKtx = "androidx.core:core-ktx:1.3.1"
    const val appcompat = "androidx.appcompat:appcompat:1.4.0"
    const val material = "com.google.android.material:material:1.2.1"
    const val constraintlayout = "androidx.constraintlayout:constraintlayout:2.0.1"


    val lifecycle = Lifecycle

    object Lifecycle {
        private const val lifecycle_version = "2.2.0"
        const val livedataKtx = "androidx.lifecycle:lifecycle-livedata-ktx:$lifecycle_version"
        const val viewModelKtx = "androidx.lifecycle:lifecycle-viewmodel-ktx:$lifecycle_version"
    }

    val navigation = Navigation

    object Navigation {
        private const val navigation_version = "2.3.0"
        const val fragmentKtx = "androidx.navigation:navigation-fragment-ktx:$navigation_version"
        const val uiKtx = "androidx.navigation:navigation-ui-ktx:$navigation_version"
    }

}