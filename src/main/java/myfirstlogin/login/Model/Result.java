package myfirstlogin.login.Model;

public class Result<T> {
    //返回信息
    private String msg;
    //返回code = -1 为失败, 200为成功
    private int code;
    //具体返回的数据
    private T detail;

    public String getMsg() {
        return msg;
    }
    public void setMsg(String msg) {
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }
    public void setCode(int code) {
        this.code = code;
    }

    public T getDetail() {
        return detail;
    }

    public void setDetail(T detail) {
        this.detail = detail;
    }

    @Override
    public String toString() {//创建Result类，用于规范数据返回。方便前端和Android同学。
        return "Result{" +
                "msg='" + msg + '\'' +
                ",code=" + code +
                ",detail=" + detail +
            '}';
    }
}
