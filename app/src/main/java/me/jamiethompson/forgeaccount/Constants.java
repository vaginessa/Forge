package me.jamiethompson.forgeaccount;

/**
 * Created by jamie on 27/09/17.
 */

public class Constants
{
	final public static String ERROR_LOG = "error";
	final public static String BASE_URL = "http://api.guerrillamail.com/ajax.php";

	final public static String GET_EMAILS = "check_email";
	final public static String GET_ADDRESS = "get_email_address";
	final public static String SET_EMAIL = "set_email_user";

	final public static int REQUEST_EMAILS = 0;
	final public static int REQUEST_ADDRESS = 1;
	final public static int REQUEST_SET_EMAIL = 2;

	final public static String ADDRESS_JSON_KEY = "email_addr";
	final public static String SID_JSON_KEY = "sid_token";
	final public static String EMAILS_JSON_KEY = "list";
	final public static String SUBJECT_JSON_KEY = "mail_subject";
	final public static String BODY_JSON_KEY = "mail_excerpt";
	final public static String FROM_JSON_KEY = "mail_from";
	final public static String TIME_JSON_KEY = "mail_timestamp";

	final public static String SID_PARAMETER_KEY = "sid_token";
	final public static String SEQUENCE_PARAMETER_KEY = "seq";
	final public static String EMAIL_USER_PARAMETER_KEY = "email_user";

	final public static String FIRSTNAME = "firstname";
	final public static String MIDDLENAME = "middlename";
	final public static String LASTNAME = "lastname";
	final public static String USERNAME = "username";
	final public static String EMAIL = "email";
	final public static String PASSWORD = "password";
	final public static String DATE = "date";

	final public static int GENERATE_TAB = 0;
	final public static int STORE_TAB = 1;
}