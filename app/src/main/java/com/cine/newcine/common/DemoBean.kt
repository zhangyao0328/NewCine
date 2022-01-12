package com.cine.newcine.common

/**
 *  @author zhangyao
 *  @date 2021/12/3  10:59
 *  @E-mail android_n@163.com
 */
data class DemoBean(
    val code: Int? = 0,
    val msg: String? = "",
    val result: Result? = Result()
)

data class Result(
    val timeSign: List<String>? = listOf()
)