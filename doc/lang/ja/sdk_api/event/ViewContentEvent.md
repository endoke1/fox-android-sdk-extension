# ViewContentEvent

public class ViewContentEvent

[java.lang.Object](https://developer.android.com/reference/java/lang/Object.html)<br>
　↳&nbsp;[co.cyberz.fox.FoxEvent](https://github.com/cyber-z/public-fox-android-sdk/blob/master/4.x/lang/ja/doc/sdk_api/README.md#foxevent)<br>
　　　↳&nbsp;[co.cyberz.fox.support.event.FoxBaseExtensionEvent](./FoxBaseExtensionEvent.md)<br>
　　　　　↳&nbsp;co.cyberz.fox.support.event.ViewContentEvent

### Public constructors

|**Constructor**|**Details**|
|:---|:---|
|**ViewContentEvent** ( )|イベント名はデフォルトで"_view_content"が設定されます。|
|**ViewContentEvent** ( int ltvPointId ) <br><br> `ltvPointId` : LTV成果地点ID|・規定のイベント名を内部で定義しているため、媒体連携を行う場合はこちらをお使いください。<br>・イベント名はデフォルトで"_view_content"が設定されます。<br>・LTV成果地点IDは管理者が発行した値を指定ください。|
|**ViewContentEvent** ( String eventName, int ltvPointId ) <br><br> ・`eventName` : イベント名<br>・`ltvPointId` : LTV成果地点ID|任意のイベント名を指定する場合にはこちらを使用ください。|

### Public methods

|**Return**|**Method**|**Details**|
|:---:|:---|:---|
|ViewContentEvent|**addUserId** ( String id )<br><br>`id` : アプリ内のユーザーID|ユーザーIDを指定する場合に使用します。|
|ViewContentEvent|**addDin** ( String din )<br><br>`din` : 日付 From|日付の指定のある場合に使用します。<br>Criteo・DynamicRemarketingとの連携を行う際に必要となります。|
|ViewContentEvent|**addDout** ( String dout )<br><br>`dout` : 日付 To|日付の指定のある場合に使用します。<br>Criteo・DynamicRemarketingとの連携を行う際に必要となります。|
|ViewContentEvent|**addDestination** ( String destination )<br><br>`destination` : 行き先(目的地)|旅行アプリなど目的地を指定する場合に使用します。<br>Criteo・DynamicRemarketingとの連携を行う際に必要となります。|
|ViewContentEvent|**addOrigin** ( String origin )<br><br>`Origin` : 出発地点|旅行アプリなど出発地点を指定する場合に使用します。<br>Criteo・DynamicRemarketingとの連携を行う際に必要となります。|
|ViewContentEvent|**addProduct** ( int id, String itemLocationId, String category, double price, int quantity )<br><br>・`id` : 商品ID<br>・`itemLocationId` : ロケーションID(商品の広告を特定の場所や地域に訴求したい場合に設定)<br>・`category` : 商品のカテゴリ<br>・`price` : 商品の価格<br>・`quantity` : 個数|閲覧した商品の情報を指定する場合に使用します。<br>Criteo・DynamicRemarketing・Dynalystとの連携を行う際に必要となります。|
|ViewContentEvent|**addCategoryId** ( String id )<br><br>`id` : カテゴリID|商品のカテゴリIDを指定します。<br>Vizuryと連携を行う際に必要となります。<br>Criteo・Vizuryとの連携を行う際に必要となります。|
|ViewContentEvent|**addCriteoPartnerId** ( String id )<br><br>`id` : CriteoアカウントID|Criteoとの連携を行う際に必要となります。CriteoアカウントIDが同一アプリで異なる場合は入力してください。|


---
[トップ](../../README.md)
