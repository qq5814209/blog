package com.me.pojo;

import org.springframework.beans.factory.annotation.Value;

public class Pay {

    /** 支付宝gatewayUrl */
    private String gatewayUrl;


    /** 商户应用id */
    private String appid;


    /** RSA私钥，用于对商户请求报文加签 */
    private String privateKey;


    /** 支付宝RSA公钥，用于验签支付宝应答 */
    private String alipayPublicKey;



    /** 同步地址 */
    private String returnUrl;



    /** 异步地址 */
    private String notifyUrl;



    /** 签名类型 */
    private String signType = "RSA2";

    /** 格式 */
    private String formate = "json";
    /** 编码 */
    private String charset = "UTF-8";



    /** 最大查询次数 */
    private static int maxQueryRetry = 5;
    /** 查询间隔（毫秒） */
    private static long queryDuration = 5000;
    /** 最大撤销次数 */
    private static int maxCancelRetry = 3;
    /** 撤销间隔（毫秒） */
    private static long cancelDuration = 3000;

    public String getGatewayUrl() {
        return gatewayUrl;
    }

    public void setGatewayUrl(String gatewayUrl) {
        this.gatewayUrl = gatewayUrl;
    }

    public String getAppid() {
        return appid;
    }

    public void setAppid(String appid) {
        this.appid = appid;
    }

    public String getPrivateKey() {
        return privateKey;
    }

    public void setPrivateKey(String privateKey) {
        this.privateKey = privateKey;
    }

    public String getAlipayPublicKey() {
        return alipayPublicKey;
    }

    public void setAlipayPublicKey(String alipayPublicKey) {
        this.alipayPublicKey = alipayPublicKey;
    }

    public String getSignType() {
        return signType;
    }

    public void setSignType(String signType) {
        this.signType = signType;
    }

    public String getFormate() {
        return formate;
    }

    public void setFormate(String formate) {
        this.formate = formate;
    }

    public String getCharset() {
        return charset;
    }

    public void setCharset(String charset) {
        this.charset = charset;
    }

    public String getReturnUrl() {
        return returnUrl;
    }

    public void setReturnUrl(String returnUrl) {
        this.returnUrl = returnUrl;
    }

    public String getNotifyUrl() {
        return notifyUrl;
    }

    public void setNotifyUrl(String notifyUrl) {
        this.notifyUrl = notifyUrl;
    }

    public static int getMaxQueryRetry() {
        return maxQueryRetry;
    }

    public static void setMaxQueryRetry(int maxQueryRetry) {
        Pay.maxQueryRetry = maxQueryRetry;
    }

    public static long getQueryDuration() {
        return queryDuration;
    }

    public static void setQueryDuration(long queryDuration) {
        Pay.queryDuration = queryDuration;
    }

    public static int getMaxCancelRetry() {
        return maxCancelRetry;
    }

    public static void setMaxCancelRetry(int maxCancelRetry) {
        Pay.maxCancelRetry = maxCancelRetry;
    }

    public static long getCancelDuration() {
        return cancelDuration;
    }

    public static void setCancelDuration(long cancelDuration) {
        Pay.cancelDuration = cancelDuration;
    }

    @Override
    public String toString() {
        return "Pay{" +
                "gatewayUrl='" + gatewayUrl + '\'' +
                ", appid='" + appid + '\'' +
                ", privateKey='" + privateKey + '\'' +
                ", alipayPublicKey='" + alipayPublicKey + '\'' +
                ", signType='" + signType + '\'' +
                ", formate='" + formate + '\'' +
                ", charset='" + charset + '\'' +
                ", returnUrl='" + returnUrl + '\'' +
                ", notifyUrl='" + notifyUrl + '\'' +
                '}';
    }
}
