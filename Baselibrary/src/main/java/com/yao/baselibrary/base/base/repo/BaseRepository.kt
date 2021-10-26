package com.yao.baselibrary.base.base.repo

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

/**
 *  @author zhangyao
 *  @date 2021/10/25  10:25
 *  @E-mail android_n@163.com
 *  基础数据层
 */
open class BaseRepository {

    /**
     * 在协程作用域中切换至IO线程
     */
    protected suspend fun <T> withIO(block: suspend () -> T): T {
        return withContext(Dispatchers.IO) {
            block.invoke()
        }
    }

}