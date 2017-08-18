package com.zoucl.server.utils;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.zoucl.server.model.BaseBean;

import java.util.Map;

/**
 * Created by zcl on 2017/6/1 0001.
 * 返回结果类
 */
public class Result {




    /** 结果代码  参考ResultCode */
    private String code;
    /** 信息 */
    private String message;
    /** 数据 */
    private Object data;

    public Result() {
        this.setCode(ResultCode.SUCCESS);
        this.setMessage("成功！");

    }

    public Result(ResultCode code) {
        this.setCode(code);
        this.setMessage(code.msg());
    }

    public Result(ResultCode code, String message) {
        this.setCode(code);
        this.setMessage(message);
    }

    public Result(ResultCode code, String message, Object data) {
        this.setCode(code);
        this.setMessage(message);
        this.setData(data);
    }

    /**
     * 业务处理成功
     * @param message 返回信息
     * @param data 返回数据
     * @return
     */
    public static Result success(String message,Object data){
        if(data instanceof Iterable){
            JSONArray array = JSONArray.parseArray(JSONObject.toJSONString(data));
            for(int i = 0;i<array.size();i++){
                removeColumn(array.getJSONObject(i),"createIp");
                removeColumn(array.getJSONObject(i),"updateIp");
                removeColumn(array.getJSONObject(i),"createId");
                removeColumn(array.getJSONObject(i),"updateId");
            }
            return new Result(ResultCode.SUCCESS,message,array);
        }
        else if(data instanceof Map || data instanceof BaseBean){
            JSONObject json = JSONObject.parseObject(JSONObject.toJSONString(data));
            removeColumn(json,"createIp");
            removeColumn(json,"updateIp");
            removeColumn(json,"createId");
            removeColumn(json,"updateId");
            return new Result(ResultCode.SUCCESS,message,json);
        }
        else{
            return new Result(ResultCode.SUCCESS,message,data);
        }
    }

    /**
     *
     * @param message
     * @param data
     * @param columns
     * @return
     */
    public static Result successWithoutColumn(String message,Object data,String columns[]){
        if(data instanceof Iterable){
            JSONArray array = JSONArray.parseArray(JSONObject.toJSONString(data));
            for(int i = 0;i<array.size();i++){
                removeColumn(array.getJSONObject(i),"createIp");
                removeColumn(array.getJSONObject(i),"updateIp");
                removeColumn(array.getJSONObject(i),"createId");
                removeColumn(array.getJSONObject(i),"updateId");
                for(int j = 0;j<columns.length;j++){
                    removeColumn(array.getJSONObject(i),columns[j]);
                }
            }
            return new Result(ResultCode.SUCCESS,message,array);
        }
        else if(data instanceof Map || data instanceof BaseBean){
            JSONObject json = JSONObject.parseObject(JSONObject.toJSONString(data));
            removeColumn(json,"createIp");
            removeColumn(json,"updateIp");
            removeColumn(json,"createId");
            removeColumn(json,"updateId");
            for(int j = 0;j<columns.length;j++){
                removeColumn(json,columns[j]);
            }
            return new Result(ResultCode.SUCCESS,message,json);
        }
        else{
            return new Result(ResultCode.SUCCESS,message,data);
        }
    }

    private static void removeColumn(JSONObject object, String column){
        if(null != object && null != object.get(column)){
            object.remove(column);
        }
    }

    /**
     * 业务处理成功
     * @param message 返回信息
     * @return
     */
    public static Result success(String message){
        return success(message,null);
    }

    /**
     * 系统错误
     * @param message 错误信息
     * @param e 异常
     * @return
     */
    public static Result sysError(String message, Exception e){
        e.printStackTrace();
        return new Result(ResultCode.SYS_ERROR,message);
    }
    /**
     * 系统错误
     * @return
     */
    public static Result sysError(String message){
        return new Result(ResultCode.SYS_ERROR,message);
    }

    /**
     * 系统错误
     * @param e 异常
     * @return
     */
    public static Result sysError(Exception e){
        e.printStackTrace();
        return new Result(ResultCode.SYS_ERROR,"系统错误！");
    }

    /**
     * 参数错误
     * @param message 错误信息
     * @return
     */
    public static Result paramError(String message){
        return new Result(ResultCode.PARAMS_ERROR,message);
    }

    /**
     * 参数错误
     * @return
     */
    public static Result paramError(){
        return new Result(ResultCode.PARAMS_ERROR,"参数错误！");
    }



    public String getCode() {
        return code;
    }
    public void setCode(ResultCode code) {
        this.code = code.val();
    }
    public String getMessage() {
        return message;
    }
    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
