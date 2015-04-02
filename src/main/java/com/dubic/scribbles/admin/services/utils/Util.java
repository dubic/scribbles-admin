/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dubic.scribbles.admin.services.utils;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.awt.image.RenderedImage;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;
import javax.validation.ConstraintViolation;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.util.StringUtils;

/**
 * performs all idm utilities
 *
 * @author dubic
 * @since idm 1.0.0
 */
public class Util {

    private static int ap = 0;

    public static String encodeMD5(String data, String salt)
            throws NullPointerException {
        if (data == null) {
            throw new NullPointerException("data to encode cannot be null");
        }
        return DigestUtils.md5Hex(salt + "elect:.dashboard" + data);
    }

    public static void tokenize(String pathInfo, String delim) {
        StringTokenizer t = new StringTokenizer(pathInfo, delim);
        while (t.hasMoreElements()) {
            System.out.println("token - " + t.nextToken());

        }

    }

    public static Date getActivationTokenExpiryDt() {
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DAY_OF_MONTH, 1);
        return cal.getTime();
    }
    public static Date getMdnValTokenExpiryDt() {
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.MINUTE, 15);
        return cal.getTime();
    }

    public static String generateTimeToken() {
        char[] time = String.valueOf(System.currentTimeMillis()).toCharArray();
        List<char[]> charrList = new ArrayList<char[]>();
        charrList.add(new char[]{'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J'});
        charrList.add(new char[]{'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T'});
        charrList.add(new char[]{'U', 'V', 'W', 'X', 'Y', 'Z', '0', '1', '2', '3'});
        charrList.add(new char[]{'4', '5', '6', '7', '8', '9'});

        StringBuffer tokenBuf = new StringBuffer();
        for (int i = 0; i < time.length; i++) {
            ap = ap >= charrList.size() ? 0 : ap;
            int chPos = Character.digit(time[i], Character.MAX_RADIX);
            if (chPos >= charrList.get(ap).length) {
                tokenBuf.append(chPos);
            } else {
                tokenBuf.append(charrList.get(ap)[chPos]);
            }
            ap++;
        }
        return tokenBuf.toString();
    }

    public static Date getPwordResetTokenExpiryDt() {
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.MINUTE, 15);
        return cal.getTime();
    }

    /**
     * creates a string of ; separated violation messages for easy viewing
     *
     * @param constraintViolations
     * @return
     */
    public static String printValidationMsg(Set<ConstraintViolation<?>> constraintViolations) {
        StringBuffer buf = new StringBuffer();
        for (ConstraintViolation<?> violation : constraintViolations) {
            buf.append(violation.getMessage()).append(";");
        }
        return buf.toString();
    }

    public static RenderedImage resizeImage(int width, int height, BufferedImage image) {
       Image scaledImage = image.getScaledInstance(width, height, Image.SCALE_DEFAULT);
       int w = scaledImage.getWidth(null);
        int h = scaledImage.getHeight(null);
        int type = BufferedImage.TYPE_INT_RGB;  // other options
        BufferedImage dest = new BufferedImage(w, h, type);
        Graphics2D g2 = dest.createGraphics();
        g2.drawImage(scaledImage, 0, 0, null);
        g2.dispose();
        return dest;
    }

    public static String toSQLDate(String value) {
        Date date = parseDate(value);
        if (date == null) {
            return null;
        }
        try {
            return new SimpleDateFormat("yyyy-MM-dd").format(date);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    
    }

    
//    public static Validator validator = Validation.buildDefaultValidatorFactory().getValidator();

    /**
     * return the first value of the list or null if list is empty
     *
     * @param list
     * @return
     */
    public static <T> T getFirstOrNull(List<T> list) {
        if (!list.isEmpty()) {
            return list.get(0);
        }
        return null;
    }

    /**
     * tests if String is null or filled with spaces.
     *
     * @param str test string
     * @return true if string is empty
     */
    public static boolean isEmpty(String str) {
        return (str == null) || (str.trim().length() <= 0);
    }

    public static String formatMoney(double amt) {
        return new DecimalFormat("###,###,###,###.##").format(amt);
    }
    
    public static String formatNumber(Integer n) {
        return new DecimalFormat("###,###,###,###").format(n);
    }

    public static String getUserEmailLoggedIn() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        Object principal = null;
        try {
            principal = auth.getPrincipal();
        } catch (NullPointerException e) {
            return null;
        }
        if (principal == null) {
            return null;
        }
        return (String) principal;
    }

    public static String formatDate(Date date) {
        if (date == null) {
            return null;
        }
        try {
            return new SimpleDateFormat("dd-MMM-yyyy hh:mm:ss a").format(date);
        } catch (Exception e) {
//            log.warn("ERROR FORMATING DATE - " + e.getMessage());
        }
        return null;
    }

    public static Date parseDate(String date) {
        if (isEmpty(date)) {
            return null;
        }
        try {
            return new SimpleDateFormat("dd-MM-yyyy").parse(date);
        } catch (ParseException ex) {

        }
        return null;
    }
    
    public static String sqlArray(String[] arry){
        String[] salArray = new String[arry.length];
        for (int i = 0; i < arry.length; i++) {
            salArray[i] = "'"+arry[i]+"'";
        }
        return StringUtils.arrayToDelimitedString(salArray, ",");
    }
    public static int currentMonth(){
        return Calendar.getInstance().get(Calendar.MONTH);
    }

    public static String convertPostedTime(Long postedTime) {
        long now = new Date().getTime();
        long postedTimeDiff = now - postedTime;
        long secs = postedTimeDiff / 1000;
        int mins = (int) (secs / 60);
        int hrs = mins / 60;
        int days = hrs / 24;
        int years = days / 365;
        StringBuilder sb = new StringBuilder();
        if (days > 0 && years > 0) {
            sb.append("about ").append(years).append(" year(s), ").append(days).append(" day(s) ago");
            return sb.toString();
        }
        if (years > 0) {
            sb.append("about ").append(years).append(" year(s) ago");
            return sb.toString();
        }
        if (days > 0) {
            sb.append("about ").append(days).append(" day(s) ago");
            return sb.toString();
        }
        if (hrs > 0) {
            sb.append("about ").append(hrs).append(" hour(s) ago");
            return sb.toString();
        }
        if (mins > 0) {
            sb.append("about ").append(mins).append(" minute(s) ago");
            return sb.toString();
        }
        sb.append("just now");
        return sb.toString();
    }

    public static void main(String[] arrrgh) {
        System.out.println("month : "+currentMonth());
//        try {
//            System.out.println("token - " + generateTimeToken());
//            Thread.sleep(1000);
//            System.out.println("token - " + generateTimeToken());
//            Thread.sleep(1000);
//            System.out.println("token - " + generateTimeToken());
//            Thread.sleep(1000);
//            System.out.println("token - " + generateTimeToken());
//        } catch (InterruptedException ex) {
//            java.util.logging.Logger.getLogger(IdmUtils.class.getName()).log(Level.SEVERE, null, ex);
//        }
    }

    public static int indexOf(Object[] array, String test) {
        for (int i = 0;i < array.length;i++) {
            if (array[i].equals(test)) {
                return i;
            }
        }
        return -1;
    }
}
