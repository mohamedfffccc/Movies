package com.example.moviesflix2.data.helper;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.moviesflix2.view.activity.HomePage;
import com.example.moviesflix2.view.dialog.LoadingDialoge;

public class HelperMethod {
    public static LoadingDialoge dialoge;

    private static ProgressDialog checkDialog;
    public static AlertDialog alertDialog;

    public static void replace(Fragment fragment, FragmentManager supportFragmentManager, int id, TextView Tool_Bar_Title, String title) {

        FragmentTransaction transaction = supportFragmentManager.beginTransaction();
        transaction.replace(id, fragment);
        transaction.addToBackStack(null);
        // Commit the transaction
        transaction.commit();
        if (Tool_Bar_Title != null) {
            Tool_Bar_Title.setText(title);
        }
    }

//    public static void showCalender(Context context, String title, final TextView text_view_data, final DateTxt data1) {
//        DatePickerDialog mDatePicker = new DatePickerDialog(context, AlertDialog.THEME_HOLO_DARK, new DatePickerDialog.OnDateSetListener() {
//            public void onDateSet(DatePicker datepicker, int selectedYear, int selectedMonth, int selectedDay) {
//                DecimalFormatSymbols symbols = new DecimalFormatSymbols(Locale.US);
//                DecimalFormat mFormat = new DecimalFormat("00", symbols);
//                String data = selectedYear + "-" + mFormat.format(Double.valueOf((selectedMonth + 1))) + "-" + mFormat.format(Double.valueOf(selectedDay));
//                data1.setDate_txt(data);
//                data1.setDay(mFormat.format(Double.valueOf(selectedDay)));
//                data1.setMonth(mFormat.format(Double.valueOf(selectedMonth + 1)));
//                data1.setYear(String.valueOf(selectedYear));
//                text_view_data.setText(data);
//            }
//        }, Integer.parseInt(data1.getYear()), Integer.parseInt(data1.getMonth()) - 1, Integer.parseInt(data1.getDay()));
//        mDatePicker.setTitle(title);
//        mDatePicker.show();
//    }

    public static void disappearKeypad(Activity activity, View v) {
        try {
            if (v != null) {
                InputMethodManager imm = (InputMethodManager) activity.getSystemService(Context.INPUT_METHOD_SERVICE);
                imm.hideSoftInputFromWindow(v.getWindowToken(), 0);
            }
        } catch (Exception e) {
        }
    }

    public static void showProgressDialog(HomePage activity, String title) {
        FragmentManager manager = activity.getSupportFragmentManager();
       dialoge = new LoadingDialoge();

        dialoge.show(manager,";;;");

          }


    public static void dismissProgressDialog() {
        try {
            dialoge.dismiss();

        } catch (Exception e) {

        }
    }
//    public static void dismissProgressBar(ProgressBar progressBar) {
//        try {
//​
//            progressBar.setVisibility(View.GONE);
//​
//        } catch (Exception e) {
//​
//        }
//    }
}

/**
 * package com.example.bloodbank.helper;
 * public class HelperMethod {
 * private static ProgressDialog checkDialog;
 * public static AlertDialog alertDialog;
 * ​
 * public static void replaceFragment(FragmentManager fragmentManager, int id, Fragment fragment) {
 * FragmentTransaction transaction = fragmentManager.beginTransaction();
 * transaction.replace(id, fragment);
 * transaction.addToBackStack(null);
 * transaction.commit();
 * }
 * ​
 * public static void showCalender(Context context, String title, final TextView text_view_data, final DateTxt data1) {
 * DatePickerDialog mDatePicker = new DatePickerDialog(context, AlertDialog.THEME_HOLO_DARK, new DatePickerDialog.OnDateSetListener() {
 * public void onDateSet(DatePicker datepicker, int selectedYear, int selectedMonth, int selectedDay) {
 * DecimalFormatSymbols symbols = new DecimalFormatSymbols(Locale.US);
 * DecimalFormat mFormat = new DecimalFormat("00", symbols);
 * String data = selectedYear + "-" + mFormat.format(Double.valueOf((selectedMonth + 1))) + "-" + mFormat.format(Double.valueOf(selectedDay));
 * data1.setDate_txt(data);
 * data1.setDay(mFormat.format(Double.valueOf(selectedDay)));
 * data1.setMonth(mFormat.format(Double.valueOf(selectedMonth + 1)));
 * data1.setYear(String.valueOf(selectedYear));
 * text_view_data.setText(data);
 * }
 * }, Integer.parseInt(data1.getYear()), Integer.parseInt(data1.getMonth()) - 1, Integer.parseInt(data1.getDay()));
 * mDatePicker.setTitle(title);
 * mDatePicker.show();
 * }
 * ​
 * public static Date convertDateString(String date) {
 * try {
 * SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
 * ​
 * Date parse = format.parse(date);
 * ​
 * return parse;
 * ​
 * } catch (ParseException e) {
 * e.printStackTrace();
 * return null;
 * }
 * }
 * ​
 * public static DateTxt convertStringToDateTxtModel(String date) {
 * try {
 * Date date1 = convertDateString(date);
 * String day = (String) DateFormat.format("dd", date1); // 20
 * String monthNumber = (String) DateFormat.format("MM", date1); // 06
 * String year = (String) DateFormat.format("yyyy", date1); // 2013
 * ​
 * return new DateTxt(day, monthNumber, year, date);
 * ​
 * } catch (Exception e) {
 * return null;
 * }
 * }
 * //
 * //    public static void onLoadImageFromUrl(ImageView imageView, String URl, Context context) {
 * //        Glide.with(context)
 * //                .load(URl)
 * //                .into(imageView);
 * //    }
 * ​
 * public static void showProgressDialog(Activity activity, String title) {
 * try {
 * ​
 * checkDialog = new ProgressDialog(activity);
 * checkDialog.setMessage(title);
 * checkDialog.setIndeterminate(false);
 * checkDialog.setCancelable(false);
 * ​
 * checkDialog.show();
 * ​
 * } catch (Exception e) {
 * ​
 * }
 * }
 * ​
 * public static void dismissProgressDialog() {
 * try {
 * ​
 * checkDialog.dismiss();
 * ​
 * } catch (Exception e) {
 * ​
 * }
 * }
 * ​
 * public static void disappearKeypad(Activity activity, View v) {
 * try {
 * if (v != null) {
 * InputMethodManager imm = (InputMethodManager) activity.getSystemService(Context.INPUT_METHOD_SERVICE);
 * imm.hideSoftInputFromWindow(v.getWindowToken(), 0);
 * }
 * } catch (Exception e) {
 * ​
 * }
 * }
 * ​
 * public static void changeLang(Context context, String lang) {
 * Resources res = context.getResources();
 * // Change locale settings in the app.
 * DisplayMetrics dm = res.getDisplayMetrics();
 * android.content.res.Configuration conf = res.getConfiguration();
 * conf.setLocale(new Locale(lang)); // API 17+ only.
 * // Use conf.locale = new Locale(...) if targeting lower versions
 * res.updateConfiguration(conf, dm);
 * }
 * ​
 * public static void htmlReader(TextView textView, String s) {
 * if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
 * textView.setText(Html.fromHtml(s, Html.FROM_HTML_MODE_COMPACT));
 * } else {
 * textView.setText(Html.fromHtml(s));
 * }
 * }
 * ​
 * public static void onPermission(Activity activity) {
 * String[] perms = {
 * Manifest.permission.ACCESS_FINE_LOCATION,
 * Manifest.permission.READ_CONTACTS,
 * Manifest.permission.READ_EXTERNAL_STORAGE,
 * Manifest.permission.WRITE_EXTERNAL_STORAGE,
 * Manifest.permission.READ_PHONE_STATE,
 * Manifest.permission.CALL_PHONE};
 * ​
 * ActivityCompat.requestPermissions(activity,
 * perms,
 * 100);
 * ​
 * }
 * ​
 * }
 */