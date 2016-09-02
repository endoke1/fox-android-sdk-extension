package co.cyberz.fox.cocos2dx.wrapper;

import android.content.Context;
import android.util.Log;

import org.json.JSONException;
import org.json.JSONObject;

import co.cyberz.fox.FoxConfig;
import co.cyberz.fox.FoxTrackOption;
import co.cyberz.fox.service.FoxEvent;
import co.cyberz.fox.support.util.StringUtil;

/**
 * Created by Garhira on 16/06/13.
 */
public class FoxTrack {

  private static long mDelegate;

  public static native void onCompleted(long delegate);

  /**
   * 初期化
   * @param c
   * @param appId
   * @param appKey
   * @param appSalt
   * @param fUrl
   * @param aUrl
   * @param tUrl
   * @param isDebug
   */
  public static void init(Context c, int appId, String appKey, String appSalt, String fUrl, String aUrl, String tUrl, boolean isDebug) {
    FoxConfig config = new FoxConfig(c.getApplicationContext(),
        appId,
        appKey,
        appSalt);
    if (!StringUtil.isEmpty(fUrl)) config.addFoxServerUrlOption(fUrl);
    if (!StringUtil.isEmpty(aUrl)) config.addAnalyticsServerUrlOption(aUrl);
    if (!StringUtil.isEmpty(tUrl)) config.addTradeServerUrlOption(tUrl);
    config.addDebugOption(isDebug);
    config.activate();
  }

  /**
   * インストール
   */
  public static void onLaunch() {
    co.cyberz.fox.Fox.trackInstall();
  }

  /**
   *
   * @param redirectUrl
   * @param buid
   * @param optout
   * @param delegate
   */
  public static void onLaunch(String redirectUrl, String buid, boolean optout, long delegate) {
    FoxTrackOption option = new FoxTrackOption();
    if (!StringUtil.isEmpty(redirectUrl)) option.addRedirectUrl(redirectUrl);
    if (!StringUtil.isEmpty(buid)) option.addBuid(buid);
    option.addOptOut(optout);
    mDelegate = delegate;

    option.setTrackingStateListener(new FoxTrackOption.TrackingStateListerner() {
      @Override
      public void onComplete() {
    	  Log.d("Cocos2d-x_FoxTrack", "成功 - onComplete");
        // 成功
        onCompleted(mDelegate);
      }
    });
    co.cyberz.fox.Fox.trackInstall(option);
  }
  
  public static void session() {
	  co.cyberz.fox.Fox.trackSession();
  }
  
  public static void sendEvent(FoxEvent e) {
	  if (e == null) return;
	  co.cyberz.fox.Fox.trackEvent(e);
  }

  public static void sendEvent(int ltvId, String buid, double price, String sku, String currency, String eventName, String action, int value, String label, String orderId, String itemName, int quantity, String eventInfo, String extraInfo) {
	  FoxEvent e = null;
	  if (0 < ltvId && !StringUtil.isEmpty(eventName)) {
		  e = new FoxEvent(eventName, ltvId);
	  } else if(!StringUtil.isEmpty(eventName)) {
		  e = new FoxEvent(eventName);
	  }
	  if (e == null) return;
	  e.buid = buid;
	  e.price = price;
	  e.sku = sku;
	  e.currency = currency;
	  e.value = value;
	  e.orderId = orderId;
	  e.itemName = itemName;
	  e.quantity = quantity;
	  try {
		  if (!StringUtil.isEmpty(eventInfo)) e.eventInfo = new JSONObject(eventInfo);
	  } catch (JSONException e1) {
		Log.e("Fox-SDK", "Cocos2d-x_FoxTrack", e1);
	  }
	  if (extraInfo != null) {
		  try {
			String extraInfos[] = extraInfo.split("&");
			for(String info : extraInfos) {
				String param[] = info.split("=");
				if (!StringUtil.isEmpty(param[0]) && !StringUtil.isEmpty(param[1])) {
					e.addExtraInfo(param[0], param[1]);
					e.eventInfo.put(param[0], param[1]);
				}
			}
		  } catch(Exception e1) {
				Log.e("Cocos2dx.FoxTrack.sendEvent", e1.getMessage());
		  }
	  }
	  co.cyberz.fox.Fox.trackEvent(e);
  }

  public static void trackEventByBrowser(String url) {
    co.cyberz.fox.Fox.trackEventByBrowser(url);
  }

	public static void setUserInfo(String userInfo) {
		try {
			JSONObject jUserInfo = new JSONObject(userInfo);
			co.cyberz.fox.Fox.setUserInfo(jUserInfo);
		} catch(Exception e) {
			Log.e("Cocos2dx setUserInfo", e.getMessage());
		}
	}

	public static String getUserInfo() {
		try {
			JSONObject jUserInfo = co.cyberz.fox.Fox.getUserInfo();
			return jUserInfo.toString();
		} catch(Exception e) {
			Log.e("Cocos2dx getUserInfo", e.getMessage());
		}
		return null;
	}

  public static boolean isConversionCompleted() {
    return co.cyberz.fox.Fox.isConversionCompleted();
  }

}