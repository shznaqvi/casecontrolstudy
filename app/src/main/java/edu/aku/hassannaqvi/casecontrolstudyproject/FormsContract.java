package edu.aku.hassannaqvi.casecontrolstudyproject;

import android.database.Cursor;
import android.provider.BaseColumns;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by hassan.naqvi on 11/30/2016.
 */

public class FormsContract {

    private final String projectName = "Case Control Study";
    //private final String surveyType = "SN";
    private String _ID = "";
    private String UID = "";
    private String formDate = ""; // Date
    private String interviewer = ""; // Interviewer
    private String areacode = "0000"; // Area Code
    private String subareacode = ""; // Cluster
    private String household = ""; // Household number
    private String istatus = ""; // Interview Status
    //private String sA = "";
    private String sB = "";
    private String sC = "";
    private String sD = "";
    private String sIC = "";

    private String gpsLat = "";
    private String gpsLng = "";
    private String gpsTime = "";
    private String gpsAcc = "";
    private String deviceID = "";
    private String synced = "";
    private String synced_date = "";

    public FormsContract() {
    }

    public String getProjectName() {
        return projectName;
    }

    public String get_ID() {
        return _ID;
    }

    public void set_ID(String _ID) {
        this._ID = _ID;
    }

    public String getUID() {
        return UID;
    }

    public void setUID(String UID) {
        this.UID = UID;
    }

    public String getFormDate() {
        return formDate;
    }

    public void setFormDate(String formDate) {
        this.formDate = formDate;
    }

    public String getInterviewer() {
        return interviewer;
    }

    public void setInterviewer(String interviewer) {
        this.interviewer = interviewer;
    }

    public String getAreacode() {
        return areacode;
    }

    public void setAreacode(String areacode) {
        this.areacode = areacode;
    }

    public String getSubareacode() {
        return subareacode;
    }

    public void setSubareacode(String subareacode) {
        this.subareacode = subareacode;
    }

    public String getHousehold() {
        return household;
    }

    public void setHousehold(String household) {
        this.household = household;
    }

    public String getIstatus() {
        return istatus;
    }

    public void setIstatus(String istatus) {
        this.istatus = istatus;
    }

    public String getsB() {
        return sB;
    }

    public void setsB(String sB) {
        this.sB = sB;
    }

    public String getsC() {
        return sC;
    }

    public void setsC(String sC) {
        this.sC = sC;
    }

    public String getsD() {
        return sD;
    }

    public void setsD(String sD) {
        this.sD = sD;
    }

    public String getsIC() {
        return sIC;
    }

    public void setsIC(String sIC) {
        this.sIC = sIC;
    }

    public String getGpsLat() {
        return gpsLat;
    }

    public void setGpsLat(String gpsLat) {
        this.gpsLat = gpsLat;
    }

    public String getGpsLng() {
        return gpsLng;
    }

    public void setGpsLng(String gpsLng) {
        this.gpsLng = gpsLng;
    }

    public String getGpsTime() {
        return gpsTime;
    }

    public void setGpsTime(String gpsTime) {
        this.gpsTime = gpsTime;
    }

    public String getGpsAcc() {
        return gpsAcc;
    }

    public void setGpsAcc(String gpsAcc) {
        this.gpsAcc = gpsAcc;
    }

    public String getDeviceID() {
        return deviceID;
    }

    public void setDeviceID(String deviceID) {
        this.deviceID = deviceID;
    }

    public String getSynced() {
        return synced;
    }

    public void setSynced(String synced) {
        this.synced = synced;
    }

    public String getSynced_date() {
        return synced_date;
    }

    public void setSynced_date(String synced_date) {
        this.synced_date = synced_date;
    }

    public FormsContract Sync(JSONObject jsonObject) throws JSONException {
        this._ID = jsonObject.getString("id");
        this.UID = jsonObject.getString("uid");
        this.formDate = jsonObject.getString("fromDate");
        this.interviewer = jsonObject.getString("interviewer");
        this.areacode = jsonObject.getString("areacode");
        this.subareacode = jsonObject.getString("subareacode");
        this.household = jsonObject.getString("household");
        this.istatus = jsonObject.getString("istatus");
        //this.sA = jsonObject.getString("sA");
        this.sB = jsonObject.getString("sB");
        this.sC = jsonObject.getString("sC");
        this.sD = jsonObject.getString("sD");
        this.sIC = jsonObject.getString("sIC");
        this.gpsLat = jsonObject.getString("gpsLat");
        this.gpsLng = jsonObject.getString("gpsLng");
        this.gpsTime = jsonObject.getString("gpsTime");
        this.gpsAcc = jsonObject.getString("gpsAcc");
        this.deviceID = jsonObject.getString("deviceID");
        this.synced = jsonObject.getString("synced");
        this.synced_date = jsonObject.getString("synced_date");
        return this;

    }

    public FormsContract Hydrate(Cursor cursor) {
        this._ID = cursor.getString(cursor.getColumnIndex(singleForm._ID));
        this.UID = cursor.getString(cursor.getColumnIndex(singleForm.COLUMN_NAME_UID));
        this.formDate = cursor.getString(cursor.getColumnIndex(singleForm.COLUMN_NAME_FORM_DATE));
        this.areacode = cursor.getString(cursor.getColumnIndex(singleForm.COLUMN_NAME_AREA_CODE));
        this.subareacode = cursor.getString(cursor.getColumnIndex(singleForm.COLUMN_NAME_SUBAREA_CODE));
        this.household = cursor.getString(cursor.getColumnIndex(singleForm.COLUMN_NAME_HOUSEHOLD));
        this.istatus = cursor.getString(cursor.getColumnIndex(singleForm.COLUMN_NAME_ISTATUS));
        //this.sA = cursor.getString(cursor.getColumnIndex(singleForm.COLUMN_NAME_SA));
        this.sB = cursor.getString(cursor.getColumnIndex(singleForm.COLUMN_NAME_SB));
        this.sC = cursor.getString(cursor.getColumnIndex(singleForm.COLUMN_NAME_SC));
        this.sD = cursor.getString(cursor.getColumnIndex(singleForm.COLUMN_NAME_SD));
        this.sIC = cursor.getString(cursor.getColumnIndex(singleForm.COLUMN_NAME_SIC));
        this.gpsLat = cursor.getString(cursor.getColumnIndex(singleForm.COLUMN_NAME_GPS_LAT));
        this.gpsLng = cursor.getString(cursor.getColumnIndex(singleForm.COLUMN_NAME_GPS_LNG));
        this.gpsTime = cursor.getString(cursor.getColumnIndex(singleForm.COLUMN_NAME_GPS_TIME));
        this.gpsAcc = cursor.getString(cursor.getColumnIndex(singleForm.COLUMN_NAME_GPS_ACC));
        this.deviceID = cursor.getString(cursor.getColumnIndex(singleForm.COLUMN_NAME_DEVICE_ID));
        this.synced = cursor.getString(cursor.getColumnIndex(singleForm.COLUMN_NAME_SYNCED));
        this.synced_date = cursor.getString(cursor.getColumnIndex(singleForm.COLUMN_NAME_SYNCED_DATE));
        return this;

    }


    public JSONObject toJSONObject() throws JSONException {

        JSONObject json = new JSONObject();

        json.put(singleForm._ID, this._ID == null ? JSONObject.NULL : this._ID);
        json.put(singleForm.COLUMN_NAME_UID, this.UID == null ? JSONObject.NULL : this.UID);
        json.put(singleForm.COLUMN_NAME_PROJECT_NAME, this.projectName == null ? JSONObject.NULL : this.projectName);
        //json.put(singleForm.COLUMN_NAME_SURVEY_TYPE, this.surveyType == null?JSONObject.NULL:this.surveyType);
        json.put(singleForm.COLUMN_NAME_DEVICE_ID, this.deviceID == null ? JSONObject.NULL : this.deviceID);
        json.put(singleForm.COLUMN_NAME_GPS_LAT, this.gpsLat == null ? JSONObject.NULL : this.gpsLat);
        json.put(singleForm.COLUMN_NAME_GPS_LNG, this.gpsLng == null ? JSONObject.NULL : this.gpsLng);
        json.put(singleForm.COLUMN_NAME_GPS_TIME, this.gpsTime == null ? JSONObject.NULL : this.gpsTime);
        json.put(singleForm.COLUMN_NAME_GPS_ACC, this.gpsAcc == null ? JSONObject.NULL : this.gpsAcc);
        json.put(singleForm.COLUMN_NAME_SYNCED, this.synced == null ? JSONObject.NULL : this.synced);
        json.put(singleForm.COLUMN_NAME_SYNCED_DATE, this.synced_date == null ? JSONObject.NULL : this.synced_date);
        json.put(singleForm.COLUMN_NAME_FORM_DATE, this.formDate == null ? JSONObject.NULL : this.formDate);
        json.put(singleForm.COLUMN_NAME_FORM_DATE, this.interviewer == null ? JSONObject.NULL : this.interviewer);
        json.put(singleForm.COLUMN_NAME_AREA_CODE, this.areacode == null ? JSONObject.NULL : this.areacode);
        json.put(singleForm.COLUMN_NAME_AREA_CODE, this.subareacode == null ? JSONObject.NULL : this.subareacode);
        json.put(singleForm.COLUMN_NAME_HOUSEHOLD, this.household == null ? JSONObject.NULL : this.household);
        json.put(singleForm.COLUMN_NAME_ISTATUS, this.istatus == null ? JSONObject.NULL : this.istatus);

        //json.put(singleForm.COLUMN_NAME_SA, this.sA == null?JSONObject.NULL:this.sA);
        json.put(singleForm.COLUMN_NAME_SB, this.sB == null ? JSONObject.NULL : this.sB);
        json.put(singleForm.COLUMN_NAME_SB, this.sB == null ? JSONObject.NULL : this.sB);
        json.put(singleForm.COLUMN_NAME_SC, this.sC == null ? JSONObject.NULL : this.sC);
        json.put(singleForm.COLUMN_NAME_SD, this.sD == null ? JSONObject.NULL : this.sD);
        json.put(singleForm.COLUMN_NAME_SIC, this.sIC == null ? JSONObject.NULL : this.sIC);

        return json;
    }

    public static abstract class singleForm implements BaseColumns {

        public static final String TABLE_NAME = "forms";
        public static final String COLUMN_NAME_NULLABLE = "NULLHACK";
        public static final String _ID = "_id";
        public static final String COLUMN_NAME_UID = "uid";
        public static final String COLUMN_NAME_PROJECT_NAME = "projectname";
        //public static final String COLUMN_NAME_SURVEY_TYPE = "surveytype";
        public static final String COLUMN_NAME_DEVICE_ID = "deviceid";
        public static final String COLUMN_NAME_GPS_LAT = "gpslat";
        public static final String COLUMN_NAME_GPS_LNG = "gpslng";
        public static final String COLUMN_NAME_GPS_ACC = "gpsacc";
        public static final String COLUMN_NAME_GPS_TIME = "gpstime";
        public static final String COLUMN_NAME_SYNCED = "sync";
        public static final String COLUMN_NAME_SYNCED_DATE = "sync_date";
        public static final String COLUMN_NAME_FORM_DATE = "fromdate";
        public static final String COLUMN_NAME_INTERVIEWER = "interviewer";
        public static final String COLUMN_NAME_AREA_CODE = "areacode";
        public static final String COLUMN_NAME_SUBAREA_CODE = "subarea";
        public static final String COLUMN_NAME_HOUSEHOLD = "household";
        public static final String COLUMN_NAME_ISTATUS = "istatus";
        //public static final String COLUMN_NAME_SA = "sa";
        public static final String COLUMN_NAME_SB = "sb";
        public static final String COLUMN_NAME_SC = "sc";
        public static final String COLUMN_NAME_SD = "sd";
        public static final String COLUMN_NAME_SIC = "sic";

    }
}
