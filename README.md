# pay  Android SDK
# 目录

* [1.简介](#1)
* [2.环境要求](#2)
* [3.快速体验](#3)
* [4.工程配套及使用](#4)
   	* [4.1导入依赖包](#4.1)
	* [4.2清单文件导入](#4.2)
	* [4.3导入微信回调类](#4.3)
	* [4.4初始化sdk](#4.4)
	* [4.5创建对象调起支付](#4.5)

![avatar](/picture/WechatIMG78.jpeg)
![avatar](/picture/WechatIMG79.png)
![avatar](/picture/WechatIMG80.jpeg)
![avatar](/picture/1548124381057.jpg)
<h1 id="1">简介</h1>

项目只是个Demo,只需要在build.gradle中添加依赖,正确的传参就可以正常的使用.

<h1 id="2">环境要求</h1>

Android SDK 要求 Android 4.4 及以上版本 请使用 Java 8 或以上版本

<h1 id="3">快速体验</h1>

##Android studio

导入整个项目,即可运行DEMO
需要注意: 测试微信支付，需要签名和包名与微信开放平台上的一致，才可支付成功。给出的 demo 包名和微信支付的appId
都是测试环境下正确的,可以直接使用.

<h1 id="4">工程配置及使用</h1>

<h3 id="4.1">一、导入依赖包</h3>

(注：依赖渠道 SDK 时，可能会和其他第三方SDK有冲突，移除依赖冲突的包就可以)

#### Gradle 导入方式

##### 修改项目的 build.gradle 文件，添加 github 仓库地址
```
allprojects {
		repositories {
			maven { url 'https://www.jitpack.io' }
		}
	}
```

```
dependencies {
        implementation 'pl.droidsonroids.gif:android-gif-drawable:1.2.16'
        implementation 'com.github.zhy230zhy:pay:1.0.3'
            }
```
<h3 id="4.2">二、清单文件导入</h3>

```
        <activity
        android:name=".wxapi.WXPayEntryActivity"
        android:exported="true"
        android:launchMode="singleTop" />
```

<h3 id="4.3">三、导入微信回调类</h3>

(注包名下创建文件夹,文件夹名称必须为wxapi 类名也不得变化)

```
public class WXPayEntryActivity extends Activity implements IWXAPIEventHandler {


    private IWXAPI api;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        api = WXAPIFactory.createWXAPI(this, PayInit.WXAPPID);
        api.handleIntent(getIntent(), this);
    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        setIntent(intent);
        api.handleIntent(intent, this);
    }

    @Override
    public void onReq(BaseReq req) {
    }

    @Override
    public void onResp(BaseResp resp) {
        EventBus.getDefault().post(resp);
        finish();
    }
}
```
<h3 id="4.4">四、初始化sdk</h3>

```
try {
      PayInit.payInit(this,"wx2a5538052969956e");
    } catch (Exception e) {
      e.printStackTrace();
    }
```
<h3 id="4.5">五、创建对象调起支付</h3>

(注 : PayDataBean类已存在,只需要set值就可以,所有字段均为必传)

```
PayInit.setPayData(this,payDataBean);
```

<table>
<tr>
<td>字段</td><td>字段含义</td><td>是否必传</td><td>备注</td>
</tr>
<tr>
<td> merCode </td><td>	商户编号</td><td>Y</td><td></td>
</tr>
<tr>
<td>orderNo</td><td>订单号</td><td>Y</td><td></td>
</tr>
<tr>
<td>payAmount</td><td>支付金额</td><td>Y</td><td></td>
</tr>
<tr>
<td>appId</td><td>微信appId</td><td>Y</td><td></td>
</tr>
<tr>
<td>payType</td><td>支付方式</td><td>Y</td><td>微信传1</td>
</tr>
<tr>
<td>busiNo</td><td>业务编号</td><td>Y</td><td></td>
</tr>
<tr>
<td>productCode</td><td>产品编号</td><td>Y</td><td>备注</td>
</tr>
<tr>
<td>productDesc</td><td>产品描述</td><td>Y</td><td>备注</td>
</tr>
<tr>
<td>isHybrid</td><td>是否原生</td><td>Y</td><td>原生传0 非原生传1</td>
</tr>
<tr>
<td>prikey</td><td>私钥</td><td>Y</td><td></td>
</tr>

<tr>
<td>pubkey</td><td>公钥</td><td>Y</td><td>备注</td>
</tr>
<tr>
<td>orderDate</td><td>时间</td><td>Y</td><td>年月日(yyyyMMdd)</td>
</tr>
<tr>
<td>orderTime</td><td>时间</td><td>Y</td><td>时分秒毫秒(hhmmssSSS)</td>
</tr>
</table>




