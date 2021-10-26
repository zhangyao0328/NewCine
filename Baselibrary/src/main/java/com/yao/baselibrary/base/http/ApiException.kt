package com.yao.baselibrary.base.http

/**
 *  @author zhangyao
 *  @date 2021/10/24  11:21
 *  @E-mail android_n@163.com
 *  封装业务错误信息
 */
class ApiException(val errorMessage:String, val errorCode:Int) : Throwable(){
}