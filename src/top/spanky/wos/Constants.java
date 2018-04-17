package top.spanky.wos;

public class Constants {

    //This section are default value for pagination
    public final static int DEFAULT_PAGE_SIZE = 10;
    public final static int MAX_PAGE_SIZE = 10;

    //This is default time value about cookie
    public final static int DEFAUTL_COOKIE_TIME = 2592000;

    //This is for AppContext
    public final static String APP_CONTEXT_REQUEST = "APP_CONTEXT_REQUEST";
    public final static String APP_CONTEXT_RESPONSE = "APP_CONTEXT_RESPONSE";
    public final static String APP_CONTEXT_THREAD_CONNCETION = "APP_CONTEXT_THREAD_CONNCETION";
    public static final String APP_CONTEXT_USER = "APP_CONTEXT_USER";
    public static final String APP_CONTEXT_SESSION = "APP_CONTEXT_SESSION";

    //path
    public static final String APP_URL_PREFIX = "page";

    // response
    public static final int RESPONSE_SUCCESS_VALUE = 200;
    public static final int RESPONSE_FAIL_VALUE = 400;
    public static final int RESPONSE_EXCEPTION_VALUE = 500;
    public static final int RESPONSE_REJECT_VALUE = 403;
    public static final String RESPONSE_SUCCESS_MESSAGE = "success";
    public static final String RESPONSE_FAIL_MESSAGE = "fail";
    public static final String RESPONSE_EXCEPTION_MESSAGE = "exception";
    public static final String RESPONSE_REJECT_MESSAGE = "reject";

    public static final int ORDER_CLOSED = 1;
    public static final int ORDER_PAYED = 0;
    public static final int ORDER_CONFIRMED = 2;
    public static final int ORDER_DELIVEYING = 3;
    public static final int ORDER_DELIVEYED = 4;
    public static final int ORDER_FINISHED = 5;
    public static final int ORDER_USER_RATED = 6;

    // Discount
    // 通用1 满减2 打折3 免运4 随机立减5
    public static final int DISCOUNT_COMMON = 1;
    public static final int DISCOUNT_CONDITION = 2;
    public static final int DISCOUNT_TAKEOFF = 3;
    public static final int DISCOUNT_DELIVERY_FREE = 4;
    public static final int DISCOUNT_RANDOM = 5;

    // admins
    public static final String[] ADMIN_OPENIDS = { "oh56I1vlzWwbJ4SeS4STPyqbPAns", "testopenId" };
}
