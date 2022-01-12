package com.cine.newcine.common.view;

import java.util.List;

/**
 * @author zhangyao
 * @date 2021/12/3  16:41
 * @E-mail android_n@163.com
 */
class Demo {


    /**
     * msg : 操作成功
     * result : {"timeSign":["15:00"]}
     * code : 1000
     */

    private String msg;
    private ResultBean result;
    private int code;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public ResultBean getResult() {
        return result;
    }

    public void setResult(ResultBean result) {
        this.result = result;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public static class ResultBean {
        private List<String> timeSign;

        public List<String> getTimeSign() {
            return timeSign;
        }

        public void setTimeSign(List<String> timeSign) {
            this.timeSign = timeSign;
        }
    }
}
