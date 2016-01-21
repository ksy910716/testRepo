package com.example.ksy.t_20160120;

/**
 * Created by PrographerJ on 2015-07-10.
 * 상수를 정의 한다.
 */
public class Constants {

    // Log Class에 인자로 넘겨줄 Tag 정의
    public static final String LOG_TAG = "untv";

    public static final String HOST = "http://api.videoceans.com";
    public static final String AD_HOST = "http://ad.videoceans.com";
    //public static final String HOST = "http://192.168.0.2:8080";
    //public static final String AD_HOST = "http://192.168.0.2:8080";

    /**
     * 영상 메인광고 인벤토리 아이디
     */
    public static final long INVENTORY_IO_VIDEO_MAIN = 4;

    //public static final String PREFERENCE_KEY = "UndergroundTV";
    //public static final String PREFERENCE_KEY_USER = "User";
    //public static final String PREFERENCE_KEY_USER_EMAIL = "UserEmail";
    //public static final String PREFERENCE_KEY_TOKEN = "Token";
    public static final String PREFERENCE_KEY_IS_USER_UPDATE = "UserUpdate";
    public static final String PREFERENCE_KEY_IS_USER_LOGIN = "UserLogin";

    //2주 시간을 체크 하기 위한 변수
    public static final String PREFERENCE_KEY_NO_LOGIN_TIME = "UserNoLoginTime";

    public static final String VIDEO_COUNT_TYPE_PLAY = "P";
    public static final String VIDEO_COUNT_TYPE_SHARE = "S";
    public static final String VIDEO_COUNT_TYPE_LIKE = "L";

    public static final int VIDEO_TYPE_UPLOAD = 0;
    public static final int VIDEO_TYPE_YOUTUBE = 1;

    //Video Info와 관련된 ID
    public final static int VIDEO_INFO_TOC_ID = 0;
    public final static int VIDEO_INFO_MUSIC_ID = 1;
    public final static int VIDEO_INFO_LOCATION_ID = 2;
    public final static int VIDEO_INFO_PRODUCT_ID = 3;

    public static int REQUEST_FOR_ACTIVITY_VIDEO_DETAIL = 100;

    public static final String DEVELOPER_KEY = "AIzaSyCyLSkYsh-mhuYKvGtLyPjMaT6bh2cBhPY";

    public static final int RECOMMAND_USER_REWARD = 500;
}
