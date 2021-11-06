/**
 *  @author zhangyao
 *  @date 2021/11/4  11:19
 *  @E-mail android_n@163.com
 */
@Suppress("SpellCheckingInspection")
object ThirdParty {

    //下拉刷新 https://github.com/scwang90/SmartRefreshLayout
    val smartRefreshLayout = Smart
    object Smart{
        private const val version = "2.0.3"
        //核心必须依赖
        const val refreshLayoutKernel = "com.scwang.smart:refresh-layout-kernel:$version"
        //金典刷新头
        const val refreshHeaderClassics = "com.scwang.smart:refresh-layout-kernel:$version"
    }

    //RecyclerViewAdapter https://github.com/CymChad/BaseRecyclerViewAdapterHelper/blob/master/readme/0-BaseRecyclerViewAdapterHelper.md
    val recyclerViewAdapter = RecyclerViewAdapter
    object RecyclerViewAdapter{
        private const val version = "3.0.4"
        const val baseRecyclerViewAdapterHelper = "com.github.CymChad:BaseRecyclerViewAdapterHelper:$version"
    }

    //内存检测 https://square.github.io/leakcanary/getting_started/
    val leakCanary = LeakCanary
    object LeakCanary {
        private const val leakCanary_version = "2.7"
        const val leakCanary = "com.squareup.leakcanary:leakcanary-android:$leakCanary_version"
    }

    val glide = Glide
    object Glide {
        const val glide = "com.github.bumptech.glide:glide:4.11.0"
        const val transformations = "jp.wasabeef:glide-transformations:4.1.0"
    }




}